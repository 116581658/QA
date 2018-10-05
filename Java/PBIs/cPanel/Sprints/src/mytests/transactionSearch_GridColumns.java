package mytests;


import logins.CPanel_Login;
import logins.CPanel_Notifications;
import logins.CPanel_Reports_GridColumns;
import logins.CPanel_Main_Menu;
import logins.CPanel_Main_Menu.CPanel_Menu_Names;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

//import org.apache.commons.io.FileUtils;
//import org.junit.*;
//import org.testng.annotations.Test;

public class transactionSearch_GridColumns {

    private WebDriver browser;
    private String cPanelLink;
    private String userCPanel;
    private String passCPanel;
    private boolean manCompanyChecked = false;
    private String companyName;

    @BeforeTest
    public void settUp() {

        cPanelLink = "https://srv-bsf-devcpatrunk.gw-4u.com/login?lang=en_us";
//      String cPanelLink = "https://srv-bsf-devcpatag.gw-4u.com/";


        byte user = 5;  // 1: TRUNK ; 3: TAG


        if (user == 5) {
            userCPanel = "yanko_cP_tr_03_test-wdr";   // Role: Finance_ReadOnly //should see the report + SC
            passCPanel = "PAss1234";
            manCompanyChecked = true;
            companyName = "SC";
        }


        System.setProperty("webdriver.chrome.driver", "C:\\02_QA\\Selenium\\WebDriver\\Chrome65-66\\chromedriver.exe");
        browser = new ChromeDriver();
//
//        System.setProperty("webdriver.gecko.driver", "C:\\02_QA\\Selenium\\WebDriver\\geckodriver-v0.20.0-win32.exe");
//        WebDriver config = new FirefoxDriver();


//
    }

    @Test
    public void testApp() throws IOException, InterruptedException {

        long[] waitingTimes = {100L, 200L, 300L, 500L, 700L, 1000L}; //1000 milliseconds = 1 sec

//=========== Log in cPanel:
        CPanel_Login.logInToThePage(browser, cPanelLink, waitingTimes[5] * 40, userCPanel, passCPanel, manCompanyChecked, companyName);

// =========== Closing Notifications:
        CPanel_Notifications.closeNotifications(browser, waitingTimes[5] * 2);

//  =========== Choosing "Transaction Search" report:
        CPanel_Menu_Names section       = CPanel_Menu_Names.REPORTS;
        String subSection    = "Operational Reports";
        String subSubSection = "Transaction Search";

        CPanel_Main_Menu.searchMenu(browser, waitingTimes[5] * 2, section, subSection, subSubSection);


//  =========== Choosing "Grid filters":
        CPanel_Reports_GridColumns.setGridColumns(browser,waitingTimes[5] * 2,1, new String[][]{{"Friled 1", "on"}, {"Friled 2", "off"}, {"Friled 3", "on"}});
// @TODO






    }

    @AfterTest
    public void tearDown() {
//        driver.quit();
    }


}

