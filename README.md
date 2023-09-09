# Veeam test automation challenge

Using Selenium WebDriver, please do the following:
- Open https://cz.careers.veeam.com/vacancies and maximize the browser window.
- Then, choose Research & Development and English from the lists of departments and
  languages, respectively.
- Please, count the number of jobs found and compare this value with the expected result.

## Coverage
- Test has parametrized  values of input parameters and the expected
job number so that the code could be used with various parameter sets.
- Used a browser of my choice (Chrome)

## Run requirements
- Java 8+ installed
- gradle installed
- web access

## How to build
In command line go to the root project folder and run command to build before the first run
```bash
gradle build
```
## How to run
In command line and run command from the root project folder
```bash
gradle cucumber
```

## Results observing
Test report is shown in console and pretty report is generated and available by url shown in console.
Look for :
````
 View your Cucumber Report at:                                            
 https://reports.cucumber.io/reports/<xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx> 

 This report will self-destruct in 24h.                                   
 Keep reports forever: https://reports.cucumber.io/profile                
````
