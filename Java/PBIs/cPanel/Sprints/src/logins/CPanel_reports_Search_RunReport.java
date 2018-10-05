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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CPanel_reports_Search_RunReport {
    static Properties prop = new Properties();
    private static FileInputStream objfile;

    public static enum SC_Reports_Operational_Simple {
        EMPTY("");

        SC_Reports_Operational_Simple(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }

    public static enum SC_Reports_Operational_Complex {
        TRANSACTIONSEARCH("Transaction Search");

        SC_Reports_Operational_Complex(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }

    public static enum SC_Reports_Financial_Simple {
        BALANCEREPORT("Balance Report"),
        STATISTICBASIC("Statistic Basic"),
        STATISTICACCOUNTING("Statistic Accounting"),
        BALANCECONFIRMATION("Balance Confirmation"),
        SETTLEMENTSUMMARYREPORT("Settlement Summary Report");

        SC_Reports_Financial_Simple(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }

    public static enum SC_Reports_Financial_Complex {
        FINANCEMOVEMENTS("Finance Movements");

        SC_Reports_Financial_Complex(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }

    public static enum SC_Reports_Risk_Complex {
        KYCREPORT("KYC report"),
        CHARGEBACKSREPORT("Chargebacks Report"),
        FRAUDTRANSACTIONSREPORT("Fraud transactions report");

        SC_Reports_Risk_Complex(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }

    }

    public static enum SC_Reports_Risk_Simple {
        EMPTY("");

        SC_Reports_Risk_Simple(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }

    }

    public static enum SC_Acquiring_Reports_Financial_Simple {
        BALANCEREPORT("Balance Report");

        SC_Acquiring_Reports_Financial_Simple(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }

    public static enum SC_Acquiring_Reports_Financial_Complex {
        ACQUIRINGSERVICEFEEANDINTERCHANGECOST("Acquiring Service Fee and interchange cost");

        SC_Acquiring_Reports_Financial_Complex(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }

    public static enum SC_Acquiring_Reports_Risk_Simple {
        EMPTY("");

        SC_Acquiring_Reports_Risk_Simple(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }

    public static enum SC_Acquiring_Reports_Risk_Complex {
        FRAUDTRANSACTIONSREPORT("Fraud transactions report");

        SC_Acquiring_Reports_Risk_Complex(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }

    public static enum SC_Withdrawals_Simple {
        EMPTY("");

        SC_Withdrawals_Simple(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }

    public static enum SC_Withdrawals_Complex {
        REQUESTSSEARCH("Requests search"),
        ORDERSSEARCH("Orders search");

        SC_Withdrawals_Complex(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }

    public static enum SC_User_Management_Simple {
        EMPTY("");

        SC_User_Management_Simple(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }

    public static enum SC_User_Management_Complex {
        USERPAYMENTMETHODS("User Payment Methods");

        SC_User_Management_Complex(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }


    public static enum G2S_Reports_Operational_Simple {
        EMPTY("");

        G2S_Reports_Operational_Simple(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }

    public static enum G2S_Reports_Operational_Complex {
        TRANSACTIONSEARCH("Transaction Search");

        G2S_Reports_Operational_Complex(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }

    public static enum G2S_Reports_Financial_Simple {
        BALANCEREPORT("Balance Report"),
        MOVEMENTSEARCH("Movement Search"),
        PAYOUTHISTORY("Payout History"),
        VENDORREPORT("Vendor Report");

        G2S_Reports_Financial_Simple(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }

    public static enum G2S_Reports_Financial_Complex {
        EMPTY("");

        G2S_Reports_Financial_Complex(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }

    public static enum G2S_Reports_Marketing_Simple {
        CONVERSIONRATES("Conversion Rates");

        G2S_Reports_Marketing_Simple(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }

    public static enum G2S_Reports_Marketing_Complex {
        EMPTY("");

        G2S_Reports_Marketing_Complex(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }


    public enum ReportLine {
        SINGLE("Single"),
        TOP("Top"),
        BOTTOM("Bottom");

        ReportLine(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }

    public enum ReportLineButtons {
        GRIDCOLUMNS("Grid Columns"),
        SEARCHMODE("Search Mode"),
        SUMMARYREPORT("Summary Report"),
        EXPORT("Export"),
        RESETSEARCH("Reset Search"),
        RESET("Reset"),
        RUN_Report("Run Report"),
        RUN_report("Run report"),
        SAVEQUERY("Save query"),
        LOADQUERY("Load query"),
        DELETESELECTEDQUERY("Delete selected query"),
        DELETEALLQUERIES("Delete all queries"),
        FIND("Find");

        ReportLineButtons(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }

    public enum ReportPage {
        PAGE1("1"),
        PAGE2("2");

        ReportPage(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }


    //@TODO : Fill in the report names in the ENUMs, overload the methods to take everyone one of the ENUMs


    public static void pressReportButton(WebDriver browser, long waitingTime, ReportPage reportPage, ReportLine menu, ReportLineButtons button) {
        //Create Object of FileInputStream Class. Pass file path.
        try {
            objfile = new FileInputStream(System.getProperty("user.dir") + "/src/misc/objects.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            prop.load(objfile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String  reportTitle      = prop.getProperty("reportsName");
        String  reportButton     = "";
        boolean complexSCReports = false;
        boolean simpleSCReports  = false;

        WebDriverWait wait              = new WebDriverWait(browser, waitingTime);
        WebElement    elementReportName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(reportTitle)));
        String        reportName        = elementReportName.getText();

        String[] arrayComplexSCReportNames = prop.getProperty("reports_SC_ComplexNames").split(",");
        for (int i = 0; i < arrayComplexSCReportNames.length; i++) {
            if (arrayComplexSCReportNames[i].equals(reportName)) {
                complexSCReports = true;
                break;
            }
        }

        String[] arraySimpleSCReportNames = prop.getProperty("reports_SC_SimpleNames").split(",");
        for (int i = 0; i < arraySimpleSCReportNames.length; i++) {
            if (arraySimpleSCReportNames[i].equals(reportName)) {
                simpleSCReports = true;
                break;
            }
        }


        String buttonName = button.getValue();

        if (complexSCReports) {

            if (reportPage.getValue().equals("1")) {

                switch (menu.getValue()) {
                    case "Top":
                        reportButton = prop.getProperty("reports_Complex_Page1_TopRow") + "//*[text()[normalize-space(.)='" + buttonName + "']]";
                        break;
                    case "Bottom":
                        reportButton = prop.getProperty("reports_Complex_Page1_BottomRow") + "//*[text()[normalize-space(.)='" + buttonName + "']]";
                        break;
                    default:
                        System.out.println("Unassigned value 1");
                        break;
                }

            } else if (reportPage.getValue().equals("2")) {

                switch (menu.getValue()) {
                    case "Single":
                        reportButton = prop.getProperty("reports_Complex_Page2_SingleRow") + "//*[text()[normalize-space(.)='" + buttonName + "']]";
                        break;
                    default:
                        System.out.println("Unassigned value 2");
                        break;
                }

            } else {
                System.out.println("Wrong Report page number");
            }


        } else if (simpleSCReports) {

            if (reportPage.getValue().equals("1")) {

                switch (menu.getValue()) {
                    case "Single":
                        reportButton = prop.getProperty("reports_Simple_Page1_SingleRow") + "//*[text()[normalize-space(.)='" + buttonName + "']]";
                        break;
                    default:
                        System.out.println("Unassigned value 1s");
                        break;
                }

            } else {
                System.out.println("Wrong Report page number");
            }


        } else {
            System.out.println("Something strange happened!");
        }

        WebElement pressButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(reportButton)));  // wait
        pressButton.click();


        System.out.println(buttonName + " button pressed ----- Method: pressReportButton");
        // //*[.='Run' and (contains(@title,'Run report'))] - the RUN on the second page
    }


    public static void searchMenu(WebDriver browser, long waitingTimeSec
            , ReportLineButtons button
            , String subButton) {

        //Create Object of FileInputStream Class. Pass file path.
        try {
            objfile = new FileInputStream(System.getProperty("user.dir") + "/src/misc/objects.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            prop.load(objfile);
        } catch (IOException e) {
            e.printStackTrace();
        }


        Capabilities cap         = ((RemoteWebDriver) browser).getCapabilities();
        String       browserName = cap.getBrowserName().toLowerCase();
        System.out.println(browserName);

        String buttonName = button.getValue();
        String subMenu    = subButton;

        String button_Menu        = "";
        String buttonName_SubMenu = "";
        String subButton_Menu     = "";

        switch (buttonName) {

            case "Grid Columns":
                button_Menu = "//ul[@id='reportAccordion']//div[@id='blockSearch']//div[contains(@class,'topMost')]//*[text()[normalize-space(.)='" + buttonName + "']]/following-sibling::ul";
                subButton_Menu = "//div[@title='" + buttonName_SubMenu + "']/input";
                break;
            case "Search Mode":
            case "Summary Report":
            case "Export":
                button_Menu = "//ul[@id='reportAccordion']//div[@id='blockSearch']//div[contains(@class,'topMost')]//*[text()[normalize-space(.)='" + buttonName + ":']]/following-sibling::ul";
                subButton_Menu = "//a[text()[normalize-space(.)='" + buttonName_SubMenu + "']]";
                break;
            case "Reset Search":
            case "Reset":
            case "Run Report":
            case "Run report":
                subMenu = "";
                break;
            case "Save query":
            case "Load query":
            case "Delete selected query":
            case "Delete all queries":
                button_Menu = "//ul[@id='reportAccordion']//div[@id='blockSearch']//div[contains(@class,'topMost')]/div[@title='Manage filters']/span[@title='" + buttonName + "']";
                subMenu = "";
                break;
            default:
                System.out.println("Not supported report :) ");

        }


        String menuButtons_by_text      = button_Menu;
        String dropDown_SubMenu_by_text = button_Menu + subButton_Menu;
        String reportTable              = "//*[@id='reportAccordion']/li[1]";
        String oldDashboardMainPage     = "//tr[@id='chart_tr_1']";

        Actions builder = new Actions(browser);

        WebElement reportsHeader;
        WebElement subMenu1_DropDown;

        Action mouseOverHome;

        if (subMenu.equals("")) {
            reportsHeader = browser.findElement(By.xpath(menuButtons_by_text));
            mouseOverHome = builder.click(reportsHeader).build();
            mouseOverHome.perform();

        } else {
            reportsHeader = browser.findElement(By.xpath(menuButtons_by_text));
            subMenu1_DropDown = browser.findElement(By.xpath(dropDown_SubMenu_by_text));

            if (!browserName.equals("firefox")) {
                mouseOverHome = builder
                        .click(reportsHeader)
                        .click(subMenu1_DropDown).release().build();
                mouseOverHome.perform();

            } else {
                /* Works!!! */
                builder.moveToElement(reportsHeader).build().perform();
                builder.moveToElement(subMenu1_DropDown).click();


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


// @TODO        Assert.assertEquals(pageTitle.getText(), finalMenu);

    }


    public String[] getButtonAndSubButtons(ReportLineButtons button, String subButton) {
        try {
            objfile = new FileInputStream(System.getProperty("user.dir") + "/src/misc/objects.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            prop.load(objfile);
        } catch (IOException e) {
            e.printStackTrace();
        }


        String buttonName     = button.getValue();
        String button_Path    = "";
        String subMenuButton  = subButton;
        String subButton_Path = "";

        switch (buttonName) {

            case "Grid Columns":
                button_Path = "//ul[@id='reportAccordion']//div[@id='blockSearch']//div[contains(@class,'topMost')]//*[text()[normalize-space(.)='" + buttonName + "']]/following-sibling::ul";
                subButton_Path = "//div[@title='" + subMenuButton + "']/input";
                break;
            case "Search Mode":
            case "Summary Report":
            case "Export":
                button_Path = "//ul[@id='reportAccordion']//div[@id='blockSearch']//div[contains(@class,'topMost')]//*[text()[normalize-space(.)='" + buttonName + ":']]/following-sibling::ul";
                subButton_Path = "//a[text()[normalize-space(.)='" + subMenuButton + "']]";
                break;
            case "Reset Search":
            case "Reset":
            case "Run Report":
            case "Run report":
                subMenuButton = "";
                break;
            case "Save query":
            case "Load query":
            case "Delete selected query":
            case "Delete all queries":
                button_Path = "//ul[@id='reportAccordion']//div[@id='blockSearch']//div[contains(@class,'topMost')]/div[@title='Manage filters']/span[@title='" + buttonName + "']";
                subMenuButton = "";
                break;
            default:
                System.out.println("Not supported report :) ");

        }

        return null;
    }


}




