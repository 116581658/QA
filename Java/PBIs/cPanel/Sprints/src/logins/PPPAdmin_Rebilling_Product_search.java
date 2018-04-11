package logins;

import customMessages.DialogMessageWithDropDown;
import customMessages.InputDialogMessage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PPPAdmin_Rebilling_Product_search {

    public static final boolean CODE_DEBUG = false;


    public static void main(String[] args) throws IOException {

        if (!CODE_DEBUG) {
            System.setProperty("webdriver.chrome.driver", "C:\\02_QA\\Selenium\\WebDriver\\Chrome65-66\\chromedriver.exe");
            WebDriver browser = new ChromeDriver();
            String linkTRUNK = "http://192.168.103.237:8080/pppadmin/admin";  // Path to PPPAdmin TRUNK
            browser.get(linkTRUNK);
            PPPAdmin_Login_page.login_PPPAdmin(browser, "pppadmin", "pppadmin");

            browser.get("http://192.168.103.237:8080/pppadmin/admin/preparerebillingproduct.do"); // Path to "Create new product"
            Create_Rebilling_Product(browser, "Yanko-Merchant_Regression_Manual", "The Product Name", "yanko_bgo_subscription");
        }

    }


    public static List<String> Create_Rebilling_Product(WebDriver driver, String merchantID, String productName, String rebillingTemplateName) {
        if (!CODE_DEBUG) {
            driver.findElement(By.xpath("//a[text()[normalize-space(.)='Create Rebilling Product']]")).click();

            driver.findElement(By.xpath("//select[@name=\"merchantId\"]/option[text()[normalize-space(.)='" + merchantID + "']]")).click();
            driver.findElement(By.xpath("//input[@name=\"productName\"]")).sendKeys(productName);
            driver.findElement(By.xpath("//select[@name=\"rblTemplateId\"]/option[text()[normalize-space(.)='" + rebillingTemplateName + "']]")).click();

        }


        InputDialogMessage.showInputMessage("Create Template", "Are these the correct values? \n If not write your owns and press OK button", "OK?");


        List lines = null;
        if (!CODE_DEBUG) {
            String merchantIDValue = driver.findElement(By.xpath("//select[@name=\"merchantId\"]")).getAttribute("value");
            merchantID = driver.findElement(By.xpath("//option[@value=\'" + merchantIDValue + "\']")).getText();

            productName = driver.findElement(By.xpath("//input[@name=\"productName\"]")).getAttribute("value");
//select[@name="rblTemplateId"]/option[@value=42006]
            String rebillingTemplateNameValue = driver.findElement(By.xpath("//select[@name=\"rblTemplateId\"]")).getAttribute("value");
            rebillingTemplateName = driver.findElement(By.xpath("//select[@name=\"rblTemplateId\"]/option[@value=\'" + rebillingTemplateNameValue + "\']")).getText();

            String rebillingProductLink = driver.getCurrentUrl();
            int equalIndex = rebillingProductLink.lastIndexOf("=");
            String rebillingProductNumber = rebillingProductLink.substring(equalIndex+1);

            System.out.println("rebillingTemplateNameValue: " + rebillingTemplateNameValue);
            System.out.println("                merchantID: " + merchantID);
            System.out.println("               productName: " + productName);
            System.out.println("     rebillingTemplateName: " + rebillingTemplateName);
            System.out.println("    rebillingProductNumber: " + rebillingProductNumber);


            lines = Arrays.asList(
                    "                Merchant: " + merchantID,
                    "            Product Name: " + productName,
                    " Rebilling Template Name: " + rebillingTemplateName,
                    "Rebilling Product Number: " + rebillingProductNumber

                    );
        }


        doYouWantToSaveTheChanges(driver);


        return lines;
    }


    private static void doYouWantToSaveTheChanges(WebDriver driver) {
        String createTemplateAnswer = DialogMessageWithDropDown.showMessageWindow("PPP Admin: Create Template", "Do you want to save the changes?", new String[]{"Yes", "NO"});

        if (createTemplateAnswer.equals("Yes")) {
            driver.findElement(By.xpath("//input[@value=\"Save\"]")).click(); //
        } else {
            driver.navigate().back(); // As there is no "Cancel" button we go back
        }
    }


}
