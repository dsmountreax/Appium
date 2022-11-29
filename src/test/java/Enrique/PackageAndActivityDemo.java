package Enrique;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.DeviceRotation;
import org.testng.annotations.Test;

public class PackageAndActivityDemo extends  BaseTest{

        @Test
        public void packageAndActivity() throws InterruptedException {
            //adb devices
            //adb shell dumpsys window | find "mCurrentFocus"
            String activityName="io.appium.android.apis.preference.PreferenceDependencies";
            String packageName="io.appium.android.apis";
            Activity activity= new Activity(packageName,activityName);
            driver.startActivity(activity);

            /*driver.findElement(AppiumBy.accessibilityId("Preference")).click();
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
            driver.findElement(AppiumBy.id("android:id/checkbox")).click();*/
            driver.findElement(AppiumBy.id("android:id/checkbox")).click();
            DeviceRotation landScape=new DeviceRotation(0,0,90);
            driver.rotate(landScape);
            driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
            driver.setClipboardText("Rahul Wifi");
            driver.findElement(AppiumBy.id("android:id/edit")).sendKeys(driver.getClipboardText());
            driver.findElement(AppiumBy.id("android:id/button2")).click();
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
            driver.pressKey(new KeyEvent(AndroidKey.HOME));
            Thread.sleep(2000);
     }

}