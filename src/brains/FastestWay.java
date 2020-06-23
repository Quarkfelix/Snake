package brains;

import Inrastructure.Settings;
import Objects.Bodypart;
import Objects.GameField;

public class FastestWay extends Brain{
	private int xFood, yFood, xSnake, ySnake;
	
	public void setMovement() {
		setVariables();
		if (xSnake != xFood) {
			moveX();
		} else {
			moveY();
		}
	}
	
	private boolean nextTileisFree(String movementdirection) {
		switch (movementdirection) {
		case "Right": {
			for (Bodypart bodypart : GameField.snake.body) {
				if(GameField.snake.head.getX() + 1 == bodypart.getX()) {
					if (GameField.snake.head.getY() == bodypart.getY()) {
						return false;
					} else {
						return true;
					}
				} else {
					return true;
				}
			}
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + movementdirection);
		}
	}
	
	private void moveX() {
		if (xSnake < xFood) {
			if (nextTileisFree("Right")) {
				GameField.snake.setMovementDirection("RIGHT");
			}
		}
		if (xSnake > xFood) {
			GameField.snake.setMovementDirection("LEFT");
		}
	}
	
	private void moveY() {
		if (ySnake < yFood) {
			GameField.snake.setMovementDirection("DOWN");
		}
		if (ySnake > yFood) {
			GameField.snake.setMovementDirection("UP");
		}
	}
	
	private void setVariables() {
		xFood = GameField.food.getX();
		yFood = GameField.food.getY();
		xSnake = GameField.snake.head.getX();
		ySnake = GameField.snake.head.getY();
	}
}
