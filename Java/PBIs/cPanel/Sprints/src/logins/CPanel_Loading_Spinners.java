package logins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class CPanel_Loading_Spinners {

    static Properties prop = new Properties();

    //Create Object of FileInputStream Class. Pass file path.
    private FileInputStream objfile;


    public static void waitLoadingSpinnerDisappear(WebDriver browser, long waitingTimeSeconds) {
        String loader = "//div[@id='blockList']//div[text()[normalize-space(.)='loading']]";

        int milliseconds = (int) waitingTimeSeconds / 1000;

        WebDriverWait wait = new WebDriverWait(browser, milliseconds);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(loader)));
    }


    public static enum DashboardCharts {
        ON("ON"), OFF("OFF");

        DashboardCharts(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }

    public void waitDashboardLoadingSpinnerDisappear(WebDriver driver, long waitingTimeSeconds) throws IOException {
        objfile = new FileInputStream(System.getProperty("user.dir") + "/src/misc/objects.properties");

        prop.load(objfile);

        String spinner = prop.getProperty("spinner");
//        String loader = "//div[@id='blockList']//div[text()[normalize-space(.)='loading']]";
//        String dashboardSpinner = "//div[@class='preloadWrapper' and not(@id='preloadBase')]/div[@class='preloadInner']//*[local-name()='svg' and @class='spinner']";
        int milliseconds = (int) waitingTimeSeconds / 1000;

        WebDriverWait wait = new WebDriverWait(driver, milliseconds);

        WebElement elementSpinner = driver.findElement(By.xpath(spinner));
        WebElement someElem = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(spinner)));
        if (someElem.isDisplayed()) {
            wait.until(ExpectedConditions.visibilityOf(elementSpinner));
            System.out.println("Spinner has appeared");

        }

        List<WebElement> spinnerElements = driver.findElements(By.xpath(spinner));

        while (spinnerElements.size() > 0){

            spinnerElements = driver.findElements(By.xpath(spinner));

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Spinner has disappeared");

    }
}
