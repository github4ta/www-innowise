package com.innowise.pages;

import com.innowise.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final String URL = "https://innowise.com/";
    private final String URL_THANK_YOU = "https://innowise.com/thank-you/";

    private final String INPUT_EMAIL = "//input[@id='EMAIL']";
    private final String BUTTON_SIGN_UP = "//button[@form='sib-form']";
    private final String SUCCESS_MESSAGE = "//div[@id='success-message']";
    private final String COPYRIGHT_TEXT = "//p[@class='copyright-text']";

    private final String BUTTON_SEARCH = "//div[@class='bot-serach-cli']";
    private final String INPUT_SEARCH ="//form[@class='new-form-menu']/input[@name='s']";
    private final String BUTTON_SUBMIT_SEARCH = "//form[@class='new-form-menu']/input[@type='submit']";
    private final String MESSAGE_NO_RESULTS= "//div[@class='search-result']";

    private final String BUTTON_CONTACT_US = "//div[@class='new-block-cont']";
    private final String INPUT_CONTACT_NAME = "//input[@id='contact-name']";
    private final String INPUT_CONTACT_COMPANY = "//input[@id='contact-company']";
    private final String INPUT_CONTACT_EMAIL = "//input[@id='contact-email']";
    private final String INPUT_CONTACT_PHONE = "//input[@id='contact-phone']";
    private final String TEXTAREA_CONTACT_MESSAGE = "//textarea[@id='contact-message']";
    private final String BUTTON_CONTACT_SEND = "//input[@id='contact-send-button']";

    private WebDriver driver;

    public HomePage() {
        driver = Driver.getDriver();
    }

    public void open() {
        driver.get(URL);
    }

    public void sendKeysToInputEmail(String email) {
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(email);
    }

    public void clickButtonSignUp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement buttonSignUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BUTTON_SIGN_UP)));
        buttonSignUp.click();
    }

    public String getSuccessMessageText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(SUCCESS_MESSAGE)));
        return successMessage.getText();
    }

    public void scrollDown() {
        Driver.scrollPageToTheWebElement();
    }

    public void clickButtonSearch() {
        driver.findElement(By.xpath(BUTTON_SEARCH)).click();
    }

    public void clickButtonSubmitSearch() {
        driver.findElement(By.xpath(BUTTON_SUBMIT_SEARCH)).click();
    }

    public void sendKeysToInputSearch(String search) {
        driver.findElement(By.xpath(INPUT_SEARCH)).sendKeys(search);
    }

    public String getMessageNoResultsText() {
        return driver.findElement(By.xpath(MESSAGE_NO_RESULTS)).getText();
    }

    public void clickButtonContactUs() {
        driver.findElement(By.xpath(BUTTON_CONTACT_US)).click();
    }

    public void sendKeysToInputContactName(String name) {
        driver.findElement(By.xpath(INPUT_CONTACT_NAME)).sendKeys(name);
    }

    public void sendKeysToInputContactCompany(String company) {
        driver.findElement(By.xpath(INPUT_CONTACT_COMPANY)).sendKeys(company);
    }

    public void sendKeysToInputContactEmail(String email) {
        driver.findElement(By.xpath(INPUT_CONTACT_EMAIL)).sendKeys(email);
    }

    public void sendKeysToInputContactPhone(String phone) {
        driver.findElement(By.xpath(INPUT_CONTACT_PHONE)).sendKeys(phone);
    }

    public void sendKeysToInputContactMessage(String message) {
        driver.findElement(By.xpath(TEXTAREA_CONTACT_MESSAGE)).sendKeys(message);
    }

    public void clickButtonContactSend() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
        Driver.waitFor(4);
        driver.findElement(By.xpath(BUTTON_CONTACT_SEND)).click();
    }

    public String getThankYouUrl() {
        return driver.getCurrentUrl();
    }
}
