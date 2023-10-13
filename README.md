# KLAPP

Aufgabenstellung: Programmieren Sie eine Klettersteig Applikation, welche sowohl auf Android als auch am Web ausführbar ist und funktioniert. Diese App soll dazu dienen Klettersteige zu erstellen, anzuzeigen und sich mit anderen Klettersteigbesuchern auzutauschen. Dies soll mittels QR-Codes, welche beim Klettersteig angebracht werden möglich gemacht werden. Beim Scannen dieser Codes soll man in einen Chat-Room mit den anderen Klettersteig besuchern geworfen werden.



Umsetzung:

- Die Entwicklerumgebung ist Android-Studio

- Als Datenbank wird Mysql innerhabl des Schulnetzwerkes benutzt

- Version Control wird mit GIT umgesetzt
Tutorial: https://youtu.be/uGLQF2kUwOA

 - Datensätze für Datenbank:
  
    Attribute:
      - ID [number]
      - der Name des Klettersteigs [STRING]
      - die Beschreibung des Klettersteigs [STRING]
      - die Anstiegszeit [STRING]
      - die Abstiegszeit [STRING]
      - [?] das Datum ab dem der Klettersteig begehbar ist [string]
      - [?] das Datum ab dem der Klettersteig nicht mehr begehbar ist [string]
      - der Status des Klettersteigs (begehbar/nicht begehbar) [boolean]
      - die Meereshöhe des Startpunktes [number]
      - die Meereshöhe des Endpunktes [number]
      - [?] das Bundesland in dem sich der Klettersteig befindet [STRING] (geolink?)
      - die Schwierigkeit des Klettersteigs (A-F) [STRING]
      - [?] die Ausrichtung des Klettersteigs nach den Himmelsrichtungen [STRING] (geolink?)
      - der Link zur Website des Klettersteigs (falls vorhanden) [STRING]
      - die Account-ID des Users, der den Klettersteig erstellt hat [STRING]
      - das Datum an dem der Klettersteig erstellt wurde [late DateTime?]
      - eine Liste mit den Speicherorten aller Bilder [STRING]
  
  - Account:

    Attribute:
      - der Benutzername [late STRING]
      - die E-Mail [late STRING]
      - die User-ID [late STRING]
      - [?] der Speicherpfad des Profilbildes [late STRING?]
      - die Telefonnummer des Users [late STRING?]
      - das Datum an dem der Account erstellt wurde [late DateTime]
      - die Benutzer-Rolle [late AccountRoll]
      
