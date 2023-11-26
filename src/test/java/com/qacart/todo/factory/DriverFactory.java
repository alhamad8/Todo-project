package com.qacart.todo.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.oer.Switch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private  WebDriver  driver;
    public WebDriver intializeDriver() {

        String browser = System.getProperty("browser","CHROME");
        switch  (browser){
            case"CHROME":
                WebDriverManager.chromedriver().setup();
                  driver = new ChromeDriver();
                break;
            case"FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "EDGE":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "SAFARI":
                driver=new SafariDriver();
                break;
            default:
                throw new RuntimeException("The browser is not supported");
        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
