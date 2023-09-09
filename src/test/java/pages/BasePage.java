package pages;

import com.google.common.base.Predicate;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    public static String baseUrl = "https://cz.careers.veeam.com";
    protected String url;
    protected String pageUrl="";

    protected By parentSelector = new By.ByXPath("..");

    protected  FluentWait wait;
    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = waitFor();
    }

    public void visitPage(String pageUrl) {
        url = baseUrl.concat(pageUrl);
        this.driver.get(url);
    }

    public void fillField(WebElement elem, String str){
        if (str!=null && !str.isEmpty())
            elem.sendKeys(str);
    }

    public FluentWait waitFor(){
        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(25));
        wait.pollingEvery(Duration.ofSeconds(1));

        wait.ignoring(NullPointerException.class);

        return wait;
    }

}
