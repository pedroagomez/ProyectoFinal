package GestorColeccion;

import Universidad.net.Materia;

import java.util.LinkedList;

public class GestorMateria {

    private GestorColeccion<Materia> materias;

    public GestorMateria() {
        this.materias = new GestorColeccion<Materia>();
    }

    

    public boolean agregarMateria(Materia mat)
    {   boolean agregada=false;
        if(mat!=null){
            if(mat instanceof Materia)
                {
                    materias.agregarAlista(mat);
                    agregada=true;
                }
        }
        return agregada;
    }


    public boolean eliminar(Materia mat) {
        boolean eliminado = false;
        if(mat!=null){
            if(mat instanceof Materia){
                if(materias.buscarEnLista(mat)){
                    materias.eliminarDeLista(mat);
                    eliminado = true;
                }
            }
        }
        return eliminado;
    }

    public String listarListaProfesores() {
       return materias.listarLista();

    }
}
