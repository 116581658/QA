package logins;

import customMessages.DialogMessageWithDropDown;
import customMessages.InputDialogMessage;
import misc.HighlightElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PPPAdmin_Merchant_create {

    public static void createMerchant(WebDriver browser, String loginLink, long waitingTime, String userName, String userPass, boolean managingCompanyCheck, String company) throws InterruptedException {


        String merchantName          = "Yanko-Merchant_Regression_Manual";
        String merchantKey           = "";
        String merchantGwId          = "";
        String managingCompany       = "";
        String multiClientID         = "88888";
        String multiClientName       = "YanMulticlient_R_M";
        String rebillingLoginName    = "n/a";
        String rebillingPasswordHash = "N/A";
        String status                = "Verified";
        String merchantEmails        = "yankoy@safecharge.com";
        String merchantPhoneNumber   = "5623463456";
        String btnSave               = "";

        browser.findElement(By.xpath("//*[text()[normalize-space(.)='Create New Merchant']]")).click();
        browser.findElement(By.xpath("//input[contains(@name,'name')]")).sendKeys(merchantName);

        // ----------------
        WebElement MerchantKeyField = browser.findElement(By.xpath("//input[@name=\"merchantKey\"]"));
        HighlightElement.highlightElementAndDisappear(browser, MerchantKeyField, 2000L);

        String answerMerchantKey = DialogMessageWithDropDown.showMessageWindow("Generate MerchantKey", "Do you want to generate the \"MerchantKey\" ? ", new String[]{"Yes", "No"});

        if (answerMerchantKey.equals("Yes")) {
            browser.findElement(By.xpath("//input[@value='Generate Key']")).click();
        } else {
            InputDialogMessage.showInputMessage("Are you ready?", "When ready press OK button", "Ready?");
            merchantKey = browser.findElement(By.xpath("//input[@name='merchantKey']")).getAttribute("value");
            System.out.println("merchantKey: " + merchantKey);
        }

        // -----------------
        WebElement MerchantGwIdField = browser.findElement(By.xpath("//input[@name=\"merchantGwId\"]"));
        HighlightElement.highlightElementAndDisappear(browser, MerchantGwIdField, 2000L);

        String answerMerchantGwIdField = DialogMessageWithDropDown.showMessageWindow("Generate MerchantGwId", "Do you want to generate the \"MerchantGwId\" ? ", new String[]{"Yes", "No"}).toUpperCase();

        if (answerMerchantGwIdField.equals("YES")) {
            browser.findElement(By.xpath("//input[@value='Generate MerchantID']")).click();
        } else {
            InputDialogMessage.showInputMessage("Are you ready?", "When ready press OK button", "Ready?");
            merchantGwId = browser.findElement(By.xpath("//input[@name='merchantGwId']")).getAttribute("value");
            System.out.println("merchantGwId: " + merchantGwId);
        }

        browser.findElement(By.xpath("//select[@name='managingCompany']/option[contains(text(),'Safecharge') and contains(@value, '1')]")).click();
        browser.findElement(By.xpath("//input[@value='Generate MerchantID']")).click();
        browser.findElement(By.xpath("//input[contains(@name,'multiClientId')]")).sendKeys(multiClientID);
        browser.findElement(By.xpath("//input[contains(@name,'multiClientName')]")).sendKeys(multiClientName);
        browser.findElement(By.xpath("//input[contains(@name,'rebillingLoginName')]")).sendKeys(rebillingLoginName);
        browser.findElement(By.xpath("//input[contains(@name,'rebillingPassword')]")).sendKeys(rebillingPasswordHash);
        browser.findElement(By.xpath("//select[@name='status']/option[contains(text()," + status + ") and contains(@value, '3')]")).click();
        browser.findElement(By.xpath("//input[contains(@name,'merchantMail')]")).sendKeys(merchantEmails);
        browser.findElement(By.xpath("//input[contains(@name,'phoneNumber')]")).sendKeys(merchantPhoneNumber);

        String answer = DialogMessageWithDropDown.showMessageWindow("PPP Admin: Create New Merchant", "Do you want to save the changes?", new String[]{"Yes", "NO"});

        merchantName = browser.findElement(By.xpath("//input[contains(@name,'name')]")).getAttribute("value");

        if (answer.equals("Yes")) {
            browser.findElement(By.xpath("//input[@value='Save']")).click(); //
        } else {
            browser.findElement(By.xpath("//input[@value='Cancel']")).click(); //
        }


    }


}
