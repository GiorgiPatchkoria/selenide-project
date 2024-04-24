package ge.tbc.tbcitacademy.steps.swoop;

import ge.tbc.tbcitacademy.data.swoop.Constants;
import ge.tbc.tbcitacademy.pages.swoop.SpecificSubCategoryPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.back;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class SpecificSubCategorySteps extends BaseSteps {
    SpecificSubCategoryPage specificSubCategoryPage = new SpecificSubCategoryPage();

    @Step("Click on the Favourite button")
    public SpecificSubCategorySteps clickOnFavouriteButton(){
        specificSubCategoryPage.favouriteButton.click();
        return this;
    }

    @Step("Verify that login page is opened")
    public SpecificSubCategorySteps verifyLoginPage(){
        webdriver().shouldHave(urlContaining(Constants.loginPage));
        return this;
    }

    @Step("Go back to offers")
    public SpecificSubCategorySteps goBackToOffers(){
        back();
        return this;
    }

    @Step("Validate that vouchers are not sold out")
    public SpecificSubCategorySteps validateVouchers(){
        specificSubCategoryPage.voucherDiagram.shouldNotHave(attribute("data-width", Constants.voucherDiagramFull));
        return this;
    }

    @Step("Click on the first offer")
    public SpecificSubCategorySteps clickOnFirstOffer(){
        specificSubCategoryPage.firstOffer.click();
        return this;
    }

}
