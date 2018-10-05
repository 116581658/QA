package logins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CPanel_Reports_ReportTables {

    public enum CPanel_GridColumns_TransactionInformation {

        TRANSACTIONID("Transaction ID"),
        TRANSACTIONDATE("Transaction Date"),
        DISPUTEDUEDATE("Dispute Due Date"),
        AFFILIATE("Affiliate"),
        LASTSTATUS("Last Status"),
        REASONDESCRIPTION("Reason Description"),
        TRANSACTIONAMOUNT("Transaction Amount"),
        WASPREVIOUSLYCREDITED("Was Previously Credited"),
        ARN("ARN"),
        CHARGEBACKDATE("Chargeback Date"),
        CLIENTNAME("Client Name"),
        TRANSACTIONTYPE("Transaction Type"),
        CHARGEBACKCATEGORY("Chargeback Category"),
        ACQUIRERBANK("Acquirer Bank"),
        CHARGEBACKAMOUNT("Chargeback Amount"),
        RECURRINGTYPE("Recurring Type"),
        CLIENTUNIQUEID("Client Unique ID"),
        UPDATEDATE("Update Date"),
        WEBSITE("Website"),
        CHARGEBACKTYPE("Chargeback Type"),
        CHARGEBACKREASONCODE("Chargeback Reason Code"),
        CURRENCY("Currency"),
        IS3D("Is 3D"),
        KYC_TRANSACTIONDATE("Transaction Date"),
        KYC_TRANSACTIONID("Transaction ID"),
        KYC_CLIENTNAME("Client name"),
        KYC_SITENAME("Site Name"),
        KYC_TRANSACTIONTYPE("Transaction Type"),
        KYC_TRANSACTIONSTATUS("Transaction Status"),
        KYC_KYCRESULT("KYC result"),
        KYC_MERCHANTSTATUS("Merchant status"),
        KYC_CLIENTUNIQUEID("Client Unique ID"),
        KYC_ISMODIFIED("Is Modified"),
        KYC_MODIFICATIONREASON("Modification Reason");

        CPanel_GridColumns_TransactionInformation(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }

    public enum CPanel_GridColumns_PaymentInformation {

        PAYMENTMETHOD("Payment Method"),
        NAMEONCARD("Name on Card"),
        CARDTYPE("Card Type"),
        CARDNUMBER("Card Number"),
        BIN("Bin"),
        ISSUINGCOUNTRY("Issuing Country");

        CPanel_GridColumns_PaymentInformation(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }

    public enum CPanel_GridColumns_ConsumerBillingInformation {  // Consumer information

        EMAILADDRESS("Email Address"),
        IPCOUNTRY("IP Country"),
        USERID("User ID"),
        PAYMENTACCOUNTIDENTIFIER("Payment account identifier"),
        ISSUERBANK("Issuer Bank"),
        BILLINGCOUNTRY("Billing Country"),
        KYC_EMAIL("Email"),
        KYC_USERID("User ID"),
        KYC_BILLINGCOUNTRY("Billing Country"),
        KYC_FIRSTNAME("First name"),
        KYC_LASTNAME("Last name");

        CPanel_GridColumns_ConsumerBillingInformation(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }

    public enum CPanel_GridColumns_Sorting {

        ASC("asc"),
        DESC("desc");

        CPanel_GridColumns_Sorting(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }

//@TODO - finish this things I forgot how :)
// <span class="sortIcon desc">&nbsp;</span>

    public static String setGridColumnsSortBy(WebDriver driver, long waitingTime, CPanel_GridColumns_TransactionInformation columnName, CPanel_GridColumns_Sorting sortAscOrDesc) {
        String colTransactionDate = "//*[@id='resultsTable']/thead//th[text()[normalize-space(.)='" + columnName.value + "']]";
        String sortedBy           = colTransactionDate + "/span[contains(@class,'" + sortAscOrDesc.value + "')]";

        WebDriverWait wait       = new WebDriverWait(driver, waitingTime);
        WebElement    colName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(colTransactionDate)));  // wait
        colName.click();

        CPanel_Loading_Spinners.waitLoadingSpinnerDisappear(driver, waitingTime * 25);

        List<WebElement> checkSort = driver.findElements(By.xpath(sortedBy));

        if (checkSort.size() == 0) {
            colName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(colTransactionDate)));  // wait
            colName.click();
            CPanel_Loading_Spinners.waitLoadingSpinnerDisappear(driver, waitingTime * 25);

        }
        return "";


    }

    public static String setGridColumnsSortBy(WebDriver driver, long waitingTime, CPanel_GridColumns_PaymentInformation columnName, CPanel_GridColumns_Sorting sortAscOrDesc) {
        String colTransactionDate = "//*[@id='resultsTable']/thead//th[text()[normalize-space(.)='" + columnName.value + "']]";
        String sortedBy           = colTransactionDate + "/span[contains(@class,'" + sortAscOrDesc.value + "')]";

        WebDriverWait wait       = new WebDriverWait(driver, waitingTime);
        WebElement    colName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(colTransactionDate)));  // wait
        colName.click();

        CPanel_Loading_Spinners.waitLoadingSpinnerDisappear(driver, waitingTime * 25);

        List<WebElement> checkSort = driver.findElements(By.xpath(sortedBy));

        if (checkSort.size() == 0) {
            colName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(colTransactionDate)));  // wait
            colName.click();
            CPanel_Loading_Spinners.waitLoadingSpinnerDisappear(driver, waitingTime * 25);

        }
        return "";


    }

    public static String setGridColumnsSortBy(WebDriver driver, long waitingTime, CPanel_GridColumns_ConsumerBillingInformation columnName, CPanel_GridColumns_Sorting sortAscOrDesc) {
        String colTransactionDate = "//*[@id='resultsTable']/thead//th[text()[normalize-space(.)='" + columnName.value + "']]";
        String sortedBy           = colTransactionDate + "/span[contains(@class,'" + sortAscOrDesc.value + "')]";

        WebDriverWait wait       = new WebDriverWait(driver, waitingTime);
        WebElement    colName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(colTransactionDate)));  // wait
        colName.click();

        CPanel_Loading_Spinners.waitLoadingSpinnerDisappear(driver, waitingTime * 25);

        List<WebElement> checkSort = driver.findElements(By.xpath(sortedBy));

        if (checkSort.size() == 0) {
            colName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(colTransactionDate)));  // wait
            colName.click();
            CPanel_Loading_Spinners.waitLoadingSpinnerDisappear(driver, waitingTime * 25);

        }
        return "";



    }

    public static String getGridColumnsSortedBy(WebDriver driver, long waitingTime, CPanel_GridColumns_TransactionInformation columnName) {
        String colTransactionDate = "//*[@id='resultsTable']/thead//th[text()[normalize-space(.)='" + columnName.value + "']]";
        String sortedBy           = colTransactionDate + "/span[contains(@class,'" + CPanel_GridColumns_Sorting.ASC.value + "') or contains(@class,'" + CPanel_GridColumns_Sorting.DESC.value + "') ]";



        WebDriverWait wait       = new WebDriverWait(driver, waitingTime);
        WebElement    colName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(colTransactionDate)));  // wait

        CPanel_Loading_Spinners.waitLoadingSpinnerDisappear(driver, waitingTime * 25);

        List<WebElement> checkSort = driver.findElements(By.xpath(sortedBy));

        String sortedWay = "default";
        for (WebElement sort : checkSort) {
            sortedWay = sort.getAttribute("class").split(" ")[1];
        }

        if (checkSort.size() == 0) {
//            columnName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(colTransactionDate)));  // wait
            System.out.printf("Column \"%s\" is sorted in it's Default order.", columnName.value, sortedWay);
//            CPanel_Loading_Spinners.waitLoadingSpinnerDisappear(driver, waitingTime * 25);

        } else if (sortedWay.equals(CPanel_GridColumns_Sorting.DESC.value)) {
            System.out.printf("Column \"%s\" is sorted in \"%s\" order.", columnName.value, CPanel_GridColumns_Sorting.DESC.value);
        } else {
            System.out.printf("Column \"%s\" is sorted in \"%s\" order.", columnName.value, CPanel_GridColumns_Sorting.ASC.value);
        }
        return "";


    }

    public static String getGridColumnsSortedBy(WebDriver driver, long waitingTime, CPanel_GridColumns_PaymentInformation columnName) {
        String colTransactionDate = "//*[@id='resultsTable']/thead//th[text()[normalize-space(.)='" + columnName.value + "']]";
        String sortedBy           = colTransactionDate + "/span[contains(@class,'" + CPanel_GridColumns_Sorting.ASC.value + "') or contains(@class,'" + CPanel_GridColumns_Sorting.DESC.value + "') ]";

        WebDriverWait wait       = new WebDriverWait(driver, waitingTime);
        WebElement    colName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(colTransactionDate)));  // wait
//        columnName.click();

        CPanel_Loading_Spinners.waitLoadingSpinnerDisappear(driver, waitingTime * 5);
        WebElement sortIcon  = driver.findElement(By.xpath(sortedBy));
        boolean    checkSort = sortIcon.isDisplayed();

        if (!checkSort) {
            System.out.printf("Column \"%s\" is sorted in it's Default order.", columnName.value);

//            columnName.click();
        }
        return "";


    }

    public static String getGridColumnsSortedBy(WebDriver driver, long waitingTime, CPanel_GridColumns_ConsumerBillingInformation columnName) {
        String colTransactionDate = "//*[@id='resultsTable']/thead//th[text()[normalize-space(.)='" + columnName.value + "']]";
        String sortedBy           = colTransactionDate + "/span[contains(@class,'" + CPanel_GridColumns_Sorting.ASC.value + "') or contains(@class,'" + CPanel_GridColumns_Sorting.DESC.value + "') ]";

        WebDriverWait wait       = new WebDriverWait(driver, waitingTime);
        WebElement    colName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(colTransactionDate)));  // wait
//        columnName.click();

        CPanel_Loading_Spinners.waitLoadingSpinnerDisappear(driver, waitingTime * 5);
        WebElement sortIcon  = driver.findElement(By.xpath(sortedBy));
        boolean    checkSort = sortIcon.isDisplayed();

        if (!checkSort) {
            System.out.printf("Column \"%s\" is sorted in it's Default order.", columnName.value);

//            columnName.click();
        }
        return "";


    }


    public static String getGridColumnsTooltips(WebDriver driver, long waitingTime, CPanel_GridColumns_TransactionInformation columnName) {
        String colTransactionDate = "//*[@id='resultsTable']/thead//th[text()[normalize-space(.)='" + columnName.value + "']]";
        CPanel_Loading_Spinners.waitLoadingSpinnerDisappear(driver, waitingTime * 25);

        List<WebElement> checkSort = driver.findElements(By.xpath(colTransactionDate));

        String tooltip = "";
        for (WebElement colName : checkSort) {
            tooltip = colName.getAttribute("title");
            System.out.println("Tooltip: " + tooltip);
        }

        return tooltip;

    }

    public static String getGridColumnsTooltips(WebDriver driver, long waitingTime, CPanel_GridColumns_PaymentInformation columnName) {
        String colTransactionDate = "//*[@id='resultsTable']/thead//th[text()[normalize-space(.)='" + columnName.value + "']]";
        CPanel_Loading_Spinners.waitLoadingSpinnerDisappear(driver, waitingTime * 25);

        List<WebElement> checkSort = driver.findElements(By.xpath(colTransactionDate));

        String tooltip = "";
        for (WebElement sort : checkSort) {
            tooltip = sort.getAttribute("title");
            System.out.println("Tooltip: " + tooltip);
        }

        return tooltip;

    }

    public static String getGridColumnsTooltips(WebDriver driver, long waitingTime, CPanel_GridColumns_ConsumerBillingInformation columnName) {
        String colTransactionDate = "//*[@id='resultsTable']/thead//th[text()[normalize-space(.)='" + columnName.value + "']]";
        CPanel_Loading_Spinners.waitLoadingSpinnerDisappear(driver, waitingTime * 25);

        List<WebElement> checkSort = driver.findElements(By.xpath(colTransactionDate));

        String tooltip = "";
        for (WebElement sort : checkSort) {
            tooltip = sort.getAttribute("title");
            System.out.println("Tooltip: " + tooltip);
        }

        return tooltip;


    }



}
