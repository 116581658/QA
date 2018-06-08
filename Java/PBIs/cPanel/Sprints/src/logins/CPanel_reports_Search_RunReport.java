package logins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CPanel_reports_Search_RunReport {


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
    //@TODO : Fill in the report names in the ENUMs, overload the methods to take everyone one of the ENUMs


    public static void runReportButton(WebDriver browser, long waitingTime, Integer report, String buttonName) {
//        String button1Name_page01      = "Run report";
//        String buttonName      = "Run report";
//        String runReportButton = "//ul[@id='reportAccordion']//div/div[" + report + "]//*[text()[normalize-space(.)='" + buttonName + "']]";


// //ul[@id='reportAccordion']//div[@id='blockSearch']//div[contains(@class,'al_right')]  -- Balance Report
        String runReportButton = "//ul[@id='reportAccordion']//div/div[" + report + "]//*[text()[normalize-space(.)='" + buttonName + "']]";

        WebDriverWait wait      = new WebDriverWait(browser, waitingTime);
        WebElement    runReport = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(runReportButton)));  // wait
        runReport.click();


        System.out.println(buttonName + " button pressed ----- Method: runReportButton");
        // //*[.='Run' and (contains(@title,'Run report'))] - the RUN on the second page
    }


}
