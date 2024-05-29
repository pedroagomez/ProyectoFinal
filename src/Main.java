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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Scanner;

public class Main {
    public static void main(String [] args)
    {

            menu();



    }

    public static void menu() {
        Universidad universidad = new Universidad();

        // Leer los datos de los archivos al iniciar
        universidad.cargarArchivoGestores();
        universidad.leerArchivoGestores();

        int opcion;
        Scanner entrada = new Scanner(System.in);
        do {
            String cadena = """
                \tBienvenido al menú
                \t[1] Aulas
                \t[2] Reservas
                \t[3] Profesores
                \t[4] Materias
                \t[5] Mostrar archivo
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
                case 2 -> menuReservas(entrada, universidad);
                case 3 -> menuProfesor(entrada, universidad);
                case 4 -> menuMateria(entrada, universidad);
                case 5 -> mostrarJson(universidad);
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 0);

        // Guardar los datos en los archivos al salir
        universidad.cargarArchivoGestores();
    }


    public static void mostrarJson(Universidad universidad)
    {
        try
        {
            System.out.println(universidad.toJson().toString());
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }
    //========================== METODOS AULA =============================================

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

    //===================================================================
    public static void verAulas(Scanner entrada, Universidad universidad) {
        int opcion;
        do {
            String cadena = """
                \tMenú aula
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
    //===================================================================
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
    //===================================================================
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
    //===================================================================
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
                case 1 -> verReservas(entrada,universidad);
                case 2 ->agregarReserva(entrada,universidad);
            }
        }while(opcion!=0);

    }

    //===================================================================
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
                \t[5] Ver reservas de profesor
                \t[0] Menu anterior
                """;
            System.out.println(cadena);
            while (!entrada.hasNextInt()) {
                System.out.println("Entrada no válida. Por favor, ingrese un número: ");
                entrada.next();
            }
            opcion = entrada.nextInt();
            switch (opcion)
            {
                case 1 -> verTodasLasReservas(entrada,universidad);
                case 2 -> verReservaDiaDeterminado(entrada,universidad);
                case 3 -> verReservaSemanaDeterminado(entrada,universidad);
                case 4 -> reservaMes(entrada,universidad);
                case 0 -> System.out.println("Volviendo al menu anterior");
                default -> System.out.println("Opcion invalida");

            }
        }while(opcion!=0);

    }

    //===================================================================
    public static void verTodasLasReservas(Scanner entrada, Universidad universidad)
    {
        System.out.println(universidad.verReservas());
    }
    //===================================================================
    public static void verReservaDiaDeterminado(Scanner entrada, Universidad universidad)
    {
        System.out.println("Ingrese el día (elija una de las siguientes opciones): ");
        for (EnumDia diaEnum : EnumDia.values()) {
            System.out.println(diaEnum.name());
        }
        EnumDia dia = null;
        while (dia == null) {
            String diaString = entrada.nextLine();
            try {
                dia = EnumDia.valueOf(diaString.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Día ingresado no válido. Por favor, ingrese un día válido.");
            }
        }
        System.out.println(universidad.verReservasDiaDeterminado(dia));
    }
    //===================================================================
    public static void verReservaSemanaDeterminado(Scanner entrada, Universidad universidad)
    {
        System.out.println("Ingrese la semana (elija una de las siguientes opciones): ");
        for (EnumSemana semana : EnumSemana.values()) {
            System.out.println(semana.name());
        }
        EnumSemana semana = null;
        while (semana == null) {
            String semanaString = entrada.nextLine();
            try {
                semana = EnumSemana.valueOf(semanaString.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Día ingresado no válido. Por favor, ingrese un día válido.");
            }
        }
        System.out.println(universidad.verReservaSemanaDeterminada(semana));
    }
    //===================================================================
    public static void reservaMes(Scanner entrada, Universidad universidad) {
        System.out.println("Ingrese el mes: ");
        entrada.nextLine();
        while (!entrada.hasNextLine()) {
            System.out.println("Opcion invalida. Por favor, ingrese el mes: ");
            entrada.nextLine();
        }
        String mesString = entrada.nextLine();
        try {
            EnumMes mes = EnumMes.valueOf(mesString.toUpperCase());
            System.out.println(universidad.verReservasMes(mes));

        } catch (IllegalArgumentException e) {
            System.out.println("Mes ingresado no valido. Por favor, ingrese un mes valido.");

        }
    }
    //===================================================================
    public static void verReservasProfesor(Scanner entrada, Universidad universidad)
    {


    }

    //===================================================================

    public static void agregarReserva(Scanner entrada, Universidad universidad) {

        System.out.println("Ingrese el mes (elija una de las siguientes opciones): ");
        for (EnumMes mesEnum : EnumMes.values()) {
            System.out.println(mesEnum.name());
        }
        EnumMes mes = null;
        while (mes == null) {
            String mesString = entrada.nextLine();
            //entrada.nextLine();
            try {
                mes = EnumMes.valueOf(mesString.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Mes ingresado no válido. Por favor, ingrese un mes válido.");
            }
        }


        System.out.println("Ingrese la semana (elija una de las siguientes opciones): ");
        for (EnumSemana semanaEnum : EnumSemana.values()) {
            System.out.println(semanaEnum.name());
        }
        EnumSemana semana = null;
        while (semana == null) {
            String semanaString = entrada.nextLine();
            try {
                semana = EnumSemana.valueOf(semanaString.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Semana ingresada no válida. Por favor, ingrese una semana válida.");
            }
        }


        System.out.println("Ingrese el día (elija una de las siguientes opciones): ");
        for (EnumDia diaEnum : EnumDia.values()) {
            System.out.println(diaEnum.name());
        }
        EnumDia dia = null;
        while (dia == null) {
            String diaString = entrada.nextLine();
            try {
                dia = EnumDia.valueOf(diaString.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Día ingresado no válido. Por favor, ingrese un día válido.");
            }
        }


        System.out.println("Ingrese la hora (elija una de las siguientes opciones): ");
        for (EnumHorarios horario : EnumHorarios.values()) {
            System.out.println(horario.ordinal() + 1 + ". " + horario.name() + " (" + horario.getHoraInicio() + "-" + horario.getHoraFin() + ")");
        }
        EnumHorarios hora = null;
        while (hora == null) {
            while (!entrada.hasNextInt()) {
                System.out.println("Entrada no válida. Por favor, ingrese un número: ");
                entrada.next();
            }
            int elegirHora = entrada.nextInt();
            if (elegirHora > 0 && elegirHora <= EnumHorarios.values().length) {  // al hacer un EnumHorarios.values automaticamente se crea un array
                hora = EnumHorarios.values()[elegirHora - 1];       // accedemos a la pos del array.
            } else {
                System.out.println("Hora ingresada no válida. Por favor, ingrese un número válido.");
            }
        }


        Aula aula = null;
        int intentos = 0;
        boolean aulaEncontrada = false;
        while (!aulaEncontrada && intentos < 3) {
            System.out.println("Ingrese el número de aula: ");
            while (!entrada.hasNextInt()) {
                System.out.println("Entrada no válida. Por favor, ingrese un número de aula válido: ");
                entrada.next();
            }
            int numeroAula = entrada.nextInt();
            aula = universidad.getGestorAula().buscarAulaPorNumero(numeroAula);
            if (aula == null) {
                System.out.println("Aula no encontrada. Por favor, ingrese un número de aula válido.");
                intentos++;
            } else {
                aulaEncontrada = true;
            }
            entrada.nextLine();
        }

        if (aulaEncontrada) {

            System.out.println("Ingrese el ID de la materia: ");
            while (!entrada.hasNextInt()) {
                System.out.println("Entrada no valida. Por favor, ingrese un ID de materia válido: ");
                entrada.next();
            }
            int idMateria = entrada.nextInt();
            Materia materia = null;
            while (materia == null) {
                try {
                    materia = universidad.getGestorMateria().devolverMateria(idMateria);
                } catch (IllegalArgumentException e) {
                    System.out.println("Materia no encontrada. Por favor, ingrese un ID de materia valido.");
                }
            }


            String verReserva = universidad.agregarReserva(mes, semana, dia, hora, aula, materia);
            System.out.println(verReserva);
        } else {
            System.out.println("No se pudo realizar la reserva debido a intentos fallidos con el número de aula.");
        }
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


    //===================================================================
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
    //===================================================================

    public static void verListadoProfesores(Universidad universidad)
    {
        System.out.println(universidad.listarProfesores());
    }

    //===================================================================
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

    //===================================================================
    public static void cargarMateria(Scanner entrada, Universidad universidad) {
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

    //===================================================================
    public static void verListadoDeMaterias(Universidad universidad)
    {
        if(universidad.listarMaterias().isEmpty()){
            System.out.println("\n\t\tLista de materias cargada no encontrada");
        }
        System.out.println(universidad.listarMaterias());
    }

    //===================================================================
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
