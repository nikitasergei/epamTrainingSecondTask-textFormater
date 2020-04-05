package by.epam.nikitaSergei.services;

public interface TextReader {
    /**
     * Method get path to file with text on local directory, and return file content as String object.
     * @param path - path to file with text
     * @return text from file as String
     */
    String getTestText(String path);
}
