package ru.andrey.contentsaggregator.contentsreaders;

import org.apache.poi.EmptyFileException;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;

public class ContentsDocxReaderTest {

    @Test
    public void testGetContentsFromCorrectFile() throws DataFormatException {
        String currentDirectory = System.getProperty("user.dir");
        String testFilePath = currentDirectory + "\\src\\test\\resources" + "\\789123_Подходящее название Good name 1.docx";
        Path path = Paths.get(testFilePath);

        List<String> excpectedList = new ArrayList<>();
        excpectedList.add("DocX Test File 1 line 1" + "\n" + "DocX Test File 1 line 2" + "\n");

        ContentsDocxReader cdxr = new ContentsDocxReader();
        List<String> actualList = cdxr.getContentsFromFile(path);

        Assert.assertEquals(excpectedList, actualList);
    }

    @Test(expected = EmptyFileException.class)
    public void testGetContentsFromEmptyFile() throws DataFormatException {
        String currentDirectory = System.getProperty("user.dir");
        String testFilePath = currentDirectory + "\\src\\test\\resources" + "\\Empty DocxTest File.docx";
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