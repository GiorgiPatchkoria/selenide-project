package ge.tbc.tbcitacademy.saucedemo;

import ge.tbc.tbcitacademy.base.BaseTest;
import ge.tbc.tbcitacademy.data.sauceDemo.Constants;
import ge.tbc.tbcitacademy.listeners.CustomTestListener;
import ge.tbc.tbcitacademy.steps.sauceDemo.DatabaseSteps;
import ge.tbc.tbcitacademy.utils.UserModel;
import ge.tbc.tbcitacademy.pages.sauceDemo.LoginPage;
import ge.tbc.tbcitacademy.pages.sauceDemo.HomePage;
import ge.tbc.tbcitacademy.steps.sauceDemo.LoginSteps;
import ge.tbc.tbcitacademy.steps.sauceDemo.HomeSteps;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.open;

@Test(groups = {"SauceDemoLogin"})
@Listeners(CustomTestListener.class)
@Epic("SauceDemo")
public class LoginTests extends BaseTest {
    DatabaseSteps databaseSteps;
    LoginPage loginPage;
    LoginSteps loginSteps;
    HomePage homePage;
    HomeSteps homeSteps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        databaseSteps = new DatabaseSteps();
        loginPage = new LoginPage();
        loginSteps = new LoginSteps();
        homePage = new HomePage();
        homeSteps = new HomeSteps();
        open(Constants.sauceDemoURL);
    }

    @Test(priority = 1, description = "Valid user login test")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Login Feature")
    @Story("As a standard user, I should be able to see images correctly")
    @Description("Verify successful login with valid credentials and verify images are displayed")
    public void successfulLoginTest(){
        UserModel user = databaseSteps.selectUser(Constants.standardUser);
        loginSteps
                .fillUsername(user.getUsername())
                .fillPassword(user.getPassword())
                .clickLogin();
        homeSteps.validateImages();
    }

    @Test(priority = 2, description = "Banned user login test")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Login Feature")
    @Story("As a banned user, I should get error message")
    @Description("Verify login attempt by a banned user and verify error message")
    public void bannedUserLoginTest(){
        UserModel user = databaseSteps.selectUser(Constants.lockedOutUser);
        loginSteps
                .fillUsername(user.getUsername())
                .fillPassword(user.getPassword())
                .clickLogin()
                .validateErrorMessage()
                .validateErrorIcon(loginPage.errorButtonIcon)
                .validateErrorIcon(loginPage.errorIconOnUsername)
                .validateErrorIcon(loginPage.errorIconOnPassword);
    }

    @Test(priority = 3, description = "Problematic user login test")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Login Feature")
    @Story("As a problematic user, I should not be able to see images correctly")
    @Description("Verify login attempt with problematic credentials and verify images are not displayed")
    public void problematicLoginTest(){
        UserModel user = databaseSteps.selectUser(Constants.problemUser);
        loginSteps
                .fillUsername(user.getUsername())
                .fillPassword(user.getPassword())
                .clickLogin();
        homeSteps.validateImages();
    }

    @Test(priority = 4, description = "Logout from valid user")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Logout Feature")
    @Story("As a standard user, I want to logout from account")
    @Description("Verify successful logout from the application")
    public void logOutTest(){
        UserModel user = databaseSteps.selectUser(Constants.standardUser);
        loginSteps
                .fillUsername(user.getUsername())
                .fillPassword(user.getPassword())
                .clickLogin();
        homeSteps
                .clickOnMenuButton()
                .clickOnLogOut();
        loginSteps
                .validateEmptyField(loginPage.usernameInput)
                .validateEmptyField(loginPage.passwordInput);
    }
}
