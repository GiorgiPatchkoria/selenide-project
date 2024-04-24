package ge.tbc.tbcitacademy.steps.sauceDemo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.data.sauceDemo.Constants;
import ge.tbc.tbcitacademy.pages.sauceDemo.LoginPage;
import io.qameta.allure.Step;


public class LoginSteps {
    LoginPage loginPage = new LoginPage();

    @Step("Fill username field with: {0}")
    public LoginSteps fillUsername(String data){
        loginPage.usernameInput.setValue(data);
        return this;
    }

    @Step("Fill password field with: {0}")
    public LoginSteps fillPassword(String data){
        loginPage.passwordInput.setValue(data);
        return this;
    }

    @Step("Click on login button")
    public LoginSteps clickLogin(){
        loginPage.loginButton.click();
        return this;
    }

    @Step("Validate error message")
    public LoginSteps validateErrorMessage(){
        loginPage.errorMessageContainer.shouldHave(Condition.exactText(Constants.errorMessage));
        return this;
    }

    @Step("Validate error icon")
    public LoginSteps validateErrorIcon(SelenideElement element){
        element.shouldBe(Condition.visible);
        return this;
    }

    @Step("Validate empty field")
    public LoginSteps validateEmptyField(SelenideElement element){
        element.shouldBe(Condition.empty);
        return this;
    }

}
