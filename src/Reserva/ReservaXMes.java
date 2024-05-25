package Reserva;

import Aula.Aula;
import Enumeradores.EnumDia;
import Enumeradores.EnumHorarios;
import Enumeradores.EnumMes;
import Universidad.net.Materia;

import java.util.LinkedHashMap;

public class ReservaXMes {
    private LinkedHashMap<EnumMes,SemanaReserva> reservaMensual;

    public ReservaXMes() {
        this.reservaMensual = new LinkedHashMap<>();
    }

    public String agregar(EnumMes mes, Integer numSemana, EnumDia dia, EnumHorarios hora, Aula aula, Materia materia){
        String mensaje = "";

        SemanaReserva reservaAux = reservaMensual.get(mes); // Me trae el mes si hay
        if(reservaAux == null)                           // Si el mes no existe
        {
            reservaAux = new SemanaReserva();              // agrega el mes
            reservaMensual.put(mes,reservaAux);
        }
        mensaje = reservaAux.agregar(numSemana,dia,hora,aula,materia);

        return mensaje;
    }


    public String accederAMes (EnumMes mes){
        SemanaReserva aux = null;
        if(reservaMensual.containsKey(mes))
            aux = reservaMensual.get(mes);
        return aux.toString();
    }

}
