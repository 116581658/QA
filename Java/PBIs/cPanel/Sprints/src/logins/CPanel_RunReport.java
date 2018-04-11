package logins;

import misc.MyCustomDate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CPanel_RunReport {

    public static void runReportButton(WebDriver browser, long waitingTime, Integer report) {
        String runReportButton = "//ul[@id='reportAccordion']//div/div["+report+"]//a[text()[normalize-space(.)='Run Report']]";

        WebDriverWait      wait      = new WebDriverWait(browser, waitingTime);
        WebElement runReport = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(runReportButton)));  // wait
        runReport.click();

    }

}
