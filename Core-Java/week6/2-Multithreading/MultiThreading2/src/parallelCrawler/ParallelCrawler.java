package parallelCrawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParallelCrawler {
    private BlockQueue<URL> links = new BlockQueue<>(50);
    private BlockQueue<String> contents = new BlockQueue<String>(50);
    private List<URL> visited = new ArrayList<>();
    private String needle;
    private static String domain = null;
    private boolean isFound = false;

    private Object lock = new Object();

    public ParallelCrawler(URL url, String needle) {
        domain = url.toString();
        this.needle = needle;
        this.links.add(url);
        this.startThreads();
    }

    private void getNextLinkContent() {

        URL url = this.links.poll();

        synchronized (lock) {
            if (!this.visited.contains(url)) {
                System.out.println(Thread.currentThread().getName() + " Added - \t\t" + url.toString());
                visited.add(url);
            } else {
                return;
            }
        }

        System.out.println(Thread.currentThread().getName() + " Currently Crawling - \t" + url.toString());

        BufferedReader in;
        StringBuilder content = new StringBuilder();

        try {
            in = new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName("UTF-8")));

            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();

        } catch (IOException e) {
        }

        System.out.println(Thread.currentThread().getName() + " Crawed - \t\t" + url.toString());
        this.contents.add(content.toString());
    }

    private void seachForNeedle() {
        String content = this.contents.poll();

        if (content.contains(needle)) {
            System.out.println("Found (out of " + visited.size() + " searched urls)");
            return;
        }

        ArrayList<String> links = getAllLinks(content);

        for (String next : links) {
            if (next.contains("http")) {
                if (!next.contains(domain)) {
                    continue;
                }
            }

            if (next.contains("/")) {
                next = next.substring(next.lastIndexOf("/") + 1);
            }

            URL nextUrl;

            try {
                nextUrl = new URL(domain + next);

                synchronized (lock) {
                    if (!this.visited.contains(nextUrl))
                        this.links.add(nextUrl);
                }
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void startThreads() {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                while (!isFound) {
                    getNextLinkContent();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                while (!isFound) {
                    getNextLinkContent();
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            public void run() {
                while (!isFound) {
                    getNextLinkContent();
                }
            }
        });

        Thread t4 = new Thread(new Runnable() {
            public void run() {
                while (!isFound) {
                    getNextLinkContent();
                }
            }
        });

        Thread t5 = new Thread(new Runnable() {
            public void run() {
                while (!isFound) {
                    seachForNeedle();
                }
            }
        });

        Thread t6 = new Thread(new Runnable() {
            public void run() {
                while (!isFound) {
                    seachForNeedle();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static ArrayList<String> getAllLinks(String url) {
        ArrayList<String> resultList = new ArrayList<>();
        String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);

        while (matcher.find()) {
            resultList.add(matcher.group(1));
        }

        return resultList;
    }
}
