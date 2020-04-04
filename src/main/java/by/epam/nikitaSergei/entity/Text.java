package by.epam.nikitaSergei.entity;

import by.epam.nikitaSergei.entity.textElements.Paragraph;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Text {
    private static final Logger logger = Logger.getLogger(Text.class);

    private List<Paragraph> paragraphs = new ArrayList<>();

    public Text(String text) {
        logger.info("Start create Text");
        if (text.charAt(0) == '\uFEFF')
            text = text.replace(text.charAt(0), ' ').trim();
        while (text.length() > 0) {
            int index = StringUtils.indexOfAny(text, '\u2029');
            if (index > 0) {
                String substring = text.substring(0, index + 1);
                this.paragraphs.add(new Paragraph(substring));
                text = text.replace(substring, "").trim();
            } else {
//                String substring = text.substring(0, text.length()-1);
                this.paragraphs.add(new Paragraph(text));
                text = text.replace(text, "").trim();
            }
        }
        logger.info("Text created");
    }

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

}
