package searchTest;

import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import search.SearchResult;

public class TestCases extends CommonAPI {
    SearchResult searchResult;
    @BeforeMethod
    public void setSearchResult(){
        searchResult= PageFactory.initElements(driver,SearchResult.class);
    }
    @Test
    public void shopTestValidation(){
        searchResult.clickOnSearchField();
        searchResult.typeOnSearchField("stainless work table");
        searchResult.validateSearchButton();
        searchResult.productTitleValidation();
        searchResult.clickOnLastElement();
        searchResult.clickOnAddToCart();
        searchResult.clickOnViewCart();
    }
}
