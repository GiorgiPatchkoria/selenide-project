package ge.tbc.tbcitacademy.steps.swoop;

import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.data.swoop.Constants;
import ge.tbc.tbcitacademy.pages.swoop.SpecificCategoryPage;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.*;

public class SpecificCategorySteps extends BaseSteps {
    SpecificCategoryPage specificCategoryPage = new SpecificCategoryPage();

    @Step("Find text გაყიდულია 0")
    public SpecificCategorySteps findText(){
        specificCategoryPage.amountOfSoldItemsAreZero.isDisplayed();
        return this;
    }

    @Step("Validate that the diagram is empty")
    public SpecificCategorySteps validateDiagramIsEmpty(){
        specificCategoryPage.voucherDiagram.shouldHave(attribute("data-width", Constants.voucherDiagramEmpty));
        return this;
    }

    @Step("Click on drop-down menu")
    public SpecificCategorySteps clickOnDropDown(){
        specificCategoryPage.dropDown.click();
        return this;
    }

    @Step("Choose value")
    public SpecificCategorySteps chooseValue(SelenideElement element){
        element.setSelected(true);
        return this;
    }

    @Step("Set value on price range: {1}")
    public SpecificCategorySteps setValueOnPriceRange(SelenideElement element, String price){
        element.setValue(price);
        return this;
    }

    @Step("Click on delete button to clear filters")
    public SpecificCategorySteps clickOnDelete(){
        specificCategoryPage.deleteButton.click();
        return this;
    }

    @Step("Validate that filters are reset to default")
    public SpecificCategorySteps validateFiltersAreDefault(){
        specificCategoryPage.dropDown.shouldHave(text(Constants.defaultDropDownText));
        specificCategoryPage.defaultCheckBoxOption.shouldBe(selected);
        specificCategoryPage.minPrice.shouldBe(empty);
        specificCategoryPage.maxPrice.shouldBe(empty);
        return this;
    }
}
