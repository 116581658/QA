package misc;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Waits {


    public static WebElement findElement(final WebDriver driver, final By locator, final int timeoutSeconds) {

        //FluentWait Declaration
        Wait<WebDriver> waitFluent = new FluentWait<WebDriver>(driver)
                .pollingEvery(Duration.ofMillis(300)) //Set query/check/control interval
                .withTimeout(Duration.ofSeconds(timeoutSeconds)) //Set timeout
                .withMessage("Timeout occured!") //Set timeout message
                .ignoring(NoSuchElementException.class); //Ignore NoSuchElementException

        //Wait until timeout period and when an element is found, then return it.
        return waitFluent.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(locator);
            }
        });

        //This is lambda expression of below code block. It is only for JAVA 8
        //return wait.until((WebDriver webDriver) -> driver.findElement(locator));
    }

    public static WebElement getWhenVisible(final WebDriver driver, By locator, int timeOutInSeconds) {
        WebElement    element = null;
        WebDriverWait wait    = new WebDriverWait(driver, timeOutInSeconds);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    public static WebElement getWhenReady(final WebDriver driver, By locator, int timeOutInSeconds) {
        WebElement    element1 = null;
        WebDriverWait wait    = new WebDriverWait(driver, timeOutInSeconds);
        element1 = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return element1;
    }

    public static WebElement clickWhenReady(final WebDriver driver, By locator, int timeOutInSeconds) {
        WebElement    element = null;
        WebDriverWait wait    = new WebDriverWait(driver, timeOutInSeconds);
        element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
        //wait until not clickable
//        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(locator)));
        return element;
    }


    public static boolean waitForPageLoad(WebDriver driver, int waitTimeInSec, ExpectedCondition<Boolean>... conditions) {
        boolean isLoaded = false;
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(waitTimeInSec)) //Set timeout
                .ignoring(StaleElementReferenceException.class)
                .pollingEvery(Duration.ofMillis(300));
        for (ExpectedCondition<Boolean> condition : conditions) {
            isLoaded = wait.until(condition);
            if (isLoaded == false) {
                //Stop checking on first condition returning false.
                break;
            }
        }
        return isLoaded;
    }

    public static final ExpectedCondition<Boolean> EXPECT_NO_DEPLOY = new ExpectedCondition<Boolean>() {
        String deployText = "Service is temporarily down. Please try again later.";
        String deploy = "//*[text()[normalize-space(.)="+deployText+"]]";

        @Override
        public Boolean apply(WebDriver driver) {
            Boolean loaded = true;
            try {
                List<WebElement> spinners = driver.findElements(By.xpath(deploy));
                for (WebElement spinner : spinners) {
                    if (spinner.isDisplayed()) {
                        loaded = false;
                        break;
                    }
                    else{

                    }
                }
            } catch (Exception ex) {
                // loaded = false;   //@TODO :  Should or not to be incommented??? Try it with Deploy running to load a page
            }
            return loaded;
        }
    };


    /**
     * Returns 'true' if there is no 'wait_dialog' element present on the page.
     */
    public static final ExpectedCondition<Boolean> EXPECT_NOT_WAITING = new ExpectedCondition<Boolean>() {
        @Override
        public Boolean apply(WebDriver driver) {
            Boolean loaded = true;
            try {
                WebElement wait = driver.findElement(By.id("F"));
                if (wait.isDisplayed()) {
                    loaded = false;
                }
            } catch (StaleElementReferenceException serex) {
                loaded = false;
            } catch (NoSuchElementException nseex) {
                loaded = true;
            } catch (Exception ex) {
                loaded = false;
                System.out.println("EXPECTED_NOT_WAITING: UNEXPECTED EXCEPTION: " + ex.getMessage());
            }
            return loaded;
        }
    };

}
