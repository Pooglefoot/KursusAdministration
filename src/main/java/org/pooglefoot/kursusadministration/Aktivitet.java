package org.pooglefoot.kursusadministration;

import java.time.LocalDate;

public record Aktivitet(
        LocalDate dato,
        String ansvarlig,
        String beskrivelse) {
}

/*public class org.pooglefoot.kursusadministration.Aktivitet {
    private final LocalDate dato;
    private final String ansvarlig;
    private final String beskrivelse;

    public org.pooglefoot.kursusadministration.Aktivitet (LocalDate dato, String ansvarlig, String beskrivelse) {
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
}*/