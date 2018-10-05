package logins;

import com.google.common.base.Verify;
import misc.HighlightElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static misc.DateCalculations.getDateAndTime;

public class CPanel_Dashboard_BTN_Export_in_CSV_PDF {

    public enum ExportTo {
        CSV("CSV"),
        PDF("PDF");

        ExportTo(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }

    public static void click_ExportTo(WebDriver driver, long waitingTime, ExportTo exportName) {
        String        reportName               = exportName.value;
        String        mainBTNExport            = "//*[@id='dashboard_main_actions']//a[contains(@class,'button-dashboard-export')]";
        String        dropDown_SubMenu_by_text = mainBTNExport + "/following-sibling::ul//a[text()[normalize-space(.)='" + reportName + "']]";
        WebDriverWait wait                     = new WebDriverWait(driver, waitingTime);
        WebElement    myDynamicElement         = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(mainBTNExport)));
//        WebElement    dynamicElementsAreLoaded = wait.until(ExpectedConditions.stalenessOf(By.xpath(mainBTNExport)));

        Actions builder = new Actions(driver);
        Action  mouseOverMainBTN;

        WebElement menuMainBTN      = driver.findElement(By.xpath(mainBTNExport));
        WebElement subMenu_DropDown = driver.findElement(By.xpath(dropDown_SubMenu_by_text));
//        HighlightElement.highlightElementBorder(driver, subMenu_DropDown, "red");

        mouseOverMainBTN = builder
                .click(menuMainBTN)
                .clickAndHold(subMenu_DropDown).release().build();
        mouseOverMainBTN.perform();

        System.out.println(getDateAndTime() + "--> Export to '" + reportName + "' was selected.");

    }

}
