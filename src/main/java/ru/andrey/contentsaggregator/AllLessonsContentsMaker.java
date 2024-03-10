package ru.andrey.contentsaggregator;

import ru.andrey.contentsaggregator.contentsreaders.ContentsDocxReader;
import ru.andrey.contentsaggregator.contentsreaders.ContentsFileReader;
import ru.andrey.contentsaggregator.contentsreaders.ContentsTxtReader;
import ru.andrey.contentsaggregator.parsers.LessonNameParser;
import ru.andrey.contentsaggregator.parsers.StringParser;

import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;

public class AllLessonsContentsMaker {

    public Map<String, List<String>> getAllContents(List<Path> pathes) throws DataFormatException {
        if(pathes == null) {
            throw new DataFormatException();
        }

        Map<String, List<String>> allContents = new LinkedHashMap<>();
        ContentsFileReader cr;
        StringParser sp = new LessonNameParser();

        if(pathes.get(0).toString().endsWith(".txt")) {
            cr = new ContentsTxtReader();
        } else if(pathes.get(0).toString().endsWith(".docx")) {
            cr = new ContentsDocxReader();
        } else {
            throw new DataFormatException();
        }

        for(Path path: pathes) {
            String lessonName = sp.getParsedString(path.toString());
            allContents.put(lessonName, cr.getContentsFromFile(path));
        }

        return allContents;
    }
}
