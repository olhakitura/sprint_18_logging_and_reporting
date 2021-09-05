package com.softserve.edu.opencart.tools.browser;

import org.openqa.selenium.WebDriver;

public final class DriverWrapper {
    //
    private static WebDriver driver;

    private DriverWrapper() {
    }
    
    public static void setDriver(Browsers browser) {
        driver = browser.runBrowser();
    }
    
    public static WebDriver getDriver() {
        if (driver == null) {
            setDriver(Browsers.DEFAULT_TEMPORARY);
        }
        return driver;
    }
    
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
    
}
