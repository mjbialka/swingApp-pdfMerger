package pl.marcin.gui.components;

import pl.marcin.gui.UIConfig;

import javax.swing.*;
import java.awt.*;

public class PathFieldFactory {
    public static JTextField create(UIConfig config) {
        JTextField pathField = new JTextField(35);
        pathField.setOpaque(false);
        pathField.setBorder(BorderFactory.createLineBorder(config.getTextFieldBorderColor()));
        pathField.setPreferredSize(new Dimension(300, 30));
        pathField.setForeground(config.getTextFieldTextColor());
        pathField.setFont(config.getTitleFieldFont());

        return pathField;
    }
}