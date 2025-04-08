package pl.marcin.util;

public final class AppConstants {

    private AppConstants() {
    }

    // Komunikaty
    public static final String NO_PDF_FOUND_MESSAGE = "Nie znaleziono plików PDF w wybranym katalogu.";
    public static final String MERGE_SUCCESS_MESSAGE = "Pliki PDF zostały pomyślnie połączone.";
    public static final String MERGE_ERROR_MESSAGE = "Wystąpił błąd podczas scalania plików PDF.";
    public static final String DIRECTORY_SELECTION_ERROR = "Wystąpił błąd podczas wybierania folderu.";
    public static final String ERROR_DIALOG_TITLE = "Błąd";
    public static final String WARNING_DIALOG_TITLE = "Ostrzeżenie";
    public static final String INFORMATION_DIALOG_TITLE = "Informacja";
    public static final String DIALOG_TITLE_SELECT_FOLDER = "Wybierz folder z plikami PDF";

    // Domyślna nazwa pliku wyjściowego
    public static final String OUTPUT_FILE_NAME = "scalony_dokument.pdf";

    // Rozszerzenia plików
    public static final String PDF_EXTENSION = ".pdf";

    // Ścieżka do domyślnego folderu wyjściowego
//    public static final String DEFAULT_OUTPUT_FOLDER = System.getProperty("user.home");


//    public static final long MAX_FILE_SIZE = 180 * 1024 * 1024; // 180 MB
}
