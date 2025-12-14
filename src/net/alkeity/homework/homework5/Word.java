package net.alkeity.homework.homework5;

import java.io.Serializable;
import java.util.ArrayList;

public class Word implements Serializable {
    private String word;
    private ArrayList<String> meaning;
    private int searchCounter;

    public Word(String word) {
        setWord(word);
        this.meaning = new ArrayList<String>();
        this.searchCounter = 0;
    }

    public Word(String word, String meaning) {
        this(word);
        addMeaning(meaning);
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public ArrayList<String> getMeaning() {
        return meaning;
    }

    public void setMeaning(ArrayList<String> meaning) {
        this.meaning = meaning;
    }

    public void addMeaning(String item) {
        this.meaning.add(item);
    }

    public int getSearchCounter() {
        return searchCounter;
    }

    public void incrementSearchCounter() {
        ++this.searchCounter;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Word word1 = (Word) o;
        return searchCounter == word1.searchCounter && word.equals(word1.word) && meaning.equals(word1.meaning);
    }

    @Override
    public int hashCode() {
        int result = word.hashCode();
        result = 31 * result + meaning.hashCode();
        result = 31 * result + searchCounter;
        return result;
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                ", meaning=" + meaning +
                ", searchCounter=" + searchCounter +
                '}';
    }
}
