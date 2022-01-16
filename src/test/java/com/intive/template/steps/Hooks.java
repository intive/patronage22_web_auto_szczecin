package com.intive.template.steps;

import com.intive.template.BrowserDriverSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.MalformedURLException;

public class Hooks {

    private static final Logger LOGGER = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void beforeScenario(Scenario scenario) throws MalformedURLException {
        LOGGER.info("================ BEFORE SCENARIO ====================\n");
        String scenarioName = scenario.getName();
        LOGGER.info(scenarioName + "\n");
        BrowserDriverSetup.startDriver(scenarioName);
    }

    @After
    public void afterScenario(Scenario scenario) throws IOException {
        BrowserDriverSetup.processExecutedScenario(scenario);
    }
}