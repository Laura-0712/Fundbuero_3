public class Main {
    public static void main(String[] args) {
        System.out.println("=== FundPunkt Demo: Normaler Ablauf (UC-01) ===");

        // 1. Objekte erzeugen (analog zum Objektdiagramm aus Uebung 3)
        Nutzer anna = new Nutzer("N-01", "Anna Berger", "anna.berger@hm.edu");
        Nutzer markus = new Nutzer("N-02", "Markus Lindner", "markus.lindner@hm.edu");
        Fundmeldung rucksack = new Fundmeldung(
                "F-10",
                "Blauer Rucksack",
                "Taschen",
                "R-Bau Hoersaal R1.046",
                "2026-11-23",
                "Roter HM-Schluesselanhaenger",
                markus
        );

        System.out.println("Angelegte Fundmeldung: " + rucksack);

        // 2. Rueckgabeanfrage erstellen und einreichen
        RueckgabeAnfrage anfrage101 = new RueckgabeAnfrage(
                "A-101",
                "Roter HM-Schluesselanhaenger in Vordertasche",
                anna,
                rucksack
        );
        boolean eingereicht = anfrage101.einreichen();
        System.out.println("Anfrage eingereicht? " + eingereicht + " -> " + anfrage101);
        System.out.println("Fundstatus nach Anfrage: " + rucksack.getStatus());

        // 3. Finder prueft Sicherheitsmerkmal und bestaetigt
        boolean merkmalPasst = rucksack.pruefeSicherheitsmerkmal(anfrage101.getEigentumsnachweis());
        System.out.println("Eigentumsnachweis gueltig? " + merkmalPasst);
        if (merkmalPasst) {
            anfrage101.bestaetigen();
        }
        System.out.println("Nach Bestaetigung:     " + anfrage101);
        System.out.println("Fundstatus jetzt:      " + rucksack.getStatus());

        // 4. Uebergabe dokumentieren
        boolean uebergeben = anfrage101.rueckgabeBestaetigen();
        System.out.println("Rueckgabe erfasst?     " + uebergeben + " -> " + rucksack.getStatus());

        // 5. Rand-/Fehlerfall: Stornierung nach Abschluss darf nicht erlaubt sein
        boolean stornoVersuch = anfrage101.stornieren();
        System.out.println("Stornierung nach Rueckgabe moeglich? " + stornoVersuch + " (erwartet: false)");

        System.out.println("\n=== Fehlerfall: Selbst-Beanspruchung (Review-Erkenntnis aus Uebung 3) ===");
        Fundmeldung flasche = new Fundmeldung(
                "F-11",
                "Edelstahl-Trinkflasche",
                "Sonstiges",
                "Mensa",
                "2026-11-23",
                "Aufkleber auf dem Boden",
                markus
        );
        RueckgabeAnfrage selbstAnfrage = new RueckgabeAnfrage(
                "A-102",
                "Aufkleber auf dem Boden",
                markus,
                flasche
        );
        System.out.println("Selbst-Beanspruchung erlaubt? " + selbstAnfrage.einreichen() + " (erwartet: false)");
    }
}