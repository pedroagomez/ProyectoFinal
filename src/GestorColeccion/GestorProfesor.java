package GestorColeccion;

import Universidad.net.Materia;
import Universidad.net.Profesor;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

public class GestorProfesor implements  Serializable  {

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

    public boolean eliminarProfesorPorLegajo(int legajo)
    {
        boolean eliminado=false;
        for(Profesor profesor :conjuntoProfesores.getConjunto())
        {
            if(profesor.getLegajo()==legajo)
            {
                conjuntoProfesores.eliminar(profesor);
                eliminado=true;
            }
        }
        return  eliminado;
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
    public void cargarArchivoMateria(){
        conjuntoProfesores.cargarArchivoConjunto("Profesores.bin");
    }
    public void leerArchivoMateria(){
        conjuntoProfesores.leerArchivoConjunto("Profesores.bin");
    }
}
