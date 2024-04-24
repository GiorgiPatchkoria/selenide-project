package ge.tbc.tbcitacademy.swoop;

import ge.tbc.tbcitacademy.base.BaseTest;
import ge.tbc.tbcitacademy.data.swoop.Constants;
import ge.tbc.tbcitacademy.listeners.CustomTestListener;
import ge.tbc.tbcitacademy.pages.swoop.*;
import ge.tbc.tbcitacademy.steps.swoop.*;
import ge.tbc.tbcitacademy.parametrizationData.PriceRangeData;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

@Test(groups = {"SwoopRegression"})
@Listeners(CustomTestListener.class)
@Epic("Swoop")
public class OfferTests extends BaseTest {
    MainPage mainPage;
    MainPageSteps mainPageSteps;
    DasvenebaPage dasvenebaPage;
    DasvenebaSteps dasvenebaSteps;
    SpecificSubCategoryPage specificSubCategoryPage;
    SpecificSubCategorySteps specificSubCategorySteps;
    SpecificOfferPage specificOfferPage;
    SpecificOfferSteps specificOfferSteps;
    SpecificCategoryPage specificCategoryPage;
    SpecificCategorySteps specificCategorySteps;


    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        mainPage = new MainPage();
        mainPageSteps = new MainPageSteps();
        dasvenebaPage = new DasvenebaPage();
        dasvenebaSteps = new DasvenebaSteps();
        specificSubCategoryPage = new SpecificSubCategoryPage();
        specificSubCategorySteps = new SpecificSubCategorySteps();
        specificOfferPage = new SpecificOfferPage();
        specificOfferSteps = new SpecificOfferSteps();
        specificCategoryPage = new SpecificCategoryPage();
        specificCategorySteps = new SpecificCategorySteps();
        open(Constants.swoopURL);
    }

    @Test(priority = 1, dataProvider = "parametrizedPrices", dataProviderClass = PriceRangeData.class, description = "Validate that offers are filtered correctly")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Price Range")
    @Story("As a user, I want to filter offers based on price range")
    @Description("Verify that offers are filtered correctly based on the provided price range")
    public void rangeTest(String minPrice, String maxPrice){
        mainPageSteps.clickOnDasveneba();
        dasvenebaSteps
                .fillMinPrice(minPrice)
                .fillMaxPrice(maxPrice)
                .clickSearchButton()
                .waitTillPageIsLoaded();
        Assert.assertTrue(dasvenebaSteps.validatePrices(minPrice, maxPrice));
    }

    @Test(priority = 2, description = "Validate favourite button")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Favorite Offers")
    @Story("As a user, I want to mark offers as favorites")
    @Description("Verify that favourite button redirects us to login page and check if vouchers are not sold out")
    public void favouriteOfferTest(){
        mainPageSteps
                .clickOnKategoriebi()
                .hoverOnAnyCategory()
                .clickOnAnySubCategory();
        specificSubCategorySteps
                .clickOnFavouriteButton()
                .verifyLoginPage()
                .goBackToOffers()
                .validateVouchers();
    }

    @Test(priority = 3, description = "Validate share button")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Share Offers")
    @Story("As a user, I want to share offer using facebook")
    @Description("Verify that share button redirects us to facebook login page")
    public void shareOfferTest(){
        mainPageSteps
                .clickOnKategoriebi()
                .hoverOnAnyCategory()
                .clickOnAnySubCategory();
        specificSubCategorySteps.clickOnFirstOffer();
        specificOfferSteps
                .clickOnShareButton()
                .validateFacebookLoginPage();
    }

    @Test(priority = 4, description = "Validate diagram of offers which are not sold out")
    @Feature("No Offers Sold")
    @Story("As a user, I want to see offers with no vouchers sold to have empty diagram")
    @Description("Verify that diagram of all offers, which are not sold out, is empty ")
    public void noOffersSoldTest(){
        mainPageSteps
                .clickOnKategoriebi()
                .clickOnAnyCategory();
        specificCategorySteps
                .findText()
                .validateDiagramIsEmpty();
    }

    @Test(priority = 5, description = "Validate clear button")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Clear Filters")
    @Story("As a user, I want to clear applied filters")
    @Description("Verify that filters are cleared correctly and options are set back to default")
    public void clearFiltersTest(){
        mainPageSteps
                .clickOnKategoriebi()
                .clickOnAnyCategory();
        specificCategorySteps
                .clickOnDropDown()
                .chooseValue(specificCategoryPage.firstDropDownOption)
                .clickOnDropDown()
                .chooseValue(specificCategoryPage.firstCheckBoxOption)
                .setValueOnPriceRange(specificCategoryPage.minPrice, Constants.minPriceAmount)
                .setValueOnPriceRange(specificCategoryPage.maxPrice, Constants.maxPriceAmount)
                .clickOnDelete()
                .validateFiltersAreDefault();
    }
}
