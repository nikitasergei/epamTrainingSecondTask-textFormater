package by.epam.nikitaSergei.services;

import by.epam.nikitaSergei.entity.Text;
import by.epam.nikitaSergei.interfaces.Printer;

import java.awt.print.Printable;

public class TextPrinter implements Printer{

    @Override
    public void printText(Text text) {
        text.getSentences().forEach(System.out::println);
    }

    @Override
    public void printTextWithWordCount(Text text) {
        text.getSentences().forEach(sentence -> System.out.println(sentence + " - " + sentence.getWordCount()));
    }

    @Override
    public void printTextInBasicSequence(Text text) {
        TextService ts = new TextService();
        ts.returnBaseSequence(text);
        printText(text);
    }
}
