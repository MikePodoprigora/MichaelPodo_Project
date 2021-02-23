package com.ilcarro.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddCarTests extends TestBase {

//    @BeforeMethod
//    public void ensurePreconditions(){
//        if(!isUserLoggedIn()){
//            logIn();
//        }
//    }
//
//    private void logIn() {
//        fillLoginForm(new User().setEmail("abba@bb2279.com").setPassword("A1bbaaaaaaa"));
//
//        submitForm();
//
//    }

    @Test
    public void testFormLetTheCarWork() {
        click(By.cssSelector(".header__nav [href='/car']"));

        fillCarForm(new Car()
                .setCountry("Canada")
                .setAddress("Bloor Street")
                .setDistanceIncluded("500")
                .setSerialNumber("12345678")
                .setBrand("Volkswagen")
                .setModel("Atlas")
                .setYear("2021")
                .setEngine("3.5V6")
                .setFuel_consumption("11")
                .setFuel("92")
                .setTransmission("Automatic")
                .setWd("gregfregfre")
                .setHorsepower("180")
                .setTorque("3456")
                .setDoors("5")
                .setSeats("5")
                .setAuto_class("E")
                .setAbout("ewfeybrfyegyfgyerg")
                .setType_feature("egregegfreg")
                .setPrice("40"));


        submitForm();

    }

    @Test
    public void NegativeTestAddCarWithoutDorsInfo(){

        click(By.cssSelector(".header__nav [href='/car']"));

        fillCarForm(new Car()
                .setCountry("Canada")
                .setAddress("Bloor Street")
                .setDistanceIncluded("500")
                .setSerialNumber("12345678")
                .setBrand("Volkswagen")
                .setModel("Atlas")
                .setYear("2021")
                .setEngine("3.5V6")
                .setFuel_consumption("11")
                .setFuel("92")
                .setTransmission("Automatic")
                .setWd("gregfregfre")
                .setHorsepower("180")
                .setTorque("3456")
                .setSeats("5")
                .setAuto_class("E")
                .setAbout("ewfeybrfyegyfgyerg")
                .setType_feature("egregegfreg")
                .setPrice("40"));


        submitForm();
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
        type(By.name("fuel_consumption"), car.getFuel_consumption());
        type(By.name("fuel"), car.getFuel());
        type(By.cssSelector(".transmition"), car.getTransmission());
        type(By.cssSelector(".wd"), car.getWd());
        type(By.cssSelector(".horsepower"), car.getHorsepower());
        type(By.cssSelector(".torque"), car.getTorque());
        type(By.cssSelector(".doors"), car.getDoors());
        type(By.cssSelector(".seats"), car.getSeats());
        type(By.cssSelector(".class"), car.getAuto_class());
        type(By.name("about"), car.getAbout());
        type(By.cssSelector(".type_feature"), car.getType_feature());
        type(By.cssSelector(".price"), car.getPrice());

    }

}
