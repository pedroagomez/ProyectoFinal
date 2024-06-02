package GestorColeccion;

import Universidad.net.Materia;
import Universidad.net.Profesor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

public class GestorMateria implements Serializable {

    private GestionColeccion<Materia>conjuntoMaterias;

    public GestorMateria() {
        this.conjuntoMaterias = new GestionColeccion<>();
    }


    public JSONArray toJson() throws JSONException
    {
        JSONArray array = new JSONArray();
        JSONObject object = new JSONObject();
        for(Materia materia : conjuntoMaterias.getConjunto())
        {
            array.put(materia.toJson());
        }

        return array;
    }

    public void agregarMateria(Materia materia)
    {
        conjuntoMaterias.agregar(materia);
    }

    public void eliminarMateria(Materia materia)
    {
        conjuntoMaterias.eliminar(materia);
    }

    public boolean eliminarMateriaPorId(int id)
    {
        boolean eliminado=false;
        Iterator<Materia> it = conjuntoMaterias.getConjuntoIterator();
        while(it.hasNext())
        {
            Materia materia = it.next();
            if(materia.getId()==id)
            {
                it.remove();
                eliminado=true;
            }
        }
        return  eliminado;
    }

    


    //devuelve el string con toda la info de la materia.
    public String encontrarYdevolverMateriaString(int id)
    {
        boolean encontrado=false;
        StringBuilder builder= new StringBuilder();
        Iterator<Materia> it=  conjuntoMaterias.getConjuntoIterator();
        while(it.hasNext() && encontrado==false)
        {
            Materia materia = it.next();
            if(materia.getId()== id)
            {
                builder.append(materia.toString()).append("\n");
                encontrado=true;
            }
        }
        return builder.toString();
    }

    public String verMateriaDetalle() {
        StringBuilder builder = new StringBuilder();
        Iterator<Materia> it = conjuntoMaterias.getConjuntoIterator();
        if (!it.hasNext()) {
            return "No hay materias cargadas";
        }
        while (it.hasNext()) {
            Materia materia = it.next();
            if (materia != null) {
                builder.append(materia.verMateriaDetalle()).append("\n");
            }
        }
        return builder.toString();
    }

    //devuelve la materia en si
    public Materia devolverMateria(int id)
    {
        boolean encontrado=false;
        Materia aux=null;
        Iterator<Materia> it=  conjuntoMaterias.getConjuntoIterator();
        while(it.hasNext() && encontrado==false)
        {
            Materia materia = it.next();
            if(materia.getId()== id)
            {
                aux=materia;
                encontrado=true;
            }
        }
        return aux;
    }
    public String listarMaterias()
    {
        return conjuntoMaterias.listarConjunto();
    }

    public void cargarArchivoMateria(){
        conjuntoMaterias.cargarArchivoConjunto("Materias.bin");
    }
    public void leerArchivoMateria(){
        conjuntoMaterias.leerArchivoConjunto("Materias.bin");
    }
}
