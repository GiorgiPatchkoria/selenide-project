package ge.tbc.tbcitacademy.pages.swoop;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SpecificCategoryPage {
    public SelenideElement
            amountOfSoldItemsAreZero = $(withText("გაყიდულია 0")),
            voucherDiagram = amountOfSoldItemsAreZero.parent().parent().$x(".//div[@class='voucher-limit']"),
            dropDown = $x("//div[@class='sidebar']//button[@class='ms-choice']"),
            firstDropDownOption = $x("//div[@id='sidebar']//input[@data-key='option_0']"),
            firstCheckBoxOption = $x("//div[@id='sidebar']//input[@value='0']"),
            minPrice = $x("//div[@id='sidebar-container']//input[@id='minprice']"),
            maxPrice = $x("//div[@id='sidebar-container']//input[@id='maxprice']"),
            deleteButton = $x("//div[@id='sidebar']//div[@class='delete-search-button']"),
            defaultCheckBoxOption = $x("//div[@id='sidebar']//input[@value='2']");
}
