package by.epam.nikitaSergei.services;

import by.epam.nikitaSergei.entity.Text;
import by.epam.nikitaSergei.entity.textElements.Sentence;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextServiceTest {
    private TextParser textParser = new TextParser();
    private TextService textService = new TextService();
    private String path = "C:/javaProjects/epamTraining/secondHomeTask/src/main/resources/DOC.txt";
    private Text text = new Text(textParser.getTestText(path));

    @Test
    public void shouldReturnTextWithCorrectSortedSentences() {
        textService.sortSentencesByWordCount(text);
        Sentence firstSentence = text.getSentences().get(0);
        Sentence secondSentence = text.getSentences().get(1);
        Sentence lastSentence = text.getSentences().get(text.getSentences().size() - 1);

        int firstSentenceWordsNumber = firstSentence.getWordCount();
        int secondSentenceWordsNumber = secondSentence.getWordCount();
        int lastSentenceWordsNumber = lastSentence.getWordCount();

        Assert.assertTrue(firstSentenceWordsNumber <= secondSentenceWordsNumber);
        Assert.assertTrue(firstSentenceWordsNumber <= lastSentenceWordsNumber);
        Assert.assertTrue(secondSentenceWordsNumber <= lastSentenceWordsNumber);
    }

    @Test
    public void testReturnBaseSequence() {
        String text = "This is first sentence for compare and it's will be bigger then second. And this is second sentence for compare.";
        Text textForTest = new Text(text);
        textService.sortSentencesByWordCount(textForTest);
        Assert.assertNotEquals("This is first sentence for compare and it's will be bigger then second.", textForTest.getSentences().get(0).toString());
        Assert.assertNotEquals("And this is second sentence for compare.", textForTest.getSentences().get(1).toString());
        textService.returnBaseSequence(textForTest);
        Assert.assertEquals("This is first sentence for compare and it's will be bigger then second.", textForTest.getSentences().get(0).toString());
        Assert.assertEquals("And this is second sentence for compare.", textForTest.getSentences().get(1).toString());

    }
}