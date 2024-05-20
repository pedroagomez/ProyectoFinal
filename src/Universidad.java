import GestorColeccion.GestorColeccion;
import Reserva.Reserva;
import Universidad.net.*;

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

    public void cargarProfesores() {
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
}
