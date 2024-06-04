import Aula.AulaComputadora;
import Enumeradores.EnumDia;
import Enumeradores.EnumHorarios;
import Enumeradores.EnumMes;
import Enumeradores.EnumSemana;
import GestorColeccion.GestionColeccion;
import GestorColeccion.GestorProfesor;
import JsonUtil.JsonUtil;
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


    //===================================================================

    public static void menu() {
        Universidad universidad = new Universidad();


        //universidad.cargarArchivoGestores();
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
                \t[6] Cargar archivo
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
                case 6 -> cargarJson(universidad);
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 0);

        // Guardar los datos en los archivos al salir
        universidad.cargarArchivoGestores();

    }

    //===================================================================
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

    //===================================================================
    public static void cargarJson(Universidad universidad)
    {
        try
        {
            JsonUtil.grabar(universidad.toJson(),"ArchivoJson");
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
                \t[3] Eliminar aulas
                \t[4] Modificar aulas
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
                case 3 -> eliminarAula(entrada,universidad);
                case 4 -> modificarAula(entrada,universidad);
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
                \t[3] Ver todas las aula
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
                case 3 -> System.out.println(universidad.listarAulas());
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

    public static void modificarAula(Scanner entrada ,Universidad universidad)
    {
        int opcion;
        do {
            String cadena = """
                Ingrese el tipo de aula que desea modificar 
                \t[1]Aulas con computadora
                \t[2]Aulas normales
                \t[0]Salir
                """;
            System.out.println(cadena);
            while(!entrada.hasNextInt())
            {
                System.out.println("Entrada no valida");
                entrada.next();
            }
            opcion=entrada.nextInt();
            switch (opcion)
            {
                case 1 -> modificarAulaComputadora(entrada,universidad);
                case 2 -> modificarAulaNormal(entrada,universidad);
                case 0 -> System.out.println("Volviendo al menu anterior..");
                default -> System.out.println("Opcion invalida");
            }
        }while(opcion!=0);


    }

    //===================================================================
    public static void modificarAulaNormal(Scanner entrada, Universidad universidad) {
        boolean aulasCargadas = true;
        String aulasListado = universidad.verAulasNormales();
        System.out.println(aulasListado);

        if (aulasListado.contains("No hay aulas normales cargadas")) {
            System.out.println("Volviendo al menú anterior...");
            aulasCargadas = false;
        }

        if (aulasCargadas) {
            boolean aulaValida = false;
            while (!aulaValida) {
                System.out.println("Ingrese el id del aula: ");
                while (!entrada.hasNextInt()) {
                    System.out.println("Entrada no válida");
                    entrada.next();
                }
                int id = entrada.nextInt();
                boolean existencia = universidad.validarExistenciaDeAula(id);

                if (!existencia) {
                    System.out.println("El aula no se encontró");
                } else {
                    aulaValida = true;
                    System.out.println("Ingrese la capacidad: ");
                    while (!entrada.hasNextInt()) {
                        System.out.println("Entrada no válida");
                        entrada.next();
                    }
                    int capacidad = entrada.nextInt();

                    System.out.println("Televisor (true/false): ");
                    while (!entrada.hasNextBoolean()) {
                        System.out.println("Entrada no válida");
                        entrada.next();
                    }
                    boolean tele = entrada.nextBoolean();

                    System.out.println("Proyector (true/false): ");
                    while (!entrada.hasNextBoolean()) {
                        System.out.println("Entrada no válida");
                        entrada.next();
                    }
                    boolean proyector = entrada.nextBoolean();

                    System.out.println(universidad.modificarAulaNormal(id, capacidad, tele, proyector));
                }
            }
        }
    }
    //===================================================================
    public static void modificarAulaComputadora(Scanner entrada, Universidad universidad) {
        boolean aulasCargadas = true;
        String aulasListado = universidad.verAulasComputadoras();
        System.out.println(aulasListado);

        if (aulasListado.contains("No hay aulas con computadoras cargadas")) {
            System.out.println("Volviendo al menú anterior...");
            aulasCargadas = false;
        }

        if (aulasCargadas) {
            int intentos = 0; // Contador de intentos
            boolean aulaValida = false;
            while (!aulaValida && intentos < 3) { // Mientras no se encuentre un aula válida y no se hayan superado 3 intentos
                System.out.println("Ingrese el id del aula de computadoras que desea modificar: ");
                while (!entrada.hasNextInt()) {
                    System.out.println("Entrada no válida");
                    entrada.next();
                }
                int id = entrada.nextInt();

                // Verificar si el aula es realmente un aula de computadoras
                boolean esAulaComputadora = universidad.validarAulaComputadora(id);

                if (!esAulaComputadora) {
                    System.out.println("El aula no es un aula de computadoras");
                    intentos++; // Incrementar el contador de intentos
                } else {
                    aulaValida = true;
                    // Continuar con la modificación del aula de computadoras
                    System.out.println("Ingrese la capacidad: ");
                    while (!entrada.hasNextInt()) {
                        System.out.println("Entrada no válida");
                        entrada.next();
                    }
                    int capacidad = entrada.nextInt();

                    System.out.println("Ingrese cantidad de computadoras: ");
                    while (!entrada.hasNextInt()) {
                        System.out.println("Entrada no válida");
                        entrada.next();
                    }
                    int cantidadCompus = entrada.nextInt();

                    System.out.println("Televisor (true/false): ");
                    while (!entrada.hasNextBoolean()) {
                        System.out.println("Entrada no válida");
                        entrada.next();
                    }
                    boolean tele = entrada.nextBoolean();

                    System.out.println("Proyector (true/false): ");
                    while (!entrada.hasNextBoolean()) {
                        System.out.println("Entrada no válida");
                        entrada.next();
                    }
                    boolean proyector = entrada.nextBoolean();

                    System.out.println("Auriculares (true/false): ");
                    while (!entrada.hasNextBoolean()) {
                        System.out.println("Entrada no válida");
                        entrada.next();
                    }
                    boolean auriculares = entrada.nextBoolean();

                    System.out.println(universidad.modificarAulaComputadora(id, capacidad, cantidadCompus, tele, proyector, auriculares));
                }
            }

            if (intentos >= 3) {
                System.out.println("Se supero el número máximo de intentos. Volviendo al menú anterior...");
            }
        }
    }

    //===================================================================
    public static void cargarAulaComputadora(Scanner entrada, Universidad universidad) {
        int opcion=-1;
        int intentos = 0;
        boolean continuar = true;

        do {

            int numeroAula;
            do {
                System.out.println("Número de aula: ");
                while (!entrada.hasNextInt()) {
                    System.out.println("Entrada no válida. Por favor, ingrese un número: ");
                    entrada.next();
                }
                numeroAula = entrada.nextInt();
                entrada.nextLine();
                intentos++;
            } while (universidad.validarExistenciaDeAula(numeroAula) && intentos < 3);

            if (intentos >= 3) {
                System.out.println("Supero el máximo de intentos permitidos. Por favor, intentelo nuevamente");
                continuar = false;
            } else {
                System.out.println("Capacidad del aula: ");
                while (!entrada.hasNextInt()) {
                    System.out.println("Entrada no válida. Por favor, ingrese un número: ");
                    entrada.next();
                }
                int capacidad = entrada.nextInt();
                entrada.nextLine();

                System.out.println("Cantidad de computadoras: ");
                int validador = 0;
                int cantidad = 0;
                while (validador == 0){
                    while (!entrada.hasNextInt()) {
                        System.out.println("Entrada no válida. Por favor, ingrese un número: ");
                        entrada.next();
                    }
                    cantidad = entrada.nextInt();
                    if (cantidad>0){
                        validador=1;
                    }else{
                        System.out.println("El numero ("+ cantidad + ") es un numero no valido, porfavor ingrese un numero enero positivo");
                    }

                    entrada.nextLine();
                }


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
                entrada.nextLine();

                System.out.println("¿Tiene auriculares? (true/false): ");
                while (!entrada.hasNextBoolean()) {
                    System.out.println("Entrada no válida. Por favor, ingrese true o false: ");
                    entrada.next();
                }
                boolean auriculares = entrada.nextBoolean();
                entrada.nextLine();

                Aula aula = new AulaComputadora(numeroAula, capacidad, proyector, tele, cantidad, auriculares);
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
                        System.out.println("Entrada no valida. Por favor, ingrese 1 para Sí o 0 para No: ");
                    }
                } while (opcion != 1 && opcion != 0);
            }
        } while (opcion != 0 && continuar);
    }

    //===================================================================
    public static void cargarAulaNormal(Scanner entrada, Universidad universidad) {

        boolean continuar = true;
        int opcion=0;

        do {

            int intentos = 0;
            int numeroAula;
            do {
                System.out.println("Número de aula: ");

                while (!entrada.hasNextInt()) {
                    System.out.println("Entrada no válida. Por favor, ingrese un número: ");
                    entrada.next();
                }
                numeroAula = entrada.nextInt();
                intentos++;
            } while (universidad.validarExistenciaDeAula(numeroAula) && intentos < 3);

            if (intentos >= 3) {
                System.out.println("Superó el máximo de intentos permitidos. Por favor inténtelo nuevamente.");
                continuar = false;
            } else {
                System.out.println("Capacidad del aula: ");
                while (!entrada.hasNextInt()) {
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

                Aula aula = new AulaNormal(numeroAula, capacidad, proyector, tele);
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
            }
        } while (opcion != 0 && continuar);
    }

    //===================================================================
    public static void eliminarAula(Scanner entrada, Universidad universidad)
    {
            if(universidad.listarAulas().contains("No hay aulas cargadas"))
            {
                System.out.println("No hay aulas cargadas");
            }
            else
            {
                System.out.println(universidad.listarAulas());
                System.out.println("Ingrese el numero de aula a eliminar: ");
                while(!entrada.hasNextInt())
                {
                    System.out.println("Entrada no valida");
                    entrada.next();
                }
                int numeroAula = entrada.nextInt();
                System.out.println(universidad.eliminarAula(numeroAula));
            }



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
            if (opcion == 2){
                if (universidad.isAulas()){
                    opcion=5;
                    System.out.println("No se puede realizar una reserva si no hay aulas cargadas previamente, porfavor ingrese al menu de aulas y cree una para realizar la reserva");
                }
            }
            switch (opcion)
            {
                case 1 -> verReservas(entrada,universidad);
                case 2 ->agregarReserva(entrada,universidad);
                case 3 -> cancelarReserva(entrada,universidad);
                case 0 -> System.out.println("Saliendo ..");
                default -> System.out.println("Opcion invalida");
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
                case 5 -> verReservasProfesor(entrada,universidad);
                case 0 -> System.out.println("Volviendo al menu anterior");
                default -> System.out.println("Opcion invalida");

            }
        }while(opcion!=0);

    }

    //===================================================================
    public static void verTodasLasReservas(Scanner entrada, Universidad universidad)
    {
        if(universidad.verReservas().isEmpty())
        {
            System.out.println("Aun no hay reservas realizadas");
        }
        System.out.println(universidad.verReservas());
    }
    //===================================================================
    public static void verReservaDiaDeterminado(Scanner entrada, Universidad universidad)
    {
        System.out.println("Ingrese el mes (elija una de las siguientes opciones): ");
        for(EnumMes mesEnum : EnumMes.values())
        {
            System.out.println(mesEnum.name());
        }
        EnumMes mes = null;
        while (mes == null) {
            String mesString = entrada.nextLine();
            try {
                mes = EnumMes.valueOf(mesString.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Día ingresado no válido. Por favor, ingrese un día válido.");
            }
        }

        System.out.println("Ingrese el semana (elija una de las siguientes opciones): ");
        for(EnumSemana semanaEnum : EnumSemana.values())
        {
            System.out.println(semanaEnum.name());
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
        if(universidad.verReservasDiaDeterminado(mes,semana,dia).isEmpty())
        {
            System.out.println("No hay reservas para la fecha ingersada");
        }
        else
        {
            System.out.println(universidad.verReservasDiaDeterminado(mes,semana,dia));
        }

    }
    //===================================================================
    public static void verReservaSemanaDeterminado(Scanner entrada, Universidad universidad)
    {

        System.out.println("Ingrese el mes  (elija una de las siguientes opciones): ");
        for (EnumMes mes : EnumMes.values()) {
            System.out.println(mes.name());
        }
        EnumMes mes = null;
        while (mes == null) {
            String semanaString = entrada.nextLine();
            try {
                mes = EnumMes.valueOf(semanaString.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Día ingresado no válido. Por favor, ingrese un día válido.");
            }
        }


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
        System.out.println(universidad.verReservaSemanaDeterminada(mes,semana));
    }
    //===================================================================
    public static void reservaMes(Scanner entrada, Universidad universidad) {
        System.out.println("Ingrese el mes (elija una de las siguientes opciones): ");
        for(EnumMes mesEnum : EnumMes.values())
        {
            System.out.println(mesEnum.name());
        }
        EnumMes mes = null;
        while (mes == null) {
            String mesString = entrada.nextLine();
            try {
                mes = EnumMes.valueOf(mesString.toUpperCase());
                System.out.println(universidad.verReservasMes(mes));
            } catch (IllegalArgumentException e) {
                System.out.println("Día ingresado no válido. Por favor, ingrese un día válido.");
            }
        }

    }
    //===================================================================
    public static void verReservasProfesor(Scanner entrada, Universidad universidad)
    {
        System.out.println(universidad.listarProfesores());
        System.out.println("Ingrese el ID del profesor : ");
        while (!entrada.hasNextInt())
        {
            System.out.println("Entrada no valida");
            entrada.next();
        }
        int idProfesor= entrada.nextInt();
        System.out.println(universidad.buscarYretornarProfeYAula(idProfesor));

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
            System.out.println("Usted tiene disponible las siguientes aulas = " + universidad.renotarAulasDisponiblesParaHoraEspecifica(mes,semana,dia,hora));
            while (!entrada.hasNextInt()) {
                System.out.println("Entrada no válida. Por favor, ingrese un número de aula válido: ");
                entrada.next();
            }
            int numeroAula = entrada.nextInt();
            aula = universidad.getGestorAula().buscarAulaPorNumero(numeroAula);

            /// hacer validacion
            if (aula == null) {
                System.out.println("Aula no encontrada. Por favor, ingrese un número de aula válido.");
                intentos++;
            } else {
                aulaEncontrada = true;
            }
            entrada.nextLine();
        }

        Materia materia = null;
        if (aulaEncontrada) {
            if(universidad.getGestorMateria().listarMaterias().isEmpty())
            {
                System.out.println("No hay materias cargadas ");
            }
            else
            {
                System.out.println("Ingrese el ID de la materia: ");
                System.out.println(universidad.verMateriaDetalle()); // CODIGO AGREGADO
                while (!entrada.hasNextInt()) {
                    System.out.println("Entrada no valida. Por favor, ingrese un ID de materia válido: ");
                    entrada.next();
                }
                int idMateria = entrada.nextInt();
                materia = universidad.getGestorMateria().devolverMateria(idMateria);
                String verReserva = "No se pudo realizar";
                if (universidad.comprobarDisponibilidad(mes, semana, dia, hora, aula) && materia != null) {
                    verReserva = universidad.agregarReserva(mes, semana, dia, hora, aula, materia);
                }
                System.out.println(verReserva);
                if (materia == null){
                    System.out.println("\tNo hay materias agregadas o indico una materia que no existe");
                }
            }

        } else {
            System.out.println("No se pudo realizar la reserva debido a intentos fallidos con el número de aula.");
        }
    }

    //=======================================================================
    public static void cancelarReserva(Scanner entrada, Universidad universidad)
    {
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
        if(!universidad.cancelarReserva(mes,semana,dia,hora))
        {
            System.out.println("Reserva no encontrada");
        }
        else
        {
            System.out.println("La reserva ha sido cancelada");
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
        int intentos=0;
        boolean existe=true;
        while(intentos<3 && existe)
        {
            System.out.println("Ingrese el numero de legajo : ");
            while(!entrada.hasNextLine())
            {
                System.out.println("Entrada no valida. Por favor ingrese un entero");
                entrada.nextLine();
            }
            int numeroLegajo=entrada.nextInt();
            if(universidad.verificarExistenciaProfesor(numeroLegajo))
            {
                System.out.println("El numero de legajo ya existe ");
                intentos++;
            }
            else {

                Profesor profesor= new Profesor(nombre,apellido,numeroLegajo);
                universidad.cargarProfesor(profesor);
                existe=false;
            }

        }
        if(intentos >= 3 )
        {
            System.out.println("Volviendo al menu");
        }



    }
    //===================================================================

    public static void verListadoProfesores(Universidad universidad)
    {
        if(universidad.listarProfesores().isEmpty())
        {
            System.out.println("Aun no hay profesores cargados");
        }
        System.out.println(universidad.listarProfesores());
    }

    //===================================================================
    public static void darDeBajaProfesor(Scanner entrada, Universidad universidad) {

        verListadoProfesores(universidad);
        if(universidad.listarProfesores().isEmpty())
        {
            System.out.println("Volviendo al menu anterior...");
        }
        else
        {
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
        int comprobante = 0;
        System.out.println("Ingrese el nombre de la materia: ");
        entrada.nextLine();
        String nombre = entrada.nextLine();

        System.out.println("Profesores disponibles:");

        if(universidad.listarProfesores().isEmpty())
        {
            System.out.println("No hay profesores cargados . Volviendo al menu anterior...");
        }
        else {
            System.out.println(universidad.listarProfesores());
            int legajoProfesor;
            while (comprobante == 0){
                System.out.println("Ingrese el número de legajo del profesor para esta materia: ");
                //legajoProfesor = entrada.nextInt();

                while(!entrada.hasNextInt()){
                    System.out.println("Entrada no válida. Por favor, ingrese un número de legajo: ");
                    entrada.next();
                }
                legajoProfesor = entrada.nextInt();

                Profesor profesor = universidad.buscarProfesorPorLegajo(legajoProfesor);
                if (profesor != null){
                    Materia materia = new Materia(nombre, profesor);
                    universidad.agregarMateria(materia);
                    System.out.println("Materia cargada correctamente.");
                    comprobante=1;
                } else {
                    System.out.println("No se encontro ningun profesor con el numero de legajo proporcionado.");
                    System.out.println("Aprete 1 para voler al menu o 0 para ingresar otro legajo");
                    comprobante = entrada.nextInt();
                }
        }

        }

    }

    //===================================================================
    public static void verListadoDeMaterias(Universidad universidad)
    {
        if(universidad.listarMaterias().isEmpty()){
            System.out.println("\nLista de materias cargada no encontrada");
        }
        System.out.println(universidad.listarMaterias());
    }

    //===================================================================
    public static void darDeBajaMateria(Scanner entrada, Universidad universidad) {

        verListadoDeMaterias(universidad);
        if(universidad.listarMaterias().isEmpty())
        {
            System.out.println("Volviendo al menu anterior ...");
        }
        else
        {
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
}
