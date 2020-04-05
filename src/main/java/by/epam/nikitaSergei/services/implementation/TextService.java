package by.epam.nikitaSergei.services.implementation;

import by.epam.nikitaSergei.entity.Text;
import by.epam.nikitaSergei.entity.textElements.Sentence;
import by.epam.nikitaSergei.services.FormatService;

import java.util.Comparator;

public class TextService implements FormatService {

    @Override
    public void sortSentencesByWordCount(Text text) {
        text.getParagraphs().forEach(paragraph -> paragraph.getSentences().sort(Comparator.comparingInt(Sentence::getWordCount)));
    }

    public void returnBaseSequence(Text text) {
        text.getParagraphs().forEach(paragraph -> paragraph.getSentences().sort((sent1, sent2) -> (int) (sent1.getId() - sent2.getId())));
    }
}
