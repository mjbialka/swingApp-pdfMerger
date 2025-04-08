package pl.marcin.util;

import javax.swing.*;
import java.awt.*;

public class DialogUtils {

    public static void showError(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, AppConstants.ERROR_DIALOG_TITLE, JOptionPane.ERROR_MESSAGE);
    }

    public static void showWarning(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, AppConstants.WARNING_DIALOG_TITLE, JOptionPane.WARNING_MESSAGE);
    }

    public static void showInfo(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, AppConstants.INFORMATION_DIALOG_TITLE, JOptionPane.INFORMATION_MESSAGE);
    }

    public static int showConfirmDialog(Component parent, String message) {
        return JOptionPane.showConfirmDialog(parent, message, "Potwierdzenie", JOptionPane.YES_NO_OPTION);
    }
}
