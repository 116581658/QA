package logins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CPanel_Notifications_close {


    public static void closeNotifications(WebDriver browser, long waitingTime) throws InterruptedException {
        String        notifications       = "//div[@class='panel_info_header' and text()[normalize-space(.)='My notifications']]/ancestor::div[1][contains(@class,'active')]";
        String        notificationsHeader = notifications + "/div[1]";
        String        notificationsCloseX = notifications + "/a[contains(@class,'panel_info_close')]";
        WebDriverWait wait                = new WebDriverWait(browser, waitingTime);


        boolean headerTitle;
        try {
            headerTitle = browser.findElement(By.xpath(notificationsHeader)).isDisplayed();
        }catch (Throwable ex){
            headerTitle = false;
        }


        if (headerTitle == true) {
            WebElement headerTitleText = browser.findElement(By.xpath(notificationsHeader));
            System.out.println(headerTitleText.getText());
            WebElement closeXButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(notificationsCloseX)));
            closeXButton.click();
        }
        Thread.sleep(2000L);
    }
}
