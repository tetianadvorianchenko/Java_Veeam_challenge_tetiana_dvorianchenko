# Celonis test automation challenge

This challenge has a goal to implement an automated test suite which consists of some
basic health checks in order to validate that the system is up and running and catches any
potential bugs introduced by changes to the system.

## Coverage
Test suite consisting of automated tests that check the login functionality, validates presence and availability of all 3 Demo analyses:
Order to cash, Purchase to pay and service now ticketing by ensuring that the analyses load
successfully and display the content correctly when opened.
Implemented in Java with Cucumber+Selenium+JUnit.

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
