package parallelCrawler;

import java.io.IOException;
import java.net.URL;

public class Program {
    public static void main(String[] args) throws IOException {
        String website = "http://9gag.com/";
        URL url = new URL(website);
        ParallelCrawler crawler = new ParallelCrawler(url, "meh");
    }
}
