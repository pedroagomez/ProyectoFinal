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
import org.json.JSONException;
import org.json.JSONObject;

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


    public JSONObject toJson() throws JSONException
    {
        JSONObject objeto= new JSONObject();
        objeto.put("Reservas",reservaMes.toJson());
        return objeto;
    }

    // ============================ GETTERS AND SETTERS
    public GestorAula getGestorAula() {
        return gestorAula;
    }

    public GestorProfesor getGestorProfesor() {
        return gestorProfesor;
    }

    public GestorMateria getGestorMateria() {
        return gestorMateria;
    }

    public ReservaPorMes getReservaMes() {
        return reservaMes;
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

    // HACER METODO PARA ELEGIR PROFE Y METERLO EN MATERIA




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

    public boolean eliminarProfesorPorLegajo(int legajo)
    {
       return gestorProfesor.eliminarProfesorPorLegajo(legajo);
    }
    /// Buscar y retornar un profesor por legajo
    public Profesor buscarProfesorPorLegajo(int legajo){
        return gestorProfesor.buscarProfesorPorLegajo(legajo);
    }

    //============================================
    //              METODOS MATERIA
    //============================================


    /// Cargar una materia nueva
    public void agregarMateria(Materia materia)
    {
        gestorMateria.agregarMateria(materia);
    }
    /// Devolvemos una cadena de caracteres Con las materias que esten cargadas
    public String listarMaterias()
    {
        return gestorMateria.listarMaterias();
    }

    public boolean eliminarMateriaPorId( int id)
    {
        return gestorMateria.eliminarMateriaPorId(id);
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

    public String verReservasMes(EnumMes mes)
    {
        return reservaMes.accederAMes(mes);
    }

    public String verReservas()
    {
        return  reservaMes.toString();
    }

    public String verReservasDiaDeterminado(EnumDia dia)
    {
        return reservaMes.verReservaDiaDeterminado(dia);
    }

    public String verReservaSemanaDeterminada(EnumSemana semana)
    {
        return  reservaMes.verReservaSemana(semana);
    }



    public String buscarYretornarProfeYAula(Profesor profe){
        StringBuilder builder =new StringBuilder();
        builder.append(reservaMes.retornoProfesorPorMes(profe));
        return builder.toString();
    }




}
