package logins;

import customMessages.DialogMessageWithDropDown;
import customMessages.InputDialogMessage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class PPPAdmin_Rebilling_Merchant_Login_create {

    public static final boolean CODE_DEBUG = false;

    public static void main(String[] args) throws IOException {

        if (CODE_DEBUG) {
            System.setProperty("webdriver.chrome.driver", "C:\\02_QA\\Selenium\\WebDriver\\Chrome65-66\\chromedriver.exe");
            WebDriver browser = new ChromeDriver();
            String linkTRUNK = "http://192.168.103.237:8080/pppadmin/admin";  // Path to PPPAdmin TRUNK
            browser.get(linkTRUNK);
            PPPAdmin_Login_page.login_PPPAdmin(browser, "pppadmin", "pppadmin");

            browser.get("http://192.168.103.237:8080/pppadmin/admin/rbleditmerchantlogin.do"); // Path to "Create Rebilling Merchant Login"
            rebilling_Merchant_Login_create(browser, "The Account name", "The login Name", "tepasss");
        }

    }

    public static List<String> rebilling_Merchant_Login_create(WebDriver driver, String merchantAccount, String merchantLoginName, String merchantLoginPassword) throws IOException {
        if (!CODE_DEBUG) {
            driver.findElement(By.xpath("//a[text()[normalize-space(.)='Create Merchant Login']]")).click();
            driver.findElement(By.xpath("//select[@name=\"merchantId\"]/option[text()[normalize-space(.)='" + merchantAccount + "']]")).click();
            driver.findElement(By.xpath("//input[@name=\"loginName\"]")).sendKeys(merchantLoginName);
            driver.findElement(By.xpath("//input[@name=\"passwordHash\"]")).sendKeys(merchantLoginPassword);
            driver.findElement(By.xpath("//input[@name=\"retypePassword\"]")).sendKeys(merchantLoginPassword);
        }
        InputDialogMessage.showInputMessage("Rebilling Merchant", "Are these the correct values? \n If not write your owns and press OK button", "OK?");

//        merchantAccount = driver.findElement(By.xpath("//select[@name=\"merchantId\"]/option[text()[normalize-space(.)='" + merchantAccount + "']]"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime date = LocalDateTime.now();
        String dateToText = date.format(formatter);
        System.out.println(dateToText);

        if (!CODE_DEBUG) {
            String merchantAccountValue = driver.findElement(By.xpath("//select[@name=\"merchantId\"]")).getAttribute("value");
            merchantAccount = driver.findElement(By.xpath("//option[@value=\'" + merchantAccountValue + "\']")).getText();
            merchantLoginName = driver.findElement(By.xpath("//input[@name=\"loginName\"]")).getAttribute("value");
            merchantLoginPassword = driver.findElement(By.xpath("//input[@name=\"passwordHash\"]")).getAttribute("value");
        }

        doYouWantToSaveTheChanges(driver);

        List<String> lines = Arrays.asList("==================" + dateToText + "==================",
                "Merchant Account: " + merchantAccount,
                "      Login Name: " + merchantLoginName,
                "  Login Password: " + merchantLoginPassword,
                "=======================================================");

        if (CODE_DEBUG) {
            System.out.println(lines.get(0));
            System.out.println(lines.get(1));
            System.out.println(lines.get(2));
            System.out.println(lines.get(3));
            System.out.println(lines.get(4));
        }

        // Creates a file, writes the credentials in it and opens it
        String path = "C:" + File.separator + "Temp" + File.separator + "the_Merchant_Login.txt";
        File f = new File(path);
        f.getParentFile().mkdirs(); //Ensures that the parent directories exist before writing. If not creates them.
        f.createNewFile();

        Path file = Paths.get(path);
        try {
            Files.write(file, lines, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
            Runtime.getRuntime().exec("explorer " + path + ""); // Opens the file
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }


    private static void doYouWantToSaveTheChanges(WebDriver driver) {
        String merchantRebillAnswer = DialogMessageWithDropDown.showMessageWindow("PPP Admin: Create \"Rebilling Merchant Login\"", "Do you want to save the changes?", new String[]{"Yes", "NO"});

        if (merchantRebillAnswer.equals("Yes")) {
            driver.findElement(By.xpath("//input[@value=\"Save\"]")).click(); //
        } else {
            driver.findElement(By.xpath("//input[@value=\"Cancel\"]")).click(); //
        }
    }

}
