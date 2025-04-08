package pl.marcin.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Objects;

public class UIConfig {
    public Font getTitleFont() {
        return new Font("Arial", Font.BOLD, 32);
    }

    public Color getTitleColor() {
        return Color.WHITE;
    }

    public Color getTextFieldBorderColor() {
        return new Color(48, 56, 69);
    }

    public Color getTextFieldTextColor() {
        return Color.WHITE;
    }

    public Font getTitleFieldFont() {
        return new Font("Arial", Font.PLAIN, 14);
    }

    public ImageIcon getFolderIcon() {
        return new ImageIcon(Objects.requireNonNull(
            getClass().getClassLoader().getResource("folder_white.png")
    ));
}

    public Font getButtonFont() {
        return new Font("Arial", Font.BOLD, 16);
    }

    public Color getButtonTextColor() {
        return Color.WHITE;
    }

    public Border getButtonBorder() {
        return new Border() {
            @Override
            public Insets getBorderInsets(Component c) {
                return new Insets(4, 4, 4, 4);
            }

            @Override
            public boolean isBorderOpaque() {
                return true;
            }

            @Override
            public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.WHITE);
                g2.setStroke(new BasicStroke(2));
                g2.drawRoundRect(x, y, width - 1, height - 1, 20, 20);
            }
        };
    }

}