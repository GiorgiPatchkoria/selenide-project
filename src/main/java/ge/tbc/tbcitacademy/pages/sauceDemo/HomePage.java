package ge.tbc.tbcitacademy.pages.sauceDemo;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {
    public ElementsCollection images = $$x("//img[@class='inventory_item_img']");
    public SelenideElement menuButton = $x("//button[@id='react-burger-menu-btn']"),
                        logOutButton = $x("//a[@id='logout_sidebar_link']");
}
