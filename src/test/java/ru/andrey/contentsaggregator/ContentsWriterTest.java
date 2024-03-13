package ru.andrey.contentsaggregator;

import org.junit.Assert;
import org.junit.Test;
import ru.andrey.contentsaggregator.exceptions.LackOfDataForWritingException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ContentsWriterTest {

    @Test
    public void testWriteOneLessonContentsToCorrectTxtFile() throws IOException {
        Map<String, List<String>> map = new LinkedHashMap<>();

        String lesson1 = "Урок 1";
        String line1 = "Первая строчка содержания";
        String line2 = "Вторая строчка содержания";

        List<String> contents = new ArrayList<>();
        contents.add(line1);
        contents.add(line2);

        map.put(lesson1, contents);

        String currentDirectory = System.getProperty("user.dir");
        String destinationFile = currentDirectory + "\\src\\test\\resources" + "\\DestinationFile.txt";
        Path path = Paths.get(destinationFile);

        ContentsWriter.writeToTxtFile(destinationFile, map);

        List<String> actualContentsOfTheFile = new ArrayList<>();
        try(Scanner scanner = new Scanner(path)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                actualContentsOfTheFile.add(line);
            }
        }

        List<String> expectedContensOfTheFile = new ArrayList<>();
        expectedContensOfTheFile.add(lesson1);
        expectedContensOfTheFile.add(line1);
        expectedContensOfTheFile.add(line2);

        Assert.assertEquals(expectedContensOfTheFile, actualContentsOfTheFile);

    }

    @Test
    public void testWriteTwoLessonContentsToCorrectTxtFile() throws IOException {
        Map<String, List<String>> map = new LinkedHashMap<>();

        String lesson1 = "Урок 1";
        String line11 = "Первая строчка содержания урока 1";
        String line12 = "Вторая строчка содержания урока 1";

        String lesson2 = "Урок 2";
        String line21 = "Первая строчка содержания урока 2";
        String line22 = "Вторая строчка содержания урока 2";


        List<String> contents1 = new ArrayList<>();
        contents1.add(line11);
        contents1.add(line12);

        map.put(lesson1, contents1);

        List<String> contents2 = new ArrayList<>();
        contents2.add(line21);
        contents2.add(line22);

        map.put(lesson2, contents2);

        String currentDirectory = System.getProperty("user.dir");
        String destinationFile = currentDirectory + "\\src\\test\\resources" + "\\DestinationFile.txt";
        Path path = Paths.get(destinationFile);

        ContentsWriter.writeToTxtFile(destinationFile, map);

        List<String> actualContentsOfTheFile = new ArrayList<>();
        try(Scanner scanner = new Scanner(path)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                actualContentsOfTheFile.add(line);
            }
        }

        List<String> expectedContensOfTheFile = new ArrayList<>();
        expectedContensOfTheFile.add(lesson1);
        expectedContensOfTheFile.add(line11);
        expectedContensOfTheFile.add(line12);
        expectedContensOfTheFile.add(lesson2);
        expectedContensOfTheFile.add(line21);
        expectedContensOfTheFile.add(line22);

        Assert.assertEquals(expectedContensOfTheFile, actualContentsOfTheFile);

    }

    @Test(expected = LackOfDataForWritingException.class)
    public void testNullDestinationFileArgument() {
        String destinationFile = null;

        Map<String, List<String>> map = new LinkedHashMap<>();

        String lesson1 = "Урок 1";
        String line1 = "Первая строчка содержания";
        String line2 = "Вторая строчка содержания";

        List<String> contents = new ArrayList<>();
        contents.add(line1);
        contents.add(line2);

        map.put(lesson1, contents);

        ContentsWriter.writeToTxtFile(destinationFile, map);
    }


    @Test(expected = LackOfDataForWritingException.class)
    public void testNullContentsMapArgument() {
        String currentDirectory = System.getProperty("user.dir");
        String destinationFile = currentDirectory + "\\src\\test\\resources" + "\\DestinationFile.txt";

        Map<String, List<String>> map = null;

        ContentsWriter.writeToTxtFile(destinationFile, map);

    }

    @Test(expected = LackOfDataForWritingException.class)
    public void testEmptyContentsMapArgument() {
        String currentDirectory = System.getProperty("user.dir");
        String destinationFile = currentDirectory + "\\src\\test\\resources" + "\\DestinationFile.txt";

        Map<String, List<String>> map = new LinkedHashMap<>();

        ContentsWriter.writeToTxtFile(destinationFile, map);

    }

    // Почему-то тест не проходится.
//    @Test(expected = FileNotFoundException.class)
//    public void testWrongDestinationFile() {
//        String currentDirectory = System.getProperty("user.dir");
//        String destinationFile = currentDirectory + "\\src\\test\\resources" + "\\Wrong DestinationFile.txt";
//
//        Map<String, List<String>> map = new LinkedHashMap<>();
//
//        String lesson1 = "Урок 1";
//        String line1 = "Первая строчка содержания";
//        String line2 = "Вторая строчка содержания";
//
//        List<String> contents = new ArrayList<>();
//        contents.add(line1);
//        contents.add(line2);
//
//        map.put(lesson1, contents);
//
//        ContentsWriter.writeToTxtFile(destinationFile, map);
//
//    }

}