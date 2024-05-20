import GestorColeccion.GestorColeccion;
import Reserva.Reserva;
import Universidad.net.*

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Universidad {
    private HashSet<Profesor> profesores;
    LinkedList<Materia> materias;
    LinkedList<Reserva> reservas
    ///HashMap<K,V> miMapa = new HashMap<K, V>();


    public Universidad() {
        this.profesores = new HashSet <>();
        this.materias = new LinkedList<>();
        this.reservas = new LinkedList<>();;
    }


}
