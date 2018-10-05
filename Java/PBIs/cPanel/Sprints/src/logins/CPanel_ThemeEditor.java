package logins;

import com.google.common.base.Verify;
import misc.HighlightElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class CPanel_ThemeEditor {

    //Create Object of FileInputStream Class. Pass file path.
    FileInputStream objfile;

    private static Properties prop = new Properties();


    public void setMerchantSite(WebDriver driver, long waitingTimeSec, String webSiteName) throws IOException {

        objfile = new FileInputStream(System.getProperty("user.dir") + "/src/misc/objects.properties");

        //Pass object reference objfile to load method of Properties object.
        prop.load(objfile);

        String     webSiteDropDown = prop.getProperty("sel_MerchantSite");
        WebElement dropDown        = driver.findElement(By.xpath(webSiteDropDown));

        btnThemeEditor_verifyMerchantSiteDropDown(driver, dropDown, waitingTimeSec);

        HighlightElement.highlightElementBorder(driver, dropDown, "red");

        String           optionName = "";
        List<WebElement> options    = driver.findElements(By.xpath(webSiteDropDown));

        List<String> optionsByText = new ArrayList<>();
        for (WebElement option : options) {
            optionsByText = Arrays.asList(option.getText().split("\\n"));
        }

        for (int i = 0; i < optionsByText.size(); i++) {
            if (optionsByText.get(i).contains(webSiteName)) {
                optionName = optionsByText.get(i).trim();
                break;
            }
        }

        Select webSiteOption = new Select(driver.findElement(By.xpath(webSiteDropDown)));
        webSiteOption.selectByVisibleText(optionName);

        btnThemeEditor_verifyChosenMerchantSite(driver, waitingTimeSec, optionName);


    }


    public static void btnThemeEditor_verifyMerchantSiteDropDown(WebDriver driver, WebElement element, long waitingTimeSec) {
        boolean       merchantSiteDropDownIsDisplayed;
        boolean       merchantSiteDropDownIsEditable;
        WebDriverWait wait            = new WebDriverWait(driver, waitingTimeSec);
        WebElement    dropDownWebSite = wait.until(ExpectedConditions.visibilityOf(element));

        merchantSiteDropDownIsDisplayed = dropDownWebSite.isDisplayed();
        if (merchantSiteDropDownIsDisplayed) {
            System.out.println("WebSite drop-down is Present: OK");
        } else {
            try {
                throw new Exception("WebSite drop-down is Not Present: NOK");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        merchantSiteDropDownIsEditable = dropDownWebSite.isEnabled();
        if (merchantSiteDropDownIsEditable) {
            System.out.println("WebSite drop-down is Enabled: OK");
        } else {
            try {
                throw new Exception("WebSite drop-down is Not Enabled: NOK");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }


    public void btnThemeEditor_verifyChosenMerchantSite(WebDriver driver
            , long waitingTimeSec
            , String webSiteName) throws IOException {

        objfile = new FileInputStream(System.getProperty("user.dir") + "/src/misc/objects.properties");

        //Pass object reference objfile to load method of Properties object.
        prop.load(objfile);


        String        webSiteDropDown = prop.getProperty("sel_MerchantSite");
        WebDriverWait wait            = new WebDriverWait(driver, waitingTimeSec);

        WebElement dropDownWebsite = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(webSiteDropDown)));

        Select webSiteOption = new Select(dropDownWebsite);
        String option        = webSiteOption.getFirstSelectedOption().getText();

        try {
            Verify.verify(true, "Expected: [" + webSiteName + "] | Present: [" + option + "] don't match!: NOK ", option, webSiteName);
            System.out.println("Expected: [" + webSiteName + "] | Present: [" + option + "] match!: OK");
        } catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }


    }


    public WebElement themeEditor_clickOnThemeDropDownOptions(WebDriver driver
            , long waitingTimeSec
            , String themeName
            , String themeDropDownOption) throws IOException {
        objfile = new FileInputStream(System.getProperty("user.dir") + "/src/misc/objects.properties");

        //Pass object reference objfile to load method of Properties object.
        prop.load(objfile);
        String themeNamePath      = "//*[contains(text(),'" + themeName + "')]/..";
        String hoverOverDownArrow = themeNamePath + "//*[contains(@class,'template_box_manage_cog')]";
        String dropDownMenuPath   = themeNamePath + "//a[text()[normalize-space(.)='" + themeDropDownOption + "']]";


        WebDriverWait wait = new WebDriverWait(driver, waitingTimeSec);
        System.out.println("Step 1");

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(themeNamePath)));
        } catch (Exception ex1) {
            System.out.printf("Theme name \"%s\"cannot be found.\n\t %s \n", themeName, ex1.getMessage());
        }
        System.out.println("Step 2");

        Actions builder = new Actions(driver);

        Action mouseOverOption;
        System.out.println("Step 3");
        WebElement elementThemeName      = driver.findElement(By.xpath(themeNamePath));
        WebElement elementThemeDownArrow = driver.findElement(By.xpath(hoverOverDownArrow));
        WebElement dropDownOption        = driver.findElement(By.xpath(dropDownMenuPath));

        mouseOverOption = builder
                .moveToElement(elementThemeName)
                .moveToElement(elementThemeDownArrow)
                .click(dropDownOption).build();
        mouseOverOption.perform();
        System.out.println("Step 4");

        WebElement       found         = null;
        List<WebElement> elementsFound = new ArrayList<>();

        if (themeDropDownOption.equals("Preview")) {
        } else if (themeDropDownOption.equals("Edit")) {
            String     elementFromNewPagePath = "//*[@id='template_name']";
            WebElement elementNewPage         = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementFromNewPagePath)));
            if (elementNewPage.isDisplayed()) {
                found = driver.findElement(By.xpath(elementFromNewPagePath));
            }

        } else if (themeDropDownOption.equals("Publish")) {

            String publishPopupText = "Are you sure you want to publish this template?";
//@TODO
        } else if (themeDropDownOption.equals("Duplicate")) {
        } else if (themeDropDownOption.equals("Move/Copy to...")) {
        } else if (themeDropDownOption.equals("Delete")) {
        } else if (themeDropDownOption.equals("Change Device Type")) {
        } else {
            System.out.println("Not defined item");
        }

        return found;
    }


    public static enum PublishConfirmationButtons {
        CANCEL("Cancel"), OK("OK");

        PublishConfirmationButtons(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }

    public WebElement themeEditor_Publish_ClickOnButton(WebDriver driver
            , long waitingTimeSec
            , PublishConfirmationButtons buttonName) {
        WebElement element = null;

//        String themeNamePath      = "//*[contains(text(),'" + themeName + "')]/..";
//        String hoverOverDownArrow = themeNamePath + "//*[contains(@class,'template_box_manage_cog')]";
//        String dropDownMenuPath   = themeNamePath + "//a[text()[normalize-space(.)='" + themeDropDownOption + "']]";


        WebDriverWait wait = new WebDriverWait(driver, waitingTimeSec);
        System.out.println("Step 1");


        return element;
    }


}
