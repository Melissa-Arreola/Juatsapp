
package DAOrepository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 */
public class Usuario extends BaseRepository<Usuario> {

    @Override
    public boolean guardar(Usuario usuario) {
        EntityManager entityManager= this.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(usuario);
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public boolean actualizar(Usuario usuarioActualizado) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Usuario usuario = entityManager.find(Usuario.class,usuarioActualizado.getIdusuario());
        if(usuario!=null){
           usuario.setCorreoElectronico(usuarioActualizado.getCorreoElectronico());
           usuario.setFechanacimiento(usuarioActualizado.getFechanacimiento());
           usuario.setSexo(usuarioActualizado.getSexo());
           usuario.setNombreUsuario(usuarioActualizado.getNombreUsuario());
           usuario.setContrasenia(usuarioActualizado.getContrasenia());
           usuario.setRel_chatusuario(usuarioActualizado.getRel_chatusuario());
           entityManager.merge(usuario);
           entityManager.getTransaction().commit();
            return true;
        }
        entityManager.getTransaction().commit();    
        return false;
    }

    @Override
    public Usuario buscarporID(long id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.getTransaction().commit();
        return usuario;
    }

    @Override
    public ArrayList<Usuario> buscarTodas() {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Usuario.class));
        Query query = entityManager.createQuery(criteria);
        List<Usuario> usuarios = query.getResultList();
        entityManager.getTransaction().commit();
        return new ArrayList<>(usuarios);
    }
    
    @Override
    public List<Usuario> buscarComo(String busqueda){
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        String sql;
        if (!busqueda.isEmpty()) {
            if (busqueda.matches("^[0-9]*$")) {
                sql = "SELECT p FROM Usuario p WHERE p.idusuario=" + busqueda + "";
            } else {
                sql = "SELECT p FROM Usuario p WHERE p.nombreUsuario LIKE '" + busqueda + "%'";
            }
        } else {
            sql = "SELECT p FROM Usuario p WHERE p.nombreUsuario LIKE '" + busqueda + "%'";
        }
        Query query1 = entityManager.createQuery(sql);
        List<Usuario> list1 = (List<Usuario>) query1.getResultList();
        return  list1;
    }
}
