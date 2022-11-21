package Enrique;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public void configureAppium() throws MalformedURLException {
        //Android Driver or IOSDriver
        // Appium code --> Appium Server --> Mobile
        // starter appium server

        service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Enrique\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();
        UiAutomator2Options options=new UiAutomator2Options();
        options.setDeviceName("KikeEmulator");
        options.setApp("D:\\Aprendizaje\\Appium\\Appium_Laboratorios\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
        driver=new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        service.stop();
    }

}
