package Reserva;

import Aula.Aula;

import java.util.HashMap;

public class SemanaReserva {
    private HashMap<Integer,Reserva>reservaxSemana;

    public SemanaReserva() {
        this.reservaxSemana = new HashMap<>();
    }

    public boolean agregar(Integer semana,Reserva nuevita)
    {
        boolean retorno = false;
        Reserva reserva = reservaxSemana.get(semana); // Me trae todas las reservas del dia
        if(reserva== null)                           // Si el dia pasado no existe
        {
            reserva = new Reserva();              // agrega el dia
            reservaxSemana.put(semana,reserva);
        }
        retorno = reserva.agregar();
        if(reserva)
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
