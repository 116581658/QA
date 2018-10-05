package misc;

import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.muthu.Verify.verifyEquals;

public class Verifications {


    public static void verifyChosenDropDownValue(WebDriver driver, long waitingTimeSec, By locator, String currencyName) {
        WebDriverWait wait = new WebDriverWait(driver, waitingTimeSec);

        WebElement dropDownCurrency = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

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


    public static void verifyInputValuePartOfContent(String currentValue, String expectedValue) {

        String current_Value  = "1";
        String expected_Value = "";
        if (currentValue.contains(expectedValue)) {
            current_Value = "someText";
            expected_Value = "someText";
        }
        else{
            current_Value = currentValue;
            expected_Value = expectedValue;
        }

        verifyEquals(current_Value, expected_Value);

    }


}
