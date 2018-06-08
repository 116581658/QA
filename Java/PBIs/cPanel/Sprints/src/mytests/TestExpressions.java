package mytests;

public class TestExpressions {


    public static void main(String[] args) {

/*  */
        int    x   = 2;
        int    y   = 23;
        int    z1  = (int) Math.ceil((double) x / (double) y);
        double z2  = Math.ceil((double) x / (double) y);
        double z3  = Math.ceil((double) x / (double) y);
        int    z3_ = (int) Math.floor((double) x / (double) y);
        double z4  = (double) x / (double) y;
        int    z5  = x % y;
        double z6  = Math.floor((double) 845.2);


        System.out.println("z1: " + z1);
        System.out.println("z2: " + z2);
        System.out.println("z3: " + z3);
        System.out.println("z3_: " + z3_);
        System.out.println("z4: " + z4);
        System.out.println("z5: " + z5);
        System.out.println("z6: " + z6);

        double zj = Math.ceil((double) x / (double) y);
        System.out.println("zj: " + zj);

        String[] dayName   = {"5.56", "0105"};
        int      theMinute = -1;
        try {
            theMinute = Integer.parseInt(dayName[0]);
            System.out.println(theMinute);
        } catch (Throwable t) {
            int charColumn = t.getMessage().indexOf(':');
            System.out.println(t.getMessage().substring(charColumn + 1));
            int    errFirstColumn = t.toString().indexOf(':');
            String errSubstr      = t.toString().substring(0, errFirstColumn);
            int    theLastDot     = errSubstr.lastIndexOf('.') + 1;
            System.out.println("      HERE: " + errSubstr.substring(theLastDot));

        }



/*
        MyCustomDate   fromDate = new MyCustomDate("2016", "Apr", "12", "", "");
        MyCustomDate   toDate   = new MyCustomDate("2017", "Apr", "11", "", "");
        MyCustomDate[] theLoop  = {fromDate, toDate};
        for (MyCustomDate var : theLoop) {
            if (var == fromDate) {
//                fromDate = new MyCustomDate();
                System.out.format("FromDate: " + fromDate + "\n");
                System.out.format("Var: " + var + " Y:%s M:%s D:%s \n", fromDate.getYear(), fromDate.getMonth(), fromDate.getDay());
            }
        }
*/



    }







}
