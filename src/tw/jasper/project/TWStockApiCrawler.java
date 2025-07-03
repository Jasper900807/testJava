package tw.jasper.project;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TWStockApiCrawler {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入股票代號：");
        String stockNo = scanner.nextLine();

        // 取得當月第一天日期，格式：yyyyMMdd
//        LocalDate now = LocalDate.now();
        LocalDate now = LocalDate.of(2025, 6, 20);
        String date = now.withDayOfMonth(1).format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        String url = String.format("https://www.twse.com.tw/exchangeReport/STOCK_DAY?response=json&date=%s&stockNo=%s", date, stockNo);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(json);

        if (root.has("data") && root.get("data").size() > 0) {
            System.out.println("股票代號：" + stockNo);
            System.out.println("日期       | 成交股數 | 成交金額 | 開盤價 | 最高價 | 最低價 | 收盤價 | 漲跌價差 | 成交筆數");
            for (JsonNode row : root.get("data")) {
                // 每筆資料是一個陣列，依序是：日期、成交股數、成交金額、開盤價、最高價、最低價、收盤價、漲跌價差、成交筆數
                System.out.printf("%s | %s | %s | %s | %s | %s | %s | %s | %s%n",
                        row.get(0).asText(),  // 日期（民國年）
                        row.get(1).asText(),  // 成交股數
                        row.get(2).asText(),  // 成交金額
                        row.get(3).asText(),  // 開盤價
                        row.get(4).asText(),  // 最高價
                        row.get(5).asText(),  // 最低價
                        row.get(6).asText(),  // 收盤價
                        row.get(7).asText(),  // 漲跌價差
                        row.get(8).asText()   // 成交筆數
                );
            }
        } else {
            System.out.println("查無資料，請確認股票代號是否正確或日期是否有資料");
        }
    }
}
