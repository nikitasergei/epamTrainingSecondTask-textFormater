package by.epam.nikitaSergei.entity.textElements;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Paragraph {
    private List<Sentence> sentences = new ArrayList<>();

    public Paragraph(String paragraph) {
        if (paragraph.charAt(0) == '\uFEFF')
            paragraph = paragraph.replace(paragraph.charAt(0), ' ').trim();
        while (paragraph.length() > 0) {
            int index = StringUtils.indexOfAny(paragraph, ".", "!", "?");
            String substring = paragraph.substring(0, index + 1);
            this.sentences.add(new Sentence(substring));
            paragraph = paragraph.replace(substring, "").trim();
        }
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
