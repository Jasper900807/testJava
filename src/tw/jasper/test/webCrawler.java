package tw.jasper.test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class webCrawler {

	public static void main(String[] args) {
		String src = "https://www.leagueoflegends.com/en-us/news/tags/patch-notes";
		
		System.out.printf("Trying to connect to %s ...\n", src);
		String words = "", title = "";
		
		try {
			Document doc = Jsoup.connect(src).get();
			Elements elements = doc.body().select("*");
			title = doc.title();
			for (Element elem : elements) {
				if (!elem.ownText().equals("")) {
					words += ' ' + elem.ownText();
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.printf("fetch words from %s :\n...\n", title);
		String[] parts = words.split("\\s");
		
		for (String part : parts) {
			System.out.println(part);			
		}
		
	}

}
