package by.epam.nikitaSergei.services.implementation;

import by.epam.nikitaSergei.services.TextReader;
import org.testng.Assert;
import org.testng.annotations.Test;

//In this TestClass when we call StringParser.parseText(), all other StringParser.class methods are called automatically
public class StringParserTest {
    private TextReader textReader = new TextFileReader();
    private StringParser stringParser = new StringParser();
    private String text = textReader.getTestText("C:/Users/User/Desktop/epamTrainingSecondTask-textFormater/src/main/resources/TextForTest.txt");

    @Test
    public void shouldReturnCorrectNumberOfParagraphs() {
        Assert.assertEquals(3, StringParser.parseText(text).size());
    }

    @Test
    public void shouldReturnCorrectNumberOfSentences() {
        Assert.assertEquals(8, StringParser.parseText(text).get(0).getSentences().size());
    }

    @Test
    public void shouldReturnCorrectNumberOfSentenceConsistableElements() {
        Assert.assertEquals(10, StringParser.parseText(text).get(0).getSentences().get(0).getSentenceElements().size());
    }
}