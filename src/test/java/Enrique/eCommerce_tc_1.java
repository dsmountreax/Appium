package Enrique;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.Assert;
import org.testng.annotations.Test;

public class eCommerce_tc_1 extends BaseTest2{
    @Test
    public void fillForm() throws InterruptedException {
        //driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Kike");
        //driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.hideKeyboard(); // to hide keyboard
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(AppiumBy.id("android:id/text1")).click();
        //scrollDown();
        /*driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new uiSelector())" +
                ".scrollIntoView(text(\"Argentina\"));"));*/
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(3000);
        //Toast name for popup message
        String toastMessage=driver.findElement(AppiumBy.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
        Assert.assertEquals(toastMessage,"Please enter your name");
    }
}
