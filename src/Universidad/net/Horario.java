package Universidad.net;

public class Horario {
    private String inicio;
    private String finalizacion;
    private String dias;

    public java.lang.String getInicio() {
        return inicio;
    }

    public void setInicio(java.lang.String inicio) {
        this.inicio = inicio;
    }

    public java.lang.String getFinalizacion() {
        return finalizacion;
    }

    public void setFinalizacion(java.lang.String finalizacion) {
        this.finalizacion = finalizacion;
    }

    public java.lang.String getDias() {
        return dias;
    }

    public void setDias(java.lang.String dias) {
        this.dias = dias;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Horario{" +
                "inicio=" + inicio +
                ", finalizacion=" + finalizacion +
                ", dias=" + dias +
                '}';
    }
}
