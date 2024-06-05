package Aula;

import Universidad.net.Materia;
import org.json.JSONException;
import org.json.JSONObject;

public class AulaNormal extends Aula{
    public AulaNormal(int numeroAula, int capacidad, boolean proyector, boolean tele) {
        super(numeroAula, capacidad, proyector, tele);
    }
    public  JSONObject toJson() throws JSONException {
        JSONObject obj = new JSONObject();
        obj.put("numeroAula", super.getNumeroAula());
        obj.put("capacidad",super.getCapacidad());
        obj.put("proyector", super.isProyector());
        obj.put("tele", super.isTele());
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
