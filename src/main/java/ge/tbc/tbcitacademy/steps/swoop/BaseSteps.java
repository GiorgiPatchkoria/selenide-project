package ge.tbc.tbcitacademy.steps.swoop;


import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.data.swoop.Constants;
import ge.tbc.tbcitacademy.pages.swoop.BasePage;
import ge.tbc.tbcitacademy.utils.CategoriesHandler;
import io.qameta.allure.Step;

public class BaseSteps {
    BasePage basePage = new BasePage();

    @Step("Click on დასვენება button")
    public BaseSteps clickOnDasveneba(){
        basePage.dasvenebaButton.click();
        return this;
    }

    public BaseSteps clickOnKategoriebi(){
        basePage.kategoriebiDropDown.click();
        return this;
    }

    @Step("Hover on any category")
    public BaseSteps hoverOnAnyCategory(){
        // chooseMainCategoryWithSubCategories-ის ვაწვდით კატეგორიების ზომას(რომლებსაც ქვეკატეგორიები აქვთ), რათა ამოარჩიოს ნებისმიერი კატეგორია რენდომულად
        int index = CategoriesHandler.chooseMainCategoryWithSubCategories(basePage.listOfCategoriesWithSubCategories.size());
        basePage.listOfCategoriesWithSubCategories.get(index).hover();
        return this;
    }

    @Step("Click on any subcategory")
    public BaseSteps clickOnAnySubCategory(){
        // ვირჩევთ კატეგორიას რენდომად მიღებული ინდექსით
        SelenideElement chosenCategory = basePage.listOfCategoriesWithSubCategories.get(CategoriesHandler.mainCategoryIndex);
        // chooseSubCategory-ის ვაწვდით არჩეული კატეგორიის ქვეკატეგორიების ზომას
        int index = CategoriesHandler.chooseSubCategory(chosenCategory.$$x(Constants.subCategories).size());
        chosenCategory.$$x(Constants.subCategories).get(index).click();
        return this;
    }

    @Step("Click on any category")
    public BaseSteps clickOnAnyCategory(){
        int index = CategoriesHandler.chooseMainCategory(basePage.listOfMainCategories.size());
        basePage.listOfMainCategories.get(index).click();
        return this;
    }
}
