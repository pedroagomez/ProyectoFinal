package Reserva;

import Aula.Aula;
import Enumeradores.EnumDia;
import Enumeradores.EnumHorarios;
import GestorColeccion.GestionColeccion;
import Universidad.net.Materia;

import java.util.*;

public class SemanaReserva {
    private LinkedHashMap<Integer,Reserva> reservaxSemana;

    public SemanaReserva() {
        this.reservaxSemana = new LinkedHashMap<>();
    }

    public String agregar(Integer numSemana, Reserva reservaNueva)
    {
        String mensaje = "";
        Reserva reservaAux = reservaxSemana.get(numSemana); // Me trae todas las reservas de la semana
        if(reservaAux == null)                           // Si la semana no existe
        {
            reservaAux = new Reserva();              // agrega La semana
            reservaxSemana.put(numSemana,reservaAux);
        }else{
            reservaxSemana.put(numSemana,reservaNueva);
        }
        boolean agregado = reservaxSemana.containsKey(numSemana);
        boolean reserva = reservaxSemana.containsValue(reservaNueva);
        if(agregado && reserva)
        {
            mensaje= "Reserva realizada";
        }
        else
        {
            mensaje="El aula ya esta reservada en este horario";
        }

        return mensaje;
    }
    

    @Override
    public String toString() {
        return "SemanaReserva{" +
                "reservaxSemana=" + reservaxSemana +
                '}';
    }
}
