package GestorColeccion;

import java.util.*;

public class GestorColeccion<T>{
    private HashSet<T>conjunto;
    private List<T> lista;

    public GestorColeccion() {
        this.conjunto = new HashSet<>();
        this.lista = new LinkedList<>();
    }

    //=================================================
    //Metodos para HashSet

    public void agregarAconjunto(T elemento)
    {
        conjunto.add(elemento);
    }

    public void eliminarDeConjunto(T elemento)
    {
        conjunto.remove(elemento);
    }

    public boolean verificarExistenciaElemento(T elemento)
    {
        return conjunto.contains(elemento);
    }

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


    public String listarConjunto()
    {
        StringBuilder builder= new StringBuilder();
        Iterator<T> it= conjunto.iterator();
        while(it.hasNext())
        {
            T elemento= it.next();
            builder.append(elemento.toString()).append("\n");
        }
        return builder.toString();
    }

    public HashSet<T> getConjunto() {
        return conjunto;
    }

    public void setConjunto(HashSet<T> conjunto) {
        this.conjunto = conjunto;
    }
//===========================================================
    //Metodos para listas

    public void agregarAlista(T elemento)
    {
        lista.add(elemento);
    }

    public void eliminarDeLista(T elemento)
    {
        lista.remove(elemento);
    }

    public String listarLista()
    {
        StringBuilder builder=new StringBuilder();
        for(T elemento : lista)
        {
            builder.append(builder.toString()).append("\n");
        }
        return builder.toString();
    }

    public boolean buscarEnLista(T elemento)
    {
        return lista.contains(elemento);
    }


    public List<T> getLista() {
        return lista;
    }

    public void setLista(List<T> lista) {
        this.lista = lista;
    }
}
