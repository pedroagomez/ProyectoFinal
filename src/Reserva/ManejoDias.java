package Reserva;

import Aula.Aula;
import GestorColeccion.GestionColeccion;

import java.util.*;

public class ManejoDias {

    private HashMap<String,GestionColeccion<Aula>> horarios;


    public ManejoDias() {
        this.horarios = new HashMap<>();
    }



    public boolean agregarAulaEnHorario(String hora, Aula aula)
    {
        boolean reservado=false;
        GestionColeccion<Aula> setAula=horarios.get(hora);          // Traigo al setAula todas las aulas que estan en ese horario
        if(setAula !=null && setAula.verificarExistenciaElemento(aula)) // Si existe significa que el horario esta ocupado
        {
            reservado=false;
        }
        else if( setAula== null)                // Si no existe, por lo tanto es null.. entonces -->
        {
            setAula=new GestionColeccion<>();
            setAula.agregar(aula);              // agrego el aula en la coleccion Gestion
            horarios.put(hora,setAula);         // agrego al hashmap el horario y el aula
            aula.setDisponible(false);          // el aula pasa a estar no disponible
            reservado=true;
        }
        return  reservado;
    }

    public boolean eliminarAulaEnHorario(String hora, Aula aula) {
        boolean darBaja = false;
        if (horarios.containsKey(hora))
        {
            GestionColeccion<Aula> setAula = horarios.get(hora);
            if (setAula != null && setAula.eliminar(aula))
            {
                aula.setDisponible(true);
                darBaja = true;
            }
        }
        return darBaja;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Iterator<Map.Entry<String,GestionColeccion<Aula>>> it= horarios.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry<String,GestionColeccion<Aula>>conjunto =it.next();
            builder.append("\tHorario: ").append(conjunto.getKey()).append("\n");
            builder.append("\tAulas : \n");
            GestionColeccion<Aula> conjuntoSet=conjunto.getValue();
            Iterator<Aula> iterator= conjuntoSet.getConjuntoIterator();
            while(iterator.hasNext())
            {
                Aula aula= iterator.next();
                builder.append("\t\t").append(aula).append("\n");
            }
        }

        return builder.toString();
    }
}
