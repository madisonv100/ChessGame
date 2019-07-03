package application.Game;

import application.Main;
import application.Game.Piece.Type;
import application.Pieces.Queen;

public class MoveLogic {
	public static  int gameOver = 0;
	public static boolean movePiece(int value, int curRow, int curCol, int destRow, int destCol)
	{
	

		
	 
			
				System.out.println(value);
			
				if(Board.pieces[value].validMove(curRow, curCol, destRow, destCol)  == true)
				{
				if(Board.getBoardValue(destCol, destRow) != -1 )
				{System.out.println(Board.pieces[Board.getBoardValue(destCol, destRow)].getType());
					if(Board.pieces[Board.getBoardValue(destCol, destRow)].getType().equals(Type.KING))
					{
						System.out.println("Game Over");
						gameOver = 1;
						
					}
				}
				Board.setboardValue(-1, curCol, curRow);
				Board.setboardValue(value, destCol, destRow);
				
				System.out.println("valid Move");
				return true;
				}
				else
				{
					System.out.println("invalid Move"); 
					return false;
				}
			

			
			

	
	
}
public static int getGameOverStatus()
{ 
	return gameOver;
	
}
}
