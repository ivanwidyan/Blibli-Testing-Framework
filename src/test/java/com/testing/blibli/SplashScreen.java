/*
 * Copyright (c) 2018. Ivan Widyan - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Email: ivanwidyan@yahoo.com
 */

package com.testing.blibli;

import com.testing.Handler;
import com.testing.Utility;
import com.testing.blibli.constants.BlibliWebElementConstants;
import com.testing.constants.AndroidElementConstants;
import com.testing.constants.ConfigConstants;
import com.testing.constants.WebElementConstants;
import com.testing.logging.Log;
import com.testing.blibli.constants.BlibliConfigConstants;
import com.testing.blibli.constants.BlibliAndroidElementConstants;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.*;

import java.sql.Time;

public class SplashScreen {

    @Test
    @Parameters({"platform"})
    public void SkipSplashScreen (String platform) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {

            WebElement getStarted = null;
            while (getStarted == null) {

                Utility.Delay(1);
                Utility.SwipeHorizontalByCoordinates(
                        Handler.GetCurrentAppiumDriver(),
                        1050, 0, 800
                );

                try {
                    getStarted = Utility.GetElementById(
                            Handler.GetCurrentAppiumDriver(),
                            BlibliAndroidElementConstants.ID_GET_STARTED_BUTTON,
                            ConfigConstants.NO_TIMEOUT);
                } catch (TimeoutException e) {}

            }

            Utility.ClickElementById(
                    Handler.GetCurrentAppiumDriver(),
                    BlibliAndroidElementConstants.ID_GET_STARTED_BUTTON);

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            try {
                Utility.ClickElementByCssSelector(
                        Handler.GetCurrentWebDriver(),
                        WebElementConstants.PARAM_CLASS,
                        BlibliWebElementConstants.HOME_AD, ConfigConstants.NO_TIMEOUT);
            } catch (TimeoutException e) {}
        }
        else {
            throw new SkipException("This test only for Android!");
        }
    }
}
