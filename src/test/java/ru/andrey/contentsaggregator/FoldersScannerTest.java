package ru.andrey.contentsaggregator;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FoldersScannerTest {

    @Test
    public void testGetPathesToOneCorrectFile() throws IOException {
        String currentDirectory = System.getProperty("user.dir");
        Path filePath1 = Paths.get("File with correct name.txt");
        Path subdirectory = Paths.get(currentDirectory+"\\TestSubDir");
        Path filePath2 = Paths.get(subdirectory + "\\File with wrong name.txt");

        List<Path> expectedPathsList = new ArrayList<>();
        expectedPathsList.add(filePath1.toAbsolutePath());

        List<Path> actualPathsList = getActualPathsList(filePath1, filePath2, currentDirectory, subdirectory);

        Assert.assertEquals(expectedPathsList,actualPathsList);
    }

    @Test
    public void testGetPathesToTwoCorrectFiles() throws IOException {
        String currentDirectory = System.getProperty("user.dir");
        Path filePath1 = Paths.get("File with correct name.txt");
        Path subdirectory = Paths.get(currentDirectory+"\\TestSubDir");
        Path filePath2 = Paths.get(subdirectory + "\\File with correct name.txt");

        List<Path> expectedPathsList = new ArrayList<>();
        expectedPathsList.add(filePath1.toAbsolutePath());
        expectedPathsList.add(filePath2.toAbsolutePath());

        List<Path> actualPathsList = getActualPathsList(filePath1, filePath2, currentDirectory, subdirectory);

        Assert.assertEquals(expectedPathsList,actualPathsList);
    }

    @Test
    public void testGetNoPathesToNoCorrectFiles() throws IOException {
        String currentDirectory = System.getProperty("user.dir");
        Path filePath1 = Paths.get("File with wrong name.txt");
        Path subdirectory = Paths.get(currentDirectory+"\\TestSubDir");
        Path filePath2 = Paths.get(subdirectory + "\\File with wrong name.txt");

        List<Path> expectedPathsList = new ArrayList<>();

        List<Path> actualPathsList = getActualPathsList(filePath1, filePath2, currentDirectory, subdirectory);

        Assert.assertEquals(expectedPathsList,actualPathsList);
    }

    private List<Path> getActualPathsList(Path filePath1, Path filePath2, String currentDirectory, Path subdirectory) throws IOException {
        if(!Files.exists(filePath1)) {
            Files.createFile(filePath1);
        }
        if(!Files.exists(subdirectory)) {
            Files.createDirectory(subdirectory);
        }
        if(!Files.exists(filePath2)) {
            Files.createFile(filePath2);
        }

        FoldersScanner fs = new FoldersScanner();
        List<Path> actualPathsList = fs.getPathesToLessonsContents(currentDirectory,"File with correct name.txt");

        Files.deleteIfExists(filePath1);
        Files.deleteIfExists(filePath2);
        Files.deleteIfExists(subdirectory);

        return actualPathsList;
    }
}