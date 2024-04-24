package ge.tbc.tbcitacademy.pages.swoop;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class BasePage {
    public SelenideElement
            dasvenebaButton = $x("//a[div[contains(@class, 'MenuIcon')] and normalize-space()='დასვენება']"),
            kategoriebiDropDown = $x("//div[@class='NewCategories newcat']");
    public ElementsCollection
            listOfCategoriesWithSubCategories = $$x("//li[contains(@class, 'leftSideMenu') and count(div[contains(@class, 'subCategory')]) > 0]"),
            listOfMainCategories = $$x("//li[contains(@class, 'leftSideMenu')]");
}
