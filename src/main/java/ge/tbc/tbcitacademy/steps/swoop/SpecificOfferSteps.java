package ge.tbc.tbcitacademy.steps.swoop;

import ge.tbc.tbcitacademy.data.swoop.Constants;
import ge.tbc.tbcitacademy.pages.swoop.SpecificOfferPage;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlStartingWith;

public class SpecificOfferSteps extends BaseSteps {
    SpecificOfferPage specificOfferPage = new SpecificOfferPage();

    @Step("Click on the Share button")
    public SpecificOfferSteps clickOnShareButton(){
        specificOfferPage.shareButton.click();
        return this;
    }

    @Step("Validate that Facebook login page is opened")
    public SpecificOfferSteps validateFacebookLoginPage(){
        switchTo().window(1);
        webdriver().shouldHave(urlStartingWith(Constants.facebookLoginURL));
        return this;
    }
}
