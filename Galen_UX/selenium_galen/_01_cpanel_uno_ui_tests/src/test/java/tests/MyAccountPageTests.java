package tests;

import classes.CPanel_Login;
import classes.CPanel_Notifications;
import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import misc.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import static com.galenframework.api.Galen.dumpPage;

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

    //Galen starts from here
    LayoutReport layoutReport ;
    //Create a tests list
    List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();
    //Create a htmlReportBuilder object
    HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();

    @BeforeTest
    public void setUp() throws InterruptedException {

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

// =========== Closing Notifications:
        CPanel_Notifications.closeNotifications(browser, waitingTimesMillis[5] * 2);

    }

    @AfterTest
    public void afterMethod() {
        //browser.quit();
    }

    @Test
    public void homePageLayoutTest() throws IOException
    {

        dumpPage(browser,"Dashboard","specs/home-page_dump.gspec","src/test/resources/dumps/dashboard", 1024, 768, false);
        //Create a layoutReport object
        //checkLayout function checks the layout and returns a LayoutReport object
        layoutReport = Galen.checkLayout(browser, "specs/home-page_dump.gspec", Arrays.asList("desktop"));

        //Create a GalenTestInfo object
        GalenTestInfo test = GalenTestInfo.fromString("homepage layout");

        //Get layoutReport and assign to test object
        test.getReport().layout(layoutReport, "check homepage layout");

        //Add test object to the tests list
        tests.add(test);

        //Create a report under /target folder based on tests list
        htmlReportBuilder.build(tests, "target/reports");

        //If layoutReport has errors Assert Fail
        if (layoutReport.errors() > 0)
        {
            Assert.fail("Layout test failed");
        }
    }


    @Test
    public void homePageLayoutTest2() throws IOException
    {

        dumpPage(browser,"Dashboard","specs/home-page_dump.gspec","src/test/resources/dumps/dashboard", 1024, 768, false);
        //Create a layoutReport object
        //checkLayout function checks the layout and returns a LayoutReport object
        layoutReport = Galen.checkLayout(browser, "specs/home-page_dump.gspec", Arrays.asList("desktop"));

        //Create a GalenTestInfo object
        GalenTestInfo test2 = GalenTestInfo.fromString("homepage2 layout");

        //Get layoutReport and assign to test object
        test2.getReport().layout(layoutReport, "check homepage2 layout");

        //Add test object to the tests list
        tests.add(test2);

        //Create a report under /target folder based on tests list
        htmlReportBuilder.build(tests, "target/reports");

        //If layoutReport has errors Assert Fail
        if (layoutReport.errors() > 0)
        {
            Assert.fail("Layout test failed");
        }
    }



}
