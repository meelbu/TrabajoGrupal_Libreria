package Entidad;


import javax.persistence.*;

@Entity
@Table(name= "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "nombre_autor", length = 100, nullable = false)
    private String nombreAutor;

    @Column(name = "apellido_autor", length = 100,nullable = false)
    private String apellidoAutor;


    public Autor(){

    }

    public Autor(Integer id, String nombreAutor, String apellidoAutor) {
        this.id = id;
        this.nombreAutor = nombreAutor;
        this.apellidoAutor = apellidoAutor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getApellidoAutor() {
        return apellidoAutor;
    }

    public void setApellidoAutor(String apellidoAutor) {
        this.apellidoAutor = apellidoAutor;
    }
}
