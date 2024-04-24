package ge.tbc.tbcitacademy.pages.swoop;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class SpecificSubCategoryPage {
    public SelenideElement
            firstOffer = $x("//div[@class='special-offer'][1]"),
            favouriteButton = firstOffer.$x(".//div[@class='deal-box-wishlist']"),
            voucherDiagram = firstOffer.$x(".//div[@class='voucher-limit']");
}
