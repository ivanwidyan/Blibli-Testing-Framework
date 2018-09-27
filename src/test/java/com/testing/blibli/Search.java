/*
 * Copyright (c) 2018. Ivan Widyan - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Email: ivanwidyan@yahoo.com
 */

package com.testing.blibli;

import com.testing.Handler;
import com.testing.Utility;
import com.testing.blibli.constants.BlibliAndroidElementConstants;
import com.testing.blibli.constants.BlibliWebElementConstants;
import com.testing.constants.AndroidElementConstants;
import com.testing.constants.ConfigConstants;
import com.testing.constants.Constants;
import com.testing.constants.WebElementConstants;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class Search {

    @Test
    @Parameters({"platform", "input"})
    public void Sort (String platform, String input) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {

            Utility.ClickElementById(
                    Handler.GetCurrentAppiumDriver(),
                    BlibliAndroidElementConstants.ID_IV_SORT_ICON);

            Utility.ClickElementByXPath(
                    Handler.GetCurrentAppiumDriver(),
                    AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW,
                    AndroidElementConstants.PARAM_TEXT,
                    input);

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            Utility.WaitInvisibilityByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    BlibliWebElementConstants.SEARCH_AJAX_LOADING);

            Utility.ClickElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_ID,
                    BlibliWebElementConstants.SEARCH_SORT_ELEMENT);

            String option = Constants.EMPTY;

            if (BlibliWebElementConstants.TEXT_PRODUK_REKOMENDASI.equalsIgnoreCase(input))
                option = BlibliWebElementConstants.SORT_PRODUK_REKOMENDASI;
            else if (BlibliWebElementConstants.TEXT_RELEVANSI.equalsIgnoreCase(input))
                option = BlibliWebElementConstants.SORT_RELEVANSI;
            else if (BlibliWebElementConstants.TEXT_PRODUK_TERBARU.equalsIgnoreCase(input))
                option = BlibliWebElementConstants.SORT_PRODUK_TERBARU;
            else if (BlibliWebElementConstants.TEXT_PRODUK_TERPOPULER.equalsIgnoreCase(input))
                option = BlibliWebElementConstants.SORT_PRODUK_TERPOPULER;
            else if (BlibliWebElementConstants.TEXT_POTONGAN_DISKON.equalsIgnoreCase(input))
                option = BlibliWebElementConstants.SORT_POTONGAN_DISKON;
            else if (BlibliWebElementConstants.TEXT_HARGA_TERMURAH.equalsIgnoreCase(input))
                option = BlibliWebElementConstants.SORT_HARGA_TERMURAH;
            else if (BlibliWebElementConstants.TEXT_HARGA_TERMAHAL.equalsIgnoreCase(input))
                option = BlibliWebElementConstants.SORT_HARGA_TERMAHAL;
            else if (BlibliWebElementConstants.TEXT_RATING_TERTINGGI.equalsIgnoreCase(input))
                option = BlibliWebElementConstants.SORT_RATING_TERTINGGI;

            Utility.ClickElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_VALUE,
                    option);

        } else {
            throw new SkipException("Platform " + platform + "is not available for test");
        }
    }

    @Test
    @Parameters({"platform", "input"})
    public void Brand(String platform, String input) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {

            Utility.ClickElementById(
                    Handler.GetCurrentAppiumDriver(),
                    BlibliAndroidElementConstants.ID_TV_FILTER);

            Utility.ClickElementByXPath(
                    Handler.GetCurrentAppiumDriver(),
                    AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW,
                    AndroidElementConstants.PARAM_TEXT,
                    BlibliAndroidElementConstants.TEXT_BRAND);

            Utility.SendKeysElementById(
                    Handler.GetCurrentAppiumDriver(),
                    BlibliAndroidElementConstants.ID_SEARCH_SRC_TEXT,
                    input);

            Utility.ClickElementById(
                    Handler.GetCurrentAppiumDriver(),
                    BlibliAndroidElementConstants.ID_RB_FACET_NAME);

            Utility.ClickElementById(
                    Handler.GetCurrentAppiumDriver(),
                    BlibliAndroidElementConstants.ID_SEARCH_FILTER_CONFIRM);

            Handler.GetCurrentAppiumDriver().hideKeyboard();

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            Utility.WaitInvisibilityByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    BlibliWebElementConstants.SEARCH_AJAX_LOADING);

            Utility.SendKeysElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_ID,
                    BlibliWebElementConstants.FILTER_BRAND,
                    input);

            Utility.ClickElementByXPathAndContainsText(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.CLASS_SPAN,
                    WebElementConstants.PARAM_CLASS,
                    BlibliWebElementConstants.FILTER_NAME,
                    input);

            Utility.WaitInvisibilityByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    BlibliWebElementConstants.SEARCH_AJAX_LOADING);

        } else {
            throw new SkipException("Platform is not available");
        }
    }

    @Test
    @Parameters({"platform", "min", "max"})
    public void Price(String platform, @Optional String min,
                      @Optional String max) {

        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {

            Utility.ClickElementById(
                    Handler.GetCurrentAppiumDriver(),
                    BlibliAndroidElementConstants.ID_TV_FILTER);

            Utility.ClickElementByXPath(
                    Handler.GetCurrentAppiumDriver(),
                    AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW,
                    AndroidElementConstants.PARAM_TEXT,
                    BlibliAndroidElementConstants.TEXT_HARGA);

            Utility.SendKeysElementById(
                    Handler.GetCurrentAppiumDriver(),
                    BlibliAndroidElementConstants.ID_ET_MIN_PRICE,
                    min);

            Utility.SendKeysElementById(
                    Handler.GetCurrentAppiumDriver(),
                    BlibliAndroidElementConstants.ID_ET_MAX_PRICE,
                    max);

            Utility.ClickElementById(
                    Handler.GetCurrentAppiumDriver(),
                    BlibliAndroidElementConstants.ID_SEARCH_FILTER_CONFIRM);

            Handler.GetCurrentAppiumDriver().hideKeyboard();

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            if (min != null) {
                Utility.WaitInvisibilityByCssSelector(
                        Handler.GetCurrentWebDriver(),
                        WebElementConstants.PARAM_CLASS,
                        BlibliWebElementConstants.SEARCH_AJAX_LOADING);

                Utility.SendKeysElementByCssSelector(
                        Handler.GetCurrentWebDriver(),
                        WebElementConstants.PARAM_ID,
                        BlibliWebElementConstants.FILTER_PRICE_MIN, min);
            }

            if (max != null) {
                Utility.WaitInvisibilityByCssSelector(
                        Handler.GetCurrentWebDriver(),
                        WebElementConstants.PARAM_CLASS,
                        BlibliWebElementConstants.SEARCH_AJAX_LOADING);

                Utility.SendKeysElementByCssSelector(
                        Handler.GetCurrentWebDriver(),
                        WebElementConstants.PARAM_ID,
                        BlibliWebElementConstants.FILTER_PRICE_MAX, max);
            }

        } else {
            throw new SkipException("Platform is not available");
        }
    }

    @Test
    @Parameters({"platform", "input"})
    public void Location(String platform, String input) {

        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {

            Utility.ClickElementById(
                    Handler.GetCurrentAppiumDriver(),
                    BlibliAndroidElementConstants.ID_TV_FILTER);

            Utility.ClickElementByXPath(
                    Handler.GetCurrentAppiumDriver(),
                    AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW,
                    AndroidElementConstants.PARAM_TEXT,
                    BlibliAndroidElementConstants.TEXT_LOKASI_PENJUAL);

            Utility.SendKeysElementById(
                    Handler.GetCurrentAppiumDriver(),
                    BlibliAndroidElementConstants.ID_SEARCH_SRC_TEXT,
                    input);

            Utility.ClickElementById(
                    Handler.GetCurrentAppiumDriver(),
                    BlibliAndroidElementConstants.ID_RB_FACET_NAME);

            Utility.ClickElementById(
                    Handler.GetCurrentAppiumDriver(),
                    BlibliAndroidElementConstants.ID_SEARCH_FILTER_CONFIRM);

            Handler.GetCurrentAppiumDriver().hideKeyboard();

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            Utility.WaitInvisibilityByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    BlibliWebElementConstants.SEARCH_AJAX_LOADING);

            Utility.ClickElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_ID,
                    BlibliWebElementConstants.FILTER_LOCATION);

            Utility.WaitInvisibilityByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    BlibliWebElementConstants.SEARCH_AJAX_LOADING);

            String origin = "Origin-" + input;

            Utility.ClickElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_VALUE,
                    origin);

        } else {
            throw new SkipException("Platform is not available");
        }
    }

    @Test
    @Parameters({"platform", "input"})
    public void Select(String platform, @Optional String input) {

        int index = Constants.FIRST_INDEX;
        if (input != null) {
            index = Integer.parseInt(input);
        }

        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {

            Utility.ClickElementsByXpath(
                    Handler.GetCurrentAppiumDriver(),
                    AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW,
                    AndroidElementConstants.PARAM_RESOURCE_ID,
                    BlibliAndroidElementConstants.ID_TV_PRODUCT_NAME,
                    Constants.FIRST_INDEX);

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            Utility.WaitInvisibilityByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    BlibliWebElementConstants.SEARCH_AJAX_LOADING);

            Utility.ClickElementsByCssSelector(Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    BlibliWebElementConstants.SEARCH_PRODUCT_TITLE,
                    index);

        } else {
            throw new SkipException("Platform is not available");
        }
    }

    @Test
    @Parameters({"platform"})
    public void PrintItem(String platform) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {

            Utility.GetElementByXPath(
                    Handler.GetCurrentAppiumDriver(),
                    AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW,
                    AndroidElementConstants.PARAM_RESOURCE_ID,
                    BlibliAndroidElementConstants.ID_TV_PRODUCT_NAME);

            Utility.GetElementByXPath(
                    Handler.GetCurrentAppiumDriver(),
                    AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW,
                    AndroidElementConstants.PARAM_RESOURCE_ID,
                    BlibliAndroidElementConstants.ID_TV_PRODUCT_ACTUAL_PRICE);

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            Utility.WaitInvisibilityByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    BlibliWebElementConstants.SEARCH_AJAX_LOADING);

            PrintItemInformation (
                    Utility.GetElementsByCssSelector(Handler.GetCurrentWebDriver(),
                        WebElementConstants.PARAM_CLASS,
                        BlibliWebElementConstants.SEARCH_PRODUCT_TITLE),

                    Utility.GetElementsByCssSelector(Handler.GetCurrentWebDriver(),
                            WebElementConstants.PARAM_CLASS,
                            BlibliWebElementConstants.SEARCH_PRODUCT_PRICE));
        } else {
            throw new SkipException("Platform is not available");
        }
    }

    private void PrintItemInformation (List<WebElement> productTitle, List<WebElement> producPrice) {
        System.out.println("######## Print Searched Items ########");
        for (int i = 0; i < productTitle.size(); i++) {
            System.out.println("Title: " + productTitle.get(i).getText());
            System.out.println("Price: " + producPrice.get(i).getText());
        }
    }
}
