package logins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class Login_cPanel {

    public static void logInToThePage(WebDriver browser, String loginLink, long waitingTime, String userName, String userPass, boolean managingCompanyCheck, String company) {

        String pathUserName = "//*[@id='login_name']";
        String pathUserPass = "//*[@id='login_pass']";
        String nameManagingCompCheck = "managingCompanyIgnoreDomain";
        String pathLogIn = "//input[@value='Log in']";
        String loginLogOutMenu = "//*[@id='my_profile_main_menu']"; // CPanel element from the next page

// Loading the Page:
        browser.get(loginLink);
        try {
            browser.manage().timeouts().pageLoadTimeout(waitingTime, MILLISECONDS);
        }catch(Throwable ex) {
            System.out.format("Page not loaded for %d milliseconds", waitingTime);
        }
        browser.manage().window().maximize();

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
        cPanelTheme.selectByVisibleText(company);

// Pressing the Login button:
        browser.findElement(By.xpath(pathLogIn)).click();

// Waiting until we enter the CPanel page:
        WebDriverWait wait = new WebDriverWait(browser, waitingTime);
        WebElement myDynamicElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginLogOutMenu)));

    }
}
