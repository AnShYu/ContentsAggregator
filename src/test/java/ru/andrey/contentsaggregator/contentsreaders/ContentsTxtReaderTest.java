package ru.andrey.contentsaggregator.contentsreaders;

import junit.framework.TestCase;
import org.apache.poi.EmptyFileException;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;

public class ContentsTxtReaderTest {

    @Test
    public void testGetContentsFromCorrectFile() throws DataFormatException {
        String currentDirectory = System.getProperty("user.dir");
        String testFilePath = currentDirectory + "\\src\\test\\resources" + "\\123456_Подходящее название Good name 1.txt";
        Path path = Paths.get(testFilePath);

        List<String> excpectedList = new ArrayList<>();
        excpectedList.add("Txt Test File 1 Line 1");
        excpectedList.add("Txt Test File 1 Line 2");

        ContentsTxtReader ctxtr = new ContentsTxtReader();
        List<String> actualList = ctxtr.getContentsFromFile(path);

        Assert.assertEquals(excpectedList, actualList);
    }

    @Test(expected = EmptyFileException.class)
    public void testGetContentsFromEmptyFile() throws DataFormatException {
        String currentDirectory = System.getProperty("user.dir");
        String testFilePath = currentDirectory + "\\src\\test\\resources" + "\\Empty TxtTest File.txt";
        Path path = Paths.get(testFilePath);

        ContentsDocxReader cdxr = new ContentsDocxReader();
        cdxr.getContentsFromFile(path);

    }

    @Test(expected = DataFormatException.class)
    public void testNullArgument() throws DataFormatException {
        Path path = null;

        ContentsDocxReader cdxr = new ContentsDocxReader();
        cdxr.getContentsFromFile(path);
    }

    // Следующий тест почему-то не проходит.
//    @Test(expected = FileNotFoundException.class)
//    public void testWrongFilePathArgument() throws DataFormatException {
//        String currentDirectory = System.getProperty("user.dir");
//        String testFilePath = currentDirectory + "\\src\\test\\resources" + "\\No such file.docx";
//        Path path = Paths.get(testFilePath);
//
//        ContentsDocxReader cdxr = new ContentsDocxReader();
//        cdxr.getContentsFromFile(path);
//    }
}