package GestorColeccion;

import Universidad.net.Materia;
import Universidad.net.Profesor;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

public class GestorProfesor {

    private GestionColeccion<Profesor>conjuntoProfesores;           // HASHSET DE PROFESOR.

    public GestorProfesor() {
        this.conjuntoProfesores = new GestionColeccion<Profesor>();
    }

    public void agregarProfesor(Profesor profe)
    {
        conjuntoProfesores.agregar(profe);
    }

    public void eliminarProfesor(Profesor profe)
    {
        conjuntoProfesores.eliminar(profe);
    }



    public String listarProfesores()
    {
        return conjuntoProfesores.listarConjunto();
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



}
