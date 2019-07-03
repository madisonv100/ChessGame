package application.Pieces;

import application.Game.Board;
import application.Game.Piece;
import application.Game.Player;

public class Rook extends Piece {
ColorP color ;
Type type;
	public Rook(ColorP color) {
		super(color);
		this.color = color;
		type = type.ROOK;
		
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
	 	
	 	System.out.println( "current piece" +currP);

	 		int rowDiff = Math.abs(destRow - curRow);
	 		int colDiff = Math.abs(destCol - curCol);

	     
	 	if((rowDiff!= 0) && (colDiff != 0))
	 	{ 
	 		System.out.print("not a valid move for the rook");
	 		return false;
	 		
	 	} 
	 		
	 	if(Board.getBoardValue(destCol, destRow) >= 0)
	 	{
	 	    if(  ((Board.pieces[Board.getBoardValue(destCol, destRow)]).getColor()).equals( currP.getColor())    )
	 	    {
	 	    System.out.print("you cant take your own piece");
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
	 		{
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
	 				
	 					System.out.print("count :"+count);
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
		return true;
		
		
		}

	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return Type.ROOK;
	}

	@Override
	public ColorP getColor() {
		// TODO Auto-generated method stub
		return color;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "R";
	}





}
