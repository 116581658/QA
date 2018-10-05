package logins;

import com.google.common.base.Verify;
import misc.HighlightElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.sound.midi.Soundbank;

import java.util.ArrayList;
import java.util.List;

import static misc.DateCalculations.getDateAndTime;

public class CPanel_Dashboard_BTN_Customize {

    public static void click_BTNCustomize(WebDriver driver, long waitingTimeSec) {

        String        buttonCustomize = "//a[text()[normalize-space(.)='Customize']]";
        WebDriverWait wait            = new WebDriverWait(driver, waitingTimeSec);

        WebElement btnCustomize = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(buttonCustomize)));
        btnCustomize.click();
        System.out.println(getDateAndTime() + "--> Button 'Customize' was pressed. ");

    }

    public static void btnCustomize_setCurrency(WebDriver driver, long waitingTimeSec, String currencyName) {
        String     currencyDropDown = "//*[@id='currency']";
        WebElement dropDown         = driver.findElement(By.xpath(currencyDropDown));

        btnCustomize_verifyCurrencyDropDown(driver, dropDown, waitingTimeSec);

        HighlightElement.highlightElementBorder(driver, dropDown, "red");

        Select currencyOption = new Select(driver.findElement(By.xpath(currencyDropDown)));
        currencyOption.selectByVisibleText(currencyName);

        btnCustomize_verifyCurrencyChosen(driver, waitingTimeSec, currencyName);

    }

    public static void btnCustomize_verifyCurrencyDropDown(WebDriver driver, WebElement element, long waitingTimeSec) {
        boolean       currencyDropDownIsDisplayed;
        boolean       currencyDropDownIsEditable;
        WebDriverWait wait             = new WebDriverWait(driver, waitingTimeSec);
        WebElement    dropDownCurrency = wait.until(ExpectedConditions.visibilityOf(element));

        currencyDropDownIsDisplayed = dropDownCurrency.isDisplayed();
        if (currencyDropDownIsDisplayed) {
            System.out.println("Currency drop-down is Present: OK");
        } else {
            System.out.println("Currency drop-down is Not Present: NOK");
        }

        currencyDropDownIsEditable = dropDownCurrency.isEnabled();
        if (currencyDropDownIsEditable) {
            System.out.println("Currency drop-down is Enabled: OK");
        } else {
            System.out.println("Currency drop-down is Not Enabled: NOK");
        }


    }

    public static void btnCustomize_verifyCurrencyChosen(WebDriver driver,
                                                         long waitingTimeSec,
                                                         String currencyName) {
        String        currencyDropDown = "//*[@id='currency']";
        WebDriverWait wait             = new WebDriverWait(driver, waitingTimeSec);

        WebElement dropDownCurrency = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(currencyDropDown)));

//        Select currencyOption = new Select(driver.findElement(By.xpath(currencyDropDown)));
        Select currencyOption = new Select(dropDownCurrency);
        String option         = currencyOption.getFirstSelectedOption().getText();

        try {
            Verify.verify(true, "Expected: [" + currencyName + "] | Present: [" + option + "] don't match!: NOK ", option, currencyName);
            System.out.println("Expected: [" + currencyName + "] | Present: [" + option + "] match!: OK");
        } catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }


    }


   public static void btnCustomize_clickApply(WebDriver driver, long waitingTimeSec) {

        String popupApplyButton = "//*[@class='dashboard-customize-wrapper']//button[text()[normalize-space(.)='Apply']]";
//        String        buttonCustomize = "//a[text()[normalize-space(.)='Customize']]";
        String        confirmMessage = "//*[@id='main_content']/div[@class='flash_messages_wrapper']/div[text()[normalize-space(.)='Dashboard customized successfully.']]";
        WebDriverWait wait           = new WebDriverWait(driver, waitingTimeSec);


        WebElement elementBTNApply = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(popupApplyButton)));
        elementBTNApply.click();
        System.out.println(getDateAndTime() + "--> Button 'Apply' was pressed. ");


        WebElement btnCustomize = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(confirmMessage)));
        System.out.println(getDateAndTime() + "--> Button 'Customize' has appeared. ");

//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(popupApplyButton)));
//        System.out.println(getDateAndTime() + "--> Button 'Apply' disappeared. ");

    }


    public static void btnCustomize_clickCancel(WebDriver driver, long waitingTimeSec) {

        String        popupApplyButton = "//*[@class='dashboard-customize-wrapper']//button[text()[normalize-space(.)='Cancel']]";
        WebDriverWait wait             = new WebDriverWait(driver, waitingTimeSec);


        WebElement elementBTNCancel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(popupApplyButton)));
        elementBTNCancel.click();
        System.out.println(getDateAndTime() + "--> Button 'Cancel' was pressed. ");

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(popupApplyButton)));
        System.out.println(getDateAndTime() + "--> Button 'Cancel' disappeared. ");

    }

    public enum DashboardPopup_Section_getName {
        MAINDASHBOARD("Main Dashboard"),
        COMPARISONGRAPHS("Comparison Graphs"),
        OVERVIEWDASHBOARD("Overview Dashboard");

        private String value;

        DashboardPopup_Section_getName(String v) {
            this.value = v;
        }


        public String getValue() {
            return value;
        }
    }

    public enum DashboardPopup_MAINDASHBOARD_getFieldName {

        MONTHLYPROJECTIONS("Monthly Projections"),
        TODAYSALES("Today's Sales"),
        WEEKLYPROJECTIONS("Weekly Projections"),
        YESTERDAYAPPROVALRATIO("Yesterday's Approval Ratio"),
        YESTERDAYSALES("Yesterday's Sales"),
        YESTERDAYTRANSACTIONS("Yesterday's Transactions");

        DashboardPopup_MAINDASHBOARD_getFieldName(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }

    public enum DashboardPopup_COMPARISONGRAPHS_getFieldName {
        SALESCOMPARISON("Sales Comparison"),
        TRANSACTIONSCOMPARISON("Transactions Comparison");

        DashboardPopup_COMPARISONGRAPHS_getFieldName(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }

    public enum DashboardPopup_OVERVIEWDASHBOARD_getFieldName {

        ACQUIRERBANKSDISTRIBUTION("Acquirer Banks"),                           // Works in TRUNK
        //        ACQUIRERBANKSDISTRIBUTION("Acquirer Banks Distribution"),    // Works in TAG
        APPROVALRATIO("Approval Ratio"),
        AVERAGETRANSACTIONVALUE("Average Transaction Value"),
        CHARGEBACKSAMOUNTRATIO("Chargebacks Amount Ratio"),
        DECLINEREASONSCODE("Decline Reasons Code"),
        DEVICETYPE("Device Type"),                                   // Works in TRUNK only for now
        FRAUDFILTERSRATIO("Fraud Filters Ratio"),
        LOCATION("Location"),
        PAYMENTMETHODS("Payment Methods"),
        REFUNDRATIO("Refund Ratio"),
        SALES("Sales"),
        TRANSACTIONS("Transactions");

        DashboardPopup_OVERVIEWDASHBOARD_getFieldName(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }

    public static enum DashboardPopup_setFieldState {
        ON("ON"), OFF("OFF");

        DashboardPopup_setFieldState(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }

    public static void btnCustomize_MAINDASHBOARD_setFields_ON_OFF(WebDriver driver, long waitingTimeSec, DashboardPopup_setFieldState toggle) throws InterruptedException {
        String sectionName = DashboardPopup_Section_getName.MAINDASHBOARD.getValue();
        String getFieldName;

        DashboardPopup_MAINDASHBOARD_getFieldName[] getFieldNames = DashboardPopup_MAINDASHBOARD_getFieldName.values();

        for (DashboardPopup_MAINDASHBOARD_getFieldName values : getFieldNames) {

            getFieldName = values.getValue();
            String  sectionForm  = "//h2[text()[normalize-space(.)='" + sectionName + "']]/following-sibling::ul/../..";
            String  section      = "//h2[text()[normalize-space(.)='" + sectionName + "']]/following-sibling::ul";
            String  field        = section + "//span[text()[normalize-space(.)=\"" + getFieldName + "\"]]"; // Here DON'T Change the " to ' !!!
            String  toggleButton = field + "/parent::li//label[contains(@class,'checkbox-label')]";
            String  state        = toggle.getValue();
            boolean firsttime    = true;

            WebDriverWait wait         = new WebDriverWait(driver, waitingTimeSec);
            WebElement    sectionField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sectionForm)));

//========Scroll to the element:
            WebElement         elementField = driver.findElement(By.xpath(field));
            JavascriptExecutor js           = (JavascriptExecutor) driver;

            js.executeScript("arguments[0].scrollIntoView(true);", elementField);

            Thread.sleep(200);
//========Element change status:
            WebElement elementLocationToggle = driver.findElement(By.xpath(toggleButton));
            String     locationText          = elementLocationToggle.getText();

            if (!locationText.equals(state)) {
                elementLocationToggle.click();
                locationText = elementLocationToggle.getText();
            }

            System.out.printf("%s's toggle has set to: %s\n", getFieldName, locationText);

            js.executeScript("window.scrollTo(0,0);");
            Thread.sleep(200);
        }
    }

    public static void btnCustomize_COMPARISONGRAPHS_setFields_ON_OFF(WebDriver driver, long waitingTimeSec, DashboardPopup_setFieldState toggle) throws InterruptedException {
        String sectionName = DashboardPopup_Section_getName.COMPARISONGRAPHS.getValue();
        String getFieldName;

        DashboardPopup_COMPARISONGRAPHS_getFieldName[] getFieldNames = DashboardPopup_COMPARISONGRAPHS_getFieldName.values();

        for (DashboardPopup_COMPARISONGRAPHS_getFieldName values : getFieldNames) {

            getFieldName = values.getValue();
            String  sectionForm  = "//h2[text()[normalize-space(.)='" + sectionName + "']]/following-sibling::ul/../..";
            String  section      = "//h2[text()[normalize-space(.)='" + sectionName + "']]/following-sibling::ul";
            String  field        = section + "//span[text()[normalize-space(.)=\"" + getFieldName + "\"]]"; // Here DON'T Change the " to ' !!!
            String  toggleButton = field + "/parent::li//label[contains(@class,'checkbox-label')]";
            String  state        = toggle.getValue();
            boolean firsttime    = true;

            WebDriverWait wait         = new WebDriverWait(driver, waitingTimeSec);
            WebElement    sectionField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sectionForm)));

//========Scroll to the element:
            WebElement         elementField = driver.findElement(By.xpath(field));
            JavascriptExecutor js           = (JavascriptExecutor) driver;

            js.executeScript("arguments[0].scrollIntoView(true);", elementField);

            Thread.sleep(50);
//========Element change status:
            WebElement elementLocationToggle = driver.findElement(By.xpath(toggleButton));
            String     locationText          = elementLocationToggle.getText();

            if (!locationText.equals(state)) {
                elementLocationToggle.click();
                locationText = elementLocationToggle.getText();
            }

            System.out.printf("%s's toggle has set to: %s\n", getFieldName, locationText);

            js.executeScript("window.scrollTo(0,0);");
            Thread.sleep(50);
        }
    }

    public static void btnCustomize_OVERVIEWDASHBOARD_setFields_ON_OFF(WebDriver driver, long waitingTimeSec, DashboardPopup_setFieldState toggle) throws InterruptedException {
        String sectionName = DashboardPopup_Section_getName.MAINDASHBOARD.getValue();
        String getFieldName;

        DashboardPopup_OVERVIEWDASHBOARD_getFieldName[] getFieldNames = DashboardPopup_OVERVIEWDASHBOARD_getFieldName.values();

        for (DashboardPopup_OVERVIEWDASHBOARD_getFieldName values : getFieldNames) {

            getFieldName = values.getValue();
            String  sectionForm  = "//h2[text()[normalize-space(.)='" + sectionName + "']]/following-sibling::ul/../..";
            String  section      = "//h2[text()[normalize-space(.)='" + sectionName + "']]/following-sibling::ul";
            String  field        = section + "//span[text()[normalize-space(.)=\"" + getFieldName + "\"]]"; // Here DON'T Change the " to ' !!!
            String  toggleButton = field + "/parent::li//label[contains(@class,'checkbox-label')]";
            String  state        = toggle.getValue();
            boolean firsttime    = true;

            WebDriverWait wait         = new WebDriverWait(driver, waitingTimeSec);
            WebElement    sectionField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sectionForm)));

//========Scroll to the element:
            WebElement         elementField = driver.findElement(By.xpath(field));
            JavascriptExecutor js           = (JavascriptExecutor) driver;

            js.executeScript("arguments[0].scrollIntoView(true);", elementField);

            Thread.sleep(200);
//========Element change status:
            WebElement elementLocationToggle = driver.findElement(By.xpath(toggleButton));
            String     locationText          = elementLocationToggle.getText();

            if (!locationText.equals(state)) {
                elementLocationToggle.click();
                locationText = elementLocationToggle.getText();
            }

            System.out.printf("%s's toggle has set to: %s\n", getFieldName, locationText);

            js.executeScript("window.scrollTo(0,0);");
            Thread.sleep(200);
        }
    }

    private static boolean firstEntrance = true;

    public static void btnCustomize_MAINDASHBOARD_setField_ON_OFF(WebDriver driver, long waitingTimeSec, DashboardPopup_MAINDASHBOARD_getFieldName fieldName, DashboardPopup_setFieldState state) throws InterruptedException {

        if (firstEntrance) {
            btnCustomize_MAINDASHBOARD_setFields_ON_OFF(driver, waitingTimeSec, DashboardPopup_setFieldState.OFF);
            firstEntrance = false;
        }

        String sectionName  = DashboardPopup_Section_getName.MAINDASHBOARD.getValue();
        String getFieldName = fieldName.getValue();

        String sectionForm  = "//h2[text()[normalize-space(.)='" + sectionName + "']]/following-sibling::ul/../..";
        String section      = "//h2[text()[normalize-space(.)='" + sectionName + "']]/following-sibling::ul";
        String field        = section + "//span[text()[normalize-space(.)=\"" + fieldName.getValue() + "\"]]";
        String toggleButton = field + "/parent::li//label[contains(@class,'checkbox-label')]";


        WebDriverWait wait         = new WebDriverWait(driver, waitingTimeSec);
        WebElement    sectionField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sectionForm)));

//========Scroll to the element:
        WebElement         elementField = driver.findElement(By.xpath(field));
        JavascriptExecutor js           = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true);", elementField);

        Thread.sleep(200);
//========Element change status:
        WebElement elementLocationToggle = driver.findElement(By.xpath(toggleButton));
        String     locationText          = elementLocationToggle.getText();

        if (!locationText.equals(state.getValue())) {
            elementLocationToggle.click();
            locationText = elementLocationToggle.getText();
        }

        System.out.printf("%s's toggle has set to: %s\n", getFieldName, locationText);

        js.executeScript("window.scrollTo(0,0);");
        Thread.sleep(200);
    }

    public static void btnCustomize_COMPARISONGRAPHS_setField_ON_OFF(WebDriver browser, long waitingTimeSec, DashboardPopup_COMPARISONGRAPHS_getFieldName fieldName, DashboardPopup_setFieldState state) throws InterruptedException {
        String sectionName  = DashboardPopup_Section_getName.COMPARISONGRAPHS.getValue();
        String getFieldName = fieldName.getValue();

        String sectionForm  = "//h2[text()[normalize-space(.)='" + sectionName + "']]/following-sibling::ul/../..";
        String section      = "//h2[text()[normalize-space(.)='" + sectionName + "']]/following-sibling::ul";
        String field        = section + "//span[text()[normalize-space(.)=\"" + getFieldName + "\"]]";
        String toggleButton = field + "/parent::li//label[contains(@class,'checkbox-label')]";

        WebDriverWait wait         = new WebDriverWait(browser, waitingTimeSec);
        WebElement    sectionField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sectionForm)));

//========Scroll to the element:
        WebElement         elementField = browser.findElement(By.xpath(field));
        JavascriptExecutor js           = (JavascriptExecutor) browser;

        js.executeScript("arguments[0].scrollIntoView(true);", elementField);

        Thread.sleep(200);
//========Element change status:
        WebElement elementLocationToggle = browser.findElement(By.xpath(toggleButton));
        String     locationText          = elementLocationToggle.getText();

        if (!locationText.equals(state.getValue())) {
            elementLocationToggle.click();
            locationText = elementLocationToggle.getText();
        }

        System.out.printf("%s's toggle has set to: %s\n", getFieldName, locationText);

        js.executeScript("window.scrollTo(0,0);");
        Thread.sleep(200);
    }

    public static void btnCustomize_OVERVIEWDASHBOARD_setField_ON_OFF(WebDriver browser, long waitingTimeSec, DashboardPopup_OVERVIEWDASHBOARD_getFieldName fieldName, DashboardPopup_setFieldState state) throws InterruptedException {
        String sectionName  = DashboardPopup_Section_getName.OVERVIEWDASHBOARD.getValue();
        String getFieldName = fieldName.getValue();

        String sectionForm  = "//h2[text()[normalize-space(.)='" + sectionName + "']]/following-sibling::ul/../..";
        String section      = "//h2[text()[normalize-space(.)='" + sectionName + "']]/following-sibling::ul";
        String field        = section + "//span[text()[normalize-space(.)=\"" + fieldName.getValue() + "\"]]";
        String toggleButton = field + "/parent::li//label[contains(@class,'checkbox-label')]";

        WebDriverWait wait         = new WebDriverWait(browser, waitingTimeSec);
        WebElement    sectionField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sectionForm)));

//========Scroll to the element:
        WebElement         elementField = browser.findElement(By.xpath(field));
        JavascriptExecutor js           = (JavascriptExecutor) browser;

        js.executeScript("arguments[0].scrollIntoView(true);", elementField);

        Thread.sleep(200);
//========Element change status:
        WebElement elementLocationToggle = browser.findElement(By.xpath(toggleButton));
        String     locationText          = elementLocationToggle.getText();

        if (!locationText.equals(state.getValue())) {
            elementLocationToggle.click();
            locationText = elementLocationToggle.getText();
        }

        System.out.printf("%s's toggle has set to: %s\n", getFieldName, locationText);

        js.executeScript("window.scrollTo(0,0);");
        Thread.sleep(200);
    }


}
