package ru.andrey.contentsaggregator;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FoldersScannerTest {

    @Test
    public void testGetPathesToLessonsContents() {
        String currentDirectory = System.getProperty("user.dir");

        Path filePath1 = Paths.get("File with contents.txt");
        Path filePath2 = Paths.get(currentDirectory+"\\TestSubDir\\File with contents.txt");

        List<Path> expectedPathsList = new ArrayList<>();
        expectedPathsList.add(filePath1);
        expectedPathsList.add(filePath2);


        FoldersScanner fs = new FoldersScanner();
        List<Path> actualPathsList = fs.getPathesToLessonsContents(currentDirectory,"File with contents.txt");


        Assert.assertEquals(expectedPathsList,actualPathsList); // Тест проваливается, т.к. не создаются настоящие файлы.
        // Стоит ли их создавать и потом удавать?
    }
}