import javax.swing.*;

public class Rook extends Piece {
    public Rook(boolean b) {
        pieceType = "Rook";
        isWhite = b;

        if(isWhite) {
            chessPiece = new ImageIcon("wrook.gif");
        }
        else {
            chessPiece = new ImageIcon("brook.gif");
        }
    }
}