package logins;

import misc.MyCustomDate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CPanel_Calendars {

    public static String calendarDate(WebDriver browser, long waitingTime, MyCustomDate fromDate, MyCustomDate toDate) {


        MyCustomDate[] theLoop          = {fromDate, toDate};
        String         concatenatedDate = "";
        for (MyCustomDate var : theLoop) {
//            body-of-loop

            String year;
            String month;
            String day;
            String hour;
            String minute;
            byte   calendarNumber = 0;

            String dateChange = "";

            year = var.getYear();
            month = var.getMonth();
            day = var.combineDate();
            hour = var.getHour();
            minute = var.getMinute();

            System.out.println("  Zero year: " + year);
            System.out.println(" Zero month: " + month);
            System.out.println("   Zero day: " + day);
            System.out.println("  Zero hour: " + hour);
            System.out.println("Zero minute: " + minute);
            System.out.println("===============");

            if (!var.combineDate("-").equals("--1") && var == fromDate) {
                dateChange = "//*[@id='dateFrom']";
                System.out.println("------From Date------");
                calendarNumber = 1;   // value needed for the Calendar's xpath

            } else if (!var.combineDate("-").equals("--1") && var == toDate) {
                dateChange = "//*[@id='dateTo']";
                System.out.println("------To Date------");
                calendarNumber = 2; // value needed for the Calendar's xpath
            } else {
                year = "";
                month = "";
                day = "1";
            }

//            if ((!fromDate.combineDate().equals("--1")) || (!toDate.combineDate().equals("--1"))) {
            if ((!var.combineDate("-").equals("--1"))) {
                String calendarOnFocus    = "//table[@class='DynarchCalendar-topCont'][" + calendarNumber + "]//div[contains(@class,'DynarchCalendar-focused')]";
                String clickOnYear        = calendarOnFocus + "//table[@class='DynarchCalendar-titleCont']";
                String clickToChangeYear  = calendarOnFocus + "//div[@class='DynarchCalendar-menu']//input[@class='DynarchCalendar-menu-year']";
                String clickToChooseMonth = calendarOnFocus + "//table[@class='DynarchCalendar-menu-mtable']//div[text()[normalize-space(.)='" + month + "']]";
//                String clickToChooseDay = calendarOnFocus + "//div[@class='DynarchCalendar-body']//*[text()[normalize-space(.)='" + day + "']]";
                String clickToChooseDay = calendarOnFocus + "//div[@class='DynarchCalendar-body']//div[@dyc-date='" + day + "']";

                WebDriverWait wait = new WebDriverWait(browser, waitingTime);

                WebElement dateMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dateChange)));
                dateMenu.click();

                WebElement theYear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(clickOnYear)));
                theYear.click();

                WebElement changeTheYear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(clickToChangeYear)));  // wait
                changeTheYear.clear(); // sendKeys(Keys.chord(Keys.CONTROL, "a"));
                changeTheYear.sendKeys(year);

                WebElement selectMonth = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(clickToChooseMonth)));  // wait
                selectMonth.click();

                WebElement selectDay = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(clickToChooseDay)));  // wait
                selectDay.click();


                if (!(hour.equals(null) && minute.equals(null))) {

                }


            }

            concatenatedDate = year + "-" + month + "-" + day;
            System.out.println("concatenatedDate: " + concatenatedDate);
            System.out.format(" Y:%s M:%s D:%s \n", var.getYear(), var.getMonth(), var.getDay());

        }
        return concatenatedDate;
    }


    public static void calendarVerifyFromDate(WebDriver browser, long waitingTime, MyCustomDate fromDate) {
        //@TODO
    }

    public static void calendarVerifyToDate(WebDriver browser, long waitingTime, MyCustomDate toDate) {
        //@TODO
    }

    public static void calendarVerifyFromDateTime(WebDriver browser, long waitingTime, MyCustomDate fromDate) {
        //@TODO
    }

    public static void calendarVerifyToDateTime(WebDriver browser, long waitingTime, MyCustomDate toDate) {
        //@TODO
    }

}
