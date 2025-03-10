package com.qa.userinyerface.framework.utils.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {
    public static Properties prop;

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
