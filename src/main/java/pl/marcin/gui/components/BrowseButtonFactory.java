package pl.marcin.gui.components;

import pl.marcin.gui.UIConfig;

import javax.swing.*;
import java.awt.*;

public class BrowseButtonFactory {
    public static JButton create(UIConfig config, Runnable onClick) {
        JButton browseButton = new JButton(config.getFolderIcon());
        browseButton.setContentAreaFilled(false);
        browseButton.setPreferredSize(new Dimension(27, 20));
        browseButton.setFocusPainted(false);
        browseButton.setBorderPainted(false);

        // Obsługa kliknięcia (jeśli przekazano akcję)
        if (onClick != null) {
            browseButton.addActionListener(_ -> onClick.run());
        }

        return browseButton;
    }
}