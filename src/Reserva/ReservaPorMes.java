package Reserva;

import Aula.Aula;
import Enumeradores.EnumDia;
import Enumeradores.EnumHorarios;
import Enumeradores.EnumMes;
import Enumeradores.EnumSemana;
import Universidad.net.Materia;
import Universidad.net.Profesor;

import java.util.LinkedHashMap;

public class ReservaPorMes {
    private LinkedHashMap<EnumMes, ReservaPorSemana> reservaMensual;

    public ReservaPorMes() {
        this.reservaMensual = new LinkedHashMap<>();
    }

    public String agregar(EnumMes mes, EnumSemana numSemana, EnumDia dia, EnumHorarios hora, Aula aula, Materia materia){
        String mensaje = "";

        ReservaPorSemana reservaAux = reservaMensual.get(mes); // Me trae el mes si hay
        if(reservaAux == null)                           // Si el mes no existe
        {
            reservaAux = new ReservaPorSemana();              // agrega el mes
            reservaMensual.put(mes,reservaAux);
        }
        mensaje = reservaAux.agregar(numSemana,dia,hora,aula,materia);

        return mensaje;
    }


    public boolean cancelarReserva(EnumMes mes,EnumSemana numSemana,EnumDia dia, EnumHorarios hora, Aula aula)
    {
        boolean reservaCancelada=false;
        if (reservaMensual.containsKey(mes)) {
            ReservaPorSemana reservaAux = reservaMensual.get(mes);
            reservaAux.cancelarReserva(numSemana,dia,hora,aula);
            reservaCancelada=true;
        }
        return  reservaCancelada;
    }


    public StringBuilder retornoProfesorPorMes (Profesor profesor){
        StringBuilder cadena = new StringBuilder();
        ReservaPorSemana aux = null;
        for(EnumMes mes : reservaMensual.keySet()){
            cadena.append(mes).append("\n");
            aux = reservaMensual.get(mes);
            cadena.append(aux.retornoProfesorPorSemana(profesor).append("\n"));
        }
        return cadena;
    }

    public StringBuilder retornoMesEspecifico (EnumMes mes,EnumSemana semana, EnumDia dia){
        StringBuilder cadena = new StringBuilder();
        ReservaPorSemana aux = null;
        aux = reservaMensual.get(mes);
        cadena.append(aux.retornoSemanaEspecifico(semana,dia)).append("\n");
        return cadena;
    }

    public String accederAMes (EnumMes mes){
        ReservaPorSemana aux = null;
        if(reservaMensual.containsKey(mes))
            aux = reservaMensual.get(mes);
        return aux.toString();
    }

}
