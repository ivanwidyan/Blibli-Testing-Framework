package com.testing.blibli.purchase;

import com.testing.Handler;
import com.testing.Utility;
import com.testing.blibli.constants.BlibliWebElementConstants;
import com.testing.constants.AndroidElementConstants;
import com.testing.constants.ConfigConstants;
import com.testing.constants.Constants;
import com.testing.constants.WebElementConstants;
import com.testing.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

            try {

                Utility.ClickElementByXPathAndContainsText(
                        Handler.GetCurrentWebDriver(),
                        WebElementConstants.CLASS_LABEL,
                        WebElementConstants.PARAM_CLASS,
                        BlibliWebElementConstants.DELIVERY_COURRIER,
                        BlibliWebElementConstants.DELIVERY_STANDARD);

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

            WebElement test = null;
            Actions actions = new Actions(Handler.GetCurrentWebDriver());

            Log.Error("click pake xpath 1");

            try {
                test = Utility.ClickElementByXPath(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.CLASS_INPUT,
                    WebElementConstants.PARAM_ID,
                    BlibliWebElementConstants.DELIVERY_NEXT_STEP);
            } catch (Exception e) {
                Log.Error(e);
            }

            Log.Error("test1: " + test);

            actions.moveToElement(test).click().perform();

            Log.Error("test1: clicked");

//            Utility.Delay(30);

            /*Log.Error("click pake id");
            try {
                test = Utility.ClickElementById(
                        Handler.GetCurrentWebDriver(),
                        BlibliWebElementConstants.DELIVERY_NEXT_STEP);
            } catch (Exception e) {
                Log.Error(e);
            }

            Log.Error("test1: " + test);

            actions.moveToElement(test).click().perform();

            Log.Error("test1: clicked");*/

            Log.Error("click pake xpath 2");
            try {
                test = Utility.ClickElementByXPath(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.CLASS_INPUT,
                    WebElementConstants.PARAM_VALUE,
                    BlibliWebElementConstants.DELIVERY_LANJUTKAN_KE_PEMBAYARAN);
            } catch (Exception e) {
                Log.Error(e);
            }

            Log.Error("test2: " + test);

            actions.moveToElement(test).click().perform();

            Log.Error("test2: clicked");


        } else {
            throw new SkipException("Platform is not available");
        }
    }

}
