package Aula;

import Universidad.net.Materia;
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

    @Override
    public JSONObject toJson() throws JSONException {
        JSONObject obj = new JSONObject();
        obj.put("numeroAula", super.getNumeroAula());
        obj.put("capacidad",super.getCapacidad());
        obj.put("proyector", super.isProyector());
        obj.put("tele", super.isTele());
        obj.put("cantidad computadoras", this.cantidadComputadoras);
        obj.put("auriculares", this.auriculares);
        Materia aux= super.getMateria();
        if (aux != null) {
            obj.put("materia", aux.toJson());
        } else {
            obj.put("materia", JSONObject.NULL);
        }
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
