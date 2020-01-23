package pages;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class HomePage extends CommonAPI {
    @FindBy(id = "searchval")
    public WebElement searchField;
    @FindBy(xpath = "//button[@class='btn btn-info banner-search-btn']")
    public WebElement clickOnSearchButton;

    /////////////////search result
    @FindBy(css = "a.description")
    public List<WebElement> productTitle;

    ///////order page
    @FindBy(id = "buyButton")
    WebElement addToCart;
    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[2]/div[2]/div[1]/div[2]/div[1]/a[1]/button[1]")
    WebElement viewCart;

    /////checkout page
    @FindBy(css = "a.emptyCartButton.btn.btn-mini.btn-ui.pull-right")
    WebElement emptyCart;
    @FindBy(xpath = "//button[contains(text(),'Empty Cart')]")
    WebElement warning;

    ///////last page
    @FindBy(css = "p.header-1")
    WebElement header;

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
       Assert.assertEquals(viewCart.isDisplayed(),true,"Product didn't add to cart");

    }

    public void waitUntilClickable(int seconds) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, seconds);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(viewCart)).click();
        Assert.assertEquals(emptyCart.isDisplayed(),true,"Checkout page isn't get displayed");
    }
    public void clickOnEmptyCart(){
        emptyCart.click();
        sleepFor(5);
        Assert.assertEquals(warning.isDisplayed(),true,"Warning isn't popped up");

    }
    public void validateWarning(){
        warning.click();
        sleepFor(5);
        Assert.assertEquals(header.isDisplayed(),true,"Shopping cart isn't empty");
    }

}
