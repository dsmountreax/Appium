package Enrique;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumBasics {
    @Test
    public void WifiSettingName() throws MalformedURLException {
        //Android Driver or IOSDriver
        // Appium code --> Appium Server --> Mobile

        // starter appium server
        AppiumDriverLocalService service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Enrique\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();
        UiAutomator2Options options=new UiAutomator2Options();
        options.setDeviceName("KikeEmulator");
        options.setApp("D:\\Aprendizaje\\Appium\\Appium_Laboratorios\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
        AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        // there are only 5 locators for android and there are Xpath, id, accesibilityId, classname, androidUIAutomator
        //Actual Automation start
        //Set Wifi Name
        driver.quit();
        service.stop();

    }
}
