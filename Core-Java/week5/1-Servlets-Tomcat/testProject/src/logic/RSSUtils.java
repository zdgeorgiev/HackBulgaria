package logic;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class RSSUtils {
	
	public static List<RSSObject> getContent() {
		List<RSSObject> objects = new ArrayList<RSSObject>();
		
		URL url = null;
    	HttpURLConnection httpcon = null;
    	SyndFeed feed = null;
    	
		try {
	    	// Reading the feed
	    	SyndFeedInput input = new SyndFeedInput();
			url = new URL("http://www.dnevnik.bg/rss/");
			httpcon = (HttpURLConnection)url.openConnection();
			feed = input.build(new XmlReader(httpcon));
		} catch (IllegalArgumentException | FeedException | IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
    	List entries = feed.getEntries();
    	Iterator itEntries = entries.iterator();

    	while (itEntries.hasNext()) {
        	SyndEntry entry = (SyndEntry) itEntries.next();
        	RSSObject currentObj = new RSSObject();

        	currentObj.setTitle(entry.getTitle());
        	currentObj.setLink(entry.getLink());
        	currentObj.setDate(entry.getPublishedDate());
        	currentObj.setContent(entry.getDescription().getValue());
        	
        	objects.add(currentObj);
    	}
    	
    	return objects;
	}
}