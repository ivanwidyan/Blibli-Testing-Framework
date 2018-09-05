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
import com.testing.constants.WebElementConstants;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class Search {

    @Test
    @Parameters({"platform", "input"})
    public void Sort (String platform, String input) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            Utility.ClickElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_ID,
                    BlibliWebElementConstants.SEARCH_SORT_ELEMENT);

            String option = "";

            if ("Produk rekomendasi".equalsIgnoreCase(input))
                option = "11";
            else if ("Relevansi".equalsIgnoreCase(input))
                option = "0";
            else if ("Produk terbaru".equalsIgnoreCase(input))
                option = "1";
            else if ("Produk terpopuler".equalsIgnoreCase(input))
                option = "7";
            else if ("Potongan diskon".equalsIgnoreCase(input))
                option = "6";
            else if ("Harga termurah".equalsIgnoreCase(input))
                option = "3";
            else if ("Harga termahal".equalsIgnoreCase(input))
                option = "4";
            else if ("Rating Tertinggi".equalsIgnoreCase(input))
                option = "9";

            Utility.ClickElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_VALUE,
                    option);

        } else {
            throw new SkipException("Platform " + platform + "is not available for test");
        }
    }

    @Test
    @Parameters({"platform"})
    public void PrintItem(String platform) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            PrintItemInformation (
                    Utility.GetElementsByCssSelector(Handler.GetCurrentWebDriver(),
                        WebElementConstants.PARAM_CLASS,
                        BlibliWebElementConstants.PRODUCT_TITLE),

                    Utility.GetElementsByCssSelector(Handler.GetCurrentWebDriver(),
                            WebElementConstants.PARAM_CLASS,
                            BlibliWebElementConstants.PRODUCT_PRICE));
        } else {
            throw new SkipException("Platform is not available");
        }
    }

    private void PrintItemInformation (List<WebElement> productTitle, List<WebElement> producPrice) {
        System.out.println("###################################");
        for (int i = 0; i < productTitle.size(); i++) {
            System.out.println("Flight: " + productTitle.get(i).getText());
            System.out.println("Time: " + producPrice.get(i).getText());
        }
    }
}
