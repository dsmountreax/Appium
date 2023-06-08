package Enrique;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest2 {
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
        options.setApp("D:\\Aprendizaje\\Appium\\Appium_Laboratorios\\Appium\\src\\test\\java\\resources\\General-Store.apk");
        driver=new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        service.stop();
    }

    public void longPressAction(WebElement ele){
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000));
    }

    public void scrollToEndAction() {
        boolean canScrollMore;
        // No prior idea
        do {
            canScrollMore=(Boolean)((JavascriptExecutor)driver).executeScript("mobile:scrollGesture", ImmutableMap.of(
                    "left",100,"top",100,"width",200,"height",200,"direction","down","percent",3.0));
        }while(canScrollMore);

    }

    public void scrollDown() {

        ((JavascriptExecutor)driver).executeScript("mobile:scrollGesture", ImmutableMap.of(
                    "left",100,"top",100,"width",200,"height",200,
                "direction","down","percent",3.0));


    }

    public void swipeGestureAction(WebElement webElement, String direction){
        ((JavascriptExecutor)driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId",webElement,//(RemoteWebElement)webElement.getId(),
                "direction",direction,"percent",0.75));
    }

    public void dragGesture(WebElement webElement) {
        ((JavascriptExecutor)driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId",webElement,//(RemoteWebElement)webElement.getId(),
                "endX",830,"endY",730));
    }

    public Double GetFormattedAmount(String amount)
    {
        Double price =Double.parseDouble(amount.substring(1));
        return price;
    }


}
