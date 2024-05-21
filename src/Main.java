import Aula.AulaComputadora;
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
        System.out.println(miUniversidad.aulasNoDisponibles());
        LinkedList<Aula> mi1 = new LinkedList<Aula>();
        mi1.add(new AulaComputadora(101,20,false,false,true,10,false));
        ManejoDias man = new ManejoDias("12:30",mi1);

        Reserva miReserva = new Reserva();

        miReserva.agregar("Lunes",man);
        miReserva.agregar("Lunes",man);
        System.out.println(miReserva.toString() );

    }
}
