package pl.marcin.gui.actions;

import pl.marcin.io.DirectoryChooserService;
import pl.marcin.util.AppConstants;

import javax.swing.*;
import java.io.File;

public class BrowseActionHandler {
    private final DirectoryChooserService choooserService;

    public BrowseActionHandler(DirectoryChooserService chooserService) {
        this.choooserService = chooserService;
    }

    public void handle(JTextField pathField, JComponent parentComponent) {
        try {
            File selectedDir = choooserService.chooseDirectory(parentComponent);
            if (selectedDir != null) {
                pathField.setText(selectedDir.getAbsolutePath());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    parentComponent,
                    AppConstants.DIRECTORY_SELECTION_ERROR + "\n" + e.getMessage(),
                    AppConstants.ERROR_DIALOG_TITLE,
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
