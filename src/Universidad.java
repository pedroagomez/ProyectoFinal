import Enumeradores.EnumDia;
import Enumeradores.EnumHorarios;
import Enumeradores.EnumMes;
import Enumeradores.EnumSemana;
import GestorColeccion.GestorAula;
import GestorColeccion.GestorMateria;
import GestorColeccion.GestorProfesor;
import Reserva.*;
import Universidad.net.*;
import Aula.*;

import java.util.HashSet;
import java.util.LinkedList;
import Reserva.*;
public class Universidad {
    private GestorAula gestorAula;
    private GestorProfesor gestorProfesor;
    private GestorMateria gestorMateria;
    private ReservaPorMes reservaMes;

    public Universidad() {
        this.gestorAula = new GestorAula();
        this.gestorProfesor = new GestorProfesor();
        this.gestorMateria = new GestorMateria();
        this.reservaMes = new ReservaPorMes();
    }



    //============================================
    //              METODOS AULA
    //============================================

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



    //============================================
    //              METODOS PROFESOR
    //============================================


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

    //============================================
    //              METODOS MATERIA
    //============================================


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


    //============================================
    //              METODOS ARCHIVOS
    //============================================


    public void cargarArchivoGestores(){
        gestorAula.cargarArchivoAula();
        gestorMateria.cargarArchivoMateria();
        gestorProfesor.cargarArchivoMateria();
    }
    public void leerArchivoGestores(){
        gestorAula.leerArchivoAula();
        gestorMateria.leerArchivoMateria();
        gestorProfesor.leerArchivoMateria();
    }


    //============================================
    //              METODOS RESERVA
    //============================================


    public String agregarReserva(EnumMes mes, EnumSemana numSemana, EnumDia dia, EnumHorarios hora, Aula aula, Materia materia)
    {
        return reservaMes.agregar(mes,numSemana,dia,hora,aula,materia);
    }

    public boolean cancelarReserva(EnumMes mes, EnumSemana numSemana, EnumDia dia, EnumHorarios hora, Aula aula)
    {
        return reservaMes.cancelarReserva(mes,numSemana,dia,hora,aula);
    }


    public String buscarYretornarProfeYAula(Profesor profe, ReservaPorMes reserva){
        StringBuilder cadena = new StringBuilder();




        return cadena.toString();
    }




}
