package classes;

import misc.DialogMessageWithDropDown;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static misc.Waits.EXPECT_NO_DEPLOY;
import static misc.Waits.findElement;
import static misc.Waits.waitForPageLoad;

public class CPanel_Login {

    Properties prop = new Properties();

    public String[] logInToCPan_Quest() {
        FileInputStream objfile = null;

        try {
            objfile = new FileInputStream(System.getProperty("user.dir") + "java/misc/objects.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            prop.load(objfile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String link_cPanelTRUNK    = prop.getProperty("cPanel_TRUNK");
        String link_cPanelTRUNKInt = prop.getProperty("cPanel_TRUNKInt");
        String link_cPanelTAG      = prop.getProperty("cPanel_TAG");
        String link_cPanelTAGInt   = prop.getProperty("cPanel_TAGInt");
        String link                = "";
// new String[]{"TRUNK", "TAG", "TRUNK_INT", "TAG_INT"}
        String[] result = new String[2];

        String answer = DialogMessageWithDropDown.showMessageWindow("CPanel", "Choose where to login: ", new String[]{"TRUNK", "TAG", "TRUNK_INT", "TAG_INT"});

        if (answer.equals("TRUNK")) {
            link = link_cPanelTRUNK;
        } else if (answer.equals("TAG")) {
            link = link_cPanelTAG;
        } else if (answer.equals("TRUNK_INT")) {
            link = link_cPanelTRUNKInt;
        } else if (answer.equals("TAG_INT")) {
            link = link_cPanelTAGInt;
        } else {
        }

        result[0] = link;
        result[1] = answer;

        return result;
    }

    public String[] logInToCPan_Quest(String[] environments) {

        FileInputStream objfile = null;

        try {
            objfile = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/misc/objects.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            prop.load(objfile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String link_cPanelTRUNK    = prop.getProperty("cPanel_TRUNK");
        String link_cPanelTRUNKInt = prop.getProperty("cPanel_TRUNKInt");
        String link_cPanelTAG      = prop.getProperty("cPanel_TAG");
        String link_cPanelTAGInt   = prop.getProperty("cPanel_TAGInt");
        String link                = "";
// new String[]{"TRUNK", "TAG", "TRUNK_INT", "TAG_INT"}
        String[] result = new String[2];


        String answer = DialogMessageWithDropDown.showMessageWindow("CPanel", "Choose where to login: ", environments);

        if (answer.equals("TRUNK")) {
            link = link_cPanelTRUNK;
        } else if (answer.equals("TAG")) {
            link = link_cPanelTAG;
        } else if (answer.equals("TRUNK_INT")) {
            link = link_cPanelTRUNKInt;
        } else if (answer.equals("TAG_INT")) {
            link = link_cPanelTAGInt;
        } else {
        }

        result[0] = link;
        result[1] = answer;

        return result;
    }


    public static void logInToThePage(WebDriver browser, String loginLink, long waitingTime, String userName, String userPass, boolean managingCompanyCheck, String company) {
        String pathUserName          = "//*[@id='login_name']";
        String pathUserPass          = "//*[@id='login_pass']";
        String nameManagingCompCheck = "managingCompanyIgnoreDomain";
        String pathLogIn             = "//input[@value='Log in']";
        String loginLogOutMenu       = "//*[@id='my_profile_main_menu']"; // CPanel element from the next page


//'Service is temporarily down. Please try again later.'


// Loading the Page:
        browser.get(loginLink);
        try {

            waitForPageLoad(browser, (int) waitingTime, EXPECT_NO_DEPLOY);
//          config.manage().timeouts().pageLoadTimeout(waitingTime, TimeUnit.MILLISECONDS);
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

// Selecting the checkbox:
        boolean checked = browser.findElement(By.name(nameManagingCompCheck)).isSelected();
        if (checked != managingCompanyCheck) {
            browser.findElement(By.name(nameManagingCompCheck)).click();
        }

// Choosing the company:
        Select cPanelTheme = new Select(browser.findElement(By.name("managingCompanyNumberTest")));
        if (!company.equals("")) {
            cPanelTheme.selectByVisibleText(company);

        } else {
        }


// Pressing the Login button:
        browser.findElement(By.xpath(pathLogIn)).click();

// Waiting until we enter the CPanel page:
        WebDriverWait wait             = new WebDriverWait(browser, waitingTime);
        boolean       myDynamicElement = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(pathLogIn)));

    }
}
