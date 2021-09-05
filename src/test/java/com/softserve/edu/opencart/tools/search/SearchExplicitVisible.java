package com.softserve.edu.opencart.tools.search;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.softserve.edu.opencart.tools.browser.DriverWrapper;

public class SearchExplicitVisible extends Search {
    private final Long EXPLICITLY_WAIT_SECONDS = 10L;
    private WebDriverWait driverWait;

    public SearchExplicitVisible() {
        //
        // TODO
        //
    }

    protected WebDriverWait getDriverWait() {
        return driverWait;
    }

    @Override
    public WebElement getWebElement(By by) {
        //
        // TODO
        //
        return null;
    }

    @Override
    public WebElement getWebElement(By by, WebElement fromWebElement) {
        //
        // TODO
        //
        return null;
    }

    @Override
    public List<WebElement> getWebElements(By by) {
        //
        // TODO
        //
        return null;
    }

    @Override
    public List<WebElement> getWebElements(By by, WebElement fromWebElement) {
        //
        // TODO
        //
        return null;
    }

}
