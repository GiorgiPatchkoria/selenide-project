package ge.tbc.tbcitacademy.utils;

import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.pages.swoop.DasvenebaPage;
import java.util.ArrayList;
import java.util.List;

public class PriceHandler {
    public static List<Integer> getAllPrices(){
        DasvenebaPage dasvenebaPage = new DasvenebaPage();
        List<Integer> pricesList = new ArrayList<>();
        for (SelenideElement price : dasvenebaPage.discountedPrices){
            String priceString = price.getText();
            int priceNumber = Integer.parseInt(priceString.substring(0, priceString.length() - 1));
            pricesList.add(priceNumber);
        }
        return pricesList;
    }
}
