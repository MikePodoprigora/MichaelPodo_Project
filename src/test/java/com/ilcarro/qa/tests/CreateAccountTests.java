package com.ilcarro.qa.tests;

import com.ilcarro.qa.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    //preconditions: user should logged out
    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getHeader().isSignUpTabPresentInHeader()) {     // if sign up not present
            app.getUser().logOut();
        }

    }


    @Test
    public void testSignUp() throws InterruptedException {
        //click on SignUp button
        app.getUser().openRegistrationFormHeader();
        Assert.assertTrue(app.getUser().isRegistrationFormOpened());

        app.getUser().fillRegistrationForm(
                new User()
                        .setFirstName("AS")
                        .setSecondName("FV")
                        .setEmail("abba@bb2279.com")
                        .setPassword("A1bbaaaaaaa"));

        app.getUser().selectPolicyCheckBox();
        app.getCar().pause(2000);
        app.getCar().submitForm();

        //check login form displayed
        Assert.assertTrue(app.getUser().isLoginFormPresent());

    }


//    @Test
//    public void negativeTestSignUpWithoutPassword() throws InterruptedException {
//
//        app.openRegistrationFormHeader();
//        Assert.assertTrue(app.isRegistrationFormOpened());
//        app.fillRegistrationForm(
//                new User()
//                        .setFirstName("Vasya")
//                        .setSecondName("Katz")
//                        .setEmail("bb@bb8744.com"));
//
//        app.selectPolicyCheckBox();
//        app.getCar().pause(3000);
//
//        //click submit button
//        app.getCar().submitForm();
//        //check login form displayed
//        Assert.assertFalse(app.isLoginFormPresent());
//
//    }


}
