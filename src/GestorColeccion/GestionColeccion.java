package GestorColeccion;


import Universidad.net.Profesor;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class GestionColeccion<T> implements IGestion<T>{

    private HashSet<T> conjunto;


    public GestionColeccion() {
        this.conjunto = new HashSet<T>();
    }


    //AGREGAR ELEMENTO
    @Override
    public void agregar(T elemento) {
        if (elemento != null) {
            conjunto.add(elemento);
        }
    }



    //ELIMINAR ELEMENTO
    @Override
    public boolean eliminar(T elemento) {
        boolean eliminar=false;
        if (elemento != null && conjunto.contains(elemento)) {
            eliminar= conjunto.remove(elemento);
        }
        return eliminar;
    }



    //VERIFICAR EXISTE DE UN ELEMENTO EN LA COLECCION. DEVUELVE UN BOOLEANO
    @Override
    public boolean verificarExistenciaElemento(T elemento) {
        return conjunto.contains(elemento);
    }

    public HashSet<T> getConjunto() {
        return conjunto;
    }

    public void setConjunto(HashSet<T> conjunto) {
        this.conjunto = conjunto;
    }



    //BUSCA Y DEVUELVE UNA CADENA DE STRING CON EL ELEMENTO QUE SE PASA POR PARAMETRO
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




    //LISTA TODA LA COLECCION Y DEVUELVE UNA CADENA DE STRING
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

    @Override
    public String toString() {
        return "GestionColeccion{" +
                "conjunto=" + conjunto +
                '}';
    }
    public void cargarArchivoConjunto(String nombreA){
        try {
            FileOutputStream ac = new FileOutputStream(nombreA);
            ObjectOutputStream ar=new ObjectOutputStream(ac);
            Iterator<T> it=conjunto.iterator();
            while (it.hasNext()){
                ar.writeObject(it.next());
            }
            ac.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {

        }
    }
    public void leerArchivoConjunto(String nombreA){
        try {
            FileInputStream fis=new FileInputStream(nombreA);
            ObjectInputStream ois=new ObjectInputStream(fis);
            boolean bandera = true;
            while (bandera) {
                agregar((T)ois.readObject());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
