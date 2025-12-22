package com.innowise;

import com.github.javafaker.Faker;
import com.innowise.driver.Driver;
import com.innowise.pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HomeTest {
    HomePage homePage;

    @BeforeEach
    public void openHomePage() {
        homePage = new HomePage();
        homePage.open();
    }

    @Test
    public void testSignUpWithEmail() {
        Faker faker = new Faker();

        homePage.sendKeysToInputEmail(faker.internet().emailAddress());
        Driver.waitFor(2);
        homePage.clickButtonSignUp();

        String actualSuccessMessage = homePage.getSuccessMessageText();
        Assertions.assertEquals("Your subscription has been successful.", actualSuccessMessage);
    }

    @AfterEach
    public void tearDown() {
        Driver.quit();
    }
}
