package Servicio;

import java.util.Scanner;

public class MenuServicio {

    Scanner entrada = new Scanner(System.in);

    AutorServicio autorServicio = new AutorServicio();

    public void menu() throws Exception {
        try {
            System.out.println("\n" + "-------MENÚ------\n"
                    + "1) Registrar un Autor.\n"
                    + "2) Búsqueda de Autor por nombre. \n"
                    + "3) Búsqueda de Autor por apellido. \n"
                    + "4) Búsqueda de Autor por Id.\n"
                    + "5) Búsqueda de todos los Autores.\n"
                    + "6) Salir.");

            System.out.println("Seleccione una opcion:");
            String respuesta = entrada.next();

            OpcionSeleccionada(respuesta);

        } catch (Exception e) {
            throw new Exception("Debe contener una opcion valida");
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
                    System.out.println("Saliendo del menú...");
                    break;

                default:
                    System.out.println("Ingrese una opcion valida");
                menu();
            }

        } catch (Exception e) {
            throw new Exception();
        }
    }



}
