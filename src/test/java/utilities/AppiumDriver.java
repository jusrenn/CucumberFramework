package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriver {
    private static AndroidDriver<AndroidElement> driver;

    public static AndroidDriver<AndroidElement> getDriver() {
        if(driver == null) {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("udid", ConfigReader.getProperty("udid"));
            cap.setCapability("deviceName", ConfigReader.getProperty("deviceName"));
            cap.setCapability("platformName", ConfigReader.getProperty("platformName"));
            cap.setCapability("platformVersion", ConfigReader.getProperty("platformVersion"));
            cap.setCapability("appPackage", ConfigReader.getProperty("youtubeAppPackage"));
            cap.setCapability("appActivity", ConfigReader.getProperty("youtubeActivity"));

            try {
                URL remoteUrl = new URL(ConfigReader.getProperty("AppiumServer"));
                driver = new AndroidDriver(remoteUrl, cap);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        return driver;
    }

    public static void closeApp() {
        if(driver != null) {
            driver.closeApp();
            driver = null;
        }
    }
}
