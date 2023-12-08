package briz.francisco.llamadasapp.shared;

public enum Turno {
    TURNO1("Lunes a Viernes no festivos de 7:00 a 15:00"),
    TURNO2("Lunes a Viernes no festivos de 15:00 a 23:00"),
    TURNO3("Lunes a Viernes no festivos de 23:00 a 7:00"),
    TURNO4("Sabados, Domingos y festivos de 7:00 a 15:00"),
    TURNO5("Sabados, Domingos y festivos de 15:00 a 23:00"),
    TURNO6("Sabados, Domingos y festivos de 23:00 a 7:00");

    private final String turnoDescripcion;

     Turno(String s) {
        this.turnoDescripcion = s;
    }
    public String getTurnoDescripcion() {
        return turnoDescripcion;
    }

    public static Turno getTurno(String turno) {
        for (Turno t : Turno.values()) {
            if (t.getTurnoDescripcion().equals(turno)) {
                return t;
            }
        }
        return null;
    }
}
