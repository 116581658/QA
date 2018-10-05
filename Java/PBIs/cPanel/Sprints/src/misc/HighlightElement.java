package misc;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HighlightElement {

    public static void highlightElementAndDisappear(WebDriver driver, WebElement element, Long milliSecs) throws InterruptedException {
        for (int i = 0; i < 1; i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: yellow; border: 2px solid red;");
            if (milliSecs != null) {
                Thread.sleep(milliSecs);
            }
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
        }
    }

    public static void highlightElementBackground(WebDriver driver, WebElement element, String colorName) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "background-color: " + colorName + ";");

    }

    public static void highlightElementBorder(WebDriver driver, WebElement element, String colorName) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].style.border='2px solid red'", transacTypeVerif);
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "border: 2px solid " + colorName + ";");

    }

    public static void highlightElementBorderAndScroll(WebDriver driver, WebElement element, String colorName, Long milliSecs) throws InterruptedException {

        scrollToElement(driver, element, milliSecs);
        highlightElementBorder(driver, element, colorName);
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
////        js.executeScript("arguments[0].style.border='2px solid red'", transacTypeVerif);
//        js.executeScript("arguments[0].scrollIntoView(true);", element);
//        Thread.sleep(milliSecs);
//        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "border: 2px solid " + colorName + ";");

    }

    public static void highlightElementBorderAndScrollTo(WebDriver driver, By locator, String colorName, Long milliSecs, Integer verticalPixels, Up_or_Down verticalDirection, Integer horizontalPixels, Left_or_Right horizontalDirection) throws InterruptedException {
//        String blockUiXpath = "//*[@class='preloadWrapper' and not(@id) and ./*[@class='preloadInner']]";
//        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement elementPeriodFilters = driver.findElement(locator);

//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(blockUiXpath)));
//        System.out.println("Before Scroll to element");

        scrollToElement(driver, elementPeriodFilters, milliSecs, verticalPixels, verticalDirection, horizontalPixels, horizontalDirection);
        highlightElementBorder(driver, elementPeriodFilters, colorName);
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
////        js.executeScript("arguments[0].style.border='2px solid red'", transacTypeVerif);
//        js.executeScript("arguments[0].scrollIntoView(true);", element);
//        Thread.sleep(milliSecs);
//        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "border: 2px solid " + colorName + ";");

    }


    public static void scrollToElement(WebDriver driver, WebElement element, Long waitingTimeAfterScroll_milliSecs) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(waitingTimeAfterScroll_milliSecs);
    }


    public enum Up_or_Down {
        UP("UP"),
        DOWN("DOWN");
        private String value;

        Up_or_Down(String v) {
            value = v;
        }

        public String getValue() {
            return value;
        }
    }

    public enum Left_or_Right {
        LEFT("Left"),
        RIGHT("Right");
        private String value;

        Left_or_Right(String v) {
            value = v;
        }

        public String getValue() {
            return value;
        }
    }

    public static void scrollToElement(WebDriver driver, WebElement element, Long waitingTimeAfterScroll_milliSecs, Integer verticalPixels, Up_or_Down verticalDirection, Integer horizontalPixels, Left_or_Right horizontalDirection) throws InterruptedException {
        if (verticalPixels >= 0) {
            if (verticalDirection.getValue().toUpperCase().equals("DOWN")) {
                verticalPixels = verticalPixels * -1;
            }
        } else {
            throw new ArithmeticException("Vertical direction (\"verticalPixels\" value) is smaller than 0 ");
        }

        if (horizontalPixels >= 0) {
            if (horizontalDirection.getValue().toUpperCase().equals("LEFT")) {
                horizontalPixels = horizontalPixels * -1;
            }
        } else {
            throw new ArithmeticException("Horizontal direction (\"horizontalPixels\" value) is smaller than 0 ");
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("javascript:window.scrollBy(" + horizontalPixels + "," + verticalPixels + ")");
        Thread.sleep(waitingTimeAfterScroll_milliSecs);
    }


}
