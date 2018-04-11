package misc;

import okio.Timeout;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class HighlightElement {

    public static void highlightElement(WebDriver driver, WebElement element, Long milliSecs) throws InterruptedException {
        for (int i = 0; i <1; i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: yellow; border: 2px solid red;");
            if (milliSecs != null){
                Thread.sleep(milliSecs);
            }
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
        }
    }
}
