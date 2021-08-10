[Ivy]
17B2F6A64C6C86D0 9.2.0 #module
>Proto >Proto Collection #zClass
Lo0 LexDemo Big #zClass
Lo0 B #cInfo
Lo0 #process
Lo0 @AnnotationInP-0n ai ai #zField
Lo0 @TextInP .type .type #zField
Lo0 @TextInP .processKind .processKind #zField
Lo0 @TextInP .xml .xml #zField
Lo0 @TextInP .responsibility .responsibility #zField
Lo0 @StartRequest f0 '' #zField
Lo0 @EndTask f1 '' #zField
Lo0 @UserDialog f3 '' #zField
Lo0 @PushWFArc f4 '' #zField
Lo0 @PushWFArc f2 '' #zField
>Proto Lo0 Lo0 LexDemo #zField
Lo0 f0 outLink chatBot.ivp #txt
Lo0 f0 inParamDecl '<> param;' #txt
Lo0 f0 requestEnabled true #txt
Lo0 f0 triggerEnabled false #txt
Lo0 f0 callSignature chatBot() #txt
Lo0 f0 startName 'Amazon Lex Chat Bot' #txt
Lo0 f0 startDescription 'Amazon Lex based Chat Bot' #txt
Lo0 f0 caseData businessCase.attach=true #txt
Lo0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>chatBot.ivp</name>
    </language>
</elementInfo>
' #txt
Lo0 f0 @C|.responsibility Everybody #txt
Lo0 f0 81 49 30 30 -21 17 #rect
Lo0 f1 337 49 30 30 0 15 #rect
Lo0 f3 dialogId com.axonivy.connector.amazon.lex.demo.ChatBot #txt
Lo0 f3 startMethod start() #txt
Lo0 f3 requestActionDecl '<> param;' #txt
Lo0 f3 responseMappingAction 'out=in;
' #txt
Lo0 f3 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>ChatBot</name>
    </language>
</elementInfo>
' #txt
Lo0 f3 168 42 112 44 -22 -8 #rect
Lo0 f4 111 64 168 64 #arcP
Lo0 f2 280 64 337 64 #arcP
>Proto Lo0 .type com.axonivy.connector.amazon.lex.demo.Data #txt
>Proto Lo0 .processKind NORMAL #txt
>Proto Lo0 0 0 32 24 18 0 #rect
>Proto Lo0 @|BIcon #fIcon
Lo0 f0 mainOut f4 tail #connect
Lo0 f4 head f3 mainIn #connect
Lo0 f3 mainOut f2 tail #connect
Lo0 f2 head f1 mainIn #connect
