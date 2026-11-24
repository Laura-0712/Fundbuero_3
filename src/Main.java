/**
 * Startklasse zum Testen der Fundbuero-Anwendung (Normalablauf und Fehlerfall).
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Fundbuero-App Demo: Normaler Ablauf (Lena & Tom) ===");

        // 1. Nutzer erzeugen (Personas aus Uebung 1)
        Nutzer tom = new Nutzer("N-01", "Tom Weber", "tom.weber@beispiel.de");
        Nutzer lena = new Nutzer("N-02", "Lena Hoffmann", "lena.hoffmann@hm.edu");

        // 2. Fundmeldung anlegen
        Fundmeldung rucksack = new Fundmeldung(
                "F-10",
                "Schwarzer Rucksack (Eastpak)",
                "Tasche/Rucksack",
                "Endhaltestelle S-Bahn S3 (GPS)",
                "2026-11-23 20:10",
                "Roter Anhaenger am Reissverschluss, Laptop im Innenfach",
                tom
        );
        System.out.println("Angelegte Fundmeldung: " + rucksack);

        // 3. Rueckgabeanfrage erstellen und einreichen
        RueckgabeAnfrage anfrage = new RueckgabeAnfrage(
                "A-101",
                "Roter Anhaenger am Reissverschluss, Laptop im Innenfach",
                lena,
                rucksack
        );
        boolean eingereicht = anfrage.einreichen();
        System.out.println("Anfrage eingereicht? " + eingereicht + " -> " + anfrage);
        System.out.println("Fundstatus nach Anfrage: " + rucksack.getStatus());

        // 4. Eigentumsnachweis pruefen und Anfrage bestaetigen
        boolean nachweisOk = rucksack.pruefeSicherheitsmerkmal(anfrage.getEigentumsnachweis());
        System.out.println("Eigentumsnachweis gueltig? " + nachweisOk);
        if (nachweisOk) {
            anfrage.bestaetigen();
        }
        System.out.println("Nach Bestaetigung: " + anfrage);
        System.out.println("Fundstatus jetzt:  " + rucksack.getStatus());

        // 5. Rueckgabe abschliessen und Randfall pruefen (Stornierung danach nicht mehr moeglich)
        boolean zurueckgegeben = anfrage.rueckgabeBestaetigen();
        System.out.println("Rueckgabe erfasst? " + zurueckgegeben + " -> " + rucksack.getStatus());
        System.out.println("Stornierung nach Rueckgabe moeglich? " + anfrage.stornieren() + " (erwartet: false)");

        // 6. Fehlerfall: Finder darf eigenen Fund nicht selbst beanspruchen
        System.out.println("\n=== Fehlerfall: Selbst-Beanspruchung ===");
        Fundmeldung schluessel = new Fundmeldung(
                "F-11",
                "Schluesselbund",
                "Schluessel",
                "S-Bahn Linie S3",
                "2026-11-23 20:15",
                "Blauer Anhaenger",
                tom
        );
        RueckgabeAnfrage selbstAnfrage = new RueckgabeAnfrage("A-102", "Blauer Anhaenger", tom, schluessel);
        System.out.println("Selbst-Beanspruchung erlaubt? " + selbstAnfrage.einreichen() + " (erwartet: false)");
    }
}