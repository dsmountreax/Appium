package Enrique;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumBasics extends BaseTest{
    @Test
    public void WifiSettingName() throws MalformedURLException {
        //Android Driver or IOSDriver
        // Appium code --> Appium Server --> Mobile
        // starter appium server
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String alertTitle =driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
        System.out.println(alertTitle);
        Assert.assertEquals(alertTitle,"WiFi settings");
        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("Rahul Wifi");
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
        // there are only 5 locators for android and there are id, accesibilityId, classname, androidUIAutomator, Xpath,
        //Actual Automation start
        //Set Wifi Name

    }
}
