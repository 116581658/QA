package com.galenframework.java.sample.components;

import com.galenframework.java.misc.Browser;
import com.galenframework.testng.GalenTestNgTestBase;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;

import java.util.List;

import static java.util.Arrays.asList;

public abstract class GalenTestBase extends GalenTestNgTestBase {

    private static final String ENV_URL = "http://testapp.galenframework.com";
    Browser setBrowser = new Browser();
    WebDriver browser;
    @Override
    public WebDriver createDriver(Object[] args) {
        browser = setBrowser.config(Browser.RunBrowser.CHROME);
        if (args.length > 0) {
            if (args[0] != null && args[0] instanceof TestDevice) {
                TestDevice device = (TestDevice)args[0];
                if (device.getScreenSize() != null) {
                    browser.manage().window().setSize(device.getScreenSize());
                }
            }
        }
        return browser;
    }

    public void load(String uri) {
        getDriver().get(ENV_URL + uri);
    }

    @DataProvider(name = "devices")
    public Object [][] devices () {
        return new Object[][] {
                {new TestDevice("mobile", new Dimension(450, 800), asList("mobile"))},
                {new TestDevice("tablet", new Dimension(750, 800), asList("tablet"))},
                {new TestDevice("desktop", new Dimension(1024, 800), asList("desktop"))}
        };
    }

    public static class TestDevice {
        private final String name;
        private final Dimension screenSize;
        private final List<String> tags;

        public TestDevice(String name, Dimension screenSize, List<String> tags) {
            this.name = name;
            this.screenSize = screenSize;
            this.tags = tags;
        }

        public String getName() {
            return name;
        }

        public Dimension getScreenSize() {
            return screenSize;
        }

        public List<String> getTags() {
            return tags;
        }

        @Override
        public String toString() {
            return String.format("%s %dx%d", name, screenSize.width, screenSize.height);
        }
    }
}
