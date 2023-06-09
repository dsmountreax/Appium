package Enrique;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class eCommerce_tc_3 extends BaseTest2{
    @Test
    public void fillForm() throws InterruptedException {
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Kike");
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
        driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();

        // Another option is
        //driver.findElements(AppiumBy.id("(com.androidsample.widget:TextView[@text='ADD TO CART'])[1]")).click();
        //driver.findElements(AppiumBy.id("com.androidsample.widget:TextView[@text='ADD TO CART']")).get(0).click();
        //driver.findElements(AppiumBy.id("com.androidsample.widget:TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();

        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(8));
        //wait.until(ExpectedConditions.invisibilityOf(driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title"))));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));

        //Thread.sleep(6000);
        List<WebElement> productPrices= driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productPrice"));
        int count = productPrices.size();
        double sum=0;
        for(int i =0; i< count; i++)
        {
            String amountString=productPrices.get(i).getText();
            Double price=Double.parseDouble(amountString.substring(1));
            sum=sum+price;
        }

        String totalAmount=driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        Double displayFormattedSum=GetFormattedAmount(totalAmount);
        Assert.assertEquals(sum,displayFormattedSum);
        WebElement ele=driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/termsButton"));
        longPressAction(ele);
        driver.findElement(AppiumBy.id("android:id/button1")).click();
        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(5000);

    }
}
