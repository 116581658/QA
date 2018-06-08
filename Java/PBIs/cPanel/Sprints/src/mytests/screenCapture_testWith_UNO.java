package mytests;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

//import org.apache.commons.io.FileUtils;
//import org.junit.*;
//import org.testng.annotations.Test;

public class screenCapture_testWith_UNO {

    WebDriver driver;
    public WebElement element;

    @BeforeTest
    public void settUp() {
//        System.setProperty("webdriver.chrome.driver", "C:\\02_QA\\Selenium\\WebDriver\\Chrome65-66\\chromedriver.exe");
//        driver = new ChromeDriver();
//
        System.setProperty("webdriver.gecko.driver", "C:\\02_QA\\Selenium\\WebDriver\\geckodriver-v0.20.0-win32.exe");
        driver = new FirefoxDriver();
        driver.get("https://uno.azurewebsites.net/report/operations/transaction-search#");
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testApp() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement    myDynamicElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='page-title']")));

        WebElement myDynamicElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main/div[1]/h1")));

        //Search for drop down
        element = myDynamicElement;
        JavascriptExecutor js = (JavascriptExecutor) driver;

//        int documentHeight = ((Number) js.executeScript("return document.body.clientHeight")).intValue();
//        int documentWidth  = ((Number) js.executeScript("return document.body.clientWidth")).intValue();
//        int clientHeight   = ((Number) js.executeScript("return document.documentElement.clientHeight")).intValue();
//        int clientWidth    = ((Number) js.executeScript("return document.documentElement.clientWidth")).intValue();
////        JavascriptExecutor js = (JavascriptExecutor) driver.manage().window().setSize(new Dimension(documentHeight,documentWidth));
//
//        System.out.println("clientHeight: " + clientHeight);
//        System.out.println(" clientWidth: " + clientWidth);
//
//        js.executeScript("arguments[0].scrollIntoView(true);", element);
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        //highlight drop down element by red color
//        js.executeScript("arguments[0].style.border='3px solid red'", element);

        // Take screen shot of whole web page
        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

//        // Calculate the elWidth and elHeight of the drop down element
//        Point p = element.getLocation();
//        System.out.format("p.getX(): %d, p.getY(): %d  \n", p.getX(), p.getY());
//        int elWidth  = element.getSize().getWidth();
//        int elHeight = element.getSize().getHeight();
//        System.out.format("elWidth: %d, elHeight: %d \n", elWidth, elHeight);

//        // Create Rectangle
//        Rectangle rect = new Rectangle(elWidth, elHeight);
//
//        BufferedImage img = null;
//        img = ImageIO.read(screenShot);
//        int imgWidth  = img.getWidth();
//        int imgHeight = img.getHeight();
////        System.out.println("imgWidth: " + imgWidth);
////        System.out.println("imgHeight: " + imgHeight);
//        int imgWidthReminder  = (int) Math.floor(p.getX() / imgWidth);
//        int imgHeightReminder = (int) Math.floor(p.getY() / imgHeight);
//        System.out.println("imgWidthReminder: " + imgWidthReminder);
//        System.out.println("imgHeightReminder: " + imgHeightReminder);
//
//        System.out.println("Some X: " + p.getX() / imgWidthReminder);
//        System.out.println("Some Y: " + p.getY() / imgHeightReminder);


//        int elementRecalcX = Math.min(p.getX(), imgWidth - (p.getX() / imgWidthReminder));
////        int elementRecalcY = Math.min( p.getY(),imgHeight - (p.getY()/ imgHeightReminder));
//        int elementRecalcY;
//
//        double elementRecalcDX = p.getX() / (double) imgWidth;
//        double elementRecalcDY = p.getY() / (double) imgHeight;
//
//        if (elHeight + imgHeight > documentWidth) {
//
//            elementRecalcY = 0;
//        } else {
//            elementRecalcY = p.getY() - ((imgHeightReminder * imgHeight));
//
//        }
//
//        System.out.println("         imgWidth: " + imgWidth);
//        System.out.println("        imgHeight: " + imgHeight);
//        System.out.println(" imgWidthReminder: " + imgWidthReminder);
//        System.out.println("imgHeightReminder: " + imgHeightReminder);
//        System.out.println("   elementRecalcX: " + elementRecalcX);
//        System.out.println("   elementRecalcY: " + elementRecalcY);
//        System.out.println("   elementRecalcDX: " + elementRecalcDX);
//        System.out.println("   elementRecalcDY: " + elementRecalcDY);
//        System.out.println("   documentHeight: " + documentHeight);
//        System.out.println("   documentWidth: " + documentWidth);
//
//        if ()
//
////        //Crop Image of partial web page which includes the "Month" drop down web element
//
////        BufferedImage dest = img.getSubimage(elementRecalcX+1, elementRecalcY+4, elWidth, elHeight);
//        BufferedImage dest = screenShot;
////        System.out.format("img w: %d, img h: %d\n", img.getWidth(), img.getHeight());
////        // write cropped image into File Object
//        ImageIO.write(, "png", screenShot);

        //Copy Image into particular directory
        FileHandler.copy(screenShot,
                new File("C:\\01_Myfiles\\Captures\\Selenium\\partialWebPageTod.png"));
    }

    @AfterTest
    public void tearDown() {
//        driver.quit();
    }


}

