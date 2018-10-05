package tests;

import com.galenframework.testng.GalenTestNgTestBase;
import misc.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import org.openqa.selenium.Dimension;
import java.util.LinkedList;
import java.util.List;



public class WelcomePageTest {
    Browser setBrowser = new Browser();
    WebDriver browser;



    @BeforeTest
    public void setUp(){

        // =========== Use browser:
        browser = setBrowser.config(Browser.RunBrowser.CHROME);
//Set the browser size for desktop
        browser.manage().window().setSize(new Dimension(1200, 800));
        //Go to swtestacademy.com
        browser.get("https://www.swtestacademy.com/");
    }


    @AfterTest
    public void tearDown()
    {
        browser.quit();
    }


    @Test
    public void homePageLayoutTest() throws IOException
    {
        //Create a layoutReport object
        //checkLayout function checks the layout and returns a LayoutReport object
        LayoutReport layoutReport = Galen.checkLayout(browser, "specs/homepage.gspec", Arrays.asList("desktop"));

        //Create a tests list
        List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();

        //Create a GalenTestInfo object
        GalenTestInfo test = GalenTestInfo.fromString("homepage layout");

        //Get layoutReport and assign to test object
        test.getReport().layout(layoutReport, "check homepage layout");

        //Add test object to the tests list
        tests.add(test);

        //Create a htmlReportBuilder object
        HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();

        //Create a report under /target folder based on tests list
        htmlReportBuilder.build(tests, "target/reports");

        //If layoutReport has errors Assert Fail
        if (layoutReport.errors() > 0)
        {
            Assert.fail("Layout test failed");
        }
    }





}
