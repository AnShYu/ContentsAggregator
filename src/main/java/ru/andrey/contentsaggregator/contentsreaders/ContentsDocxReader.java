package ru.andrey.contentsaggregator.contentsreaders;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.DataFormatException;

public class ContentsDocxReader implements ContentsFileReader {
    @Override
    public List<String> getContentsFromFile(Path path) throws DataFormatException {
        if(path == null) {
            throw new DataFormatException();
        }

        List<String> contentsOfTheFile = Collections.emptyList();

        try (InputStream is = new FileInputStream(path.toFile()); XWPFDocument document = new XWPFDocument(OPCPackage.open(is));
        XWPFWordExtractor extractor = new XWPFWordExtractor(document)) {
            String docText = extractor.getText();
            if(docText != null) {
                contentsOfTheFile = new ArrayList<>();
                contentsOfTheFile.add(docText);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        return contentsOfTheFile; // Возвращает List, чтобы соответствовать сигнатуре интерфейса. Можно интерфейс сделать
        // дженериком, но тогда переделывать еще класс AllLessonsContentsMaker
    }
}
