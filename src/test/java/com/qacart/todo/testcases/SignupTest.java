package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.SignupPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.configUtil;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
@Feature("Authintication feature")
public class SignupTest extends BaseTest {
    @Story("Sign up using email and password")
    @Description("It will login with email and password")

    @Test(description = "Verify that the signup functionality")
    public void checkSignUpFunctionality (){
        SignupPage signup = new SignupPage(getDriver());
        signup.loadURL();
        signup.signUp("Ahmad","Alhamad","alhamadahmad16@outlook.com","ahmad123","ahmad123");

    }


    @Story("Login using email and password")

    @Test(description = "Verify that the login functionality")
    public void checkfunctionalityOfLogin (){
        LoginPage loginPage = new LoginPage(getDriver());
        boolean welcomeMessageISDisplyed =loginPage
                .loadUrl()
                .loginFunction(configUtil.getInstance().getُEmail(),configUtil.getInstance().getُPassword())
                .isWelcomeMessageDisplayed();
        Assert.assertTrue(welcomeMessageISDisplyed);
        /*
        builder paatren : الانتقال من ميثود الى ميثود دون استخدام الobject
        قمنا باختصار السطر الذي تحت وبما انه اخر ميثود بترجع بوليان بنقدر نعرف السطر كامل ك بوليان
         */
        //
        //TodoPage todoPage = loginPage.loginFunction("alhamadahmad16@outlook.com","ahmad123");
         //=new TodoPage(driver);
       // boolean welcomeMessageISDisplyed = todoPage.isWelcomeMessageDisplayed();



    }
}
