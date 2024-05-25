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

    public String agregar(Integer numSemana, EnumDia dia, EnumHorarios hora, Aula aula, Materia materia)
    {
        String mensaje = "";

        Reserva reservaAux = reservaxSemana.get(numSemana); // Me trae todas las reservas de la semana
        if(reservaAux == null)                           // Si la semana no existe
        {
            reservaAux = new Reserva();              // agrega La semana
            reservaxSemana.put(numSemana,reservaAux);
        }
        mensaje = reservaAux.agregar(dia,hora,aula,materia);

        return mensaje;
    }


    public String accederASemana (Integer semana){
        Reserva aux = null;
        if(reservaxSemana.containsKey(semana))
        aux = reservaxSemana.get(semana);
        return aux.toString();
    }


    @Override
    public String toString() {
        return "SemanaReserva{" +
                "reservaxSemana=" + reservaxSemana +
                '}';
    }
}
