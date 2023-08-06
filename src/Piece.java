// This is an abstract object that tracks the actions every piece should take.

import javax.swing.*;
import java.awt.*;

public class Piece {
    public static ImageIcon chessPiece;
    public boolean isWhite;

    public static void drawPiece(int x, int y, Graphics g) {
        g.drawImage(chessPiece.getImage(), x, y, null);
    }
}
