package com.testing.blibli.purchase;

import com.sun.corba.se.impl.orbutil.closure.Constant;
import com.testing.Handler;
import com.testing.Utility;
import com.testing.blibli.constants.BlibliAndroidElementConstants;
import com.testing.blibli.constants.BlibliWebElementConstants;
import com.testing.constants.ConfigConstants;
import com.testing.constants.Constants;
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
                    BlibliAndroidElementConstants.ID_CONTINUE_BTN);

            Utility.Delay(3);
            Utility.TapByCoordinates(1006, 136);

            Utility.Delay(3);
            Utility.TapByCoordinates(480, 364);

            String paymentCode = Utility.GetElementById(
                    Handler.GetCurrentAppiumDriver(),
                    BlibliAndroidElementConstants.ID_TV_ORDER_ID).getText();

            Log.Info("Payment Code: " + paymentCode);

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            String paymentCode = Constants.EMPTY;

            try {
                WebElement el = Utility.ClickElementByXPathAndContainsText(
                        Handler.GetCurrentWebDriver(),
                        WebElementConstants.CLASS_SPAN,
                        WebElementConstants.PARAM_CLASS,
                        BlibliWebElementConstants.THANKYOU_ORDERNUMBER,
                        BlibliWebElementConstants.THANKYOU_TEXT_NOMOR_PESANAN);
                paymentCode = el.getText();

            } catch (Exception e) {
                Log.Error(e);
            }

            String[] noPesanan = paymentCode.split(Constants.SPACE);

            Log.Info("Payment Code: " + noPesanan[2]);

        } else {
            throw new SkipException("Platform is not available");
        }
    }

}
