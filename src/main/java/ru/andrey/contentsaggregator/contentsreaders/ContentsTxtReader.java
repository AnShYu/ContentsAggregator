package ru.andrey.contentsaggregator.contentsreaders;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class ContentsTxtReader implements ContentsFileReader {

    public List<String> getContentsFromFile(Path path) throws DataFormatException {
        if(path == null) {
            throw new DataFormatException();
        }

        List<String> contentsOfTheFile = new ArrayList<>();
        try(Scanner scanner = new Scanner(path)) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                contentsOfTheFile.add(line);
            }

        } catch(IOException e) {
            e.printStackTrace();
        }
        return contentsOfTheFile;
    }

}
