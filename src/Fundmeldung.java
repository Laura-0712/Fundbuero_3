/**
 * Repraesentiert eine gemeldete Fundsache im System inkl. nicht oeffentlichem
 * Sicherheitsmerkmal fuer die Eigentumspruefung.
 */
public class Fundmeldung {
    private String fundId;
    private String titel;
    private String kategorie;
    private String fundort;
    private String funddatum;
    private String sicherheitsmerkmal;
    private String status;
    private Nutzer finder;

    public Fundmeldung(String fundId, String titel, String kategorie, String fundort,
                       String funddatum, String sicherheitsmerkmal, Nutzer finder) {
        this.fundId = fundId;
        this.titel = titel;
        this.kategorie = kategorie;
        this.fundort = fundort;
        this.funddatum = funddatum;
        this.sicherheitsmerkmal = sicherheitsmerkmal;
        this.status = "GEMELDET";
        this.finder = finder;
        if (finder != null) {
            finder.fundmeldungHinzufuegen(this);
        }
    }

    public String getFundId() {
        return fundId;
    }

    public String getTitel() {
        return titel;
    }

    public String getKategorie() {
        return kategorie;
    }

    public String getFundort() {
        return fundort;
    }

    public String getFunddatum() {
        return funddatum;
    }

    public String getStatus() {
        return status;
    }

    public Nutzer getFinder() {
        return finder;
    }

    /**
     * Prueft, ob die Angabe der suchenden Person mit dem hinterlegten
     * nicht oeffentlichen Sicherheitsmerkmal uebereinstimmt.
     */
    public boolean pruefeSicherheitsmerkmal(String angabe) {
        if (sicherheitsmerkmal == null || angabe == null) {
            return false;
        }
        return sicherheitsmerkmal.trim().equalsIgnoreCase(angabe.trim());
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean archivieren() {
        if ("GEMELDET".equals(status)) {
            this.status = "ARCHIVIERT";
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Fundmeldung{" +
                "fundId='" + fundId + '\'' +
                ", titel='" + titel + '\'' +
                ", kategorie='" + kategorie + '\'' +
                ", fundort='" + fundort + '\'' +
                ", status='" + status + '\'' +
                ", finder=" + (finder != null ? finder.getName() : "unbekannt") +
                '}';
    }
}