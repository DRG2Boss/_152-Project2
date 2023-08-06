import javax.swing.*;

public class Rook extends Piece {
    public Rook(boolean b) {
        isWhite = b;
        if(isWhite) {
            chessPiece = new ImageIcon("wrook.gif");
        }
        else {
            chessPiece = new ImageIcon("brook.gif");
        }
    }
}