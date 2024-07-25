Die [Amazon Lex API](https://aws.amazon.com/lex/) von Axon Ivy verbindet Amazon Lex mit deinen Prozessautomatisierungs-Workflows. Durch diese Integration kannst du die Möglichkeiten der natürlichen Sprachverarbeitung (NLP) und des maschinellen Lernens (ML) von Amazon Lex direkt in deinen Axon Ivy-Prozessen nutzen.

Die wichtigsten Funktionen der Amazon Lex API:

- **Erkennung von Absichten** : (Intent Recognition) Die Erkennung von Absichten ist eine NLP-Technik, mit der das Ziel oder der Zweck hinter der Eingabe eines Benutzers identifiziert wird.
- **Bi-direktionale** Kommunikation: Die API bietet Methoden, um Nachrichten von deinem Prozess an den Bot zu senden  und Antworten zurückzuerhalten. So wird eine bi-direktionale Kommunikation  zwischen deinem Prozess und der Konversationsschnittstelle ermöglicht.
- **Demo-Implementierung**: Axon Ivy bietet eine einsatzbereite Demo-Implementierung, die du einfach an deine spezifischen Anforderungen anpassen kannst. Das reduziert deinen Integrationsaufwand und hilft dir, Amazon Lex schnell in deine Prozesse einzubinden.
- **Freemium-Preismodell**: Die Schnittstelle basiert auf dem Freemium-Preismodell von Amazon Web Services (AWS). Das bedeutet, du kannst den Dienst bis zu einem bestimmten Nutzungsumfang kostenlos verwenden. So kannst du die Vorteile von Konversationsschnittstellen in deinen Prozessen kostenlos testen und bewerten.
  
**Was ist der Unterschied zu ChatGPT?**

Amazon Lex und ChatGPT verwenden zwar beide NLP- und ML-Techniken, verfolgen aber unterschiedliche Ziele. ChatGPT ist ein umfangreiches Sprachmodell, das von OpenAI trainiert wurde, um offene Gespräche zu führen.
Amazon Lex hingegen ist ein Dienst, der speziell für die Erstellung von Chatbots mit vordefinierten  Absichten und Aktionen entwickelt wurde.
**Mit der Amazon Lex API von Axon Ivy hast du die Möglichkeit, deine Prozessautomatisierung
zu optimieren, indem du Chatbot-Funktionalitäten hinzufügst. Auf diese Weise werden deine Prozesse dank der Interaktion in natürlicher Sprache intuitiver und benutzerfreundlicher**.

## Demo

### Chat Bot

The chat bot demo is based on the amazon BookTrip demo bot. 
1. Type a booking text you like into the text field like: _I want to book a hotel_ or _I want to book a car_.
2. Answer the questions of the bots
3. Amazon Lex will detect your intent and provides additional information in the confirmation.

![demo-process](images/lex-demo.png)

## Setup

1. First you need to create a Amazon Lex bot.
   Go to https://aws.amazon.com

2. Login or create a new account.

3. Click on Services / Amazon Lex.

4. Click on Getting Started Guide and follow the instruction to create a new bot. 
  Ensure that you create a V2 bot
  Use template BookTrip
  
![demo-process](images/lex-bot.png)  

5. Configure the following variables in your project:

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

