package Servicio;

import Entidad.Autor;
import Persistencia.AutorDao;

import java.util.List;
import java.util.Scanner;

public class AutorServicio {

    Scanner entrada = new Scanner(System.in);

    private AutorDao autorDao = new AutorDao();

    public void crearAutor() throws Exception{
        Autor autor = new Autor();
        try {
            System.out.println("Ingrese el nombre del autor");
            String nombre = entrada.next();
            autor.setNombreAutor(nombre);
            if (nombre==null || nombre.trim().isEmpty()){
                throw new Exception("Debe contener un nombre");
            }else {
                System.out.println("Se guardó exitosamente.");
            }
            autorDao.Insertar(autor);

        }catch (Exception e){
            throw e;
        }
    }

    public void mostrarAutorPorNombre() throws Exception {

        try {
            System.out.println("Ingrese el nombre del autor que desea buscar");
            String nombre = entrada.next();

            List<Autor> autores = autorDao.obtenerPorNombre(nombre);

            if (autores.isEmpty()) {
                throw new Exception("La lista de autores está vacía");
            } else {

                System.out.println("\n" + "Resultado: ");
                System.out.printf("%-10s%-20s\n", "Id", "Nombre");

                for (Autor autor1 : autores) {
                    System.out.printf("%-10s%-20s\n",autor1.getId(),
                            autor1.getNombreAutor());
                }
            }

        } catch (Exception e) {
            throw new Exception("No se encontro un autor con ese nombre");
        }

    }

    public void mostrarAutorPorId() throws Exception {

        try {
            System.out.println("Ingrese el Id del autor que desea buscar");
            Integer Id = entrada.nextInt();

            Autor autor = autorDao.obtenerPorId(Id);

            if (autor == null) {
                throw new Exception("La lista de autores esta vacia");
            } else {
                System.out.println("\n" + "Resultado: ");
                System.out.printf("%-15s%-40s\n", "Id", "Nombre");

                System.out.printf("%-15s%-40s\n", autor.getId(),
                        autor.getNombreAutor());
            }
        } catch (Exception e) {
            throw new Exception("No se encontro un autor con ese id");
        }
    }

    public void mostrarAutores() throws Exception {

        try {
            List<Autor> autores = autorDao.obtenerTodos();

            if (autores.isEmpty()) {
                throw new Exception("No existen autores registrados");

            } else {

                System.out.println("\n" + "Lista de Autores");
                System.out.printf("%-15s%-40s\n", "ID", "Nombre");

                for (Autor autor : autores) {
                    System.out.printf("%-15s%-40s\n", autor.getId(),
                            autor.getNombreAutor());
                }
            }
        }catch (Exception e) {
            throw e;
        }
    }




}
