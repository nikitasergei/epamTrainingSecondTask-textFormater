package by.epam.nikitaSergei.interfaces;

import by.epam.nikitaSergei.entity.Text;

/**
 *  The {@code Printer} interface is implemented by {@code print} methods to implement writing to the console.
 */
public interface Printer {

    /**
     * Method print text to console
     * @param text - text for print to console
     */
    void printText (Text text);

    /**
     * When printing to the console, the number of words in the sentence is indicated
     * @param text - text to print
     */

    void printTextWithWordCount (Text text);

    /**
     * When printing text to the console, the original sequence of sentences is restored.
     * @param text - text in any condition
     */
    void printTextInBasicSequence(Text text);
}
