package Persistencia;

import Entidad.Autor;
import Entidad.Libro;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class LibroDao {

    private final EntityManager em = Persistence.createEntityManagerFactory("PersistenciaL").createEntityManager();

    public void Insertar(Libro libro) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Error al cargar el libro");
        }
    }

    public List<Libro> obtenerTodos() throws Exception{
        try {
            List<Libro> libros = em.createQuery("SELECT a FROM Libro a", Libro.class).getResultList();
            return libros;

        } catch (Exception e) {
            throw new Exception("Error al obtener todos los libros");
        }
    }

    public Libro obtenerPorIsbn(Long isbn) throws Exception {
        try {
            Libro libro = em.find(Libro.class, isbn);
            return libro;
        } catch (Exception e) {
            throw new Exception("Error al obtener el libro por isbn");
        }
    }

    public Libro obtenerPorTitulo(String titulo) throws Exception {
        try {
            Libro libro = em.find(Libro.class, titulo);
            return libro;
        } catch (Exception e) {
            throw new Exception("Error al obtener el libro por el titulo");
        }
    }
    public void eliminarPorLibro(Libro libro) throws Exception {
        try {
            em.getTransaction().begin();
            em.remove(libro);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Error al eliminar todos los libros");
        }
    }

    public void actualizar(Libro libro) throws Exception {

        try {

            em.getTransaction().begin();
            em.merge(libro);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Error al actualizar libro");
        }
    }





}
