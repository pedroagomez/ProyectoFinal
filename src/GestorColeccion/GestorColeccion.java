package GestorColeccion;

import java.util.*;

public class GestorColeccion<T,K>{
    private HashMap<K,T>mapa;
    private HashSet<T>conjunto;
    private List<T> lista;

    public GestorColeccion() {
        this.mapa = new HashMap<>();
        this.conjunto = new HashSet<>();
        this.lista = new LinkedList<>();
    }

    public void agregarMapa(K key, T elemento)
    {
        mapa.put(key,elemento);
    }

    public T obtenerMapa(K key)
    {
        return mapa.get(key);
    }

    public void eliminarMapa(K key)
    {
        mapa.remove(key);
    }

    public String listarMapa()
    {
        StringBuilder builder=new StringBuilder();
        Iterator<Map.Entry<K,T>>it=mapa.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry<K,T> conjunto=it.next();
            builder.append("Numero : "+ conjunto.getKey());
            builder.append(conjunto.getValue()).append("\n");
        }
        return builder.toString();
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

    public boolean buscarElemento(T elemento)
    {
        return conjunto.contains(elemento);
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

    //===========================================================

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





}
