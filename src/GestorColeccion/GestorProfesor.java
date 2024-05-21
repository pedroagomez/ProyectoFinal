package GestorColeccion;

import Universidad.net.Materia;
import Universidad.net.Profesor;

import java.io.Serializable;
import java.util.LinkedList;

public class GestorProfesor {

    private GestorColeccion<Profesor> conjuntoProfesores;

    public GestorProfesor() {
        this.conjuntoProfesores = new GestorColeccion<Profesor>();
    }


    public void agregar(Profesor profe) {
        if(profe!=null){
            if(profe instanceof Profesor){
                    conjuntoProfesores.agregarAconjunto(profe);
                }
            }
    }


    public boolean eliminar(Profesor profe) {
        boolean eliminado = false;
        if(profe!=null){
            if(profe instanceof Profesor){
               if(conjuntoProfesores.verificarExistenciaElemento(profe))
               {
                   conjuntoProfesores.eliminarDeConjunto(profe);
                }
            }
        }
        return eliminado;
    }

    public String listarListaProfesores() {

        return conjuntoProfesores.listarConjunto();
    }
}
