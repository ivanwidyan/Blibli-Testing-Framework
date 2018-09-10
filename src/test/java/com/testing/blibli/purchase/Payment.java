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

public class Payment {

    @Test
    @Parameters({"platform", "input"})
    public void Transfer(String platform, String input) {

        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            WebDriverWait wait = new WebDriverWait(Handler.GetCurrentWebDriver(),
                    ConfigConstants.DEFAULT_TIMEOUT);
            WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath(".//b[@class='payment-type-name ng-binding' and contains(text(), 'Transfer')]")));
            el.click();

            Utility.ClickElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_VALUE,
                    BlibliWebElementConstants.TRANSFER_BANK_BNI);

        } else {
            throw new SkipException("Platform is not available");
        }
    }

    @Test
    @Parameters({"platform"})
    public void Indomaret(String platform) {

        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {

            Utility.Delay(5);
            Utility.SwipeVerticalByCoordinates(Handler.GetCurrentAppiumDriver(),
                    1032,475, 550, 1000);

            Utility.Delay(5);
            Utility.TapByCoordinates(550, 1564);

            Utility.ClickElementById(
                    Handler.GetCurrentAppiumDriver(),
                    "blibli.mobile.commerce:id/bt_understand");

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            Utility.ClickElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_ID,
                    BlibliWebElementConstants.PAYMENT_INDOMARET);

        } else {
            throw new SkipException("Platform is not available");
        }
    }

    @Test
    @Parameters({"platform"})
    public void PayNow(String platform) {

        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {
            Utility.ClickElementById(
                    Handler.GetCurrentAppiumDriver(),
                    "blibli.mobile.commerce:id/tv_checkout");

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            Utility.WaitInvisibilityByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    "angular-loading");

            Log.Debug("test 1");
            try {
                Utility.ClickElementByCssSelector(
                        Handler.GetCurrentWebDriver(),
                        "span",
                        WebElementConstants.PARAM_CLASS,
                        "bli-keylock");
            } catch (Exception e) {
                Log.Error(e);
            }

            Log.Debug("test 2");
            try {
            Utility.ClickElementByXPath(
                    Handler.GetCurrentWebDriver(),
                    "span",
                    WebElementConstants.PARAM_CLASS,
                    "bli-keylock");
            } catch (Exception e) {
                Log.Error(e);
            }

            try {
                Log.Debug("test 3");
                WebDriverWait wait = new WebDriverWait(Handler.GetCurrentWebDriver(),
                        ConfigConstants.DEFAULT_TIMEOUT);
                WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(".//label[@class='submit-checkout__label' and contains(text(), '  Bayar Sekarang')]")));
                el.click();
            } catch (Exception e) {
                Log.Error(e);
            }

            try {
                Log.Debug("test 4");
                WebDriverWait wait = new WebDriverWait(Handler.GetCurrentWebDriver(),
                        ConfigConstants.DEFAULT_TIMEOUT);
                WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(".//label[@for='gdn-submit-checkout' and contains(text(), '  Bayar Sekarang')]")));
                el.click();
            } catch (Exception e) {
                Log.Error(e);
            }

        } else {
            throw new SkipException("Platform is not available");
        }
    }

}
