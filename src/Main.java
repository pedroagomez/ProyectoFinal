import Aula.AulaComputadora;
import Enumeradores.EnumDia;
import Enumeradores.EnumHorarios;
import GestorColeccion.GestionColeccion;
import Reserva.ManejoDias;
import Aula.*;
import Reserva.Reserva;
import Universidad.net.Materia;
import Universidad.net.Profesor;

import java.util.HashMap;
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
        Aula aux = new AulaComputadora(101,20,false,false,true,10,false);


        Reserva miReserva = new Reserva();
        Profesor profesor = new Profesor("Pepe","Argento",1);
        Materia materia = new Materia("Matematica",profesor);

        System.out.println(miReserva.agregar(EnumDia.LUNES, EnumHorarios.DIEZTREINTA_A_TRECE,new AulaComputadora(101,20,false,false,true,10,false),materia));

        miReserva.agregar(EnumDia.MARTES,EnumHorarios.OCHOTREINTA_A_DIEZTREINTA,aux,materia);
        System.out.println(miReserva.agregar(EnumDia.JUEVES,EnumHorarios.DIEZTREINTA_A_TRECE,new AulaComputadora(101,20,false,false,true,10,false),materia));

        System.out.println(miReserva.agregar(EnumDia.MARTES,EnumHorarios.OCHOTREINTA_A_DIEZTREINTA,new AulaComputadora(102,20,false,false,true,20,false),materia));
        System.out.println(miReserva.agregar(EnumDia.LUNES, EnumHorarios.DIEZTREINTA_A_TRECE,new AulaComputadora(103,20,false,false,true,10,false),materia));
        //miReserva.cancelarReserva("Lunes","10",new AulaComputadora(101,20,false,false,true,10,false));
        System.out.println(miReserva.toString() );
    }
}
