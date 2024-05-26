import Aula.AulaComputadora;
import Enumeradores.EnumDia;
import Enumeradores.EnumHorarios;
import Enumeradores.EnumMes;
import Enumeradores.EnumSemana;
import GestorColeccion.GestionColeccion;
import GestorColeccion.GestorProfesor;
import Reserva.ManejoDias;
import Aula.*;
import Reserva.*;
import Universidad.net.Materia;
import Universidad.net.Profesor;

import java.util.Scanner;

public class Main {
    public static void main(String [] args)
    {
        /*Universidad miUniversidad = new Universidad();
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
        Materia materia = new Materia("Matematica",profesor);

        System.out.println(miReserva.agregar(EnumDia.LUNES, EnumHorarios.DIEZTREINTA_A_TRECE,new AulaComputadora(101,20,false,false,true,10,false),materia));

        miReserva.agregar(EnumDia.MARTES,EnumHorarios.OCHOTREINTA_A_DIEZTREINTA,aux,materia);
        System.out.println(miReserva.agregar(EnumDia.JUEVES,EnumHorarios.OCHOTREINTA_A_DIEZTREINTA,new AulaComputadora(101,20,false,false,true,10,false),materia));
        System.out.println(miReserva.agregar(EnumDia.LUNES, EnumHorarios.DIEZTREINTA_A_TRECE,new AulaComputadora(102,20,false,false,true,10,false),materia));
        miReserva.agregar(EnumDia.LUNES, EnumHorarios.OCHOTREINTA_A_DIEZTREINTA,new AulaComputadora(102,20,false,false,true,10,false),materia);
        //miReserva.cancelarReserva("Lunes","10",new AulaComputadora(101,20,false,false,true,10,false));
        System.out.println(miReserva.toString());

        ReservaPorSemana semanal = new ReservaPorSemana();
        semanal.agregar(EnumSemana.SEMANA1,EnumDia.MARTES,EnumHorarios.OCHOTREINTA_A_DIEZTREINTA,aux,materia);
        semanal.agregar(EnumSemana.SEMANA1,EnumDia.JUEVES,EnumHorarios.OCHOTREINTA_A_DIEZTREINTA,aux,materia);
        semanal.agregar(EnumSemana.SEMANA1,EnumDia.VIERNES,EnumHorarios.OCHOTREINTA_A_DIEZTREINTA,aux,materia);
        semanal.agregar(EnumSemana.SEMANA1,EnumDia.MARTES,EnumHorarios.QUINCETREINTA_A_DIECIOCHO,aux,materia);
        semanal.agregar(EnumSemana.SEMANA2,EnumDia.MARTES,EnumHorarios.OCHOTREINTA_A_DIEZTREINTA,aux,materia);

        System.out.println("\t\t\t\t\n\n\n\n\n\n\n\nCREACION DE MES");
        ReservaPorMes mes= new ReservaPorMes();
        mes.agregar(EnumMes.ENERO,EnumSemana.SEMANA1,EnumDia.MARTES,EnumHorarios.OCHOTREINTA_A_DIEZTREINTA,aux,materia);
        mes.agregar(EnumMes.ENERO,EnumSemana.SEMANA2,EnumDia.MIERCOLES,EnumHorarios.OCHOTREINTA_A_DIEZTREINTA,aux,materia);
        mes.agregar(EnumMes.ENERO,EnumSemana.SEMANA2,EnumDia.JUEVES,EnumHorarios.OCHOTREINTA_A_DIEZTREINTA,aux,materia);
        mes.agregar(EnumMes.FEBRERO,EnumSemana.SEMANA2,EnumDia.MARTES,EnumHorarios.OCHOTREINTA_A_DIEZTREINTA,aux,materia);
        mes.agregar(EnumMes.FEBRERO,EnumSemana.SEMANA2,EnumDia.MARTES,EnumHorarios.OCHOTREINTA_A_DIEZTREINTA,aux,materia);
        mes.agregar(EnumMes.FEBRERO,EnumSemana.SEMANA3,EnumDia.MARTES,EnumHorarios.OCHOTREINTA_A_DIEZTREINTA,aux,materia);
        System.out.println("\t\t\t\t\t\n\n\n\nMOSTRANDO MES ENERO");
        System.out.println(mes.accederAMes(EnumMes.ENERO));
        System.out.println("\t\t\t\t\t\n\n\n\nMOSTRANDO MES FEBRERO");
        System.out.println(mes.accederAMes(EnumMes.FEBRERO));

        Universidad universidad1=new Universidad();
        Aula aula1=new AulaComputadora(101,20,false,false,true,10,false);
        Aula aula2=new AulaComputadora(202,20,false,false,false,10,false);

        universidad1.agregarAula(aula1);
        universidad1.agregarAula(aula2);
        universidad1.agregarAula(new AulaComputadora(303,20,false,false,false,10,false));

        universidad1.cargarProfesor(new Profesor("Pepe","Argento",1));
        Materia materia1=new Materia("Programacion",new Profesor("Pepe","Argento",1));
        universidad1.agregarReserva(EnumMes.MARZO,1,EnumDia.LUNES,EnumHorarios.OCHOTREINTA_A_DIEZTREINTA,aula1,materia1);
        System.out.println("\t\t\t\t\t\n\n\n\nMOSTRANDO DONDE LABURA EL PROFE CON SUS HORARIOS");
        System.out.println(mes.retornoProfesorPorMes(profesor));*/
            menu();

    }



public static void menu() {
    Universidad universidad = new Universidad();

    // universidad.leerArchivoGestores();

    int opcion;
    Scanner entrada = new Scanner(System.in);
    do {
        String cadena = """
                \tBienvenido al menú
                \t[1] Aulas
                \t[2] Reservas
                \t[3] Profesores
                \t[4] Materias
                \t[0] Salir
                """;
        System.out.println(cadena);
        while (!entrada.hasNextInt()) {
            System.out.println("Entrada no válida. Por favor, ingrese un número: ");
            entrada.next();
        }
        opcion = entrada.nextInt();
        entrada.nextLine();
        switch (opcion) {
            case 1 -> menuAulas(entrada, universidad);
            case 2 -> menuReservas(entrada,universidad);
            case 3 -> menuProfesor(entrada,universidad);
            case 4 -> menuMateria(entrada,universidad);
            case 0 -> System.out.println("Saliendo...");
            default -> System.out.println("Opción inválida");
        }
    } while (opcion != 0);
}


//========================== METODOS AULA=============================================

public static void menuAulas(Scanner entrada, Universidad universidad) {
    int opcion;
    do {
        String cadena = """
                \tSeleccione una opción
                \t[1] Ver aulas
                \t[2] Cargar aulas
                \t[0] Menú anterior
                """;
        System.out.println(cadena);
        while (!entrada.hasNextInt()) {
            System.out.println("Entrada no válida. Por favor, ingrese un número: ");
            entrada.next();
        }
        opcion = entrada.nextInt();
        entrada.nextLine();
        switch (opcion) {
            case 1 -> verAulas(entrada, universidad);
            case 2 -> menuCargarAula(entrada, universidad);
            case 0 -> System.out.println("Volviendo al menú anterior...");
            default -> System.out.println("Opción inválida");
        }
    } while (opcion != 0);
}

public static void verAulas(Scanner entrada, Universidad universidad) {
    int opcion;
    do {
        String cadena = """
                \t Menú aula
                \t[1] Ver aulas con computadora
                \t[2] Ver aulas normales
                \t[3] Ver aulas disponibles
                \t[4] Ver todas las aulas
                \t[0] Salir
                """;
        System.out.println(cadena);
        while (!entrada.hasNextInt()) {
            System.out.println("Entrada no válida. Por favor, ingrese un número: ");
            entrada.next();
        }
        opcion = entrada.nextInt();
        entrada.nextLine();
        switch (opcion) {
            case 1 -> System.out.println(universidad.verAulasComputadoras());
            case 2 -> System.out.println(universidad.verAulasNormales());
            case 3 -> System.out.println(universidad.verAulasDisponibles());
            case 4 -> System.out.println(universidad.listarAulas());
            case 0 -> System.out.println("Saliendo...");
            default -> System.out.println("Opción inválida");
        }
    } while (opcion != 0);
}

public static void menuCargarAula(Scanner entrada, Universidad universidad) {
    int opcion;
    do {
        String cadena = """
                \tSeleccione el tipo de aula que desea cargar
                \t[1] Aula con computadora
                \t[2] Aula normal
                \t[0] Menú anterior
                """;
        System.out.println(cadena);
        while (!entrada.hasNextInt()) {
            System.out.println("Entrada no válida. Por favor, ingrese un número: ");
            entrada.next();
        }
        opcion = entrada.nextInt();
        entrada.nextLine();
        switch (opcion) {
            case 1 -> cargarAulaComputadora(entrada, universidad);
            case 2 -> cargarAulaNormal(entrada, universidad);
            case 0 -> System.out.println("Volviendo al menú anterior...");
            default -> System.out.println("Opción inválida");
        }
    } while (opcion != 0);
}

public static void cargarAulaComputadora(Scanner entrada, Universidad universidad) {
    int opcion;
    do {
        System.out.println("Número de aula: ");
        while (!entrada.hasNextInt()) {
            System.out.println("Entrada no válida. Por favor, ingrese un número: ");
            entrada.next();
        }
        int numeroAula = entrada.nextInt();
        entrada.nextLine();

        System.out.println("Capacidad del aula: ");
        while (!entrada.hasNextInt()) {
            System.out.println("Entrada no válida. Por favor, ingrese un número: ");
            entrada.next();
        }
        int capacidad = entrada.nextInt();
        entrada.nextLine();

        System.out.println("Cantidad de computadoras: ");
        while (!entrada.hasNextInt()) {
            System.out.println("Entrada no válida. Por favor, ingrese un número: ");
            entrada.next();
        }
        int cantidad = entrada.nextInt();
        entrada.nextLine();

        System.out.println("¿Con proyector? (true/false): ");
        while (!entrada.hasNextBoolean()) {
            System.out.println("Entrada no válida. Por favor, ingrese true o false: ");
            entrada.next();
        }
        boolean proyector = entrada.nextBoolean();
        entrada.nextLine();

        System.out.println("¿Con televisor? (true/false): ");
        while (!entrada.hasNextBoolean()) {
            System.out.println("Entrada no válida. Por favor, ingrese true o false: ");
            entrada.next();
        }
        boolean tele = entrada.nextBoolean();
        entrada.nextLine(); //BORRA RESTO DEL BUFFER

        System.out.println("¿El aula estará disponible? (true/false): ");
        while (!entrada.hasNextBoolean()) {
            System.out.println("Entrada no válida. Por favor, ingrese true o false: ");
            entrada.next();
        }
        boolean disponible = entrada.nextBoolean();
        entrada.nextLine();

        System.out.println("¿Tiene auriculares? (true/false): ");
        while (!entrada.hasNextBoolean()) {
            System.out.println("Entrada no válida. Por favor, ingrese true o false: ");
            entrada.next();
        }
        boolean auriculares = entrada.nextBoolean();
        entrada.nextLine();

        Aula aula = new AulaComputadora(numeroAula, capacidad, proyector, tele, disponible, cantidad, auriculares);
        universidad.agregarAula(aula);

        do {
            System.out.println("¿Desea cargar otra aula? (1: Sí, 0: No): ");
            while (!entrada.hasNextInt()) {
                System.out.println("Entrada no válida. Por favor, ingrese 1 para Sí o 0 para No: ");
                entrada.next();
            }
            opcion = entrada.nextInt();
            entrada.nextLine(); // Consumir el salto de línea
            if (opcion != 1 && opcion != 0) {
                System.out.println("Entrada no válida. Por favor, ingrese 1 para Sí o 0 para No: ");
            }
        } while (opcion != 1 && opcion != 0);

    } while (opcion != 0);
}

public static void cargarAulaNormal(Scanner entrada, Universidad universidad)
    {
        int opcion;
        do {
            opcion= entrada.nextInt();
            System.out.println("Número de aula: ");
            while (!entrada.hasNextInt()) {
                System.out.println("Entrada no válida. Por favor, ingrese un número: ");
                entrada.next();
            }
            int numeroAula = entrada.nextInt();
            System.out.println("Capacidad del aula: ");
            while(!entrada.hasNextInt())
            {
                System.out.println("Entrada no válida. Por favor, ingrese un número: ");
                entrada.next();
            }
            int capacidad = entrada.nextInt();

            System.out.println("¿Con proyector? (true/false): ");
            while (!entrada.hasNextBoolean()) {
                System.out.println("Entrada no válida. Por favor, ingrese true o false: ");
                entrada.next();
            }
            boolean proyector = entrada.nextBoolean();

            System.out.println("¿Con televisor? (true/false): ");
            while (!entrada.hasNextBoolean()) {
                System.out.println("Entrada no válida. Por favor, ingrese true o false: ");
                entrada.next();
            }
            boolean tele = entrada.nextBoolean();

            System.out.println("¿El aula estará disponible? (true/false): ");
            while(!entrada.hasNextBoolean())
            {
                System.out.println("Entrada no válida, ingrese true o false : ");
            }
            boolean disponible = entrada.nextBoolean();

            Aula aula=new AulaNormal(numeroAula,capacidad,proyector,tele,disponible);
            universidad.agregarAula(aula);
            do {
                System.out.println("¿Desea cargar otra aula? (1: Sí, 0: No): ");
                while (!entrada.hasNextInt()) {
                    System.out.println("Entrada no válida. Por favor, ingrese 1 para Sí o 0 para No: ");
                    entrada.next();
                }
                opcion = entrada.nextInt();
                if (opcion != 1 && opcion != 0) {
                    System.out.println("Entrada no válida. Por favor, ingrese 1 para Sí o 0 para No: ");
                }
            } while (opcion != 1 && opcion != 0);

        }while(opcion!=0);

    }


    //==============================METODOS RESERVA========================================
    public static void menuReservas(Scanner entrada, Universidad universidad)
    {
        int opcion;
        do {
            String cadena= """
                \t Elija una opcion
                \t[1] Ver reservas 
                \t[2] Agregar reserva
                \t[3] Cancelar reserva
                \t[0] Salir
                """;
            System.out.println(cadena);
            while (!entrada.hasNextInt()) {
                System.out.println("Entrada no válida. Por favor, ingrese un número: ");
                entrada.next();
            }
            opcion = entrada.nextInt();
            switch (opcion)
            {

            }
        }while(opcion!=0);

    }


    public  static void verReservas(Scanner entrada, Universidad universidad)
    {
        int opcion;
        do {
            String cadena= """
                \t Elija una opcion
                \t[1] Ver todas las reservas 
                \t[2] Ver reservas de dia determinado
                \t[3] Ver reservas de semana determinada
                \t[4] Ver reservas de mes determinado
                \t[0] Ver reservas de profesor
                """;
            System.out.println(cadena);
            while (!entrada.hasNextInt()) {
                System.out.println("Entrada no válida. Por favor, ingrese un número: ");
                entrada.next();
            }
            opcion = entrada.nextInt();
            switch (opcion)
            {
                case 1 -> System.out.println("");
                case 2 -> System.out.println(" ");
                case 3 -> System.out.println( " ");
                case 4 -> reservaMes(entrada,universidad);

            }
        }while(opcion!=0);

    }

    public static void reservaMes(Scanner entrada, Universidad universidad) {
        System.out.println("Ingrese el mes: ");
        while (!entrada.hasNextLine()) {
            System.out.println("Opcion invalida. Por favor, ingrese el mes: ");
            entrada.nextLine();
        }
        String mesString = entrada.nextLine();
        try {
            EnumMes mes = EnumMes.valueOf(mesString.toUpperCase());
            universidad.verReservasMes(mes);

        } catch (IllegalArgumentException e) {
            System.out.println("Mes ingresado no valido. Por favor, ingrese un mes valido.");

        }
    }

    public static void verReservasProfesor(Scanner entrada, Universidad universidad)
    {
        verListadoProfesores(universidad);
        
    }



    //===================================== PROFESOR=========================================

    public static void menuProfesor(Scanner entrada, Universidad universidad)
    {
        int opcion;
        do {
            String cadena ="""
            \t Seleccione una opcion
            \t[1] Cargar profesor
            \t[2] Ver listado de profesores
            \t[3] Dar de baja profesor
            \t[0] Salir
            """;
            System.out.println(cadena);
            while(!entrada.hasNextInt())
            {
                System.out.println("Entrada no válida. Por favor, ingrese un número: ");
                entrada.nextLine();
            }
            opcion= entrada.nextInt();
            switch (opcion)
            {
                case 1 ->cargaProfesor(entrada,universidad);
                case 2-> verListadoProfesores(universidad);
                case 3 ->darDeBajaProfesor(entrada,universidad);
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }
        }while(opcion!=0);


    }

    public static void cargaProfesor(Scanner entrada, Universidad universidad)
    {
        System.out.println("Ingrese el nombre ");
        while(!entrada.hasNextLine())
        {
            System.out.println("Entrada no valida. Por favor ingrese un String");
            entrada.nextLine();
        }
        entrada.nextLine();
        String nombre=entrada.nextLine();

        System.out.println("Ingrese el apellido : ");
        while(!entrada.hasNextLine())
        {
            System.out.println("Entrada no valida. Por favor ingrese un String");
            entrada.nextLine();
        }
        String apellido=entrada.nextLine();

        System.out.println("Ingrese el numero de legajo : ");
        while(!entrada.hasNextLine())
        {
            System.out.println("Entrada no valida. Por favor ingrese un entero");
            entrada.nextLine();
        }
        int numeroLegajo=entrada.nextInt();

        Profesor profesor= new Profesor(nombre,apellido,numeroLegajo);

        universidad.cargarProfesor(profesor);
    }

    public static void verListadoProfesores(Universidad universidad)
    {
        System.out.println(universidad.listarProfesores());
    }

    public static void darDeBajaProfesor(Scanner entrada, Universidad universidad) {

        verListadoProfesores(universidad);
        System.out.println("\n \nIngrese el legajo del profesor que desea dar de baja: ");
        while (!entrada.hasNextInt()) {
            System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
            entrada.nextLine();
        }
        int legajo = entrada.nextInt();
        boolean eliminado = universidad.eliminarProfesorPorLegajo(legajo);
        if (eliminado) {
            System.out.println("Profesor dado de baja correctamente.");
        } else {
            System.out.println("No se encontró ningún profesor con ese legajo.");
        }
    }


    //================================ Materias====================================
    public static void menuMateria(Scanner entrada, Universidad universidad)
    {
        int opcion;
        do {
            String cadena ="""
            \t Seleccione una opcion
            \t[1] Cargar materia
            \t[2] Ver listado de materias
            \t[3] Dar de baja materia
            \t[0] Salir
            """;
            System.out.println(cadena);
            while(!entrada.hasNextInt())
            {
                System.out.println("Entrada no válida. Por favor, ingrese un número: ");
                entrada.nextLine();
            }
            opcion= entrada.nextInt();
            switch (opcion)
            {
                case 1 ->cargarMateria(entrada,universidad);
                case 2-> verListadoDeMaterias(universidad);
                case 3 ->darDeBajaMateria(entrada,universidad);
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }
        }while(opcion!=0);


    }

    public static void cargarMateria(Scanner entrada, Universidad universidad) {

        GestorProfesor gestorProfesor= new GestorProfesor();
        System.out.println("Ingrese el nombre de la materia: ");
        entrada.nextLine();
        String nombre = entrada.nextLine();


        System.out.println("Profesores disponibles:");
        System.out.println(universidad.listarProfesores());

        System.out.println("Ingrese el número de legajo del profesor para esta materia: ");
        while (!entrada.hasNextInt()) {
            System.out.println("Entrada no válida. Por favor, ingrese un número de legajo: ");
            entrada.next();
        }
        int legajoProfesor = entrada.nextInt();
        entrada.nextLine();


        Profesor profesor = universidad.buscarProfesorPorLegajo(legajoProfesor);

        if (profesor != null) {
            Materia materia = new Materia(nombre, profesor);
            universidad.agregarMateria(materia);
            System.out.println("Materia cargada correctamente.");
        } else {
            System.out.println("No se encontro ningun profesor con el numero de legajo proporcionado.");
        }
    }

    public static void verListadoDeMaterias(Universidad universidad)
    {
        System.out.println(universidad.listarMaterias());
    }

    public static void darDeBajaMateria(Scanner entrada, Universidad universidad) {

        verListadoDeMaterias(universidad);
        System.out.println("\n \nIngrese el ID de la materia  que desea dar de baja: ");
        while (!entrada.hasNextInt()) {
            System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
            entrada.nextLine();
        }
        int id = entrada.nextInt();
        boolean eliminado = universidad.eliminarMateriaPorId(id);
        if (eliminado) {
            System.out.println("Profesor dado de baja correctamente.");
        } else {
            System.out.println("No se encontró ningún profesor con ese legajo.");
        }
    }
}
