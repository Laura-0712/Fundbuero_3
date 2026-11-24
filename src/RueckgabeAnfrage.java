/**
 * Repraesentiert eine Anfrage einer suchenden Person zur Rueckgabe
 * einer konkreten Fundmeldung inklusive Statusuebergaengen.
 */
public class RueckgabeAnfrage {
    private String anfrageId;
    private String eigentumsnachweis;
    private String status;
    private Nutzer suchende;
    private Fundmeldung fundmeldung;

    public RueckgabeAnfrage(String anfrageId, String eigentumsnachweis,
                            Nutzer suchende, Fundmeldung fundmeldung) {
        this.anfrageId = anfrageId;
        this.eigentumsnachweis = eigentumsnachweis;
        this.status = "ENTWURF";
        this.suchende = suchende;
        this.fundmeldung = fundmeldung;
        if (suchende != null) {
            suchende.anfrageHinzufuegen(this);
        }
    }

    public String getAnfrageId() {
        return anfrageId;
    }

    public String getEigentumsnachweis() {
        return eigentumsnachweis;
    }

    public String getStatus() {
        return status;
    }

    public Nutzer getSuchende() {
        return suchende;
    }

    public Fundmeldung getFundmeldung() {
        return fundmeldung;
    }

    public boolean einreichen() {
        if (!"ENTWURF".equals(status) || fundmeldung == null) {
            return false;
        }
        if (!"GEMELDET".equals(fundmeldung.getStatus())) {
            return false;
        }
        if (eigentumsnachweis == null || eigentumsnachweis.trim().isEmpty()) {
            return false;
        }
        // Selbst-Beanspruchung durch den Finder ist nicht erlaubt
        if (suchende != null && suchende.equals(fundmeldung.getFinder())) {
            return false;
        }
        this.status = "ANGEFRAGT";
        this.fundmeldung.setStatus("BEANSPRUCHT");
        return true;
    }

    public boolean bestaetigen() {
        if (!"ANGEFRAGT".equals(status) || fundmeldung == null) {
            return false;
        }
        this.status = "BESTAETIGT";
        this.fundmeldung.setStatus("ABHOLBEREIT");
        return true;
    }

    public boolean ablehnen() {
        if (!"ANGEFRAGT".equals(status) || fundmeldung == null) {
            return false;
        }
        this.status = "ABGELEHNT";
        this.fundmeldung.setStatus("GEMELDET");
        return true;
    }

    public boolean stornieren() {
        if (("ANGEFRAGT".equals(status) || "BESTAETIGT".equals(status)) && fundmeldung != null) {
            this.status = "STORNIERT";
            this.fundmeldung.setStatus("GEMELDET");
            return true;
        }
        return false;
    }

    public boolean rueckgabeBestaetigen() {
        if (!"BESTAETIGT".equals(status) || fundmeldung == null) {
            return false;
        }
        this.status = "ABGESCHLOSSEN";
        this.fundmeldung.setStatus("ZURUECKGEGEBEN");
        return true;
    }

    @Override
    public String toString() {
        return "RueckgabeAnfrage{" +
                "anfrageId='" + anfrageId + '\'' +
                ", status='" + status + '\'' +
                ", suchende=" + (suchende != null ? suchende.getName() : "unbekannt") +
                ", fundmeldung=" + (fundmeldung != null ? fundmeldung.getTitel() : "unbekannt") +
                '}';
    }
}