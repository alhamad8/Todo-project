package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.utils.configUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        /*
        بما انه الكلاس الاب يحتوي على كونستراكتر الكلاس الابن سوف يكون له كونستراكتر
        super: تعني استدعاء للكونستراكتر للكلاس الاب
        اي استدعاء السطرين الموجودين في الكونستراكتر الاب this + page factory
        اي صفحة جديدة يتم اضافتها ترث من الكلاس BasePage
        اي كلاس جديد (تيست كيس) ترث من الكلاس BaseTest
         */
    }


    @FindBy(xpath = "//*[@id=\"email\"]")
      private WebElement emailInput;
    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement passwordInput;
    @FindBy(xpath = "//*[@id=\"submit\"]/span[1]")
    private WebElement loginButton;



    @Step
    public TodoPage loginFunction (String email, String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click(); // عند الضغط على زر تسجيل الدخول نصل الى صفحة todo page
        return new TodoPage(driver);                  //بدل ما نرجع بالتيست كيس نعرف instance of todo page بنخلي login method ترجعلنا new TodoPage
                                                    // الانتقال من صفحة الى صفحة على مستوى الpage level وليس على مستوى التيست كيس
    }                                               // ميثود اللوجن صار نوعها TodoPage


    @Step
    public LoginPage loadUrl (){
        driver.get(configUtil.getInstance().getBaseUrl());
        return this; //بنوجع الصفحة الحالية اللي هي LginPage
                    //نستطيع من خلالها الوصوصول للميثود الاخرى

    }

}
