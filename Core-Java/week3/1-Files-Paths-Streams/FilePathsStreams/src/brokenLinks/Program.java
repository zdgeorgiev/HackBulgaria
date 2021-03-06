package brokenLinks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Program {
    public static void main(String[] args) throws IOException {
        System.out.println("Running");
        findBrokenLinks(Paths.get("D:\\Downloads"));
        System.out.println("Finished");
    }

    public static void findBrokenLinks(Path path) throws IOException {
        for (File currentFile : path.toFile().listFiles()) {
            if (currentFile.isDirectory()) {
                findBrokenLinks(currentFile.toPath());
            } else {
                if (Files.isSymbolicLink(currentFile.toPath())) {
                    if (Files.readSymbolicLink(currentFile.toPath()) == null) {
                        System.out.println("Broken - " + path.toFile());
                    }
                }
            }
        }
    }
}