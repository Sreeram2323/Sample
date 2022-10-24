package com.main;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
public class Base {
    public WebDriver driver;
    public WebDriver driverinstance(String browser) {
        switch(browser)  {

            case "Chrome": {

                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            }
            case "Firefox": {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            }
            case "Edge": {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            }
            case "Safari": {
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
            }

        }
        return driver;
    }
}
