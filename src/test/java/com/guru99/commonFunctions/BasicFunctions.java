package com.guru99.commonFunctions;

import com.google.common.io.Resources;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.core.util.Loader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class BasicFunctions {
    protected WebDriver driver;
    protected Properties pro;
    protected String baseUrl ;
    protected int timeOut;

    @Before
    public void openBrowser() throws IOException {

        URL url = Resources.getResource("applications/config.properties");
        pro = new Properties();
        pro.load(url.openStream());
        baseUrl = pro.getProperty("base.url");
        timeOut = Integer.parseInt(pro.getProperty("time"));
       //System.setProperty("webdriver.gecko.driver", "C:\\Users\\saiso\\Software\\Firefox_Driver\\geckodriver.exe");
       // WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }


    @After
    public void closeBrowser() {
        // driver.quit();

    }


}
