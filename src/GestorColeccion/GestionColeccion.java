package GestorColeccion;

import Universidad.net.Profesor;

import java.util.HashSet;
import java.util.Iterator;

public class GestionColeccion<T> implements IGestion<T>{

    private HashSet<T> conjunto;

    public GestionColeccion() {
        this.conjunto = new HashSet<T>();
    }

    @Override
    public void agregar(T elemento) {
        if (elemento != null) {
            conjunto.add(elemento);
        }
    }

    @Override
    public boolean eliminar(T elemento) {
        boolean eliminar=false;
        if (elemento != null && conjunto.contains(elemento)) {
            eliminar= conjunto.remove(elemento);
        }
        return eliminar;
    }

    @Override
    public boolean verificarExistenciaElemento(T elemento) {
        return conjunto.contains(elemento);
    }

    @Override
    public String devolverElemento(T elemento) {
        StringBuilder builder = new StringBuilder();
        boolean encontrado=false;
        Iterator<T> it=conjunto.iterator();
        while(it.hasNext() && encontrado == false)
        {
            T dato = it.next();
            if(dato.equals(elemento))
            {
                builder.append(dato.toString());
                encontrado=true;
            }
        }
        return builder.toString();
    }

    @Override
    public String listarConjunto() {
        StringBuilder builder= new StringBuilder();
        Iterator<T> it= conjunto.iterator();
        while(it.hasNext())
        {
            T elemento= it.next();
            builder.append(elemento.toString()).append("\n");
        }
        return builder.toString();
    }

    public Iterator<T> getConjuntoIterator() {
        return conjunto.iterator();
    }
}
