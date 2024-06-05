package Aula;

import org.json.JSONException;
import org.json.JSONObject;

public class AulaNormal extends Aula{
    public AulaNormal(int numeroAula, int capacidad, boolean proyector, boolean tele) {
        super(numeroAula, capacidad, proyector, tele);
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
