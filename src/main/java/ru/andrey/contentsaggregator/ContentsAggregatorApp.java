package ru.andrey.contentsaggregator;

import ru.andrey.contentsaggregator.contentsreaders.ContentsFileReader;
import ru.andrey.contentsaggregator.contentsreaders.ContentsTxtReader;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;

public class ContentsAggregatorApp {
    public static void main(String[] args) { // Если в main указать throws exception, то далее exception не обрабатывается?
        //Нужно ли тестировать метод main?
        try{
            String rootFolder = UtilityData.FOLDERWITHLESSONS;
//            String contentsFileName = UtilityData.TXTSINGLELESSONCONTENTSFILENAME;
            String contentsFileName = UtilityData.DOCXSINGLELESSONCONTENTSFILENAME;
            String destinationFileName = UtilityData.DESTINATIONFILE;

            List<Path> pathesWithContentsFiles = new FoldersScanner().getPathesToLessonsContents(rootFolder, contentsFileName);

            Map<String, List<String>> allLessonsContents = new AllLessonsContentsMaker().getAllContents(pathesWithContentsFiles);

            ContentsWriter.writeToTxtFile(destinationFileName, allLessonsContents);
        } catch (DataFormatException e) {
            System.out.println("Сheck file names and pathes/ Проверьте имена и адреса файлов");
        }
    }
}