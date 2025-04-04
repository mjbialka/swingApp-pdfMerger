package pl.marcin;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;

public class PdfMergerApp {

    public static void createAndShowGUI() {
        try {
            UIManager.setLookAndFeel((UIManager.getSystemLookAndFeelClassName()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 200);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);
        frame.setBackground(new Color(0, 0, 0, 0));
        frame.setShape(new RoundRectangle2D.Double(0, 0, frame.getWidth(), frame.getHeight(), 30, 30));

        JPanel panel = getPanel();

        frame.setContentPane(panel); //dodajemy panel ui do okna


        JLabel titleLabel = new JLabel("Pdf Tool", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(Color.WHITE); // Biały kolor czcionki

        GridBagConstraints ui = new GridBagConstraints();
        ui.gridx = 0; // Kolumna 0
        ui.gridy = 0; // Pierwszy wiersz
        ui.gridwidth = 2; // Rozciąga się na 2 kolumny
        ui.insets = new Insets(10, 0, 20, 0); // Odstęp: góra-dół 10px, między elementami 20px

        panel.add(titleLabel, ui);


        // 1. Tworzymy JTextField do wprowadzania ścieżki katalogu
        JTextField pathField = new JTextField(35);
        pathField.setOpaque(false); // Ustawiamy tło jako przezroczyste
        pathField.setBorder(BorderFactory.createLineBorder(new Color(48, 56, 69), 3)); // Pogrubiona biała ramka (grubość 3)
        pathField.setPreferredSize(new Dimension(300, 30)); // Ustawiamy rozmiar (szersze i wyższe)

        // Ustawiamy biały kolor tekstu oraz czcionkę niepogrubioną
        pathField.setForeground(Color.WHITE); // Kolor tekstu na biały
        pathField.setFont(new Font("Arial", Font.PLAIN, 14)); // Ustawiamy czcionkę na Arial bez pogrubienia

        ui.gridx = 0; // Pierwsza kolumna
        ui.gridy = 1; // Drugi wiersz (poniżej tytułu)
        ui.gridwidth = 2; // Zajmuje dwie kolumny
        ui.insets = new Insets(2, 2, 2, 2); // Odstęp
        panel.add(pathField, ui);


        // 2. Tworzymy JButton z ikoną
        ImageIcon folderIcon = new ImageIcon("C:\\Users\\Marcin\\IdeaProjects\\swingApp-pdfMerging\\src\\main\\resources\\folder_white.png");
        JButton browseButton = new JButton(folderIcon);

        // Ustawiamy, aby przycisk był przeźroczysty
        browseButton.setOpaque(false); // Przezroczystość tła
        browseButton.setContentAreaFilled(false); // Zapobiega wypełnianiu tła
        browseButton.setPreferredSize(new Dimension(27, 20)); // Rozmiar przycisku (dostosuj do ikony)


        ui.gridx = 2; // Trzecia kolumna
        ui.gridwidth = 1; // Zajmuje tylko jedną kolumnę
        panel.add(browseButton, ui);

        // Tworzymy niestandardowy border z zaokrąglonymi rogami
        Border roundedBorder = new Border() {
            @Override
            public Insets getBorderInsets(Component c) {
                return new Insets(4, 4, 4, 4); // Ustalamy marginesy wewnętrzne
            }

            @Override
            public boolean isBorderOpaque() {
                return true; // Ustalamy, że ramka jest nieprzezroczysta
            }

            @Override
            public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.WHITE); // Kolor ramki
                g2.setStroke(new BasicStroke(2)); // Grubość ramki
                g2.drawRoundRect(x, y, width - 1, height - 1, 20, 20); // Zaokrąglona ramka
            }
        };

        // Tworzymy przycisk "Scal PDF" z niestandardową ramką
        JButton mergeButton = new JButton("Scal PDF");
        mergeButton.setFont(new Font("Arial", Font.BOLD, 16)); // Pogrubiona czcionka
        mergeButton.setForeground(Color.WHITE); // Biały tekst
        mergeButton.setOpaque(false); // Przezroczystość tła
        mergeButton.setContentAreaFilled(false); // Zapobiega wypełnianiu tła
        mergeButton.setBorder(roundedBorder); // Ustawiamy niestandardową ramkę z zaokrąglonymi rogami
        mergeButton.setPreferredSize(new Dimension(200, 32)); // Rozmiar przycisku (większy)


        // Dodajemy MouseListener, aby zmieniać grubość ramki i czcionki po najechaniu
        mergeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                // Zwiększamy grubość ramki o 1 oraz czcionkę o 1
                mergeButton.setFont(new Font("Arial", Font.BOLD, 17)); // Zwiększamy czcionkę o 1
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                // Przywracamy pierwotną czcionkę i grubość ramki
                mergeButton.setFont(new Font("Arial", Font.BOLD, 16)); // Przywracamy czcionkę
            }
        });


        // Ustawiamy constraints, aby przycisk był wyśrodkowany na dole
        ui.gridx = 0; // Pierwsza kolumna
        ui.gridy = 2; // Trzeci wiersz (po innych komponentach)
        ui.gridwidth = 3; // Rozciąga się na trzy kolumny (cała szerokość)
        ui.insets = new Insets(20, 10, 8, 10); // Odstęp od innych elementów i dolny margines
        panel.add(mergeButton, ui);


        // Akcja po kliknięciu przycisku "Scal PDF"
        mergeButton.addActionListener(_ -> {
            String directoryPath = pathField.getText().trim(); // Pobranie ścieżki z pola tekstowego

            if (directoryPath.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Proszę podać ścieżkę do katalogu!", "Błąd", JOptionPane.ERROR_MESSAGE);
                return;
            }

            File directory = new File(directoryPath);
            if (!directory.exists() || !directory.isDirectory()) {
                JOptionPane.showMessageDialog(frame, "Podana ścieżka nie jest katalogiem!", "Błąd", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                // Wywołanie metody scalania z klasy PdfOperator
                PdfOperator.mergePDFFilesInDirectory(directoryPath);
                JOptionPane.showMessageDialog(frame, "Pliki PDF zostały scalone pomyślnie!", "Sukces", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ioException) {
                JOptionPane.showMessageDialog(frame, "Wystąpił błąd podczas scalania plików: " + ioException.getMessage(),
                        "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        });

// Akcja po kliknięciu przycisku "Wybierz katalog"
        browseButton.addActionListener(_ -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // Ograniczenie do wyboru folderów
            int returnValue = fileChooser.showOpenDialog(frame);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedDirectory = fileChooser.getSelectedFile();
                pathField.setText(selectedDirectory.getAbsolutePath()); // Ustawienie ścieżki w polu tekstowym
            }
        });


        frame.setVisible(true);
    }

    private static JPanel getPanel() {
        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(74, 86, 108, 220)); // tło
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
            }
        };

        panel.setOpaque(false); // przeźroczystość tła
        panel.setLayout(new GridBagLayout()); //menadżer układu
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); //marginesy
        return panel;
    }
}
