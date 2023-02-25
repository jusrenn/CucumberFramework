package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverAndroid {
    private static AndroidDriver<AndroidElement> driver;

    public static AndroidDriver<AndroidElement> getDriver() {
        if(driver == null) {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigReader.getProperty("platformName"));
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
