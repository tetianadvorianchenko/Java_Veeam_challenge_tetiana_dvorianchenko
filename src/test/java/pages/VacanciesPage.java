package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class VacanciesPage extends BasePage {
    String pageUrl = "/vacancies";
    @FindBy(css="div[id='cookiescript_accept']")
    WebElement acceptCookies;
    @FindBy(css="input[name='query']")
    WebElement keywordField;
    @FindBy(xpath=".//button[text()=\"All departments\"]")
    WebElement departmentDropdown;
    @FindBy(xpath=".//button[text()=\"All languages\"]")
    WebElement languagesDropdown;
    @FindBy(xpath=".//button[text()=\"Any experience\"]")
    WebElement experienceDropdown;
    @FindBy(className="ce-validation__hint")
    WebElement clearFilters;
    @FindBy(css="h3 span[class='text-secondary pl-2']")
    WebElement vacancies_count;
    @FindAll(@FindBy(css="a[class='dropdown-item']"))
    List<WebElement> dropdownOptions;
    @FindAll(@FindBy(css="div[class='custom-control custom-checkbox']"))
    List<WebElement> checkboxDropdown;

    protected By vacancies_locator = By.cssSelector("a[class='card card-sm card-no-hover']");

    public VacanciesPage(WebDriver driver)
    {
        super(driver);
        visitPage(pageUrl);
        PageFactory.initElements(this.driver, this);
    }

    public void isPageLoaded(){
        wait.until(ExpectedConditions.visibilityOf(acceptCookies));
        wait.until(ExpectedConditions.visibilityOf(keywordField));
        wait.until(ExpectedConditions.visibilityOf(departmentDropdown));
        wait.until(ExpectedConditions.visibilityOf(experienceDropdown));
        wait.until(ExpectedConditions.visibilityOf(languagesDropdown));
    }
    public void acceptCookies(){
        acceptCookies.click();
        wait.until(ExpectedConditions.invisibilityOf(acceptCookies));
    }
    public void clearFilters(){
        clearFilters.click();
    }

    public boolean areFiltersShown(){
        return keywordField.isDisplayed() && departmentDropdown.isDisplayed() && languagesDropdown.isDisplayed() && experienceDropdown.isDisplayed();
    }

    public void fillKeyWord(String text){
        keywordField.sendKeys(text);
    }
    public void setDepartment(String value){
        departmentDropdown.click();
        wait.until(ExpectedConditions.visibilityOf(findOptionByText(dropdownOptions, value)));
        findOptionByText(dropdownOptions, value).click();
    }
    public void openLanguageDropdown(){
        languagesDropdown.click();
    }
    public void setLanguage(String value){
        wait.until(ExpectedConditions.visibilityOf(findOptionByText(checkboxDropdown, value)));
        findOptionByText(checkboxDropdown, value).click();
    }
    public void setExperience(String value){
        experienceDropdown.click();
        wait.until(ExpectedConditions.visibilityOf(findOptionByText(dropdownOptions, value)));
        findOptionByText(dropdownOptions, value).click();
    }

    public WebElement findOptionByText(List<WebElement> options,String value){
        for(WebElement option: options){
            if (option.getText().equalsIgnoreCase(value)){
                return option;
            }
        }
        return null;
    }
    public void submitFilters(){
        keywordField.click();

    }
    public int countVacanciesShown(){
        List<WebElement> vacancies = this.driver.findElements(vacancies_locator);
        return vacancies.size();
    }

    public int getVacanciesOpenNum(){
        return Integer.valueOf(vacancies_count.getText());
    }
}
