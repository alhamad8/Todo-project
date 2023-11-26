package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.api.TasksApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.configUtil;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
@Feature("Todo feature")

public class TodoTest extends BaseTest {


    @Story("Add Todo")
    @Test()
    public void checkFunctionalityOfAddTask ()  {
        RegisterApi registerApi = new RegisterApi();
        registerApi.register();
       NewTodoPage newTodoPage = new NewTodoPage(getDriver());
        newTodoPage.load();
        injectCookiesToBrowser(registerApi.getRestAssuredCookies());
        String actualResultMessage =  newTodoPage.load()
                .addTask("My first task")
                .getTodoText();
       /* LoginPage login = new LoginPage(driver);
        String actualResultMessage=  login.loadUrl().
                loginFunction(configUtil.getInstance().getُEmail(),configUtil.getInstance().getُPassword())
                .clickOnAddButton()
                .addTask("My tasks").getTodoText();*/
        Assert.assertEquals(actualResultMessage, "New Task Today");
       // TodoPage todoPage = login.loginFunction("alhamadahmad16@outlook.com","ahmad123");
       // NewTodoPage newTodoPage = todoPage.clickOnAddButton();
        //New todo page
     //   todoPage= newTodoPage.addTask("New Task Today");
       //String actualResultMessage = todoPage.getTodoText();

    }
    @Story("Delete Todo")
    @Test ()
    public void checkFunctionOfDeleteTask(){
        RegisterApi registerApi = new RegisterApi();
        registerApi.register();
        TasksApi tasksApi = new TasksApi();
        tasksApi.addTask(registerApi.getAccessToken());
        TodoPage todoPage = new TodoPage(getDriver());
        todoPage.load();
        injectCookiesToBrowser(registerApi.getRestAssuredCookies());

        boolean noTaskMessage = todoPage.load().clickOnDeleteButton().getNoTasksMessages();
        Assert.assertTrue(noTaskMessage);


       /* LoginPage login = new LoginPage(driver);
        boolean noTaskMessage =  login.loadUrl()
                .loginFunction(configUtil.getInstance().getُEmail(),configUtil.getInstance().getُPassword())
                .clickOnAddButton()
                .addTask("Test Tas;").clickOnDeleteButton().getNoTasksMessages();
        Assert.assertTrue(noTaskMessage);
        driver.quit();*/
        //TodoPage todoPage = login.loginFunction("alhamadahmad16@outlook.com","ahmad123");
        //TodoPage todopage = new TodoPage(driver);
        //NewTodoPage newTodoPage= todoPage.clickOnAddButton();
        //New todo page
      //  todoPage= newTodoPage.addTask("Second Task");
      //  todoPage.clickOnDeleteButton();
        //boolean noTaskMessage =todoPage.getNoTasksMessages();

    }
}
