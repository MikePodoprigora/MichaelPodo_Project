package com.ilcarro.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    static WebDriver wd;

    @BeforeSuite
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();

        wd.get("https://ilcarro-dev-v1.firebaseapp.com/");

    }

    //1t method
    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }

    public boolean isFindCarFormPresent(){
        return isElementPresent(By.cssSelector(".Main_mainpage__find_your_car__AHLkw form"));
    }

     //2nd method
//    public boolean isFindCarFormPresent2(){
//        return isElementPresent2(By.cssSelector(".Main_mainpage__find_your_car__AHLkw form");
//    }


    public boolean isElementPresent2(By by){
        try{
            wd.findElement(by);
            return true;
        }catch (NoSuchElementException ex){
            return false;
        }
    }

    @AfterSuite(enabled = true)
    public void tearDown(){
        wd.quit();

    }

    public boolean isLoginFormPresent() {
        return isElementPresent(By.cssSelector(".Login_login__right_block__1niYm"));
    }

    protected void type(By locator, String text) {
//        wd.findElement(locator).click();   // simple form with click function, lock down
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator){
        wd.findElement(locator).click();
    }

    public void submitForm() {
        new WebDriverWait(wd, 15)  // function for waiting the clickable button
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']"))).click();
//        click(By.cssSelector("[type='submit']"));
    }

    public boolean isSignUpTabPresentInHeader() {
        return isElementPresent(By.cssSelector("[href='/signup']"));
    }

    public void logOut() {
        click(By.xpath("//a[contains(., 'logOut')]"));
    }

    public void clickLoginTabOnHeader() {
        click(By.cssSelector("[href='/login']"));
    }

    public boolean isUserLoggedIn() {
        return isElementPresent(By.xpath("//a[contains(., 'logOut')]"));
    }
}
