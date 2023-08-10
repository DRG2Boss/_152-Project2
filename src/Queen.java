// Define specifics for Queen as subclass of Piece.

import javax.swing.*;

public class Queen extends Piece {
    public Queen(boolean bIsWhite) {
        // Assign "piece" variables and choose image based on pieceType and color.
        pieceType = "Queen";
        isWhite = bIsWhite;

        if(isWhite) {
            chessPiece = new ImageIcon("wqueen.gif");
        }
        else {
            chessPiece = new ImageIcon("bqueen.gif");
        }
    }

    // Limit movements to what Queens are able to do using carMove function from Piece.
        // Can move any number of spaces horizontally, vertically, OR diagonally.
        // Same movement abilities as BOTH Rook and Bishop.
    public boolean canMove(int startX, int startY, int endX, int endY) {
        // Rook
        if((endX == startX && ((endY > startY && endY < 8) || (endY < startY && endY >=0))) ||
                (endY== startY && ((endX> startX && endX < 8) || (endX < startX && endX >=0)))){
            return true;
        }
        // Bishop
        int dX = Math.abs(endX - startX);
        int dY = Math.abs(endY - startY);

        return dX == dY;
    }
}