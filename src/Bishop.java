// Define specifics for Bishop as subclass of Piece.

import javax.swing.*;

public class Bishop extends Piece {
    public Bishop(boolean b) {
        // Assign "piece" variables and choose image based on pieceType and color.
        pieceType = "Bishop";
        isWhite = b;

        if(isWhite) {
            chessPiece = new ImageIcon("wbishop.gif");
        }
        else {
            chessPiece = new ImageIcon("bbishop.gif");
        }
    }

    // Limit movements to what Bishops are able to do using carMove function from Piece.
        // Can move any number of spaces diagonally.
    public boolean canMove(int startX, int startY, int endX, int endY){
        int dX = Math.abs(endX - startX);
        int dY = Math.abs(endY - startY);

        // Return true or false based on if dX == dY.
        return dX == dY;
    }
}