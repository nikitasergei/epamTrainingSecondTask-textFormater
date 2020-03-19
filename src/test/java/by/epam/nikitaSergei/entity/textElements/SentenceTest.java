package by.epam.nikitaSergei.entity.textElements;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SentenceTest {

    @Test
    public void shouldReturnCorrectWordNumber() {
        String content = "Long ago, before Gutenberg, if you wanted to know something, you had to memorize it."; //numbOfWords = 15, numbOfElements = 19
        Sentence sentence = new Sentence(content);
        Assert.assertEquals(sentence.getWordCount(), 15);
    }

    @Test
    public void shouldBeThrownNullPointerException() {
        String content = null;
        Assert.assertThrows(NullPointerException.class, () -> new Sentence(content));
    }
}