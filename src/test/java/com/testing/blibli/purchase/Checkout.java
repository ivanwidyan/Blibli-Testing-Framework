package com.testing.blibli.purchase;

import com.testing.Handler;
import com.testing.Utility;
import com.testing.blibli.constants.BlibliAndroidElementConstants;
import com.testing.constants.ConfigConstants;
import com.testing.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Checkout {

    @Test
    @Parameters({"platform"})
    public void Continue(String platform) {

        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {

            Utility.ClickElementById(
                    Handler.GetCurrentAppiumDriver(),
                    BlibliAndroidElementConstants.ID_NEXT_BUTTON);

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

        } else {
            throw new SkipException("Platform is not available");
        }
    }

}
