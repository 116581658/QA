package logins;

import misc.CustomCalendarDate;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CPanel_reports_Search_drop_down_Filters_Calendars {

    private static String fromOrToTimeDate;

    private static void setFromOrToTimeDate(String someTime) {
        fromOrToTimeDate = someTime;
    }

    public static String getFromOrToTimeDate() {
        return fromOrToTimeDate;
    }

    public static String calendarDate(WebDriver driver, long waitingTime, CustomCalendarDate fromDate, CustomCalendarDate toDate) {

        boolean DEBUG = false;

        WebDriverWait wait = new WebDriverWait(driver, waitingTime);

        CustomCalendarDate[] theLoop          = {fromDate, toDate};
        String               concatenatedDate = "";
        for (CustomCalendarDate var : theLoop) {
//            body-of-loop
            Actions builder        = new Actions(driver);
            Action  mouseOverDay;
            byte    calendarNumber = 0;
            String  fromTime;


            String year;
            String month;
            String day;
            String hours;
            String minutes;


            year = var.getYear();
            month = var.getMonth();
            day = var.combineDate();
            hours = var.getHour();
            minutes = var.getMinute();

            if (DEBUG) {
                System.out.println("  Zero year: " + year);
                System.out.println(" Zero month: " + month);
                System.out.println("   Zero day: " + day);
                System.out.println("===============");
            }

            String dateChange          = "";
            String reportName          = getReportName(driver);
            String requestsSearch      = "Requests search";
            String ordersSearch        = "Orders search";
            String balanceConfirmation = "Balance Confirmation";

            if (!var.combineDate("-").equals("--1") && var == fromDate) {

                if (reportName.equals(requestsSearch) || reportName.equals(ordersSearch)) {
                    dateChange = "//*[@id='fromDate']";

                } else {
                    dateChange = "//*[@id='dateFrom']";
                }

                if (DEBUG) {
                    System.out.println("------From Date------");
                }
//                calendarNumber = 1;   // value needed for the Calendar's xpath
                setFromOrToTimeDate("FROM");
            } else if (!var.combineDate("-").equals("--1") && var == toDate) {
                if (reportName.equals(requestsSearch) || reportName.equals(ordersSearch)) {
                    dateChange = "//*[@id='toDate']";

                } else {
                    dateChange = "//*[@id='dateTo']";
                }

                if (DEBUG) {
                    System.out.println("------To Date------");
                }
                calendarNumber = 2; // value needed for the Calendar's xpath
                setFromOrToTimeDate("TO");

            } else {
                year = "";
                month = "";
                day = "1";
            }

            if ((!(year == null || year.isEmpty())) && (!(month == null || month.isEmpty())) && (!(day == null || day.isEmpty()))) {
//            if ((!fromDate.combineDate().equals("--1")) || (!toDate.combineDate().equals("--1"))) {
                if ((!var.combineDate("-").equals("--1"))) {
//                String calendarToChoose    = "//table[@class='DynarchCalendar-topCont'][" + calendarNumber + "]//div[contains(@class,'DynarchCalendar-focused')]";
                    String calendarOnFocus    = "//table[@class='DynarchCalendar-topCont' and (not(contains(@style,'display: none')))]//div[contains(@class,'DynarchCalendar-focused')]";
                    String clickOnYear        = calendarOnFocus + "//table[@class='DynarchCalendar-titleCont']//div[@dyc-type='title']";
                    String clickToChangeYear  = calendarOnFocus + "//div[@class='DynarchCalendar-menu']//input[@class='DynarchCalendar-menu-year']";
                    String clickToChooseMonth = calendarOnFocus + "//table[@class='DynarchCalendar-menu-mtable']//div[text()[normalize-space(.)='" + month + "']]";
//                    String clickToChooseDay   = calendarOnFocus + "//tbody//div[@class='DynarchCalendar-body']//div[@dyc-date='" + day + "']";
                    String clickToChooseDay = calendarOnFocus + "//div[@class='DynarchCalendar-body']//div[@dyc-date='" + day + "']";
//                String clickOnElementLabel = "//label[text()[normalize-space(.)='To date/time:']]";
                    String clickOnElementLabel = "//h1[@class='page_title']";


                    WebElement dateMenu = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dateChange)));
                    dateMenu.click();

                    WebElement theYear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(clickOnYear)));
                    theYear.click();

                    WebElement changeTheYear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(clickToChangeYear)));  // wait
                    changeTheYear.clear(); // sendKeys(Keys.chord(Keys.CONTROL, "a"));
                    changeTheYear.sendKeys(year);

                    WebElement selectMonth = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(clickToChooseMonth)));  // wait
                    selectMonth.click();

                    try {
                        Thread.sleep(600L);        // This time pause is essential as it turned out after 4 days of tryings
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    WebElement selectDayFire = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(clickToChooseDay)));  // wait

                    selectDayFire.click(); // this works with Chrome and with Firefox 11.05.2018

//                mouseOverDay = builder.click(selectDayFire).build();
//                mouseOverDay.perform();


                /*!!!!!!! As the click on the second date was not selecting the date this is a hack for Chrome
                (and as it turned out the best solution also for Firefox): !!!!!*/
                    driver.findElement(By.xpath(clickOnElementLabel)).click();

                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(clickToChooseDay)));  // wait

                    try {
                        Thread.sleep(500L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
            concatenatedDate = year + "-" + month + "-" + day;
            if (DEBUG) {
                System.out.println("concatenatedDate: " + concatenatedDate);
                System.out.format(" Year: %s Month: %s Day: %s \n", var.getYear(), var.getMonth(), var.getDay());
            }

            if ((!(hours == null || hours.isEmpty())) && (!(minutes == null || minutes.isEmpty()))) {
                if (DEBUG) {
                    System.out.println("  Hours are not null: " + hours);
                }
                calendarTime(driver, waitingTime, hours, minutes); // Sets the Hours
            } else {
                if (DEBUG) {
                    System.out.println("  Hours or Minutes are empty! ");
                }
            }


        }
        return concatenatedDate;
    }

    public static String calendarDate(WebDriver driver, long waitingTime, CustomCalendarDate date) {

        boolean DEBUG = false;

        WebDriverWait wait = new WebDriverWait(driver, waitingTime);

        CustomCalendarDate[] theLoop          = {date};
        String               concatenatedDate = "";
        for (CustomCalendarDate var : theLoop) {
//            body-of-loop
            Actions builder        = new Actions(driver);
            Action  mouseOverDay;
            byte    calendarNumber = 0;
            String  fromTime;


            String year;
            String month;
            String day;
            String hours;
            String minutes;


            year = var.getYear();
            month = var.getMonth();
            day = var.combineDate();
            hours = var.getHour();
            minutes = var.getMinute();

            if (DEBUG) {
                System.out.println("  Zero year: " + year);
                System.out.println(" Zero month: " + month);
                System.out.println("   Zero day: " + day);
                System.out.println("===============");
            }

            String dateChange          = "";
            String reportName          = getReportName(driver);
            String balanceConfirmation = "Balance Confirmation";

            if (!var.combineDate("-").equals("--1") && var == date) {

                if (reportName.equals(balanceConfirmation)) {
                    dateChange = "//*[@id='date']";

                } else {
                    dateChange = "";
                }

                if (DEBUG) {
                    System.out.println("------From Date------");
                }
//                calendarNumber = 1;   // value needed for the Calendar's xpath
                setFromOrToTimeDate("FROM");
            } else if (!var.combineDate("-").equals("--1") && var == date) {
                if (reportName.equals(balanceConfirmation) ) {
                    dateChange = "//*[@id='date']";

                } else {
                    dateChange = "";
                }

                if (DEBUG) {
                    System.out.println("------To Date------");
                }
                calendarNumber = 2; // value needed for the Calendar's xpath
                setFromOrToTimeDate("TO");

            } else {
                year = "";
                month = "";
                day = "1";
            }

            if ((!(year == null || year.isEmpty())) && (!(month == null || month.isEmpty())) && (!(day == null || day.isEmpty()))) {
//            if ((!fromDate.combineDate().equals("--1")) || (!toDate.combineDate().equals("--1"))) {
                if ((!var.combineDate("-").equals("--1"))) {
//                String calendarToChoose    = "//table[@class='DynarchCalendar-topCont'][" + calendarNumber + "]//div[contains(@class,'DynarchCalendar-focused')]";
                    String calendarOnFocus    = "//table[@class='DynarchCalendar-topCont' and (not(contains(@style,'display: none')))]//div[contains(@class,'DynarchCalendar-focused')]";
                    String clickOnYear        = calendarOnFocus + "//table[@class='DynarchCalendar-titleCont']//div[@dyc-type='title']";
                    String clickToChangeYear  = calendarOnFocus + "//div[@class='DynarchCalendar-menu']//input[@class='DynarchCalendar-menu-year']";
                    String clickToChooseMonth = calendarOnFocus + "//table[@class='DynarchCalendar-menu-mtable']//div[text()[normalize-space(.)='" + month + "']]";
//                    String clickToChooseDay   = calendarOnFocus + "//tbody//div[@class='DynarchCalendar-body']//div[@dyc-date='" + day + "']";
                    String clickToChooseDay = calendarOnFocus + "//div[@class='DynarchCalendar-body']//div[@dyc-date='" + day + "']";
//                String clickOnElementLabel = "//label[text()[normalize-space(.)='To date/time:']]";
                    String clickOnElementLabel = "//h1[@class='page_title']";


                    WebElement dateMenu = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dateChange)));
                    dateMenu.click();

                    WebElement theYear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(clickOnYear)));
                    theYear.click();

                    WebElement changeTheYear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(clickToChangeYear)));  // wait
                    changeTheYear.clear(); // sendKeys(Keys.chord(Keys.CONTROL, "a"));
                    changeTheYear.sendKeys(year);

                    WebElement selectMonth = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(clickToChooseMonth)));  // wait
                    selectMonth.click();

                    try {
                        Thread.sleep(600L);        // This time pause is essential as it turned out after 4 days of tryings
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    WebElement selectDayFire = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(clickToChooseDay)));  // wait

                    selectDayFire.click(); // this works with Chrome and with Firefox 11.05.2018

//                mouseOverDay = builder.click(selectDayFire).build();
//                mouseOverDay.perform();


                /*!!!!!!! As the click on the second date was not selecting the date this is a hack for Chrome
                (and as it turned out the best solution also for Firefox): !!!!!*/
                    driver.findElement(By.xpath(clickOnElementLabel)).click();

                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(clickToChooseDay)));  // wait

                    try {
                        Thread.sleep(500L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
            concatenatedDate = year + "-" + month + "-" + day;
            if (DEBUG) {
                System.out.println("concatenatedDate: " + concatenatedDate);
                System.out.format(" Year: %s Month: %s Day: %s \n", var.getYear(), var.getMonth(), var.getDay());
            }

            if ((!(hours == null || hours.isEmpty())) && (!(minutes == null || minutes.isEmpty()))) {
                if (DEBUG) {
                    System.out.println("  Hours are not null: " + hours);
                }
                calendarTime(driver, waitingTime, hours, minutes); // Sets the Hours
            } else {
                if (DEBUG) {
                    System.out.println("  Hours or Minutes are empty! ");
                }
            }


        }
        return concatenatedDate;
    }

    public static String getReportName(WebDriver driver) {

        String  reportHeader     = "//*[@id='main_content']/h1";
        Boolean isPresent        = driver.findElements(By.xpath(reportHeader)).size() > 0;
        String  reportHeaderName = driver.findElement(By.xpath(reportHeader)).getText();
        if (isPresent) {
            return reportHeaderName;

        } else {
            return "";
        }

    }

    public static void calendarVerifyFromDate(WebDriver browser, long waitingTime, CustomCalendarDate fromDate) {
        //@TODO
    }

    public static void calendarVerifyToDate(WebDriver browser, long waitingTime, CustomCalendarDate toDate) {
        //@TODO
    }

    public static void calendarVerifyFromDateTime(WebDriver browser, long waitingTime, CustomCalendarDate fromDate) {
        //@TODO
    }

    public static void calendarVerifyToDateTime(WebDriver browser, long waitingTime, CustomCalendarDate toDate) {
        //@TODO
    }


    //@TODO: finish the calendar date selection
//@TODO: finish the calendar date minute calculation


    private static String calendarTime(WebDriver driver, long waitingTime, String hour, String minutes) {
        boolean DEBUG      = false;
        String  timeChange = "";
        String  fromTime   = "FROM";
        String  toTime     = "TO";

        if (DEBUG) {
            System.out.println("  Zero hour: " + hour);
            System.out.println("Zero minute: " + minutes);
            System.out.println("===============");
        }


        String reportName              = getReportName(driver);
        String reportChargebacksReport = "Chargebacks Report";


        if (getFromOrToTimeDate().equals(fromTime)) {

            if (reportName.equals(reportChargebacksReport)) {
                timeChange = "//*[@id='timeFrom']/../div/i";
            } else {
                timeChange = "//*[@id='timeFrom']";
            }

            if (DEBUG) {
                System.out.println("------From Time------");
            }


        } else if (getFromOrToTimeDate().equals(toTime)) {
            if (reportName.equals(reportChargebacksReport)) {
                timeChange = "//*[@id='timeTo']/../div/i";
            } else {
                timeChange = "//*[@id='timeTo']";
            }

            if (DEBUG) {
                System.out.println("------To Time------");
            }


        } else {
            minutes = "99"; //Not possible digit for minutes
        }

//@TODO continue with the xpaths for the Time

        if ((!minutes.equals("99"))) {

            String clickOnElementLabel = "//label[text()[normalize-space(.)='To date/time:']]";

            WebDriverWait wait = new WebDriverWait(driver, waitingTime);

            WebElement dateMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(timeChange)));
            dateMenu.click();

// ================Setting the hours:
            setTime(driver, waitingTime, hour);

// ================Clicking on minutes:
            setMinutes(driver, waitingTime, minutes);

// ================Clicking on "From date/time" element to close the Date popup:

/*!!!!!!! As the click on the second date was not selecting the date this is a hack for Chrome
                (and as it turned out the best solution also for Firefox): !!!!!*/
            driver.findElement(By.xpath(clickOnElementLabel)).click();

            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        String concatenatedTime = hour + ":" + minutes;
        System.out.println("concatenatedTime: " + concatenatedTime);

//        }
        return concatenatedTime;
    }


    private static void setTime(WebDriver driver, long waitingTime, String timeExpected) {

        boolean DEBUG = false;

        String calendarTimeOnFocus = "//table[@class='DynarchCalendar-topCont' and (not(contains(@style,'display: none')))]//tbody//div[@class='DynarchCalendar-bottomBar']//table[@class='DynarchCalendar-time']";
        String timeDigits          = calendarTimeOnFocus + "//div[@class='DynarchCalendar-time-hour']";
        String timeArrowUP         = calendarTimeOnFocus + "//td[@dyc-type='time-hour+']";
        String timeArrowDown       = calendarTimeOnFocus + "//td[@dyc-type='time-hour-']";

        WebDriverWait wait = new WebDriverWait(driver, waitingTime);

        WebElement theTime     = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(timeDigits)));
        String     timeCurrent = theTime.getText();

        String whichArrow;
        String arrowDown  = "DOWN";
        String arrowUp    = "UP";
        int    timeCurr   = Integer.valueOf(timeCurrent);
        int    timeExp    = Integer.valueOf(timeExpected);
        int    numberOfClicks;
        int    hoursInDay = 24;

//Curr:   [00] 01 02 03 04 05 06 07 08 09 10 [11] 12 13 14 15 16 17 18 19 20 21 22 23
//Curr:   14 15 16 17 16 19 20 21 22 23 [00] 1 2 3 4 5 6 7 8 9 10 11 12 13
//Expec:  00 01 02 03 04 05 06 07 08 09 10 11 12 13 [14] 15 16 17 18 19 20 21 22 23

//         timeCurr = 23; // 11 - (0 + 6) = 5 down > | 23 - 5 = 19 up
//         timeExp = 20;  // 0 - (0 + 20) = -20 up < | 23 -20 + 1 = 4 down
        if (DEBUG) {
            System.out.println("   Time Now: " + timeCurr);
            System.out.println("Time Wanted: " + timeExp);
        }
//============= Calculating how many minimum clicks and which arrow to press:
        int clicksDown;
        int clicksUP;
        if (timeCurr < timeExp) {
            numberOfClicks = timeCurr - timeExp;
            clicksUP = Math.abs(numberOfClicks);
            clicksDown = Math.abs(hoursInDay + (numberOfClicks));

            if (DEBUG) {
                System.out.println("Clicks DOWN count : " + clicksDown);
                System.out.println("  Clicks UP count : " + clicksUP);
            }

            if (clicksDown < clicksUP) {
                whichArrow = arrowDown;
                numberOfClicks = clicksDown;
                if (DEBUG) {
                    System.out.println("Which arrow to click: " + whichArrow);
                    System.out.println("     How many clicks: " + numberOfClicks);
                }

            } else {
                whichArrow = arrowUp;
                numberOfClicks = clicksUP;
                if (DEBUG) {
                    System.out.println("Which arrow to click: " + whichArrow);
                    System.out.println("     How many clicks: " + numberOfClicks);
                }
            }

        } else {
            numberOfClicks = timeCurr - timeExp;
            clicksDown = Math.abs(numberOfClicks);
            clicksUP = Math.abs(hoursInDay - (numberOfClicks));
            if (DEBUG) {
                System.out.println("   Clicks DOWN count: " + clicksDown);
                System.out.println("     Clicks UP count: " + clicksUP);
            }

            if (clicksDown < clicksUP) {
                whichArrow = arrowDown;
                numberOfClicks = clicksDown;
                if (DEBUG) {
                    System.out.println("Which arrow to click: " + whichArrow);
                    System.out.println("     How many clicks: " + numberOfClicks);
                }

            } else {
                whichArrow = arrowUp;
                numberOfClicks = clicksUP;
                if (DEBUG) {
                    System.out.println("Which arrow to click: " + whichArrow);
                    System.out.println("     How many clicks: " + numberOfClicks);
                }
            }

        }

//============== Setting the Time:
        WebElement time_ArrowUP   = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(timeArrowUP)));
        WebElement time_ArrowDOWN = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(timeArrowDown)));

        String arrowDirection  = whichArrow;
        int    timeClickNumber = numberOfClicks;

        for (int a = 0; a < timeClickNumber; a++) {
            if (arrowDirection.equals(arrowUp)) {
                time_ArrowUP.click();
            } else {
                time_ArrowDOWN.click();
            }

        }

        try {
            Thread.sleep(200L);        // Putting some pause
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void setMinutes(WebDriver driver, long waitingTime, String minutesExpected) {
        boolean DEBUG = false;

        String calendarTimeOnFocus = "//table[@class='DynarchCalendar-topCont' and (not(contains(@style,'display: none')))]//tbody//div[@class='DynarchCalendar-bottomBar']//table[@class='DynarchCalendar-time']";
        String minutesDigit        = calendarTimeOnFocus + "//div[@class='DynarchCalendar-time-minute']";
        String minutesArrowUP      = calendarTimeOnFocus + "//td[@dyc-type='time-min+']";
        String minutesArrowDown    = calendarTimeOnFocus + "//td[@dyc-type='time-min-']";
        String minutesOnCalendar   = calendarTimeOnFocus + "//tr/td/div[@dyc-type='time-min']";

        WebDriverWait wait = new WebDriverWait(driver, waitingTime);

        WebElement theMinutes     = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(minutesDigit)));
        String     currentMinutes = theMinutes.getText();


        String whichArrow;
        String fromDateTime = "FROM";

//============= Calculating how many minimum clicks and which arrow to press:
        String arrowDown  = "DOWN";
        String arrowUp    = "UP";
        int    minsCurr   = Integer.valueOf(currentMinutes);
        int    minsExp    = Integer.valueOf(minutesExpected);
        int    numberOfClicks;
        int    minsInHour = 60;

        int differencebetweenClicks = getMinutesDifference(driver, waitingTime);
//        double minsInjump = 5;
        double minsInjump = (double) differencebetweenClicks;
        int    now;

        if (minutesFromOrTo(minsCurr).equals(fromDateTime)) {
            now = (int) Math.ceil(minsCurr / minsInjump); // 11 - (0 + 6) = 5 down > | 23 - 5 = 19 up
        } else {
            now = (int) Math.floor(minsCurr / minsInjump); // 11 - (0 + 6) = 5 down > | 23 - 5 = 19 up
        }

        // 0 - (0 + 20) = -20 up < | 23 -20 + 1 = 4 down
        int expected = (int) Math.floor(minsExp / minsInjump);
        if (DEBUG) {
            System.out.println("     Now: " + now);
            System.out.println("Expected: " + expected);
        }

        int mins = (int) Math.floor(minsInHour / minsInjump);
        if (DEBUG) {
            System.out.println("minsInHour: " + mins);
        }

        int clicksDown;
        int clicksUP;
        if (now < expected) {
            numberOfClicks = now - expected;
            clicksUP = Math.abs(numberOfClicks);
            clicksDown = Math.abs(mins + (numberOfClicks));
            if (DEBUG) {
                System.out.println("clicksDown: " + clicksDown);
                System.out.println("  clicksUP: " + clicksUP);
            }

            if (clicksDown < clicksUP) {
                whichArrow = arrowDown;
                numberOfClicks = clicksDown;
                if (DEBUG) {
                    System.out.println(" Where: " + whichArrow);
                    System.out.println("result: " + numberOfClicks);
                }

            } else {
                whichArrow = arrowUp;
                numberOfClicks = clicksUP;
                if (DEBUG) {
                    System.out.println(" Where: " + whichArrow);
                    System.out.println("result: " + numberOfClicks);
                }
            }

        } else {
            numberOfClicks = now - expected;
            clicksDown = Math.abs(numberOfClicks);
            clicksUP = Math.abs(mins - (numberOfClicks));
            if (DEBUG) {
                System.out.println("clicksDown: " + clicksDown);
                System.out.println("  clicksUP: " + clicksUP);
            }

            if (clicksDown < clicksUP) {
                whichArrow = arrowDown;
                numberOfClicks = clicksDown;
                if (DEBUG) {
                    System.out.println(" Where: " + whichArrow);
                    System.out.println("result: " + numberOfClicks);
                }

            } else {
                whichArrow = arrowUp;
                numberOfClicks = clicksUP;
                if (DEBUG) {
                    System.out.println(" Where: " + whichArrow);
                    System.out.println("result: " + numberOfClicks);
                }
            }

        }

//============== Setting the Minutes:

        WebElement minute_ArrowUP = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(minutesArrowUP)));

        WebElement minute_ArrowDOWN = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(minutesArrowDown)));

        String arrowDirection     = whichArrow;
        int    minutesClickNumber = numberOfClicks;

        for (int a = 0; a < minutesClickNumber; a++) {
            if (arrowDirection.equals(arrowUp)) {
                minute_ArrowUP.click();
            } else {
                minute_ArrowDOWN.click();
            }

        }

        try {
            Thread.sleep(200L);        // Putting some pause
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static String minutesFromOrTo(int minutesCurrent) {
        String calendarToOrFrom = "";
        String from             = "FROM";

        if (minutesCurrent % 5 == 0) {
            calendarToOrFrom = from;
        }

        return calendarToOrFrom;
    }


    private static int getMinutesDifference(WebDriver driver, long waitingTime) {

        String calendarTimeOnFocus = "//table[@class='DynarchCalendar-topCont' and (not(contains(@style,'display: none')))]//tbody//div[@class='DynarchCalendar-bottomBar']//table[@class='DynarchCalendar-time']";
        String minutesArrowUP      = calendarTimeOnFocus + "//td[@dyc-type='time-min+']";
        String minutesArrowDown    = calendarTimeOnFocus + "//td[@dyc-type='time-min-']";
        String minutesOnCalendar   = calendarTimeOnFocus + "//tr/td/div[@dyc-type='time-min']";

        WebDriverWait wait = new WebDriverWait(driver, waitingTime);

        WebElement minute_ArrowUP = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(minutesArrowUP)));

        WebElement minute_ArrowDOWN = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(minutesArrowDown)));

        WebElement minutes;
        String     minutesBeforeClicks = "";
        String     minutesAfterClicks  = "";
        int        minutesClickNumber  = 3;
        for (int a = 0; a < minutesClickNumber; a++) {
            if (a == 0) {
                minute_ArrowUP.click();
            } else if (a == 1) {
                minutes = driver.findElement(By.xpath(minutesOnCalendar));
                minutesBeforeClicks = minutes.getText();
                minute_ArrowUP.click();
                minutes = driver.findElement(By.xpath(minutesOnCalendar));
                minutesAfterClicks = minutes.getText();
            } else {
                minute_ArrowDOWN.click();
                minute_ArrowDOWN.click();
            }
        }

        int minDiff = Integer.parseInt(minutesAfterClicks) - Integer.parseInt(minutesBeforeClicks);
        return minDiff;
    }

}
