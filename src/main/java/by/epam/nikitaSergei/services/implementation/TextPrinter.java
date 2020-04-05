package by.epam.nikitaSergei.services.implementation;

import by.epam.nikitaSergei.entity.Text;
import by.epam.nikitaSergei.services.Printer;

public class TextPrinter implements Printer {

    @Override
    public void printText(Text text) {
        text.getParagraphs().forEach(paragraph -> System.out.print(paragraph + " "));
    }

    @Override
    public void printTextWithWordCount(Text text) {
        text.getParagraphs().forEach(paragraph -> paragraph.getSentences()
                .forEach(sentence -> System.out.println(sentence + " - " + sentence.getWordCount())));
    }

    @Override
    public void printTextInBasicSequence(Text text) {
        TextService ts = new TextService();
        ts.returnBaseSequence(text);
        printText(text);
    }
}
