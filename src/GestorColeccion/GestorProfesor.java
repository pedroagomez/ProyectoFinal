package GestorColeccion;

import Universidad.net.Materia;
import Universidad.net.Profesor;

import java.io.Serializable;
import java.util.LinkedList;

public class GestorProfesor implements IGestor {
    private LinkedList<Profesor> profesores;

    public GestorProfesor() {
        this.profesores = new LinkedList<>();
    }

    @Override
    public void agregar(Object o) {
        if(o!=null){
            if(o instanceof Profesor){
                if(!this.profesores.contains(o)){
                    profesores.add((Profesor) o);
                }
            }
        }
    }

    @Override
    public boolean eliminar(Object o) {
        boolean eliminado = false;
        if(o!=null){
            if(o instanceof Profesor){
                if(this.profesores.contains(o)){
                    profesores.remove((Profesor) o);
                    eliminado = true;
                }
            }
        }
        return eliminado;
    }

    @Override
    public String filtrar(Object o) {
        StringBuilder sb = new StringBuilder();

        for (Profesor profesor : profesores) {
            sb.append(profesor.getNombre()).append("/t");
        }
        return sb.toString();
    }
}
