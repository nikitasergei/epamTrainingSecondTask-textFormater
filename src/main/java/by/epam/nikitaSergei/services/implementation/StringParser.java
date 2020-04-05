package by.epam.nikitaSergei.services.implementation;

import by.epam.nikitaSergei.entity.textElements.Paragraph;
import by.epam.nikitaSergei.entity.textElements.Sentence;
import by.epam.nikitaSergei.entity.textElements.sentenceElements.PunctuationMark;
import by.epam.nikitaSergei.entity.textElements.sentenceElements.Word;
import by.epam.nikitaSergei.services.SentenceConsistable;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class StringParser {
    private static final Logger LOGGER = Logger.getLogger(StringParser.class);

    /**
     * Method parse {@param text} and @return list of Paragraph objects, which {@param text} contains.
     *
     * @param text - text for parsing
     * @return List of Paragraph objects, which {@param text} contains
     */
    public static List<Paragraph> parseText(String text) {
        List<Paragraph> paragraphs = new ArrayList<>();
        if (text.charAt(0) == '\uFEFF')
            text = text.replace(text.charAt(0), ' ').trim();
        while (text.length() > 0) {
            int index = StringUtils.indexOfAny(text, '\u2029');
            if (index < 0)
                index = text.indexOf("    ");
            if (index > 0) {
                String substring = text.substring(0, index + 1);
                paragraphs.add(new Paragraph(substring));
                text = text.replace(substring, "").trim();
            } else {
                paragraphs.add(new Paragraph(text));
                text = text.replace(text, "").trim();
            }
        }
        return paragraphs;
    }

    /**
     * Method parse {@param paragraph} and @return List of Sentence objects, which this paragraph contains .
     *
     * @param paragraph - paragraph which must be parsed
     * @return List of Sentence
     */
    public static List<Sentence> parseParagraph(String paragraph) {
        List<Sentence> sentences = new ArrayList<>();
        if (paragraph.charAt(0) == '\uFEFF')
            paragraph = paragraph.replace(paragraph.charAt(0), ' ').trim();
        while (paragraph.length() > 0) {
            int index = StringUtils.indexOfAny(paragraph, ".", "!", "?");
            String substring = paragraph.substring(0, index + 1);
            sentences.add(new Sentence(substring));
            paragraph = paragraph.replace(substring, "").trim();
        }
        return sentences;
    }

    /**
     * Method parse {@param sentence} and @return List of elements which this sentence contains.
     *
     * @param sentence - sentence which must be parsed
     * @return list 0f SentenceConsistable elements
     */
    public static List<SentenceConsistable> parseSentence(String sentence) {
        List<SentenceConsistable> sentenceElements = new ArrayList<>();
        int iterator = 0;
        while (sentence.length() > 0) {
            char symbol = sentence.charAt(iterator);
            if (Character.isLetterOrDigit(symbol) || symbol == '\'') {              //if letter or digit and word is NOT complete
                iterator++;
            } else if (Character.isWhitespace(symbol)) {                            //if whiteSpace
                sentenceElements.add(new Word(sentence.substring(0, iterator)));
                sentence = sentence.substring(iterator).trim();
                iterator = 0;
            } else if (iterator == 0) {                                              //if punctuation mark
                sentenceElements.add(new PunctuationMark(symbol));
                sentence = sentence.substring(1).trim();
                iterator = 0;
            } else {                                                                 //if letter or digit and word is complete
                String substring = sentence.substring(0, iterator);
                sentenceElements.add(new Word(substring));
                sentence = sentence.replace(substring, " ").trim();
                iterator = 0;
            }
        }
        LOGGER.info("New sentence created");
        return sentenceElements;
    }
}
