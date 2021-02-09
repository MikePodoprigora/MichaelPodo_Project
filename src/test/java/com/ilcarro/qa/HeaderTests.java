package com.ilcarro.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderTests extends TestBase{

    //check if element present on the header page
    @BeforeMethod
    public void ensureHeaderElementsExist() {


    }

    @Test
    public void testHederElements(){
        // assert if elements are present on the page

            //search field
        click(By.cssSelector("[href=\"/search\"]"));
        //checking presents
            Assert.assertTrue(isElementPresent(By.cssSelector("form .search-sidebar__form")));


            //let the car work
        click(By.cssSelector("[href=\"/car\"]"));
        //checking presents
            Assert.assertTrue(isElementPresent(By.cssSelector("form .let-carwork-style_lets_car_form__2fYnX")));

            //terms of use
        click(By.cssSelector("[href=\"/terms\"]"));
        //checking presents
            Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(., 'Terms')]")));
            wd.get("https://ilcarro-dev-v1.firebaseapp.com/"); // you have to go back from this field, Bug of this page

            //click on SignUp button
        click(By.cssSelector("[href='/signup']"));
        // assert is element present on the page
            Assert.assertTrue(isElementPresent(By.cssSelector("form.signup__fields")));

            //click on LogIn button
        click(By.cssSelector("[href='/login']"));
        // assert is element present on the page
            Assert.assertTrue(isElementPresent(By.cssSelector("form .input-field-style_input_formik_field__3rJjj")));

    }



}
