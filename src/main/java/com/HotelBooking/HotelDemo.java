package com.HotelBooking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class HotelDemo {

    public static void main (String args[]) {


        System.setProperty("webdriver.chrome.driver", "C:/dev/tools/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        //driver.get("http://www.pluralsight.com");
        driver.get("http://hotel-test.equalexperts.io");

        WebElement firstnameField = driver.findElement(By.id("firstname"));
        firstnameField.sendKeys("one");

        WebElement lastnameField = driver.findElement(By.id("lastname"));
        lastnameField.sendKeys("two");

        WebElement totalpriceField = driver.findElement(By.id("totalprice"));
        totalpriceField.sendKeys("101");

        driver.findElement(By.id("checkin")).click();
        List<WebElement> alldatesCheckin = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
        for (WebElement ele : alldatesCheckin) {
            String date = ele.getText();
            if (date.equalsIgnoreCase("28")) {
                ele.click();
                break;
            }
        }

        driver.findElement(By.id("checkout")).click();
        List<WebElement> alldatesCheckout = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
        for (WebElement ele : alldatesCheckout) {
            String date = ele.getText();
            if (date.equalsIgnoreCase("29")) {
                ele.click();
                break;
            }
        }

        driver.findElement(By.cssSelector("input[type='button'][value=' Save ']")).click();

        WebElement firstName = driver.findElements(By.className("row")).get(1);
        String name = firstName.getText();
        WebElement deleteButton = driver.findElements(By.cssSelector("input[type='button'][value='Delete']")).get(0);

        deleteButton.click();

    }
}
