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
        openRegistrationFormHeader();
        Assert.assertTrue(isRegistrationFormOpened());

        fillRegistrationForm(
                new User()
                        .setFirstName("AS")
                        .setSecondName("FV")
                        .setEmail("abba@bb2279.com")
                        .setPassword("A1bbaaaaaaa"));

        selectPolicyCheckBox();
        pause(2000);
        submitForm();

        //check login form displayed
        Assert.assertTrue(isLoginFormPresent());

    }


    @Test
    public void negativeTestSignUpWithoutPassword() throws InterruptedException {

        openRegistrationFormHeader();
        Assert.assertTrue(isRegistrationFormOpened());
        fillRegistrationForm(
                new User()
                        .setFirstName("Vasya")
                        .setSecondName("Katz")
                        .setEmail("bb@bb8744.com"));

        selectPolicyCheckBox();
        pause(3000);

        //click submit button
        submitForm();
        //check login form displayed
        Assert.assertFalse(isLoginFormPresent());

    }


}
