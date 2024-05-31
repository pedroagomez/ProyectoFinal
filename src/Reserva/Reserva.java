package Reserva;

import Aula.*;
import Enumeradores.EnumDia;
import Enumeradores.EnumHorarios;
import GestorColeccion.GestionColeccion;
import Universidad.net.Materia;
import Universidad.net.Profesor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class Reserva {
    private LinkedHashMap<EnumDia, ManejoDias> configurador;

    public Reserva()
    {
        this.configurador = new LinkedHashMap<>();
    }

    public JSONArray toJson()  throws JSONException
    {
        JSONArray array = new JSONArray();
        JSONObject objeto = new JSONObject();
        for(Map.Entry<EnumDia, ManejoDias>it : configurador.entrySet())
        {
            objeto.put("Dia",it.getKey().toString());
            objeto.put("Horarios",it.getValue().toJson());
            array.put(objeto);
        }
        return array;

    }

        public String agregar(EnumDia dia, EnumHorarios hora, Aula aula, Materia materia)
        {
            String mensaje = "";
            ManejoDias manejoDias = configurador.get(dia); // Me trae todas las reservas del dia
           if(manejoDias== null)                           // Si el dia pasado no existe
           {
               manejoDias=new ManejoDias();              // agrega el dia
               configurador.put(dia,manejoDias);
           }
           boolean reserva = manejoDias.agregarAulaEnHorario(hora,aula,materia);
           if(reserva)
           {
               mensaje= "Reserva realizada";
           }
           else
           {
               mensaje="No se pudo realizar la reserva";
           }

            return mensaje;
        }

        public boolean cancelarReserva(EnumDia dia, EnumHorarios hora, Aula aula) {
            boolean reservaCancelada=false;
            if (configurador.containsKey(dia)) {
                ManejoDias manejoDias = configurador.get(dia);
                manejoDias.eliminarAulaEnHorario(hora, aula);
                reservaCancelada=true;
            }
            return reservaCancelada;
        }



        public StringBuilder retornoProfesorPorDia (Profesor profesor){
            StringBuilder cadena = new StringBuilder();
            ManejoDias aux = null;
            for(EnumDia dia : configurador.keySet()){
                cadena.append(dia).append("\n");
                aux = configurador.get(dia);
                cadena.append(aux.retornarProfesorPorHora(profesor)).append("\n");
            }
            return cadena;
        }

        public String verReservaDia(EnumDia dia)
        {
            StringBuilder builder=new StringBuilder();
            ManejoDias manejoDias = configurador.get(dia);
            if(manejoDias!=null)
            {
                builder.append(manejoDias.toString()).append("\n");
            }

            return  builder.toString();
        }

        public boolean verDisponiblidad(EnumDia dia,EnumHorarios hora,Aula aula){
        boolean disponible=true;
        ManejoDias aux = configurador.get(dia);
        if(aux!=null){
           disponible = aux.verDisponible(hora, aula);
        }
        return disponible;
        }


        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            configurador.forEach((dia, manejoDias) -> {
                builder.append(dia).append(":\n\t");
                builder.append(manejoDias).append("\n\t");
            });
            return builder.toString();
        }
}

