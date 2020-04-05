package by.epam.nikitaSergei.entity.textElements.sentenceElements;

import by.epam.nikitaSergei.services.SentenceConsistable;
import org.apache.log4j.Logger;

public class PunctuationMark implements SentenceConsistable {

    private static final Logger logger = Logger.getLogger(PunctuationMark.class);

    private String symbol;

    public PunctuationMark(char symbol) {
        this.symbol = String.valueOf(symbol);
        logger.info("New punctuation mark created");
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}

