package tw.jasper.project;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PttCrawler {
    public static void main(String[] args) throws Exception {
        // 設定網址
        String url = "https://www.ptt.cc/bbs/Gossiping/index.html";

        // 模擬 cookie 同意（PTT 需要年齡驗證）
        Document doc = Jsoup.connect(url)
                .cookie("over18", "1")
                .get();

        // 抓取所有文章標題
        Elements titles = doc.select("div.title a");
        System.out.println("最新文章標題：");
        for (Element title : titles) {
            System.out.println("- " + title.text());
        }
    }
}
