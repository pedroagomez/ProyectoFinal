package Aula;

public class AulaNormal extends Aula{
    public AulaNormal(int numeroAula, int capacidad, boolean proyector, boolean tele) {
        super(numeroAula, capacidad, proyector, tele);
    }

    @Override
    public String toStringSinMateria() {
        return  "NumeroAula=" + this.getNumeroAula() +
                ", capacidad=" + this.getCapacidad() +
                ", proyector=" + this.isProyector() +
                ", tele=" + this.isTele();
    }

    @Override
    public String toString() {
        return "Aula normal "+super.toString();
    }


}
