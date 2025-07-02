package tw.jasper.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tw.jasper.apis.MyDrawer;

public class MySign extends JFrame {
	private MyDrawer MyDrawer;
	private JButton clear, undo, redo, color;
	
	public MySign() {
		super("Sign App");
		
		MyDrawer = new MyDrawer();
		setLayout(new BorderLayout());
		add(MyDrawer);
		
		JPanel top = new JPanel(new FlowLayout());
		clear = new JButton("Clear");
		undo = new JButton("Undo");
		redo = new JButton("Redo");
		color = new JButton("Color");
		top.add(clear);
		top.add(undo);
		top.add(redo);
		top.add(color);
		
		add(top, BorderLayout.NORTH);
		
		
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initEvent();
	}
	
	
	private void initEvent() {
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MyDrawer.clear();
			}
		});
		
		undo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MyDrawer.undo();
			}
		});
		
		redo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MyDrawer.redo();
			}
		});
		
		color.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				changeColor();
			}
		});
	}
	
	private void changeColor() {
		Color newcolor = JColorChooser.showDialog(this, "Change Colot",MyDrawer.getColor());
		if (newcolor != null) {
			MyDrawer.changeColor(newcolor);
		}
	}

	public static void main(String[] args) {
		new MySign();
	}

}
