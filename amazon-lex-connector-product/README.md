Axon Ivy's [Amazon Lex API](https://aws.amazon.com/lex/)  connector integrates Amazon Lex, a service for building conversational interfaces, into your process automation workflows. This integration allows you to leverage Natural Language Processing (NLP) and Machine Learning (ML) capabilities provided by Amazon Lex within your Axon Ivy processes.

Key features of the Amazon Lex API connector:

- **Intent Recognition**: Intent recognition is a natural language processing (NLP) technique used to identify the goal or purpose behind a user's input.
- **Bi-directional Communication**: The API provides methods to send messages from your process to the bot and receive responses back, facilitating seamless communication between your process and the conversational interface.
- **Demo Implementation**: Axon Ivy offers a ready-to-use demo implementation that you can easily adapt to your specific use case. This reduces your integration effort and helps you quickly get started with incorporating Amazon Lex into your processes.
- **Freemium Pricing**: The connector is based on Amazon Web Services' (AWS) freemium pricing model, which means you can start using the service for free up to a certain usage threshold. This allows you to experiment and evaluate the benefits of conversational interfaces in your processes without upfront costs.

It's important to note that while both Amazon Lex and ChatGPT use NLP and ML techniques, they serve different purposes. ChatGPT is a large language model trained by OpenAI to engage in open-ended conversations and assist with various tasks. On the other hand, Amazon Lex is a service specifically designed for building conversational interfaces (chatbots) with predefined intents and actions.

**With Axon Ivy's Amazon Lex API connector, you can enhance your process automation initiatives by introducing conversational capabilities, making your processes more user-friendly and accessible through natural language interactions.**

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
