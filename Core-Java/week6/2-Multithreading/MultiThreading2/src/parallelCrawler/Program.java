package parallelCrawler;

import java.io.IOException;
import java.net.URL;

public class Program {
    public static void main(String[] args) throws IOException {
        String website = "https://www.facebook.com/";
        URL url = new URL(website);
        ParallelCrawler crawler = new ParallelCrawler(url, "meh");
    }
}
