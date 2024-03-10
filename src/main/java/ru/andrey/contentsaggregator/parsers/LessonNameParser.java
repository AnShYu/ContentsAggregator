package ru.andrey.contentsaggregator.parsers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LessonNameParser implements StringParser {
    @Override
    public String getParsedString(String text) {
        String parsedText = "UNSPECIFIED LESSON NAME / УРОК БЕЗ СПЕЦИАЛЬНОГО НАЗВАНИЯ";
        if(text != null) {
            String regEx = "[0-9]{6}[^\\\\]*";

            Pattern pattern = Pattern.compile(regEx);
            Matcher matcher = pattern.matcher(text);

            if(matcher.find()) {
                parsedText = matcher.group();
            }
        }
        return parsedText;
    }
}
