package logins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CPanel_Loading_Spinner {

    public static void waitLoadingSpinnerDisappear(WebDriver browser, long waitingTimeSeconds) {
        String loader = "//div[@id='blockList']//div[text()[normalize-space(.)='loading']]";

        int milliseconds = (int) waitingTimeSeconds / 1000;

        WebDriverWait wait = new WebDriverWait(browser, milliseconds);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(loader)));
    }
}
