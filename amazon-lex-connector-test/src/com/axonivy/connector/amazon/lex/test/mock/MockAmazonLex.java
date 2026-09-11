package com.axonivy.connector.amazon.lex.test.mock;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.ivyteam.ivy.engine.rest.service.annotation.csrf.DisableCsrfProtection;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path(MockAmazonLex.PATH_SUFFIX)
@PermitAll
@Hidden
@SuppressWarnings("all")
@DisableCsrfProtection
public class MockAmazonLex {

  private static final ObjectMapper MAPPER = new ObjectMapper();

  public static final String PATH_SUFFIX = "amazonLexMock";

  @POST
  @Path("bots/{botId}/botAliases/{botAliasId}/botLocales/{localeId}/sessions/{sessionId}/text")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response recognizeText(String request,
      @PathParam("botId") String botId,
      @PathParam("botAliasId") String botAliasId,
      @PathParam("localeId") String localeId,
      @PathParam("sessionId") String sessionId) {
    var response = switch (json(request).path("text").asText()) {
      case "Book a hotel" -> Feedback.BOOK_HOTEL;
      case "New York" -> Feedback.NEW_YORK;
      case "tomorrow" -> Feedback.TOMORROW;
      case "five" -> Feedback.FIVE;
      case "queen" -> Feedback.QUEEN;
      case "yes, please" -> Feedback.YES_PLEASE;
      default -> null;
    };
    if (response == null) {
      return Response.status(Response.Status.BAD_REQUEST)
          .entity("Unsupported Lex mock request: " + request)
          .build();
    }
    return Response.ok(response.formatted(sessionId), MediaType.APPLICATION_JSON).build();
  }

  private static JsonNode json(String raw) {
    try {
      return MAPPER.readTree(raw);
    } catch (Exception ex) {
      throw new RuntimeException("Failed to parse JSON from string: " + raw, ex);
    }
  }

  private interface Feedback {

    String BOOK_HOTEL = """
        {"interpretations":[{"intent":{"confirmationState":"None","name":"BookHotel","slots":{"CheckInDate":null,"Location":null,"Nights":null,"RoomType":null},"state":"InProgress"},"interpretationSource":"Lex","nluConfidence":{"score":1.0}},{"intent":{"name":"BookCar","slots":{"CarType":null,"DriverAge":null,"PickUpCity":null,"PickUpDate":null,"ReturnDate":null}},"interpretationSource":"Lex","nluConfidence":{"score":0.48}},{"intent":{"name":"FallbackIntent","slots":{}},"interpretationSource":"Lex"}],"messages":[{"content":"What city will you be staying in?","contentType":"PlainText"}],"sessionId":"%s","sessionState":{"dialogAction":{"slotToElicit":"Location","type":"ElicitSlot"},"intent":{"confirmationState":"None","name":"BookHotel","slots":{"CheckInDate":null,"Location":null,"Nights":null,"RoomType":null},"state":"InProgress"}},"originatingRequestId":"c31a3f13-10ad-436f-bea3-a1d77b431229"}
        """;

    String NEW_YORK = """
        {"interpretations":[{"intent":{"confirmationState":"None","name":"BookHotel","slots":{"CheckInDate":null,"Location":{"value":{"interpretedValue":"New York","originalValue":"New York","resolvedValues":["new york"]}},"Nights":null,"RoomType":null},"state":"InProgress"},"interpretationSource":"Lex","nluConfidence":{"score":1.0}},{"intent":{"name":"BookCar","slots":{"CarType":null,"DriverAge":null,"PickUpCity":null,"PickUpDate":null,"ReturnDate":null}},"interpretationSource":"Lex","nluConfidence":{"score":0.53}},{"intent":{"name":"FallbackIntent","slots":{}},"interpretationSource":"Lex"}],"messages":[{"content":"What day do you want to check in?","contentType":"PlainText"}],"sessionId":"%s","sessionState":{"dialogAction":{"slotToElicit":"CheckInDate","type":"ElicitSlot"},"intent":{"confirmationState":"None","name":"BookHotel","slots":{"CheckInDate":null,"Location":{"value":{"interpretedValue":"New York","originalValue":"New York","resolvedValues":["new york"]}},"Nights":null,"RoomType":null},"state":"InProgress"}},"originatingRequestId":"c31a3f13-10ad-436f-bea3-a1d77b431229"}
        """;

    String TOMORROW = """
        {"interpretations":[{"intent":{"confirmationState":"None","name":"BookHotel","slots":{"CheckInDate":{"value":{"interpretedValue":"2026-09-12","originalValue":"tomorrow","resolvedValues":["2026-09-12"]}},"Location":{"value":{"interpretedValue":"New York","originalValue":"New York","resolvedValues":["new york"]}},"Nights":null,"RoomType":null},"state":"InProgress"},"interpretationSource":"Lex","nluConfidence":{"score":1.0}},{"intent":{"name":"FallbackIntent","slots":{}},"interpretationSource":"Lex"},{"intent":{"name":"BookCar","slots":{"CarType":null,"DriverAge":null,"PickUpCity":null,"PickUpDate":null,"ReturnDate":null}},"interpretationSource":"Lex","nluConfidence":{"score":0.29}}],"messages":[{"content":"How many nights will you be staying?","contentType":"PlainText"}],"sessionId":"%s","sessionState":{"dialogAction":{"slotToElicit":"Nights","type":"ElicitSlot"},"intent":{"confirmationState":"None","name":"BookHotel","slots":{"CheckInDate":{"value":{"interpretedValue":"2026-09-12","originalValue":"tomorrow","resolvedValues":["2026-09-12"]}},"Location":{"value":{"interpretedValue":"New York","originalValue":"New York","resolvedValues":["new york"]}},"Nights":null,"RoomType":null},"state":"InProgress"}},"originatingRequestId":"c31a3f13-10ad-436f-bea3-a1d77b431229"}
        """;

    String FIVE = """
        {"interpretations":[{"intent":{"confirmationState":"None","name":"BookHotel","slots":{"CheckInDate":{"value":{"interpretedValue":"2026-09-12","originalValue":"tomorrow","resolvedValues":["2026-09-12"]}},"Location":{"value":{"interpretedValue":"New York","originalValue":"New York","resolvedValues":["new york"]}},"Nights":{"value":{"interpretedValue":"5","originalValue":"five","resolvedValues":["5"]}},"RoomType":null},"state":"InProgress"},"interpretationSource":"Lex","nluConfidence":{"score":1.0}},{"intent":{"name":"FallbackIntent","slots":{}},"interpretationSource":"Lex"},{"intent":{"name":"BookCar","slots":{"CarType":{"value":{"interpretedValue":"five","originalValue":"five","resolvedValues":[]}},"DriverAge":null,"PickUpCity":null,"PickUpDate":null,"ReturnDate":null}},"interpretationSource":"Lex","nluConfidence":{"score":0.29}}],"messages":[{"content":"What type of room would you like, queen, king or deluxe?","contentType":"PlainText"}],"sessionId":"%s","sessionState":{"dialogAction":{"slotToElicit":"RoomType","type":"ElicitSlot"},"intent":{"confirmationState":"None","name":"BookHotel","slots":{"CheckInDate":{"value":{"interpretedValue":"2026-09-12","originalValue":"tomorrow","resolvedValues":["2026-09-12"]}},"Location":{"value":{"interpretedValue":"New York","originalValue":"New York","resolvedValues":["new york"]}},"Nights":{"value":{"interpretedValue":"5","originalValue":"five","resolvedValues":["5"]}},"RoomType":null},"state":"InProgress"}},"originatingRequestId":"c31a3f13-10ad-436f-bea3-a1d77b431229"}
        """;

    String QUEEN = """
        {"interpretations":[{"intent":{"confirmationState":"None","name":"BookHotel","slots":{"CheckInDate":{"value":{"interpretedValue":"2026-09-12","originalValue":"tomorrow","resolvedValues":["2026-09-12"]}},"Location":{"value":{"interpretedValue":"New York","originalValue":"New York","resolvedValues":["new york"]}},"Nights":{"value":{"interpretedValue":"5","originalValue":"five","resolvedValues":["5"]}},"RoomType":{"value":{"interpretedValue":"queen","originalValue":"queen","resolvedValues":["queen"]}}},"state":"InProgress"},"interpretationSource":"Lex","nluConfidence":{"score":1.0}},{"intent":{"name":"FallbackIntent","slots":{}},"interpretationSource":"Lex"},{"intent":{"name":"BookCar","slots":{"CarType":null,"DriverAge":null,"PickUpCity":null,"PickUpDate":null,"ReturnDate":null}},"interpretationSource":"Lex","nluConfidence":{"score":0.31}}],"messages":[{"content":"Okay, I have you down for a 5 night stay in New York starting 2026-09-12.  Shall I book the reservation?","contentType":"PlainText"}],"sessionId":"%s","sessionState":{"dialogAction":{"type":"ConfirmIntent"},"intent":{"confirmationState":"None","name":"BookHotel","slots":{"CheckInDate":{"value":{"interpretedValue":"2026-09-12","originalValue":"tomorrow","resolvedValues":["2026-09-12"]}},"Location":{"value":{"interpretedValue":"New York","originalValue":"New York","resolvedValues":["new york"]}},"Nights":{"value":{"interpretedValue":"5","originalValue":"five","resolvedValues":["5"]}},"RoomType":{"value":{"interpretedValue":"queen","originalValue":"queen","resolvedValues":["queen"]}}},"state":"InProgress"}},"originatingRequestId":"c31a3f13-10ad-436f-bea3-a1d77b431229"}
        """;

    String YES_PLEASE = """
        {"interpretations":[{"intent":{"confirmationState":"Confirmed","name":"BookHotel","slots":{"CheckInDate":{"value":{"interpretedValue":"2026-09-12","originalValue":"tomorrow","resolvedValues":["2026-09-12"]}},"Location":{"value":{"interpretedValue":"New York","originalValue":"New York","resolvedValues":["new york"]}},"Nights":{"value":{"interpretedValue":"5","originalValue":"five","resolvedValues":["5"]}},"RoomType":{"value":{"interpretedValue":"queen","originalValue":"queen","resolvedValues":["queen"]}}},"state":"ReadyForFulfillment"},"interpretationSource":"Lex","nluConfidence":{"score":1.0}},{"intent":{"name":"FallbackIntent","slots":{}},"interpretationSource":"Lex"},{"intent":{"name":"BookCar","slots":{"CarType":null,"DriverAge":null,"PickUpCity":null,"PickUpDate":null,"ReturnDate":null}},"interpretationSource":"Lex","nluConfidence":{"score":0.22}}],"sessionId":"%s","sessionState":{"dialogAction":{"type":"Close"},"intent":{"confirmationState":"Confirmed","name":"BookHotel","slots":{"CheckInDate":{"value":{"interpretedValue":"2026-09-12","originalValue":"tomorrow","resolvedValues":["2026-09-12"]}},"Location":{"value":{"interpretedValue":"New York","originalValue":"New York","resolvedValues":["new york"]}},"Nights":{"value":{"interpretedValue":"5","originalValue":"five","resolvedValues":["5"]}},"RoomType":{"value":{"interpretedValue":"queen","originalValue":"queen","resolvedValues":["queen"]}}},"state":"ReadyForFulfillment"}},"originatingRequestId":"c31a3f13-10ad-436f-bea3-a1d77b431229"}
        """;
  
  }
}