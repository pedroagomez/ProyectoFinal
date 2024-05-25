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
    /// Agregar un aular a la coleccion
    public void agregarAula(Aula aulita)
    {
        gestorAula.agregarAula(aulita.getNumeroAula(),aulita);
    }
    /// Veremos las aulas disponibles - Nos devuelve la cadena de caracteres mostrando las aulas libres
    public String verAulasDisponibles()
    {
        return gestorAula.verAulasDisponibles();
    }
    /// Veremos las aulas con computadores disponibles
    public String verAulasComputadoras()
    {
        return gestorAula.verAulasConComputadoras();
    }
    /// Vemos las aulas normales (La clase hija de Aula)
    public String verAulasNormales()
    {
        return gestorAula.verAulasNormales();
    }
    /// Nos devuelve las aulas disponibles en cadena de String
    public String listarAulas()
    {
        return gestorAula.listarAulas();
    }
    /// Nos devuelve todas las aulas disponibles en Univerdad
    public String aulasNoDisponibles()
    {
        return gestorAula.aulaNoDisponible();
    }

    //METODOS PROFESOR

    /// Cargar un profesor
    public void cargarProfesor(Profesor profe)
    {
        gestorProfesor.agregarProfesor(profe);
    }
    /// Mostrar los profesores
    public String listarProfesores()
    {
        return gestorProfesor.listarProfesores();
    }
    /// Buscar y retornar un profesor por legajo
    public Profesor buscarProfesorPorLegajo(int legajo){
        return gestorProfesor.buscarProfesorPorLegajo(legajo);
    }

    // Materias

    /// Cargar una materia nueva
    public void cargarMaterias(Materia materia)
    {
        gestorMateria.agregarMateria(materia);
    }
    /// Devolvemos una cadena de caracteres Con las materias que esten cargadas
    public String listarMaterias()
    {
        return gestorMateria.listarMaterias();
    }
    //RESERVA
    ///Agregamos una nueva reserva

    public void cargarArchivoC(){
        gestorAula.cargarArchivoAula();
        gestorMateria.cargarArchivoMateria();
        gestorProfesor.cargarArchivoMateria();
    }
    public void leerArchivoC(){
        gestorAula.leerArchivoAula();
        gestorMateria.leerArchivoMateria();
        gestorProfesor.leerArchivoMateria();
    }


}
