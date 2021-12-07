
package DAOrepository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;


/**
 *
 */
public class Chat extends BaseRepository<Chat>{

    
    @Override
    public boolean guardar(Chat chat) {
        EntityManager entityManager= this.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(chat);
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public boolean actualizar(Chat chatActualizado) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Chat chat = entityManager.find(Chat.class,chatActualizado.getIdchat());
        if (chat != null) {
            chat.setNombre(chatActualizado.getNombre());
            chat.setMensajes(chatActualizado.getMensajes());
            chat.setRel_chatusuario(chatActualizado.getRel_chatusuario());
            entityManager.merge(chat);
            entityManager.getTransaction().commit();
            return true;
        }
        entityManager.getTransaction().commit();
        return false;
    }

    @Override
    public Chat buscarporID(long id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Chat chat = entityManager.find(Chat.class, id);
        entityManager.getTransaction().commit();
        return chat;
    }

    @Override
    public ArrayList<Chat> buscarTodas() {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Chat.class));
        Query query = entityManager.createQuery(criteria);
        List<Chat> chats = query.getResultList();
        entityManager.getTransaction().commit();
        return new ArrayList<>(chats);
    }

    @Override
    public List<Chat> buscarComo(String busqueda) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        String sql;
        if (!busqueda.isEmpty()) {
            if (busqueda.matches("^[0-9]*$")) {
                sql = "SELECT p FROM Chat p WHERE p.idchat=" + busqueda + "";
            } else {
                sql = "SELECT p FROM Chat p WHERE p.nombre LIKE '" + busqueda + "%'";
            }
        } else {
            sql = "SELECT p FROM Chat p WHERE p.nombre LIKE '" + busqueda + "%'";
        }
        Query query1 = entityManager.createQuery(sql);
        ArrayList<Chat> list1 = (ArrayList<Chat>) query1.getResultList();
        return  list1;
    }    
}
