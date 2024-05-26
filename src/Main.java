import Aula.AulaComputadora;
import Enumeradores.EnumDia;
import Enumeradores.EnumHorarios;
import Enumeradores.EnumMes;
import Enumeradores.EnumSemana;
import GestorColeccion.GestionColeccion;
import Reserva.ManejoDias;
import Aula.*;
import Reserva.*;
import Universidad.net.Materia;
import Universidad.net.Profesor;

public class Main {
    public static void main(String [] args)
    {
        Universidad miUniversidad = new Universidad();
        miUniversidad.agregarAula(new AulaComputadora(101,20,false,false,true,10,false));
        miUniversidad.agregarAula(new AulaComputadora(202,20,false,false,false,10,false));
        miUniversidad.agregarAula(new AulaComputadora(303,20,false,false,false,10,false));
        //System.out.println(miUniversidad.listarAulas());
        //System.out.println(miUniversidad.aulasNoDisponibles());
        GestionColeccion<Aula> mi1 = new GestionColeccion<>();
        mi1.agregar(new AulaComputadora(101,20,false,false,true,10,false));
        ManejoDias man = new ManejoDias();
        Aula aux = new AulaComputadora(101,20,false,false,true,10,false);


        Reserva miReserva = new Reserva();
        Profesor profesor = new Profesor("Pepe","Argento",1);
        Profesor profesor2 = new Profesor("Tito","Calderon",2);
        Profesor profesor3 = new Profesor("Coscu","Nashe",3);
        Materia materia = new Materia("Matematica",profesor);
        Materia materia2 = new Materia("Economia",profesor2);
        Materia materia3 = new Materia("Laboratorio",profesor3);
        System.out.println(miReserva.agregar(EnumDia.LUNES, EnumHorarios.DIEZTREINTA_A_TRECE,new AulaComputadora(101,20,false,false,true,10,false),materia));

        miReserva.agregar(EnumDia.MARTES,EnumHorarios.OCHOTREINTA_A_DIEZTREINTA,aux,materia);
        System.out.println(miReserva.agregar(EnumDia.JUEVES,EnumHorarios.DIEZTREINTA_A_TRECE,new AulaComputadora(101,20,false,false,true,10,false),materia));
        System.out.println(miReserva.agregar(EnumDia.LUNES, EnumHorarios.DIEZTREINTA_A_TRECE,new AulaComputadora(102,20,false,false,true,10,false),materia));
        miReserva.agregar(EnumDia.LUNES, EnumHorarios.OCHOTREINTA_A_DIEZTREINTA,new AulaComputadora(102,20,false,false,true,10,false),materia);
        //miReserva.cancelarReserva("Lunes","10",new AulaComputadora(101,20,false,false,true,10,false));
        System.out.println(miReserva.toString());

        ReservaPorSemana semanal = new ReservaPorSemana();
        semanal.agregar(EnumSemana.SEMANA1,EnumDia.MARTES,EnumHorarios.OCHOTREINTA_A_DIEZTREINTA,aux,materia2);
        semanal.agregar(EnumSemana.SEMANA1,EnumDia.JUEVES,EnumHorarios.OCHOTREINTA_A_DIEZTREINTA,aux,materia);
        semanal.agregar(EnumSemana.SEMANA1,EnumDia.VIERNES,EnumHorarios.OCHOTREINTA_A_DIEZTREINTA,aux,materia3);
        semanal.agregar(EnumSemana.SEMANA1,EnumDia.MARTES,EnumHorarios.QUINCETREINTA_A_DIECIOCHO,aux,materia);
        semanal.agregar(EnumSemana.SEMANA2,EnumDia.MARTES,EnumHorarios.OCHOTREINTA_A_DIEZTREINTA,aux,materia2);

        System.out.println("\t\t\t\t\n\n\n\n\n\n\n\nCREACION DE MES");
        ReservaPorMes mes= new ReservaPorMes();
        mes.agregar(EnumMes.ENERO,EnumSemana.SEMANA1,EnumDia.MARTES,EnumHorarios.OCHOTREINTA_A_DIEZTREINTA,aux,materia);
        mes.agregar(EnumMes.ENERO,EnumSemana.SEMANA2,EnumDia.MIERCOLES,EnumHorarios.OCHOTREINTA_A_DIEZTREINTA,aux,materia);
        mes.agregar(EnumMes.ENERO,EnumSemana.SEMANA2,EnumDia.JUEVES,EnumHorarios.OCHOTREINTA_A_DIEZTREINTA,aux,materia);
        mes.agregar(EnumMes.FEBRERO,EnumSemana.SEMANA2,EnumDia.MARTES,EnumHorarios.OCHOTREINTA_A_DIEZTREINTA,aux,materia3);
        mes.agregar(EnumMes.FEBRERO,EnumSemana.SEMANA2,EnumDia.MARTES,EnumHorarios.DIEZTREINTA_A_TRECE,aux,materia2);
        aux = new AulaComputadora(169,20,false,false,true,10,false);
        mes.agregar(EnumMes.FEBRERO,EnumSemana.SEMANA2,EnumDia.MARTES,EnumHorarios.QUINCETREINTA_A_DIECIOCHO,aux,materia);
        mes.agregar(EnumMes.FEBRERO,EnumSemana.SEMANA3,EnumDia.MARTES,EnumHorarios.OCHOTREINTA_A_DIEZTREINTA,aux,materia2);
        System.out.println("\t\t\t\t\t\n\n\n\nMOSTRANDO MES ENERO");
        System.out.println(mes.accederAMes(EnumMes.ENERO));
        System.out.println("\t\t\t\t\t\n\n\n\nMOSTRANDO MES FEBRERO");
        System.out.println(mes.accederAMes(EnumMes.FEBRERO));

        /*Universidad universidad1=new Universidad();
        Aula aula1=new AulaComputadora(101,20,false,false,true,10,false);
        Aula aula2=new AulaComputadora(202,20,false,false,false,10,false);

        universidad1.agregarAula(aula1);
        universidad1.agregarAula(aula2);
        universidad1.agregarAula(new AulaComputadora(303,20,false,false,false,10,false));

        universidad1.cargarProfesor(new Profesor("Pepe","Argento",1));
        Materia materia1=new Materia("Programacion",new Profesor("Pepe","Argento",1));
        universidad1.agregarReserva(EnumMes.MARZO,1,EnumDia.LUNES,EnumHorarios.OCHOTREINTA_A_DIEZTREINTA,aula1,materia1);*/
        System.out.println("\t\t\t\t\t\n\n\n\nMOSTRANDO DONDE LABURA EL PROFE CON SUS HORARIOS");
        System.out.println(mes.retornoProfesorPorMes(profesor));
        System.out.println("\t\t\t\t\t\n\n\n\nMOSTRANDO MATER OCHO A DIEZ");
        System.out.println(mes.retornoMesEspecifico(EnumMes.FEBRERO,EnumSemana.SEMANA2,EnumDia.MARTES));


        System.out.println("\t\t\t\t\t\n\n\n\nMOSTRANDO MATERIA ESPECIFICA");

        System.out.println(mes.retornoMateriaPorMes(materia2));

    }
}
