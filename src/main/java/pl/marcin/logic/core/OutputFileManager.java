package pl.marcin.logic.core;

import pl.marcin.util.AppConstants;

import java.io.File;

public class OutputFileManager {
    public File getOutputFile(File directory) {
        return new File(directory, AppConstants.OUTPUT_FILE_NAME);
    }
}
