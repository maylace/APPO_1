package application;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Constants
		final int screenWidth = 20; // Columns
		final int screenHeight = 10; // Rows
		final int snakePositionX = screenWidth / 2;
		final int snakePositionY = screenHeight / 2;

		// Init screen
		GameScreen screen = new GameScreen(screenWidth, screenHeight);
		screen.InitScreen();

		// Init walls
		Wall wall = new Wall('#');
		wall.addWallsRow(screen, wall, 0); // First row
		wall.addWallsRow(screen, wall, screen.getScreenHeight() - 1); // Last
																		// row
		wall.addWallsColumn(screen, wall, 0); // First column
		wall.addWallsColumn(screen, wall, screen.getScreenWidth() - 1); // Last
																		// column

		// Init player
		Snake snake = new Snake('@', snakePositionX, snakePositionY);
		screen.setObjectOnLocation(snake, snake.getX(), snake.getY());

		// Init foodG
		Food food = new Food('*');
		food.addRandomFood(screen, food);
		
		// Input from player
		Scanner scanner = new Scanner(System.in);
		char input;

		// The game logic starts here
		boolean isRunning = true;

		while (isRunning) {
			screen.PrintScreen();
			// Get input from player and do something
			switch (input = scanner.nextLine().charAt(0)) {
			case 'a':
				snake.moveLeft(screen, snake);
				food.addRandomFood(screen, food);
				break;
			case 'd':
				snake.moveRight(screen, snake);
				food.addRandomFood(screen, food);
				break;
			case 'w':
				snake.moveUp(screen, snake);
				food.addRandomFood(screen, food);
				break;
			case 's':
				snake.moveDown(screen, snake);
				food.addRandomFood(screen, food);
				break;

			}
		}
	}

}
