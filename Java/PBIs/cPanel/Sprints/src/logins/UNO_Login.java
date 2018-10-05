package logins;

import customMessages.DialogMessageWithDropDown;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class UNO_Login {


//    public static String[] logInToCProf_Quest() {
//
//        String link_cProfileTRUNK = "https://srv-bsf-devcprtrunk.gw-4u.com/";
//        String link_cProfileTAG   = "https://srv-bsf-devcprtag.gw-4u.com/";
//        String link               = "";
//
//        String answer = DialogMessageWithDropDown.showMessageWindow("CProfile", "Choose where to login: ", new String[]{"TRUNK", "TAG", "TRUNK_INT", "TAG_INT"});
//
//        if (answer.equals("TRUNK") || answer.equals("TRUNK_INT")) {
//            link = link_cProfileTRUNK;
//
//        } else if (answer.equals("TAG") || answer.equals("TAG_INT")) {
//            link = link_cProfileTAG;
//
//        } else {
//
//        }
//        return new String[]{answer, link};
//
//    }


    public static void logInToThePage(WebDriver browser, String loginLink, long waitingTime, String userName, String userPass) {

        String pathUserName          = "//*[@id='email']";
        String pathUserPass          = "//*[@id='password']";
        String pathLogIn             = "//button[contains(@class,'btn-lg')]";
        String loginLogOutMenu       = "//header[contains(@class,'app-header')]"; // UNO element from the next page

// Loading the Page:
        browser.get(loginLink);
        try {
            browser.manage().timeouts().pageLoadTimeout(waitingTime, TimeUnit.MILLISECONDS);
        } catch (Throwable ex) {
            System.out.format("Page not loaded for %d milliseconds", waitingTime);
        }
        browser.manage().window().maximize();

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

// Entering the Users' name and password on the page:
        browser.findElement(By.xpath(pathUserName)).sendKeys(userName);
        browser.findElement(By.xpath(pathUserPass)).sendKeys(userPass);

// Pressing the Login button:
        browser.findElement(By.xpath(pathLogIn)).click();

// Waiting until we enter the CPanel page:
        WebDriverWait wait             = new WebDriverWait(browser, waitingTime);
        WebElement    myDynamicElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginLogOutMenu)));

    }
}

