package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.utils.configUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.api.internal.ConfigUtil;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Dummy2 {
    public static void main (String [] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qacart-todo.herokuapp.com/");
        driver.manage().window().maximize();
        RegisterApi registerApi = new RegisterApi();
        registerApi.register();
        List<Cookie> restAssuredCookies = registerApi.getRestAssuredCookies();
        for (Cookie cookie : restAssuredCookies){
            org.openqa.selenium.Cookie seleniumCookies = new org.openqa.selenium.Cookie(cookie.getName(),cookie.getValue());
            driver.manage().addCookie(seleniumCookies);
        }
        driver.get("https://qacart-todo.herokuapp.com/");
        Thread.sleep(50000);
        driver.quit();

    }
}
