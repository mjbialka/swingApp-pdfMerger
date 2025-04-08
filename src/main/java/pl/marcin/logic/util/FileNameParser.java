package pl.marcin.logic.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileNameParser {
    public static int extractNumber(String fileName) {
        Matcher matcher = Pattern.compile("\\d+").matcher(fileName);
        return matcher.find() ? Integer.parseInt(matcher.group()) : 0;
    }
}
