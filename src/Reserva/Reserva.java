package Reserva;

import Aula.*;
import Enumeradores.EnumDia;
import Enumeradores.EnumHorarios;
import Universidad.net.Materia;

import java.util.HashMap;
import java.util.LinkedHashMap;


public class Reserva {
    private LinkedHashMap<EnumDia, ManejoDias> configurador;

    public Reserva()
    {
        this.configurador = new LinkedHashMap<>();
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
               mensaje="El aula ya esta reservada en este horario";
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

