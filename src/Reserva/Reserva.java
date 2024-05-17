package Reserva;

import Aula.*;
import Universidad.net.Horario;
import Universidad.net.Materia;


public class Reserva {
    private Aula numeroAula;
    private Materia nombreMateria;
    private Horario horario;

    public Reserva(Aula numeroAula, Materia nombreMateria, Horario horario) {
        this.numeroAula= numeroAula;
        this.nombreMateria = nombreMateria;
        this.horario = horario;
    }

    public Aula getNumeroAula() {
        return numeroAula;
    }

    public void setNumeroAula(Aula numeroAula) {
        this.numeroAula = numeroAula;
    }

    public Materia getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(Materia nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "numeroAula=" + numeroAula +
                ", nombreMateria=" + nombreMateria +
                ", horario=" + horario +
                '}';
    }
}
