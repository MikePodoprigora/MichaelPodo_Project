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
        fillRegistrationForm(
                new User()
                        .setFirstName("AS")
                        .setSecondName("FV")
                        .setEmail("abba@bb2279.com")
                        .setPassword("A1bbaaaaaaa"));

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
    public void testSignUpWithoutPassword() throws InterruptedException {

        click(By.cssSelector("[href='/signup']"));
        Assert.assertTrue(isElementPresent(By.cssSelector("form.signup__fields")));
        fillRegistrationForm(
                new User()
                        .setFirstName("Vasya")
                        .setSecondName("Katz")
                        .setEmail("bb@bb8744.com"));

        click(By.cssSelector("#check_policy")); // same thing like we did, only with the method "click";
        pause(3000);


        //click submit button
        //submitForm();

        //check login form displayed
       // Assert.assertTrue(isLoginFormPresent());

    }

    public void fillRegistrationForm(User user) {
        type(By.name("first_name"), user.getFirstName());
        type(By.name("second_name"), user.getSecondName());
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }


}
