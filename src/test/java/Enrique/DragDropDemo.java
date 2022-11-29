package Enrique;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragDropDemo extends BaseTest{

    @Test
    public void dragDropTest() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement dot1= driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
        dragGesture(dot1);
        WebElement dropText= driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text"));
        Assert.assertEquals(dropText.getText(),"Dropped!");
        Thread.sleep(2000);
    }
}
