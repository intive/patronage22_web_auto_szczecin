package com.intive.template.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

public class ConfigurationManager {

    public final String BROWSER_CONFIG = System.getProperty("environment");

    public Map<String,String> getBrowserConfiguration() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String devicePath = String.format("src/test/resources/suite/%s.json", BROWSER_CONFIG);
            return objectMapper.readValue(Paths.get(devicePath).toFile(), Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}