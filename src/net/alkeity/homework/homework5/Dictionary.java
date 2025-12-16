package net.alkeity.homework.homework5;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;

public class Dictionary {
    private String language;
    private String translationLanguage;
    private Path dirPath;

    public Dictionary(String language, String translationLanguage, String dirPath)
            throws FileNotFoundException {
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

    public Path getDirPath() {
        return dirPath;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setTranslationLanguage(String translationLanguage) {
        this.translationLanguage = translationLanguage;
    }

    public void setDirPath(String dirPath) throws FileNotFoundException {
        Path tmp = Path.of(dirPath);
        if (!Files.exists(tmp)) {
            throw new FileNotFoundException("Provided path does not exists or is not a directory.");
        }
        this.dirPath = tmp;
    }

    public void addWord(String word, String meaning) throws IOException {
        Word newWord = new Word(word, meaning);
        addNewWord(newWord);
    }

    public void addNewWord(Word word) throws IOException {
        ArrayList<Word> dict = getDictionaryByLetter(word.getWord().charAt(0));
        if (
                dict.stream().noneMatch(w -> Objects.equals(w.getWord(), word.getWord()))
        ) dict.add(word);
        saveDictionaryByLetter(word.getWord().charAt(0), dict);
    }

    public Word getWord(String word) throws IOException {
        ArrayList<Word> dict = getDictionaryByLetter(word.charAt(0));
        // TODO get word using binary search, increment counter, record counter and save file
        return new Word("dummy");
    }

    public ArrayList<Word> getDictionaryByLetter(char letter) throws IOException {
        Path dictPath = dirPath.resolve("%s.txt".formatted(Character.toUpperCase(letter)));
        if (Files.notExists(dictPath)) {
            Files.createFile(dictPath);
            return new ArrayList<Word>();
        }

        ArrayList<Word> dict = null;

        try (
                FileInputStream fs = new FileInputStream(dictPath.toString());
                ObjectInputStream os = new ObjectInputStream(fs);
        ) {
            dict = (ArrayList<Word>) os.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return dict;
    }

    public void saveDictionaryByLetter(char letter, ArrayList<Word> dict) throws IOException {
        dict.sort((word1, word2) -> word1.getWord().compareToIgnoreCase(word2.getWord()));
        Path dictPath = dirPath.resolve("%s.txt".formatted(Character.toUpperCase(letter)));
        if (Files.notExists(dictPath)) Files.createFile(dictPath);

        try (
                FileOutputStream fs = new FileOutputStream(dictPath.toString());
                ObjectOutputStream os = new ObjectOutputStream(fs);
                ) {
            os.writeObject(dict);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public ArrayList<Word> getTop10Words() {}

//    public ArrayList<Word> getBottom10Words() {}

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
