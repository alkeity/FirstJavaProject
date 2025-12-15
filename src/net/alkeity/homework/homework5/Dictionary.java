package net.alkeity.homework.homework5;

import java.util.ArrayList;
import java.util.Collections;

public class Dictionary {
    private String language;
    private String translationLanguage;
    private String dirPath;

    public Dictionary(String language, String translationLanguage, String dirPath) {
        setLanguage(language);
        setTranslationLanguage(translationLanguage);
        setDirPath(dirPath);
    }

    public String getLanguage() {
        return language;
    }

    public String getTranslationLanguage() {
        return translationLanguage;
    }

    public String getDirPath() {
        return dirPath;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setTranslationLanguage(String translationLanguage) {
        this.translationLanguage = translationLanguage;
    }

    public void setDirPath(String dirPath) {
        // TODO check if folder exists
        this.dirPath = dirPath;
    }

    public void addWord(String word, String meaning) {
        Word newWord = new Word(word, meaning);
        ArrayList<Word> dict = getDictionaryByLetter(word.charAt(0));
        dict.add(newWord);
        saveDictionaryByLetter(word.charAt(0), dict);
    }

    public void addWord(String word) {}

    public Word getWord(String word) {
        ArrayList<Word> dict = getDictionaryByLetter(word.charAt(0));
        // TODO get word using binary search, increment counter, record counter and save file
        return new Word("dummy");
    }

    public ArrayList<Word> getDictionaryByLetter(char letter) {
        // TODO get obj list from specified file
        ArrayList<Word> dict = new ArrayList<Word>();
        return dict;
    }

    public void saveDictionaryByLetter(char letter, ArrayList<Word> dict) {
        dict.sort((word1, word2) -> word1.getWord().compareToIgnoreCase(word2.getWord()));
        // TODO
    }

    public ArrayList<Word> getTop10Words() {}

    public ArrayList<Word> getBottom10Words() {}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Dictionary that = (Dictionary) o;
        return language.equals(that.language) && translationLanguage.equals(that.translationLanguage) && dirPath.equals(that.dirPath);
    }

    @Override
    public int hashCode() {
        int result = language.hashCode();
        result = 31 * result + translationLanguage.hashCode();
        result = 31 * result + dirPath.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "language='" + language + '\'' +
                ", translationLanguage='" + translationLanguage + '\'' +
                ", dirPath='" + dirPath + '\'' +
                '}';
    }
}
