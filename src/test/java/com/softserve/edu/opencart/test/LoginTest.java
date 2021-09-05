package com.softserve.edu.opencart.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import ru.yandex.qatools.allure.annotations.Step;
import io.qameta.allure.SeverityLevel;
import ru.yandex.qatools.allure.annotations.Title;


import com.softserve.edu.opencart.data.User;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.EditAccountPage;
import com.softserve.edu.opencart.pages.HomePage;
import com.softserve.edu.opencart.pages.UnsuccessfulLoginPage;

@Title("Testing LOGIN")
public class LoginTest extends TestRunner {

    @DataProvider
    public Object[][] dataSuccessful() {
        //
        // TODO
        //
        return new Object[][] {
            { new UserRepository().getExistUser() },
        };
    }
    @Description("Test verify SUCCESSFUL LOGIN")
    @Step("Assertion for SUCCESSFUL LOGIN")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "dataSuccessful")
    public void checkSuccessful(User user) {
        //
        // Steps
        EditAccountPage editAccountPage = loadApplication()
                .gotoLoginPage()
                .successfulLogin(user.getEmail(), user.getPassword())
                .gotoEditAccountRight();
        presentationSleep();
        //
        // Check
        Assert.assertEquals(editAccountPage.getFirstNameFieldText(), user.getFirstname());
        //
        // Return to Previous State
        HomePage homePage = editAccountPage
                .gotoContinue() // optional
                .gotoLogoutRight()
                .gotoContinue();
        //
        // Check
        Assert.assertTrue(homePage
                .getSlideshow0FirstImageAttributeSrcText()
                .contains(HomePage.EXPECTED_IPHONE6));
        presentationSleep();
    }
    
    @DataProvider
    public Object[][] dataUnsuccessful() {
        return new Object[][] {
            //
            // TODO
            //
            { "invalid@awdrt.com", "pass", "not" },
        };
    }

    @Description("Test verify UNSUCCESSFUL LOGIN")
    @Step("Assertion for UNSUCCESSFUL LOGIN")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "dataUnsuccessful")
    public void checkUnsuccessful(String email, String password, String firstName) {
        //
        // Steps
        UnsuccessfulLoginPage unsuccessfulLoginPage = loadApplication()
                .gotoLoginPage()
                .unsuccessfulLoginPage(email, password)
                .unsuccessfulLoginPage(email, password)
                .unsuccessfulLoginPage(email, password)
                .unsuccessfulLoginPage(email, password)
                .unsuccessfulLoginPage(email, password);
        presentationSleep();
        //
        // Check
        Assert.assertTrue(unsuccessfulLoginPage.getAlertWarningText()
                .contains(UnsuccessfulLoginPage.EXPECTED_LOGIN_MESSAGE));
        presentationSleep();
        //
        // Steps
        unsuccessfulLoginPage = unsuccessfulLoginPage
                .unsuccessfulLoginPage(email, password)
                .unsuccessfulLoginPage(email, password);
        //
        // Check
        Assert.assertTrue(unsuccessfulLoginPage.getAlertWarningText()
                .contains(UnsuccessfulLoginPage.EXPECTED_LOCK_MESSAGE));
        presentationSleep();
        //
        // Return to Previous State
        HomePage homePage = unsuccessfulLoginPage
                .gotoHomePage();
        //
        // Check (optional)
        Assert.assertTrue(homePage
                .getSlideshow0FirstImageAttributeSrcText()
                .contains(HomePage.EXPECTED_IPHONE6));
        presentationSleep();
    }

}
