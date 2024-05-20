import GestorColeccion.GestorColeccion;
import Reserva.Reserva;
import Universidad.net.*;

import javax.swing.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Universidad {
    private HashSet<Profesor> profesores;
    LinkedList<Materia> materias;
    LinkedList<Reserva> reservas;
    ///HashMap<K,V> miMapa = new HashMap<K, V>();


    public Universidad() {
        this.profesores = new HashSet <>();
        this.materias = new LinkedList<>();
        this.reservas = new LinkedList<>();;
    }

    public void cargarProfesoresAutomatico() {
        profesores.add(new Profesor("Rodrigo","Albert",1 ));
        profesores.add(new Profesor("Paula","Fernandez",2 ));
        profesores.add(new Profesor("Costanza","Nandez",3 ));
        profesores.add(new Profesor("Maximiliano","Expert",4 ));
        profesores.add(new Profesor("Dexster","Morgan",5 ));
        profesores.add(new Profesor("Ben","Kenobi",6 ));
        profesores.add(new Profesor("Ani","Skaywito",7 ));
        profesores.add(new Profesor("Paulo","Mendez",8 ));
        profesores.add(new Profesor("Emanuel","Lopez",9 ));
    }

    public boolean cargarProfesorNuevo(String nombre,String apellido, int Legajo) {
        boolean correcto = false;
        Profesor aux = new Profesor(nombre,apellido,Legajo);
        if (!profesores.contains(aux)) {
            profesores.add(new Profesor(nombre,apellido,Legajo));
            correcto = true;
        }
        return correcto;
    }

    public Profesor buscarYdevolverProfesorPorLegajo(int legajo){
        Profesor aux = null;
        for(Profesor profesor : profesores){
            if(profesor.getLegajo() == legajo){
                aux = profesor;
            }
        }
        return aux;
    }
}
