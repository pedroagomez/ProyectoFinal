package Reserva;

import Aula.Aula;
import Enumeradores.EnumHorarios;
import GestorColeccion.GestionColeccion;
import Universidad.net.Materia;
import Universidad.net.Profesor;

import java.util.*;

public class ManejoDias {

    private HashMap<EnumHorarios,GestionColeccion<Aula>> horarios;


    public ManejoDias() {
        this.horarios = new HashMap<>();
    }

    ///ACA LAS NUEVAS MODIFICACIONES PARA AGREGAR AL PROFESOR Y LA RESERVA
    public boolean agregarAulaEnHorario(EnumHorarios hora, Aula aula, Materia materia) {
        boolean reservado = false;
        if (!horarios.containsKey(hora)) {
            horarios.put(hora, new GestionColeccion<Aula>());
        }
        GestionColeccion<Aula> aulasEnHorario = horarios.get(hora);
        if (!aulasEnHorario.verificarExistenciaElemento(aula)) {
            aula.setMateria(materia);
            aulasEnHorario.agregar(aula);
            aula.setDisponible(false);
            reservado = true;
        }
        return reservado;
    }


    public boolean eliminarAulaEnHorario(EnumHorarios hora, Aula aula) {
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
        Iterator<Map.Entry<EnumHorarios,GestionColeccion<Aula>>> it= horarios.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry<EnumHorarios,GestionColeccion<Aula>>conjunto =it.next();
            builder.append("\tHorario: ").append(conjunto.getKey());
            builder.append("\t\t\t\t\t\t Aula : ");
            GestionColeccion<Aula> conjuntoSet=conjunto.getValue();
            Iterator<Aula> iterator= conjuntoSet.getConjuntoIterator();
            while(iterator.hasNext())
            {
                Aula aula= iterator.next();
                builder.append(aula.getNumeroAula()).append(aula.getMateria().obtenerInformacionDetallada()).append("\n");
            }
        }

        return builder.toString();
    }
}
