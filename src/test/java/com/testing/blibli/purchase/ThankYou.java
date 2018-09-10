package com.testing.blibli.purchase;

import com.testing.Handler;
import com.testing.Utility;
import com.testing.blibli.constants.BlibliWebElementConstants;
import com.testing.constants.ConfigConstants;
import com.testing.constants.WebElementConstants;
import com.testing.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ThankYou {

    @Test
    @Parameters({"platform"})
    public void Print(String platform) {

        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {

            Utility.Delay(5);
            Utility.TapByCoordinates(73, 140);

            Utility.ClickElementById(
                    Handler.GetCurrentAppiumDriver(),
                    "blibli.mobile.commerce:id/continue_btn");

            Utility.Delay(3);
            Utility.TapByCoordinates(1006, 136);

            Utility.Delay(3);
            Utility.TapByCoordinates(480, 364);

            String paymentCode = Utility.GetElementById(
                    Handler.GetCurrentAppiumDriver(),
                    "blibli.mobile.commerce:id/tv_order_id").getText();

            Log.Info("Payment Code: " + paymentCode);

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            String paymentCode = "";

            try {
                Log.Debug("test 1");
                WebDriverWait wait = new WebDriverWait(Handler.GetCurrentWebDriver(),
                        ConfigConstants.DEFAULT_TIMEOUT);
                WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(".//span[@class='ordernumber' and contains(text(), 'Nomor pesanan: ')]")));
                paymentCode = el.getText();

            } catch (Exception e) {
                Log.Error(e);
            }

            String[] noPesanan = paymentCode.split(" ");

            Log.Info("Payment Code: " + noPesanan[2]);

        } else {
            throw new SkipException("Platform is not available");
        }
    }

}
