package by.epam.nikitaSergei.interfaces;

public interface Parser {
    /**
     * Method get path to file with text on local directory, and return file content as String object.
     * @param path - path to file with text
     * @return text from file as String
     */
    String getTestText(String path);
}
