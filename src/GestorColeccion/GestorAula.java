package GestorColeccion;

import Aula.*;

import javax.swing.plaf.basic.BasicButtonUI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GestorAula {

    private HashMap<Integer,Aula> mapaAula;

    public GestorAula() {
        this.mapaAula = new HashMap<>();
    }

    public void agregarAula(int numeroAula,Aula aula)
    {
        mapaAula.put(numeroAula,aula);
    }

    public boolean aulaNoDisponible(int numeroAula)
    {
        boolean disponible=true;
        Iterator<Map.Entry<Integer,Aula>>it=mapaAula.entrySet().iterator();
        while(it.hasNext() && disponible== true)
        {
            Map.Entry<Integer,Aula>conjunto=it.next();
            if(conjunto.getKey() == numeroAula)
            {
                conjunto.getValue().setDisponible(false);
                disponible=false;
            }
        }
        return disponible;
    }

    public String verAulasDisponibles()
    {
        StringBuilder builder= new StringBuilder();
        Iterator<Map.Entry<Integer,Aula>>it=mapaAula.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry<Integer,Aula>conjunto=it.next();
            if(conjunto.getValue().isDisponible())
            {
                builder.append(conjunto.getValue()).append("\n");
            }
        }
        return builder.toString();
    }

    public String verAulasConComputadoras()
    {
        StringBuilder builder= new StringBuilder();
        Iterator<Map.Entry<Integer,Aula>>it=mapaAula.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry<Integer,Aula>conjunto=it.next();
            if(conjunto instanceof AulaComputadora)
            {
                builder.append("Numero de aula : "+conjunto.getKey()).append("\n");
                builder.append(conjunto.getValue()).append("\n");
            }
        }
        return builder.toString();
    }

    public String verAulasNormales()
    {
        StringBuilder builder= new StringBuilder();
        Iterator<Map.Entry<Integer,Aula>>it=mapaAula.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry<Integer,Aula>conjunto=it.next();
            if(conjunto instanceof AulaNormal)
            {
                builder.append("Numero de aula : "+conjunto.getKey()).append("\n");
                builder.append(conjunto.getValue()).append("\n");
            }
        }
        return builder.toString();
    }



}
