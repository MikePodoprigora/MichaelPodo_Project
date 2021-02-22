package com.ilcarro.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
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

        fillLoginForm(new User().setEmail("abba@bb2279.com").setPassword("A1bbaaaaaaa"));

        submitForm();

    //Assert userLoggedIn
        Assert.assertTrue(isUserLoggedIn());
        String email = wd.findElement(By.cssSelector("[href='/account']")).getText();
        System.out.println(email);
        Assert.assertEquals(email, "abba@bb2279.com");

}

    public void fillLoginForm(User user) {
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());


    }

}
