package textCompression;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import readAndWriteUtils.FileUtils;

public class UtilsTests {

    private String expected;
    private String actual;

    @Before
    public void init() {
        this.expected = null;
        this.actual = null;
    }

    @Test
    public void testCompression() {
        Path source = Paths.get("../testData/testData/compressThis.txt");
        Path destination = Paths.get("../testData/testData/compressed.txt");

        try {
            Utils.compressFile(source, destination);

            actual = FileUtils.getInstance().readFrom(destination.toFile());
            expected = "buffalo,rides,a|~0 ~0 ~0 ~1 ~2 ~0 ~0 ~0.";
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        assertEquals(actual.equals(expected), true);
    }

    @Test
    public void testWithTempFiles() {
        Path source = Paths.get("../testData/testData/c.txt");
        Path destination = Paths.get("../testData/testData/c2.txt");

        try {
            StringBuilder text = new StringBuilder();
            text.append("We are humans, humans are animals, animals are cute!");

            FileUtils.getInstance().writeTo(source, text.toString());
            Utils.compressFile(source, destination);

            actual = FileUtils.getInstance().readFrom(destination);
            expected = "We,are,humans,animals,cute|~0 ~1 ~2, ~2 ~1 ~3, ~3 ~1 ~4!";

            source.toFile().delete();
            destination.toFile().delete();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        assertEquals(actual.equals(expected), true);
    }

    @Test
    public void testDecompressionTempFiles() {
        Path source = Paths.get("../testData/testData/c.txt");
        Path destination = Paths.get("../testData/testData/c2.txt");

        try {
            StringBuilder text = new StringBuilder();
            text.append("We,are,humans,animals,cute|~0 ~1 ~2, ~2 ~1 ~3, ~3 ~1 ~4!");

            FileUtils.getInstance().writeTo(source, text.toString());
            Utils.decompressFile(source, destination);

            actual = FileUtils.getInstance().readFrom(destination);
            expected = "We are humans, humans are animals, animals are cute!";

            source.toFile().delete();
            destination.toFile().delete();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        assertEquals(actual.equals(expected), true);
    }

    @Test
    public void testDecompressionTempFiles2() {
        Path source = Paths.get("../testData/testData/c.txt");
        Path destination = Paths.get("../testData/testData/c2.txt");

        try {
            StringBuilder text = new StringBuilder();
            text.append("buffalo,rides,a|~0 ~0 ~0 ~1 ~2 ~0 ~0 ~0.");

            FileUtils.getInstance().writeTo(source, text.toString());
            Utils.decompressFile(source, destination);

            actual = FileUtils.getInstance().readFrom(destination);
            expected = "buffalo buffalo buffalo rides a buffalo buffalo buffalo.";

            source.toFile().delete();
            destination.toFile().delete();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        assertEquals(actual.equals(expected), true);
    }
}