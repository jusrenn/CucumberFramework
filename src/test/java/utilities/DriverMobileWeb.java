package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverMobileWeb {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if(driver == null) {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability(CapabilityType.BROWSER_NAME, ConfigReader.getProperty("browser"));
            cap.setCapability(CapabilityType.PLATFORM_NAME, ConfigReader.getProperty("platformName"));

            try {
                URL remoteURL = new URL(ConfigReader.getProperty("AppiumServer"));
                driver = new RemoteWebDriver(remoteURL, cap);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public static void quit() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void close() {
        if(driver != null) {
            driver.close();
            driver = null;
        }
    }
}
