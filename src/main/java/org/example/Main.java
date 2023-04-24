package org.example;

import Servicio.MenuServicio;

public class Main {
    public static void main(String[] args) {


        MenuServicio menuServicio = new MenuServicio();

        try {
            menuServicio.Menu();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }



    }
}