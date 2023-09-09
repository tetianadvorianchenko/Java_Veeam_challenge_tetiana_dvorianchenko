package steps_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.VacanciesPage;

import java.util.Arrays;
import java.util.List;

public class VacanciesStepdefs extends BaseStepdefs{
    protected VacanciesPage vacanciesPage;

    @Given("Vacancies page is open")
    public void vacanciesPageIsOpened() {
        setDriver();
        vacanciesPage = new VacanciesPage(driver);
        vacanciesPage.isPageLoaded();
        vacanciesPage.acceptCookies();
    }

    @Then("Vacancies page is shown")
    public void vacanciesPageIsShown() {
        Assert.assertTrue("Vacancies page is not shown", vacanciesPage.areFiltersShown());
    }
    @Then("{int} vacancies are shown")
    public void checkVacanciesNumber(int num){

        Assert.assertEquals("Number of vacancies does not match",num,vacanciesPage.countVacanciesShown());
    }
    @Then("{int} matches Vacancies open number")
    public void validateVacanciesOpenNum(int num){
        Assert.assertEquals("Number of vacancies does not match UI",num, vacanciesPage.getVacanciesOpenNum());
    }

    @When("user fills keyword with {string}")
    public void fillKeywords(String value) {
        if (!value.isEmpty())
            vacanciesPage.fillKeyWord(value);
    }
    @When("user selects department {string}")
    public void selectDepartment(String value) {
        if (!value.isEmpty())
            vacanciesPage.setDepartment(value);
    }

    @When("user selects language {string}")
    public void selectLanguage(String values) {
        List<String> languages = Arrays.asList(values.split(","));
        if (languages.size()>0) {
            vacanciesPage.openLanguageDropdown();
            for (String lang : languages) {
                vacanciesPage.setLanguage(lang);
            }
            vacanciesPage.submitFilters();
        }
    }

    @When("user selects experience {string}")
    public void selectExperience(String value) {
        if (!value.isEmpty())
            vacanciesPage.setExperience(value);
        vacanciesPage.submitFilters();
    }
}
