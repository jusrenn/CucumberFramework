package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class GoogleHomePage {
    public GoogleHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//div[@class='QS5guaa sy4vM'])[2]")
    public WebElement acceptCookiesButton;

    @FindBy(css = "[name=qcc]")
    public WebElement searchBoxInput;

    @FindBy(id = "result-statsss")
    public WebElement resultText;
}
