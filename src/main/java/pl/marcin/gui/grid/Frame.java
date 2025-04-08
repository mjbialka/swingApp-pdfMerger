package pl.marcin.gui.grid;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class Frame extends JFrame {
    public Frame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 200);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setBackground(new Color(0, 0, 0, 0));
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));  // Zaokrąglone rogi
    }
}