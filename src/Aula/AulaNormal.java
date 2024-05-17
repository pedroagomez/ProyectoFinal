package Aula;

public class AulaNormal extends Aula{
    public AulaNormal(int numeroAula, int capacidad, boolean proyector, boolean tele, boolean disponible) {
        super(numeroAula, capacidad, proyector, tele, disponible);
    }

    @Override
    public String toString() {
        return "Aula normal "+super.toString();
    }


}
