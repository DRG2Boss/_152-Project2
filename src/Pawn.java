import javax.swing.*;

public class Pawn extends Piece {
    public Pawn(boolean b) {
        pieceType = "Pawn";
        isWhite = b;

        if(isWhite) {
            chessPiece = new ImageIcon("wpawn.gif");
        }
        else {
            chessPiece = new ImageIcon("bpawn.gif");
        }
    }
}
