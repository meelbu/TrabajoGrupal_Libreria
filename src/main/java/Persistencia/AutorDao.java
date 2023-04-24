package Persistencia;

import Entidad.Autor;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class AutorDao {

    private final EntityManager em = Persistence
            .createEntityManagerFactory("PersistenciaL")
            .createEntityManager();

    public void Insertar(Autor autor) throws Exception{
        try {
            em.getTransaction().begin();
            em.persist(autor);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            throw new Exception("Error al cargar el autor");
        }
    }

}
