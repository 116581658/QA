package logins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class PPPAdmin_Login_page {

    public static void login_PPPAdmin(WebDriver browser, String userName, String password) {

        browser.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        browser.manage().window().maximize();

        WebElement userField = browser.findElement(By.xpath("//form//label[text()[normalize-space(.)='Username']]/../input"));
        WebElement passField = browser.findElement(By.xpath("//form//label[text()[normalize-space(.)='Password']]/../input"));
        WebElement loginButton = browser.findElement(By.xpath("//input[@value='Login']"));

        userField.sendKeys(userName);
        passField.sendKeys(password);
        loginButton.click();
    }

}
