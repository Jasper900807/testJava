package tw.jasper.test;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tw.jasper.apis.GamePanel;
import tw.jasper.apis.GamePanelV2;

public class BallGame extends JFrame {
	private GamePanelV2 panel;
	
	public BallGame() {
		setLayout(new BorderLayout());
		
		panel = new GamePanelV2();
		add(panel);
		
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		
	}
	
	
	

	public static void main(String[] args) {
		new BallGame();

	}

}
