package pl.marcin.gui.grid;

import java.awt.*;

public class GridBagHelper {
    public static GridBagConstraints constraints(int gridx, int gridy) {
        GridBagConstraints uiGrid = new GridBagConstraints();
        uiGrid.gridx = gridx;
        uiGrid.gridy = gridy;
        uiGrid.insets = new Insets(4, 4, 4, 4); // domyślny margines
        uiGrid.fill = GridBagConstraints.NONE;
        uiGrid.anchor = GridBagConstraints.CENTER;
        return uiGrid;
    }

    public static GridBagConstraints constraints(int gridx, int gridy, int gridwidth, Insets insets) {
        GridBagConstraints uiGrid = constraints(gridx, gridy);
        uiGrid.gridwidth = gridwidth;
        uiGrid.insets = insets;
        return uiGrid;
    }
}
