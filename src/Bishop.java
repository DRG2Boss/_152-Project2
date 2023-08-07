import javax.swing.*;

public class Bishop extends Piece {
    public Bishop(boolean b) {
        pieceType = "Bishop";
        isWhite = b;

        if(isWhite) {
            chessPiece = new ImageIcon("wbishop.gif");
        }
        else {
            chessPiece = new ImageIcon("bbishop.gif");
        }
    }
}