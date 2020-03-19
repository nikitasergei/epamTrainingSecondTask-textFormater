package by.epam.nikitaSergei.entity.textElements;

import by.epam.nikitaSergei.entity.textElements.sentenceElements.PunctuationMark;
import by.epam.nikitaSergei.entity.textElements.sentenceElements.Word;
import by.epam.nikitaSergei.interfaces.SentenceConsistable;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private static final Logger logger = Logger.getLogger(Sentence.class);
    private static long countId = 1;

    private List<SentenceConsistable> sentenceElements = new ArrayList<>();
    private long id;

    public Sentence(String sentence) {
        if (sentence.substring(sentence.length() - 1).matches("[.!?]")) {
            this.id = countId;
            countId++;
            int iterator = 0;
            while (sentence.length() > 0) {
                char symbol = sentence.charAt(iterator);
                if (Character.isLetterOrDigit(symbol) || symbol == '\'') {              //if letter or digit and word is NOT complete
                    iterator++;
                } else if (Character.isWhitespace(symbol)) {                            //if whiteSpace
                    String substring = sentence.substring(0, iterator);
                    this.sentenceElements.add(new Word(substring));
                    sentence = sentence.substring(iterator).trim();
                    iterator = 0;
                } else if (iterator == 0) {                                              //if punctuation mark
                    this.sentenceElements.add(new PunctuationMark(symbol));
                    sentence = sentence.substring(1).trim();
                    iterator = 0;
                } else {                                                                 //if letter or digit and word is complete
                    String substring = sentence.substring(0, iterator);
                    this.sentenceElements.add(new Word(substring));
                    sentence = sentence.replace(substring, " ").trim();
                    iterator = 0;
                }
            }
            logger.info("New sentence created");
        } else throw new IllegalArgumentException();
    }

    /**
     * @return number of objects instance of Word.class in each sentence.
     */
    public int getWordCount() {
        return (int) this.getSentenceElements().stream()
                .filter(sentenceConsistable -> sentenceConsistable.getClass().equals(Word.class))
                .count();
    }

    public long getId() {
        return id;
    }

    public List<SentenceConsistable> getSentenceElements() {
        return sentenceElements;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("");
        for (int elementIndex = 0; elementIndex < this.sentenceElements.size(); elementIndex++) {
            if (this.sentenceElements.get(elementIndex).getClass().equals(PunctuationMark.class)) {
                sb.append(this.sentenceElements.get(elementIndex));
                if (elementIndex != this.sentenceElements.size() - 1) {
                    sb.append(" ");
                }
            } else if (this.sentenceElements.get(elementIndex + 1).getClass().equals(PunctuationMark.class)) {
                sb.append(this.sentenceElements.get(elementIndex));
            } else sb.append(this.sentenceElements.get(elementIndex)).append(" ");
        }
        return sb.toString();
    }
}
