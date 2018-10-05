package misc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Browser {

    Properties prop = new Properties();
    private FileInputStream objfile;

    public enum RunBrowser {
        CHROME("chrome"),
        FIREFOX("firefox"),
        IE("ie");

        RunBrowser(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }

    public WebDriver config(RunBrowser browserName) {
        WebDriver browser =null;

        try {
            objfile = new FileInputStream(System.getProperty("user.dir") + "/src/misc/objects.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            prop.load(objfile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String chromeDriverPath = prop.getProperty("chromeDriverPath");
        String firefoxDriverPath = prop.getProperty("firefoxDriverPath");

        if (browserName.getValue().equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            browser = new ChromeDriver();
        } else {
            System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
            browser = new FirefoxDriver();
        }

        return browser;
    }
}
