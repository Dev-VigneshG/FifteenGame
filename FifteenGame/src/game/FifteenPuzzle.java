package game;
import java.util.Random;
import java.util.Scanner;
public class FifteenPuzzle {
	private int noOfRowsColumns;
	private Square[][] board;
	private int steps=0;
	private boolean isWin=false;
	private int posEmptyRow;
	private int posEmptyCol;
	private Scanner scanner;
	public  FifteenPuzzle(int noOfRowsColumns)
	{
		this.noOfRowsColumns=noOfRowsColumns;
		board=new Square[noOfRowsColumns][noOfRowsColumns];
		scanner=new Scanner(System.in);
	}
	public void createBoard() {
		for(int i=0;i<noOfRowsColumns;i++)
		{
			for(int j=0;j<noOfRowsColumns;j++)
			{
				board[i][j]=new Square((i*noOfRowsColumns)+(j+1));

			}
		}
		board[noOfRowsColumns-1][noOfRowsColumns-1]=new Square(0);
		posEmptyRow=posEmptyCol=noOfRowsColumns-1;

	}
	public void shuffleBoard()
	{
		Random random=new Random();
		int noOfShuffle=random.nextInt(300)+200;
		int shuffle=0;
		while(shuffle<noOfShuffle)
		{
			int direction=random.nextInt(4);
			int tempRow=posEmptyRow;
			int tempCol=posEmptyCol;
			if(direction==0)
			{
				tempCol--;
			}
			else if(direction==1)
			{
				tempCol++;
			}
			else if(direction==2)
			{
				tempRow--;
			}
			else if(direction==3)
			{
				tempRow++;
			}
			if(isValid(tempRow,tempCol)&&isValidMove(tempRow,tempCol)) {
				move(tempRow,tempCol);
				shuffle++;
			}
		}
		steps=0;
	}
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
	public boolean isValid(int row,int column) 
	{
		if(row>=0&&column>=0&&row<noOfRowsColumns&&column<noOfRowsColumns)
			return true;
		return false;
	}
	public boolean isValidMove(int row,int column)
	{
		return(row==posEmptyRow&&Math.abs(column-posEmptyCol)==1)||(column==posEmptyCol&&Math.abs(row-posEmptyRow)==1);
	}
	public boolean isWin() {
		int startValue=1;
		for(int i=0;i<noOfRowsColumns;i++)
		{
			for(int j=0;j<noOfRowsColumns;j++)
			{
				if(i==noOfRowsColumns-1&&j==noOfRowsColumns-1)
				{
					if(board[i][j].getValue()!=0)
					{
						return false;
					}
				}
				else if(startValue!=board[i][j].getValue())
				{
                 return false; 
				}
				startValue++;
			}
		}
		return true;
	}
	public void play() {
		while(!isWin())
		{
			display();
			System.out.println("Enter Row&Column: ");
			int row=scanner.nextInt();
			int col=scanner.nextInt();
			if(isValid(row,col)&&isValidMove(row,col))
			{
				move(row,col);
			}
			else
			{
				System.out.println("Invalid Move!!!");
			}
		}
		if(isWin())
		{
			System.out.println("You Are Win!!!");
			System.out.println("You Take "+getSteps()+" steps!");
		}
	}
	public int getSteps() {
		
		return this.steps;
	}
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