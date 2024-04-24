package ge.tbc.tbcitacademy.parametrizationData;

import org.testng.annotations.DataProvider;

public class PriceRangeData {
    @DataProvider
    public static Object[][] parametrizedPrices(){
        return new Object[][]{
                {"100", "200"},
                {"50", "100"},
                {"500", "1000"},
                {"300","400"},
                {"100", "1000"}
        };
    }
}
