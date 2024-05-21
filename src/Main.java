import Aula.AulaComputadora;

public class Main {
    public static void main(String [] args)
    {
        Universidad miUniversidad = new Universidad();
        miUniversidad.agregarAula(new AulaComputadora(101,20,false,false,true,10,false));
        miUniversidad.agregarAula(new AulaComputadora(202,20,false,false,false,10,false));
        miUniversidad.agregarAula(new AulaComputadora(303,20,false,false,false,10,false));
        //System.out.println(miUniversidad.listarAulas());
        System.out.println(miUniversidad.aulasNoDisponibles());


    }
}
