# MAKEFILE

# CONST
export BROWSERSTACK_KEY=<secrete>
export BROWSERSTACK_USER=<secrete>

MAVEN_NORMAL_RUN:
	mvn clean test

MAVEN_BS_RUN:
	mvn clean test -Dbrowser="bs_chrome" -Denvironment="bs_chrome_win"