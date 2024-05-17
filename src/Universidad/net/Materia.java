package Universidad.net;

public class Materia {
    private String nombre;
    private int id;
    private Profesor profesor;

    public Materia(java.lang.String nombre, int id, Profesor profesor) {
        this.nombre = nombre;
        this.id = id;
        this.profesor = profesor;
    }

    public java.lang.String getNombre() {
        return nombre;
    }

    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}
