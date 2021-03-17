package com.ilcarro.qa.tests;

import com.ilcarro.qa.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        //goTo login page
        if (!app.getUser().isLoginFormPresent()) {
            // if user logged in, click logout, after go to login
            if (app.getUser().isUserLoggedIn()) {
                app.getUser().logOut();
            }
            app.getHeader().clickLoginTabOnHeader();
        }

    }

    @Test
    public void loginRegisteredUserPositiveTest() {

        // Login user
        app.getUser().fillLoginForm(new User()
                .setEmail("aa@bb109.com")
                .setPassword("1Aaaaaaaa"));

        app.getCar().submitForm();

        //Assert userLoggedIn
        Assert.assertTrue(app.getUser().isUserLoggedIn());
        String email = app.getHeader().getEmailTextFromHeader();
        System.out.println(email);
        Assert.assertEquals(email, "aa@bb109.com");
    }

    @Test(enabled = true)
    public void loginUserWithoutPasswordTests() throws InterruptedException {
        System.out.println("User without password login test is started");

        // go to login page and log in
        app.getUser().fillLoginForm(new User()
                .setEmail("aa@bb109.com"));

        app.getUser().pause(2000);
    }
}
