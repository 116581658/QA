package logins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static misc.Waits.clickWhenReady;
import static misc.Waits.findElement;


public class Express_CPanel_Wizard {


    public static void pressWizard(WebDriver driver, long waitingTime) throws InterruptedException {

        String closeWatchLater = "//*[@id='close_welcome_screen']";
        String wizard          = "//*[@id='automation_toolbar']//a[@class='show_wizard_menu']";
        String buttonOK        = "//*[(@id='popup-error') and contains(@style,'display: block')]//button[text()[normalize-space(.)='OK'] ]";

        WebDriverWait wait = new WebDriverWait(driver, waitingTime); // waitingTimes[5] * 6
        /**/
        WebElement buttOK;
        try {

            if (driver.findElement(By.xpath(buttonOK)).isDisplayed()) {

                buttOK = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonOK)));
                buttOK.click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(buttonOK)));
            }

        } catch (Throwable ex) {
            System.out.println("Popup with \"OK\" button was not displayed!");
        }


        WebElement watchLater;
        try {

            if (driver.findElement(By.xpath(closeWatchLater)).isDisplayed()) {

                watchLater = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(closeWatchLater)));
                watchLater.click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(closeWatchLater)));
            }

        } catch (Throwable ex) {
            System.out.println("\"Watch later\" was not displayed!");
        }

        Thread.sleep(2000L);

        WebElement wizardButton;
        try {

            if (driver.findElement(By.xpath(wizard)).isDisplayed()) {

                wizardButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(wizard)));
                wizardButton.click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(wizard)));
            }

        } catch (Throwable ex) {
            System.out.println("\"Wizard\" button is active!");
        }


        try {
            //Find element with FluentWait and Clicks on "OK" button
            WebElement lastButtonOK = findElement(driver, By.xpath(buttonOK), 5);
            lastButtonOK.click();
        } catch (Throwable ex) {
            System.out.println("Popup with \"OK\" button was not displayed!");
        }

    }

    public static void pressActivateAccount(WebDriver driver, long waitingTime) throws InterruptedException {

        String closeWatchLater           = "//*[@id='close_welcome_screen']";
        String activateAccount           = "//*[@id='applicationFormShow']/div[text()[normalize-space(.)='Activate account']]";
        String closeApplicationFormFromX = "//*[@id='main_content']/div[@class='arrow_appForm']/div[text()='X']";
        String buttonOK                  = "//*[(@id='popup-error') and contains(@style,'display: block')]//button[text()[normalize-space(.)='OK'] ]";

        WebDriverWait wait = new WebDriverWait(driver, waitingTime); // waitingTimes[5] * 6
        /**/
        WebElement buttOK;
        try {

            if (driver.findElement(By.xpath(buttonOK)).isDisplayed()) {

                buttOK = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonOK)));
                buttOK.click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(buttonOK)));
            }

        } catch (Throwable ex) {
            System.out.println("Popup with \"OK\" button was not displayed!");
        }


        WebElement watchLater;
        try {

            if (driver.findElement(By.xpath(closeWatchLater)).isDisplayed()) {

                watchLater = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(closeWatchLater)));
                watchLater.click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(closeWatchLater)));
            }

        } catch (Throwable ex) {
            System.out.println("\"Watch later\" was not displayed!");
        }

        Thread.sleep(2000L);

        WebElement activateAccountButton;
        try {

            if (driver.findElement(By.xpath(activateAccount)).isDisplayed()) {

                activateAccountButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(activateAccount)));
                activateAccountButton.click();

                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(closeApplicationFormFromX)));
            }

        } catch (Throwable ex) {
            System.out.println("\"Activate account\" button was not displayed!");
        }


        try {
            //Find element with FluentWait and Clicks on "OK" button
            WebElement lastButtonOK = findElement(driver, By.xpath(buttonOK), 5);
            lastButtonOK.click();
        } catch (Throwable ex) {
            System.out.println("Popup with \"OK\" button was not displayed!");
        }

    }

    public static void pressDesktopButton(WebDriver driver, long waitingTime, String buttonName) {
        String desktopPreviewButton = "//*[text()[normalize-space(.)='Customise your Checkout page']]/../ul/li[@class='desktop']//a[text()[normalize-space(.)='" + buttonName + "']]";

        WebDriverWait wait = new WebDriverWait(driver, waitingTime); // waitingTimes[5] * 6

        WebElement elementDesktop;
        try {
            elementDesktop = driver.findElement(By.xpath(desktopPreviewButton));
//            highlightElementBorder(driver,elementDesktop,"red");
            elementDesktop.click();
            System.out.println("Desktop \"" + buttonName + "\" button was pressed!");
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(desktopPreviewButton)));
        } catch (Throwable ex) {
            System.out.println("Desktop \"" + buttonName + "\" button was not found!");
        }


    }


    public static void pressMobileButton(WebDriver driver, long waitingTime, String buttonName) {
        String desktopPreviewButton = "//*[text()[normalize-space(.)='Customise your Checkout page']]/../ul/li[@class='mobile']//a[text()[normalize-space(.)='" + buttonName + "']]";

        WebDriverWait wait = new WebDriverWait(driver, waitingTime); // waitingTimes[5] * 6

        WebElement elementDesktop;
        try {
            elementDesktop = driver.findElement(By.xpath(desktopPreviewButton));
//            highlightElementBorder(driver,elementDesktop,"red");
            elementDesktop.click();
            System.out.println("Mobile \"" + buttonName + "\" button was pressed!");
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(desktopPreviewButton)));
        } catch (Throwable ex) {
            System.out.println("Mobile \"" + buttonName + "\" button was not found!");
        }


    }

    public static void welcomePopupPressXButton(WebDriver driver, long waitingTime) {
        String closeWelcomePopupFromX = "//*[@id='welcome_screen_automation']/div/child::div[text()[normalize-space(.)='X']]";

        String dashboardPage = "//*[@id='my_profile_main_menu']/a/i[contains(@class,'iconf-myprofile')]";

        WebDriverWait wait = new WebDriverWait(driver, waitingTime); // waitingTimes[5] * 6

        WebElement elementX;
        try {
            elementX = clickWhenReady(driver, By.xpath(closeWelcomePopupFromX), 10);
            if (elementX.isDisplayed()) {
                elementX.click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(closeWelcomePopupFromX)));
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dashboardPage)));
            }

        } catch (Throwable ex) {
            System.out.println("\"X\" button was not displayed!");
        }

    }

    public static void pressContinueApplication(WebDriver driver, long waitingTime) {
        String continueApplication = "//*[@id='applicationFormShow']/div[text()[normalize-space(.)='Continue application']]";


        WebDriverWait wait = new WebDriverWait(driver, waitingTime); // waitingTimes[5] * 6

        WebElement elementX;
        try {
            elementX = clickWhenReady(driver, By.xpath(continueApplication), 10);

        } catch (Throwable ex) {
            System.out.println("\"Continue application\" button was not displayed!");
        }

    }

}
