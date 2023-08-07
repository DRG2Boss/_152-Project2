// Define specifics for Pawn as subclass of Piece.

import javax.swing.*;

public class Pawn extends Piece {
    public Pawn(boolean b) {
        // Assign "piece" variables and choose image based on pieceType and color.
        pieceType = "Pawn";
        isWhite = b;

        if(isWhite) {
            chessPiece = new ImageIcon("wpawn.gif");
        }
        else {
            chessPiece = new ImageIcon("bpawn.gif");
        }
    }

    // Limit movements to what Pawns are able to do using carMove function from Piece.
        // Must move 1 square forward (up for white, down for black).
        // Except for the first move, where it can move 1 or 2 spaces forward.
    public boolean canMove(int startX, int startY, int endX, int endY) {
        if(isWhite) {
            return endX == startX && ((startY <= 6 && endY == startY - 1) || (startY == 6 && endY == startY - 2));
        }
        else {
            return endX == startX && ((startY >= 1 && endY == startY + 1) || (startY == 1 && endY == startY + 2));
        }
    }
}
