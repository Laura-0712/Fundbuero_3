# Übungsblatt 2: Anforderungen, Akzeptanzkriterien & Roadmap – Fundbüro-App

> **Hinweis:** Diese Liste entspricht dem überarbeiteten Stand nach dem Requirements-Coach-Review aus Übungsblatt 3 (`docs/02-review/uebung3-modellierung.md`). Überarbeitete Anforderungen sind mit Version `2` gekennzeichnet.

---

## Aufgabe 1 - Erstellen Sie eine strukturierte Liste mit funktionalen Anforderungen

Formulierungsschema: *Nach [Bedingung] muss das System [Akteur] die Möglichkeit bieten, [Funktion] auszuführen.*

| ID | Version | Status | Feature | Priorität | Anforderungsname | Beschreibung | Quelle |
|---|---|---|---|---|---|---|---|
| F-010 | 1 | Entwurf | Benutzerkonto | Muss | Registrieren und Anmelden | Nach Eingabe gültiger Registrierungsdaten (E-Mail, Passwort) muss das System Nutzern die Möglichkeit bieten, ein Konto anzulegen und sich anzumelden. | US11 |
| F-020 | 1 | Entwurf | Verlustmeldung | Muss | Verlust melden | Nach Anmeldung muss das System Verlierern die Möglichkeit bieten, einen Verlust mit Kategorie, Beschreibung, Ort, Zeitraum und optionalem Foto zu melden. | US1 |
| F-030 | 1 | Entwurf | Fundmeldung | Muss | Fund melden | Nach Anmeldung muss das System Findern die Möglichkeit bieten, einen Fund mit Foto, Beschreibung und automatisch erfasstem Standort zu melden. | US2 |
| F-040 | 2 | Entwurf | Abgleich und Benachrichtigung | Muss | Automatischer Abgleich | Nach dem Speichern einer Verlust- oder Fundmeldung muss das System offene Gegenmeldungen abgleichen und einen Treffer zuordnen, wenn die Kategorie übereinstimmt und mindestens 70 von 100 Punkten erreicht werden (Ort 30, Zeit 30, Farbe 20, Marke oder Stichwort 20). Meldungen mit 50 bis 69 Punkten werden nur als „ähnliche Fundsache“ angezeigt. | US3 |
| F-041 | 2 | Entwurf | Abgleich und Benachrichtigung | Muss | Treffer-Benachrichtigung | Nach Erkennen eines Treffers (mindestens 70 Punkte) muss das System Verlierern die Möglichkeit bieten, per Push-Nachricht informiert zu werden (bei Nichtzustellung per E-Mail). | US3 |
| F-050 | 1 | Entwurf | Suche | Soll | Fundsachen suchen und filtern | Nach Eingabe eines Suchbegriffs muss das System Nutzern die Möglichkeit bieten, Fundsachen nach Kategorie, Ort, Datum und Stichwort zu filtern. | US4 |
| F-060 | 1 | Entwurf | Eigentumsnachweis | Muss | Eigentum nachweisen | Nach Auswahl von „Das ist meiner“ muss das System Verlierern Kontrollfragen zu nicht öffentlichen Merkmalen stellen und das Ergebnis speichern. | US5 |
| F-070 | 2 | Entwurf | Terminvergabe | Soll | Abholtermin buchen | Nach erfolgreichem Eigentumsnachweis muss das System Verlierern die Möglichkeit bieten, einen freien Abholtermin zu buchen und einen QR-Code zu erhalten. Der QR-Code ist nur ein Schlüssel zum Vorgang und ersetzt nicht die Ausweisprüfung bei der Abholung. | US6 |
| F-071 | 1 | Entwurf | Terminvergabe | Soll | Vertretung bevollmächtigen | Nach erfolgreichem Eigentumsnachweis muss das System Verlierern die Möglichkeit bieten, eine Vertretung mit Name zu benennen und eine digitale Vollmacht zu hinterlegen. | US6 |
| F-080 | 1 | Entwurf | Fundverwaltung und Herausgabe | Muss | Fundsache verwalten | Nach Eingang einer Fundsache muss das System Sachbearbeitern die Möglichkeit bieten, Lagerort und Status zu erfassen und zu ändern. | US7 |
| F-090 | 2 | Entwurf | Fundverwaltung und Herausgabe | Muss | Herausgabe dokumentieren | Nach Scan des QR-Codes und bestätigter Ausweisprüfung muss das System Sachbearbeitern die Möglichkeit bieten, die Herausgabe mit Datum und Bearbeiter zu protokollieren. Bei Abholung durch eine Vertretung sind zusätzlich der Ausweis der Vertretung und eine hinterlegte Vollmacht erforderlich. | US8 |
| F-100 | 1 | Entwurf | Fristenverwaltung | Kann | Ablaufende Fristen anzeigen | 14 Tage vor Fristende muss das System Sachbearbeitern die Möglichkeit bieten, die betroffenen Fundsachen in einer Liste einzusehen. | US9 |
| F-110 | 1 | Entwurf | Finder-Rückmeldung | Kann | Finder informieren | Nach der Herausgabe muss das System Findern die Möglichkeit bieten, eine Rückmeldung über den Erfolg zu erhalten. | US10 |

---

## Aufgabe 2 - Erstellen Sie eine strukturierte Liste mit nicht-funktionalen Anforderungen

| ID | Ver. | Quelle | Geltungsbereich | Anforderungsname | Anforderungsbeschreibung |
|---|---|---|---|---|---|
| N-010 | 1 | US1, US2 | Verlust- und Fundmeldung | Antwortzeit | Bei 100 parallelen Meldungen müssen mindestens 95 % der Speichervorgänge innerhalb von 2 Sekunden bestätigt werden. |
| N-020 | 1 | US1, US2 | Verlust- und Fundmeldung | Bedienbarkeit | Eine Erstnutzerin muss eine Verlustmeldung in höchstens 2 Minuten ohne Hilfe abschließen können (Test mit 5 Personen, mindestens 4 erfolgreich). |
| N-030 | 2 | US5, US8, US11 | Gesamtsystem | Datenschutz | Personenbezogene Daten müssen DSGVO-konform verarbeitet werden. Kontaktdaten sind nur dem Besitzer und Sachbearbeitern zugänglich, und die Übertragung erfolgt per TLS 1.2 oder höher. Ausweisnummern werden nicht gespeichert. |
| N-040 | 1 | US11 | Benutzerkonto | Passwortsicherheit | Passwörter müssen mit einem Hashverfahren (z. B. bcrypt) gespeichert werden. Nach 5 fehlgeschlagenen Anmeldungen wird das Konto für 15 Minuten gesperrt. |
| N-050 | 1 | US7, US8 | Verwaltungsoberfläche | Barrierefreiheit | Die Oberfläche muss WCAG 2.1 Stufe AA erfüllen (Kontrast mind. 4,5:1, volle Tastaturbedienung, skalierbare Schrift bis 200 %). |
| N-060 | 1 | US3 | Abgleich | Zuverlässigkeit | Nach Speichern einer Meldung muss der Abgleich in 95 % der Fälle innerhalb von 60 Sekunden abgeschlossen und die Benachrichtigung ausgelöst sein. |
| N-070 | 1 | alle | Gesamtsystem | Wartbarkeit | Die Testabdeckung muss mindestens 70 % betragen. Neue Kategorien müssen ohne Codeänderung per Konfiguration ergänzbar sein. |
| N-080 | 2 | US8 | Herausgabe | Nachvollziehbarkeit | Jede Herausgabe muss unveränderlich protokolliert und 3 Jahre lang abrufbar sein. Das Protokoll enthält nur Datum, Uhrzeit, Fund-ID, Meldenummer, Bearbeiter-ID, Ergebnis und eine interne Nutzer-ID, aber keine Namen, Kontaktdaten oder Ausweisnummern. Bei Kontolöschung wird die Verknüpfung zur Nutzer-ID entfernt, der Protokolleintrag bleibt erhalten. |

---

## Aufgabe 3 - Versehen Sie Ihre Anforderungen mit Akzeptanzkriterien

### F-020: Verlust melden

1. Die Meldung „Rucksack, schwarz, S-Bahn S3, 17:30–18:15 Uhr“ wird gespeichert, erhält eine Meldenummer und erscheint in „Meine Meldungen“ mit Status „Offen“.
2. Fehlt ein Pflichtfeld (Kategorie, Beschreibung oder Ort), wird nicht gespeichert und das Feld wird markiert.
3. Das Foto ist optional. Ohne Foto wird die Meldung trotzdem gespeichert.
4. Bei fehlender Netzverbindung wird die Eingabe lokal als Entwurf gespeichert und nach Wiederherstellung der Verbindung gesendet.

### F-040: Automatischer Abgleich

1. Zu der Verlustmeldung „schwarzer Rucksack, S3, 17:30–18:15“ wird die Fundmeldung „schwarzer Rucksack, S3-Endhaltestelle, 20:10“ angelegt. Die Kategorie stimmt überein, das System berechnet 100 Punkte, es entsteht ein Treffer, der beiden Meldungen zugeordnet wird, und Lena erhält eine Push-Nachricht.
2. Bei abweichender Kategorie (Fund: „Schlüssel“, Verlust: „Rucksack“) entsteht kein Treffer, unabhängig von der Punktzahl der übrigen Kriterien.
3. Ein verworfener Treffer („Nicht mein Gegenstand“) wird für diese Verlustmeldung nicht erneut vorgeschlagen.
4. Bei gleicher Kategorie und nur 60 Punkten entsteht kein Treffer und keine Push-Nachricht, die Fundsache erscheint aber als „ähnliche Fundsache“. Mehrere Treffer werden nach Punkten absteigend sortiert.

### F-090: Herausgabe dokumentieren

1. Nach Scan eines gültigen QR-Codes zeigt das System Fundsache und Anfrage. Nach Bestätigung der Ausweisprüfung steht der Status auf „Herausgegeben“, und Datum, Uhrzeit und Bearbeiter sind gespeichert. Das Protokoll ist danach nicht mehr änderbar.
2. Ein bereits genutzter oder abgelaufener QR-Code wird mit Fehlermeldung abgelehnt.
3. Verweigert der Sachbearbeiter die Herausgabe, muss er einen Grund eingeben. Der Status bleibt „Reserviert“.
4. Holt eine Vertretung ab, ist die Herausgabe nur mit dem Ausweis der Vertretung und einer hinterlegten digitalen Vollmacht möglich. Ohne Vollmacht lehnt das System die Herausgabe ab.

### N-010: Antwortzeit

1. Testbedingung: Lasttest mit 100 parallelen Nutzern, je ein Foto bis 3 MB, WLAN mit mind. 20 Mbit/s. Mindestens 95 von 100 Anfragen werden in höchstens 2 Sekunden bestätigt.
2. Bei 100 parallelen Anfragen gehen keine Meldungen verloren (100 % gespeichert).
3. Die durchschnittliche Antwortzeit bei Einzelanfragen liegt unter 1 Sekunde.

### N-030: Datenschutz

1. Alle Verbindungen nutzen TLS 1.2 oder höher. Ein Zugriff über unverschlüsseltes HTTP wird abgelehnt (Test per Security-Scan).
2. Ein Finder sieht in der Treffer-Ansicht keine Kontaktdaten des Verlierers und umgekehrt.
3. Nach Kontolöschung werden personenbezogene Daten (Name, E-Mail, Kontaktdaten, Meldungen) innerhalb von 30 Tagen gelöscht, vorher ist ein Datenexport möglich. Im Herausgabeprotokoll erscheint der Nutzer danach nur noch als „gelöschter Nutzer“, der Protokolleintrag bleibt erhalten.
4. Ein Nutzer ohne Sachbearbeiterrolle erhält beim Aufruf der Verwaltungsoberfläche „403 Zugriff verweigert“.

---

## Aufgabe 4 - Fassen Sie Ihre User Stories in Features zusammen und priorisieren Sie die Features in einer Roadmap

### Features und zugeordnete Anforderungen

| Nr. | Feature | Anforderungen |
|---|---|---|
| 1 | Benutzerkonto | F-010, N-040 |
| 2 | Verlustmeldung | F-020, N-010, N-020 |
| 3 | Fundmeldung | F-030, N-010, N-020 |
| 4 | Abgleich und Benachrichtigung | F-040, F-041, N-060 |
| 5 | Eigentumsnachweis | F-060 |
| 6 | Fundverwaltung und Herausgabe | F-080, F-090, N-050, N-080 |
| 7 | Suche | F-050 |
| 8 | Terminvergabe | F-070, F-071 |
| 9 | Fristenverwaltung | F-100 |
| 10 | Finder-Rückmeldung | F-110 |
| – | **Übergreifend (Gesamtsystem)** | N-030 Datenschutz, N-070 Wartbarkeit |

### Roadmap

| Stufe | Features |
|---|---|
| **Sofort** (Release 1) | 1 Benutzerkonto, 2 Verlustmeldung, 3 Fundmeldung, 4 Abgleich und Benachrichtigung, 5 Eigentumsnachweis, 6 Fundverwaltung und Herausgabe |
| **Nächstes** (Release 2) | 7 Suche, 8 Terminvergabe |
| **Später** | 9 Fristenverwaltung, 10 Finder-Rückmeldung |
| **Nie** | Online-Bezahlung für Postversand, eigene Social-Media-Funktion (außerhalb des Kernziels, hoher Aufwand und Risiko) |

### Begründung: Feature 4 „Abgleich und Benachrichtigung“ (Sofort)

- **Nutzen für die Personas:** Der automatische Abgleich ist das Alleinstellungsmerkmal der App. Lena (Verliererin) will nicht ständig selbst suchen und möchte sofort erfahren, wenn ihr Rucksack gefunden wurde. Genau das löst ihr Hauptproblem: unklare Zuständigkeiten und fehlende Rückmeldung. Tom (Finder) profitiert indirekt, weil sein Fund automatisch dem richtigen Besitzer zugeordnet wird. Klaus (Sachbearbeiter) bekommt weniger telefonische Nachfragen, weil Treffer ohne sein Zutun entstehen. Ohne dieses Feature wäre die App nur eine digitale Kartei ohne Vorteil gegenüber dem bisherigen Verfahren.
- **Abhängigkeiten:** Das Feature braucht angemeldete Nutzer sowie Verlust- und Fundmeldungen (Features 1 bis 3) und muss daher im selben Release kommen. Umgekehrt setzen Eigentumsnachweis (5) und Herausgabe (6) einen Treffer voraus und sind ohne Abgleich nur eingeschränkt sinnvoll.
- **Voraussichtlicher Aufwand:** Mittel. Der Kern ist ein regelbasierter Abgleich über Kategorie, Ort, Zeitfenster und Stichwörter, der ohne KI auskommt. Die Push-Anbindung ist über Standarddienste (z. B. Firebase) überschaubar. Ein Bildvergleich wäre aufwändig und gehört deshalb nicht in Release 1.
- **Fazit:** Hoher Nutzen, klare Abhängigkeiten zu Kernfeatures und beherrschbarer Aufwand in der einfachen Variante ergeben die Einstufung „Sofort“. Das Aufwand-Nutzen-Verhältnis ist deutlich besser als bei der Fristenverwaltung, die nur Klaus betrifft und sich auch manuell lösen lässt (daher „Später“).
