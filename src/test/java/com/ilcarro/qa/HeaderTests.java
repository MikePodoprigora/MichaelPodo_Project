package com.ilcarro.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderTests extends TestBase {

    @BeforeMethod
    public void ensureHeaderElementsExist() {

    }

    @Test
    public void testHederElements() {

        //search field
        app.getCar().click(By.cssSelector("[href=\"/search\"]"));
        //checking presents
        Assert.assertTrue(app.getCar().isElementPresent(By.cssSelector("form .search-sidebar__form")));

        //let the car work
        app.getCar().click(By.cssSelector("[href=\"/car\"]"));
        //checking presents
        Assert.assertTrue(app.getCar().isElementPresent(By.cssSelector("form .let-carwork-style_lets_car_form__2fYnX")));

        //terms of use
        app.getCar().click(By.cssSelector("[href=\"/terms\"]"));

        //checking presents
        Assert.assertTrue(app.getCar().isElementPresent(By.xpath("//h1[contains(., 'Terms')]")));

        //click on SignUp button
        app.getUser().openRegistrationFormHeader();
        Assert.assertTrue(app.getUser().isRegistrationFormOpened());

        //click on LogIn button
        app.getCar().click(By.cssSelector("[href='/login']"));
        // assert is element present on the page
        Assert.assertTrue(app.getCar().isElementPresent(By.cssSelector("form .input-field-style_input_formik_field__3rJjj")));

    }


}
