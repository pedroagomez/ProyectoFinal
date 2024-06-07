package GestorColeccion;

import Universidad.net.Materia;
import Universidad.net.Profesor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

public class GestorProfesor implements  Serializable  {

    private GestionColeccion<Profesor>conjuntoProfesores;           // HASHSET DE PROFESOR.

    public GestorProfesor() {
        this.conjuntoProfesores = new GestionColeccion<Profesor>();
    }
    public String listarProfesores()
    {
        return conjuntoProfesores.listarConjunto();
    }
    public JSONArray toJson() throws JSONException
    {
        JSONArray array = new JSONArray();
        JSONObject object = new JSONObject();
        for(Profesor profesor : conjuntoProfesores.getConjunto())
        {
            array.put(profesor.toJson());
        }
        return array;
    }

    public void agregarProfesor(Profesor profe)
    {
        conjuntoProfesores.agregar(profe);
    }

    public void eliminarProfesor(Profesor profe)
    {
        conjuntoProfesores.eliminar(profe);
    }

    public boolean eliminarProfesorPorLegajo(int legajo)
    {
        boolean eliminado=false;
        Iterator<Profesor>it= conjuntoProfesores.getConjuntoIterator();
        while (it.hasNext())
         {
            Profesor profesor= it.next();
            if(profesor.getLegajo() == legajo)
            {
                it.remove();
                eliminado=true;
            }
        }
        return  eliminado;
    }
    //SE PASA POR PARAMETRO UN LEGAJO Y DEVUELVE AL PROFESOR

    public Profesor buscarProfesorPorLegajo(int legajo)
    {
        Profesor aux=null;
        Iterator<Profesor>it= conjuntoProfesores.getConjuntoIterator();
        while(it.hasNext())
        {
            Profesor profe= it.next();
            if(profe.getLegajo()==legajo)
            {
                aux=profe;
            }
        }
        return aux;
    }

    public boolean verificarExistenciaProfesor(int id)
    {
        boolean existe=false;
        Iterator<Profesor>it= conjuntoProfesores.getConjuntoIterator();
        while(it.hasNext())
        {
            Profesor profe = it.next();
            if(profe.getLegajo()== id)
            {
                existe=true;
            }
        }
        return existe;
    }
    public void cargarArchivoProfesor(){
        conjuntoProfesores.cargarArchivoConjunto("Profesores.bin");
    }
    public void leerArchivoProfesor(){
        conjuntoProfesores.leerArchivoConjunto("Profesores.bin");
    }

}
