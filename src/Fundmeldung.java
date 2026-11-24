public class Verlustmeldung {
    private String meldenummer;
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

    public Nutzer getVerlierer() {
        return verlierer;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Verlustmeldung{" +
                "meldenummer='" + meldenummer + '\'' +
                ", kategorie='" + kategorie + '\'' +
                ", farbe='" + farbe + '\'' +
                ", marke='" + marke + '\'' +
                ", status='" + status + '\'' +
                ", verlierer=" + (verlierer != null ? verlierer.getName() : "unbekannt") +
                '}';
    }
}
