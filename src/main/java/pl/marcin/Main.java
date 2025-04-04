package pl.marcin;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        start();
    }

    protected static void start(){
        SwingUtilities.invokeLater(PdfMergerApp::createAndShowGUI);
    }


}
