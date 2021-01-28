package com.ilcarro.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

//preconditions: user should logged out
    @BeforeMethod
    public void ensurePreconditions(){
        if(!isElementPresent(By.cssSelector("[href='/login']"))){     // if sign up not present
            wd.findElement(By.xpath("//a[contains(., 'logOut')]")).click();    // click to logout button
        }

    }

    @Test
    public void testSignUp(){
        //click on SignUp button
        wd.findElement(By.cssSelector("[href='/signup']")).click();
        // assert is element present on the page
        Assert.assertTrue(isElementPresent(By.cssSelector("form.signup__fields")));


        // to fill registration form
        wd.findElement(By.cssSelector("#first_name")).click();
        wd.findElement(By.cssSelector("#first_name")).clear();
        wd.findElement(By.cssSelector("#first_name")).sendKeys("AS");

        wd.findElement(By.cssSelector("#second_name")).click();
        wd.findElement(By.cssSelector("#second_name")).clear();
        wd.findElement(By.cssSelector("#second_name")).sendKeys("FV");

        wd.findElement(By.cssSelector("#email")).click();
        wd.findElement(By.cssSelector("#email")).clear();
        wd.findElement(By.cssSelector("#email")).sendKeys("asdfg@gmail.com");

        wd.findElement(By.cssSelector("#password")).click();
        wd.findElement(By.cssSelector("#password")).clear();
        wd.findElement(By.cssSelector("#password")).sendKeys("A1aaaaaaa");

        //check policy button
        wd.findElement(By.cssSelector("#check_policy")).click();

        //click submit button
        
        //check login form displayed



    }




}
