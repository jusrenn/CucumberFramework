package log4j_example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import utilities.DriverWeb;

public class test {

    private static final Logger logger = LogManager.getLogger();

    @Test
    public void test01() {
        DriverWeb.getDriver().get("https://www.google.com.tr");
        logger.info("Google anasayfasina gildi!");

        String title = DriverWeb.getDriver().getTitle();

        if(title.equals("")) {
            logger.info("Google anasayfasina ulasilamadi!");
        } else {
            logger.info("Title alindi!");
        }

        DriverWeb.quit();
    }
}
