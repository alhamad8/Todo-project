package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends BasePage {
    public SignupPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (xpath = "//*[@id=\"root\"]/div[1]/div/div/a[3]")
    private WebElement signUpTab;
    @FindBy (xpath = "//*[@id=\"root\"]/div[2]/div/div/div[1]/div/input")
    private WebElement firstNameField;
    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div/div[2]/div/input")
    private WebElement lastNameField;
    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div/div[3]/div/input")
    private  WebElement emailField;
    @FindBy (xpath = "//*[@id=\"root\"]/div[2]/div/div/div[4]/div/input")
    private   WebElement passwordField;
    @FindBy (xpath = "//*[@id=\"root\"]/div[2]/div/div/div[5]/div/input")
    private WebElement confirmPasswordField;
    @FindBy (xpath = "//*[@id=\"root\"]/div[2]/div/div/button/span[1]")
    private WebElement signUpButton;

    public void signUp (String firstName,String lastName,String email,String password,String confirmPassword){
        signUpTab.click();
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(confirmPassword);
        signUpButton.click();
    }

    public void loadURL (){
        driver.get("https://qacart-todo.herokuapp.com/");

    }


}
