package ru.andrey.contentsaggregator.parsers;

import org.junit.Assert;
import org.junit.Test;

public class LessonNameParserTest {

    @Test
    public void testRandomLessonNameParsing() {
        String text = "112233_Урок25. Первый. New Lesson\\текст_";
        StringParser sp = new LessonNameParser();
        String parsedText = sp.getParsedString(text);
        Assert.assertEquals("112233_Урок25. Первый. New Lesson", parsedText);
    }

    @Test
    public void testIncorrectLessonNameParsing() {
        String text = "Урок25. Первый. New Lesson\\текст_";
        StringParser sp = new LessonNameParser();
        String parsedText = sp.getParsedString(text);
        Assert.assertEquals("UNSPECIFIED LESSON NAME / УРОК БЕЗ СПЕЦИАЛЬНОГО НАЗВАНИЯ", parsedText);
    }

    @Test
    public void testNullLessonNameParsing() {
        String text = null;
        StringParser sp = new LessonNameParser();
        String parsedText = sp.getParsedString(text);
        Assert.assertEquals("UNSPECIFIED LESSON NAME / УРОК БЕЗ СПЕЦИАЛЬНОГО НАЗВАНИЯ", parsedText);
    }
}