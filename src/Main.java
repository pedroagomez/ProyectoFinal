import Aula.AulaComputadora;
import GestorColeccion.GestionColeccion;
import Reserva.ManejoDias;
import Aula.*;
import Reserva.Reserva;

import java.util.LinkedList;

public class Main {
    public static void main(String [] args)
    {
        Universidad miUniversidad = new Universidad();
        miUniversidad.agregarAula(new AulaComputadora(101,20,false,false,true,10,false));
        miUniversidad.agregarAula(new AulaComputadora(202,20,false,false,false,10,false));
        miUniversidad.agregarAula(new AulaComputadora(303,20,false,false,false,10,false));
        //System.out.println(miUniversidad.listarAulas());
        //System.out.println(miUniversidad.aulasNoDisponibles());
        GestionColeccion<Aula> mi1 = new GestionColeccion<>();
        mi1.agregar(new AulaComputadora(101,20,false,false,true,10,false));
        ManejoDias man = new ManejoDias();

        Reserva miReserva = new Reserva();

        System.out.println(miReserva.agregar("Lunes","10",new AulaComputadora(101,20,false,false,true,10,false)));
        System.out.println(miReserva.agregar("Martes","10",new AulaComputadora(102,20,false,false,true,20,false)));

        //miReserva.cancelarReserva("Lunes","10",new AulaComputadora(101,20,false,false,true,10,false));
        System.out.println(miReserva.toString() );

    }
}
