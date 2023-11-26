package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.configUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class NewTodoPage extends BasePage {
    public NewTodoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div/div/div/input")
    private WebElement todoField;

    @FindBy (xpath = "//*[@id=\"root\"]/div[2]/div/div/button")
    private WebElement createButton;

   @Step
    public TodoPage addTask (String taskName){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        todoField.sendKeys(taskName);
        createButton.click();
        return new TodoPage(driver);
    }
   @Step
    public NewTodoPage load (){
        driver.get(configUtil.getInstance().getBaseUrl() + EndPoint.NEW_TODO_ENDPOINT);
        return this;
    }
}
