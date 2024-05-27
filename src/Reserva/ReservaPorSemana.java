package Reserva;

import Aula.Aula;
import Enumeradores.EnumDia;
import Enumeradores.EnumHorarios;
import Enumeradores.EnumSemana;
import Universidad.net.Materia;
import Universidad.net.Profesor;

import java.util.*;

public class ReservaPorSemana {
    private LinkedHashMap<EnumSemana,Reserva> reservaPorSemana;

    public ReservaPorSemana() {
        this.reservaPorSemana = new LinkedHashMap<>();
    }

    public String agregar(EnumSemana numSemana, EnumDia dia, EnumHorarios hora, Aula aula, Materia materia)
    {
        String mensaje = "";

        Reserva reservaAux = reservaPorSemana.get(numSemana); // Me trae todas las reservas de la semana
        if(reservaAux == null)                           // Si la semana no existe
        {
            reservaAux = new Reserva();              // agrega La semana
            reservaPorSemana.put(numSemana,reservaAux);
        }
        mensaje = reservaAux.agregar(dia,hora,aula,materia);

        return mensaje;
    }

    public boolean cancelarReserva(EnumSemana numSemana, EnumDia dia, EnumHorarios hora, Aula aula) {
        boolean reservaCancelada=false;
        if (reservaPorSemana.containsKey(numSemana)) {
            Reserva reservaAux = reservaPorSemana.get(dia);
            reservaAux.cancelarReserva(dia,hora,aula);
            reservaCancelada=true;
        }
        return reservaCancelada;
    }



    public String accederASemana (EnumSemana semana){
        Reserva aux = null;
        if(reservaPorSemana.containsKey(semana)){
            aux = reservaPorSemana.get(semana);
        }

        return aux.toString();
    }

    public StringBuilder retornoProfesorPorSemana (Profesor profesor){
        StringBuilder cadena = new StringBuilder();
        Reserva aux = null;
        for(EnumSemana semana : reservaPorSemana.keySet()){
            cadena.append(semana).append("\n");
            aux = reservaPorSemana.get(semana);
            cadena.append(aux.retornoProfesorPorDia(profesor).append("\n"));
        }
        return cadena;
    }


    public String verReservaDia(EnumDia dia)
    {
        StringBuilder builder=new StringBuilder();
        for(EnumSemana semana : reservaPorSemana.keySet())
        {
            Reserva reserva = reservaPorSemana.get(semana);
            String diaSemana = reserva.verReservaDia(dia);
            builder.append(diaSemana.toString()).append("\n");
        }

        return  builder.toString();
    }


    @Override
    public String toString() {
        return "SemanaReserva " +
                "reservaSemana=" + reservaPorSemana
                ;
    }
}
