#Axon Efeus [#Amazon Lex API](https://aws.amazon.com/lex/) Anschluss integriert
#Amazon Lex, eine Bedienung für bauen gesprächige Schnittstellen, hinein eure
Arbeitsgang Automatisierung workflows. Diese Integration erlaubt du zu
#aushebeln Naturale Sprache Verarbeitung (NLP) und Maschine #Lernen (#ML)
Fähigkeiten versehen bei #Amazon Lex innerhalb eure #Axon #Ivy verarbeitet.

Wesentliche Charakterzüge von #der #Amazon Lex API Anschluss:

- **Absicht Bestätigung**: Absicht Bestätigung ist eine naturale Sprache
  Verarbeitung (NLP) Methode benutzte zu identifizieren das Tor oder Zweck
  hinter einen NutzersInput.
- **Bi-#Direktional Kommunikation**: Das API versieht Methoden zu senden
  Meldungen von eurem Arbeitsgang zu dem bot und empfangen Antworten rückwärtig,
  unterstützend nahtlose Kommunikation zwischen eurem Arbeitsgang und die
  gesprächige Schnittstelle.
- **Demo Ausführung**: #Axon #Ivy bietet an ein bereites-zu-Nutzung Demo
  Ausführung dass du kannst sicher zu eurer spezifischen Nutzung Fall
  adaptieren. Dies setzt herunter eure Integration Anstrengung und hilft du
  schnell #loslegen mit verleiben #Amazon Lex hinein eure Arbeitsgänge.
- **Freemium #Preisfindung**: Der Anschluss ist gegründet auf #Amazon Web
  Bedienungens (AWS) freemium #Preisfindung Model, welcher bedeutet du kannst
  starten benutzen #kostenlos die Bedienung bis einem gewissen Gebrauch
  Schwelle. Dies erlaubt du zu experimentieren und auswerten die Nutzen von
  gesprächig Schnittstellen in euren Arbeitsgängen #ohne upfront Preise.

Es ist wichtig zu beachten jene Weile #beide #Amazon Lex und ChatGPT Nutzung NLP
und #ML Methoden, sie servieren verschiedene Zwecke. ChatGPT Ist eine große
Sprache Model trainiert mal OpenAI zu verloben herein offen-endete
Unterhaltungen und assistieren mit verschiedenen Tasks. Andererseits, #Amazon
Lex ist speziell eine Bedienung gestaltet für bauen gesprächige Schnittstellen
(chatbots) mit #vordefiniert Absichten und Aktionen.

**Mit #Axon Efeus #Amazon Lex API Anschluss, du kannst eure Arbeitsgang
Automatisierung Initiativen erweitern mal hereinbringen gesprächige Fähigkeiten,
machend eure Arbeitsgänge #mehr Nutzer-freundlich und erreichbar durch natural
Sprache Interaktionen.**

## Demo

### Schwatz Bot

Der Schwatz bot Demo ist gegründet weiter die amazon BookTrip Demo bot.
1. Tipp ein #vorbestellen Text du magst hinein das Text Feld gleichnamig: _Ich
   mögen ein Hotel vorbestellen_ oder _ich mögen ein Auto vorbestellen_.
2. Beantworte die Fragen von die bots
3. #Amazon Lex wollen herausfinden eure Absicht und versieht Zusatzinformation
   in der Bestätigung.

![Demo-verarbeite](images/lex-demo.png)

## Einrichtung

1. Zuerst brauchst du zu schaffen #ein #Amazon Lex bot. Geh zu
   https://aws.amazon.com

2. Anmeldung oder schaffen ein neues Konto.

3. Klick auf Bedienungen / #Amazon Lex.

4. Klick auf #loslegen Steuert und folgen die Weisung zu schaffen ein neues bot.
   Sicher jener du schaffst ein V2 bot Nutzung Vorlage BookTrip

![Demo-verarbeite](images/lex-bot.png)

5. Konfigurier die folgenden Variablen in eurem Projekt:

```
Variables:

  Amazon.Lex:

    # Secret key to access amazon lex
    # [password] 
    SecretKey: <YOUR_SECRET_KEY>

    # Access key to access amazon lex
    # [password]
    AccessKey: <YOUR_ACCESS_KEY>

    # Identifier of the amazon lex bot alias that should be called
    BotAliasId: <YOUR_BOT_ALIAS_ID>

    # Identifier of the amazon lex bot that should be called
    BotId: <YOUR_BOT_ID>
```
