package tw.jasper.test;

import java.sql.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class test {
    public static void main(String[] args) {
        String cname = args.length > 0 ? args[0] : "王大明";
        String url = "jdbc:mysql://localhost:3306/AddressBook?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "root";

        String sql = "SELECT h.address, p.tel " +
                     "FROM UserInfo u " +
                     "JOIN Live l ON u.uid = l.uid " +
                     "JOIN House h ON l.hid = h.hid " +
                     "LEFT JOIN Phone p ON h.hid = p.hid " +
                     "WHERE u.cname = ?";

        JSONArray resultArr = new JSONArray();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cname);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                JSONObject obj = new JSONObject();
                obj.put("address", rs.getString("address"));
                obj.put("tel", rs.getString("tel"));
                resultArr.put(obj);
            }
            System.out.println(resultArr.toString(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

