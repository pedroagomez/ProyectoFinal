package GestorColeccion;

import Universidad.net.Materia;

import java.util.LinkedList;

public class GestorMateria implements IGestor{
    private LinkedList<Materia> materias;


    public GestorMateria() {
        this.materias = new LinkedList<>();
    }

    @Override
    public void agregar(Object o) {
        if(o!=null){
            if(o instanceof Materia){
                if(!this.materias.contains(o)){
                    materias.add((Materia)o);
                }
            }
        }
    }

    @Override
    public boolean eliminar(Object o) {
        boolean eliminado = false;
        if(o!=null){
            if(o instanceof Materia){
                if(this.materias.contains(o)){
                    materias.remove((Materia)o);
                    eliminado = true;
                }
            }
        }
        return eliminado;
    }

    @Override
    public String filtrar(Object o) {
        StringBuilder sb = new StringBuilder();

        for (Materia materia : materias) {
            sb.append(materia.getNombre()).append("/t");
        }
        return sb.toString();
    }
}
