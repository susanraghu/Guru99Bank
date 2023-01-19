package com.Guru99;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class login {

    WebDriver driver;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.gecko.driver", "G:\\geckodriver.exe"); // Setting system properties of FirefoxDriver
        String pathToBinary = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(pathToBinary);
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
    }

    @Given("browser is launched and user is navigated to {string}")
    public void browserIsLaunchedAndUserIsNavigatedTo(String url) {

        driver.get(url);

        driver.switchTo().alert().accept();
    }

    @When("user enters username as {string}")
    public void userEntersUsernameAs(String arg0) {
        driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]")).sendKeys("arg0");

    }

    @And("user enters password as {string}")
    public void userEntersPasswordAs(String arg0) {
        driver.findElement(By.xpath("//tbody/tr[2]/td[2]/input[1]")).sendKeys("arg0");
    }
}
