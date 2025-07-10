package tw.jasper.apis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class GiftDB {
	private static final String URL = "jdbc:mysql://localhost/test";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String QuerySQL = 
			"""
			SELECT id '編號', name '名稱', feature '特色', tel '電話', city '城市' FROM gift
			""";
	
	private Connection conn;
	private ResultSet rs;
	private String[] fieldNames;
	
	public GiftDB() throws Exception {
		Properties prop = new Properties();
		prop.setProperty("user", USER);
		prop.setProperty("password", PASSWORD);
		conn = DriverManager.getConnection(URL, prop);
		
		queryDB();
	}
	
	public void queryDB() throws Exception { queryDB(QuerySQL);}
	
	public void queryDB(String sql) throws Exception {
		Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rs = stmt.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		fieldNames = new String[rsmd.getColumnCount()];
		for (int i=0; i<fieldNames.length; i++) {
			fieldNames[i] = rsmd.getColumnLabel(i+1);
		}
	}
	
	public int getRows() {
		try {
			rs.last();
			return rs.getRow();
		} catch (SQLException e) {
			return 0;
		}
	}
	
	
	public int getCols() {
		return fieldNames.length;
	}
	
	// row, col => 0-base
	public Object getValueAt(int row, int column) {
		try {
			rs.absolute(row+1);
			return rs.getString(column+1);
		} catch (SQLException e) {
			return "#ERROR";
		}
		
	}
	
	public String getColName(int col) {
		return fieldNames[col];
	}
	
	public void updateData(int row, int col, String newData) {
		if (col != 0) {
			try {
				rs.absolute(row+1);
				rs.updateString(col+1, newData);
				rs.updateRow();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void deleteData(int row) {
		try {
			rs.absolute(row+1);
			rs.deleteRow();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
