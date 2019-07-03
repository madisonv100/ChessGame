package application.Game;

import application.Pieces.Biship;
import application.Pieces.King;
import application.Pieces.Knight;
import application.Pieces.Pawn;
import application.Pieces.Queen;
import application.Pieces.Rook;

 public  class Board {
	
public static int [][] board= new int [8][8];
public static Piece[] pieces  = new Piece[32];


static public void createBoard() {	
int index = 0;

	for(int i = 0; i< 8; i ++)
	{   
		
		board[7][i] = index;
		index ++;			
	}
	 
	
	for(int j = 0; j < 8; j ++)
	{   
	
		board[6][j] = index;
		index ++;			
	}
	 
	for(int k = 0; k< 8; k ++)
	{   
		
		board[0][k] = index;
		index ++;			
	}
	
	

	for(int t = 0; t< 8; t ++)
	{   
		board[1][t] = index;
		index ++;			
	}
	
	int countRow = 2;
	int countColumn = 0;
	
	for(int h = 0 ; h < 8; h++)
	{
		board[countRow][countColumn] = -1;
		
		 countColumn ++;	
	}
	countRow = 3;
	countColumn = 0;
	for(int h = 0 ; h < 8; h++)
	{
		board[countRow][countColumn] = -1;
		
		 countColumn ++;	
	}	
	countRow = 4;
	countColumn = 0;
	for(int h = 0 ; h < 8; h++)
	{
		board[countRow][countColumn] = -1;
		
		 countColumn ++;	
	}	 
	countRow = 5;
	countColumn = 0;
	for(int h = 0 ; h < 8; h++)
	{
		board[countRow][countColumn] = -1;
		
		 countColumn ++;	
	}	
}

public static int  getBoardValue(int curRow, int curCol)
{
	
	return  board[curRow][curCol] ;
	
}



public static void setboardValue(int value, int destRow, int destCol)
{
	board[destRow][destCol] = value;
	
}


static public void  createPieces()
{ 
	pieces[0] = new Rook(Piece.ColorP.BLACK);
	
	pieces[1] = new Knight(Piece.ColorP.BLACK);
	pieces[2] = new Biship(Piece.ColorP.BLACK);
	pieces[3] = new Queen(Piece.ColorP.BLACK);
	pieces[4] = new King(Piece.ColorP.BLACK);
	pieces[5] = new Biship(Piece.ColorP.BLACK); 
	pieces[6] = new Knight(Piece.ColorP.BLACK);
	pieces[7] = new Rook(Piece.ColorP.BLACK);
	pieces[8] = new Pawn(Piece.ColorP.BLACK);
	pieces[9] = new Pawn(Piece.ColorP.BLACK);
	pieces[10] = new Pawn(Piece.ColorP.BLACK);
	pieces[11] = new Pawn(Piece.ColorP.BLACK);
	pieces[12] = new Pawn(Piece.ColorP.BLACK);
	pieces[13] = new Pawn(Piece.ColorP.BLACK);
	pieces[14] = new Pawn(Piece.ColorP.BLACK);
	pieces[15] = new Pawn(Piece.ColorP.BLACK);
	

	pieces[16] = new Rook(Piece.ColorP.WHITE);
	pieces[17] = new Knight(Piece.ColorP.WHITE);
	pieces[18] = new Biship(Piece.ColorP.WHITE);
	pieces[19] = new Queen(Piece.ColorP.WHITE);
	pieces[20] = new King(Piece.ColorP.WHITE);
	pieces[21] = new Biship(Piece.ColorP.WHITE);
	pieces[22] = new Knight(Piece.ColorP.WHITE);
	pieces[23] = new Rook(Piece.ColorP.WHITE);
	pieces[24] = new Pawn(Piece.ColorP.WHITE);
	pieces[25] = new Pawn(Piece.ColorP.WHITE);
	pieces[26] = new Pawn(Piece.ColorP.WHITE);
	pieces[27] = new Pawn(Piece.ColorP.WHITE);
	pieces[28] = new Pawn(Piece.ColorP.WHITE);
	pieces[29] = new Pawn(Piece.ColorP.WHITE);
	pieces[30] = new Pawn(Piece.ColorP.WHITE);
	pieces[31] = new Pawn(Piece.ColorP.WHITE);
	
	
	
}
public  Piece getPieceValue(int index)
{
	System.out.println(pieces[index]);

	return pieces[index];
	
	
}

	
	
	
	
	
	
	
	

	
	
	
}