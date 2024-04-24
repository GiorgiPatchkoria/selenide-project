package ge.tbc.tbcitacademy.steps.swoop;

import ge.tbc.tbcitacademy.data.swoop.Constants;
import ge.tbc.tbcitacademy.pages.swoop.DasvenebaPage;
import ge.tbc.tbcitacademy.utils.PriceHandler;
import io.qameta.allure.Step;
import java.util.List;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class DasvenebaSteps extends BaseSteps {
    DasvenebaPage dasvenebaPage = new DasvenebaPage();

    @Step("Fill minimum price with: {0}")
    public DasvenebaSteps fillMinPrice(String minPrice){
        dasvenebaPage.minPrice.click();
        dasvenebaPage.minPrice.setValue(minPrice);
        return this;
    }

    @Step("Fill maximum price with: {0}")
    public DasvenebaSteps fillMaxPrice(String maxPrice){
        dasvenebaPage.maxPrice.click();
        dasvenebaPage.maxPrice.setValue(maxPrice);
        return this;
    }

    @Step("Click on search button")
    public DasvenebaSteps clickSearchButton(){
        dasvenebaPage.searchButton.click();
        return this;
    }

    @Step("Wait till page is loaded")
    public DasvenebaSteps waitTillPageIsLoaded(){
        webdriver().shouldHave(urlContaining(Constants.partOfPriceRangeURL));
        return this;
    }

    @Step("Validate prices in the search results")
    public boolean validatePrices(String minPrice, String maxPrice){
        int minPriceInt = Integer.parseInt(minPrice);
        int maxPriceInt = Integer.parseInt(maxPrice);
        List<Integer> allPrices = PriceHandler.getAllPrices();
        return allPrices.stream().allMatch(prices -> prices >= minPriceInt && prices <= maxPriceInt);
    }
}
