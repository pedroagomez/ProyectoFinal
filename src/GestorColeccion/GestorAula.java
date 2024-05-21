package GestorColeccion;

import Aula.Aula;
import GestorColeccion.GestorColeccion;

import java.util.Iterator;

public class GestorAula {
    private GestorColeccion<Aula> setAula;

    public GestorAula() {
        this.setAula = new GestorColeccion<Aula>();
    }

    public void agregarAula(Aula aula){

        setAula.agregarAconjunto(aula);
    }

    public String buscarYdevolverAula(Aula aula)
    {
        StringBuilder builder= new StringBuilder();
        if(setAula.verificarExistenciaElemento(aula))
        {
            builder.append(setAula.devolverElemento(aula)).append("\n");
        }
        else
        {
            builder.append("Elemento no encontrado");
        }
        return builder.toString();
    }

    public String listarAulas()
    {
        return setAula.listarConjunto();
    }

   public String listarAulaComputadora(Aula aula)
   {
       StringBuilder builder=new StringBuilder();
       if(aula instanceof AulaComputadora)
       {
          builder.append(setAula.listarConjunto()).append("\n");
       }
       return builder.toString();
   }

    public String listarAulaNormal(Aula aula)
    {
        StringBuilder builder=new StringBuilder();
        if(aula instanceof AulaNormal)
        {
            builder.append(setAula.listarConjunto()).append("\n");
        }
        return builder.toString();
    }

    public String listarAulasDisponibles()
    {
        StringBuilder builder=new StringBuilder();

        for(Aula aula : setAula.getConjunto())
        {
            if (aula.isDisponible())
            {
                builder.append(setAula.listarConjunto()).append("\n");
            }
        }
        return builder.toString();
    }
}
