package by.epam.nikitaSergei.services;

import by.epam.nikitaSergei.entity.Text;
import by.epam.nikitaSergei.entity.textElements.Sentence;
import by.epam.nikitaSergei.interfaces.FormatService;

import java.util.Comparator;

public class TextService implements FormatService {

    @Override
    public void sortSentencesByWordCount(Text text) {
        text.getSentences().sort(Comparator.comparingInt(Sentence::getWordCount));

    }

    public void returnBaseSequence(Text text) {
        text.getSentences().sort((sent1, sent2) -> (int) (sent1.getId() - sent2.getId()));
    }
}
