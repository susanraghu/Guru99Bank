package com.guru99.pages;

import com.google.common.io.Resources;
import com.guru99.commonFunctions.BasicFunctions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Login {
    protected WebDriver driver;
    protected Properties pro;
    protected String baseUrl;
    protected int timeOut;

    @Before
    public void openBrowser() throws IOException {

        URL url = Resources.getResource("applications/config.properties");
        Properties properties = new Properties();
        properties.load(url.openStream());
        baseUrl = properties.getProperty("base.url");
        timeOut = Integer.parseInt(properties.getProperty("time"));
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.of(timeOut, ChronoUnit.SECONDS));
    }

    @Given("Open Firefox and launch the application {string}")
    public void openFirefoxAndLaunchTheApplication(String url) {
        driver.get(baseUrl + url);
        driver.manage().timeouts().implicitlyWait(Duration.of(timeOut, ChronoUnit.SECONDS));
        //driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
        driver.switchTo().frame("gdpr-consent-notice");
        driver.findElement(By.xpath("/html/body/app-root/app-theme/div/div/app-notice/app-theme/div/div/app-home/div/div[2]/app-footer/div/div[2]/app-action-buttons/div/button[3]/span[1]/div/span")).click();
        driver.switchTo().parentFrame();
    }

    @When("userid {string} is entered")
    public void useridIsEntered(String userId) {
        driver.findElement(By.name("uid")).sendKeys(userId);
    }

    @And("password {string} is entered")
    public void passwordIsEntered(String passwords) {
        driver.findElement(By.name("password")).sendKeys(passwords);
    }

    @And("click on {string} button")
    public void clickOnButton(String Login) {
        driver.findElement(By.name("btnLogin")).click();

    }

    @Then("the page must be redirected to {string}")
    public void thePageMustBeRedirectedTo(String url) {
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = baseUrl + url;

        assertEquals(actualUrl, expectedUrl);
    }

    @And("title is {string}")
    public void titleIs(String titleHomePage) {

        String actual = driver.getTitle();
        String expected = titleHomePage;

        assertEquals(actual, expected);

    }

    @Then("the page must display error popup with message {string}")
    public void thePageMustDisplayErrorPopupWithMessage(String message) {
        String actual = driver.switchTo().alert().getText();
        assertEquals(message, actual);

    }
}