package com.softserve.edu.opencart.test;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.softserve.edu.opencart.pages.HomePage;
import com.softserve.edu.opencart.tools.browser.DriverWrapper;

public abstract class TestRunner {
    private final String BASE_URL = "http://taqc-opencart.epizy.com/";
    private final Long ONE_SECOND_DELAY = 1000L;

    protected void presentationSleep() {
        presentationSleep(1);
    }

    protected void presentationSleep(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        presentationSleep(); // For Presentation ONLY
        DriverWrapper.quitDriver();;
    }

    @BeforeMethod
    public void beforeMethod() {
        DriverWrapper.getDriver().get(BASE_URL);
        presentationSleep(); // For Presentation ONLY
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        presentationSleep(); // For Presentation ONLY
        if (!result.isSuccess()) {
            String testName = result.getName();
            System.out.println("***TC error, name = " + testName + " ERROR");
            // Take Screenshot, Save sourceCode, Save to log, Prepare report, Return to previous state, logout, etc.
            // driver.manage().deleteAllCookies(); // clear cache; delete cookie; delete session;
        }
        //driver.findElement(By.cssSelector("#logo .img-responsive")).click();
        //driver.findElement(By.cssSelector("#logo > a")).click();
        DriverWrapper.getDriver().findElement(By.xpath("//img[contains(@src, '/logo.png')]/..")).click();
        presentationSleep(); // For Presentation ONLY
    }

    protected HomePage loadApplication() {
        return new HomePage(DriverWrapper.getDriver());
    }

}
