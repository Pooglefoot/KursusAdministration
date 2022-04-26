package org.pooglefoot.kursusadministration;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Klassen Kursus, som har et navn og en liste af aktiviteter.
 */
public class Kursus {
    private final String navn;
    private List<Aktivitet> aktiviteter = new ArrayList<>();

    public Kursus(String navn) {
        this.navn = navn;
    }

    /**
     * Tilføjer en aktivitet til Kursets aktivitets liste med den givne dato, ansvarlige og beskrivelse.
     *
     * @param dato          Dato for aktivitet
     * @param ansvarlig     Ansvarlig for aktivitet
     * @param beskrivelse   Beskrivelse af aktivitet
     */
    public void addAktivitet(LocalDate dato, String ansvarlig, String beskrivelse) {
        this.aktiviteter.add(new Aktivitet(dato, ansvarlig, beskrivelse));
    }

    /**
     * Fjerner en aktivitet fra Kursets Aktivitetsliste der foregår på en given dato med en bestemt ansvarlig.
     *
     * @param dato      Datoen hvor aktiviteter skal slettes
     * @param ansvarlig Den ansvarlige hvis' kurser skal slettes
     */
    public void removeAktiviteter(LocalDate dato, String ansvarlig) {
        /*this.aktiviteter.removeIf(a -> dato.equals(a.getDato()) && ansvarlig.equals(a.getAnsvarlig()));*/

        this.aktiviteter = this.aktiviteter.stream()
                .filter(a -> !(dato.equals(a.dato()) && ansvarlig.equals(a.ansvarlig())))
                .collect(Collectors.toList());
    }

    /**
     * Returnerer et Map over samtlige dage hvorpå Kurset har aktiviteter, samt hvor mange aktiviteter på disse dage.
     *
     * @return  et Map hvor datoer der har aktiviteter er en Key, og antallet af aktiviteter på en dato er den
     *          tilsvarende Value.
     */
    public Map<LocalDate, Integer> aktiviteterPaaDatoer() {
        var map = new HashMap<LocalDate, Integer>();

        for (var a : this.aktiviteter) {
            // Reducér funktionskald
            LocalDate dato = a.dato();

            if (map.containsKey(dato)) {
                var antal = map.get(dato);
                map.replace(dato, antal + 1);
            } else {
                map.put(dato, 1);
            }
        }

        return map;
    }

    public String getNavn() {
        return this.navn;
    }

    public void prettyPrintMap() {
        System.out.printf("%n%s%n", this.aktiviteterPaaDatoer());
    }

    /**
     * Sorterer Kursets Aktivitetsliste før aktiviteter printes pænt til terminalen.
     */
    public void prettyPrintAktiviteter() {
        System.out.printf("%-12s %-12s %s%n", "Dato", "Ansvarlig", "Beskrivelse");
        this.aktiviteter.stream()
                .sorted(Comparator.comparing(Aktivitet::ansvarlig))
                .sorted(Comparator.comparing(Aktivitet::dato))
                .forEach(Kursus::printAktivitet);
    }

    /**
     * Printer en aktivitet pænt til terminalen.
     *
     * @param a Aktiviteten som skal printes pænt.
     */
    static void printAktivitet(Aktivitet a) {
        System.out.printf(
                "%-12s %-12s %s%n",
                a.dato(),
                a.ansvarlig(),
                a.beskrivelse()
        );
    }
}
