package net.alkeity.homework.homework5;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String rootPath = "F:\\tmps";
        Dictionary dict;
        try {
            dict = new Dictionary("Irish", "English", rootPath);
        }
        catch (FileNotFoundException e) {
            System.out.println("Path does not exists!");
            return;
        }

        dict.addWord("sultmhar", "enjoyable");
    }
}
