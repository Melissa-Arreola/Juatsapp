
package DAOrepository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 */
public abstract class Base<T>  {
   
    public abstract boolean guardar(T entidad);
    public abstract boolean actualizar(T entidad);
    public abstract T buscarporID(long id);
    public abstract ArrayList<T> buscarTodas();
    public abstract List<T> buscarComo(String busqueda);
    public EntityManager createEntityManager(){
        EntityManagerFactory managerFactory= Persistence.createEntityManagerFactory("juatsapp");
        EntityManager entityManager= managerFactory.createEntityManager();
        return entityManager;
    }
    
}
