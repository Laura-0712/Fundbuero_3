import java.util.ArrayList;
import java.util.List;

/**
 * Repraesentiert einen registrierten Nutzer der Fundbuero-App.
 * Ein Nutzer kann sowohl Fundmeldungen anlegen (Finder) als auch
 * Rueckgabeanfragen stellen (Suchende/Verlierer).
 */
public class Nutzer {
    private String nutzerId;
    private String name;
    private String email;
    private List<Verlustmeldung> verlustmeldungen;
    private List<Fundmeldung> fundmeldungen;

    public Nutzer(String nutzerId, String name, String email) {
        this.nutzerId = nutzerId;
        this.name = name;
        this.email = email;
        this.verlustmeldungen = new ArrayList<>();
        this.fundmeldungen = new ArrayList<>();
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

    public void verlustmeldungHinzufuegen(Verlustmeldung meldung) {
        if (meldung != null && !verlustmeldungen.contains(meldung)) {
            verlustmeldungen.add(meldung);
        }
    }

    public void fundmeldungHinzufuegen(Fundmeldung meldung) {
        if (meldung != null && !fundmeldungen.contains(meldung)) {
            fundmeldungen.add(meldung);
        }
    }

    public List<Verlustmeldung> getVerlustmeldungen() {
        return new ArrayList<>(verlustmeldungen);
    }

    public List<Fundmeldung> getFundmeldungen() {
        return new ArrayList<>(fundmeldungen);
    }

    @Override
    public String toString() {
        return "Nutzer{" +
                "nutzerId='" + nutzerId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
