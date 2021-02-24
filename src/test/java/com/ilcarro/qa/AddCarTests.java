package com.ilcarro.qa;

import org.testng.annotations.Test;

public class AddCarTests extends TestBase {


    @Test
    public void testFormLetTheCarWorkForLoggedInUser() throws InterruptedException {

        if(!isUserLoggedIn()){
            logIn();
        }

        openAddCarFormFromHeader();

        fillCarForm(new Car()
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


        pause(1000);
        submitForm();

    }

    @Test
    public void testFormLetTheCarWorkForNotLoggedInUser() throws InterruptedException {
        if (isUserLoggedIn()){
            logOut();
        }

        openAddCarFormFromHeader();

        fillCarForm(new Car()
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


        pause(1000);
        submitForm();

    }

    @Test
    public void NegativeTestAddCarWithoutDorsInfo(){

        openAddCarFormFromHeader();

        fillCarForm(new Car()
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


        submitForm();
    }


}
