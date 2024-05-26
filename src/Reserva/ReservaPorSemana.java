package Reserva;

import Aula.Aula;
import Enumeradores.EnumDia;
import Enumeradores.EnumHorarios;
import Enumeradores.EnumMes;
import Enumeradores.EnumSemana;
import Universidad.net.Materia;
import Universidad.net.Profesor;

import java.util.*;

public class ReservaPorSemana {
    private LinkedHashMap<EnumSemana,Reserva> reservaxSemana;

    public ReservaPorSemana() {
        this.reservaxSemana = new LinkedHashMap<>();
    }

    public String agregar(EnumSemana numSemana, EnumDia dia, EnumHorarios hora, Aula aula, Materia materia)
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

    public boolean cancelarReserva(EnumSemana numSemana, EnumDia dia, EnumHorarios hora, Aula aula) {
        boolean reservaCancelada=false;
        if (reservaxSemana.containsKey(numSemana)) {
            Reserva reservaAux = reservaxSemana.get(dia);
            reservaAux.cancelarReserva(dia,hora,aula);
            reservaCancelada=true;
        }
        return reservaCancelada;
    }



    public String accederASemana (EnumSemana semana){
        Reserva aux = null;
        if(reservaxSemana.containsKey(semana)){
            aux = reservaxSemana.get(semana);
        }

        return aux.toString();
    }

    public StringBuilder retornoProfesorPorSemana (Profesor profesor){
        StringBuilder cadena = new StringBuilder();
        Reserva aux = null;
        for(EnumSemana semana : reservaxSemana.keySet()){
            cadena.append(semana).append("\n");
            aux = reservaxSemana.get(semana);
            cadena.append(aux.retornoProfesorPorDia(profesor).append("\n"));
        }
        return cadena;
    }


    public StringBuilder retornoSemanaEspecifico (EnumSemana semana, EnumDia dia){
        StringBuilder cadena = new StringBuilder();
        Reserva aux = null;
        aux = reservaxSemana.get(semana);
        cadena.append(aux.retornoDiaEspecifica(dia)).append("\n");
        return cadena;
    }


    @Override
    public String toString() {
        return "SemanaReserva{" +
                "reservaxSemana=" + reservaxSemana +
                '}';
    }
}
