package misc;

public class MyCustomDate {

    private String year;
    private String month;
    private String day;
    private String hour;
    private String minute;

    public MyCustomDate() {
        this.year = "";
        this.month = "";
        this.day = "1";
    }

    public MyCustomDate(String year, String month, String day) {

        this.year = setFromYear(year);
        this.month = setFromMonth(month)[0];
        this.day = setFromDay(day)[0];

        System.out.println(" this.year: " + this.year);
        System.out.println("this.month: " + this.month);
        System.out.println("  this.day: " + this.day);

    }

    public MyCustomDate(String year, String month, String day, String hour, String minute) {

        this.year = setFromYear(year);
        this.month = setFromMonth(month)[0];
        this.day = setFromDay(day)[0];
        this.hour = setFromHour(hour)[1];
        this.minute = setFromMinute(minute)[1];

        System.out.println("   this.year: " + this.year);
        System.out.println("  this.month: " + this.month);
        System.out.println("    this.day: " + this.day);
        System.out.println("   this.hour: " + this.hour);
        System.out.println(" this.minute: " + this.minute);

    }

    private String setFromYear(String year) {
        String yr = year;
        if (yr.length() != 4) {
            System.out.println("Invalid Year format!");
            return "";
        } else {
            return yr;
        }
    }

    private String[] monthName = new String[2];

    private String[] setFromMonth(String month) {

        if (month.length() > 3) {
            month = month.substring(0, 3);
        }

        switch (month) {
            case "1": case "01": case "Jan":
                monthName[0] = "Jan";
                monthName[1] = "01";
                break;
            case "2": case "02": case "Feb":
                monthName[0] = "Feb";
                monthName[1] = "02";
                break;
            case "3": case "03": case "Mar":
                monthName[0] = "Mar";
                monthName[1] = "03";
                break;
            case "4": case "04": case "Apr":
                monthName[0] = "Apr";
                monthName[1] = "04";
                break;
            case "5": case "05": case "May":
                monthName[0] = "May";
                monthName[1] = "05";
                break;
            case "6": case "06": case "Jun":
                monthName[0] = "Jun";
                monthName[1] = "06";
                break;
            case "7": case "07": case "Jul":
                monthName[0] = "Jul";
                monthName[1] = "07";
                break;
            case "8": case "08": case "Aug":
                monthName[0] = "Aug";
                monthName[1] = "08";
                break;
            case "9": case "09": case "Sep":
                monthName[0] = "Sep";
                monthName[1] = "09";
                break;
            case "10": case "Oct":
                monthName[0] = "Oct";
                monthName[1] = "10";
                break;
            case "11": case "Nov":
                monthName[0] = "Nov";
                monthName[1] = "11";
                break;
            case "12": case "Dec":
                monthName[0] = "Dec";
                monthName[1] = "12";
                break;
            default:
                System.out.println("Invalid month.");
                break;
        }
        return monthName;
    }

    private String[] dayName = new String[2];

    private String[] setFromDay(String day) {

        switch (day) {
            case "":
                dayName[0] = "";
                dayName[1] = "";
                break;
            case "1": case "01":
                dayName[0] = "1";
                dayName[1] = "01";
                break;
            case "2": case "02":
                dayName[0] = "2";
                dayName[1] = "02";
                break;
            case "3": case "03":
                dayName[0] = "3";
                dayName[1] = "03";
                break;
            case "4": case "04":
                dayName[0] = "4";
                dayName[1] = "04";
                break;
            case "5": case "05":
                dayName[0] = "5";
                dayName[1] = "05";
                break;
            case "6": case "06":
                dayName[0] = "6";
                dayName[1] = "06";
                break;
            case "7": case "07":
                dayName[0] = "7";
                dayName[1] = "07";
                break;
            case "8": case "08":
                dayName[0] = "8";
                dayName[1] = "08";
                break;
            case "9": case "09":
                dayName[0] = "9";
                dayName[1] = "09";
                break;
            default:
                dayName[0] = day;
                dayName[1] = day;
                break;
        }

        for (int j = 0; j < dayName.length; j++) {
            int theDay = Integer.parseInt(dayName[j]);
            if (theDay > 31 || theDay < 1) {
                System.out.format("Invalid day: %d ", theDay);
                dayName[j] = "";
            }

        }
        return dayName;

    }

    private String[] hourName = new String[2];

    private String[] setFromHour(String hour) {

        switch (hour) {
            case "":
                hourName[0] = "";
                hourName[1] = "";
                break;
            case "0": case "00":
                hourName[0] = "0";
                hourName[1] = "00";
                break;
            case "1": case "01":
                hourName[0] = "1";
                hourName[1] = "01";
                break;
            case "2": case "02":
                hourName[0] = "2";
                hourName[1] = "02";
                break;
            case "3": case "03":
                hourName[0] = "3";
                hourName[1] = "03";
                break;
            case "4": case "04":
                hourName[0] = "4";
                hourName[1] = "04";
                break;
            case "5": case "05":
                hourName[0] = "5";
                hourName[1] = "05";
                break;
            case "6": case "06":
                hourName[0] = "6";
                hourName[1] = "06";
                break;
            case "7": case "07":
                hourName[0] = "7";
                hourName[1] = "07";
                break;
            case "8": case "08":
                hourName[0] = "8";
                hourName[1] = "08";
                break;
            case "9": case "09":
                hourName[0] = "9";
                hourName[1] = "09";
                break;
            default:
                hourName[0] = hour;
                hourName[1] = hour;
                break;
        }

        for (int j = 0; j < hourName.length; j++) {

            int theHour;
            try {
                theHour = Integer.parseInt(hourName[j]);
                if (theHour > 23 || theHour < 0) {
                    System.out.format("Invalid hour: %d. Should be in [00 - 23] interval.\n", theHour);
                    hourName[j] = "";
                } else {
                    System.out.println(theHour);

                }
            } catch (Throwable t) {
                int    charColumn     = t.getMessage().indexOf(':');
                String theTrResult    = t.getMessage().substring(charColumn + 2);
                int    errFirstColumn = t.toString().indexOf(':');
                String errSubstr      = t.toString().substring(0, errFirstColumn);
                int    theLastDot     = errSubstr.lastIndexOf('.') + 1;
                System.out.print("ERROR: " + errSubstr.substring(theLastDot) + " for Hour format: " + theTrResult);
                System.out.format(". Should be Integer value and in [00 - 23] interval \n");
                System.out.println("----------------");
                hourName[j] = "";

            }
        }
        return hourName;

    }

    private String[] minuteName = new String[2];

    private String[] setFromMinute(String minute) {

        switch (minute) {
            case "":
                minuteName[0] = "";
                minuteName[1] = "";
                break;
            case "0": case "00":
                minuteName[0] = "0";
                minuteName[1] = "00";
                break;
            case "1": case "01":
                minuteName[0] = "1";
                minuteName[1] = "01";
                break;
            case "2": case "02":
                minuteName[0] = "2";
                minuteName[1] = "02";
                break;
            case "3": case "03":
                minuteName[0] = "3";
                minuteName[1] = "03";
                break;
            case "4": case "04":
                minuteName[0] = "4";
                minuteName[1] = "04";
                break;
            case "5": case "05":
                minuteName[0] = "5";
                minuteName[1] = "05";
                break;
            case "6": case "06":
                minuteName[0] = "6";
                minuteName[1] = "06";
                break;
            case "7": case "07":
                minuteName[0] = "7";
                minuteName[1] = "07";
                break;
            case "8": case "08":
                minuteName[0] = "8";
                minuteName[1] = "08";
                break;
            case "9": case "09":
                minuteName[0] = "9";
                minuteName[1] = "09";
                break;
            default:
                minuteName[0] = minute;
                minuteName[1] = minute;
                break;
        }
        for (int j = 0; j < minuteName.length; j++) {
            int theMinute;
            try {
                theMinute = Integer.parseInt(minuteName[j]);
                if (theMinute > 59 || theMinute < 0) {
                    System.out.format("Invalid minute: %d. Should be in [00 - 59] interval.\n", theMinute);
                    minuteName[j] = "";
                } else {
                    System.out.println(theMinute);
                }
            } catch (Throwable t) {
                int    charColumn     = t.getMessage().indexOf(':');
                String theTrResult    = t.getMessage().substring(charColumn + 2);
                int    errFirstColumn = t.toString().indexOf(':');
                String errSubstr      = t.toString().substring(0, errFirstColumn);
                int    theLastDot     = errSubstr.lastIndexOf('.') + 1;
                System.out.print("ERROR: " + errSubstr.substring(theLastDot) + " for Minute format: " + theTrResult);
                System.out.format(". Should be Integer and in [00 - 59] interval \n");
                System.out.println("----------------");
                minuteName[j] = "";

            }
        }


        return minuteName;

    }

    public String getYear() {
        return this.year;
    }

    public String getMonth() {
        return this.month;
    }

    public String getDay() {
        return this.day;
    }

    public String getHour() {
        return this.hour;
    }

    public String getMinute() {
        return this.minute;
    }

    public String combineDate(String symbol) {
        return year + symbol + monthName[0] + symbol + dayName[0];
    }

    public String combineDate() {
        return year + monthName[1] + dayName[1];
    }


}
