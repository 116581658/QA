package misc;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateCalculations {

    private String Year;
    private String Month;
    private String Day;

    public void setYear() {
        String[] dateAndTime = getDateAndTime().split(" ");
        Year = dateAndTime[0];
    }

    public void setMonth() {
        String[] dateAndTime = getDateAndTime().split(" ");
        Month = dateAndTime[1];
    }

    public void setDay() {
        String[] dateAndTime = getDateAndTime().split(" ");
        Day = dateAndTime[2];
    }


    public static String getDate(int Years, int Months, int Days) {

        String   currentDate = "";
        Calendar cal         = Calendar.getInstance();   // GregorianCalendar

        // An Easier way to print the timestamp by getting a Date instance
        Date date = cal.getTime();
        System.out.println("Current date and time in Date's toString() is : " + date + "\n");

        Calendar calTemp;
        calTemp = (Calendar) cal.clone();
        calTemp.add(Calendar.YEAR, Years);
        calTemp.add(Calendar.MONTH, Months);
        calTemp.add(Calendar.DAY_OF_YEAR, Days);
        date = calTemp.getTime();       // Converting Calendar type to Date type in order to format the date
        System.out.println("Converted: " + calTemp.getTime());
//            SimpleDateFormat simpleFormatter = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
//            System.out.println("Formatting the Calendar v1: " + simpleFormatter.format(date));

        SimpleDateFormat simpleFormatter2 = new SimpleDateFormat("yyyy MM dd");
        currentDate = simpleFormatter2.format(date);
        System.out.println("Formatting the Calendar v2: " + currentDate);

        return currentDate;

    }


    public static String getDateAndTime(int Years, int Months, int Days, int Hours, int Minutes, int Seconds) {

        String   currentDate = "";
        Calendar cal         = Calendar.getInstance();   // GregorianCalendar

        // An Easier way to print the timestamp by getting a Date instance
        Date date = cal.getTime();
        System.out.println("Current date and time in Date's toString() is : " + date + "\n");

        Calendar calTemp;
        calTemp = (Calendar) cal.clone();
        calTemp.add(Calendar.YEAR, Years);
        calTemp.add(Calendar.MONTH, Months);
        calTemp.add(Calendar.DAY_OF_YEAR, Days);
        calTemp.add(Calendar.HOUR_OF_DAY, Hours);
        calTemp.add(Calendar.MINUTE, Minutes);
        calTemp.add(Calendar.SECOND, Seconds);

        System.out.println("Hour of the Day : " + cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("Minute : " + cal.get(Calendar.MINUTE));
        System.out.println("Second : " + cal.get(Calendar.SECOND));


        date = calTemp.getTime();       // Converting Calendar type to Date type in order to format the date
        System.out.println("Converted: " + calTemp.getTime());
//            SimpleDateFormat simpleFormatter = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
//            System.out.println("Formatting the Calendar v1: " + simpleFormatter.format(date));

        SimpleDateFormat simpleFormatter2 = new SimpleDateFormat("yyyy MM dd hh mm ss");
        currentDate = simpleFormatter2.format(date);
        System.out.println("Formatting the Calendar v2: " + currentDate);

        return currentDate;

    }

    public static String getDateAndTime() {

        String   currentDate = "";
        Calendar cal         = Calendar.getInstance();   // GregorianCalendar

        // An Easier way to print the timestamp by getting a Date instance
        Date date = cal.getTime();
//        System.out.println("Current date and time in Date's toString() is : " + date + "\n");
//
//        Calendar calTemp;
//        calTemp = (Calendar) cal.clone();
//        calTemp.add(Calendar.YEAR, 0);
//        calTemp.add(Calendar.MONTH, 0);
//        calTemp.add(Calendar.DAY_OF_YEAR, 0);
//        calTemp.add(Calendar.HOUR_OF_DAY, 0);
//        calTemp.add(Calendar.MINUTE, 0);
//        calTemp.add(Calendar.SECOND, 0);
//
//        System.out.println("Hour of the Day : " + cal.get(Calendar.HOUR_OF_DAY));
//        System.out.println("Minute : " + cal.get(Calendar.MINUTE));
//        System.out.println("Second : " + cal.get(Calendar.SECOND));
//
//
//        date = calTemp.getTime();       // Converting Calendar type to Date type in order to format the date
//        System.out.println("Converted: " + calTemp.getTime());
//            SimpleDateFormat simpleFormatter = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
//            System.out.println("Formatting the Calendar v1: " + simpleFormatter.format(date));

        SimpleDateFormat simpleFormatter2 = new SimpleDateFormat("yyyy MM dd hh mm ss");
        currentDate = simpleFormatter2.format(date);
//        System.out.println("Formatting the Calendar v2: " + currentDate);

        return currentDate;

    }


}
