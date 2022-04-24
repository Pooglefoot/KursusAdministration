import java.time.LocalDate;
import java.util.*;

public class Kursus {
    private final String navn;
    private final ArrayList<Aktivitet> aktiviteter;

    public Kursus(String navn) {
        this.navn = navn;
        this.aktiviteter = new ArrayList<>();
    }

    public void addAktivitet(LocalDate dato, String ansvarlig, String beskrivelse) {
        this.aktiviteter.add(new Aktivitet(dato, ansvarlig, beskrivelse));
    }

    public void removeAktiviteter(LocalDate dato, String ansvarlig) {
        this.aktiviteter.removeIf(a -> dato == a.getDato() && ansvarlig.equals(a.getAnsvarlig()));

        /*for (Aktivitet a : this.aktiviteter) {
            if (dato == a.getDato()) {
                if (ansvarlig.equals(a.getAnsvarlig())) {
                    this.aktiviteter.remove(a);
                }
            }
        }*/
    }

    public Map<LocalDate, Integer> aktiviteterPaaDatoer() {
        Map <LocalDate, Integer> map = new HashMap<>();

        for (Aktivitet a : this.aktiviteter) {
            // Reducér funktionskald
            LocalDate dato = a.getDato();

            if (map.containsKey(dato)) {
                Integer antal = map.get(dato);
                map.replace(dato, antal+1);
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
        System.out.printf("%s%n%n", this.aktiviteterPaaDatoer());
    }

    public void prettyPrintAktiviteter() {
        /*Collections.sort(this.aktiviteter, new Comparator<Aktivitet>() {
            @Override
            public int compare(Aktivitet o1, Aktivitet o2) {
                LocalDate d1 = ((Aktivitet) o1).getDato();
                LocalDate d2 = ((Aktivitet) o2).getDato();
                int dComp = d1.compareTo(d2);

                if (dComp != 0) {
                    return dComp;
                }

                String a1 = ((Aktivitet) o1).getAnsvarlig();
                String a2 = ((Aktivitet) o2).getAnsvarlig();
                return a1.compareTo(a2);
            }
        });*/

        //Stream<Aktivitet> sortedAktiviteter = this.aktiviteter.stream().sorted(Comparator.comparing(Aktivitet::getDato).thenComparing(Aktivitet::getAnsvarlig));

        System.out.printf("%-12s %-12s %s%n", "Dato", "Ansvarlig", "Beskrivelse");
        this.aktiviteter.stream()
                .sorted(Comparator
                    .comparing(Aktivitet::getDato)
                    .thenComparing(Aktivitet::getAnsvarlig))
                    .forEach((a) -> System.out.printf(
                            "%-12s %-12s %s%n",
                            a.getDato(),
                            a.getAnsvarlig(),
                            a.getBeskrivelse()
                    ));
    }
}
