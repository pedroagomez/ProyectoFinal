package Reserva;

import Aula.*;
import Universidad.net.Horario;
import Universidad.net.Materia;

import java.util.HashMap;
import java.util.LinkedList;


public class Reserva {
    private HashMap<String, ManejoDias> configurador;

    public Reserva()
    {this.configurador = new HashMap<>();

    }

        public String agregar(String dia, String hora, Aula aula)
        {
            String mensaje = "";
            ManejoDias manejoDias = configurador.get(dia); // Me trae todas las reservas del dia
           if(manejoDias== null)                           // Si el dia pasado no existe
           {
               manejoDias=new ManejoDias();              // agrega el dia
               configurador.put(dia,manejoDias);
           }
           boolean reserva= manejoDias.agregarAulaEnHorario(hora,aula);
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

        public void cancelarReserva(String dia, String hora, Aula aula) {
            if (configurador.containsKey(dia)) {
                ManejoDias manejoDias = configurador.get(dia);
                manejoDias.eliminarAulaEnHorario(hora, aula);
            }
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            configurador.forEach((dia, manejoDias) -> {
                builder.append(dia).append(":\n");
                builder.append(manejoDias).append("\n");
            });
            return builder.toString();
        }
}

