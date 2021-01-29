package com.ilcarro.qa;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
@Test
    public void loginRegisteredUserPositiveTest(){
    //goTo login page
    wd.findElement(By.cssSelector("")).click();
    //fillLoginForm
    wd.findElement(By.cssSelector("")).click();
    wd.findElement(By.cssSelector("")).clear();
    wd.findElement(By.cssSelector("")).sendKeys();

    //submit login


    //Assert userLoggedIn

}

}
