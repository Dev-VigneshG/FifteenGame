package runner;
import java.util.Scanner;
import game.FifteenPuzzle;
public class FifteenGameRunner {
      public static void main(String[] args)
      {
    	  Scanner scanner=new Scanner(System.in);
    	  System.out.println("********************Welcome to 15 Puzzle Game!!!***********");
    	  System.out.println("Enter Size of The Puzzle: (Give One Value ex:5):");
    	  int noOfRowsColumns=scanner.nextInt();
    	  FifteenPuzzle fifteenPuzzle=new FifteenPuzzle(noOfRowsColumns);
    	  fifteenPuzzle.createBoard();
          fifteenPuzzle.shuffleBoard();
    	  fifteenPuzzle.play();
      }
}
