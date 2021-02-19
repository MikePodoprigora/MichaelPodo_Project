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
    public void testSignUp() throws InterruptedException {
        //click on SignUp button
        click(By.cssSelector("[href='/signup']"));
        // assert is element present on the page
        Assert.assertTrue(isElementPresent(By.cssSelector("form.signup__fields")));

        // to fill registration form
        fillRegistrationForm("AS", "FV", "aa@bb2279.com", "A1aaaaaaa");

        click(By.cssSelector("#check_policy")); // same thing like we did, only with the method "click";

        pause(2000);

        //click submit button
        submitForm();

        //check login form displayed
        Assert.assertTrue(isLoginFormPresent());  // this method will call the method "isElementPresent"

    }


    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }


    @Test
    public void testSignUp2() throws InterruptedException {
        //click on SignUp button
        click(By.cssSelector("[href='/signup']"));
        Assert.assertTrue(isElementPresent(By.cssSelector("form.signup__fields")));
        fillRegistrationForm("Vasya", "Katz","vasya.katz555@gmail.com", "Vasiliy11111");
        click(By.cssSelector("#check_policy")); // same thing like we did, only with the method "click";
        pause(3000);
        submitForm();

        //check login form displayed
        Assert.assertTrue(isLoginFormPresent());  // this method will call the method "isElementPresent"

    }

    public void fillRegistrationForm(String firstName, String secondName, String email, String password) {
        type(By.cssSelector("#first_name"), firstName);
        type(By.cssSelector("#second_name"), secondName);
        type(By.cssSelector("#email"), email);
        type(By.cssSelector("#password"), password);
    }


}
