package ru.andrey.contentsaggregator;

import ru.andrey.contentsaggregator.exceptions.LackOfDataForWritingException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;

public class ContentsWriter {
    // Нужно ли тестировать этот метод?
    public static void writeToTxtFile(String destinationFileName, Map<String, List<String>> aggrgatedContents) {
        if(destinationFileName == null || aggrgatedContents == null || aggrgatedContents.isEmpty()) {
            throw new LackOfDataForWritingException("Invalid destination file or no data for writing / Неверное имя файла для записи или отсутствуют данные для записи");
        }

        try(Writer writer = new FileWriter(destinationFileName); BufferedWriter bf = new BufferedWriter(writer)) {
            // Вложенный цикл. Но здесь, кажется ок - внешний цикл проходит по ключам
            for (String key: aggrgatedContents.keySet()) {
                bf.write(key + System.lineSeparator());
                for (String contentsLine: aggrgatedContents.get(key)) {
                    bf.write(contentsLine + System.lineSeparator());
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

}
