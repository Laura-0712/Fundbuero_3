/**
 * Repraesentiert eine gemeldete Fundsache im System inkl. nicht oeffentlichem
 * Sicherheitsmerkmal fuer die Eigentumspruefung.
 */
public class Fundmeldung {
    private String fundId;
    private String titel;
    private String kategorie;
    private String beschreibung;
    private String farbe;
    private String marke;
    private String ort;
    private String zeitraum;
    private String status;
    private Nutzer verlierer;

    public Verlustmeldung(String meldenummer, String kategorie, String beschreibung,
                          String farbe, String marke, String ort, String zeitraum, Nutzer verlierer) {
        this.meldenummer = meldenummer;
        this.kategorie = kategorie;
        this.beschreibung = beschreibung;
        this.farbe = farbe;
        this.marke = marke;
        this.ort = ort;
        this.zeitraum = zeitraum;
        this.status = "Offen";
        this.verlierer = verlierer;
        if (verlierer != null) {
            verlierer.verlustmeldungHinzufuegen(this);
        }
    }

    public String getMeldenummer() {
        return meldenummer;
    }

    public String getKategorie() {
        return kategorie;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public String getFarbe() {
        return farbe;
    }

    public String getMarke() {
        return marke;
    }

    public String getOrt() {
        return ort;
    }

    public String getZeitraum() {
        return zeitraum;
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
                ", farbe='" + farbe + '\'' +
                ", marke='" + marke + '\'' +
                ", status='" + status + '\'' +
                ", verlierer=" + (verlierer != null ? verlierer.getName() : "unbekannt") +
                '}';
    }
}
