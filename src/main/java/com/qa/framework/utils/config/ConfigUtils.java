package com.qa.framework.utils.config;

import java.io.*;
import java.util.Properties;

public class ConfigUtils {
    public static Properties prop;

    private ConfigUtils() {
    }

    public static Properties getConfigProperties() {
        if (prop == null) {
            prop = new Properties();
            //by default
            String project = System.getProperty("project", "orangehr");
            String fileName = "project-" + project + ".properties";

            try (InputStream inputStream = ConfigUtils.class.getClassLoader().getResourceAsStream(fileName)) {
                if (inputStream == null) {
                    throw new IOException("Config file not found" + fileName);
                }
                prop.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return prop;
    }

    public static String getProperty(String key) {
        return getConfigProperties().getProperty(key);
    }
}
