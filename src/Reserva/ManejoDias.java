package Reserva;

import Aula.Aula;

import java.util.LinkedList;
import java.util.Objects;

public class ManejoDias {
    private String hora;
    private LinkedList<Aula> aulas;

    

    public ManejoDias(String hora) {
        this.hora = hora;
        this.aulas = new LinkedList<>();
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public LinkedList<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(LinkedList<Aula> aulas) {
        this.aulas = aulas;
    }

    @Override
    public boolean equals(Object o) {
        boolean retorno = false;
        if (o!=null){
            if (o instanceof ManejoDias){
                if(((ManejoDias) o).getHora().equalsIgnoreCase(this.hora)){
                    retorno = true;
                }
            }
        }
        return retorno;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
