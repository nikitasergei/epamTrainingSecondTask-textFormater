package by.epam.nikitaSergei.entity;

import by.epam.nikitaSergei.entity.textElements.Sentence;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Text {
    private static final Logger logger = Logger.getLogger(Text.class);

    private List<Sentence> sentences = new ArrayList<>();

    public Text(String text) {
        logger.info("Start create Text");
        if (text.charAt(0) == '\uFEFF')
            text = text.replace(text.charAt(0), ' ').trim();
        while (text.length() > 0) {
            int index = StringUtils.indexOfAny(text, ".", "!", "?");
            String substring = text.substring(0, index + 1);
            this.sentences.add(new Sentence(substring));
            text = text.replace(substring, "").trim();
        }
        logger.info("Text created");
    }

    public List<Sentence> getSentences() {
        return sentences;
    }
}
