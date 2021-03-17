package com.ilcarro.qa.tests;

import com.ilcarro.qa.model.Car;
import org.testng.annotations.Test;

public class AddCarTests extends TestBase {


    @Test(enabled = true)
    public void testFormLetTheCarWorkForLoggedInUser() throws InterruptedException {

        if(!app.getUser().isUserLoggedIn()){
            app.getUser().logIn();
        }

        app.getCar().openAddCarFormFromHeader();

        app.getCar().fillCarForm(new Car()
                .setCountry("Canada")
                .setAddress("Bloor Street")
                .setDistanceIncluded("500")
                .setSerialNumber("93678246")
                .setBrand("Volkswagen")
                .setModel("Atlas")
                .setYear("2021")
                .setEngine("3.5V6")
                .setFuelConsumption("10")
                .setFuel("Petrol")
                .setTransmission("Automatic")
                .setWd("gregfregfre")
                .setHorsepower("180")
                .setTorque("3456")
                .setDoors("5")
                .setSeats("5")
                .setAutoClass("E")
                .setAbout("ewfeybrfyegyfgyerg")
                .setTypeFeature("egregegfreg")
                .setPrice("40"));

        app.getCar().pause(1000);
        app.getCar().submitForm();

    }

    @Test
    public void testFormLetTheCarWorkForNotLoggedInUser() throws InterruptedException {
        if (app.getUser().isUserLoggedIn()){
            app.getUser().logOut();
        }

        app.getCar().openAddCarFormFromHeader();

        app.getCar().fillCarForm(new Car()
                .setCountry("Canada")
                .setAddress("Bloor Street")
                .setDistanceIncluded("500")
                .setSerialNumber("93678246")
                .setBrand("Volkswagen")
                .setModel("Atlas")
                .setYear("2021")
                .setEngine("3.5V6")
                .setFuelConsumption("10")
                .setFuel("Petrol")
                .setTransmission("Automatic")
                .setWd("gregfregfre")
                .setHorsepower("180")
                .setTorque("3456")
                .setDoors("5")
                .setSeats("5")
                .setAutoClass("E")
                .setAbout("ewfeybrfyegyfgyerg")
                .setTypeFeature("egregegfreg")
                .setPrice("40"));

        app.getCar().pause(1000);
        app.getCar().submitForm();

    }

    @Test
    public void NegativeTestAddCarWithoutDoorsInfo(){

        app.getCar().openAddCarFormFromHeader();

        app.getCar().fillCarForm(new Car()
                .setCountry("Canada")
                .setAddress("Bloor Street")
                .setDistanceIncluded("500")
                .setSerialNumber("12345678")
                .setBrand("Volkswagen")
                .setModel("Atlas")
                .setYear("2021")
                .setEngine("3.5V6")
                .setFuelConsumption("10")
                .setFuel("92")
                .setTransmission("Automatic")
                .setWd("gregfregfre")
                .setHorsepower("180")
                .setTorque("3456")
                .setSeats("5")
                .setAutoClass("E")
                .setAbout("ewfeybrfyegyfgyerg")
                .setTypeFeature("egregegfreg")
                .setPrice("40"));

        app.getCar().submitForm();
    }


}
