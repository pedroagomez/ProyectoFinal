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

    public boolean equals(Object object) {
        boolean retorno = false;
        if (object !=null){
            if (object instanceof  Materia){
                if (object.getID() = this.id){
                    retorno=true;
                }
            }
        }
        return retorno;
    }

    public int hashCode() {
        return 1;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Materia{" +
                "nombre=" + nombre +
                ", id=" + id +
                ", profesor=" + profesor +
                '}';
    }
}
