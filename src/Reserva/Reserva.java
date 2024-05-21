package Reserva;

import Aula.*;
import Universidad.net.Horario;
import Universidad.net.Materia;

import java.util.HashMap;
import java.util.LinkedList;


public class Reserva {
    private HashMap<String,LinkedList<ManejoDias>>configurador;

    public Reserva() {
        this.configurador = new HashMap<>();
    }

    public void agregar(String dia,ManejoDias manejo){
        LinkedList<ManejoDias> aux = null;
        if (configurador.containsKey(dia)){
            aux = configurador.get(dia);
        }else{
            aux = new LinkedList<>();
        }
        aux.add(manejo);
        configurador.put(dia,aux);
    }


}
