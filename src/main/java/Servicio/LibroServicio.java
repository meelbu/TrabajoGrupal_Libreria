package Servicio;

import Entidad.Autor;
import Entidad.Libro;
import Persistencia.LibroDao;

import java.util.List;
import java.util.Scanner;

public class LibroServicio {

    Scanner entrada = new Scanner(System.in). useDelimiter("\n");

    private LibroDao librodao = new  LibroDao();

    public void crearLibro() throws Exception {

        Libro libro = new Libro ();
        Autor autor = new Autor ();

        try {
            System.out.println("\n" + "Registro de Libros"+ "\n" + "Ingrese el ISBN: ");
            Long isbn = entrada.nextLong();

            libro.setIsbn(isbn);

            if (isbn == null || isbn.toString().trim().isEmpty()) {
                throw new Exception("El isbn es obligatorio");
            }

            System.out.println("Ingrese el titulo: ");
            String titulo = entrada.next();

            libro.setTitulo(titulo);

            if (titulo == null || titulo.toString().trim().isEmpty()) {
                throw new Exception("El titulo es obligatorio");
            }

            System.out.println("Ingrese el año: ");
            Integer anio = entrada.nextInt();
            libro.setAnio(anio);

            if (anio == null || anio. toString(). trim(). isEmpty()) {
                throw new Exception("El año es obligatorio");
            }

            System.out.println("Ingrese ejemplares: ");
            Integer ejemplares = entrada.nextInt();
            libro. setEjemplares(ejemplares);

            if (ejemplares == null || ejemplares. toString(). trim(). isEmpty()) {
                throw new Exception("Los ejemplares son obligatorio");
            }

            System.out.println("Ingrese el ID del Autor: ");
            Integer Id = entrada.nextInt();
            autor. setId(Id);

            libro. setAutor(autor);

            if (Id == null) {
                throw new Exception("El autor es obligatorio");
            }

            System.out.println("¡Registro Exitoso!");
            librodao.Insertar(libro);

        } catch (Exception e) {
            throw new Exception("Error al crear el libro");
        }
    }

    public void MostrarLibros() throws Exception {

        try {
            List<Libro> libros = librodao.obtenerTodos();

            if (libros.isEmpty()) {
                throw new Exception("No hay registros de libros");

            } else  {

                System.out.println("\n" + "Lista de Libros");
                System.out.printf("%-20s%-25s%-20s%-20s%-20s%-20s\n", "ISBN", "Titulo"
                        , "Nombre Autor", "Apellido Autor", "Año", "Ejemplares");

                for (Libro libro : libros) {
                    System.out.printf("%-20s%-25s%-20s%-20s%-20s%-20s\n", libro.getIsbn(),
                            libro.getTitulo(), libro.getAutor().getNombreAutor(), libro.getAutor().getApellidoAutor(),
                            libro.getAnio(), libro.getEjemplares());

                }
            }

        }catch (Exception e) {
            throw e;
        }
    }


    public void MostrarLibroPorISBN() throws Exception {

        try {
            System.out.println("\n" + "Ingrese el ISBN del libro que desea buscar: ");
            Long isbn = entrada.nextLong();

            Libro libro = librodao.obtenerPorIsbn(isbn);

            if (libro == null || isbn == null) {
                System.out.println("El libro no existe");
            } else {
                System.out.printf("%-20s%-25s%-20s%-20s%-20s\n", "ISBN", "Titulo"
                        , "Autor", "Año", "Ejemplares");

                System.out.printf("%-20s%-25s%-20s%-20s%-20s\n", libro.getIsbn(),
                        libro.getTitulo(), libro.getAutor().getNombreAutor(),
                        libro.getAnio(), libro.getEjemplares());
            }

        } catch (Exception e) {
            throw new Exception("Error al buscar libro por isbn");
        }

    }

    public void MostrarLibroPorTitulo() throws Exception {

        try {
            System.out.println("\n" + "Ingrese el titulo del libro que desea buscar: ");
            String titulo = entrada.next();

            Libro libro = librodao.obtenerPorTitulo(titulo);

            if (libro == null || titulo == null) {
                System.out.println("El libro no existe");
            } else {
                System.out.printf("%-20s%-25s%-20s%-20s%-20s\n", "ISBN", "Titulo"
                        , "Autor", "Año", "Ejemplares");

            }

        } catch (Exception e) {
            throw new Exception("Error al buscar libro por titulo");
        }

    }

    public void eliminarRegistro() throws Exception{
        try {

            System.out.println("\n" + "Ingrese el ISBN del libro que desea eliminar: ");
            Long isbn = entrada.nextLong();

            Libro libro = librodao.obtenerPorIsbn(isbn);

            System.out.println("\n" + "¡Se elimino exitosamente!");
            librodao.eliminarPorLibro(libro);

        }catch (Exception e){
            throw new Exception("No se encontro un libro con ese ISBN ");
        }
    }

    public void editarLibro() throws Exception{

        try{

            System.out.println("Ingrese el ISBN del libro que desea editar: ");
            Long ISBN = entrada.nextLong();

            Libro libro1 = librodao.obtenerPorIsbn(ISBN);

            System.out.println("\n" + "Ingrese el nuevo título del libro:");
            String titulo = entrada.next();

            libro1.setTitulo(titulo);

            System.out.println("\n" + "Ingrese el año de edición:");
            Integer anio = entrada.nextInt();

            libro1.setAnio(anio);

            System.out.println("\n" + "Ingrese la cantidad de ejemplares:");
            Integer ejemplares = entrada.nextInt();

            libro1.setEjemplares(ejemplares);

            System.out.println("\n" + "¡Se editó exitosamente!");

            librodao.actualizar(libro1);

        }catch (Exception e) {
            throw new Exception("No se encontró un libro con ese ISBN ");
        }
    }



}
