package pl.marcin.logic.core;

import pl.marcin.logic.util.FileNameParser;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class PdfSorter {
    public void sortFilesByNumber(File[] files) {
        Arrays.sort(files, Comparator.comparingInt(f -> FileNameParser.extractNumber(f.getName())));
    }
}
