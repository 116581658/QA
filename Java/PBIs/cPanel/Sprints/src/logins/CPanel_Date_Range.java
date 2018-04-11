package logins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CPanel_Date_Range {
    public static void dateRange(WebDriver browser, long waitingTime , String changeFromPeriod, String changeToPeriod ) {

        // Waiting time 1 sec;
        WebDriverWait wait = new WebDriverWait(browser, waitingTime);

        String dateRange = "//label[text()[normalize-space(.)='Date Range:']]/../div/button/span[text()[normalize-space(.)='"+changeFromPeriod+"']]";
        String dateRangeSearch = "//div[@class='ms-search']/input";
//        String period = "Custom period";
        String period = changeToPeriod;
        String clickSearchresult = "//label[text()[normalize-space(.)='" + period + "']]";

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dateRange)));
        browser.findElement(By.xpath(dateRange)).click();

        browser.findElement(By.xpath(dateRangeSearch)).sendKeys(period);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(clickSearchresult)));
        browser.findElement(By.xpath(clickSearchresult)).click();  // Maybe "WebElement transSearch =" in front is needed

    }



}
