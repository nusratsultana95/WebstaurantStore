package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ProductPage_Stainless_Work_Table{
    OrderPage orderPage= new OrderPage();
    @FindBy(css = "a.description")
    public List<WebElement> productTitle;

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
               //Assert.assertEquals(orderPage.addToCart.isDisplayed(), true, "Last item hasn't got clicked");
            }
        }
    }
}
