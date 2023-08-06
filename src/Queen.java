import javax.swing.*;

public class Queen extends Piece {
    public Queen(boolean b) {
        isWhite = b;
        if(isWhite) {
            chessPiece = new ImageIcon("wqueen.gif");
        }
        else {
            chessPiece = new ImageIcon("bqueen.gif");
        }
    }
}