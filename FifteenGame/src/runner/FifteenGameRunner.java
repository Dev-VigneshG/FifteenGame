/*
 * TITLE:FIFTEEN PUZZLE
 * AUTHOR:VIGNESH G
 * DESCRIPTION:
 *  The main objective of this game is to rearrange the shuffled cells into the correct order.
 *
 * PACKAGES:
 * 1)game   -contains game glasses
 * 2)runner -used to run the Game
 * 
 * CLASSES:
 * 1)FifteenPuzzle(game)       -represents the game
 * 2)Square(game)              -represent the each cell in the board
 * 3)FifteenGameRunner(runner) -This Class runs the game 
 * 
 * TOOL:
 * 1)Java SE 21
 * 2)Eclipse IDE
 */
package runner;
import java.util.Scanner;
import game.FifteenPuzzle;
public class FifteenGameRunner {
	public static void main(String[] args)
	{
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("********************Welcome to 15 Puzzle Game!!!***********");
			System.out.println("Enter Size of The Puzzle: (Give One Value ex:5):");
			//getting no of row and columns.board must be square. So only one value needed
			int noOfRowsColumns=scanner.nextInt();
			//Initialize the game
			FifteenPuzzle fifteenPuzzle=new FifteenPuzzle(noOfRowsColumns);
			//creating the board
			fifteenPuzzle.createBoard();
			//Shuffling the board
			fifteenPuzzle.shuffleBoard();
			//start the game
			fifteenPuzzle.play();
		}
	}
}
