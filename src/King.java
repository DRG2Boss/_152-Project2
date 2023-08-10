// Define specifics for King as subclass of Piece.

import javax.swing.*;

public class King extends Piece {
    public King(boolean bIsWhite) {
        // Assign "piece" variables and choose image based on pieceType and color.
        pieceType = "King";
        isWhite = bIsWhite;

        if(isWhite) {
            chessPiece = new ImageIcon("wking.gif");
        }
        else {
            chessPiece = new ImageIcon("bking.gif");
        }
    }

    // Limit movements to what Kings are able to do using carMove function from Piece.
        // Can move one space in any direction.
    public boolean canMove(int startX, int startY, int endX, int endY) {
        return (Math.abs(endX - startX) == 1 || endX == startX) &&
                (Math.abs(endY - startY) == 1 || endY == startY);
    }
}