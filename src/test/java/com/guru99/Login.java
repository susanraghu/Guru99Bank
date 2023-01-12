package com.guru99;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login {
    WebDriver driver;


    @Before
    public void openBrowser(){
         driver = new FirefoxDriver();
        driver.manage().window().maximize();

    }


    @Given("Open Firefox and launch the application {string}")
    public void openFirefoxAndLaunchTheApplication(String url) {
     driver.get(url);

    }

    @When("userid {string} is entered")
    public void useridIsEntered(String arg0) {
    }

    @And("password {string} is entered")
    public void passwordIsEntered(String arg0) {
    }

    @And("click on {string} button")
    public void clickOnButton(String arg0) {

    }
}
