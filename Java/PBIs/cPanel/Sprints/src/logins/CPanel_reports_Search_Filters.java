package logins;

import misc.HighlightElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CPanel_reports_Search_Filters {


    /**
     * This is the main method which makes use of addNum method.
     * @param driver The WebDriver name
     * @param waitingTime The waiting time for the elements to be found. Usually 6 secs. If more is needed possible there is an error
     * @param filterName The Drop-down filter name
     * @param filterChoice The name of the selected from the Drop-down element
     * @return Nothing Till now it is not configured to return any values
     */


    public static String setDropDownFilter(WebDriver driver, long waitingTime, String filterName, String filterChoice) {

        String colorViolet2nd = "#fae8ff";

        String fieldLabel    = "//div[contains(@id,'blockSearch')]//label[contains(normalize-space(.),'" + filterName + "')]/parent::div[contains(@class,'blockField')]";
        String fieldDropDown = fieldLabel + "//select[1]//parent::div/div/button";
        String fieldDropDownValue = fieldLabel + "//select[1]//parent::div/div/div//label[contains(normalize-space(.),'" + filterChoice + "')]";


        WebDriverWait wait = new WebDriverWait(driver, waitingTime);

        WebElement transacType = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(fieldDropDown)));
        HighlightElement.highlightElementBackground(driver,transacType,colorViolet2nd);
        transacType.click();

        WebElement transacTypeVerif = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(fieldDropDownValue)));
        HighlightElement.highlightElementBorder(driver,transacTypeVerif,"red");
        transacTypeVerif.click();

        System.out.printf("Filter name: '%s', Filter choice: '%s' \n", filterName, filterChoice);


        return "";


    }


    /**
     * This is the main method which makes use of addNum method.
     * @param driver The WebDriver name
     * @param waitingTime The waiting time for the elements to be found. Usually 6 secs. If more is needed possible there is an error
     * @param filterName The Input filter name
     * @param filterChoice The value to be inserted into this input field
     * @return Nothing Till now it is not configured to return any values
     */

    public static String setInputFilter(WebDriver driver, long waitingTime, String filterName, String filterChoice) {

        String colorViolet2nd = "#fae8ff";
        String colorViolet7th = "#e699ff";

        String fieldLabel    = "//div[contains(@id,'blockSearch')]//label[contains(normalize-space(.),'" + filterName + "')]/parent::div[contains(@class,'blockField')]";
        String fieldInput = fieldLabel + "/input";

        WebDriverWait wait = new WebDriverWait(driver, waitingTime);

        WebElement transacType = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(fieldInput)));
        HighlightElement.highlightElementBackground(driver,transacType,colorViolet2nd);
        transacType.sendKeys(filterChoice);

        System.out.printf("Filter name: '%s', Filter choice: '%s' \n", filterName, filterChoice);

        return "";


    }

}
