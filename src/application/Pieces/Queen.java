package application.Pieces;

import application.Game.Board;
import application.Game.Piece;
import application.Game.Player;

public class Queen extends Piece {
private Type type;
ColorP color;



	public Queen(ColorP color) {
		super(color);
		//this.value = value ;
		this.color = color;
		
		type = Type.QUEEN;
		
	}

	
	public  boolean validMove(int curRow, int curCol, int destRow, int destCol) {
	
		
		if( (validPath(curRow, curCol, destRow, destCol) == true) && !sameColor )
		{
		 return true;
		}
		
		sameColor = false;
		return false;
	}



	  boolean sameColor = false;
	
@Override
 public Boolean validPath(int curRow, int curCol, int destRow, int destCol) {
	Piece currP = Board.pieces[Board.getBoardValue(curCol, curRow)];
	
	System.out.println( "current Piece:  " +currP);

		int rowDiff = Math.abs(destRow - curRow);
		int colDiff = Math.abs(destCol - curCol);

    
	if((rowDiff != colDiff) && (rowDiff!= 0) && (colDiff != 0))
	{ 
		System.out.print("queen cant move that way");
		return false;
		
	} 
		
	if(Board.getBoardValue(destCol, destRow) >= 0)
	{
	    if(  ((Board.pieces[Board.getBoardValue(destCol, destRow)]).getColor()).equals( currP.getColor())    )
	    {
	    System.out.print("cant take piece that is same color");
	    	sameColor = true;
	    	System.out.print(Board.pieces[Board.getBoardValue(destCol, destRow)]);
	    	
	    }
	}

		
	int colDir  = 1;
	int rowDir = 1;
	
	
		if ((curCol-destCol) > 0)
		{
			colDir = -1;
		}
	


		if ((destRow-curRow) > 0)
		{
			rowDir = -1; 
		}

//moving side to side 
if(rowDiff == 0 && colDiff >0)
{   
	//moving right
	if(colDir > 0)
	{//System.out.print("moving right");
		int nextCol = curCol+1;
	    int  nextRow = curRow;
	    int count = 0;
		for(int i = 0; i < colDiff-1; i++)
		{
			if(Board.getBoardValue(nextCol, nextRow) != -1 && colDiff!=1)
			{	System.out.println("Piece Blocking : " +Board.getBoardValue(nextCol, nextRow));
				return false;
			}
			count++;
			nextCol++;
		
		}
	}
		
	
	//moving left
		else if(colDir < 0)
	{
		int nextCol = curCol-1;
	    int  nextRow = curRow;
	    int count = 0;
	    for(int i = 0; i < colDiff-1; i++)
		{
			if(Board.getBoardValue(nextCol, nextRow) != -1  )
			{	System.out.println("Piece Blocking : " +Board.getBoardValue(nextCol, nextRow));
				return false;
			}
			count++;
			nextCol--;
	}
    }
	}

//Moving up and Down 
if(colDiff == 0 && rowDiff >0)
{
	//Moving up
	if(rowDir > 0 )
	{
		
		int nextRow = curRow-1;
		int nextCol = curCol;
		int count = 0;
		for(int i = 0; i < rowDiff -1 ; i++)
		{
			if(Board.getBoardValue(nextCol, nextRow) != -1  )
			{
			System.out.println("Piece Blocking : " +Board.getBoardValue(nextCol, nextRow));
			
			return false;
			} 
		
		count++;
		nextRow--;
		}
		
	}
	
	//moving Down
	else if(rowDir < 0 )
	{
		System.out.println("moving down ");
		int nextRow = curRow+1;
		int nextCol = curCol;
		int count = 0;
		for(int i = 0; i < rowDiff -1 ; i++)
		{
			if(Board.getBoardValue(nextCol, nextRow) != -1  )
			{
			System.out.println("Piece Blocking : " +Board.getBoardValue(nextCol, nextRow));
			
			return false;
			}
		
		count++;
		nextRow++;
		}
	}
}
	
//Moving Diagnol 
if (rowDiff == colDiff)
{
	//moving down right 
	if(rowDir < 0 && colDir > 0)
	{
	System.out.println("moving down right ");
	int nextRow = curRow+1;
	int nextCol = curCol+1;
	int count = 0;
	for(int i = 0; i < rowDiff -1; i ++)
	{
		if(Board.getBoardValue(nextCol, nextRow) != -1  )
		{
		System.out.println("Piece Blocking : " +Board.getBoardValue(nextCol, nextRow));
	
		return false;
		}
		count++;
		nextRow++;
		nextCol++;
		
	}
	}
	
	//Moving up right 
	else if (rowDir > 0 && colDir >0 ) 
	{
		System.out.println("moving up right ");
		int nextRow = curRow-1;
		int nextCol = curCol+1;
		int count = 0;
		for(int i = 0; i < rowDiff -1; i ++)
		{
			if(Board.getBoardValue(nextCol, nextRow) != -1  )
			{
			System.out.println("Piece Blocking : "+Board.getBoardValue(nextCol, nextRow));
			
			return false;
			}
			count++;
			nextRow--;
			nextCol++;
			
		}
	}
	//Moving down left
	else if(rowDir < 0 && colDir < 0  )
	{
		System.out.println("moving down left");
		int nextRow = curRow+1;
		int nextCol = curCol-1;
		int count = 0;
		for(int i = 0; i < rowDiff -1; i ++)
		{
			if(Board.getBoardValue(nextCol, nextRow) != -1  )
			{
			System.out.println("Piece Blocking : " +Board.getBoardValue(nextCol, nextRow));
		
			return false;
			}
			count++;
			nextRow++;
			nextCol--;
			
		}
	} 
	
	//moving up left
	else if (rowDir > 0 && colDir < 0)
	{
		System.out.println("moving up left");
		int nextRow = curRow-1;
		int nextCol = curCol-1;
		int count = 0; 
		for(int i = 0; i < rowDiff -1; i ++)
		{
			if(Board.getBoardValue(nextCol, nextRow) != -1  )
			{
			System.out.println("Piece Blocking : " +Board.getBoardValue(nextCol, nextRow));
			
			return false;
			}
			count++;
			nextRow--;
			nextCol--;
			
		}
	}
	
	
}
	



		
	return true;
	
	
	}

	


	@Override
	public Type getType() {
		
		return type.QUEEN;
	}




	@Override
	public ColorP getColor() {
		// TODO Auto-generated method stub
		return color;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "  Q ";
	}




}
