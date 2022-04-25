package org.pooglefoot.kursusadministration;

import java.time.LocalDate;

public class KursusAdministration {
    public static void main(String[] args) {
        // Tilføjet her da de er dynamiske, vil hellere have dem i addKursusWithAktiviteter.
        // Ville nok bruge en ZonedDateTime, da det højst sandsynligt finder sted i én tidszone.
        LocalDate dato = LocalDate.now().plusDays(3);

        Kursus mitKursus = addKursusWithAktiviteter("Andeby Gymnasie");

        mitKursus.prettyPrintMap();
        mitKursus.prettyPrintAktiviteter();
        System.out.println();

        mitKursus.removeAktiviteter(dato, "CB");

        mitKursus.prettyPrintMap();
        mitKursus.prettyPrintAktiviteter();
        System.out.println();
    }

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