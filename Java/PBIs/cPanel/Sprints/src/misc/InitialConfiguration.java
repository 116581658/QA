package misc;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import static logins.CPanel_Login.logInToCPan_Quest;

public class InitialConfiguration {

    Properties prop = new Properties();
    //Create Object of FileInputStream Class. Pass file path.
    public FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "/src/misc/objects.properties");
    ;
    long[] waitingTimesMillis = {100L, 200L, 300L, 500L, 700L, 1000L}; //1000 milliseconds = 1 sec
    int[] waitingTimesSecs = {1, 2, 3, 5, 7, 10}; //1000 milliseconds = 1 sec

    WebDriver browser;

    private static String[] environments = {"TRUNK", "TAG"};
    public static String[] cPanel = logInToCPan_Quest(environments);   // {"TRUNK", "TAG", "TRUNK_INT", "TAG_INT"}

    public static String cPanelLink = cPanel[0];
    public static String cPanelEnvironment = cPanel[1];

    public InitialConfiguration() throws FileNotFoundException {
    }
}
