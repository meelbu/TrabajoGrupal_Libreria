package Servicio;

import Entidad.Autor;
import Persistencia.AutorDao;

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




}
