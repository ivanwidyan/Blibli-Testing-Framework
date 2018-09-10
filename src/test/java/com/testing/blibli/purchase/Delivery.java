package com.testing.blibli.purchase;

import com.testing.Handler;
import com.testing.Utility;
import com.testing.blibli.constants.BlibliWebElementConstants;
import com.testing.constants.AndroidElementConstants;
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

public class Delivery {

    @Test
    @Parameters({"platform"})
    public void ChooseCourrier(String platform) {

        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            Log.Debug("Pick courrier");
            try {

                WebDriverWait wait = new WebDriverWait(Handler.GetCurrentWebDriver(),
                        ConfigConstants.DEFAULT_TIMEOUT);
                WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(".//label[@class='ng-binding bold' and contains(text(), 'Standard')]")));
                el.click();

            } catch (Exception e) {
                Log.Error(e);
            }

        } else {
            throw new SkipException("Platform is not available");
        }
    }

    @Test
    @Parameters({"platform"})
    public void ContinueToPayment(String platform) {

        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {

            Utility.TapByCoordinates(550, 1700);

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            try {
                Utility.ClickElementByXPath(
                    Handler.GetCurrentWebDriver(),
                    "input",
                    WebElementConstants.PARAM_ID,
                    BlibliWebElementConstants.DELIVERY_NEXT_STEP);
            } catch (Exception e) {
                Log.Error(e);
            }

            Log.Debug("test 4");
            try {
                Utility.ClickElementByXPath(
                    Handler.GetCurrentWebDriver(),
                    "input",
                    WebElementConstants.PARAM_VALUE,
                    "Lanjutkan ke Pembayaran");
            } catch (Exception e) {
                Log.Error(e);
            }

        } else {
            throw new SkipException("Platform is not available");
        }
    }

}
