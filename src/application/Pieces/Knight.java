package application.Pieces;

import application.Game.Board;
import application.Game.Piece;
import application.Game.Player;

public class Knight extends Piece {

	ColorP color;
	Type type;
	//this is just for git test
	public Knight(ColorP color) {
		super(color);
		this.color = color;
		
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
		
		System.out.println( "currP" +currP);

			int rowDiff = Math.abs(destRow - curRow);
			int colDiff = Math.abs(destCol - curCol);
		System.out.println("rowDiff: " + rowDiff);
		System.out.println("colDiff: " + colDiff);
		
		System.out.println("curCol: " + curCol);
	    System.out.println("curRow: " + curRow);
		System.out.println("destRow: " + destRow);
	    System.out.println("destCol: " + destCol);
	    
	
			
		if(Board.getBoardValue(destCol, destRow) >= 0)
		{
		    if(  ((Board.pieces[Board.getBoardValue(destCol, destRow)]).getColor()).equals( currP.getColor())    )
		    {System.out.print("destRow: " + destRow);
		    System.out.print("destCol: " + destCol);
		    System.out.print("same color is true");
		    	sameColor = true;
		    	System.out.print(Board.pieces[Board.getBoardValue(destCol, destRow)]);
		    	
		    }
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
				System.out.println("moving d");
			}
	
	if(Math.abs(rowDiff-colDiff) !=1 || colDiff >=3 || rowDiff >=3)
	{
		return false;
	}
	
	
	return true;
	}

	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return type.KNIGHT;
	}

	@Override
	public ColorP getColor() { 
		// TODO Auto-generated method stub
		return color;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "KN";
	}



}
