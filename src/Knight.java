// Define specifics for Knight as subclass of Piece.

import javax.swing.*;

public class Knight extends Piece {
    public Knight(boolean b) {
        // Assign "piece" variables and choose image based on pieceType and color.
        pieceType = "Knight";
        isWhite = b;
        if(isWhite) {
            chessPiece = new ImageIcon("wknight.gif");
        }
        else {
            chessPiece = new ImageIcon("bknight.gif");
        }
    }

    // Limit movements to what Knights are able to do using carMove function from Piece.
        // Must move in an L shape.
        // 2 squares horizontally and 1 square vertically
        // OR 2 squares vertically and 1 horizontally
    public boolean canMove(int startX, int startY, int endX, int endY){
        return(endX == startX - 1 && (endY == startY + 2 || endY == startY - 2)) ||
                (endX == startX + 1 && (endY == startY + 2 || endY == startY - 2)) ||
                (endX == startX + 2 && (endY == startY + 1 || endY == startY - 1)) ||
                (endX == startX - 2 && (endY == startY + 1 || endY == startY - 1));
    }
}