package IO;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import Inrastructure.Main;
import libary_version_2.Button;

public class MouseHandler implements MouseListener{
	private HashMap<String, Button> buttons = Main.window.buttons;
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		for (String key : buttons.keySet()) {
			if (buttons.get(key).contains(e.getX(), e.getY())) {
				switch (key) {
				case "play": {
					Main.window.createGameField();
					Main.window.createBrain();
					break;
				}
				
				case "quit": {
					Main.gui.jf.dispose();
					break;
				}
				case "brains1": {
					Main.window.setSelectedAlgorythm(1);
					break;
				}
				
				case "brains2": {
					Main.window.setSelectedAlgorythm(2);
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + key);
				}
			}
			
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
