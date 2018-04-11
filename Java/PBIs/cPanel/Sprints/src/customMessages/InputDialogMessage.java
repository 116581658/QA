package customMessages;

import javax.swing.*;

public class InputDialogMessage {

    public static String showInputMessage(String title, String textMessage, String text) {

        String selectedValue = (String) JOptionPane.showInputDialog( null, textMessage, title, JOptionPane.QUESTION_MESSAGE ,null,null, text) ;

        if (selectedValue == null  || selectedValue.length() == 0) {
            System.exit(0);
        }
        return selectedValue;
    }


}
