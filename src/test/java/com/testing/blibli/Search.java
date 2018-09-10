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
import com.testing.constants.Constants;
import com.testing.constants.WebElementConstants;
import com.testing.logging.Log;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
                    "blibli.mobile.commerce:id/iv_sort_icon");

            Utility.ClickElementByXPath(
                    Handler.GetCurrentAppiumDriver(),
                    AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW,
                    AndroidElementConstants.PARAM_TEXT,
                    input);

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            Utility.WaitInvisibilityByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    "ajax-loading");

            Utility.ClickElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_ID,
                    BlibliWebElementConstants.SEARCH_SORT_ELEMENT);

            String option = "";

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
                    "blibli.mobile.commerce:id/tv_filter");

            Utility.ClickElementByXPath(
                    Handler.GetCurrentAppiumDriver(),
                    AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW,
                    AndroidElementConstants.PARAM_TEXT,
                    "Brand");

            Utility.SendKeysElementById(
                    Handler.GetCurrentAppiumDriver(),
                    "blibli.mobile.commerce:id/search_src_text",
                    input);

            Utility.ClickElementById(
                    Handler.GetCurrentAppiumDriver(),
                    "blibli.mobile.commerce:id/rb_facet_name");

            Utility.ClickElementById(
                    Handler.GetCurrentAppiumDriver(),
                    "blibli.mobile.commerce:id/search_filter_confirm");

            Handler.GetCurrentAppiumDriver().hideKeyboard();

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            Utility.WaitInvisibilityByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    BlibliWebElementConstants.SEARCH_LOADING);

            Utility.SendKeysElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_ID,
                    BlibliWebElementConstants.FILTER_BRAND,
                    input);

            // TODO: Clean this up
            WebDriverWait wait = new WebDriverWait(Handler.GetCurrentWebDriver(),
                    ConfigConstants.DEFAULT_TIMEOUT);
            WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath(".//span[@class='filter-name' and contains(text(), '" + input + "')]")));
            el.click();

            Utility.WaitInvisibilityByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    BlibliWebElementConstants.SEARCH_LOADING);

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
                    "blibli.mobile.commerce:id/tv_filter");

            Utility.ClickElementByXPath(
                    Handler.GetCurrentAppiumDriver(),
                    AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW,
                    AndroidElementConstants.PARAM_TEXT,
                    "Harga");

            Utility.SendKeysElementById(
                    Handler.GetCurrentAppiumDriver(),
                    "blibli.mobile.commerce:id/et_min_price",
                    min);

            Utility.SendKeysElementById(
                    Handler.GetCurrentAppiumDriver(),
                    "blibli.mobile.commerce:id/et_max_price",
                    max);

            Utility.ClickElementById(
                    Handler.GetCurrentAppiumDriver(),
                    "blibli.mobile.commerce:id/search_filter_confirm");

            Handler.GetCurrentAppiumDriver().hideKeyboard();

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            if (min != null) {
                Utility.WaitInvisibilityByCssSelector(
                        Handler.GetCurrentWebDriver(),
                        WebElementConstants.PARAM_CLASS,
                        BlibliWebElementConstants.SEARCH_LOADING);

                Utility.SendKeysElementByCssSelector(
                        Handler.GetCurrentWebDriver(),
                        WebElementConstants.PARAM_ID,
                        BlibliWebElementConstants.FILTER_PRICE_MIN, min);
            }

            if (max != null) {
                Utility.WaitInvisibilityByCssSelector(
                        Handler.GetCurrentWebDriver(),
                        WebElementConstants.PARAM_CLASS,
                        BlibliWebElementConstants.SEARCH_LOADING);

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
                    "blibli.mobile.commerce:id/tv_filter");

            Utility.ClickElementByXPath(
                    Handler.GetCurrentAppiumDriver(),
                    AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW,
                    AndroidElementConstants.PARAM_TEXT,
                    "Lokasi Penjual");

            Utility.SendKeysElementById(
                    Handler.GetCurrentAppiumDriver(),
                    "blibli.mobile.commerce:id/search_src_text",
                    input);

            Utility.ClickElementById(
                    Handler.GetCurrentAppiumDriver(),
                    "blibli.mobile.commerce:id/rb_facet_name");

            Utility.ClickElementById(
                    Handler.GetCurrentAppiumDriver(),
                    "blibli.mobile.commerce:id/search_filter_confirm");

            Handler.GetCurrentAppiumDriver().hideKeyboard();

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            Utility.WaitInvisibilityByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    BlibliWebElementConstants.SEARCH_LOADING);

            Utility.ClickElementByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_ID,
                    BlibliWebElementConstants.FILTER_LOCATION);

            Utility.WaitInvisibilityByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    BlibliWebElementConstants.SEARCH_LOADING);

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
                    "blibli.mobile.commerce:id/tv_product_name",
                    Constants.FIRST_INDEX);

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            Utility.WaitInvisibilityByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    BlibliWebElementConstants.SEARCH_LOADING);

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
                    "blibli.mobile.commerce:id/tv_product_name");

            Utility.GetElementByXPath(
                    Handler.GetCurrentAppiumDriver(),
                    AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW,
                    AndroidElementConstants.PARAM_RESOURCE_ID,
                    "blibli.mobile.commerce:id/tv_product_actual_price");

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            Utility.WaitInvisibilityByCssSelector(
                    Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    BlibliWebElementConstants.SEARCH_LOADING);

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
