package tw.jasper.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tw.jasper.apis.MyClock;
import tw.jasper.apis.MyDrawer2;

public class MySign3 extends JFrame {
	private MyDrawer2 MyDrawer;
	private JButton clear, undo, redo, color, saveJpg, saveObject, loadObject;
	
	public MySign3() {
		super("Sign App");
		
		MyDrawer = new MyDrawer2();
		setLayout(new BorderLayout());
		add(MyDrawer);
		
		JPanel top = new JPanel(new FlowLayout());
		clear = new JButton("Clear");
		undo = new JButton("Undo");
		redo = new JButton("Redo");
		color = new JButton("Color");
		saveJpg = new JButton("saveJpg");
		saveObject = new JButton("saveObject");
		loadObject = new JButton("loadObject");
		
		
		top.add(clear);
		top.add(undo);
		top.add(redo);
		top.add(color);
		top.add(saveJpg);
		top.add(saveObject);
		top.add(loadObject);
		
		MyClock myClock = new MyClock();
		top.add(myClock);
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
		
		saveJpg.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				saveJpeg();
			}
		});
		
		saveObject.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				saveObj();
			}
		});
		
		loadObject.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loadObj();
			}
		});
	}
	
	private void changeColor() {
		Color newcolor = JColorChooser.showDialog(this, "Change Colot",MyDrawer.getColor());
		if (newcolor != null) {
			MyDrawer.changeColor(newcolor);
		}
	}
	
	private void saveJpeg() {
		JFileChooser jfc = new JFileChooser();
		if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			File saveFile = jfc.getSelectedFile();
			try {
				if (MyDrawer.saveJPEG(saveFile)) {
					JOptionPane.showMessageDialog(this, "Save success");
				}
				else {
					JOptionPane.showMessageDialog(this, "Save fail");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Save fail");
			}
			
		}
	}
	
	private void saveObj() {
		JFileChooser jfc = new JFileChooser();
		if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			File saveFile = jfc.getSelectedFile();
			try {
				MyDrawer.saveLines(saveFile);
				JOptionPane.showMessageDialog(this, "Save success");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Save fail");
			}
			
		}
	}
	
	private void loadObj() {
		JFileChooser jfc = new JFileChooser();
		if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			File loadFile = jfc.getSelectedFile();
			try {
				MyDrawer.loadLines(loadFile);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Load fail");
			}
			
		}
	}
	
	

	public static void main(String[] args) {
		new MySign3();
	}

}
