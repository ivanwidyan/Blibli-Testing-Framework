/*
 * Copyright (c) 2018. Ivan Widyan - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Email: ivanwidyan@yahoo.com
 */

package com.testing.blibli;

import com.testing.Handler;
import com.testing.Utility;
import com.testing.constants.ConfigConstants;
import com.testing.constants.Constants;
import com.testing.constants.WebElementConstants;
import com.testing.logging.Log;
import com.testing.blibli.constants.BlibliAndroidElementConstants;
import com.testing.blibli.constants.BlibliConfigConstants;

import com.testing.blibli.constants.BlibliWebElementConstants;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.*;

public class Home {

    @Test
    @Parameters({"platform", "input"})
    public void Search (String platform, String input) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {

            Utility.Delay(10);
            Utility.TapByCoordinates(490, 280);

            Utility.SendKeysElementById(
                    Handler.GetCurrentAppiumDriver(),
                    BlibliAndroidElementConstants.ID_AV_KEY_SEARCH,
                    input);

            Utility.TapByCoordinates(1000, 1700);

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            Utility.SendKeysElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_NG_MODEL,
                    BlibliWebElementConstants.HOME_SEARCHPARAM,
                    input);

            Utility.ClickElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_ID,
                    BlibliWebElementConstants.HOME_SEARCH_BUTTON);

        } else {
            throw new SkipException("Platform " + platform + "is not available for test");
        }
    }

    @Test
    @Parameters({"platform", "input"})
    public void KategoriBelanja (String platform, String input) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

        } else {
            throw new SkipException("Platform " + platform + "is not available for test");
        }
    }
}
