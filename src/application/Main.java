package application;

import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;

import application.Game.Board;
import application.Game.MoveLogic;
import application.Game.Piece;
import application.Game.Piece.Type;

import application.Game.Piece.ColorP;
import application.Game.Player;
import application.Pieces.Biship;
import application.Pieces.King;
import application.Pieces.Knight;
import application.Pieces.Pawn;
import application.Pieces.Queen;
import application.Pieces.Rook;
import javafx.application.Application;
import javafx.beans.property.Property;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import application.Pieces.Queen;

public class Main extends Application {
	StackPane rootPane = new StackPane();
	GridPane chessBoard = new GridPane();
	Pane whiteCapP = new Pane();
	Pane blackCapP = new Pane();
	int curRow;
	int curCol;
	int destRow;
	int destCol;
	int value;
	

	int moveState = 0;
	private boolean whiteMove = true;
	
	private Scene scene1;
	private Scene scene2;
	
	 
	public class PushMe implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {
			GridButton b = (GridButton) e.getSource();
			
			
		if (moveState == 0)
		{
			
			curRow = b.getRow();
			curCol = b.getCol();
		if( Board.pieces[Board.getBoardValue(curCol, curRow)].getColor().equals(ColorP.WHITE))
			{
			if(!whiteMove)
			{
				return;
			}
			
			}else
			{
				if(whiteMove)
				{
					return;
				}
			}
			moveState++;
			b.setStyle("-fx-background-color: green");
		}
		else if (moveState == 1)
		{
			destRow = b.getRow();
			destCol = b.getCol();
			System.out.println("DC "+destCol);
			b.setStyle("-fx-background-color: yellow");
			System.out.println("CR"+curRow);
			System.out.println("CC"+curCol);
			System.out.println(Board.board[curCol] [curRow]);
			//MoveLogic.movePiece(Board.board[curCol] [curRow], curRow,  curCol,  destRow,  destCol);
			if(MoveLogic.movePiece(Board.board[curCol] [curRow], curRow,  curCol,  destRow,  destCol))
			{
			whiteMove = !Board.pieces[Board.getBoardValue(destCol, destRow)].getColor().equals(ColorP.WHITE);
			}
          moveState++;
		}
		else if(moveState == 2)
		{ 
			for (int row = 0; row < 8; row++) {
				for (int col = 0; col < 8; col++) {
									
					Rectangle square = new Rectangle();
					chessBoard.add(square, row, col);
					if (Board.getBoardValue(row, col) == -1) {
						GridButton btn = new GridButton(getImage( row, col), col, row);
						btn.setOnAction(new EventHandler<ActionEvent>() {
				            @Override
				            public void handle(ActionEvent event) {
				            	System.out.println(btn.getRow()+ "," + btn.getCol());
				            }
				        });
						btn.setPrefWidth(100);
						btn.setPrefHeight(100);
						chessBoard.add(btn, row, col);
						btn.setOnAction(new PushMe());
						btn.setStyle("-fx-background-color: transparent; -fx-border-color: blue");
					}
					else
					{
					GridButton btn = new GridButton(getImage( row, col), col, row);
					btn.setOnAction(new EventHandler<ActionEvent>() {
			            @Override
			            public void handle(ActionEvent event) {
			                
			            }
			        });
					btn.setPrefWidth(100);
					btn.setPrefHeight(100);
					chessBoard.add(btn, row, col);
					btn.setOnAction(new PushMe());
					
					btn.setStyle("-fx-background-color: transparent; -fx-border-color: blue");
				
					}
					
				
					
				
				
					square.heightProperty().bind(chessBoard.heightProperty().divide(8));
					square.widthProperty().bind(chessBoard.widthProperty().divide(8));
					Color color;
					if ((row + col) % 2 == 0)
						color = Color.WHITE;
					else
						color = Color.GREY;
					square.setFill(color);
				}
				
			}
			
			moveState = 0;
		
		}
		
		  if(MoveLogic.getGameOverStatus() ==1)
		  {
			  Board.createPieces();
			Board.createBoard();
			MoveLogic.gameOver = 0;
			
		  }

		
		
		}
	}

		

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Chess");
		
		//set up scene one
//		Label label = new Label("Player One : ");
//		 TextField textfield = new TextField(); 
//		 
//		 Label label1 = new Label("Player two : "); 
//		 TextField textfield1 = new TextField(); 
//		 
//		 textfield.setPrefColumnCount(10); 
//		 textfield1.setPrefColumnCount(10); 
		 Button button1 = new Button ("Start Game");
			button1.setOnAction(e -> primaryStage.setScene((new Scene(chessBoard, 400, 400))));
		 HBox hbox = new HBox( button1); 
		 hbox.setSpacing(10); 
		 hbox.setAlignment(Pos.CENTER); 
		 Scene scene1 = new Scene(hbox, 280, 280); 
		
		 BackgroundFill background_fill = new BackgroundFill(Color.CYAN,  
                 CornerRadii.EMPTY, Insets.EMPTY); 
		
		 Background background = new Background(background_fill); 
		 hbox.setBackground(background);  
		
		

	
	
	
		
		
		
		//set up scene two 
		
		
		 
		Board.createPieces();
		Board.createBoard();
		chessBoard.setPadding(new Insets(10, 10, 10, 10));
		
		
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
								
				Rectangle square = new Rectangle();
				chessBoard.add(square, row, col);
				if (Board.getBoardValue(row, col) == -1) {
					GridButton btn = new GridButton(getImage( row, col), col, row);
					btn.setOnAction(new EventHandler<ActionEvent>() {
			            @Override
			            public void handle(ActionEvent event) {
			            	System.out.println(btn.getRow()+ "," + btn.getCol());
			            }
			        });
					btn.setPrefWidth(100);
					btn.setPrefHeight(100);
					chessBoard.add(btn, row, col);
					
					btn.setOnAction(new PushMe());
				
					btn.setStyle("-fx-background-color: transparent; -fx-border-color: blue");
				}
				else
				{
				GridButton btn = new GridButton(getImage( row, col), col, row);
				btn.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent event) {
		                System.out.println(btn.getRow()+ "," + btn.getCol());
		            }
		        }); 
				btn.setPrefWidth(100);
				btn.setPrefHeight(100);
				chessBoard.add(btn, row, col);
				btn.setOnAction(new PushMe());
				
				btn.setStyle("-fx-background-color: transparent; -fx-border-color: blue");
			
				}
				 
		
			
			
				square.heightProperty().bind(chessBoard.heightProperty().divide(8));
				square.widthProperty().bind(chessBoard.widthProperty().divide(8));
				Color color;
				if ((row + col) % 2 == 0)
					color = Color.WHITE;
				else
					color = Color.GREY;
				square.setFill(color);
			}
		
			
		}


			
		//primaryStage.setScene(new Scene(chessBoard, 400, 400));
		primaryStage.setScene(scene1);
		primaryStage.show();
		
	
	}
	public Image getImage(int row, int col)
	{
	if(Board.getBoardValue(row, col) == -1)
	{
		return new WritableImage(50, 50 );
	}
		Enum  type = Board.pieces[Board.getBoardValue(row, col)].getType();
		Enum  colors = Board.pieces[Board.getBoardValue(row, col)].getColor();
		if (type.equals(Type.QUEEN)  && colors.equals(ColorP.WHITE))
		{
			return new  Image(getClass().getResourceAsStream("white_queen.png"));
		}
		else if (type.equals(Type.QUEEN)  && colors.equals(ColorP.BLACK))
		{
			return new  Image(getClass().getResourceAsStream("black_queen.png")); 
		}
		else if (type.equals(Type.KING)  && colors.equals(ColorP.WHITE))
		{
			return new  Image(getClass().getResourceAsStream("white_king.png")); 
		}
		else if (type.equals(Type.KING)  && colors.equals(ColorP.BLACK))
		{
			return new  Image(getClass().getResourceAsStream("black_king.png")); 
		} 
		else if (type.equals(Type.BISHOP)  && colors.equals(ColorP.WHITE))
		{
			return new  Image(getClass().getResourceAsStream("white_bishop.png")); 
		}
		else if (type.equals(Type.BISHOP)  && colors.equals(ColorP.BLACK))
		{
			return new  Image(getClass().getResourceAsStream("black_bishop.png")); 
		}
		else if (type.equals(Type.KNIGHT)  && colors.equals(ColorP.WHITE))
		{
			return new  Image(getClass().getResourceAsStream("white_knight.png")); 
		}
		else if (type.equals(Type.KNIGHT)  && colors.equals(ColorP.BLACK))
		{
			return new  Image(getClass().getResourceAsStream("black_knight.png")); 
		}
		else if (type.equals(Type.ROOK)  && colors.equals(ColorP.WHITE))
		{
			return new  Image(getClass().getResourceAsStream("white_rook.png")); 
		}
		else if (type.equals(Type.ROOK)  && colors.equals(ColorP.BLACK))
		{
			return new  Image(getClass().getResourceAsStream("black_rook.png")); 
		}
		else if (type.equals(Type.PAWN)  && colors.equals(ColorP.WHITE))
		{
			return new  Image(getClass().getResourceAsStream("white_pawn.png")); 
		}
		else if (type.equals(Type.PAWN)  && colors.equals(ColorP.BLACK))
		{
			return new  Image(getClass().getResourceAsStream("black_pawn.png")); 
		}
		return null;
		
	}

	private static void main(String[] args) {
		launch(args);
		// TODO Auto-generated method stub

	}

	
}
