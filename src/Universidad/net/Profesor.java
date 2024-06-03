package Universidad.net;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Profesor implements Serializable {
    private String nombre;
    private String apellido;
    private int legajo;

    public Profesor(String nombre,String apellido, int legajo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
    }

    public JSONObject toJson() throws JSONException
    {
        JSONObject objeto = new JSONObject();
        objeto.put("nombre",this.nombre);
        objeto.put("apellido",this.apellido);
        objeto.put("legajo",this.legajo);
        return  objeto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public boolean equals(Object object) {
        boolean retorno = false;
        if (object!= null){
                if (object instanceof Profesor){
                    if (((Profesor) object).getLegajo() == this.legajo) {
                        retorno = true;
                    }
                }
            }
        return retorno;
    }

    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return   nombre + " "+
                 apellido +
                " ,Numero de legajo = " + legajo ;

    }
}