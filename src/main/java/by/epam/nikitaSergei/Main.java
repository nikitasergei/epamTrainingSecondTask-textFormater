package by.epam.nikitaSergei;

import by.epam.nikitaSergei.entity.Text;
import by.epam.nikitaSergei.entity.textElements.Sentence;
import by.epam.nikitaSergei.services.TextParser;
import by.epam.nikitaSergei.services.TextService;

public class Main {
    private static String pathToTextFile = "C:/javaProjects/epamTraining/secondHomeTask/src/main/resources/DOC.txt";

    public static void main(String[] args) {


        TextParser textParser = new TextParser();
        Text text1 = new Text(textParser.getTestText(pathToTextFile));
        TextService textService = new TextService();
        textService.sortSentencesByWordCount(text1);


    }
}
