package GestorColeccion;

import Universidad.net.Materia;
import Universidad.net.Profesor;

import java.util.LinkedList;

public class GestorMateria {

    private GestionColeccion<Materia>conjuntoMaterias;

    public GestorMateria() {
        this.conjuntoMaterias = new GestionColeccion<>();
    }

    public void agregarMateria(Materia materia)
    {
        conjuntoMaterias.agregar(materia);
    }

    public void eliminarMateria(Materia materia)
    {
        conjuntoMaterias.eliminar(materia);
    }

    public String buscarYdevolverMateria(Materia materia)
    {
        StringBuilder builder = new StringBuilder();
        if (conjuntoMaterias.verificarExistenciaElemento(materia)) {
            builder.append(conjuntoMaterias.devolverElemento(materia)).append("\n");
        } else {
            builder.append("Elemento no encontrado");
        }
        return builder.toString();
    }

    public String listarMaterias()
    {
        return conjuntoMaterias.listarConjunto();
    }


}
