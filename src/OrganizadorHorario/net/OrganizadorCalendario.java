package OrganizadorHorario.net;

import Reserva.Reserva;

public class OrganizadorCalendario {
   private Calendario calendario;
   private Reserva reserva;

    public OrganizadorCalendario(Calendario calendario, Reserva reserva) {
        this.calendario = calendario;
        this.reserva = reserva;
    }

    public Calendario getCalendario() {
        return calendario;
    }

    public void setCalendario(Calendario calendario) {
        this.calendario = calendario;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
