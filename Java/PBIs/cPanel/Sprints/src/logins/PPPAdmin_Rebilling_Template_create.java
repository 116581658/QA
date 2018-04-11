package logins;

import customMessages.DialogMessageWithDropDown;
import customMessages.InputDialogMessage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PPPAdmin_Rebilling_Template_create {

    public static final boolean CODE_DEBUG = false;
    public static final String TEMPLATE_TYPE = "finish";
    public static final String CODE_TEMPLATE = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<billing>\n" +
            "    <initialization>\n" +
            "        <transaction immediate=\"yes\" type=\"cashier\">\n" +
            "            <commonName>Trail UPO Subscription</commonName>\n" +
            "            <param name=\"amount\" value=\"${InitialAmount}\"/>\n" +
            "            <param name=\"currency\" value=\"${Currency}\"/>\n" +
            "        </transaction>\n" +
            "    </initialization>\n" +
            "\n" +
            "    <transaction immediate=\"no\" sequence=\"1\" type=\"cashier\">\n" +
            "        <commonName>Recurring UPO Subscription</commonName>\n" +
            "        <param name=\"amount\" value=\"${RecurringAmount}\"/>\n" +
            "        <param name=\"currency\" value=\"${Currency}\"/>\n" +
            "        <start>\n" +
            "            <day>${StartDay}</day>\n" +
            "            <month>${StartMonth}</month>\n" +
            "            <year>${StartYear}</year>\n" +
            "        </start>\n" +
            "\n" +
            "        <interval>\n" +
            "            <day>${IntervalDay}</day>\n" +
            "            <month>${IntervalMonth}</month>\n" +
            "            <year>${IntervalYear}</year>\n" +
            "        </interval>\n" +
            "\n" +
            "        <end>\n" +
            "            <day>${EndDay}</day>\n" +
            "            <month>${EndMonth}</month>\n" +
            "            <year>${EndYear}</year>\n" +
            "        </end>\n" +
            "    </transaction>\n" +
            "</billing>\n";

    public static void main(String[] args) throws IOException {

        if (!CODE_DEBUG) {
            System.setProperty("webdriver.chrome.driver", "C:\\02_QA\\Selenium\\WebDriver\\Chrome65-66\\chromedriver.exe");
            WebDriver browser = new ChromeDriver();
            String linkTRUNK = "http://192.168.103.237:8080/pppadmin/admin";  // Path to PPPAdmin TRUNK
            browser.get(linkTRUNK);
            PPPAdmin_Login_page.login_PPPAdmin(browser, "pppadmin", "pppadmin");

            browser.get("http://192.168.103.237:8080/pppadmin/admin/rbledittemplate.do"); // Path to "Create Template"
            Create_Template(browser, "Yanko-BGO subscriptions", "Yanko-BGO subscriptions");
        }

    }

    public static List<String> Create_Template(WebDriver driver, String merchantAccount, String templateName) {
        if (!CODE_DEBUG) {

            if (templateName.equals("")) {
                templateName = merchantAccount.toLowerCase();
            } else {
                templateName = templateName.toLowerCase();
            }

            driver.findElement(By.xpath("//a[text()[normalize-space(.)='Create Template']]")).click();
            driver.findElement(By.xpath("//select[@name=\"merchantId\"]/option[text()[normalize-space(.)='" + merchantAccount + "']]")).click();
            driver.findElement(By.xpath("//input[@name=\"templateName\"]")).sendKeys(templateName);
            driver.findElement(By.xpath("//input[@name=\"templateType\"]")).sendKeys(TEMPLATE_TYPE);
            driver.findElement(By.xpath("//textarea[@name=\"flowXML\"]")).sendKeys(CODE_TEMPLATE);
        }

        InputDialogMessage.showInputMessage("Create Template", "Are these the correct values? \n If not write your owns and press OK button", "OK?");

        List<String> lines = Collections.EMPTY_LIST;
        if (!CODE_DEBUG) {
            String merchantAccountValue = driver.findElement(By.xpath("//select[@name=\"merchantId\"]")).getAttribute("value");
            merchantAccount = driver.findElement(By.xpath("//select[@name=\"merchantId\"]/option[@value=\'" + merchantAccountValue + "\']")).getText();
            templateName = driver.findElement(By.xpath("//input[@name=\"templateName\"]")).getAttribute("value");
            String templateType = driver.findElement(By.xpath("//input[@name=\"templateType\"]")).getAttribute("value");

            System.out.println(merchantAccount);
            System.out.println(templateName);
            System.out.println(templateType);

            lines = Arrays.asList(
                    "Merchant Account: " + merchantAccount,
                    "   Template Name: " + templateName,
                    "   Template Type: " + templateType);
        }

        doYouWantToSaveTheChanges(driver);

        return lines;
    }

    private static void doYouWantToSaveTheChanges(WebDriver driver) {
        String createTemplateAnswer = DialogMessageWithDropDown.showMessageWindow("PPP Admin: Create Template", "Do you want to save the changes?", new String[]{"Yes", "NO"});

        if (createTemplateAnswer.equals("Yes")) {
            driver.findElement(By.xpath("//input[@value=\"Save\"]")).click(); //
        } else {
            driver.findElement(By.xpath("//input[@value=\"Cancel\"]")).click(); //
        }
    }


}
