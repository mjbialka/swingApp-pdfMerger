package pl.marcin;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PdfOperator {

    public static void mergePDFFilesInDirectory(String directoryPath) throws IOException {

        File directory = new File(directoryPath);
        File[] pdfFiles = directory.listFiles((_, name) -> name.toLowerCase().endsWith(".pdf"));

        if (pdfFiles != null && pdfFiles.length > 0) {

            Arrays.sort(pdfFiles, (f1, f2) -> {

                Integer num1 = extractNumber(f1.getName());
                Integer num2 = extractNumber(f2.getName());
                return num1.compareTo(num2);
            });

            PDFMergerUtility pdfMerger = new PDFMergerUtility();

            String destinationFile = directoryPath + "\\merged_document.pdf";
            pdfMerger.setDestinationFileName(destinationFile);

            for (File pdfFile : pdfFiles) {
                pdfMerger.addSource(pdfFile);
            }

            pdfMerger.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());


            JOptionPane.showMessageDialog(null, "Pliki PDF zostały połączone pomyślnie.", "Sukces", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Brak plików PDF w katalogu.", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static Integer extractNumber(String fileName) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(fileName);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        }
        return 0;
    }
}