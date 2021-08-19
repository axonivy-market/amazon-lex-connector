package com.axonivy.connector.amazon.lex.connector;

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import com.amazonaws.lex.runtime.v2.Intent;
import com.amazonaws.lex.runtime.v2.IntentState;
import com.amazonaws.lex.runtime.v2.Interpretation;
import com.amazonaws.lex.runtime.v2.Message;
import com.amazonaws.lex.runtime.v2.RecognizeTextResponse;
import com.amazonaws.lex.runtime.v2.Slot;

public class BotResponse {

  public static List<String> messages(RecognizeTextResponse result) {
    if (result.getMessages() == null) {
      return Collections.emptyList();
    }
    return result.getMessages().stream()
      .map(Message::getContent)
      .collect(Collectors.toList());
  }

  public static String stringify(Intent intent) {
    Map<String, String> recognized = getSlotMap(intent);
    return intent.getName() + " " + recognized;
  }

  public static Intent getIntent(RecognizeTextResponse result) {
    var confirmed = EnumSet.of(
      IntentState.READYFORFULFILLMENT,
      IntentState.FULFILLED);
    return findIntent(result, confirmed).orElse(null);
  }

  private static Optional<Intent> findIntent(RecognizeTextResponse result, EnumSet<IntentState> states) {
    return result.getInterpretations().stream()
      .map(Interpretation::getIntent)
      .filter(intent -> states.contains(intent.getState()))
      .filter(intent -> !intent.getSlots().isEmpty())
      .findFirst();
  }

  private static Map<String, String> getSlotMap(Intent intent) {
    Map<String, String> recognized = new HashMap<>();
    for (Entry<String, Slot> entry : intent.getSlots().entrySet()) {
      String val = entry.getValue().getValue().getInterpretedValue();
      recognized.put(entry.getKey(), val);
    }
    return recognized;
  }

}
