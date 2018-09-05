/*
 * Copyright (c) 2018. Ivan Widyan - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Email: ivanwidyan@yahoo.com
 */

package com.testing.blibli;

import com.testing.Handler;
import com.testing.Utility;
import com.testing.constants.AndroidElementConstants;
import com.testing.constants.ConfigConstants;
import com.testing.logging.Log;
import com.testing.blibli.constants.BlibliConfigConstants;
import com.testing.blibli.constants.BlibliAndroidElementConstants;
import org.testng.SkipException;
import org.testng.annotations.*;

public class SplashScreen {

    @Test
    @Parameters({"platform"})
    public void SkipSplashScreen (String platform) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {

        } else {
            throw new SkipException("This test only for Android!");
        }
    }
}
