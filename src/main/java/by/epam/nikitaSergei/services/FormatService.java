package by.epam.nikitaSergei.services;

import by.epam.nikitaSergei.entity.Text;

public interface FormatService {

    /**
     * This method sort {@param text} in ascending order of elements instance of Word.class in a sentence.
     * @param text - text in any condition
     */
    void sortSentencesByWordCount(Text text);

    /**
     * This method return {@param text} to base sequence of sentences
     * @param text - text to format.
     */
    void returnBaseSequence(Text text);
}
