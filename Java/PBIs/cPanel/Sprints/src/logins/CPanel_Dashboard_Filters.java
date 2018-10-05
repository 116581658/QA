package logins;

import misc.HighlightElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static misc.Verifications.verifyChosenDropDownValue;
import static misc.Waits.clickWhenReady;
import static org.muthu.Verify.verifyEquals;


public class CPanel_Dashboard_Filters {

    private final boolean DEBUG = false;

    private static String propertyFilePath = System.getProperty("user.dir") + "\\src\\misc\\objects.properties";

    Properties prop = new Properties();
    FileInputStream objfile;

    {
        try {
            objfile = new FileInputStream(propertyFilePath);
            prop.load(objfile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            System.out.println("Configuration properties file cannot be found");
        }
    }


    public enum Filters {
        Dashboard_Filters,
        Popup_Filters
    }

    public void click_ManageFilters(WebDriver driver) {
        clickWhenReady(driver, By.xpath(prop.getProperty("btn_ManageFilters")), 10);
    }

    public void manageFilters_click_CloseX(WebDriver driver) {
        clickWhenReady(driver, By.xpath(prop.getProperty("btn_CloseX")), 10);
    }

    public void manageFilters_click_Cancel(WebDriver driver) {
        clickWhenReady(driver, By.xpath(prop.getProperty("btn_Cancel")), 10);
    }

    public void manageFilters_click_Apply(WebDriver driver) {
        clickWhenReady(driver, By.xpath(prop.getProperty("btn_Apply")), 10);
    }

    public void selectValueFrom_FirstFilter(WebDriver driver, String firstFilterValue) {
        selectFilter(driver, 5, By.xpath(prop.getProperty("btn_ManageFilters_SelectFilter")), firstFilterValue);
    }

    public void manageFilters_click_PleaseSelectACountry(WebDriver driver) {
        clickWhenReady(driver, By.xpath(prop.getProperty("pleaseSelectACountry")), 10);
    }

    public void manageFilters_set_Country(WebDriver driver, String countryName) {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        String     country = prop.getProperty("allCountries") + "[contains(text(),'" + countryName + "')]";
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(country)));
        element.click();
        System.out.println("Country \"" + countryName + "\" was selected.");
    }


    public void setCountry(WebDriver driver, String countryName) {
        manageFilters_click_PleaseSelectACountry(driver);
        manageFilters_set_Country(driver, countryName);
    }


    public static void setDashboardFilters(WebDriver driver, long waitingTime, Filters items, String period, String[] countries, String[] paymentmethods, String acquirerBank, String currency, String[] clients) throws InterruptedException {

        String btnDatePeriod;
        String btnCountries;  // @TODO
        String btnPaymentMethods; // @TODO
        String optionFilterDate;
        String countryName;
        String optionCountry;
        String optionCountryBegin;
        String optionCountryEnd;
        String optionPM;
        String periodType             = "";
        String countryType            = "";
        String paymentMethodsType     = "";
        String acquirerBankType       = "";    // @TODO we have new filters - add them
        String processingCurrencyType = "";
        String clientNameType         = "";

        if (items.equals(Filters.Dashboard_Filters)) {
            periodType = "period";
            countryType = "country";
            paymentMethodsType = "paymentMethod";
            acquirerBankType = "acquirerBank";
            processingCurrencyType = "processingCurrency";
            clientNameType = "clientName";

        } else if (items.equals(Filters.Popup_Filters)) {
            periodType = "period_reports";
            countryType = "country_reports";
            paymentMethodsType = "paymentMethod_reports";
            acquirerBankType = "acquirerBank_reports";
            processingCurrencyType = "processingCurrency_reports";
            clientNameType = "clientName_reports";

        } else {
            System.out.println("Something else");
        }
/*  // TODO: Filters when popup appears
      //div[@class="customPopupInner"]//div[contains(@class,'dashboard_options')]//div[@class='dashboard_filters']//select[@name='period_reports']//parent::div

*/

        String colorViolet2nd = "#fae8ff";
        String colorViolet7th = "#e699ff";

        btnDatePeriod = "//div[@class='dashboard_filters']//select[@name='" + periodType + "']/parent::div//button";
        optionFilterDate = btnDatePeriod + "/../div[contains(@class,'ms-drop')]//li//*[text()[normalize-space(.)='" + period + "']]";

        btnCountries = "//div[@class='dashboard_filters']//select[@name='" + countryType + "']/parent::div//button";
        optionCountryBegin = btnCountries + "/../div[contains(@class,'ms-drop')]//li//*[contains(.,'";
        optionCountryEnd = "')]";

        btnPaymentMethods = "//div[@class='dashboard_filters']//select[@name='" + paymentMethodsType + "']/parent::div//button";
        optionPM = btnPaymentMethods + "/../div[contains(@class,'ms-drop')]//li//*[contains(.,'" + paymentmethods + "')]";

        WebDriverWait wait = new WebDriverWait(driver, waitingTime);

//TODO: add more ifs below this for the different cases: countries[] ,  paymentmethods[] are not null
        if (!period.equals("")) {

            WebElement filterToday = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnDatePeriod)));
            HighlightElement.highlightElementBackground(driver, filterToday, colorViolet2nd);
            filterToday.click();

            Thread.sleep(300);

            WebElement dropDValue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(optionFilterDate)));
            HighlightElement.highlightElementBackground(driver, dropDValue, colorViolet7th);
            dropDValue.click();

            Thread.sleep(300);

        }

        if (!countries.equals("")) {


            for (int i = 0; i < countries.length; i++) {

                countryName = countries[i];
                optionCountry = optionCountryBegin + countryName + optionCountryEnd;
                WebElement filterCountries = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnCountries)));
                HighlightElement.highlightElementBackground(driver, filterCountries, colorViolet2nd);
                filterCountries.click();


                WebElement dropDCountryValue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(optionCountry)));
                HighlightElement.highlightElementBackground(driver, dropDCountryValue, colorViolet7th);
                dropDCountryValue.click();

            }

        }


    }


    public static void verifyNativeValues(List<String> actualValues, List<String> expectedValues) {
        verifyEquals(actualValues, expectedValues);
    }


    /**
     * Get all <code><option/></code> innerHTML attributes
     */
//    public static List<String> getAllOptions(final WebDriver driver, By locator) {
    public static List<String> getAllOptions(WebDriver driver) {

        String periodsFilter = "//*[@id='main_content']//div[contains(@class,'dashboard-filters-select-periods')]/select";

        WebDriverWait    wait         = new WebDriverWait(driver, 10);
        WebElement       dropdown     = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(periodsFilter)));
        Select           select       = new Select(dropdown);
        List<WebElement> options      = select.getOptions();
        List<String>     optionValues = new ArrayList<>();

        System.out.println("=========== Actual =========== ");
        for (WebElement item : options) {
            optionValues.add(item.getText());
            System.out.println("Actual drop-down values are: " + item.getText());
        }

        return optionValues;
    }


    public static List<String> getAllOptions(final WebDriver driver, By locator) {

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement dropdown = driver.findElement(locator);
//
//
        Select           select       = new Select(dropdown);
        List<WebElement> options      = select.getOptions();
        List<String>     optionValues = new ArrayList<>();

        System.out.println("=========== Actual =========== ");
        for (WebElement item : options) {
            String obj = item.getText().trim();
            optionValues.add(obj);
            System.out.println("Actual drop-down values are: " + obj);
        }

        return optionValues;
    }


    public List<String> getAllElements(final WebDriver driver, By locator) {

        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        List<WebElement> elements = driver.findElements(locator);

        List<String> optionValues = new ArrayList<>();
        for (WebElement item : elements) {
            String obj = item.getText().trim();
            optionValues.add(obj);
            if (DEBUG) {
                System.out.println(obj);
            }
        }

        return optionValues;
    }

    public void selectFilter(WebDriver driver, long waitingTimeSec, By locator, String dropDownValue) {

        WebDriverWait wait     = new WebDriverWait(driver, 30);
        WebElement    dropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

//        String     currencyDropDown = "//*[@id='currency']";
        WebElement dropDown2 = driver.findElement(locator);

//        btnThemeEditor_verifyMerchantSiteDropDown(driver, dropDown, waitingTimeSec);

        HighlightElement.highlightElementBorder(driver, dropDown2, "red");

        Select dropDownOption = new Select(dropDown2);
        dropDownOption.selectByVisibleText(dropDownValue);

        verifyChosenDropDownValue(driver, waitingTimeSec, locator, dropDownValue);


    }


}
