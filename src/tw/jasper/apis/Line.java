package tw.jasper.apis;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;

public class Line implements Serializable {
	private ArrayList<Point> points;
	private Color color;
	
	public Line(Color color) {
		points = new ArrayList<Point>();
		this.color = color;
	}
	
	public void addPoint(Point p) {
		points.add(p);
	}
	
	public Point getPoint(int idx) {
		return points.get(idx);
	}
	public int numOfPoint() {
		return points.size();
	}

	public Color getColor() {
		return color;
	}
	
}
