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
    public void setUp() {
        init();

    }

    public void init() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();

        wd.get("https://ilcarro-dev-v1.firebaseapp.com/");
    }


    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    public boolean isFindCarFormPresent() {
        return isElementPresent(By.cssSelector(".Main_mainpage__find_your_car__AHLkw form"));
    }


    @AfterSuite(enabled = false)
    public void tearDown() {
        stop();

    }

    private void stop() {
        wd.quit();
    }

    public boolean isLoginFormPresent() {
        return isElementPresent(By.cssSelector(".Login_login__right_block__1niYm"));
    }

    protected void type(By locator, String text) {

        if (text != null) {
            click(locator);
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void submitForm() {
        new WebDriverWait(wd, 15)  // function for waiting the clickable button
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']"))).click();
//        click(By.cssSelector("[type='submit']"));
    }

    public void logIn() {
        fillLoginForm(new User().setEmail("abba@bb2279.com").setPassword("A1bbaaaaaaa"));

        submitForm();
    }

    public void fillLoginForm(User user) {
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
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

    public void openAddCarFormFromHeader() {
        click(By.cssSelector(".header__nav [href='/car']"));
    }

    public void fillCarForm(Car car) {
        type(By.name("country"), car.getCountry());
        type(By.cssSelector(".address"), car.getAddress());
        type(By.cssSelector(".distance_included"), car.getDistanceIncluded());
        type(By.cssSelector(".serial_number"), car.getSerialNumber());
        type(By.cssSelector(".brand"), car.getBrand());
        type(By.cssSelector(".model"), car.getModel());
        type(By.cssSelector(".year"), car.getYear());
        type(By.name("engine"), car.getEngine());
        type(By.name("fuel_consumption"), car.getFuelConsumption());
        type(By.name("fuel"), car.getFuel());
        type(By.cssSelector(".transmition"), car.getTransmission());
        type(By.cssSelector(".wd"), car.getWd());
        type(By.cssSelector(".horsepower"), car.getHorsepower());
        type(By.cssSelector(".torque"), car.getTorque());
        type(By.cssSelector(".doors"), car.getDoors());
        type(By.cssSelector(".seats"), car.getSeats());
        type(By.cssSelector(".class"), car.getAutoClass());
        type(By.name("about"), car.getAbout());
        type(By.cssSelector(".type_feature"), car.getTypeFeature());
        type(By.cssSelector(".price"), car.getPrice());

    }

    public void selectPolicyCheckBox() {
        click(By.cssSelector("#check_policy"));
    }

    public void openRegistrationFormHeader() {
        click(By.cssSelector("[href='/signup']"));
    }

    public boolean isRegistrationFormOpened() {
        return isElementPresent(By.cssSelector("form.signup__fields"));
    }

    public void fillRegistrationForm(User user) {
        type(By.name("first_name"), user.getFirstName());
        type(By.name("second_name"), user.getSecondName());
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

    public String getEmailTextFromHeader() {
        return wd.findElement(By.cssSelector("[href='/account']")).getText();
    }
}
