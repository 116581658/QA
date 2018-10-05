package logins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CPanel_reports_Search_Date_Range {
    public static void dateRange(WebDriver browser, long waitingTime, String changeFromPeriod, String changeToPeriod) {

        // Waiting time 1 sec;
        WebDriverWait wait = new WebDriverWait(browser, waitingTime);

        String dateRange         = "//label[text()[normalize-space(.)='Date Range:']]/../div/button/span[text()[normalize-space(.)='" + changeFromPeriod + "']]";
        String dateRangeSearch   = "//div[@class='ms-search']/input";
        String clickSearchresult = "//label[text()[normalize-space(.)='" + changeToPeriod + "']]";

        WebElement dateRangeField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dateRange)));
        dateRangeField.click();

        WebElement dateRangeInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dateRangeSearch)));
        dateRangeInput.sendKeys(changeToPeriod);

//        config.findElement(By.xpath(dateRangeSearch)).sendKeys(changeToPeriod);

        WebElement dateRangeValue = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(clickSearchresult)));
        dateRangeValue.click();


    }


    public static void dateRangeValue(WebDriver browser, long waitingTime, String changeToPeriod) {

        // Waiting time 1 sec;
        WebDriverWait wait = new WebDriverWait(browser, waitingTime);

        String dateRange         = "//label[text()[normalize-space(.)='Date Range:']]/../div/button/span[text()[normalize-space(.)='Today']]";
        String dateRangeSearch   = "//div[@class='ms-search']/input";
        String clickSearchresult = "//label[text()[normalize-space(.)='" + changeToPeriod + "']]";

        WebElement dateRangeField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dateRange)));
        dateRangeField.click();

        WebElement dateRangeInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dateRangeSearch)));
        dateRangeInput.sendKeys(changeToPeriod);

//        config.findElement(By.xpath(dateRangeSearch)).sendKeys(changeToPeriod);

        WebElement dateRangeValue = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(clickSearchresult)));
        dateRangeValue.click();


    }

}
