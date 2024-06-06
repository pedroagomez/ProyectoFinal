import Enumeradores.EnumDia;
import Enumeradores.EnumHorarios;
import Enumeradores.EnumMes;
import Enumeradores.EnumSemana;
import GestorColeccion.GestorAula;
import GestorColeccion.GestorMateria;
import GestorColeccion.GestorProfesor;
import JsonUtil.JsonUtil;
import Reserva.*;
import Universidad.net.*;
import Aula.*;

import java.util.HashSet;
import java.util.LinkedList;
import Reserva.*;
import org.json.JSONArray;
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

    /// LEE EL ARCHIVO JSON Y CARGA LA RESEÑA CON LO ANTERIOR GUARDADO
    public void byJson() throws  JSONException{
        JSONObject reserva =new JSONObject(JsonUtil.leer("ArchivoJson"));
        JSONArray arrayR = new JSONArray();
        EnumMes mes;
        EnumSemana semana;
        EnumDia dia;
        EnumHorarios hora;
        arrayR=reserva.getJSONArray("Reservas");
        for(int i=0;i<arrayR.length();i++){
            JSONObject objeto1=arrayR.getJSONObject(i);
            mes=EnumMes.valueOf(objeto1.getString("Mes").toUpperCase());;
            JSONArray arrayS=objeto1.getJSONArray("Semana");
            for(int j=0;j<arrayS.length();j++){
                JSONObject object2=arrayS.getJSONObject(j);
                semana=EnumSemana.valueOf(object2.getString("Semana").toUpperCase());
                JSONArray arrayD=object2.getJSONArray("Dias");
                for(int f=0;f<arrayD.length();f++){
                    JSONObject object3=arrayD.getJSONObject(f);
                    dia=EnumDia.valueOf(object3.getString("Dia").toUpperCase());
                    JSONArray arrayH = object3.getJSONArray("Horarios");
                    for(int k=0;k<arrayH.length();k++){
                        JSONObject object4=arrayH.getJSONObject(k);
                        hora=EnumHorarios.valueOf(object4.getString("Hora").toUpperCase());
                        JSONArray arrayA = object4.getJSONArray("aulas");
                        for (int l=0;l<arrayA.length();l++){
                            JSONObject objectA=arrayA.getJSONObject(l);
                            JSONObject objetoM=objectA.getJSONObject("materia");
                            JSONObject objetoP=objetoM.getJSONObject("profesor");
                            if(objectA.has("auriculares")){
                                Aula auxA=new AulaComputadora(objectA.getInt("numeroAula"),objectA.getInt("capacidad"),objectA.getBoolean("proyector"),
                                        objectA.getBoolean("tele"),objectA.getInt("cantidad computadoras"),objectA.getBoolean("auriculares"));
                                Profesor auxP=new Profesor(objetoP.getString("nombre"),objetoP.getString("apellido"),objetoP.getInt("legajo"));
                                Materia auxM=new Materia(objetoM.getString("nombre"),auxP);
                                agregarReserva(mes,semana,dia,hora,auxA,auxM);
                            }else {
                                Aula auxA=new AulaNormal(objectA.getInt("numeroAula"),objectA.getInt("capacidad"),objectA.getBoolean("proyector"),
                                        objectA.getBoolean("tele"));
                                Profesor auxP=new Profesor(objetoP.getString("nombre"),objetoP.getString("apellido"),objetoP.getInt("legajo"));
                                Materia auxM=new Materia(objetoM.getString("nombre"),auxP);
                                agregarReserva(mes,semana,dia,hora,auxA,auxM);
                            }
                        }
                    }
                }
            }

        }

    }

    // ============================ GETTERS AND SETTERS =================================
    public GestorAula getGestorAula() {
        return gestorAula;
    }


    public GestorMateria getGestorMateria() {
        return gestorMateria;
    }




    //=================================== METODOS AULA =======================================



    /// Agregar un aula a la coleccion
    public void agregarAula(Aula aulita)
    {
        gestorAula.agregarAula(aulita.getNumeroAula(),aulita);
    }
    /// FUNCION PARA COMPROBAR LA EXISTENCIA DE UN AULA
    public boolean validarExistenciaDeAula(int numero)
    {
        return gestorAula.validarExistenciaAula(numero);
    }
    /// FUNCION PARA ELIMINAR UN AULA
    public String eliminarAula(int numero)
    {
        return gestorAula.eliminarAula(numero);
    }

    /// Veremos las aulas con computadores disponibles
    public String verAulasComputadoras()
    {
        StringBuilder builder= new StringBuilder();
        if(gestorAula.verAulasConComputadoras().isEmpty())
        {
            builder.append("No hay aulas con computadoras cargadas");
        }
        else
        {
            builder.append(gestorAula.verAulasConComputadoras()).append("\n");
        }
        return builder.toString();
    }
    /// COMPROMAOS LA EXISTENCIA DE UN AULA POR ID
    public boolean validarAulaComputadora(int id)
    {
        return gestorAula.validarAulaComputadora(id);
    }
    /// Vemos las aulas normales (La clase hija de Aula)
    public String verAulasNormales()
    {
        StringBuilder builder= new StringBuilder();
        if(gestorAula.verAulasNormales().isEmpty())
        {
            builder.append("No hay aulas normales cargadas");
        }
        else
        {
            builder.append(gestorAula.verAulasNormales()).append("\n");
        }
        return builder.toString();

    }
    /// Nos devuelve las aulas disponibles en cadena de String
    public String listarAulas()
    {
        StringBuilder builder= new StringBuilder();
        if(gestorAula.listarAulas().isEmpty())
        {
            builder.append("No hay aulas cargadas");
        }
        else
        {
            builder.append(gestorAula.listarAulas()).append("\n");
        }
        return builder.toString();
    }
    /// MODIFICAR UN AULA NORMAL
    public String modificarAulaNormal(int idAula,int capacidad,boolean tele,boolean proyector)
    {
        return gestorAula.modificarAula(idAula,capacidad,tele,proyector);
    }
    /// MODIFICAR UN AULA CON COMPUTADORA
    public String modificarAulaComputadora(int idAula, int cantidadCompus,int capacidad, boolean tele, boolean proyector,boolean auriculares)
    {
        return gestorAula.modificarAulaComputadora(idAula,capacidad,cantidadCompus,tele,proyector,auriculares);
    }
    /// FUNCION PARA VER SI TENGO AULAS CARGADAS
    public boolean isAulas(){
        return gestorAula.tengoDatos();
    }

    //=================================== METODOS PROFESOR =======================================


    // Cargar un profesor
    public void cargarProfesor(Profesor profe)
    {
        gestorProfesor.agregarProfesor(profe);
    }
    // Mostrar los profesores
    public String listarProfesores()
    {
        return gestorProfesor.listarProfesores();
    }
    /// VERIFICAR SI EXISTE EL PROFESOR CARGADO
    public boolean verificarExistenciaProfesor(int id)
    {
        return gestorProfesor.verificarExistenciaProfesor(id);
    }
    /// ELIMINAR UN PROFESOR POR LEGAJO
    public boolean eliminarProfesorPorLegajo(int legajo)
    {
        return gestorProfesor.eliminarProfesorPorLegajo(legajo);
    }
    /// Buscar y retornar un profesor por legajo
    public Profesor buscarProfesorPorLegajo(int legajo){
        return gestorProfesor.buscarProfesorPorLegajo(legajo);
    }

    //=================================== METODOS MATERIA =======================================

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
    // VEMOS UNA MATERIA EN PARTICULAR
    public String verMateriaDetalle()


    {
        return gestorMateria.verMateriaDetalle();
    }
    // ELIMINAMOS UNA MATERIA POR ID
    public boolean eliminarMateriaPorId( int id)
    {
        return gestorMateria.eliminarMateriaPorId(id);
    }

    //=================================== METODOS PROFE Y MATERIA ================================
    // VEMOS SI EXISTE EL PROFE Y MATERIA CARGADOS
    public boolean comprobarExistenciaMateriaYprofe(Materia materia, Profesor profesor){
        return  gestorMateria.compararMateriaPorString(materia,profesor);
    }


    //=================================== METODOS ARCHIVOS =======================================
    // CARGAMOS EL ARCHIVO CON LOS DATOS
    public void cargarArchivoGestores(){
        gestorAula.cargarArchivoAula();
        gestorMateria.cargarArchivoMateria();
        gestorProfesor.cargarArchivoProfesor();
    }
    // LEEMOS EL ARCHIVO CON LOS DATOS
    public void leerArchivoGestores(){
        gestorAula.leerArchivoAula();
        gestorMateria.leerArchivoMateria();
        gestorProfesor.leerArchivoProfesor();
    }


    //=================================== METODOS RESERVA =======================================
    /// AGREGAMOS LA RESERVA
    public String agregarReserva(EnumMes mes, EnumSemana numSemana, EnumDia dia, EnumHorarios hora, Aula aula, Materia materia)
    {
        return reservaMes.agregar(mes,numSemana,dia,hora,aula,materia);
    }
    /// CANCELAMOS UNA RESERVA
    public boolean cancelarReserva(EnumMes mes, EnumSemana numSemana, EnumDia dia, EnumHorarios hora)
    {
        return reservaMes.cancelarReserva(mes,numSemana,dia,hora);
    }
    /// VEMOS LAS RESERVAS DEL MES
    public String verReservasMes(EnumMes mes)
    {
        return reservaMes.accederAMes(mes);
    }

    public String verReservas()
    {
        return  reservaMes.toString();
    }
    // VEMOS LA RESERVA X DIA
    public String verReservasDiaDeterminado(EnumMes mes,EnumSemana semana, EnumDia dia)
    {
        return reservaMes.verReservaDia(dia,semana,mes);
    }
    // VEMOS LAS RESERVAS DE LA SEMANA
    public String verReservaSemanaDeterminada(EnumMes mes,EnumSemana semana)
    {
        return  reservaMes.verReservaSemana(mes,semana);
    }
    /// COMPROBAMOS DISPONIBILIDAD DEL AULA
    public boolean comprobarDisponibilidad(EnumMes mes, EnumSemana semana, EnumDia dia, EnumHorarios hora, Aula aula){
        return reservaMes.verDisponibilidad(dia,semana,mes,hora,aula);
    }
    // RETORNAMOS LAS AULAS DISPONIBLES PARA UN HORARIO QUE SE LE PASE
    public String renotarAulasDisponiblesParaHoraEspecifica (EnumMes mes, EnumSemana semana, EnumDia dia,EnumHorarios hora){
        LinkedList<Aula> misAulasCargadas = gestorAula.retornoAulas();
        StringBuilder cadenaAula = new StringBuilder();
        cadenaAula.append("Aulas sin reservar en este horario = \t\n");
        int disponibles = 0;
        int iterador = misAulasCargadas.size();
        for(int i = 0; i<iterador; i++){
            if (comprobarDisponibilidad(mes,semana,dia,hora,misAulasCargadas.get(i))){
                cadenaAula.append("Numero de aula = ").append(misAulasCargadas.get(i).getNumeroAula()).append("\t\n");
                disponibles++;
            }
        }
        if (disponibles == 0) {
            cadenaAula.setLength(0);
            cadenaAula.append("No hay aulas disponibles para este horario");
        }
        return cadenaAula.toString();
    }
    /// BUSCAMOS UN PROFESOR Y VEMOS EN QUE AULA DA CLASES
    public String buscarYretornarProfeYAula(int idProfesor){
        StringBuilder builder =new StringBuilder();
        Profesor profesor = buscarProfesorPorLegajo(idProfesor);
        if(profesor== null)
        {
            builder.append("No hay reservas del profesor " + profesor.getNombre());
        }
        else
        {
            builder.append(reservaMes.retornoProfesorPorMes(profesor));
        }

        return builder.toString();
    }
}
