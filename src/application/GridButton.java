package application;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GridButton extends Button {
	
private int row = 0;
private int col = 0;

public GridButton(Image image, int row, int col) {
	super("");
	this.row = row;
	this.col = col;
	this.setGraphic(new ImageView(image));
	
	
}

public int getRow() {
	return row;
}
public int getCol() {
	return col;
}


}
