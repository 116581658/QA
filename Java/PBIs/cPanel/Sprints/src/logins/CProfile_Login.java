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

public class CProfile_Login {


    public static String[] logInToCProf_Quest() {

        String link_cProfileTRUNK = "https://srv-bsf-devcprtrunk.gw-4u.com/";
        String link_cProfileTAG   = "https://srv-bsf-devcprtag.gw-4u.com/";
        String link               = "";

        String answer = DialogMessageWithDropDown.showMessageWindow("CProfile", "Choose where to login: ", new String[]{"TRUNK", "TAG", "TRUNK_INT", "TAG_INT"});

        if (answer.equals("TRUNK") || answer.equals("TRUNK_INT")) {
            link = link_cProfileTRUNK;

        } else if (answer.equals("TAG") || answer.equals("TAG_INT")) {
            link = link_cProfileTAG;

        } else {

        }
        return new String[]{answer, link};

    }


    public static void logInToCProf_Page(WebDriver browser, long waitingTime, String loginLink, String userName, String userPass, String targetStage) {

        String inputUsername     = "//*[@id='username']";
        String inputPassword     = "//*[@id='password']";
        String targetEnvironment = "";

        if (targetStage.toUpperCase().equals("TRUNK")) {
            targetStage = "Trunk";                 // "Trunk", "Next Tag"
            targetEnvironment = "Production"; // "Production", "Sandbox"
        } else if (targetStage.toUpperCase().equals("TRUNK_INT")) {
            targetStage = "Trunk";
            targetEnvironment = "Sandbox";
        } else if (targetStage.toUpperCase().equals("TAG")) {
            targetStage = "Next Tag";
            targetEnvironment = "Production";
        } else if (targetStage.toUpperCase().equals("TAG_INT")) {
            targetStage = "Next Tag";
            targetEnvironment = "Sandbox";
        }

        String pathLogIn = "//button[text()[normalize-space(.)='Login']]";

        String targetStageXPath      = "//*[@id='s2id_target_stage']/a";
        String targetStageXPathClick = "//*[@id='s2id_autogen1_search']";

        String targetEnvironmentXPath      = "//*[@id='s2id_target_variation']/a";
        String targetEnvironmentXPathClick = "//*[@id='s2id_autogen2_search']";

        String loginLogOutMenu = "//h1[text()[normalize-space(.)='Dashboard']]"; // CProfile element from the next page

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


        long          waitingTimeSec = 2L;
        WebDriverWait wait           = new WebDriverWait(browser, waitingTimeSec);

// =================Entering the Users' name and password on the page:
        WebElement userNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputUsername)));
        userNameField.sendKeys(userName);

        WebElement userPassField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputPassword)));
        userPassField.sendKeys(userPass);

// =================Selecting Stage:
        browser.findElement(By.xpath(targetStageXPath)).click();
        browser.findElement(By.xpath(targetStageXPathClick)).sendKeys(targetStage + Keys.ENTER);

// =================Selecting Environment:
        browser.findElement(By.xpath(targetEnvironmentXPath)).click();
        browser.findElement(By.xpath(targetEnvironmentXPathClick)).sendKeys(targetEnvironment + Keys.ENTER);


// =================Pressing the Login button:
        browser.findElement(By.xpath(pathLogIn)).click();

// =================Waiting until we enter the CProfile page:
        WebElement myDynamicElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginLogOutMenu)));

    }

    public static void logInToCProf_Page(WebDriver browser, long waitingTime, String userName, String userPass) {

        String[] result      = logInToCProf_Quest();
        String   targetStage = result[0];
        String   loginLink   = result[1];

        String inputUsername     = "//*[@id='username']";
        String inputPassword     = "//*[@id='password']";
        String targetEnvironment = "";

        if (targetStage.equals("TRUNK")) {
            targetStage = "Trunk";                 // "Trunk", "Next Tag"
            targetEnvironment = "Production"; // "Production", "Sandbox"
        } else if (targetStage.equals("TRUNK_INT")) {
            targetStage = "Trunk";
            targetEnvironment = "Sandbox";
        } else if (targetStage.equals("TAG")) {
            targetStage = "Next Tag";
            targetEnvironment = "Production";
        } else if (targetStage.equals("TAG_INT")) {
            targetStage = "Next Tag";
            targetEnvironment = "Sandbox";
        }

        String pathLogIn = "//button[text()[normalize-space(.)='Login']]";

        String targetStageXPath      = "//*[@id='s2id_target_stage']/a";
        String targetStageXPathClick = "//*[@id='s2id_autogen1_search']";

        String targetEnvironmentXPath      = "//*[@id='s2id_target_variation']/a";
        String targetEnvironmentXPathClick = "//*[@id='s2id_autogen2_search']";

        String loginLogOutMenu = "//h1[text()[normalize-space(.)='Dashboard']]"; // CProfile element from the next page

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


        long          waitingTimeSec = 2L;
        WebDriverWait wait           = new WebDriverWait(browser, waitingTimeSec);

// =================Entering the Users' name and password on the page:
        WebElement userNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputUsername)));
        userNameField.sendKeys(userName);

        WebElement userPassField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputPassword)));
        userPassField.sendKeys(userPass);

// =================Selecting Stage:
        browser.findElement(By.xpath(targetStageXPath)).click();
        browser.findElement(By.xpath(targetStageXPathClick)).sendKeys(targetStage + Keys.ENTER);

// =================Selecting Environment:
        browser.findElement(By.xpath(targetEnvironmentXPath)).click();
        browser.findElement(By.xpath(targetEnvironmentXPathClick)).sendKeys(targetEnvironment + Keys.ENTER);


// =================Pressing the Login button:
        browser.findElement(By.xpath(pathLogIn)).click();

// =================Waiting until we enter the CProfile page:
        WebElement myDynamicElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginLogOutMenu)));

    }


}
