package logins;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static misc.Waits.*;

public class CPanel_Main_Menu {


    public enum CPanel_Menu_Names {

        DASHBOARD("Dashboard"),
        REPORTS("Reports"),
        ACQUIRINGREPORTS("Acquiring Reports"),
        MARKETINGTOOLS("Marketing Tools"),
        WITHDRAWALS("Withdrawals"),
        QRGENERATOR("QR Generator"),
        USERMANAGEMENT("User Management"),
        MYPROFILE("My profile"),
        NOTIFICATIONS("Notifications"),
        DOCUMENTS("Documents"),
        HELP("Help"),
        LANGUAGES("Languages");

        CPanel_Menu_Names(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }


    public static void searchMenu_Old(WebDriver browser, long waitingTimeSec, CPanel_Menu_Names section, String subsection, String subsubsection) {
        Capabilities cap         = ((RemoteWebDriver) browser).getCapabilities();
        String       browserName = cap.getBrowserName().toLowerCase();
        System.out.println(browserName);
        String     report             = section.getValue();
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
                subReports_Menu = "//*[@id='acquiring_reports_menu']";
                break;
            case "Marketing Tools":
                subReports_Menu = "//*[@id='marketing_tools_menu']";
                break;
            case "Withdrawals":
                subReports_Menu = "//*[@id='withdrawals_menu']";
                break;
            case "My profile":
                subReports_Menu = "//*[@id='my_profile_main_menu']";
                break;
            case "Notifications":
                subReports_Menu = "//*[@id='notifications_menu']";
                break;
            case "Documents":
                subReports_Menu = "//*[@id='documentation_menu']";
                break;
            case "Help":
                subReports_Menu = "//*[@id='tech_support_tools_menu']";
                break;
            case "Languages":
                subReports_Menu = "//*[@id='language_menu']";
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

        String menuReports_by_text        = "//*[text()[normalize-space(.)='" + report + "']]";
        String dropDown_SubMenu_by_text   = subReports_Menu + "//*[text()[normalize-space(.)='" + subMenu + "']]";
        String dropDown_FinalMenu_by_text = subReports_Menu + "//*[text()[normalize-space(.)='" + finalMenu + "']]";
        String reportTable                = "//*[@id='reportAccordion']/li[1]";
        String oldDashboardMainPage       = "//tr[@id='chart_tr_1']";

        Actions builder = new Actions(browser);

        WebElement reportsHeader;
        WebElement subMenu1_DropDown;
        WebElement subMenu_Final;

        Action mouseOverHome;
        if (!report.equals(CPanel_Menu_Names.MYPROFILE.getValue())
                && !report.equals(CPanel_Menu_Names.NOTIFICATIONS.getValue())
                && !report.equals(CPanel_Menu_Names.DOCUMENTS.getValue())
                && !report.equals(CPanel_Menu_Names.HELP.getValue())
                && !report.equals(CPanel_Menu_Names.LANGUAGES.getValue())) {
            if (subMenu.equals("")) {
                reportsHeader = browser.findElement(By.xpath(menuReports_by_text));
                mouseOverHome = builder.click(reportsHeader).build();
                mouseOverHome.perform();

            } else if (finalMenu.equals("")) {
                reportsHeader = browser.findElement(By.xpath(menuReports_by_text));
                subMenu1_DropDown = browser.findElement(By.xpath(dropDown_SubMenu_by_text));

                mouseOverHome = builder
                        .click(reportsHeader)
                        .click(subMenu1_DropDown).build();
                mouseOverHome.perform();

            } else {
                reportsHeader = browser.findElement(By.xpath(menuReports_by_text));
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
                Waits.findElement(config,By.xpath(dropDown_SubMenu_by_text),5);
                subMenu1_DropDown.click();

                Waits.findElement(config,By.xpath(dropDown_FinalMenu_by_text),5);
                subMenu_Final.click();
                */

                }


                WebDriverWait wait = new WebDriverWait(browser, 5);

                try {
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(reportTable)));
                } catch (Exception ex1) {
                    System.out.printf("Element from the next page is not found.\n\t %s \n", ex1.getMessage());
                }


                try {
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(oldDashboardMainPage)));
                } catch (Exception ex2) {
                    System.out.printf("Element from this Fpage page is still active.\n\t %s\n", ex2.getMessage());
                }


            }

        } else {
            if (subMenu.equals("")) {
                reportsHeader = browser.findElement(By.xpath(subReports_Menu));
                mouseOverHome = builder.click(reportsHeader).build();
                mouseOverHome.perform();

            } else if (finalMenu.equals("")) {
                reportsHeader = browser.findElement(By.xpath(subReports_Menu));
                subMenu1_DropDown = browser.findElement(By.xpath(dropDown_SubMenu_by_text));

                mouseOverHome = builder
                        .click(reportsHeader)
                        .click(subMenu1_DropDown).build();
                mouseOverHome.perform();

            } else {
                System.out.println("Undefined steps.");
            }

        }

// @TODO        Assert.assertEquals(pageTitle.getText(), finalMenu);

    }


    public static void searchMenu(WebDriver driver, long waitingTimeSec, CPanel_Menu_Names section, String subsection, String subsubsection) {
        Capabilities cap         = ((RemoteWebDriver) driver).getCapabilities();
        String       browserName = cap.getBrowserName().toLowerCase();
        System.out.println(browserName);
        String     report             = section.getValue();
        String     subMenu            = subsection;
        String     finalMenu          = subsubsection;
        String     finalMenuMainTitle = "Dashboard";     //@TODO: Assert the titles and Make working for the other menus
        String     pageTitlePath      = "//div[@id='main_content']/h1[@class='page_title']";
        WebElement pageTitle          = driver.findElement(By.xpath(pageTitlePath));

        String mainMenuTabs = "";

        switch (report) {

            case "Dashboard":
                mainMenuTabs = "//*[@id='home_menu']";
                subMenu = "";
                finalMenu = "";
                break;
            case "Reports":
                mainMenuTabs = "//*[@id='reports_menu']";
                break;
            case "Acquiring Reports":
                mainMenuTabs = "//*[@id='acquiring_reports_menu']";
                break;
            case "Marketing Tools":
                mainMenuTabs = "//*[@id='marketing_tools_menu']";
                break;
            case "Withdrawals":
                mainMenuTabs = "//*[@id='withdrawals_menu']";
                break;
            case "My profile":
                mainMenuTabs = "//*[@id='my_profile_main_menu']";
                break;
            case "Notifications":
                mainMenuTabs = "//*[@id='notifications_menu']";
                break;
            case "Documents":
                mainMenuTabs = "//*[@id='documentation_menu']";
                break;
            case "Help":
                mainMenuTabs = "//*[@id='tech_support_tools_menu']";
                break;
            case "Languages":
                mainMenuTabs = "//*[@id='language_menu']";
                break;
            default:
                System.out.println("Not supported report :) ");

        }


        String menuReports_by_text        = mainMenuTabs + "//*[text()[normalize-space(.)='" + report + "']]/..";
        String dropDown_SubMenu_by_text   = menuReports_by_text + "/following-sibling::ul//*[text()[normalize-space(.)='" + subMenu + "']]";
        String dropDown_FinalMenu_by_text = dropDown_SubMenu_by_text + "/following-sibling::ul//*[text()[normalize-space(.)='" + finalMenu + "']]";
        String reportTable                = "//*[@id='reportAccordion']/li[1]";
        String oldDashboardMainPage       = "//tr[@id='chart_tr_1']";

        Actions builder = new Actions(driver);

        WebElement reportsHeader;
        WebElement subMenu1_DropDown;
        WebElement subMenu_Final;

        Action mouseOverHome;
        if (!report.equals(CPanel_Menu_Names.MYPROFILE.getValue())
                && !report.equals(CPanel_Menu_Names.NOTIFICATIONS.getValue())
                && !report.equals(CPanel_Menu_Names.DOCUMENTS.getValue())
                && !report.equals(CPanel_Menu_Names.HELP.getValue())
                && !report.equals(CPanel_Menu_Names.LANGUAGES.getValue())) {
            if (subMenu.equals("")) {
                clickWhenReady(driver, By.xpath(menuReports_by_text),10);

            } else if (finalMenu.equals("")) {
                clickWhenReady(driver, By.xpath(menuReports_by_text),10);
                clickWhenReady(driver, By.xpath(dropDown_SubMenu_by_text),10);

            } else {
/*
                clickWhenReady(driver, By.xpath(menuReports_by_text),10);
                clickWhenReady(driver, By.xpath(dropDown_SubMenu_by_text),10);
                clickWhenReady(driver, By.xpath(dropDown_FinalMenu_by_text),10);

                reportsHeader = driver.findElement(By.xpath(menuReports_by_text));
                subMenu1_DropDown = driver.findElement(By.xpath(dropDown_SubMenu_by_text));
                subMenu_Final = driver.findElement(By.xpath(dropDown_FinalMenu_by_text));
 */



                if (browserName.equals("firefox")) {

                    reportsHeader = findElement(driver, By.xpath(menuReports_by_text), 10);
                    reportsHeader.click();
                    subMenu1_DropDown = findElement(driver, By.xpath(dropDown_SubMenu_by_text), 10);
                    subMenu1_DropDown.click();
                    subMenu_Final = findElement(driver, By.xpath(dropDown_FinalMenu_by_text), 10);
                    subMenu_Final.click();

                    //@TODO : Try without mouse move :)
                /* Doesn't Work!!!
                reportsHeader.click();
                Waits.findElement(config,By.xpath(dropDown_SubMenu_by_text),5);
                subMenu1_DropDown.click();

                Waits.findElement(config,By.xpath(dropDown_FinalMenu_by_text),5);
                subMenu_Final.click();
                */

                } else {
                    clickWhenReady(driver, By.xpath(menuReports_by_text), 10);
                    clickWhenReady(driver, By.xpath(dropDown_SubMenu_by_text), 10);
                    clickWhenReady(driver, By.xpath(dropDown_FinalMenu_by_text), 10);



                }


                WebDriverWait wait = new WebDriverWait(driver, 5);

                try {
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(reportTable)));
                } catch (Exception ex1) {
                    System.out.printf("Element from the next page is not found.\n\t %s \n", ex1.getMessage());
                }


                try {
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(oldDashboardMainPage)));
                } catch (Exception ex2) {
                    System.out.printf("Element from this Fpage page is still active.\n\t %s\n", ex2.getMessage());
                }


            }

        } else {
            if (subMenu.equals("")) {
                reportsHeader = driver.findElement(By.xpath(mainMenuTabs));
                mouseOverHome = builder.click(reportsHeader).build();
                mouseOverHome.perform();

            } else if (finalMenu.equals("")) {
                reportsHeader = driver.findElement(By.xpath(mainMenuTabs));
                subMenu1_DropDown = driver.findElement(By.xpath(dropDown_SubMenu_by_text));

                mouseOverHome = builder
                        .click(reportsHeader)
                        .click(subMenu1_DropDown).build();
                mouseOverHome.perform();

            } else {
                System.out.println("Undefined steps.");
            }

        }

// @TODO        Assert.assertEquals(pageTitle.getText(), finalMenu);

    }
}
