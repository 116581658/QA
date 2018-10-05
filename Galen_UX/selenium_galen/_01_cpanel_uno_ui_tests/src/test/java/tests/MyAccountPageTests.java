package tests;

import classes.CPanel_Login;
import misc.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class MyAccountPageTests {
    Properties prop = new Properties();

    CPanel_Login login = new CPanel_Login();
    Browser setBrowser = new Browser();
    WebDriver browser;
//    private static String[] environments = {"TRUNK", "TAG"};
//    public String[] cPanel = login.logInToCPan_Quest(environments);

//    public String cPanelLink = cPanel[0];
//    public String cPanelEnvironment = cPanel[1];

    public String cPanelLink;
    public String cPanelEnvironment = "TRUNK";

    long[] waitingTimesMillis = {100L, 200L, 300L, 500L, 700L, 1000L}; //1000 milliseconds = 1 sec
    int[] waitingTimesSecs = {1, 2, 3, 5, 7, 10}; //1000 milliseconds = 1 sec


    @BeforeTest
    public void setUp() {

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

        cPanelLink = prop.getProperty("cPanel_TRUNK");

        String  userCPanel        = "";
        String  passCPanel        = "";
        boolean manCompanyChecked = false;
        String  companyName       = "";

        if (cPanelEnvironment.equals("TRUNK")) {
            userCPanel = "yanko_cP_tr_03_test-wdr";   // Role: Finance_ReadOnly //should see the report + SC
            passCPanel = "PAss1234";
            manCompanyChecked = true;
            companyName = "SC";
        } else if (cPanelEnvironment.equals("TRUNK")) {
            userCPanel = "yanko_cP_tr_03_test-wdr";   // Role: Finance_ReadOnly //should see the report + SC
            passCPanel = "PAss1234";
            manCompanyChecked = true;
            companyName = "SC";
        } else {
        }


// =========== Use browser:
        browser = setBrowser.config(Browser.RunBrowser.CHROME);


// =========== Log in cPanel:
        CPanel_Login.logInToThePage(browser, cPanelLink, waitingTimesMillis[5] * 40, userCPanel, passCPanel, manCompanyChecked, companyName);

    }

    @Test
    public void f() {


    }


    @AfterTest
    public void afterMethod() {
        //browser.quit();
    }

}
