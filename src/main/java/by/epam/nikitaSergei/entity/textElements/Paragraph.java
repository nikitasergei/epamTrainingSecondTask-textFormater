package by.epam.nikitaSergei.entity.textElements;

import by.epam.nikitaSergei.services.implementation.StringParser;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Paragraph {
    private static Logger LOGGER = Logger.getLogger(Paragraph.class);
    private List<Sentence> sentences = new ArrayList<>();

    public Paragraph(String paragraph) {
        this.sentences = StringParser.parseParagraph(paragraph);
        LOGGER.info("Paragraph is parsed");
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("");
        for (Sentence sentence : sentences) {
            sb.append(sentence.toString()).append(" ");
        }
        return sb.toString();
    }
}
