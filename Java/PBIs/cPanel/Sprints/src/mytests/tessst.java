package mytests;

import com.google.gson.JsonArray;
import org.openqa.selenium.json.Json;

import java.util.HashMap;
import java.util.Map;

public class tessst {
    public static void main(String[] args) {


        Map<String, String[]> reportContents      = new HashMap<String, String[]>();
        String                reportsMenu         = "Reports";
        String                aquiringReportsMenu = "Acquiring Reports";

        String[] reports_oper_trans = new String[]{"Operational Reports", "Transaction Search"};
        String[] reports_fin_bal    = new String[]{"Financial Reports", "Balance"};
        String[] reports_fin_ven    = new String[]{"Financial Reports", "Vendor Report"};
        String[] reports_fin_move   = new String[]{"Financial Reports", "Movement Search"};
        String[] reports_fin_pay    = new String[]{"Financial Reports", "Payout History"};
        String[] reports_mar_conv   = new String[]{"Marketing Reports", "Conversion rates"};

        String[] acquiring_fin_bal = new String[]{"Financial Reports", "Balance Report"};
        String[] acquiring_fin_acq = new String[]{"Financial Reports", "Acquiring Service Fee and interchange cost"};
        String[] acquiring_ris_fra = new String[]{"Risk Reports", "Fraud transactions report"};


        reportContents.put(reportsMenu, reports_oper_trans);
        reportContents.put(reportsMenu, reports_fin_bal);
        reportContents.put(reportsMenu, reports_fin_ven);
        reportContents.put(reportsMenu, reports_fin_move);
        reportContents.put(reportsMenu, reports_fin_pay);
        reportContents.put(reportsMenu, reports_mar_conv);

        reportContents.put(aquiringReportsMenu, acquiring_fin_bal);
        reportContents.put(aquiringReportsMenu, acquiring_fin_acq);
        reportContents.put(aquiringReportsMenu, acquiring_ris_fra);

        String report    = "";
        String subMenu   = "";
        String finalMenu = "";
//        if ("Reports".equals(reportContents.keySet())) {
        String result="";
        for (Map.Entry<String, String[]> entry : reportContents.entrySet()) {
            if ("Reports".equals(entry.getKey())) {
                result = entry.getKey();
                System.out.println(result);
            }
        }
       int reportsss = reportContents.get(result).length;
       String reportss = reportContents.get(result)[0];
       String reports = reportContents.get(result)[1];

        System.out.println(reportsss);
        System.out.println(reportss);
        System.out.println(reports);

//            System.out.println(reportContents.get("Reports"));
//        System.out.println(reportContents.values() );
//
//            for(String key : reportContents.containsKey("Reports")){
//                if(reportContents.get(key).equals("Reports")){
//                    report = reportContents.get(key)[1]; //return the first found
//                    System.out.println(report);
//                }
//            }

//            report = reportContents.get(reportsMenu);
//            subMenu = reportContents.get(report)[1];
//            System.out.println(subMenu);
//            finalMenu = reportContents.get(report)[2];
//            System.out.println(finalMenu);

//        }


    }
}
