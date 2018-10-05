package logins;

import misc.HighlightElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;


public class CPanel_Dashboard_Filters_Old {

    public enum Filters {
        Dashboard_Filters,
        Popup_Filters
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
}
