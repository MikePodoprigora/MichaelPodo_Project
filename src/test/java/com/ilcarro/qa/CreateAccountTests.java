package com.ilcarro.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

//preconditions: user should logged out
    @BeforeMethod
    public void ensurePreconditions(){
        if(!isSignUpTabPresentInHeader()){     // if sign up not present
            logOut();
        }

    }



    @Test
    public void testSignUp(){
        //click on SignUp button
        click(By.cssSelector("[href='/signup']"));
        // assert is element present on the page
        Assert.assertTrue(isElementPresent(By.cssSelector("form.signup__fields")));


        // to fill registration form
        type(By.cssSelector("#first_name"), "AS");
        type(By.cssSelector("#second_name"),"FV");
        type(By.cssSelector("#email"), "aa@bb222.com");
        type(By.cssSelector("#password"),"A1aaaaaaa");



        //check policy button
       // wd.findElement(By.cssSelector("#check_policy")).click();
        click(By.cssSelector("#check_policy")); // same thing like we did, only with the method "click";

        //click submit button
        submitForm();

        //check login form displayed
        Assert.assertTrue(isLoginFormPresent());  // this method will call the method "isElementPresent"

    }


}
