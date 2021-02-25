package com.ilcarro.qa;

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

        app.getUser().fillLoginForm(new User().setEmail("abba@bb2279.com").setPassword("A1bbaaaaaaa"));

        app.getCar().submitForm();

        //Assert userLoggedIn
        Assert.assertTrue(app.getUser().isUserLoggedIn());
        String email = app.getHeader().getEmailTextFromHeader();
        System.out.println(email);
        Assert.assertEquals(email, "abba@bb2279.com");

    }


}
