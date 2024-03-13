package ru.andrey.contentsaggregator;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;

public class AllLessonsContentsMakerTest {

    @Test
    public void testGetСontentsFromOneTxtFile() throws DataFormatException {
        String currentDirectory = System.getProperty("user.dir");
        String testFilePath = currentDirectory + "\\src\\test\\resources" + "\\123456_Подходящее название Good name 1.txt";
        Path path = Paths.get(testFilePath);

        List<Path> pathsToFiles = new ArrayList<>();
        pathsToFiles.add(path);

        List<String> expectedContents = new ArrayList<>();
        expectedContents.add("Txt Test File 1 Line 1");
        expectedContents.add("Txt Test File 1 Line 2");

        Map<String, List<String>> expectedMap = new HashMap<>();
        expectedMap.put("123456_Подходящее название Good name 1.txt", expectedContents);

        AllLessonsContentsMaker alcm = new AllLessonsContentsMaker();
        Map<String, List<String>> actualMap = alcm.getAllContents(pathsToFiles);

        Assert.assertEquals(expectedMap, actualMap);

    }

    @Test
    public void testGetСontentsFromTwoTxtFiles() throws DataFormatException {
        String currentDirectory = System.getProperty("user.dir");
        String testFilePath1 = currentDirectory + "\\src\\test\\resources" + "\\123456_Подходящее название Good name 1.txt";
        Path path1 = Paths.get(testFilePath1);

        String testFilePath2 = currentDirectory + "\\src\\test\\resources" + "\\123456_Подходящее название Good name 2.txt";
        Path path2 = Paths.get(testFilePath2);

        List<Path> pathsToFiles = new ArrayList<>();
        pathsToFiles.add(path1);
        pathsToFiles.add(path2);

        List<String> expectedContents1 = new ArrayList<>();
        expectedContents1.add("Txt Test File 1 Line 1");
        expectedContents1.add("Txt Test File 1 Line 2");

        List<String> expectedContents2 = new ArrayList<>();
        expectedContents2.add("Txt Test File 2 Line 1");
        expectedContents2.add("Txt Test File 2 Line 2");

        Map<String, List<String>> expectedMap = new HashMap<>();
        expectedMap.put("123456_Подходящее название Good name 1.txt", expectedContents1);
        expectedMap.put("123456_Подходящее название Good name 2.txt", expectedContents2);

        AllLessonsContentsMaker alcm = new AllLessonsContentsMaker();
        Map<String, List<String>> actualMap = alcm.getAllContents(pathsToFiles);

        Assert.assertEquals(expectedMap, actualMap);

    }

    @Test
    public void testGetСontentsFromOneDocxFile() throws DataFormatException {
        String currentDirectory = System.getProperty("user.dir");
        String testFilePath = currentDirectory + "\\src\\test\\resources" + "\\789123_Подходящее название Good name 1.docx";
        Path path = Paths.get(testFilePath);

        List<Path> pathsToFiles = new ArrayList<>();
        pathsToFiles.add(path);

        List<String> expectedContents = new ArrayList<>();
        expectedContents.add("DocX Test File 1 line 1" + "\n" + "DocX Test File 1 line 2" + "\n");

        Map<String, List<String>> expectedMap = new HashMap<>();
        expectedMap.put("789123_Подходящее название Good name 1.docx", expectedContents);

        AllLessonsContentsMaker alcm = new AllLessonsContentsMaker();
        Map<String, List<String>> actualMap = alcm.getAllContents(pathsToFiles);

        Assert.assertEquals(expectedMap, actualMap);

    }

    @Test
    public void testGetСontentsFromTwoDocxFiles() throws DataFormatException {
        String currentDirectory = System.getProperty("user.dir");
        String testFilePath1 = currentDirectory + "\\src\\test\\resources" + "\\789123_Подходящее название Good name 1.docx";
        Path path1 = Paths.get(testFilePath1);

        String testFilePath2 = currentDirectory + "\\src\\test\\resources" + "\\789123_Подходящее название Good name 2.docx";
        Path path2 = Paths.get(testFilePath2);

        List<Path> pathsToFiles = new ArrayList<>();
        pathsToFiles.add(path1);
        pathsToFiles.add(path2);

        List<String> expectedContents1 = new ArrayList<>();
        expectedContents1.add("DocX Test File 1 line 1" + "\n" + "DocX Test File 1 line 2" + "\n");

        List<String> expectedContents2 = new ArrayList<>();
        expectedContents2.add("DocX Test File 2 line 1" + "\n" + "DocX Test File 2 line 2" + "\n");

        Map<String, List<String>> expectedMap = new HashMap<>();
        expectedMap.put("789123_Подходящее название Good name 1.docx", expectedContents1);
        expectedMap.put("789123_Подходящее название Good name 2.docx", expectedContents2);

        AllLessonsContentsMaker alcm = new AllLessonsContentsMaker();
        Map<String, List<String>> actualMap = alcm.getAllContents(pathsToFiles);

        Assert.assertEquals(expectedMap, actualMap);

    }

    @Test(expected = DataFormatException.class)
    public void testNullArgument() throws DataFormatException {
        List<Path> pathsToFiles = null;

        AllLessonsContentsMaker alcm = new AllLessonsContentsMaker();
        alcm.getAllContents(pathsToFiles);
    }

    @Test(expected = DataFormatException.class)
    public void testUnhandeledFileFormat() throws DataFormatException {
        String currentDirectory = System.getProperty("user.dir");
        String testFilePath1 = currentDirectory + "\\src\\test\\resources" + "\\789123_Подходящее название Good name 1.doc";
        Path path1 = Paths.get(testFilePath1);

        List<Path> pathsToFiles = new ArrayList<>();
        pathsToFiles.add(path1);

        AllLessonsContentsMaker alcm = new AllLessonsContentsMaker();
        alcm.getAllContents(pathsToFiles);

    }


}