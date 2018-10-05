package logins;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class CProfile_Main_Menus {


    public enum MenuTitles {
        HOME("Home"),
        USERS("Users"),
        ROLES("Roles"),
        MERCHANTS("Merchants"),
        IPWHITELIST("IP Whitelist"),
        PPPREPORTER("PPP Reporter"),
        TRANSACTIONSEARCH("Transaction Search"),
        WITHDRAWALEDIT("Withdrawal Edit"),
        SUPPORT("Support");

        private String value;

        MenuTitles(String v) {
            value = v;
        }

        public String getValue() {
            return value;
        }
    }

    public enum MenuHome {
        HOME("Home");

        private String value;

        MenuHome(String v) {
            value = v;
        }

        public String getValue() {
            return value;
        }
    }

    public enum MenuUsers {
        USERS("Users");


        private String value;

        MenuUsers(String v) {
            value = v;
        }

        public String getValue() {
            return value;
        }
    }

    public enum MenuRoles {

        ROLES("Roles");


        private String value;

        MenuRoles(String v) {
            value = v;
        }

        public String getValue() {
            return value;
        }
    }

    public enum MenuMerchants {

        MERCHANTS("Merchants");


        private String value;

        MenuMerchants(String v) {
            value = v;
        }

        public String getValue() {
            return value;
        }
    }

    public enum MenuIPWhiteList {
        IPWHITELIST("IP Whitelist");

        private String value;

        MenuIPWhiteList(String v) {
            value = v;
        }

        public String getValue() {
            return value;
        }
    }

    public enum MenuPPPReporter {
        PPPREPORTER("PPP Reporter");

        private String value;

        MenuPPPReporter(String v) {
            value = v;
        }

        public String getValue() {
            return value;
        }
    }

    public enum MenuTransactionSearch {
        TRANSACTIONSEARCH("Transaction Search");

        private String value;

        MenuTransactionSearch(String v) {
            value = v;
        }

        public String getValue() {
            return value;
        }
    }

    public enum MenuWithdrwal {
        WITHDRAWALEDIT("Withdrawal Edit");

        private String value;

        MenuWithdrwal(String v) {
            value = v;
        }

        public String getValue() {
            return value;
        }
    }

    public enum MenuSupport {
        SUPPORT("Support");

        private String value;

        MenuSupport(String v) {
            value = v;
        }

        public String getValue() {
            return value;
        }
    }


    public enum MenuSubUsers {
        CPANELUSERS("Cpanel Users"),
        CPROFLLEUSERS("CProflle Users"),
        USERHISTORY("User History");

        MenuSubUsers(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }

    public enum MenuSubRoles {
        CPANELROLES("Cpanel Roles"),
        CPROFILEROLES("Cprofile Roles");

        MenuSubRoles(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }

    public enum MenuSubPPPReporter {
        RESTAPIACTIVITY("REST API Activity");

        MenuSubPPPReporter(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }

    public enum MenuSubSupport {
        CPANELDOCUMENTS("Cpanel Documents"),
        CPANELTHEMES("Cpanel Themes"),
        CPANELNOTIFICATIONS("Cpanel Notifications"),
        CPANELOPTIONS("Cpanel Options"),
        CPANELLOGS("Cpanel Logs");

        MenuSubSupport(String v) {
            value = v;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }


    public static class Menus {
        private String menu;
        private String subMenu;

        public String getMenu() {
            return menu;
        }

        private void setMenu(String menu) {
            this.menu = menu;
        }

        public String getSubMenu() {
            return subMenu;
        }

        private void setSubMenu(String subMenu) {
            this.subMenu = subMenu;
        }

        public Menus(MenuHome menu) {
            setMenu(menu.getValue());
            setSubMenu("");
        }

        public Menus(MenuUsers menu, MenuSubUsers subMenu) {
            setMenu(menu.getValue());
            setSubMenu(subMenu.getValue());
        }

        public Menus(MenuRoles menu, MenuSubRoles subMenu) {
            setMenu(menu.getValue());
            setSubMenu(subMenu.getValue());
        }

        public Menus(MenuMerchants menu) {
            setMenu(menu.getValue());
            setSubMenu("");
        }

        public Menus(MenuIPWhiteList menu) {
            setMenu(menu.getValue());
            setSubMenu("");

        }

        public Menus(MenuPPPReporter menu, MenuSubPPPReporter subMenu) {
            setMenu(menu.getValue());
            setSubMenu(subMenu.getValue());
        }

        public Menus(MenuTransactionSearch menu) {
            setMenu(menu.getValue());
            setSubMenu("");
        }

        public Menus(MenuWithdrwal menu) {
            setMenu(menu.getValue());
            setSubMenu("");
        }

        public Menus(MenuSupport menu, MenuSubSupport subMenu) {
            setMenu(menu.getValue());
            setSubMenu(subMenu.getValue());
        }


        private static final Map<String, Map<String, String>> test2 = createMap();

        private static Map<String, Map<String, String>> createMap() {
            Map<String, Map<String, String>> test1 = new HashMap<>();
            test1.put(MenuTitles.HOME.getValue(), new HashMap<String, String>() {{
                put("1", "Dashboard");
            }});
            test1.put(MenuTitles.USERS.getValue(), new HashMap<String, String>() {{
                put("Cpanel Users", "Cpanel Users");
                put("CProflle Users", "Cprofile Users");
                put("User History", "Cprofile User History");
            }});
            test1.put(MenuTitles.ROLES.getValue(), new HashMap<String, String>() {{
                put("Cpanel Roles", "Cpanel Roles");
                put("Cprofile Roles", "Cprofile Roles");
            }});
            test1.put(MenuTitles.MERCHANTS.getValue(), new HashMap<String, String>() {{
                put("1", "Merchants");
            }});
            test1.put(MenuTitles.IPWHITELIST.getValue(), new HashMap<String, String>() {{
                put("1", "Whitelist IPs");
            }});
            test1.put(MenuTitles.PPPREPORTER.getValue(), new HashMap<String, String>() {{
                put("REST API Activity", "REST API Activity");
            }});
            test1.put(MenuTitles.TRANSACTIONSEARCH.getValue(), new HashMap<String, String>() {{
                put("1", "Transactions");

            }});
            test1.put(MenuTitles.WITHDRAWALEDIT.getValue(), new HashMap<String, String>() {{
                put("1", "Withdrawal Edit");

            }});
            test1.put(MenuTitles.SUPPORT.getValue(), new HashMap<String, String>() {{
                put("Cpanel Documents", "Tech documentation");
                put("Cpanel Themes", "Cpanel Themes");
                put("Cpanel Notifications", "Cpanel Notifications");
                put("Cpanel Options", "Cpanel Options");
                put("Cpanel Logs", "Cpanel Logs");
            }});

            return test1;
        }

        public String getSubMenusHeaders() {

            String result;

//            System.out.println("   Menu: " + getMenu());
//            System.out.println("SubMenu: " + getSubMenu());

            if (getSubMenu().equals("")) {
                setSubMenu("1");
            }
            result = test2.get(getMenu()).get(getSubMenu());

            return result;
        }


    }


//    public static LinkedHashMap<String, LinkedHashMap<String,String >> grade = new LinkedHashMap<>();


    //    mymap.get("key").put("key2", "val2");


//
//
//
//
//
//
//
//


//    public static void doSomeTest(WebDriver config, String key) throws InterruptedException {
//
////        for (Map.Entry<String, String> entry : mymap) {
////            logInToCProf_Page(config, 10L, entry.getKey(), entry.getValue());
////
////        }
//
//        logInToCProf_Page(config, 10L, key, mymap.get(key));
//
//    }


    public static void menuNavigation(WebDriver driver, long waitingTime, Menus menus) throws InterruptedException {

        String menu    = menus.getMenu();
        String submenu = menus.getSubMenu();
        String header  = menus.getSubMenusHeaders();

        String menuName    = "//*[text()[normalize-space(.)='" + menu + "']]";
        String submenuName = "//*[text()[normalize-space(.)='" + submenu + "']]";
        String pageTitle   = "//h1//*[text()[normalize-space(.)='" + header + "']]";


        driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);

        driver.findElement(By.xpath(menuName)).click();
        Thread.sleep(500L);

        if (!submenu.equals("")) {
            driver.findElement(By.xpath(submenuName)).click();
        }

        WebDriverWait wait;
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(pageTitle)));

    }


}



