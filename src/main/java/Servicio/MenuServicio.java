package Servicio;

import java.util.Scanner;

public class MenuServicio {

    Scanner entrada = new Scanner(System.in);

    AutorServicio autorServicio = new AutorServicio();
    LibroServicio libroServicio = new LibroServicio ();

    public void menu() throws Exception {
        try {
            System.out.println("\n" + "-------MENÚ------\n"
                    + "1) Registrar un Autor.\n"
                    + "2) Búsqueda de Autor por nombre. \n"
                    + "3) Búsqueda de Autor por apellido. \n"
                    + "4) Búsqueda de Autor por Id.\n"
                    + "5) Búsqueda de todos los Autores.\n"
                    + "6) Editar un autor.\n"
                    + "7) Eliminar un autor.\n"
                    + "8) Registrar un libro.\n"
                    + "9) Lista de libros registrados.\n"
                    + "10) Buscar libro por ISBN.\n"
                    + "11) Buscar libro por título.\n"
                    + "12) Eliminar un libro.\n"
                    + "13) Editar un libro.\n"
                    + "14) Salir.");

            System.out.println("Seleccione una opción:");
            String respuesta = entrada.next();

            OpcionSeleccionada(respuesta);

        } catch (Exception e) {
            throw new Exception("Debe contener una opción válida");
        }

    }

    public void OpcionSeleccionada(String respuesta) throws Exception {

        try {

            switch (respuesta) {

                case  "1":
                    autorServicio. crearAutor();
                    menu();
                    break;

                case "2":
                    autorServicio.mostrarAutorPorNombre();
                    menu();
                    break;
                case "3":
                    autorServicio.mostrarAutorPorApellido();
                    menu();
                    break;


                case "4":
                    autorServicio.mostrarAutorPorId();
                    menu();
                    break;

                case "5":
                    autorServicio.mostrarAutores();
                    menu();
                    break;

                case "6":
                    autorServicio.editarAutor();
                    menu();
                    break;

                case "7":
                    autorServicio.eliminarRegistro();
                    menu();
                    break;

                case "8":
                    libroServicio.crearLibro();
                    menu();
                    break;

                case "9":
                    libroServicio.MostrarLibros();
                    menu();
                    break;

                case "10":
                    libroServicio.MostrarLibroPorISBN();
                    menu();
                    break;

                case "11":
                    libroServicio.MostrarLibroPorTitulo();
                    menu();
                    break;

                case "12":
                    libroServicio.eliminarRegistro();
                    menu();
                    break;

                case "13":
                    libroServicio.editarLibro();
                    menu();
                    break;

                case "14":
                    System.out.println("Saliendo del menú...");
                    break;

                default:
                    System.out.println("Ingrese una opción válida");
                menu();
            }

        } catch (Exception e) {
            throw new Exception();
        }
    }



}
