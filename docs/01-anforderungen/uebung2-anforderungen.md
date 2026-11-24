# Übungsblatt 2: Anforderungen, Akzeptanzkriterien & Roadmap – „FundPunkt“

## Aufgabe 1 – Funktionale Anforderungen

Schema: *Nach [Bedingung] muss das System [Akteur] die Möglichkeit bieten, [Funktion] auszuführen.*

| ID | Version | Status | Feature | Priorität | Anforderungsname | Beschreibung | Quelle |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| F-010 | 1 | Entwurf | Fundverwaltung | Muss | Fundmeldung anlegen | Nach erfolgreicher Anmeldung muss das System Findern die Möglichkeit bieten, eine neue Fundmeldung mit Titel, Kategorie, Fundort, Funddatum und verdecktem Sicherheitsmerkmal zu erfassen. | US-01 |
| F-020 | 1 | Entwurf | Fundsuche | Muss | Fundgegenstände suchen | Nach Eingabe eines Suchbegriffs und optional einer Kategorie muss das System Suchenden die Möglichkeit bieten, alle passenden offenen Fundmeldungen in einer Ergebnisliste anzuzeigen. | US-02 |
| F-030 | 1 | Entwurf | Rückgabeabwicklung | Muss | Rückgabeanfrage stellen | Nach Auswahl einer offenen Fundmeldung muss das System angemeldeten Suchenden die Möglichkeit bieten, eine Rückgabeanfrage mit einem Eigentumsnachweis einzureichen. | US-03, UC-01 |
| F-040 | 1 | Entwurf | Rückgabeabwicklung | Muss | Anspruch bestätigen oder ablehnen | Nach Eingang einer Rückgabeanfrage muss das System dem Finder die Möglichkeit bieten, den Eigentumsnachweis zu prüfen und die Anfrage zu bestätigen oder abzulehnen. | US-04, UC-01 |
| F-050 | 1 | Entwurf | Rückgabeabwicklung | Soll | Rückgabeanfrage stornieren | Nach Erstellung oder Bestätigung einer Rückgabeanfrage (vor erfolgter Übergabe) muss das System der Suchenden die Möglichkeit bieten, die Anfrage zu stornieren. | US-05, UC-01 |
| F-060 | 1 | Entwurf | Rückgabeabwicklung | Muss | Rückgabe dokumentieren | Nach Bestätigung einer Rückgabeanfrage muss das System dem Finder die Möglichkeit bieten, die physische Übergabe des Gegenstands zu dokumentieren und die Fundmeldung abzuschließen. | US-06, UC-01 |

---

## Aufgabe 2 – Nicht-funktionale Anforderungen

| ID | Ver. | Quelle | Geltungsbereich | Anforderungsname | Anforderungsbeschreibung |
| :--- | :--- | :--- | :--- | :--- | :--- |
| N-010 | 1 | UC-01, US-02 | Fundsuche | Antwortzeit Suche | Bei bis zu 100 parallelen Suchanfragen müssen mindestens 95 % der Anfragen innerhalb von 2 Sekunden mit der Ergebnisliste beantwortet werden. |
| N-020 | 1 | Persona Markus | Gesamtes System | Vertraulichkeit Sicherheitsmerkmal & Kontaktdaten | Das System darf das verdeckte Sicherheitsmerkmal einer Fundmeldung sowie die Kontaktdaten des Finders niemals öffentlich anzeigen; Kontaktdaten dürfen erst nach Bestätigung der Anfrage ausschließlich der berechtigten Suchenden angezeigt werden. |
| N-030 | 1 | Persona Anna | Benutzeroberfläche | Benutzbarkeit & Barrierefreiheit | Alle Kernfunktionen (Fund melden, Suche, Anspruch stellen) müssen die WCAG-2.1-Richtlinien der Stufe AA erfüllen und auf Mobilgeräten ab 360 px Breite ohne horizontales Scrollen bedienbar sein. |
| N-040 | 1 | Gesamtsystem | Gesamtes System | Wartbarkeit & Modularität | Die Fachlogik (Nutzer, Fundmeldung, Rückgabeanfrage) muss strikt von der Ein-/Ausgabe getrennt sein und eine automatisierte Testabdeckung der Kernmethoden von mindestens 80 % aufweisen. |

---

## Aufgabe 3 – Akzeptanzkriterien

### Funktionale Anforderung F-020 – Fundgegenstände suchen
*Nach Eingabe eines Suchbegriffs und optional einer Kategorie muss das System Suchenden die Möglichkeit bieten, alle passenden offenen Fundmeldungen in einer Ergebnisliste anzuzeigen.*

**Akzeptanzkriterien:**
1. Wird der Suchbegriff „Rucksack“ eingegeben, zeigt das System alle Fundmeldungen im Status *Gemeldet* an, deren Titel oder Kategorie den Begriff enthalten.
2. Wird zusätzlich die Kategorie „Taschen“ gewählt, werden ausschließlich offene Fundmeldungen dieser Kategorie angezeigt.
3. Fundmeldungen im Status *Zurückgegeben* oder *Archiviert* erscheinen nicht in der öffentlichen Ergebnisliste.
4. Liefert eine Suche keine Treffer (z. B. „Regenschirm“), zeigt das System eine leere Liste mit dem Hinweis „Keine passenden Fundmeldungen gefunden“ an.

### Funktionale Anforderung F-030 – Rückgabeanfrage stellen
*Nach Auswahl einer offenen Fundmeldung muss das System angemeldeten Suchenden die Möglichkeit bieten, eine Rückgabeanfrage mit einem Eigentumsnachweis einzureichen.*

**Akzeptanzkriterien:**
1. Reicht eine angemeldete Suchende zu einer Fundmeldung im Status *Gemeldet* einen nicht-leeren Eigentumsnachweis ein, wird eine neue Rückgabeanfrage im Status *Angefragt* erstellt und die Fundmeldung wechselt auf *Beansprucht*.
2. Ist das Feld für den Eigentumsnachweis leer, verweigert das System das Absenden und zeigt eine eindeutige Fehlermeldung an.
3. Befindet sich die Fundmeldung nicht im Status *Gemeldet* (z. B. bereits *Beansprucht* oder *Zurückgegeben*), lehnt das System die Anfrage mit einem Hinweis ab.

### Funktionale Anforderung F-050 – Rückgabeanfrage stornieren
*Nach Erstellung oder Bestätigung einer Rückgabeanfrage (vor erfolgter Übergabe) muss das System der Suchenden die Möglichkeit bieten, die Anfrage zu stornieren.*

**Akzeptanzkriterien:**
1. Storniert die Suchende eine Rückgabeanfrage im Status *Angefragt* oder *Bestätigt*, wechselt der Status der Anfrage auf *Storniert*.
2. Gleichzeitig wird der Status der zugehörigen Fundmeldung automatisch wieder auf *Gemeldet* zurückgesetzt, sodass sie erneut gesucht und beansprucht werden kann.
3. Befindet sich die Rückgabeanfrage bereits im Status *Abgeschlossen*, lehnt das System eine Stornierung ab.

### Nicht-funktionale Anforderung N-010 – Antwortzeit Suche
*Bei bis zu 100 parallelen Suchanfragen müssen mindestens 95 % der Anfragen innerhalb von 2 Sekunden mit der Ergebnisliste beantwortet werden.*

**Akzeptanzkriterien:**
1. *Testbedingung:* Lasttest mit 100 simulierten parallelen Nutzern auf einem Bestand von 1.000 Fundmeldungen über 60 Sekunden.
2. Das 95. Perzentil (p95) der Antwortzeiten liegt bei $\le 2,0\text{ s}$.
3. Die Fehlerrate (HTTP-Status 5xx oder Timeouts) liegt bei $0\,\%$.

### Nicht-funktionale Anforderung N-020 – Vertraulichkeit Sicherheitsmerkmal & Kontaktdaten
*Das System darf das verdeckte Sicherheitsmerkmal einer Fundmeldung sowie die Kontaktdaten des Finders niemals öffentlich anzeigen; Kontaktdaten dürfen erst nach Bestätigung der Anfrage ausschließlich der berechtigten Suchenden angezeigt werden.*

**Akzeptanzkriterien:**
1. In der öffentlichen Suchliste und der Detailansicht einer Fundmeldung wird das Attribut `sicherheitsmerkmal` niemals ausgegeben.
2. Solange eine Rückgabeanfrage im Status *Angefragt*, *Abgelehnt* oder *Storniert* ist, bleiben E-Mail-Adresse und Übergabedetails des Finders verborgen.
3. Erst wenn die Anfrage den Status *Bestätigt* erreicht, werden die Übergabedetails ausschließlich für die anfragende Nutzerin freigeschaltet.

---

## Aufgabe 4 – Features und Roadmap

### Feature-Zuordnung
- **Feature 1: Benutzer- & Fundverwaltung**
  - F-010 (Fundmeldung anlegen)
  - N-020 (Vertraulichkeit), N-040 (Wartbarkeit)
- **Feature 2: Fundsuche**
  - F-020 (Fundgegenstände suchen)
  - N-010 (Antwortzeit Suche), N-030 (Benutzbarkeit)
- **Feature 3: Rückgabeabwicklung & Eigentumsprüfung**
  - F-030 (Rückgabeanfrage stellen), F-040 (Anspruch bestätigen/ablehnen), F-050 (Stornieren), F-060 (Rückgabe dokumentieren)
  - N-020 (Vertraulichkeit), N-030 (Benutzbarkeit)
- **Feature 4: Verlustmeldungen & automatisches Matching (Erweiterung)**
  - Suchende können verlorene Gegenstände melden und werden automatisch benachrichtigt, wenn passende Funde eingehen.
- **Feature 5: Automatische Archivierungs- & Aufbewahrungsfristen (Erweiterung)**
  - Automatische Archivierung nach Ablauf der gesetzlichen Aufbewahrungsfrist (6 Monate).
- **Feature 6: Online-Versteigerung nicht abgeholter Fundstücke**
  - Integrierte Auktionsplattform mit Zahlungsabwicklung für abgelaufene Fundsachen.

### Roadmap

| Zeithorizont | Features |
| :--- | :--- |
| **Sofort (Release 1 – MVP)** | Feature 1 (Benutzer- & Fundverwaltung), Feature 2 (Fundsuche), Feature 3 (Rückgabeabwicklung & Eigentumsprüfung) |
| **Nächstes (Release 2)** | Feature 4 (Verlustmeldungen & automatisches Matching) |
| **Später (Release 3)** | Feature 5 (Automatische Archivierungs- & Aufbewahrungsfristen) |
| **Nie (Out of Scope)** | Feature 6 (Online-Versteigerung nicht abgeholter Fundstücke) |

### Begründung der Priorisierung (Beispiel: Feature 3 – Rückgabeabwicklung & Eigentumsprüfung -> „Sofort“)
- **Nutzen für die Personas:** Ohne den verifizierten Rückgabeprozess kann Anna ihren Rucksack nicht verbindlich abholen und Markus hat keine Sicherheit, dass der Gegenstand an die echte Besitzerin geht.
- **Abhängigkeiten:** Feature 3 setzt direkt auf Feature 1 (erfasste Fundmeldungen) und Feature 2 (Auffinden eines Gegenstands) auf und schließt den Kernprozess eines Fundbüros ab.
- **Implementierungsaufwand:** Der Aufwand ist überschaubar, da eine klar definierte Zustandslogik ohne komplexe KI-Matching-Algorithmen (Feature 4) oder externe Zahlungssysteme (Feature 6) ausreicht.
