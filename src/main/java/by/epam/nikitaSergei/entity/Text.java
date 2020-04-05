package by.epam.nikitaSergei.entity;

import by.epam.nikitaSergei.entity.textElements.Paragraph;
import by.epam.nikitaSergei.services.implementation.StringParser;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Text {
    private static final Logger LOGGER = Logger.getLogger(Text.class);

    private List<Paragraph> paragraphs = new ArrayList<>();

    public Text(String text) {
        this.paragraphs = StringParser.parseText(text);
        LOGGER.info("Text is parsed");
    }

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }
}
