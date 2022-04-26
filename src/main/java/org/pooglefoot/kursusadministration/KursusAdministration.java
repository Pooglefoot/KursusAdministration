package org.pooglefoot.kursusadministration;

import java.time.LocalDate;

public class KursusAdministration {
    public static void main(String[] args) {
        Kursus mitKursus = addKursusWithAktiviteter("Andeby Gymnasie");

        mitKursus.prettyPrintMap();
        mitKursus.prettyPrintAktiviteter();
        System.out.println();

        LocalDate dato = LocalDate.now().plusDays(3);
        mitKursus.removeAktiviteter(dato, "CB");

        mitKursus.prettyPrintMap();
        mitKursus.prettyPrintAktiviteter();
        System.out.println();
    }

    /**
     * Bruger et givent navn til at oprette et kursus med aktiviteter der finder sted i dag, om tre dage og om en uge,
     * med forskellige aktivitetsansvarlige.
     *
     * @param   kursusNavn Navnet for kurset der skal oprettes med tilhørende aktiviteter.
     * @return  Det endelige kursus med tilføjede aktiviteter.
     */
    public static Kursus addKursusWithAktiviteter(String kursusNavn) {
        LocalDate dato1 = LocalDate.now();
        LocalDate dato2 = dato1.plusDays(3);
        LocalDate dato3 = dato1.plusWeeks(1);

        Kursus kursus = new Kursus(kursusNavn);

        // Datoerne mikset således at sorteringen kan ses.
        kursus.addAktivitet(dato2, "CB", "Andeby gennem tiderne");
        kursus.addAktivitet(dato1, "JVA", "Økonomi");
        kursus.addAktivitet(dato2, "GG", "Videnskab");
        kursus.addAktivitet(dato1, "CB", "Andeby gennem tiderne");
        kursus.addAktivitet(dato2, "CB", "Historiske figurer");
        kursus.addAktivitet(dato3, "GG", "Videnskab");
        kursus.addAktivitet(dato1, "GG", "Videnskab");
        kursus.addAktivitet(dato3, "GG", "Teknik");

        return kursus;
    }
}