package GestorColeccion;

public interface IGestion<T> {

    void agregar(T elemento);
    boolean eliminar(T elemento);
    boolean verificarExistenciaElemento(T elemento);
    String devolverElemento(T elemento);
    String listarConjunto();
}
