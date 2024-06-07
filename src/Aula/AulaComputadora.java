package Aula;

import org.json.JSONException;
import org.json.JSONObject;

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
    public JSONObject toJson() throws JSONException {
        JSONObject obj = new JSONObject();
        obj.put("numeroAula", this.getNumeroAula());
        obj.put("capacidad", this.getCapacidad());
        obj.put("proyector", this.isProyector());
        obj.put("tele", this.isTele());
        if (this.getMateria() != null) {
            obj.put("materia", this.getMateria().toJson());
        } else {
            obj.put("materia", JSONObject.NULL);
        }
        obj.put("Cantidad computadoras",this.cantidadComputadoras);
        obj.put("Auriculares",this.auriculares);
        return obj;
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
