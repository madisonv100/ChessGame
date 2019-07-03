package application.Pieces;

import application.Game.Board;
import application.Game.Piece;
import application.Game.Player;


public class King extends Piece {
Type type;

	ColorP color;

	public King(ColorP color) {
		super(color);
		this.color = color;
		
		
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
		
		System.out.println( "currP color" +currP.getColor());

			int rowDiff = Math.abs(destRow - curRow);
			int colDiff = Math.abs(destCol - curCol);

	    if(Board.getBoardValue(destCol, destRow) >= 0)
		{
		    if(  ((Board.pieces[Board.getBoardValue(destCol, destRow)]).getColor()).equals( currP.getColor())     )
		    {
		    System.out.print("cant take piece that is same color");
		    	sameColor = true;
		    	System.out.print(Board.pieces[Board.getBoardValue(destCol, destRow)]);
		    	
		    }
		}

			
		int colDir  = 1;
		int rowDir = 1;
		
		if(rowDiff > 1 || colDiff > 1)
		{
			return false;
		}
			
		if(Board.getBoardValue(curCol, curRow) <= 15 && (Board.getBoardValue(curCol, curRow) >= 0))
		{
			if(destCol - curCol < 0)
			{
				colDir = 1;
				int tempCol = curCol-2;
				int tempRow = curRow-2;
				if(Board.getBoardValue(tempCol, tempRow) != -1)
				{
				if ( Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType().equals(type.PAWN) && Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getColor().equals(ColorP.WHITE)  )
				                  {
					      System.out.println("Pawn putting you in check");
					      return false;
				                  }
				}
				tempCol = curCol-2;
				tempRow = curRow+2;
				 if(Board.getBoardValue(tempCol, tempRow) != -1)
				{
					if( Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType().equals(type.PAWN) && Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getColor().equals(ColorP.WHITE)  )
					{
						 System.out.println("Pawn putting you in check");
					      return false;
					} 
				}
			}
			else
			{
				colDir = -1;  
			 
			}
		}
		if(Board.getBoardValue(curCol, curRow) <= 31 && (Board.getBoardValue(curCol, curRow) >= 16))
		{
			int tempCol = curCol+2;
			 int tempRow = curRow-2;
			if(destCol - curCol > 0)
			{
				
				colDir = 1;
				if(Board.getBoardValue(tempCol, tempRow) != -1)
				{
				if ( Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType().equals(type.PAWN) && Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getColor().equals(ColorP.BLACK)  )
				                  {
					      System.out.println("Pawn putting you in check");
					      return false;
				                  }
				}
				tempCol = curCol+2;
				tempRow = curRow+2;
				 if(Board.getBoardValue(tempCol, tempRow) != -1)
				{
					if( Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType().equals(type.PAWN) && Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getColor().equals(ColorP.BLACK)  )
					{
						 System.out.println("Pawn putting you in check");
					      return false;
					} 
				}
			}
		}
			else 
			{
				colDir = -1;
			}
		
		if ((destRow-curRow) > 0)
		{
			rowDir = -1; 
			System.out.println("moving d");
		}
	//Checking up
	
		//king
		
		int tempCol = destCol;
		int tempRow = destRow-2;
		if(destRow > 2)
		{
		 if(Board.getBoardValue(tempCol, tempRow) != -1)
		 {
			System.out.println("checking up KING");
			 if( (Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType().equals(type.KING)   && Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getColor() != currP.getColor()  ))
					 {
				       return false;
					 }
		 }
		} 
		
		//queen and rook
		 tempCol = destCol;
		 tempRow = destRow-1;
		for(int i = destRow; i > 0 ; i--)
		{
			 if(Board.getBoardValue(tempCol, tempRow) != -1)
			 {System.out.println("checking up");
		
				 System.out.println(Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType());
				 if( (Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType().equals(type.ROOK) || Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType().equals(type.QUEEN))  && Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getColor() != currP.getColor()  ) 
				 {
					 return false;
				 }
				 if((Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType() != Type.QUEEN || Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType() != Type.ROOK ))
				 {
			 break;
				 }
			 }
			 tempRow--;
		}
		//checking down
		
		//king
		tempCol = destCol;
		tempRow = destRow+2;
		if(destRow < 6)
		{
		 if(Board.getBoardValue(tempCol, tempRow) != -1)
		 {
			 System.out.println("checking Down KING");
			 if( (Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType().equals(type.KING)   && Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getColor() != currP.getColor()  ))
					 {
				       return false;
					 }
		 }
		
		}
		//queen and rook
		 tempCol = destCol;
		 tempRow = destRow+1; 
		for(int i = destRow; i < 6 ; i++)
		{
			 if(Board.getBoardValue(tempCol, tempRow) != -1)
			 {System.out.println("checking down");
				 System.out.println(Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType());
			
				 if( (Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType().equals(type.ROOK) || Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType().equals(type.QUEEN))  && Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getColor() != currP.getColor()  ) 
				 {
					
					 return false;
				 }
				 if((Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType() != Type.QUEEN || Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType() != Type.ROOK ))
				 {
			 break;
				 }
			 }
			 tempRow++;
		}
		//checking left
		
		//king
		if(destCol > 2)
		{
			
		tempCol = destCol-2;
		tempRow = destRow;
		 if(Board.getBoardValue(tempCol, tempRow) != -1)
		 {
			 System.out.println("checking left KING");
			 if( (Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType().equals(type.KING)   && Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getColor() != currP.getColor()  ))
					 {
				       return false;
					 }
		 }
		}
		
		
		//queen and rook
		 tempCol = destCol-1;
		 tempRow = destRow;
		 
		for(int i = destCol; i > 0 ; i--)
		{
			 if(Board.getBoardValue(tempCol, tempRow) != -1)
			 {System.out.println("checking left");
			
				 System.out.println(Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType());
				 if( (Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType().equals(type.ROOK) || Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType().equals(type.QUEEN))  && Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getColor() != currP.getColor()  ) 
				 {
					 return false;
				 }
				 if((Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType() != Type.QUEEN || Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType() != Type.ROOK ))
				 {
			 break;
				 }
			 }
			 tempCol--;
		}
		//checking right
		
		//king
		if(destCol < 5)
		{
		tempCol = destCol+2;
		tempRow = destRow;
		 if(Board.getBoardValue(tempCol, tempRow) != -1)
		 {
			 System.out.println("checking right KING");
			 if( (Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType().equals(type.KING)   && Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getColor() != currP.getColor()  ))
					 {
				       return false;
					 }
		 }
		
		}
		//queen and rook
		 tempCol = destCol+1;
		 tempRow = destRow;
		for(int i = destCol; i < 7 ; i++)
		{
			 if(Board.getBoardValue(tempCol, tempRow) != -1)
			 {System.out.println("checking right");
			
				 System.out.println(Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType());
				 if( (Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType().equals(type.ROOK) || Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType().equals(type.QUEEN))  && Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getColor() != currP.getColor()  ) 
				 {
					 return false;
				 }
				 if((Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType() != type.QUEEN || Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType() != type.ROOK ))
				 {
			 break;
				 }
			 }
			 tempCol++;
		}
		
		//Checking up right
		
			//king
		if(destCol < 6 && destRow >2)
		{
			 tempCol = destCol+2;
			 tempRow = destRow-2;
			 if(Board.getBoardValue(tempCol, tempRow) != -1)
			 {
				 System.out.println("checking up right KING");
				 if( (Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType().equals(type.KING)   && Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getColor() != currP.getColor()  ))
						 {
					       return false;
						 }
			 }
		}
			
			
			//queen and rook
			 tempCol = destCol+1;
			 tempRow = destRow-1;
			for(int i = destRow; i > 2 ; i--)
			{
				 if(Board.getBoardValue(tempCol, tempRow) != -1)
				 {System.out.println("checking up right");
			
					 System.out.println(Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType());
					 if( (Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType().equals(type.BISHOP) || Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType().equals(type.QUEEN))  && Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getColor() != currP.getColor()  ) 
					 {
						 return false;
					 }
					 if((Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType() != Type.QUEEN || Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType() != Type.BISHOP ))
					 {
				 break;
					 } 
				 }
				 tempRow--;
				 tempCol++;
			}
			//checking up left
			
			//king
			if(destCol >2 && destRow >2)
			{
			tempCol = destCol-2;
			tempRow = destRow-2;
			 if(Board.getBoardValue(tempCol, tempRow) != -1)
			 {
				 System.out.println("checking up left KING");
				 if( (Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType().equals(type.KING)   && Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getColor() != currP.getColor()  ))
						 {
					       return false;
						 }
			 }
			
			}
			//queen and rook
			 tempCol = destCol-1;
			 tempRow = destRow-1; 
			for(int i = destRow; i > 2 ; i--)
			{
				 if(Board.getBoardValue(tempCol, tempRow) != -1)
				 {System.out.println("checking down");
					 System.out.println(Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType());
				
					 if( (Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType().equals(type.BISHOP) || Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType().equals(type.QUEEN))  && Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getColor() != currP.getColor()  ) 
					 {
						
						 return false;
					 }
					 if((Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType() != Type.BISHOP || Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType() != Type.ROOK ))
					 {
				 break;
					 }
				 }
				 tempRow--;
				 tempCol--;
			}
			//checking down right 
			
			//king
			if(destCol < 5 && destRow <5)
			{
			tempCol = destCol+2;
			tempRow = destRow+2;
			 if(Board.getBoardValue(tempCol, tempRow) != -1)
			 {
				 System.out.println("checking down right KING");
				 if( (Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType().equals(type.KING)   && Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getColor() != currP.getColor()  ))
						 {
					       return false;
						 }
			 }
			
			}
			//queen and rook
			 tempCol = destCol+1; 
			 tempRow = destRow+1;
			 
			for(int i = destCol; i > 1 ; i--)
			{
				 if(Board.getBoardValue(tempCol, tempRow) != -1)
				 {System.out.println("checking down right");
				
					 System.out.println(Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType());
					 if( (Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType().equals(type.BISHOP) || Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType().equals(type.QUEEN))  && Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getColor() != currP.getColor()  ) 
					 {
						 return false;
					 }
					 if((Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType() != Type.BISHOP || Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType() != Type.ROOK ))
					 {
				 break;
					 }
				 }
				 tempCol++;
				 tempRow++;
			}
			//checking down left
			
			//king
			if(destRow < 6 && destCol >2)
			{
			tempCol = destCol-2;
			tempRow = destRow+2;
			 if(Board.getBoardValue(tempCol, tempRow) != -1)
			 {
				 System.out.println("checking down left KING");
				 if( (Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType().equals(type.KING)   && Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getColor() != currP.getColor()  ))
						 {
					       return false;
						 }
			 }
			}
			
			//queen and rook
			 tempCol = destCol-1;
			 tempRow = destRow+1;
			for(int i = destCol; i < 6 ; i++)
			{
				 if(Board.getBoardValue(tempCol, tempRow) != -1)
				 {System.out.println("checking down left");
				
					 System.out.println(Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType());
					 if( (Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType().equals(type.BISHOP) || Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType().equals(type.QUEEN))  && Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getColor() != currP.getColor()  ) 
					 {
						 return false;
					 }
					 if((Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType() != type.BISHOP || Board.pieces[(Board.getBoardValue(tempCol, tempRow))].getType() != type.ROOK ))
					 {
				 break;
					 }
				 }
				 tempCol--;
				 tempRow++;
			}
		
		return true;
	}	

	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return type.KING;
	}

	@Override
	public ColorP getColor() {
		// TODO Auto-generated method stub
		return color;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "K";
	}






}
