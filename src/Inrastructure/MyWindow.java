package Inrastructure;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.HashMap;

import Objects.GameField;
import brains.Algorythmus2;
import brains.Brain;
import brains.FastestWay;
import libary_version_2.Button;
import ui.InformationPanel;

public class MyWindow {
	private int selectedAlgorythm = 0;
	public static GameField gf;
	public static InformationPanel infPanel;
	public static Brain brain;
	public HashMap<String, Button> buttons = new HashMap<String, Button>();
	
	public MyWindow() {
		buttons.put("play", new Button(1030, 685, 120, 50, Color.BLACK, Color.RED));
		buttons.put("quit", new Button(860, 685, 120, 50, Color.BLACK, Color.RED));
		buttons.put("brains1", new Button(1030, 400, 150, 60, Color.BLACK, Color.RED));
		buttons.put("brains2", new Button(860, 400, 150, 60, Color.BLACK, Color.RED));
		buttonSetup();
		infPanel = new InformationPanel();
	}
	
	private void buttonSetup() {
		buttons.get("play").setText("PLAY");
		buttons.get("quit").setText("QUIT");
		buttons.get("brains1").setText("Brains1");
		buttons.get("brains2").setText("Brains2");
		
		for (String key : buttons.keySet()) {
			buttons.get(key).setTextColor(Settings.ButtonTextColor);
			buttons.get(key).setColor(Settings.ButtonBackgroundColor);
			buttons.get(key).setFramingColor(Settings.ButtonBorderColor);
		}
	}
	
	public void createGameField() {
		if (gf != null) {
			gf.stopGameField();
		}
		gf = null;
		gf = new GameField();
	}
	
	public void createBrain() {
		switch (selectedAlgorythm) {
		case 0: {break;}
		case 1: {
			this.brain = new FastestWay();
			System.out.println("1");
			break;
		}
		case 2: {
			this.brain = new Algorythmus2();
			System.out.println("2");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + brain);
		}
	} 
	
	//getter und setter
	public void setSelectedAlgorythm(int index) {
		this.selectedAlgorythm = index;
	}
	
	
	
	
	
	
	//draw
	public void draw(Graphics2D g) {
		g.setColor(Settings.windowBackgroundColor);
		g.fillRect(0, 0, 1200, 800);
		
		try {
			gf.setupDraw(g);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		infPanel.draw(g);
		
		for (String key : buttons.keySet()) {
			buttons.get(key).paint(g);
		}
		
	}
}
