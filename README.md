# Uni Würzburg Discord Bot

- Automatisierter Discord Bot, geschrieben in Java (mit Gradle).
- Der Bot liest jeden Morgen den aktuellen Speiseplan der Mensa über eine API aus und postet ihn in einen Discord-Server.


# Roadmap
- Projekt aufsetzen und Github Repository erstellen [X]
- JDA einbinden und den Bot online bringen [X]
- Täglich den Speiseplan der Mensa auslesen können [X]
- Diesen dann automatisch jeden Morgen im Discord Server posten [X]
- Rollen-Verteil-System bauen damit jeder Nutzer selbst entscheiden kann, ob er vom Bot gepinged werden kann [X]


- Später: Evtl. Implementierung von Erinnerungen für Abgabefristen
- Später: Evtl. Implementierung automatischer Erinnerung an Klausuranmeldephasen und Prüfungstermine


 # Wichtige genutzte Bibliotheken:
- JDA (Java Discord API): Für die Verbindung zum Discord-Kanal
- OkHttp: Für die HTTP-Anfrage an die OpenMensa-API
- Gson (Google): Um die JSON-Daten der API zu parsen
- ScheduledExecutorService: Für die automatische Zeitsteuerung 
