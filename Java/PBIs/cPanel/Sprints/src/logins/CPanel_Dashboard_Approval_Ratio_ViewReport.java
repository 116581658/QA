package logins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static misc.DateCalculations.getDateAndTime;

public class CPanel_Dashboard_Approval_Ratio_ViewReport {

    public static void pressLNK_ViewReport(WebDriver browser, long waitingTimeSec) {

        String viewReport      = "//*[@id='chart-approval_ratio']/..//span[text()[normalize-space(.)='View Report']]";
        String viewReportPopup = "//*[@id='popupViewReportsContent']";

        WebDriverWait wait = new WebDriverWait(browser, waitingTimeSec);

        WebElement elementViewReport = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(viewReport)));
        elementViewReport.click();

        System.out.println(getDateAndTime() + "--> Link 'View Report' was pressed. ");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(viewReportPopup)));

    }


    public static void pressViewReport_Close(WebDriver browser, long waitingTimeSec) {

        String        popupWindow = "//div[contains(@class,'customPopup-opened')]//*[@class='customPopupInner']";
        String        btnClose    = popupWindow + "//button[contains(@class,'customPopupCloser')]";
        WebDriverWait wait        = new WebDriverWait(browser, waitingTimeSec);


        WebElement elementBTNApply = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnClose)));
        elementBTNApply.click();
        System.out.println(getDateAndTime() + "--> The 'X'('Close') was pressed. ");

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(btnClose)));
        System.out.println(getDateAndTime() + "--> The 'X'('Close') disappeared. ");

    }


}


