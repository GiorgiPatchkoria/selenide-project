package ge.tbc.tbcitacademy.steps.sauceDemo;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import ge.tbc.tbcitacademy.data.sauceDemo.Constants;
import ge.tbc.tbcitacademy.pages.sauceDemo.HomePage;
import io.qameta.allure.Step;

public class HomeSteps {
    HomePage homePage = new HomePage();

    @Step("Validate images on home page")
    public HomeSteps validateImages(){
        homePage.images.shouldHave(CollectionCondition.size(6));
        homePage.images.forEach(img -> img.shouldBe(Condition.visible));
        homePage.images.forEach(img -> img.shouldNotHave(Condition.attributeMatching("src", Constants.invalidImage)));
        return this;
    }

    @Step("Click on menu button")
    public HomeSteps clickOnMenuButton(){
        homePage.menuButton.click();
        return this;
    }

    @Step("Click on logout button")
    public HomeSteps clickOnLogOut(){
        homePage.logOutButton.click();
        return this;
    }
}
