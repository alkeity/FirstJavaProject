package net.alkeity.homework.homework7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TxtContentComparer {
    public Path path1;
    public Path path2;

    public TxtContentComparer(Path path1, Path path2) {
        this.path1 = path1;
        this.path2 = path2;
    }

    public boolean compareContent() {
        List<String> content1, content2;
        try {
            content1 = Files.readAllLines(path1);
            content2 = Files.readAllLines(path2);
        }
        catch (IOException e) {
            System.out.println("Couldn't read files: " + e.getMessage());
            return false;
        }

        boolean isIdentical = content1.size() == content2.size();
        int len = Math.min(content1.size(), content2.size());
        for (int i = 0; i < len; i++) {
            if (!content1.get(i).equals(content2.get(i))) {
                isIdentical = false;
                System.out.printf("%s          %s\n", content1.get(i), content2.get(i));
            }
        }

        if (content1.size() > content2.size()) {
            for (int i = len; i < content1.size(); i++) {
                System.out.printf("%s          -\n", content1.get(i));
            }
        }
        else if (content2.size() > content1.size()) {
            for (int i = len; i < content2.size(); i++) {
                System.out.printf("-          %s\n", content2.get(i));
            }
        }

        return isIdentical;
    }
}
