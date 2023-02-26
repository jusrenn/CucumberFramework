package log4j_example;

import org.apache.log4j.Logger;
import org.junit.Test;
import utilities.DriverWeb;


public class test {

    final static Logger logger = Logger.getLogger(test.class);

    @Test
    public void test01() {
        DriverWeb.getDriver().get("https://www.google.com.tr");
        logger.info("Google anasayfasina gildi!");

        String title = DriverWeb.getDriver().getTitle();

        if(title.equals("")) {
            logger.fatal("Google anasayfasina ulasilamadi!");
        } else {
            logger.info("Title alindi!");
        }
    }
}
