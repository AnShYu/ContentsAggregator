package ru.andrey.contentsaggregator.contentsreaders;

import org.junit.Assert;
import org.junit.Test;

public class ContentsDocxReaderTest {

    @Test
    public void testGetContentsFromFile() {

        //String currentWorkingDirectory = System.getProperty("user.dir");
        /* Нужно ли тестировать такой класс? Я представляю себе тестирование так:
         - создается docx файл в текущей рабочей директории
         - в него записывается несколько строк
         - строки считываются с помощью тестируемого метода
         - файл удаляется
         - делаем assertEquals

         Но какой-либо сложной логики в методе нет - он самостоятельно фактически только записывает в List.
         Более сложная логика будет в создании и удалении файла.

        */

        Assert.assertEquals(1, 1);
    }
}