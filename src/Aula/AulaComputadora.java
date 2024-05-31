package Aula;

public class AulaComputadora extends Aula{
    private int cantidadComputadoras;
    private boolean auriculares;

    public AulaComputadora(int numeroAula, int capacidad, boolean proyector, boolean tele, int cantidadComputadoras, boolean auriculares) {
        super(numeroAula, capacidad, proyector, tele);
        this.cantidadComputadoras = cantidadComputadoras;
        this.auriculares = auriculares;
    }

    public int getCantidadComputadoras() {
        return cantidadComputadoras;
    }

    public void setCantidadComputadoras(int cantidadComputadoras) {
        this.cantidadComputadoras = cantidadComputadoras;
    }

    public boolean isAuriculares() {
        return auriculares;
    }

    public void setAuriculares(boolean auriculares) {
        this.auriculares = auriculares;
    }

    @Override
    public String toStringSinMateria() {
            return   "NumeroAula=" + this.getNumeroAula() +
                    ", capacidad=" + this.getCapacidad() +
                    ", computadoras=" + this.getCantidadComputadoras() +
                    ", proyector=" + this.isProyector() +
                    ", tele=" + this.isTele() +
                    ", Auriculares=" + this.isAuriculares();
    }

    @Override
    public String toString() {
        return  "AulaComputadora{" +
                 "cantidadComputadoras=" + cantidadComputadoras +
                ", auriculares=" + auriculares + super.toString();
    }
}
