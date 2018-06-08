package logins;

import misc.HighlightElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
        String        currencyDropDown            = "//*[@id='currency']";
        WebDriverWait wait                        = new WebDriverWait(driver, waitingTimeSec);

        WebElement dropDownCurrency = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(currencyDropDown)));

        HighlightElement.highlightElementBorder(driver, dropDownCurrency, "red");

//@TODO: Add check if the currency drop-down is Visible and Selectable: Assert or Verify is better
//See below: btnCustomize_assertCurrencyDropDown(....)

        Select currencyOption = new Select(driver.findElement(By.xpath(currencyDropDown)));
        currencyOption.selectByVisibleText(currencyName);

//@TODO: Add check if the Selected currency stays after Apply button has been pressed: Assert or Verify is better
//See below: btnCustomize_assertCurrencyChosen
        btnCustomize_assertCurrencyChosen(driver,waitingTimeSec,currencyName);


    }

    public static void btnCustomize_assertCurrencyDropDown(WebDriver driver, long waitingTimeSec) {
        String        currencyDropDown            = "//*[@id='currency']";
        boolean       currencyDropDownIsDisplayed ;
        WebDriverWait wait                        = new WebDriverWait(driver, waitingTimeSec);

        WebElement dropDownCurrency = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(currencyDropDown)));

        currencyDropDownIsDisplayed = dropDownCurrency.isDisplayed();
        if (currencyDropDownIsDisplayed) {
            System.out.println("Currency drop-down is present: OK");
        } else {
            System.out.println("Currency drop-down is not present: NOK");
        }



    }

    public static void btnCustomize_assertCurrencyChosen(WebDriver driver, long waitingTimeSec, String currencyName) {
        String        currencyDropDown            = "//*[@id='currency']";
        WebDriverWait wait                        = new WebDriverWait(driver, waitingTimeSec);

        WebElement dropDownCurrency = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(currencyDropDown)));

        Select currencyOption = new Select(driver.findElement(By.xpath(currencyDropDown)));
        String option = currencyOption.getFirstSelectedOption().getText();
        System.out.printf("Selected currency value: %s\n", option);
        Assert.assertEquals(option, currencyName);


    }



    public static void btnCustomize_clickApply(WebDriver driver, long waitingTimeSec) {

        String        popupApplyButton = "//*[@class='dashboard-customize-wrapper']//button[text()[normalize-space(.)='Apply']]";
        WebDriverWait wait             = new WebDriverWait(driver, waitingTimeSec);


        WebElement elementBTNApply = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(popupApplyButton)));
        elementBTNApply.click();
        System.out.println(getDateAndTime() + "--> Button 'Apply' was pressed. ");

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(popupApplyButton)));
        System.out.println(getDateAndTime() + "--> Button 'Apply' disappeared. ");

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

        APPROVALRATIO("Approval Ratio"),
        AVERAGETRANSACTIONVALUE("Average Transaction Value"),
        CHARGEBACKSAMOUNTRATIO("Chargebacks Amount Ratio"),
        DECLINEREASONSCODE("Decline Reasons Code"),
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

    public static void btnCustomize_MAINDASHBOARD_setField_ON_OFF(WebDriver browser, long waitingTimeSec, DashboardPopup_MAINDASHBOARD_getFieldName fieldName, DashboardPopup_setFieldState state) throws InterruptedException {
        String sectionName  = DashboardPopup_Section_getName.MAINDASHBOARD.getValue();
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

        Thread.sleep(400);
//========Element change status:
        WebElement elementLocationToggle = browser.findElement(By.xpath(toggleButton));
        String     locationText          = elementLocationToggle.getText();

        if (!locationText.equals(state.getValue())) {
            elementLocationToggle.click();
            locationText = elementLocationToggle.getText();
        }

        System.out.printf("%s's toggle has set to: %s\n", getFieldName, locationText);

        js.executeScript("window.scrollTo(0,0);");
        Thread.sleep(400);
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

        Thread.sleep(400);
//========Element change status:
        WebElement elementLocationToggle = browser.findElement(By.xpath(toggleButton));
        String     locationText          = elementLocationToggle.getText();

        if (!locationText.equals(state.getValue())) {
            elementLocationToggle.click();
            locationText = elementLocationToggle.getText();
        }

        System.out.printf("%s's toggle has set to: %s\n", getFieldName, locationText);

        js.executeScript("window.scrollTo(0,0);");
        Thread.sleep(400);
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

        Thread.sleep(400);
//========Element change status:
        WebElement elementLocationToggle = browser.findElement(By.xpath(toggleButton));
        String     locationText          = elementLocationToggle.getText();

        if (!locationText.equals(state.getValue())) {
            elementLocationToggle.click();
            locationText = elementLocationToggle.getText();
        }

        System.out.printf("%s's toggle has set to: %s\n", getFieldName, locationText);

        js.executeScript("window.scrollTo(0,0);");
        Thread.sleep(400);
    }


}
