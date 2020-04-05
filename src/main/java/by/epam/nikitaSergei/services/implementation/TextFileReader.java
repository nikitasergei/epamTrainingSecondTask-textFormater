package by.epam.nikitaSergei.services.implementation;

import by.epam.nikitaSergei.services.TextReader;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextFileReader implements TextReader {
    private static final Logger logger = Logger.getLogger(TextFileReader.class);

    @Override
    public String getTestText(String path) {
        try {
            return Files.lines(Paths.get(path))
                    .reduce("", String::concat).trim();
        } catch (IOException exception) {
            logger.error(exception);
        }
        return null;
    }
}
