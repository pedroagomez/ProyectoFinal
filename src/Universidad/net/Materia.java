package Universidad.net;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Materia implements Serializable {
    private String nombre;
    private int id;
    private static int iDSatic=0;
    private Profesor profesor;



    public Materia(String nombre, Profesor profesor) {
        this.nombre = nombre;
        this.id = iDSatic++;
        this.profesor = profesor;
    }
    public Materia( int id) {
        iDSatic = id;
    }


    public Materia(int id){
        iDSatic = id;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public static void setiDSatic(int iDSatic) {
        Materia.iDSatic = iDSatic;
    }

    //PROFESOR LO PODEMOS MOVER?
    /*
    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    */
    public boolean equals(Object o) {
        boolean retorno = false;
        if (o !=null){
            if (o instanceof  Materia){
                if (((Materia) o).getId() == this.getId()){
                    retorno=true;
                }
            }
        }
        return retorno;
    }

    public int hashCode() {
        return 1;
    }
    public JSONObject toJson() throws JSONException
    {
        JSONObject objeto = new JSONObject();
        objeto.put("nombre",this.nombre);
        objeto.put("id",this.id);
        objeto.put("profesor",this.profesor.toJson());
        return  objeto;
    }
    @Override
    public String toString() {
        return   "Nombre='" + nombre + '\'' +
                ", id=" + id +
                ",\t profesor=" + profesor +
                '}';
    }

    public String verMateriaDetalle()
    {
        return "Materia: " + this.nombre + ", ID: " + id;

    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public String obtenerInformacionDetallada() {
        return "Materia: " + this.nombre + ", Profesor: " + this.profesor.getNombre() ;
    }
}
