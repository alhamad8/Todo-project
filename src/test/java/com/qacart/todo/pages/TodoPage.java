package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.configUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TodoPage extends BasePage {
    public TodoPage(WebDriver driver) {
        super(driver);

    }

    @FindBy (css="[data-testid=\"add\"]")
    private WebElement addButton;
    @FindBy (xpath = "//*[@id=\"root\"]/div[2]/div/div/h2")
    private WebElement welcomeMessage;
    @FindBy (xpath = "//*[@id=\"root\"]/div[2]/div/div/div[2]/h2")
    private WebElement todoItem;
    @FindBy (xpath = "//*[@id=\"root\"]/div[2]/div/div/div[2]/div/button")
    private WebElement deleteButton;
    @FindBy (xpath = "//*[@id=\"root\"]/div[2]/div/div/h4")
    private WebElement noTasksMessage;
    WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
    Actions act = new Actions (driver);


   @Step
    public boolean isWelcomeMessageDisplayed (){

        return welcomeMessage.isDisplayed();
    }

    public NewTodoPage clickOnAddButton (){
        addButton.click();
        return new NewTodoPage(driver);// لانه عند الضغط على زر الاضافة + يتم فتح صفحة جديدة اضافة مهمة
    }

    public String getTodoText (){
        return todoItem.getText();
    }

    public TodoPage clickOnDeleteButton (){
        deleteButton.click();
        return this;
    }

    public boolean getNoTasksMessages (){
        return noTasksMessage.isDisplayed();
    }

    public TodoPage load (){
        driver.get(configUtil.getInstance().getBaseUrl() + EndPoint.TODO_PAGE_END_POINT);
        return this;
    }



}
