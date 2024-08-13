package com.axonivy.connector.amazon.lex.test;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import com.axonivy.ivy.webtest.IvyWebTest;
import com.axonivy.ivy.webtest.engine.EngineUrl;
import com.codeborne.selenide.Condition;

import ch.ivyteam.ivy.environment.Ivy;

/**
 * Test the Amazon Lex Demo
 */
@IvyWebTest(headless = true)
public class ChatBotIT {

  @Test
  public void chatBot() {
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

  private void sendInputAndWait(String input) {
    var chatSize = sendInput(input);
    //$(By.id("form:chat")).findElements(By.tagName("div")).get(chatSize + 1).isDisplayed();
  }

  private int sendInput(String input) {
    var chatSize = $(By.id("form:chat")).findElements(By.tagName("div")).size();
    $(By.id("form:input")).sendKeys(input);
    $(By.id("form:send")).shouldBe(enabled).click();
    return chatSize;
  }
}