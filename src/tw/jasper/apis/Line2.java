package tw.jasper.apis;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Line2 implements Serializable {
	private ArrayList<HashMap<String, Integer>> points;
	private Color color;
	
	public Line2(Color color) {
		points = new ArrayList<HashMap<String, Integer>>();
		this.color = color;
	}
	
	public void addPoint(HashMap<String, Integer> p) {
		points.add(p);
	}
	
	public HashMap<String, Integer> getPoint(int idx) {
		return points.get(idx);
	}
	public int numOfPoint() {
		return points.size();
	}

	public Color getColor() {
		return color;
	}
}
