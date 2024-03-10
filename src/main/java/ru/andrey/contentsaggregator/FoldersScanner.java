package ru.andrey.contentsaggregator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FoldersScanner {

    public List<Path> getPathesToLessonsContents(String rootFolder, String fileName) {
        List<Path> pathsWithRequiredFiles = null;
        if (rootFolder != null && fileName != null) {
            try (Stream<Path> paths = Files.walk(Paths.get(rootFolder))) {
                pathsWithRequiredFiles = paths.filter(path -> {
                            String file = path.getFileName().toString();
                            return fileName.equals(file);
                        })
                        .collect(Collectors.toList());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(pathsWithRequiredFiles == null) {
            pathsWithRequiredFiles = Collections.emptyList();
        } else if(pathsWithRequiredFiles != null && pathsWithRequiredFiles.isEmpty()) {
            pathsWithRequiredFiles = Collections.emptyList();
        }
        return pathsWithRequiredFiles;
    }

}
