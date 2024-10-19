package game;
import java.util.Random;
import java.util.Scanner;
public class FifteenPuzzle {
	private int noOfRowsColumns;
	private Square[][] board;
	private int steps=0;      
	private boolean isWin=false;
	private int posEmptyRow;// position of Empty Square row
	private int posEmptyCol;// position of Empty Square column
	private Scanner scanner;
	public  FifteenPuzzle(int noOfRowsColumns)
	{
		//set number of rows and columns
		this.noOfRowsColumns=noOfRowsColumns;
		//create empty board with given dimension
		board=new Square[noOfRowsColumns][noOfRowsColumns];
		scanner=new Scanner(System.in);
	}
	//This method used to create board
	public void createBoard() {
		//create board with correct order
		for(int i=0;i<noOfRowsColumns;i++)
		{
			for(int j=0;j<noOfRowsColumns;j++)
			{
				board[i][j]=new Square((i*noOfRowsColumns)+(j+1));

			}
		}
		//Empty Square placed in last row and last column
		board[noOfRowsColumns-1][noOfRowsColumns-1]=new Square(0);
		//Setting Position of Empty Square
		posEmptyRow=posEmptyCol=noOfRowsColumns-1;

	}
	//this method used to shuffle the board
	public void shuffleBoard()
	{
		Random random=new Random();
		//shuffle the board random value between 200 to 500 times
		int noOfShuffle=random.nextInt(300)+200;
		int shuffle=0;
		while(shuffle<noOfShuffle)
		{
			int direction=random.nextInt(4);
			int tempRow=posEmptyRow;
			int tempCol=posEmptyCol;
			//Left Move
			if(direction==0)
			{
				tempCol--;
			}
			//Right Move
			else if(direction==1)
			{
				tempCol++;
			}
			//Top Move
			else if(direction==2)
			{
				tempRow--;
			}
			//Bottom Move
			else if(direction==3)
			{
				tempRow++;
			}
			if(isValid(tempRow,tempCol)&&isValidMove(tempRow,tempCol)) {
				move(tempRow,tempCol);
				shuffle++;
			}
		}
		//not consider steps for shuffling the board
		steps=0;
	}
	//this method used to display the board into console
	public void display()
	{
		System.out.println("Steps: "+getSteps());
		for(int i=0;i<noOfRowsColumns;i++)
		{
			for(int j=0;j<noOfRowsColumns;j++)
			{
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	//this method used to whether given row and column in between the boundary of the board or not
	public boolean isValid(int row,int column) 
	{
		if(row>=0&&column>=0&&row<noOfRowsColumns&&column<noOfRowsColumns)
			return true;
		return false;
	}
	//this method used to Check Move is possible or not.
	//row and column denote which element move to empty square
	public boolean isValidMove(int row,int column)
	{
		return(row==posEmptyRow&&Math.abs(column-posEmptyCol)==1)||(column==posEmptyCol&&Math.abs(row-posEmptyRow)==1);
	}
	//this method used to check win or not
	public boolean isWin() {
		//1st value of board is 1 (in correct Order)
		int startValue=1;
		for(int i=0;i<noOfRowsColumns;i++)
		{
			for(int j=0;j<noOfRowsColumns;j++)
			{
				if(i==noOfRowsColumns-1&&j==noOfRowsColumns-1)
				{
					//If last Square value must be 0(empty) if not return false
					if(board[i][j].getValue()!=0)
					{
						return false;
					}
				}
				//if not correct value return false
				else if(startValue!=board[i][j].getValue())
				{
                 return false; 
				}
				//increment the startValue to check next other element
				startValue++;
			}
		}
		return true;
	}
	//this method used to play the game
	public void play() {
		while(!isWin())
		{
			display();
			System.out.println("Enter Row&Column: ");
			int row=scanner.nextInt();
			int col=scanner.nextInt();
			//if valid move move row&col to position of empty cell
			
			if(isValid(row,col)&&isValidMove(row,col))
			{
				move(row,col);
			}
			//else print invalid move
			else
			{
				System.out.println("Invalid Move!!!");
			}
		}
		//if user arrange in correct order 
		if(isWin())
		{
			System.out.println("You Are Win!!!");
			System.out.println("You Take "+getSteps()+" steps!");
		}
	}
	public int getSteps() {
		
		return this.steps;
	}
	//this method used to move the particular cell into empty cell(swapping)
	public void move(int row,int column) {
		if(isValid(row,column)&&isValidMove(row,column))
		{
			int temp=board[row][column].getValue();
			board[row][column].setValue(board[posEmptyRow][posEmptyCol].getValue());
			board[posEmptyRow][posEmptyCol].setValue(temp);
			this.posEmptyRow=row;
			this.posEmptyCol=column;
			steps++;
		}
		else
		{
			System.out.println("Invalid Move");
		}
	}
}
