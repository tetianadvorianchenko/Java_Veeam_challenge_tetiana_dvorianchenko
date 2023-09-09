package steps_definitions;

import org.openqa.selenium.WebDriver;

public class BaseStepdefs {
    protected static WebDriver driver;
    public static WebDriver getDriver() {
        return driver;
    }

    public void setDriver(){
        driver=HelperClass.getDriver();
    }
}
