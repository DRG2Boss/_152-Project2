import javax.swing.*;

public class King extends Piece {
    public King(boolean b) {
        isWhite = b;
        if(isWhite) {
            chessPiece = new ImageIcon("wking.gif");
        }
        else {
            chessPiece = new ImageIcon("bking.gif");
        }
    }
}