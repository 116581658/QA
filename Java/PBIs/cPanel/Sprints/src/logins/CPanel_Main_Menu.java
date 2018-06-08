package logins;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CPanel_Main_Menu {

    public static void searchMenu(WebDriver browser, long waitingTimeSec, String section, String subsection, String subsubsection) throws InterruptedException {
        Capabilities cap         = ((RemoteWebDriver) browser).getCapabilities();
        String       browserName = cap.getBrowserName().toLowerCase();
        System.out.println(browserName);
        String     report             = section;
        String     subMenu            = subsection;
        String     finalMenu          = subsubsection;
        String     finalMenuMainTitle = "Dashboard";     //@TODO: Assert the titles and Make working for the other menus
        String     pageTitlePath      = "//div[@id='main_content']/h1[@class='page_title']";
        WebElement pageTitle          = browser.findElement(By.xpath(pageTitlePath));

        String subReports_Menu = "";

        switch (report) {

            case "My Account":
                subMenu = "";
                finalMenu = "";
//            pageTitle =   //@TODO
                break;
            case "Reports":
                subReports_Menu = "//*[@id='reports_menu']";
                break;
            case "Acquiring Reports":
                subReports_Menu = " //*[@id='acquiring_reports_menu']";
                break;
            case "Marketing Tools":
                subReports_Menu = " //*[@id='marketing_tools_menu']";
                break;
            case "Products":
                subReports_Menu = " //*[@id='products_menu']";
                break;
            default:
                System.out.println("Not supported report :) ");

        }



/* Trying the Switch

        if (report.equals("My Account")) {
            subMenu = "";
            finalMenu = "";
//            pageTitle =   //@TODO
        } else if (report.equals("Reports")) {
            subReports_Menu = "//*[@id='reports_menu']";

        } else if (report.equals("Acquiring Reports")) {
            subReports_Menu = " //*[@id='acquiring_reports_menu']";

        } else if (report.equals("Marketing Tools")) {
            subReports_Menu = " //*[@id='marketing_tools_menu']";

        } else if (report.equals("Products")) {
            subReports_Menu = " //*[@id='marketing_tools_menu']";

        }

*/

        String menuReports_by_text        = "//a[text()[normalize-space(.)='" + report + "']]";
        String dropDown_SubMenu_by_text   = subReports_Menu + "//a[text()[normalize-space(.)='" + subMenu + "']]";
        String dropDown_FinalMenu_by_text = subReports_Menu + "//a[text()[normalize-space(.)='" + finalMenu + "']]";
        String reportTable                = "//*[@id='reportAccordion']/li[1]";

        Actions builder = new Actions(browser);

        WebElement reportsHeader     = browser.findElement(By.xpath(menuReports_by_text));
        WebElement subMenu1_DropDown ;
        WebElement subMenu_Final;

        Action mouseOverHome;

        if (subMenu.equals("")) {
            mouseOverHome = builder.click(reportsHeader).build();
            mouseOverHome.perform();

        } else if (finalMenu.equals("")) {
            subMenu1_DropDown = browser.findElement(By.xpath(dropDown_SubMenu_by_text));

            mouseOverHome = builder
                    .click(reportsHeader)
                    .click(subMenu1_DropDown).build();
            mouseOverHome.perform();

        } else {
            subMenu1_DropDown = browser.findElement(By.xpath(dropDown_SubMenu_by_text));
            subMenu_Final = browser.findElement(By.xpath(dropDown_FinalMenu_by_text));

            if (!browserName.equals("firefox")) {
                mouseOverHome = builder
                        .click(reportsHeader)
                        .click(subMenu1_DropDown)
                        .clickAndHold(subMenu_Final).release().build();
                mouseOverHome.perform();

            } else {
                /* Works!!! */
                builder.moveToElement(reportsHeader).build().perform();
                builder.moveToElement(subMenu1_DropDown).build().perform();
                subMenu_Final.click();


                //@TODO : Try without mouse move :)
                /* Doesn't Work!!!
                reportsHeader.click();
                Waits.findElement(browser,By.xpath(dropDown_SubMenu_by_text),5);
                subMenu1_DropDown.click();

                Waits.findElement(browser,By.xpath(dropDown_FinalMenu_by_text),5);
                subMenu_Final.click();
                */

            }


            WebDriverWait wait = new WebDriverWait(browser, 15);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(reportTable)));
        }

// @TODO        Assert.assertEquals(pageTitle.getText(), finalMenu);

    }
}
