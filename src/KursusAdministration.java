import java.time.LocalDate;

public class KursusAdministration {
    public static void main(String[] args) {
        // Tilføjet her da de er dynamiske, vil hellere have dem i addKursusWithAktiviteter.
        LocalDate dato1 = LocalDate.now();
        LocalDate dato2 = dato1.plusDays(3);
        LocalDate dato3 = dato1.plusWeeks(1);

        Kursus mitKursus = addKursusWithAktiviteter("Andeby Gymnasie", dato1, dato2, dato3);

        mitKursus.prettyPrintMap();
        mitKursus.prettyPrintAktiviteter();
        System.out.println();

        mitKursus.removeAktiviteter(dato2, "CB");

        mitKursus.prettyPrintMap();
        mitKursus.prettyPrintAktiviteter();
        System.out.println();
    }

    public static Kursus addKursusWithAktiviteter(String kursusNavn, LocalDate dato1, LocalDate dato2, LocalDate dato3) {

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