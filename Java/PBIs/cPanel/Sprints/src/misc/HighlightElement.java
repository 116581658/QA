package misc;

import okio.Timeout;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

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


}
