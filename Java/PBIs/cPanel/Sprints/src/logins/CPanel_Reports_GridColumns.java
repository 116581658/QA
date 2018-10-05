package logins;

import org.openqa.selenium.WebDriver;

public class CPanel_Reports_GridColumns {


    public static String setGridColumns(WebDriver driver, long waitingTime, Integer report, String[][]... values) {
        String btn_GridColumns = "Grid Columns";
//        CPanel_reports_Search_RunReport.pressReportButton(driver,2000,report,btn_GridColumns);

        for (String[][] v : values) {
            for (String[] k : v) {
                System.out.println(k[0]);
                System.out.println(k[1]);
            }

        }

        return "";


    }
}
