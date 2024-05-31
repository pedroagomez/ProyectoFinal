package Aula;

public class AulaNormal extends Aula{
    public AulaNormal(int numeroAula, int capacidad, boolean proyector, boolean tele) {
        super(numeroAula, capacidad, proyector, tele);
    }

    @Override
    public String toString() {
        return "Aula normal "+super.toString();
    }


}
