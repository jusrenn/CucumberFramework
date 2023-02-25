package stepDefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.GoogleHomePage;
import utilities.ConfigReader;
import utilities.DriverWeb;
import utilities.ReusableMethods;

public class GoogleStepDefinition {

    GoogleHomePage google = new GoogleHomePage();

    @Given("Google anasayfasina git")
    public void google_anasayfasina_git() {
        DriverWeb.getDriver().get(ConfigReader.getProperty("googleURL"));
    }
    @Given("SearchBox'a {string} yi yaz ve enter'a bas")
    public void search_box_a_yi_yaz_ve_enter_a_bas(String string) {
        if(ReusableMethods.elementIsVisible(google.acceptCookiesButton)) {
            google.acceptCookiesButton.click();
        }
        google.searchBoxInput.sendKeys(string + Keys.ENTER);
    }
    @Given("Aramanin basariyla yapildigini kontrol et")
    public void aramanin_basariyla_yapildigini_kontrol_et() {
        String resultText = google.resultText.getText();
        String[] resultTextArr = resultText.split(" ");
        Long resultSum = Long.parseLong(resultTextArr[1].replace(".", ""));

        Assert.assertTrue(resultSum>0);
    }

    @Given("Browser'i kapat")
    public void Browseri_kapat() {
        DriverWeb.quit();
    }
}