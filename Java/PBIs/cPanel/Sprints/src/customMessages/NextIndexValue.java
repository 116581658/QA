package customMessages;

import javax.swing.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.Toolkit;
import java.io.*;

public class NextIndexValue {
    static final Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    static void setClipboardContents(final String aContents) {
        clipboard.setContents(new StringSelection(aContents), null);
    }

    static String getClipboardContents() throws IOException, UnsupportedFlavorException {
        return (String) clipboard.getContents(null).getTransferData(DataFlavor.stringFlavor);
    }


    static void showIndexValue(String i, String title, String textBeforeI, Integer x, Integer y) throws IOException, UnsupportedFlavorException {

        JOptionPane optionPane = new JOptionPane(textBeforeI, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION);
        optionPane.setWantsInput(true);
        optionPane.setInitialSelectionValue(i + ": was copied to the clipboard");
        setClipboardContents(i);
        getClipboardContents();
        JDialog dialog = optionPane.createDialog(null, title);
        dialog.setLocation(x, y);
        dialog.setVisible(true);

    }
}
