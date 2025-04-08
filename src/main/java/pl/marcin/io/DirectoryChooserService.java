package pl.marcin.io;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class DirectoryChooserService {

    public File chooseDirectory(Component parent) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setDialogTitle("Wybierz folder z plikami PDF");

        int result = chooser.showOpenDialog(parent);
        if (result == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        }
        return null;
    }

}
