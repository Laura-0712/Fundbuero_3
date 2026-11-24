import java.util.ArrayList;
import java.util.List;

public class Nutzer {
    private String nutzerId;
    private String name;
    private String email;
    private List<Fundmeldung> fundmeldungen;
    private List<RueckgabeAnfrage> anfragen;

    public Nutzer(String nutzerId, String name, String email) {
        this.nutzerId = nutzerId;
        this.name = name;
        this.email = email;
        this.fundmeldungen = new ArrayList<>();
        this.anfragen = new ArrayList<>();
    }

    public String getNutzerId() {
        return nutzerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void fundmeldungHinzufuegen(Fundmeldung fundmeldung) {
        if (fundmeldung != null && !fundmeldungen.contains(fundmeldung)) {
            fundmeldungen.add(fundmeldung);
        }
    }

    public void anfrageHinzufuegen(RueckgabeAnfrage anfrage) {
        if (anfrage != null && !anfragen.contains(anfrage)) {
            anfragen.add(anfrage);
        }
    }

    public List<Fundmeldung> getFundmeldungen() {
        return new ArrayList<>(fundmeldungen);
    }

    public List<RueckgabeAnfrage> getAnfragen() {
        return new ArrayList<>(anfragen);
    }

    @Override
    public String toString() {
        return "Nutzer{" +
                "nutzerId='" + nutzerId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}