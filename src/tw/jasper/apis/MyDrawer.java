package tw.jasper.apis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

public class MyDrawer extends JPanel {
//	private ArrayList<Point> line;
//	private ArrayList<ArrayList<Point>> lines;
	private ArrayList<Line> lines, redoList;
	private Color defaultColor;
	
	
	public MyDrawer() {
		lines = new ArrayList<>();
		redoList = new ArrayList<>();
		defaultColor = Color.BLACK;
		
		
		setBackground(Color.YELLOW);
		MyMouseAdapter adapter = new MyMouseAdapter();
		addMouseListener(adapter);
		addMouseMotionListener(adapter);
		
	
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(4));
		
		
		
		for (Line line : lines) {
			g2d.setColor(line.getColor());
			for (int i=1; i<line.numOfPoint(); i++) {
				Point p1 = line.getPoint(i-1);
				Point p2 = line.getPoint(i);
				g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
			}			
		}
		
		
	}
	
	private class MyMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			Line line = new Line(defaultColor);
			Point p = new Point(e.getX(), e.getY());
			line.addPoint(p);
			lines.add(line);
			redoList.clear();
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			Point p = new Point(e.getX(), e.getY());
			lines.getLast().addPoint(p);;
			repaint();
		}
	}
	
	public void clear() {
		lines.clear();
		repaint();
	}
	public void undo() {
		if (lines.size() > 0) {
			redoList.add(lines.removeLast());			
			repaint();
		}
	}
	public void redo() {
		if (redoList.size() > 0) {
			lines.add(redoList.removeLast());
			repaint();
		}
	}
	public Color getColor() {
		return defaultColor;
	}
	
	public void changeColor(Color newColor) {
		defaultColor = newColor;
	}
	
}

// 外部類別 參數難用
//class MyMouseAdapter2 extends MouseAdapter {
//	private ArrayList<Line> lines, redoList;
//	private MyDrawer myDrawer;
//	
//	public MyMouseAdapter2(ArrayList<Line> lines, ArrayList<Line> redoList, MyDrawer myDrawer) {
//		this.lines = lines;
//		this.redoList = redoList;
//		this.myDrawer = myDrawer;
//	}
//	
//	@Override
//	public void mousePressed(MouseEvent e) {
//		Line line = new Line(Color.BLACK);
//		Point p = new Point(e.getX(), e.getY());
//		line.addPoint(p);
//		lines.add(line);
//		redoList.clear();
//	}
//	
//	@Override
//	public void mouseDragged(MouseEvent e) {
//		Point p = new Point(e.getX(), e.getY());
//		lines.getLast().addPoint(p);;
//		myDrawer.repaint();
//	}
//}

