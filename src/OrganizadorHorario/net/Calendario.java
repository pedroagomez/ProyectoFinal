package OrganizadorHorario.net;

import java.util.Objects;

public class Calendario {
    private String dia;
    private String semana;
    private String mes;

    public Calendario(String dia, String semana, String mes) {
        this.dia = dia;
        this.semana = semana;
        this.mes = mes;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getSemana() {
        return semana;
    }

    public void setSemana(String semana) {
        this.semana = semana;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calendario that = (Calendario) o;
        return Objects.equals(dia, that.dia) && Objects.equals(semana, that.semana) && Objects.equals(mes, that.mes);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "Calendario{" +
                "dia='" + dia + '\'' +
                ", semana='" + semana + '\'' +
                ", mes='" + mes + '\'' +
                '}';
    }
}
