package Objects;

import java.awt.Color;
import java.awt.Graphics2D;

import Inrastructure.Main;
import Inrastructure.MyWindow;
import Inrastructure.Settings;

public class Head {
	private int x,y;
	
	public Head() {
		x = 1;
		y = 1;
	}

	
	//schlange wird �ber dec und inc gesteuert
	public void incX() {
		x += 1;
	}
	
	public void decX() {
		x -= 1;
	}
	
	public void incY() {
		y += 1;
	}
	
	public void decY() {
		y -= 1;
	}
	
	//getter und setter
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	
	
	
	
	
	
	public void draw(Graphics2D g) {
		GameField gf = MyWindow.gf;
		
		g.setColor(Settings.headColor);
		g.fillRect((x-1)*40 + gf.x, (y-1)*40 + gf.y, 40, 40);
	
	}
}
