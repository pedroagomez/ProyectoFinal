package Aula;


import Universidad.net.Materia;
import Universidad.net.Profesor;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.Objects;

public abstract class Aula  implements Serializable {
    private int numeroAula;
    private int capacidad;
    private boolean proyector;
    private boolean tele;

    private Materia materia;


    public Aula(int numeroAula, int capacidad, boolean proyector, boolean tele) {
        this.numeroAula = numeroAula;
        this.capacidad = capacidad;
        this.proyector = proyector;
        this.tele = tele;
        this.materia = null;
    }

    public JSONObject toJson() throws JSONException {
        JSONObject obj = new JSONObject();
        obj.put("numeroAula", this.numeroAula);
        obj.put("capacidad", this.capacidad);
        obj.put("proyector", this.proyector);
        obj.put("tele", this.tele);
        if (this.materia != null) {
            obj.put("materia", this.materia.toJson());
        } else {
            obj.put("materia", JSONObject.NULL);
        }
        return obj;
    }

    public int getNumeroAula() {
        return numeroAula;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isProyector() {
        return proyector;
    }

    public void setProyector(boolean proyector) {
        this.proyector = proyector;
    }

    public boolean isTele() {
        return tele;
    }

    public void setTele(boolean tele) {
        this.tele = tele;
    }


    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }


    public String toStringSinMateria() {
        return   "NumeroAula=" + numeroAula +
                ", capacidad=" + capacidad +
                ", proyector=" + proyector +
                ", tele=" + tele;
    }
    @Override
    public String toString() {
        return "Aula{" +
                "numeroAula=" + numeroAula +
                ", capacidad=" + capacidad +
                ", proyector=" + proyector +
                ", tele=" + tele +
                ", materia=" + materia +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        boolean esIgual=false;
        if(o!=null)
        {
            if(o instanceof Aula)
            {
                Aula aula=(Aula)o;
                if(aula.numeroAula == getNumeroAula())
                {
                    esIgual=true;
                }
            }
        }
        return esIgual;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
