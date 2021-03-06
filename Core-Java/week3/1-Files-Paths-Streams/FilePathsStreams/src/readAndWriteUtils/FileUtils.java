package readAndWriteUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Path;

public class FileUtils {
    private static FileUtils instance = null;

    private FileUtils() {
    }

    public static synchronized FileUtils getInstance() {
        if (instance == null) {
            instance = new FileUtils();
        }

        return instance;
    }

    public String readFrom(File file) throws IOException {
        StringBuilder output = new StringBuilder();

        try (BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),
                Charset.defaultCharset()))) {

            String sCurrentLine = bReader.readLine();

            while (sCurrentLine != null) {
                output.append(sCurrentLine);
                sCurrentLine = bReader.readLine();

                if (sCurrentLine != null) {
                    output.append(String.format("%n"));
                }
            }
        }

        return output.toString();
    }

    public String readFrom(Path path) throws IOException {
        return this.readFrom(new File(path.toString()));
    }

    public void writeTo(File file, String text) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }

        try (BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),
                Charset.defaultCharset()))) {

            for (int i = 0; i < text.length(); i++) {
                bWriter.write(text.charAt(i));
            }
        }
    }

    public void writeTo(Path path, String text) throws IOException {
        this.writeTo(new File(path.toString()), text);
    }
}