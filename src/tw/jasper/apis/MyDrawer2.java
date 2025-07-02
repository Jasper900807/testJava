package tw.jasper.apis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyDrawer2 extends JPanel {

	private ArrayList<Line2> lines, redoList;
	private Color defaultColor;
	
	
	public MyDrawer2() {
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
		
		
		
		for (Line2 line : lines) {
			g2d.setColor(line.getColor());
			for (int i=1; i<line.numOfPoint(); i++) {
				HashMap<String, Integer> p1 = line.getPoint(i-1);
				HashMap<String, Integer> p2 = line.getPoint(i);
				g2d.drawLine(p1.get("x"), p1.get("y"), p2.get("x"), p2.get("y"));
			}			
		}
		
		
		
	}
	
	private class MyMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			Line2 line = new Line2(defaultColor);
			HashMap<String, Integer> point = new HashMap<>();
			point.put("x", e.getX());
			point.put("y", e.getY());
			line.addPoint(point);
			lines.add(line);
			redoList.clear();
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			HashMap<String, Integer> p = new HashMap<>();
			p.put("x", e.getX());
			p.put("y", e.getY());
			lines.getLast().addPoint(p);
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
	
	public boolean saveJPEG(File saveFile) throws Exception {
		BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_BGR);
		
		Graphics2D g2d = img.createGraphics();
		paint(g2d);
		
		return ImageIO.write(img, "jpg", saveFile);
	}
	
	public void saveLines(File saveFile) throws Exception {
		ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(saveFile));
		oout.writeObject(lines);
		oout.flush();
		oout.close();
	}
	
	public void loadLines(File loadFile) {
		try (ObjectInputStream oin =  new ObjectInputStream(new FileInputStream(loadFile));) {
			Object obj = oin.readObject();
			if (obj instanceof ArrayList) {
				lines = (ArrayList<Line2>)obj;
				redoList.clear();
				repaint();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}



