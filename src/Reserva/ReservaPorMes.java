package Reserva;

import Aula.Aula;
import Enumeradores.EnumDia;
import Enumeradores.EnumHorarios;
import Enumeradores.EnumMes;
import Enumeradores.EnumSemana;
import Universidad.net.Materia;
import Universidad.net.Profesor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

public class ReservaPorMes {
    private LinkedHashMap<EnumMes, ReservaPorSemana> reservaMensual;

    public ReservaPorMes() {
        this.reservaMensual = new LinkedHashMap<>();
    }


    public JSONArray toJson()  throws JSONException
    {
        JSONArray array = new JSONArray();

        for(Map.Entry<EnumMes, ReservaPorSemana>it : reservaMensual.entrySet())
        {   JSONObject objeto = new JSONObject();
            objeto.put("Mes",it.getKey().toString());
            objeto.put("Semana",it.getValue().toJson());
            array.put(objeto);
        }
        return array;

    }

    public LinkedHashMap<EnumMes, ReservaPorSemana> getReservaMensual() {
        return reservaMensual;
    }
    /// FUNCION PARA AGREGAR LA RESERVA POR MES
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

    /// FUNCION PARA CANCELAR UNA RESERVA
    public boolean cancelarReserva(EnumMes mes,EnumSemana numSemana,EnumDia dia, EnumHorarios hora)
    {
        boolean reservaCancelada=false;
        if (reservaMensual.containsKey(mes)) {
            ReservaPorSemana reservaAux = reservaMensual.get(mes);
            if(reservaAux!=null)
            {
                reservaCancelada=reservaAux.cancelarReserva(numSemana,dia,hora);
                if(reservaAux.isEmpty())
                {
                    reservaMensual.remove(mes);
                }
            }

        }
        return  reservaCancelada;
    }

    /// FUNCION PARA RETORNAR EL PROFESOR QUE TIENE RESERVA EN ESE MES
    public String retornoProfesorPorMes (Profesor profesor){
        StringBuilder cadena = new StringBuilder();
        ReservaPorSemana aux = null;
        for(EnumMes mes : reservaMensual.keySet()){
            aux = reservaMensual.get(mes);
            if(aux!=null){
                cadena.append(mes).append("\n");
                cadena.append(aux.retornoProfesorPorSemana(profesor).append("\n"));
            }
            else
            {
                cadena.append("No hay reservas");
            }
        }
        return cadena.toString();
    }
    /// FUNCION PARA ACCEDER AL MES
    public String accederAMes (EnumMes mes){
        ReservaPorSemana aux = null;
        String mensaje = "";
        if(reservaMensual.containsKey(mes)){
            aux = reservaMensual.get(mes);
            mensaje = aux.toString();
        }else {
            mensaje = "No se encontro reservas";
        }
        return mensaje;
    }
    /// FUNCION PARA VER LAS RESERVAS EN EL MES Y LA SEMANA ASIGANADA
    public String verReservaSemana(EnumMes mes, EnumSemana semana)
    {
        StringBuilder builder=new StringBuilder();
        if(reservaMensual.containsKey(mes))
        {
            ReservaPorSemana reservaPorSemana = reservaMensual.get(mes);
            builder.append(reservaPorSemana.accederASemana(semana)).append("\n");
        }else{
            builder = new StringBuilder();
            builder.append("No hay reservas");
        }

        return builder.toString();
    }
    /// FUNCION PARA VER LA RESERVA EN EL DIA ASIGANDO
    public String verReservaDia(EnumDia dia,EnumSemana semana,EnumMes mes)
    {
        StringBuilder builder=new StringBuilder();
        if(reservaMensual.containsKey(mes))
        {
            ReservaPorSemana reserva = reservaMensual.get(mes);
            builder.append(reserva.verReservaDia(dia,semana)).append("\n");
        } else
        {
            builder.append("Reserva no encontrada");
        }

        return  builder.toString();
    }
    /// FUNCION PARA VER LA DISPONIBILIDAD DE LAS AULAS PARA RESERVAR
    public boolean verDisponibilidad(EnumDia dia,EnumSemana semana,EnumMes mes,EnumHorarios hora, Aula aula ){
        boolean disponibilidad=true;
        ReservaPorSemana aux = null;
        aux = reservaMensual.get(mes);
        if(aux != null){
            disponibilidad = aux.verDisponibilidad(dia,semana,hora,aula);
        }
        return disponibilidad;
    }



    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if(reservaMensual.isEmpty())
        {
            builder.append("No hay reservas");
        }
        else
        {
            builder.append("Reserva Mensual:\n");
            reservaMensual.forEach((mes, semana) -> {
                builder.append(mes).append(":\n").append(semana).append("\n");
            });
        }

        return builder.toString();
    }
}
