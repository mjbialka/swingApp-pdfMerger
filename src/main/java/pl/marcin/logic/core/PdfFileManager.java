package pl.marcin.logic.core;

import pl.marcin.util.AppConstants;

import java.io.File;
import java.util.Locale;

public class PdfFileManager {
    public File[] getPdfFiles(File directory) {
        File[] files = directory.listFiles(file ->
                file.isFile() && file.getName().toLowerCase(Locale.ROOT).endsWith(AppConstants.PDF_EXTENSION));
        return files != null ? files : new File[0];
    }
}
