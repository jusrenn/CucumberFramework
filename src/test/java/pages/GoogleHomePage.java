package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class GoogleHomePage {
    public GoogleHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//div[@class='QS5gu sy4vMaaa'])[2]")
    public WebElement acceptCookiesButton;

    @FindBy(css = "[name=qaaa]")
    public WebElement searchBoxInput;

    @FindBy(id = "result-statsaaa")
    public WebElement resultText;
}
