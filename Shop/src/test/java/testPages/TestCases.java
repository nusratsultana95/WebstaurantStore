package testPages;

import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckOutPage;
import pages.HomePage;
import pages.OrderPage;
import pages.ProductPage_Stainless_Work_Table;

public class TestCases extends CommonAPI {
    HomePage homePage;
    ProductPage_Stainless_Work_Table productPageObj;
    OrderPage orderPage;
    CheckOutPage checkOutPage;
    @BeforeMethod
    public void setSearchResult(){
        homePage = PageFactory.initElements(driver, HomePage.class);
        productPageObj=PageFactory.initElements(driver,ProductPage_Stainless_Work_Table.class);
        orderPage=PageFactory.initElements(driver,OrderPage.class);
        checkOutPage=PageFactory.initElements(driver,CheckOutPage.class);
    }
    @Test
    public void shopTestValidation(){
        homePage.clickOnSearchField();
        homePage.typeOnSearchField("stainless work table");
        homePage.validateSearchButton();
        productPageObj.productTitleValidation();
        productPageObj.clickOnLastElement();
        orderPage.clickOnAddToCart();
        orderPage.waitUntilClickable(5);
        checkOutPage.clickOnEmptyCart();
        checkOutPage.validateWarning();
    }
}
