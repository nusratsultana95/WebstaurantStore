package search;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class SearchResult extends CommonAPI {
    @FindBy(id = "searchval")
    public WebElement searchField;
    @FindBy(xpath = "//button[@class='btn btn-info banner-search-btn']")
    public WebElement clickOnSearchButton;
    @FindBy(css = "a.description") //css = "a.description"
    public List<WebElement> productTitle;
    @FindBy(id = "buyButton")
    WebElement addToCart;
    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[2]/div[2]/div[1]/div[2]/div[1]/a[1]/button[1]")
    WebElement viewCArt;

    public void clickOnSearchField() {
        searchField.click();
    }
    public void typeOnSearchField(String value) {
        searchField.sendKeys(value);
    }
    public void validateSearchButton() {
        clickOnSearchButton.click();
    }
    public void productTitleValidation(){
        System.out.println(productTitle.size());
        for(int i=0;i<productTitle.size();i++) {
            String titleText=productTitle.get(i).getText();
            if (titleText.contains("Table")) {
                System.out.println(titleText);
            } else {
                System.out.println("Every product doesn't contain the word 'Table' in it's title");
            }
        }
    }
    public void clickOnLastElement() {
        for (int i = 0; i < productTitle.size(); i++) {
            if (i == productTitle.size() - 1) {
                productTitle.get(i).click();
                Assert.assertEquals(addToCart.isDisplayed(), true, "Last item hasn't got clicked");
            }
        }
    }
    public void clickOnAddToCart(){
        addToCart.click();
        sleepFor(5);

    }
//    public void clickOnViewCart(){
//        //waitUntilClickable("/html[1]/body[1]/div[3]/div[2]/div[2]/div[1]/div[2]/div[1]/a[1]/button[1]",15);
//       // viewCart.click();
//
//        sleepFor(5);
//    }

    public void waitUntilClickable(int seconds) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, seconds);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(viewCArt)).click();
    }

}
