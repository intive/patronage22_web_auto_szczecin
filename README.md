### FRAMEWORK

This is simple example of test automation web framework.
- Java 15+ 
- Maven
- Selenium 4.0
- jUnit5
- Cucumber
- Chrome/Firefox
- BrowserStack



### TEST FRAMEWORK SETUP

Install the most important package manager for MAC
- #### Install [Brew](https://brew.sh)

Install latest JAVA version 
- #### Install [Latest Java](https://formulae.brew.sh/formula/openjdk)

Install latest MAVEN version
- #### Install [Maven](https://formulae.brew.sh/formula/maven#default)

Install Chromedriver and automatically put it to PATH
- #### Install [Chromedriver](https://formulae.brew.sh/cask/chromedriver#default)

### RUN TEST
Default test will run on Chrome

- Run all `mvn clean test` 
- Run by tag `mvn clean test -Dcucumber.filter.tags="@Smoke"`
- Run on different browser `mvn clean test -Dbrowser='firefox'`

Also check Makefile for Browserstack


