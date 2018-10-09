package com.galenframework.java.misc;

import javax.swing.*;

public class DialogMessageWithDropDown {

    public static String showMessageWindow( String title, String text  , Object[] possibleValues ) {

        text = text == null ? "Choose one" : text;
        String selectedValue = (String) JOptionPane.showInputDialog(null,
                text, title, JOptionPane.QUESTION_MESSAGE, null, possibleValues, possibleValues[0]);

        if (selectedValue == null  || selectedValue.length() == 0) {
            System.exit(0);
        }
        return selectedValue;
    }

}


