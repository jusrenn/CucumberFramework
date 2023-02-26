package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverWeb;

// page_url = https://www.google.com.tr
public class GoogleHomePage {
    public GoogleHomePage() {
        PageFactory.initElements(DriverWeb.getDriver(), this);
    }

    @FindBy(xpath = "(//div[@class='QS5gu sy4vM'])[2]")
    public WebElement acceptCookiesButton;

    @FindBy(css = "[name=q]")
    public WebElement searchBoxInput;

    @FindBy(id = "result-stats")
    public WebElement resultText;
}
