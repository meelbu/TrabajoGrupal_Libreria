package Servicio;

import java.util.Scanner;

public class MenuServicio {

    Scanner entrada = new Scanner(System.in);

    AutorServicio autorServicio = new AutorServicio();

    public void Menu() throws Exception {
        try {
            System.out.println("\n" + "-------MENÚ------\n"
                    + "1) Registrar un Autor.\n"
                    + "2) Búsqueda de Autor por nombre. \n"
                    + "3) Salir.");

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
                Menu();

                break;

                case "2":
                    System.out.println("Consulta finalizada");

                break;


                default:
                    System.out.println("Ingrese una opcion valida");
                Menu();
            }

        } catch (Exception e) {
            throw new Exception();
        }
    }
}
