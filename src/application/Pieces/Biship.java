package application.Pieces;

import application.Game.Board;
import application.Game.Piece;
import application.Game.Player;


public class Biship extends Piece {

Type type;
ColorP color; 
public Biship(ColorP color) {
		super(color);
		this.color = color;
		 
		type = Type.BISHOP;
		// TODO Auto-generated constructor stub
	}




	@Override
	public boolean validMove(int curRow, int curCol, int destRow, int destCol) {
		
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
		
		System.out.println( "current Piece: " +currP);
//System.out.println("destColor"+((Board.pieces[Board.getBoardValue(destCol, destRow)]).getColor()));


			int rowDiff = Math.abs(destRow - curRow);
			int colDiff = Math.abs(destCol - curCol);
		
	    
		if((rowDiff != colDiff) )
		{
			System.out.print("Bishop doesnt move that way");
			return false; 
			
		}
			
		if(Board.getBoardValue(destCol, destRow) >= 0)
		{
		    if(  ((Board.pieces[Board.getBoardValue(destCol, destRow)]).getColor()).equals( currP.getColor())    )
		    {
		    System.out.print("cant take a piece that is the same color");
		    	sameColor = true;
		    	System.out.print(Board.pieces[Board.getBoardValue(destCol, destRow)]);
		    	
		    }
		}

			
		int colDir  = 1;
		int rowDir = 1;
		
		
			if ((curCol-destCol) > 0)
			{
				colDir = -1;
				//System.out.println("moving left");
			}
		


			if ((destRow-curRow) > 0)
			{
				rowDir = -1; 
				//System.out.println("moving d");
			}

	
	//Moving Diagnol 
	if (rowDiff == colDiff)
	{
		//moving down right 
		if(rowDir < 0 && colDir > 0)
		{
		
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
			
			int nextRow = curRow-1; 
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
				nextRow--;
				nextCol++;
				
			}
		}
		//Moving down left
		else if(rowDir < 0 && colDir < 0  )
		{
			
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
	// TODO Auto-generated method stub
	return type.BISHOP;
}

@Override
public ColorP getColor() {
	// TODO Auto-generated method stub
	return color;
}

@Override
public String toString() {
	// TODO Auto-generated method stub
	return "B";
}
		

}




