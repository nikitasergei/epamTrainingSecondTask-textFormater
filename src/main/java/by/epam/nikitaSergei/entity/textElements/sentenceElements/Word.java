package by.epam.nikitaSergei.entity.textElements.sentenceElements;

import by.epam.nikitaSergei.interfaces.SentenceConsistable;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class Word implements SentenceConsistable {
    private static final Logger logger = Logger.getLogger(Word.class);

    private List<Character> symbols = new ArrayList<>();

    public Word(String word) {
        for (int i = 0; i < word.length(); i++) {
            symbols.add(word.charAt(i));
        }
        logger.info("New word created");
    }

    public List<Character> getSymbols() {
        return symbols;
    }

    @Override
    public String toString() {
        StringBuilder word = new StringBuilder();
        for (Character symbol : symbols) {
            word.append(symbol);
        }
        return word.toString();
    }
}
