package Reserva;

import Aula.Aula;
import Enumeradores.EnumDia;
import Enumeradores.EnumHorarios;
import Enumeradores.EnumSemana;
import Universidad.net.Materia;
import Universidad.net.Profesor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

public class ReservaPorSemana {
    private LinkedHashMap<EnumSemana,Reserva> reservaPorSemana;

    public ReservaPorSemana() {
        this.reservaPorSemana = new LinkedHashMap<>();
    }


    public JSONArray toJson()  throws JSONException
    {
        JSONArray array = new JSONArray();

        for(Map.Entry<EnumSemana, Reserva>it : reservaPorSemana.entrySet())
        {   JSONObject objeto = new JSONObject();
            objeto.put("Semana",it.getKey().toString());
            objeto.put("Dias",it.getValue().toJson());
            array.put(objeto);
        }
        return array;

    }
    /// FUNCION PARA AGREGAR LA RESERVA POR SEMANA
    public String agregar(EnumSemana numSemana, EnumDia dia, EnumHorarios hora, Aula aula, Materia materia)
    {
        String mensaje = "";

            Reserva reservaAux = reservaPorSemana.get(numSemana);         // Me trae todas las reservas de la semana
            if(reservaAux == null)                                       // Si la semana no existe
            {
                reservaAux = new Reserva();                               // agrega La semana
                reservaPorSemana.put(numSemana,reservaAux);
            }
            mensaje = reservaAux.agregar(dia,hora,aula,materia);

        return mensaje;
    }
    /// FUNCION PARA VER SI EL MAP ESTA VACIO
    public boolean isEmpty()
    {
        return reservaPorSemana.isEmpty();
    }
    /// FUCNION PARA CANCELAR UNA RESERVA
    public boolean cancelarReserva(EnumSemana numSemana, EnumDia dia, EnumHorarios hora) {
        boolean reservaCancelada=false;
        if (reservaPorSemana.containsKey(numSemana)) {
            Reserva reservaAux = reservaPorSemana.get(numSemana);
            if(reservaAux!=null)
            {
                reservaCancelada=reservaAux.cancelarReserva(dia,hora);
               if(reservaAux.isEmpty())
               {
                   reservaPorSemana.remove(numSemana);
               }
            }

        }
        return reservaCancelada;
    }


    /// FUNCION PARA ACCEDER A UNA SEMANA EN PARTICULAR
    public String accederASemana (EnumSemana semana){
        StringBuilder builder= new StringBuilder();
        Reserva aux = null;
        if(reservaPorSemana.containsKey(semana)){
            aux = reservaPorSemana.get(semana);
            builder.append(aux).append("\n");
        }
        else
        {
            builder.append("No hay reservas");
        }

        return builder.toString();
    }
    /// FUNCION PARA RETORNAR POR STRING QUE PROFESOR ESTA EN ESA SEMANA
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

    /// FUNCION PARA VER LA RESERVA EN UN DIA EN ESPECIFICO
    public String verReservaDia(EnumDia dia,EnumSemana semana)
    {
        StringBuilder builder=new StringBuilder();
        if(reservaPorSemana.containsKey(semana))
        {
            Reserva reserva = reservaPorSemana.get(semana);
            builder.append(reserva.verReservaDia(dia)).append("\n");
        }
        else
        {
            builder.append("No se encontro reserva");
        }
        return  builder.toString();
    }
    /// FUNCION PARA VER LA DISPONIBILIDAD DE LAS AULAS PARA LA RESERVA
    public boolean verDisponibilidad(EnumDia dia,EnumSemana semana, EnumHorarios hora, Aula aula){
        boolean disponibilidad=true;
        Reserva aux = null;
        aux = reservaPorSemana.get(semana);
        if(aux != null){
            disponibilidad = aux.verDisponiblidad(dia,hora,aula);
        }

        return disponibilidad;
    }



    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        reservaPorSemana.forEach((semana, manejoDias) -> {
            builder.append("\t").append(semana).append(":\n").append(manejoDias).append("\n");
        });
        return builder.toString();
    }
}
