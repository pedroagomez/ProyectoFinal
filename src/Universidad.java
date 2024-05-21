import GestorColeccion.GestorAula;
import GestorColeccion.GestorMateria;
import GestorColeccion.GestorProfesor;
import Reserva.Reserva;
import Universidad.net.*;
import Aula.*;

import java.util.HashSet;
import java.util.LinkedList;

public class Universidad {
    private GestorAula gestorAula;
    private GestorProfesor gestorProfesor;
    private GestorMateria gestorMateria;

    private Reserva reserva;

    public Universidad() {
        this.gestorAula = new GestorAula();
        this.gestorProfesor = new GestorProfesor();
        this.gestorMateria = new GestorMateria();
        this.reserva = new Reserva();
    }

    public void agregarAula(Aula aulita)
    {
        gestorAula.agregarAula(aulita.getNumeroAula(),aulita);
    }

    public String verAulasDisponibles()
    {
        return gestorAula.verAulasDisponibles();
    }

    public String verAulasComputadoras()
    {
        return gestorAula.verAulasConComputadoras();
    }

    public String verAulasNormales()
    {
        return gestorAula.verAulasNormales();
    }

    public String listarAulas()
    {
        return gestorAula.listarAulas();
    }

    public String aulasNoDisponibles()
    {
        return gestorAula.aulaNoDisponible();
    }

    //METODOS PROFESOR


    public void cargarProfesor(Profesor profe)
    {
        gestorProfesor.agregarProfesor(profe);
    }

    public String listarProfesores()
    {
        return gestorProfesor.listarProfesores();
    }

    public Profesor buscarProfesorPorLegajo(int legajo){
        return gestorProfesor.buscarProfesorPorLegajo(legajo);
    }

    // Materias


    public void cargarMaterias(Materia materia)
    {
        gestorMateria.agregarMateria(materia);
    }

    public String listarMaterias()
    {
        return gestorMateria.listarMaterias();
    }


    //RESERVA

    public void agregarReserva()
    {
       // reserva.agregar("Lunes",ne);
    }


}
