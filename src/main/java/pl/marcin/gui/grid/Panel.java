package pl.marcin.gui.grid;

import pl.marcin.gui.UIConfig;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    private final UIConfig config;

    public Panel(UIConfig config) {
        this.config = config;

        setOpaque(false);
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(74, 86, 108, 220)); // tło
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
    }
}