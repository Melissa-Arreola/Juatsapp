
package DAOrepository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import objetosNegocio.Mensaje;


/**
 */
public class Mensajes extends BaseRepository<Mensaje>{

    @Override
    public boolean guardar(Mensaje mensaje) {
        EntityManager entityManager= this.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(mensaje);
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public boolean actualizar(Mensaje mensajeActualizado) {
        return true;
    }

    @Override
    public Mensaje buscarporID(long id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Mensaje mensaje = entityManager.find(Mensaje.class, id);
        entityManager.getTransaction().commit();
        return mensaje;
    }

    @Override
    public ArrayList<Mensaje> buscarTodas() {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Mensaje.class));
        Query query = entityManager.createQuery(criteria);
        List<Mensaje> mensajes = query.getResultList();
        entityManager.getTransaction().commit();
        return new ArrayList<>(mensajes);
    }

    @Override
    public List<Mensaje> buscarComo(String busqueda) {
       EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        String sql;
        if (!busqueda.isEmpty()) {
            if (busqueda.matches("^[0-9]*$")) {
                sql = "SELECT p FROM Mensaje p WHERE p.idmensaje=" + busqueda + "";
            } else {
                sql = "SELECT p FROM Mensaje p WHERE p.mensaje LIKE '" + busqueda + "%'";
            }
        } else {
            sql = "SELECT p FROM Mensaje p WHERE p.mensaje LIKE '" + busqueda + "%'";
        }
        Query query1 = entityManager.createQuery(sql);
        ArrayList<Mensaje> list1 = (ArrayList<Mensaje>) query1.getResultList();
        return  list1;
    }
    
}
