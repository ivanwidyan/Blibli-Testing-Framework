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
import com.testing.constants.ConfigConstants;
import com.testing.constants.ElementConstants;
import com.testing.constants.WebElementConstants;
import org.testng.SkipException;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login {

    @Test
    @Parameters({"platform", "username", "password"})
    public void Login (String platform, @Optional String username,
                       @Optional String password) {

        if (username == null) {
            username = ElementConstants.TEST_EMAIL;
        }

        if (password == null) {
            password = ElementConstants.TEST_PASSWORD;
        }

        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {

            Utility.ClickElementById(
                    Handler.GetCurrentAppiumDriver(),
                    "blibli.mobile.commerce:id/rb_existing_user");

            Utility.SendKeysElementById(
                    Handler.GetCurrentAppiumDriver(),
                    "blibli.mobile.commerce:id/et_user_email_id",
                    username);

            Utility.SendKeysElementById(
                    Handler.GetCurrentAppiumDriver(),
                    "blibli.mobile.commerce:id/et_user_password",
                    password);

            Utility.ClickElementById(
                    Handler.GetCurrentAppiumDriver(),
                    "blibli.mobile.commerce:id/bt_register");

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            Utility.SendKeysElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    "input input--email",
                    username);

            Utility.SendKeysElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    "input input--password",
                    password);

            Utility.ClickElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    "button-submit");

        } else {
            throw new SkipException("Platform " + platform + "is not available for test");
        }
    }

}
