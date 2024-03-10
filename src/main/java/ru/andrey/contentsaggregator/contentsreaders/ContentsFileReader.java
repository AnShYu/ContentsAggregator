package ru.andrey.contentsaggregator.contentsreaders;

import java.nio.file.Path;
import java.util.List;
import java.util.zip.DataFormatException;

public interface ContentsFileReader  {
    List<String> getContentsFromFile(Path path) throws DataFormatException;
}
