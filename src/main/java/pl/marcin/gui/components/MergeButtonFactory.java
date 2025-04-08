package pl.marcin.gui.components;

import pl.marcin.gui.UIConfig;

import javax.swing.*;
import java.awt.*;

public class MergeButtonFactory {
    public static JButton create(UIConfig config, Runnable onClick) {
        JButton mergeButton = new JButton("Scal PDF");

        mergeButton.setFont(config.getButtonFont());
        mergeButton.setForeground(config.getButtonTextColor());
        mergeButton.setOpaque(false);
        mergeButton.setContentAreaFilled(false);
        mergeButton.setBorder(config.getButtonBorder());
        mergeButton.setPreferredSize(new Dimension(200, 32));
        mergeButton.setFocusPainted(false);

        if (onClick != null) {
            mergeButton.addActionListener(_ -> onClick.run());
        }

        return mergeButton;
    }
}

//        mergeButton.addActionListener(_ -> {
//            // Obsługuje kliknięcie w przycisk "Scal PDF"
//            String directoryPath = pathField.getText().trim();
//            // Walidacja i operacja scalania PDF
//        });