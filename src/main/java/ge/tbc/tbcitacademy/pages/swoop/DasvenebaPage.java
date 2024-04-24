package ge.tbc.tbcitacademy.pages.swoop;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class DasvenebaPage {
    public SelenideElement
            minPrice = $x("//div[@id='sidebar-container']//input[@id='minprice']"),
            maxPrice = $x("//div[@id='sidebar-container']//input[@id='maxprice']"),
            searchButton = $x("//div[@id='sidebar']//div[@class='submit-button']");
    public ElementsCollection discountedPrices = $$x("//div[@class='discounted-prices']/p[1]");
}
