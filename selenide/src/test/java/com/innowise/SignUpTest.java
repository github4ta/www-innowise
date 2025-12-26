package com.innowise;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SignUpTest {
    private final String URL = "https://innowise.com/";

    private final String INPUT_EMAIL = "input[id='EMAIL']";
    private final String BUTTON_SIGN_UP = "button[form='sib-form']";
    private final String SUCCESS_MESSAGE = "div[id='success-message']";

    private final String SUCCESS_MESSAGE_TEXT = "Your subscription has been successful.";

    @Test
    public void test1() {
        Faker faker = new Faker();

        open(URL);

        $(INPUT_EMAIL).setValue(faker.internet().emailAddress());
        $(BUTTON_SIGN_UP).click();

        String actualSuccessMessage = $(SUCCESS_MESSAGE).getText();

        Assertions.assertEquals(SUCCESS_MESSAGE_TEXT, actualSuccessMessage);
    }

    @Test
    public void test2() {
        Faker faker = new Faker();

        open(URL);

        $(INPUT_EMAIL).setValue(faker.internet().emailAddress());
        $(BUTTON_SIGN_UP).shouldBe(clickable).click();

        String actualSuccessMessage = $(SUCCESS_MESSAGE).getText();

        Assertions.assertEquals(SUCCESS_MESSAGE_TEXT, actualSuccessMessage);
    }

    @Test
    public void test3() {
        Faker faker = new Faker();

        open(URL);

        $(INPUT_EMAIL).scrollTo().setValue(faker.internet().emailAddress());
        $(BUTTON_SIGN_UP).click();

        String actualSuccessMessage = $(SUCCESS_MESSAGE).getText();

        Assertions.assertEquals(SUCCESS_MESSAGE_TEXT, actualSuccessMessage);
    }

    @Test
    public void test4() {
        Faker faker = new Faker();

        open(URL);

        $(INPUT_EMAIL).scrollTo().setValue(faker.internet().emailAddress());
        $(BUTTON_SIGN_UP).click();

        String actualSuccessMessage = $(SUCCESS_MESSAGE).shouldBe(visible).getText();

        Assertions.assertEquals(SUCCESS_MESSAGE_TEXT, actualSuccessMessage);
    }
}
