package com.ilcarro.qa;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        //goTo login page
        if (!isLoginFormPresent()){
            // if user logged in, click logout, after go to login
            if (isUserLoggedIn()){
                logOut();
            }
            clickLoginTabOnHeader();
        }

    }


    @Test
    public void loginRegisteredUserPositiveTest(){



    //fillLoginForm
    type(By.name("email"),"aa@bb109.com");
    type(By.name("password"), "1Aaaaaaaa");


    //submit login button // we launch the method who located in the TestBase which clicks a button
    submitForm();


    //Assert userLoggedIn

}

}
