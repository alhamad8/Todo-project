package com.qacart.todo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;// يتم عمله protected حتى يتم الوصول له في الكلاس الابناء
                                // هذا الدرايفر تاتي قيمته من التيست كيس من التيست كيس الى الsuper من الsuper الى ال base page ويتم عمل intialize للدرايفر
    public BasePage (WebDriver driver){
        this.driver=driver;//يتم وضع الدراايفر المعرف هنا بالدرايفر القادم من التيست كيس,,,this.driver:driver from this class
        PageFactory.initElements(driver,this);/* this : تعني هذه الصفحة لكنها لا تعود لهذه الصفحة بالتحديد بل للكلاس الذي يبعث قيمة الدرايفر
                                                       init elements: initialize elements of the page
                                                       يعني  initialize elemnts of this page

                                                       ويتم عمل هذا الكونستركتر حتى نرسل قيمة الdriver للinstance في التست كيس

                                                وبما انه الصفحات تورث من هذا الكلاس تم عمل هذا الكلاس حتى ترث منه الصفحات


        */
    }
}



/*
POM design : تقسيم الويب الى صفحات
يتم عمل كلاس لكل صفحة على حدةويتم وضع عناصر الصفحة بهذا الكلاس
 */