package pl.marcin.logic;

import pl.marcin.logic.core.OutputFileManager;
import pl.marcin.logic.core.PdfFileManager;
import pl.marcin.logic.core.PdfMergeService;
import pl.marcin.logic.core.PdfSorter;

import java.io.File;
import java.io.IOException;

public class PdfMergerController {
    private final PdfFileManager fileManager;
    private final PdfSorter sorter;
    private final OutputFileManager outputFileManager;
    private final PdfMergeService mergeService;

    public PdfMergerController(
            PdfFileManager fileManager,
            PdfSorter sorter,
            OutputFileManager outputFileManager,
            PdfMergeService mergeService
    ) {
        this.fileManager = fileManager;
        this.sorter = sorter;
        this.outputFileManager = outputFileManager;
        this.mergeService = mergeService;
    }

    public boolean mergeAllPdfsInDirectory(File inputDirectory) throws IOException {
        File[] pdfFiles = fileManager.getPdfFiles(inputDirectory);

        if (pdfFiles.length == 0) {
            return false;
        }

        sorter.sortFilesByNumber(pdfFiles);
        File outputFile = outputFileManager.getOutputFile(inputDirectory);
        mergeService.merge(pdfFiles, outputFile);

        return true;
    }
}
