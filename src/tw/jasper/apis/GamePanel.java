package tw.jasper.apis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	private BufferedImage ballImg;
	private int ballX, ballY;
	private int viewW, viewH, ballW, ballH;
	private Timer timer;
	private int dx, dy;
	
	
	public GamePanel() {
		setBackground(Color.PINK);
		
		dx = dy = 10;
		ballX = ballY = 50;
		try {
			ballImg = ImageIO.read(new File("dir3/ball.png"));
			ballW = ballImg.getWidth();
			ballH = ballImg.getHeight();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		timer = new Timer();
		timer.schedule(new BallTask(), 1*500, 30);
		
		
	}
	
	private class BallTask extends TimerTask {
		@Override
		public void run() {
			if (ballX <= 0) {
				dx = Math.abs(dx);
			}
			else if ((ballX + ballW) >= viewW) {
				dx = -Math.abs(dx);
			}
			if (ballY <= 0) {
				dy = Math.abs(dy);
			}
			else if ((ballY + ballH) >= viewH) {
				dy = -Math.abs(dy);
			}
			
			
			
			ballX += dx;
			ballY += dy;
			repaint();
		}
	}
	
	
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		viewW = getWidth();
		viewH = getHeight();
		
		g.drawImage(ballImg, ballX, ballY, null);
	}
	
}
