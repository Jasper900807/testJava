package tw.jasper.apis;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class GiftTable extends JTable {
	private GiftDB db;
	
	public GiftTable() {
		try {
			db = new GiftDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setModel(new GiftModel());
	}
	
	public void delRow() {
//		System.out.println(getSelectedRow());
		int delRow = getSelectedRow();
		if (delRow != -1) {
			db.deleteData(delRow);
			repaint();
		}
	}
	
	private class GiftModel extends DefaultTableModel {

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return db.getRows();
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return db.getCols();
		}

		@Override
		public String getColumnName(int column) {
			return db.getColName(column);
		}

		@Override
		public Object getValueAt(int row, int column) {
			// TODO Auto-generated method stub
			return db.getValueAt(row, column);
		}

		@Override
		public void setValueAt(Object aValue, int row, int column) {
			db.updateData(row, column, (String)aValue);
		}
		
		
		
	}
}
