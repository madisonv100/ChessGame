package application.Game;

import java.util.List;




public abstract class Piece {
	
public enum Type {
	BISHOP, KING, QUEEN, ROOK, KNIGHT, PAWN

}

public enum ColorP {
WHITE, BLACK
}
// capture
//type
//movement (path)
//be captured 

Type type;
public ColorP color;

public Player player;

public Piece(ColorP color)

{
}

public abstract boolean validMove(int curRow, int curCol, int destRow, int destCol);
//public abstract void move( int curRow, int curCol, int destRow, int destCol);

public abstract Boolean validPath(int startX, int startY,int finalX, int finalY);

public abstract Type getType();
public abstract ColorP getColor();

public abstract String toString();


}
