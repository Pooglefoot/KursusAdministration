import java.time.LocalDate;

public class Aktivitet {
    private final LocalDate dato;
    private final String ansvarlig;
    private final String beskrivelse;

    public Aktivitet (LocalDate dato, String ansvarlig, String beskrivelse) {
        this.dato = dato;
        this.ansvarlig = ansvarlig;
        this.beskrivelse = beskrivelse;
    }

    public LocalDate getDato() {
        return this.dato;
    }

    public String getAnsvarlig() {
        return this.ansvarlig;
    }

    public String getBeskrivelse() {
        return this.beskrivelse;
    }
}
