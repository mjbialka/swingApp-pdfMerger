package pl.marcin.gui.components;

import pl.marcin.gui.UIConfig;

import javax.swing.*;

public class TitleLabelFactory {
    public static JLabel create(UIConfig config) {
        JLabel titleLabel = new JLabel("Pdf Tool", SwingConstants.CENTER);
        titleLabel.setFont(config.getTitleFont());
        titleLabel.setForeground(config.getTitleColor());
        return titleLabel;
    }
}