package GestorColeccion;

public interface IGestor {
    void agregar(Object o);
    boolean eliminar(Object o);
    String filtrar(Object o);
}
