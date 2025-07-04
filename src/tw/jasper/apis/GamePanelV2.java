package tw.jasper.apis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanelV2 extends JPanel {
	private BufferedImage ballImg;
	private Timer timer;
	private int viewW, viewH;
	private int ballW, ballH;
	private LinkedList<BallTask> balls;
	private int fps = 60;
	
	
	public GamePanelV2() {
		setBackground(Color.PINK);
		
		balls = new LinkedList<>();
		
		try {
			ballImg = ImageIO.read(new File("dir3/ball.png"));
			ballW = ballImg.getWidth();
			ballH = ballImg.getHeight();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		timer = new Timer();
		timer.schedule(new refreshView(), 0, 16);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				BallTask ball =  new BallTask(e.getX() - (int)(ballW/2.0), e.getY() - (int)(ballH/2));
				balls.add(ball);
				timer.schedule(ball, 1*500, 1000/fps);
			}
		});
	}
	
	private class BallTask extends TimerTask {
		private int ballX, ballY;
		private int dx, dy;
		
		public BallTask(int ballX, int ballY) {
			this.ballX = ballX;
			this.ballY = ballY;
			dx = (int)(Math.random()*17 - 8);
			dy = (int)(Math.random()*17 - 8);
		}
		
		
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
		}
	}
	
	public class refreshView extends TimerTask {
		
		@Override
		public void run() {
			repaint();
			
		}
	}
	
	
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		viewW = getWidth();
		viewH = getHeight();
		
		for (BallTask ball : balls) {
			g.drawImage(ballImg, ball.ballX, ball.ballY, null);			
		}
	}
	
}
