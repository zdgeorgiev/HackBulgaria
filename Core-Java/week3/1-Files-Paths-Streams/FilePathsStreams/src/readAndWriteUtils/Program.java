package readAndWriteUtils;

import java.io.File;
import java.io.IOException;

public class Program {

    public static void main(String[] args) {
        FileUtils fileUtils = FileUtils.getInstance();
        File file = new File("../testData/testData/A/b.txt");

        System.out.println(file.exists());

        try {
            // Read from file
            System.out.println(fileUtils.readFrom(file));
            // Read from path
            System.out.println(fileUtils.readFrom(file.toPath()));
            // Write to file
            fileUtils.writeTo(new File("../testData/testData/A/b.txt"), "1");
            System.out.println(fileUtils.readFrom(new File("../testData/testData/A/b.txt")));
            // Write to path
            fileUtils.writeTo(new File("../testData/testData/A/b.txt").toPath(), "2");
            System.out.println(fileUtils.readFrom(new File("../testData/testData/A/b.txt")));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}