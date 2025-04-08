package pl.marcin.gui;

import pl.marcin.gui.actions.BrowseActionHandler;
import pl.marcin.gui.actions.MergeActionHandler;
import pl.marcin.gui.components.BrowseButtonFactory;
import pl.marcin.gui.components.MergeButtonFactory;
import pl.marcin.gui.components.PathFieldFactory;
import pl.marcin.gui.components.TitleLabelFactory;
import pl.marcin.gui.grid.GridBagHelper;
import pl.marcin.gui.grid.Frame;
import pl.marcin.gui.grid.Panel;
import pl.marcin.io.DirectoryChooserService;
import pl.marcin.logic.PdfMergerController;
import pl.marcin.logic.core.OutputFileManager;
import pl.marcin.logic.core.PdfFileManager;
import pl.marcin.logic.core.PdfMergeService;
import pl.marcin.logic.core.PdfSorter;

import javax.swing.*;
import java.awt.*;

public class GUIManager {

    private final UIConfig config;

    public GUIManager() {
        this.config = new UIConfig(); //ładowanie konfiguracji UI
    }

    public void initUI() {
        Frame frame = new Frame();
        Panel panel = new Panel(config);
        frame.setContentPane(panel);


        addTitleLabel(panel);
        JTextField pathField = addPathField(panel);
        addBrowseButton(panel, pathField);
        addMergeButton(panel, pathField);

        frame.setVisible(true);
    }


    private void addTitleLabel(JPanel panel) {
        panel.add(TitleLabelFactory.create(config),
                GridBagHelper.constraints(0, 0, 2, new Insets(10, 0, 20, 0)));
    }

    private JTextField addPathField(JPanel panel) {
        JTextField pathField = PathFieldFactory.create(config);
        panel.add(pathField, GridBagHelper.constraints(0, 1, 2, new Insets(2, 2, 2, 2)));
        return pathField;
    }

    private void addBrowseButton(JPanel panel, JTextField pathField) {
        DirectoryChooserService chooserService = new DirectoryChooserService();
        BrowseActionHandler actionHandler = new BrowseActionHandler(chooserService);

        JButton browseButton = BrowseButtonFactory.create(config, () -> actionHandler.handle(pathField, panel));

        panel.add(browseButton, GridBagHelper.constraints(2, 1, 1, new Insets(2, 2, 2, 2)));
    }

    private void addMergeButton(JPanel panel, JTextField pathField) {
        PdfMergeService mergeService = new PdfMergeService();
        PdfFileManager fileManager = new PdfFileManager();
        PdfSorter sorter = new PdfSorter();
        OutputFileManager outputFileManager = new OutputFileManager();

        PdfMergerController controller = new PdfMergerController(
                fileManager, sorter, outputFileManager, mergeService
        );

        MergeActionHandler mergeHandler = new MergeActionHandler(panel, controller);

        JButton mergeButton = MergeButtonFactory.create(config, () -> {
            String directoryPath = pathField.getText().trim();
            mergeHandler.handleMerge(directoryPath);
        });

        panel.add(mergeButton, GridBagHelper.constraints(0, 2, 3, new Insets(20, 10, 8, 10)));
    }

}