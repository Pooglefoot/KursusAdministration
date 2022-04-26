package org.pooglefoot.kursusadministration;

import java.time.LocalDate;

/**
 * En simpel record for Aktiviteter
 *
 * @param dato          Datoen for aktiviteten
 * @param ansvarlig     Aktivitetens ansvarlige
 * @param beskrivelse   Beskrivelse af aktiviteten
 */
public record Aktivitet(
        LocalDate dato,
        String ansvarlig,
        String beskrivelse) {
}

/*public class Aktivitet {
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
}*/