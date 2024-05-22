package GestorColeccion;

import Universidad.net.Materia;
import Universidad.net.Profesor;

import java.util.Iterator;
import java.util.LinkedList;

public class GestorMateria {

    private GestionColeccion<Materia>conjuntoMaterias;

    public GestorMateria() {
        this.conjuntoMaterias = new GestionColeccion<>();
    }

    public void agregarMateria(Materia materia)
    {
        conjuntoMaterias.agregar(materia);
    }

    public void eliminarMateria(Materia materia)
    {
        conjuntoMaterias.eliminar(materia);
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


}
