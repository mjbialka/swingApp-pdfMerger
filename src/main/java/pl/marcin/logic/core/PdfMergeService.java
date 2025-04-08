package pl.marcin.logic.core;

import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.io.IOException;
public class PdfMergeService {

    public void merge(File[] sourceFiles, File outputTargetFile) throws IOException {
        PDFMergerUtility merger = new PDFMergerUtility();
        merger.setDestinationFileName(outputTargetFile.getAbsolutePath());

        for (File pdf : sourceFiles) {
            merger.addSource(pdf);
        }

        merger.mergeDocuments(null);
    }

}
