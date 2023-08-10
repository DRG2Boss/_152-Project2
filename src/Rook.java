// Define specifics for Rook as subclass of Piece.

import javax.swing.*;

public class Rook extends Piece {
    public Rook(boolean bIsWhite) {
        // Assign "piece" variables and choose image based on pieceType and color.
        pieceType = "Rook";
        isWhite = bIsWhite;

        if(isWhite) {
            chessPiece = new ImageIcon("wrook.gif");
        }
        else {
            chessPiece = new ImageIcon("brook.gif");
        }
    }

    // Limit movements to what Rooks are able to do using carMove function from Piece.
        // Can move any number of spaces horizontally or vertically.
    public boolean canMove(int startX, int startY, int endX, int endY){
        return (endX == startX && ((endY > startY && endY < 8) || (endY < startY && endY >= 0))) ||
                (endY == startY && ((endX > startX && endX < 8) || (endX < startX && endX >= 0)));
    }
}