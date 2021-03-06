package fixSubtitles;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Program {
    public static void main(String[] args) throws IOException {
        fixEncoding(new File("../testData/testData/lost.s04e11.hdtv.xvid-2hd.srt").toPath());
    }

    private static void fixEncoding(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path, Charset.forName("Windows-1251"));
        Files.write(Paths.get("../testData/testData/lost.s04e11.hdtv.xvid-2hdFixed.html"), lines,
                StandardCharsets.UTF_8);
    }
}