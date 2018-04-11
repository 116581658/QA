package logins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class CPanel_Search_menu {

    public static void searchMenu(WebDriver browser, long waitingTimeSec, String section, String subsection, String subsubsection) throws InterruptedException {


        String report    = section;
        String subMenu   = subsection;
        String finalMenu = subsubsection;

        String subReports_Menu = "";
        if (report.equals("Reports")) {
            subReports_Menu = "//*[@id='reports_menu']";

        } else if (report.equals("Acquiring Reports")) {
            subReports_Menu = " //*[@id='acquiring_reports_menu']";

        } else if (report.equals("My Account")) {
            subMenu = "";
            finalMenu = "";
        }


        String menuReports_by_text        = "//a[text()[normalize-space(.)='" + report + "']]";
        String dropDown_SubMenu_by_text   = subReports_Menu + "//a[text()[normalize-space(.)='" + subMenu + "']]";
        String dropDown_FinalMenu_by_text = subReports_Menu + "//a[text()[normalize-space(.)='" + finalMenu + "']]";
        String reportTable                = "//*[@id='reportAccordion']/li[1]";

        Actions builder = new Actions(browser);

        WebElement reportsHeader     = browser.findElement(By.xpath(menuReports_by_text));
        WebElement subMenu1_DropDown = browser.findElement(By.xpath(dropDown_SubMenu_by_text));
        WebElement subMenu_Final     = browser.findElement(By.xpath(dropDown_FinalMenu_by_text));

        Action mouseOverHome;

        if (subMenu.equals("")) {
            mouseOverHome = builder.click(reportsHeader).build();
            mouseOverHome.perform();

        } else {
            mouseOverHome = builder
                    .click(reportsHeader)
                    .click(subMenu1_DropDown)
                    .clickAndHold(subMenu_Final).release().build();
            mouseOverHome.perform();
            WebDriverWait wait = new WebDriverWait(browser, waitingTimeSec);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(reportTable)));

        }

    }
}
