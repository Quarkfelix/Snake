package Draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import IO.MouseHandler;
import Inrastructure.Main;

public class Draw extends JPanel{
	
	public Draw() {
		this.addMouseListener(new MouseHandler());
	}
	
	public void paint(Graphics graphics) {
		Graphics2D g = (Graphics2D) graphics;
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1200, 800);
		
		Main.window.draw(g);
	}
}




class DrawThread extends Thread {
	public Draw draw;
	
	public DrawThread() {
		draw = new Draw();
		super.start();
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			draw.repaint();
		}
	}
}
