package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CheckOutPage {
    @FindBy(css = "a.emptyCartButton.btn.btn-mini.btn-ui.pull-right")
    WebElement emptyCart;
    @FindBy(xpath = "//button[contains(text(),'Empty Cart')]")
    WebElement warning;


    public void clickOnEmptyCart(){
        emptyCart.click();
       // Assert.assertEquals(warning.isDisplayed(),true,"Warning isn't popped up");

    }
    public void validateWarning(){
        warning.click();
       // Assert.assertEquals(header.isDisplayed(),true,"Shopping cart isn't empty");
    }

}
