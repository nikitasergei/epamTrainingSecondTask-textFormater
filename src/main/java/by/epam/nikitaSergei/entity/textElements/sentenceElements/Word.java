package by.epam.nikitaSergei.entity.textElements.sentenceElements;

import by.epam.nikitaSergei.interfaces.SentenceConsistable;
import org.apache.log4j.Logger;


public class Word implements SentenceConsistable {
    private static final Logger logger = Logger.getLogger(Word.class);

    private String value;

    public Word(String word) {
        this.value = word;
        logger.info("New word created");
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
