package com.qa.orangehr.framework.utils.config;

import java.io.*;
import java.util.Properties;

public class ConfigUtils {
    private static Properties prop;

    public static Properties getConfigProperties() {
        if (prop == null) {
            prop = new Properties();
            try (InputStream inputStream = ConfigUtils.class.getClassLoader().getResourceAsStream("config.properties")) {
                if (inputStream == null) {
                    throw new IOException("Config file not found");
                }
                prop.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return prop;
    }
}
