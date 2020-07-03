package Inrastructure;

import Draw.GUI;
import libary_version_2.MusicPlayer;

public class Main {
	public static GUI gui;
	public static MyWindow window;
	
	public static void main(String[] args) {
		MusicPlayer mp = new MusicPlayer("drawings/gmbs.wav");
		window = new MyWindow();
		gui = new GUI();
		
		
	}
	
}
