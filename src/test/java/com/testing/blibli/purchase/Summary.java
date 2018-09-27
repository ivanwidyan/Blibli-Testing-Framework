package com.testing.blibli.purchase;

import com.testing.Handler;
import com.testing.Utility;
import com.testing.blibli.constants.BlibliAndroidElementConstants;
import com.testing.blibli.constants.BlibliWebElementConstants;
import com.testing.constants.AndroidElementConstants;
import com.testing.constants.ConfigConstants;
import com.testing.constants.Constants;
import com.testing.constants.WebElementConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Summary {

    @Test
    @Parameters({"platform", "input"})
    public void PickSize(String platform, @Optional String input) {

        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            int index = Constants.FIRST_INDEX;
            if (input != null) {
                index = Integer.parseInt(input);
            }

            Utility.ClickElementsByCssSelector(Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    BlibliWebElementConstants.SUMMARY_SIZE,
                    index);

        } else {
            throw new SkipException("Platform is not available");
        }
    }

    @Test
    @Parameters({"platform", "input"})
    public void AddQuantity(String platform, @Optional String input) {

        int quantity = 1;
        if (input != null) {
            quantity = Integer.parseInt(input);
        }

        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {

            Utility.ClickElementById(
                    Handler.GetCurrentAppiumDriver(),
                    BlibliAndroidElementConstants.ID_AUTO_COMPLETE_TEXT);

            Utility.ClickElementByXPath(
                    Handler.GetCurrentAppiumDriver(),
                    AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW,
                    AndroidElementConstants.PARAM_TEXT,
                    Integer.toString(quantity));

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            for (int i = 0; i < quantity; i++) {

                Utility.ClickElementByXPathAndContainsText(
                        Handler.GetCurrentWebDriver(),
                        WebElementConstants.CLASS_DIV,
                        WebElementConstants.PARAM_CLASS,
                        BlibliWebElementConstants.SUMMARY_QUANTITY,
                        Constants.SYMBOL_PLUS);

            }

        } else {
            throw new SkipException("Platform is not available");
        }
    }

    @Test
    @Parameters({"platform"})
    public void AddToCart(String platform) {

        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {


        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            Utility.ClickElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    BlibliWebElementConstants.SUMMARY_ADD_TO_CART);

        } else {
            throw new SkipException("Platform is not available");
        }
    }

    @Test
    @Parameters({"platform"})
    public void BuyNow(String platform) {

        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {

            Utility.ClickElementById(
                    Handler.GetCurrentAppiumDriver(),
                    BlibliAndroidElementConstants.ID_BT_BUY_BUTTON);

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            Utility.ClickElementByXPathAndContainsText(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.CLASS_BUTTON,
                    WebElementConstants.PARAM_CLASS,
                    Constants.EMPTY,
                    BlibliWebElementConstants.SUMMARY_BELI_SEKARANG);

        } else {
            throw new SkipException("Platform is not available");
        }
    }

}
