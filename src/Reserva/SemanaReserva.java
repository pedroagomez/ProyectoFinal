package Reserva;

import Aula.Aula;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class SemanaReserva {
    private LinkedHashMap<Integer,Reserva> reservaxSemana;

    public SemanaReserva() {
        this.reservaxSemana = new HashMap<>();
    }

    public boolean agregar(Integer semana,Reserva nuevita)
    {
        String mensaje = "";
        boolean retorno = false;
        Reserva reserva = reservaxSemana.get(semana); // Me trae todas las reservas del dia
        if(reserva== null)                           // Si el dia pasado no existe
        {
            reserva = new Reserva();              // agrega el dia
            reservaxSemana.put(semana,reserva);
        }
        retorno = true;
        if(retorno = true)
        {
            mensaje= "Reserva realizada";
        }
        else
        {
            mensaje="El aula ya esta reservada en este horario";
        }

        return mensaje;
    }


}
