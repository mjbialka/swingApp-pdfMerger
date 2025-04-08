package pl.marcin.gui.actions;

import pl.marcin.logic.PdfMergerController;
import pl.marcin.util.AppConstants;
import pl.marcin.util.DialogUtils;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MergeActionHandler {
    private final Component parent;
    private final PdfMergerController mergeService;

    public MergeActionHandler(Component parent, PdfMergerController mergeService) {
        this.parent = parent;
        this.mergeService = mergeService;
    }

    public void handleMerge(String directoryPath) {
        if (directoryPath == null || directoryPath.isBlank()) {
            DialogUtils.showWarning(parent, AppConstants.DIALOG_TITLE_SELECT_FOLDER);
            return;
        }

        File dir = new File(directoryPath);
        if (!dir.exists() || !dir.isDirectory()) {
            DialogUtils.showError(parent, AppConstants.DIRECTORY_SELECTION_ERROR);
            return;
        }

        try {
            boolean success = mergeService.mergeAllPdfsInDirectory(dir);
            if (success) {
                int result = DialogUtils.showConfirmDialog(parent, AppConstants.MERGE_SUCCESS_MESSAGE + "\nCzy chcesz otworzyć folder?");
                if (result == JOptionPane.YES_OPTION) {
                    Desktop.getDesktop().open(dir);
                }
            } else {
                DialogUtils.showWarning(parent, AppConstants.NO_PDF_FOUND_MESSAGE);
            }
        } catch (Exception e) {
            DialogUtils.showError(parent, AppConstants.MERGE_ERROR_MESSAGE + "\n" + e.getMessage());
        }
    }
}
