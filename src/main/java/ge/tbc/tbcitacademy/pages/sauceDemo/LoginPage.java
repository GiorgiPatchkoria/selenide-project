package ge.tbc.tbcitacademy.pages.sauceDemo;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    public SelenideElement usernameInput = $(By.id("user-name")),
                passwordInput = $(By.id("password")),
                loginButton = $(By.id("login-button")),
                errorMessageContainer = $x("//h3[@data-test='error']"),
                errorButtonIcon = $x("//button[@class='error-button']"),
                errorIconOnUsername = usernameInput.parent().find(".error_icon"),
                errorIconOnPassword = passwordInput.parent().find(".error_icon");
}
