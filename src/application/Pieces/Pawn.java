package application.Pieces;

import application.Game.Board;
import application.Game.Piece;
import application.Game.Player;

public class Pawn extends Piece{

	ColorP color;
	Type type;

	
	public Pawn(ColorP color) {
		super(color);
		this.color = color;
		
	
	}
public  boolean validMove(int curRow, int curCol, int destRow, int destCol) {
	
		
		if( (validPath(curRow, curCol, destRow, destCol) == true) && !sameColor )
		{
		firstMove = false;
		 return true;
		}
		
		sameColor = false;
		return false;
	}



	  boolean sameColor = false;
	 boolean firstMove = true;
	
	@Override
	public Boolean validPath(int curRow, int curCol, int destRow, int destCol) {
		Piece currP = Board.pieces[Board.getBoardValue(curCol, curRow)];
		
		System.out.println( "currP" +currP);

			int rowDiff = Math.abs(destRow - curRow);
			int colDiff = Math.abs(destCol - curCol);
		
	     
		if((rowDiff > 2) && (colDiff >1) && colDiff == rowDiff )
		{ 
			System.out.print("doesnt reach conditional");
			return false;
			 
		}
		
	int colDir  = 1;
	int rowDir = 1;
	
	
		if ((curCol-destCol) > 0)
		{
			colDir = -1;
			System.out.println("moving left");
		}
	


		if ((destRow-curRow) > 0)
		{
			rowDir = -1; 
			return false;
		}
if(firstMove)
{	
	{
		if(colDiff >2)
		{
			return false;
		}
	}
}
if(!firstMove)
{
if(colDiff > 1)
{
	return false;
}
}

if(rowDiff >2)
{
	return false;
}
 
if(Board.getBoardValue(curCol, curRow) <= 15 && (Board.getBoardValue(curCol, curRow) >= 0))
{
	if(destCol - curCol < 0)
	{
		colDir = 1;
	}
	else
	{
		colDir = -1;
		
	}
}
if(Board.getBoardValue(curCol, curRow) <= 31 && (Board.getBoardValue(curCol, curRow) >= 16))
{
	if(destCol - curCol > 0)
	{
		
		colDir = 1;
}
	else {
		colDir = -1;
	}
	
}

if(colDir < 0)
{
	return false;
}
			
		if(Board.getBoardValue(destCol, destRow) >= 0)
		{
		    if(  ((Board.pieces[Board.getBoardValue(destCol, destRow)]).getColor()).equals( currP.getColor())    )
		    {
		    System.out.print("same color is true");
		    	sameColor = true;
		    	System.out.print(Board.pieces[Board.getBoardValue(destCol, destRow)]);
		    	
		    }
		}



if(rowDiff == 1)
{
	if((Board.getBoardValue(destCol, destRow)) != -1)
{
	return true;
}
}

if(colDiff == 1)
{
	if((Board.getBoardValue(destCol, destRow)) != -1)
	{
		return false;
	}
}
	
	
		return true;
	}



int pawnState = 0;

public int setMoveState()
{
	return pawnState++;
	
}
public int  getMoveState()
{
	return pawnState;
	
}
	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return type.PAWN;
	}

	@Override
	public ColorP getColor() {
		// TODO Auto-generated method stub
		return color;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "P";
	}




}
