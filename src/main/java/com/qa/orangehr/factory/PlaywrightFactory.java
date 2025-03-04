package com.qa.orangehr.factory;

import com.microsoft.playwright.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PlaywrightFactory {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    Properties prop;

    public Browser getBrowser(Properties prop) {
        playwright = Playwright.create();
        String browserName = prop.getProperty("browser").trim();
        switch (browserName.toLowerCase()) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)
                        .setSlowMo(450));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "safari":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome")
                        .setHeadless(false).setSlowMo(1000));
                break;
            default:
                System.out.println("Invalid browser name: " + browserName);
        }
        return browser;
    }

    /*
    Этот метод к фабрике отнощения не имеет
    по логике, нужно создать класс брауер который будет использовать брауер полученный из фабрики
    (и покрытый синголтоном) и уже в этом классе, браузер можно будет закрывать, переключать на вкладки,
    брать урл и прочие
     */

    public Page getNewContextAndPage(Browser browser) {
        browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate(prop.getProperty("URL").trim());
        return page;
    }


    /*
    Метод ниже необходимо переснести к утилитам

    и нельзя использовать абсолютные пути
     */

    /**
     * this method is used to initialize the properties from config file
     */
    public Properties getProp() {
        try {
            FileInputStream ip = new FileInputStream(new File("./src/main/resources/config/config.properties"));
            prop = new Properties();
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
