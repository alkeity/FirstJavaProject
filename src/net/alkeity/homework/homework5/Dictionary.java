package net.alkeity.homework.homework5;

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
