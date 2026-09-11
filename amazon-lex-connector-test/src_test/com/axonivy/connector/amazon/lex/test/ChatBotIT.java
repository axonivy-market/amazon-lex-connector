package com.axonivy.connector.amazon.lex.test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;

import com.axonivy.connector.amazon.lex.test.mock.MockAmazonLex;
import com.axonivy.ivy.webtest.IvyWebTest;
import com.axonivy.ivy.webtest.engine.EngineUrl;
import com.axonivy.ivy.webtest.engine.WebAppFixture;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import ch.ivyteam.ivy.rest.client.mapper.JsonFeature;

/**
 * Test the Amazon Lex Demo
 */
@IvyWebTest
public class ChatBotIT {

  @ParameterizedTest(name = "{0}")
  @MethodSource("variants")
  public void chatBot(Variant variant, WebAppFixture fixture) {
    if (variant == Variant.MOCK) {
      routeLexClientToMock(fixture);
    }

    // valid links can be copied from the start page of the internal web-browser
    open(EngineUrl.createProcessUrl("amazon-lex-connector-demo/17B2F6A64C6C86D0/chatBot.ivp"));

    // fill new customer form
    sendInputAndWait("Book a hotel");
    sendInputAndWait("New York");
    sendInputAndWait("tomorrow");
    sendInputAndWait("five");
    sendInputAndWait("queen");
    sendInput("yes, please");

    $(By.id("form:confirmation"))
        .shouldBe(Condition.matchText("BookHotel"))
        .shouldBe(Condition.matchText("CheckInDate="))
        .shouldBe(Condition.matchText("Location=New York"))
        .shouldBe(Condition.matchText("Nights=5"))
        .shouldBe(Condition.matchText("RoomType=queen"));
  }

  private static Stream<Variant> variants() {
    if (Boolean.getBoolean("amazon.lex.e2e")) {
      return Stream.of(Variant.MOCK, Variant.E2E);
    }
    return Stream.of(Variant.MOCK);
  }

  private static void routeLexClientToMock(WebAppFixture fixture) {
    var lexClient = "RestClients.Amazon-Lex-Amazon-Lex-Runtime-V2";
    fixture.config(lexClient + ".Url", EngineUrl.createRestUrl(MockAmazonLex.PATH_SUFFIX));
    fixture.config(lexClient + ".Features", List.of(JsonFeature.class.getName()));
  }

  private enum Variant {
    MOCK,
    E2E
  }

  private void sendInputAndWait(String input) {
    var chatSize = sendInput(input);
    SelenideElement chatForm = $(By.id("form:chat"));
    ElementsCollection childElements = chatForm.$$(By.tagName("div"));
    childElements.get(chatSize + 1).shouldHave(appear, Duration.ofSeconds(10));
  }

  private int sendInput(String input) {
    var chatSize = $(By.id("form:chat")).findElements(By.tagName("div")).size();
    $(By.id("form:input")).sendKeys(input);
    $(By.id("form:send")).shouldBe(enabled).click();
    return chatSize;
  }
}