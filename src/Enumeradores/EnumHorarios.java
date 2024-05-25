package Enumeradores;

public enum EnumHorarios {

    OCHOTREINTA_A_DIEZTREINTA(830,1030),
    DIEZTREINTA_A_TRECE(1030,1300),
    TRECE_A_QUINCETREINTA(1300,1530),
    QUINCETREINTA_A_DIECIOCHO(1530,1800);



    private int horaInicio;
    private int horaFin;

    EnumHorarios(int horaInicio, int horaFin) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(int horaFin) {
        this.horaFin = horaFin;
    }
}
