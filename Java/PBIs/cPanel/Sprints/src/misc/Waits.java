package misc;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Waits {


    public static WebElement findElement(final WebDriver driver, final By locator, final int timeoutSeconds) {

        //FluentWait Decleration
        FluentWait<WebDriver> waitFluent = new FluentWait<WebDriver>(driver)
                .withTimeout(timeoutSeconds, TimeUnit.SECONDS) //Set timeout
                .pollingEvery(300, TimeUnit.MILLISECONDS) //Set query/check/control interval
                .withMessage("Timeout occured!") //Set timeout message
                .ignoring(NoSuchElementException.class); //Ignore NoSuchElementException

        //Wait until timeout period and when an element is found, then return it.
        return waitFluent.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(locator);
            }
        });

        //This is lambda expression of below code block. It is only for JAVA 8
        //return wait.until((WebDriver webDriver) -> driver.findElement(locator));
    }
}
