[Ivy]
17B2F6BE1C69F667 9.2.0 #module
>Proto >Proto Collection #zClass
Cs0 ChatBotProcess Big #zClass
Cs0 RD #cInfo
Cs0 #process
Cs0 @AnnotationInP-0n ai ai #zField
Cs0 @TextInP .type .type #zField
Cs0 @TextInP .processKind .processKind #zField
Cs0 @TextInP .xml .xml #zField
Cs0 @TextInP .responsibility .responsibility #zField
Cs0 @UdInit f0 '' #zField
Cs0 @UdProcessEnd f1 '' #zField
Cs0 @PushWFArc f2 '' #zField
Cs0 @UdEvent f3 '' #zField
Cs0 @GridStep f4 '' #zField
Cs0 @PushWFArc f5 '' #zField
Cs0 @RestClientCall f6 '' #zField
Cs0 @PushWFArc f7 '' #zField
Cs0 @UdProcessEnd f8 '' #zField
Cs0 @PushWFArc f9 '' #zField
>Proto Cs0 Cs0 ChatBotProcess #zField
Cs0 f0 guid 17B2F6BE1CE1230E #txt
Cs0 f0 method start() #txt
Cs0 f0 inParameterDecl '<> param;' #txt
Cs0 f0 inParameterMapAction 'out.sessionId=java.util.UUID.randomUUID().toString();
' #txt
Cs0 f0 inActionCode 'import com.axonivy.connector.amazon.lex.demo.Message;
Message message = new Message();
message.what = "How can I help you?";
message.icon = "si si-messages-bubble";
out.messages.add(message);' #txt
Cs0 f0 outParameterDecl '<> result;' #txt
Cs0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start()</name>
    </language>
</elementInfo>
' #txt
Cs0 f0 83 51 26 26 -16 15 #rect
Cs0 f1 211 51 26 26 0 12 #rect
Cs0 f2 109 64 211 64 #arcP
Cs0 f3 guid 17B2F6F682852A08 #txt
Cs0 f3 actionTable 'out=in;
' #txt
Cs0 f3 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>send</name>
    </language>
</elementInfo>
' #txt
Cs0 f3 83 147 26 26 -14 15 #rect
Cs0 f4 actionTable 'out=in;
' #txt
Cs0 f4 actionCode 'import com.axonivy.connector.amazon.lex.demo.Message;
Message message;
message.what = in.input;
message.icon = "si si-single-neutral-actions";
out.messages.add(message);' #txt
Cs0 f4 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Add input to messages</name>
    </language>
</elementInfo>
' #txt
Cs0 f4 136 138 144 44 -63 -8 #rect
Cs0 f5 109 160 136 160 #arcP
Cs0 f6 clientId 13f7783c-cd64-4625-a663-82b504bd4195 #txt
Cs0 f6 path /bots/{botId}/botAliases/{botAliasId}/botLocales/{localeId}/sessions/{sessionId}/text #txt
Cs0 f6 templateParams 'botAliasId=ivy.var.Amazon_Lex_BotAliasId;
botId=ivy.var.Amazon_Lex_BotId;
sessionId=in.sessionId;
localeId="en_US";
' #txt
Cs0 f6 properties 'accessKey=ivy.var.Amazon_Lex_AccessKey;
secretKey=ivy.var.Amazon_Lex_SecretKey;
' #txt
Cs0 f6 method POST #txt
Cs0 f6 bodyInputType ENTITY #txt
Cs0 f6 bodyObjectType com.amazonaws.lex.runtime.v2.SessionIdTextBody #txt
Cs0 f6 bodyObjectMapping 'param.text=in.input;
' #txt
Cs0 f6 resultType com.amazonaws.lex.runtime.v2.RecognizeTextResponse #txt
Cs0 f6 responseCode 'import com.amazonaws.lex.runtime.v2.Intent;
import com.axonivy.connector.amazon.lex.connector.BotResponse;
import com.axonivy.connector.amazon.lex.demo.Message;

List<String> messages = BotResponse.messages(result);
if (!messages.isEmpty()) {
	Message message;
	message.what = messages.get(0);
	message.icon = "si si-messages-bubble";
	out.messages.add(message);
} else if (BotResponse.getIntent(result) is initialized) {
	Intent intent = BotResponse.getIntent(result);
	out.confirmation = BotResponse.stringify(intent);
	out.finished = true;
}
in.input = "";' #txt
Cs0 f6 clientErrorCode ivy:error:rest:client #txt
Cs0 f6 statusErrorCode ivy:error:rest:client #txt
Cs0 f6 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Send input to Amazon Lex</name>
    </language>
</elementInfo>
' #txt
Cs0 f6 312 138 160 44 -70 -8 #rect
Cs0 f7 280 160 312 160 #arcP
Cs0 f8 507 147 26 26 0 12 #rect
Cs0 f9 472 160 507 160 #arcP
>Proto Cs0 .type com.axonivy.connector.amazon.lex.demo.ChatBot.ChatBotData #txt
>Proto Cs0 .processKind HTML_DIALOG #txt
>Proto Cs0 -8 -8 16 16 16 26 #rect
Cs0 f0 mainOut f2 tail #connect
Cs0 f2 head f1 mainIn #connect
Cs0 f3 mainOut f5 tail #connect
Cs0 f5 head f4 mainIn #connect
Cs0 f4 mainOut f7 tail #connect
Cs0 f7 head f6 mainIn #connect
Cs0 f6 mainOut f9 tail #connect
Cs0 f9 head f8 mainIn #connect
