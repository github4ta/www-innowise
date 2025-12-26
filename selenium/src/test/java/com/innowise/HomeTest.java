package com.innowise;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeTest {
    private final String URL = "https://innowise.com/";

    private final String INPUT_EMAIL = "//input[@id='EMAIL']";
    private final String BUTTON_SIGN_UP = "//button[@form='sib-form']";
    private final String SUCCESS_MESSAGE = "//div[@id='success-message']";

    private final String SUCCESS_MESSAGE_TEXT = "Your subscription has been successful.";

    private WebDriver driver;
    private Faker faker;

    @BeforeEach
    public void setUp() {
        faker = new Faker();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(URL);
    }

    @Test
    public void test1() {
        WebElement inputEmail = driver.findElement(By.xpath(INPUT_EMAIL));
        inputEmail.sendKeys(faker.internet().emailAddress());

        WebElement buttonSignUp = driver.findElement(By.xpath(BUTTON_SIGN_UP));
        buttonSignUp.click();

        WebElement successMessage = driver.findElement(By.xpath(SUCCESS_MESSAGE));
        String actualSuccessMessage = successMessage.getText();

        Assertions.assertEquals(SUCCESS_MESSAGE_TEXT, actualSuccessMessage);
    }

    @Test
    public void test2() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        WebElement inputEmail = driver.findElement(By.xpath(INPUT_EMAIL));
        inputEmail.sendKeys(faker.internet().emailAddress());

        WebElement buttonSignUp = driver.findElement(By.xpath(BUTTON_SIGN_UP));
        buttonSignUp.click();

        WebElement successMessage = driver.findElement(By.xpath(SUCCESS_MESSAGE));
        String actualSuccessMessage = successMessage.getText();

        Assertions.assertEquals(SUCCESS_MESSAGE_TEXT, actualSuccessMessage);
    }

    @Test
    public void test3() {
        WebElement inputEmail = driver.findElement(By.xpath(INPUT_EMAIL));
        inputEmail.sendKeys(faker.internet().emailAddress());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(4));
        WebElement buttonSignUp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_SIGN_UP)));
        buttonSignUp.click();

        WebElement successMessage = driver.findElement(By.xpath(SUCCESS_MESSAGE));
        String actualSuccessMessage = successMessage.getText();

        Assertions.assertEquals(SUCCESS_MESSAGE_TEXT, actualSuccessMessage);
    }

    @Test
    public void test4() {
        WebElement inputEmail = driver.findElement(By.xpath(INPUT_EMAIL));
        inputEmail.sendKeys(faker.internet().emailAddress());

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementClickInterceptedException.class);
        WebElement buttonSignUp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_SIGN_UP)));
        buttonSignUp.click();

        WebElement successMessage = driver.findElement(By.xpath(SUCCESS_MESSAGE));
        String actualSuccessMessage = successMessage.getText();

        Assertions.assertEquals(SUCCESS_MESSAGE_TEXT, actualSuccessMessage);
    }

    @Test
    public void test5() {
        WebElement inputEmail = driver.findElement(By.xpath(INPUT_EMAIL));
        new Actions(driver).scrollToElement(inputEmail).perform();
        inputEmail.sendKeys(faker.internet().emailAddress());

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(2)).pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementClickInterceptedException.class);
        WebElement buttonSignUp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_SIGN_UP)));
        buttonSignUp.click();

        WebElement successMessage = driver.findElement(By.xpath(SUCCESS_MESSAGE));
        String actualSuccessMessage = successMessage.getText();

        Assertions.assertEquals(SUCCESS_MESSAGE_TEXT, actualSuccessMessage);
    }

    @Test
    public void test6() {
        WebElement inputEmail = driver.findElement(By.xpath(INPUT_EMAIL));
        new Actions(driver)
                .scrollToElement(inputEmail)
                .perform();
        inputEmail.sendKeys(faker.internet().emailAddress());

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementClickInterceptedException.class);
        WebElement buttonSignUp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_SIGN_UP)));
        buttonSignUp.click();

        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementClickInterceptedException.class);
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SUCCESS_MESSAGE)));
        String actualSuccessMessage = successMessage.getText();

        Assertions.assertEquals(SUCCESS_MESSAGE_TEXT, actualSuccessMessage);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
