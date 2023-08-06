import javax.swing.*;

public class Knight extends Piece {
    public Knight(boolean b) {
        isWhite = b;
        if(isWhite) {
            chessPiece = new ImageIcon("wknight.gif");
        }
        else {
            chessPiece = new ImageIcon("bknight.gif");
        }
    }
}