package pl.marcin;

import pl.marcin.gui.GUIManager;

import javax.swing.*;

public class PdfMergerApp {
    public static void start() {
        SwingUtilities.invokeLater(PdfMergerApp::createAndShowGUI);
    }

    protected static void createAndShowGUI() {
        GUIManager guiManager = new GUIManager();
        guiManager.initUI();
    }
}
