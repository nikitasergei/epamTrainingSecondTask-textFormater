package by.epam.nikitaSergei;

import by.epam.nikitaSergei.entity.Text;
import by.epam.nikitaSergei.services.implementation.TextFileReader;
import by.epam.nikitaSergei.services.implementation.TextPrinter;
import by.epam.nikitaSergei.services.implementation.TextService;

public class Main {
    private static String pathToTextFile = "C:/javaProjects/epamTraining/secondHomeTask/src/main/resources/DOC.txt";

    public static void main(String[] args) {

        TextFileReader textParser = new TextFileReader();
        Text text1 = new Text(textParser.getTestText(pathToTextFile));
        TextPrinter textPrinter = new TextPrinter();
        textPrinter.printText(text1);
        TextService textService = new TextService();
        textService.sortSentencesByWordCount(text1);

    }
}
