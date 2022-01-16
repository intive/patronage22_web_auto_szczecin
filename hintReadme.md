In this file you will find many helpful explanations about project structure and files.

#Project structure

Structure of project for Maven with cucumber will be similar like below:

```xml
my-app
|-- pom.xml
|-- .gitignore
|-- readme.md
|-- src
    |-- test
        |-- java
            |-- com
                |-- mycompany
                        |-- app
                            |--Driver.java
                            |--TestRunner.java
                            |--pages
                                |--BasePage.java
                                |--ExamplePage.java
                            |--steps
                                |--Hooks.java
                                |--ExamplePageStepdefs.java
                            |--commonuse (methods which will be used often by another classes)
                            |--snipets (submodel)
        |--resources
            |--cucumber.properties
            |--features
                |--examplePage.feature
    |-- main
        |-- java
            |-- com
                |-- mycompany
                    |-- app
                        |-- App.java
```
_Driver.class_ - class for _browser/mobile device/appium/selenium_ driver declaration.\
In this class we can also add any loggers and taking screen shoots tools.

_TestRunner.class_ - configuration class for starting our tests with cucumber plugin.

_pages_ - package where are stored all classes file with webpages and BasePage.class.\
In these files there are declaration of locators and methods for them.

_BasePage.class_ - base class which will be use in each other web pages classes.

_steps_ - package with steps for each webpages written in gherkin.

_Hooks.java_ - class with declaration what should be done before and after each scenario.

_resources_ - folder where are stored all needed resources for project. This can be pictures, json files, etc.

_features_ - folder where are stored all features files which includes scenarios for given tests.

Files _pom.xml_, _.gitignore_ and _readme.md_ will be described as separate sections.

# **POM.XML**

POM stands for "Project Object Model". It is an XML representation of a Maven project.

Below is examples and descriptions of most important tags in this file.

```xml
<modelVersion>4.0.0</modelVersion>
<groupId>company name </groupId>
<artifactId>myproject</artifactId>
<version>1.0.0</version>
<name>MyProjectName</name>
<description>Simple description</description>
```
modelVersion - declares to which version of project descriptor this POM conforms.\
groupId	- generally unique amongst an organization or a project, usually reverse of company domain\
artifactId - name which identify artifact, usually name of our project\
version	- version number of artifact as three number divided by dots\
name - name which identify artifact but written in elegant way because is displayed each time when project is building\
description	- short description of project. It is also displayed during project building\
\
Here few sections examples in this file:

dependencies - dependencies section for other  Maven artifacts usually *.jar packages or other external library's
```xml
<dependencies>
<dependency>
<groupId>org.apache.commons</groupId>
<artifactId>commons-lang3</artifactId>
<version>3.0</version>
</dependency>
...
</dependencies>
```
build - section of additional options running during project build process. Here we can add and configure plugins.

```xml
<build>
<plugins>
<plugin>
<groupId>org.apache.maven.plugins</groupId>
<artifactId>maven-compiler-plugin</artifactId>
<configuration>
<source>1.8</source>
<target>1.8</target>
</configuration>
</plugin>
...
</plugins>		
</build>
```
repositories - section where we can add external repositories and Maven will look for external artifacts.\
However, is usually empty because it can be also configured in settings.xml file.
```xml
<repositories>
<repository>
<id>repository.spring.release</id>
<name>Spring GA Repository</name>
<url>http://repo.spring.io/release</url>
</repository>
...
</repositories>
```
Also in pom.xml you can define java version which should be used.
```xml
<properties>
	<java.version>1.8</java.version>
</properties>
```
More information about pom.xml you can easily find [here](http://maven.apache.org/pom.html#Build_Settings).

# .gitignore

The .gitignore file is a text file that tells Git which files or folders to ignore in a project.\
A local .gitignore file is usually placed in the root directory of a project.\
You can also create a global .gitignore file and any entries in that file will be ignored in all of your Git repositories.\
To create a local .gitignore file, create a text file and name it .gitignore (remember to include the . at the beginning).\
Then edit this file as needed. Each new line should list an additional file or folder that you want Git to ignore.

The entries in this file can also follow a matching pattern.\
`
    * is used as a wildcard match`\
`/ is used to ignore pathnames relative to the .gitignore file`\
`# is used to add comments to a .gitignore file`

More information about .gitignore you can find [here](https://git-scm.com/docs/gitignore)
#readme.md

A README file is an essential guide that gives other developers a detailed description of your project.
The quality of a README description differentiates a good project from bad ones.
In intelliJ you can create readme.md file by following these [hints](https://www.jetbrains.com/help/idea/markdown.html). \
Remember to keep your README updated.

 

#Running Maven Tools

Maven Phases

Although hardly a comprehensive list, these are the most common default lifecycle phases executed.

    validate: validate the project is correct and all necessary information is available
    compile: compile the source code of the project
    test: test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed
    package: take the compiled code and package it in its distributable format, such as a JAR.
    integration-test: process and deploy the package if necessary into an environment where integration tests can be run
    verify: run any checks to verify the package is valid and meets quality criteria
    install: install the package into the local repository, for use as a dependency in other projects locally
    deploy: done in an integration or release environment, copies the final package to the remote repository for sharing with other developers and projects.

There are two other Maven lifecycles of note beyond the default list above. They are

    clean: cleans up artifacts created by prior builds

    site: generates site documentation for this project

Example of Maven command mostly used by software testers/QA is `mvn clean test`

#