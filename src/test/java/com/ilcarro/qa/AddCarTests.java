package com.ilcarro.qa;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AddCarTests extends TestBase {
    @Test
    public void testFormLetTheCarWork(){
//        click(By.cssSelector(".let-carwork-style_let_car_location__30BIh"));


        type(By.name("country"), "Canada");
        type(By.cssSelector(".address"), "Bloor Street");
        type(By.cssSelector(".distance_included"), "500");
        type(By.cssSelector(".serial_number"), "12345678");
        type(By.cssSelector(".brand"), "Volkswagen");
        type(By.cssSelector(".model"), "Atlas");
        type(By.cssSelector(".year"), "2021");
        type(By.cssSelector("engine"), "3.5");
        type(By.cssSelector(".transmition"), "Automatic");
        type(By.cssSelector(".wd"), "gregfregfre");
        type(By.cssSelector(".horsepower"), "180");
        type(By.cssSelector(".torque"), "3456");
        type(By.cssSelector(".doors"), "4");
        type(By.cssSelector(".seats"), "5");
        type(By.cssSelector(".class"), "E");
        type(By.name("about"), "ewfeybrfyegyfgyerg");
        type(By.cssSelector(".type_feature"), "egregegfreg");
        type(By.cssSelector(".price"), "40");

        submitForm();


    }

}
