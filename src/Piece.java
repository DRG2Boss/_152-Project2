// This is an abstract object that tracks the actions every piece should take.

import javax.swing.*;
import java.awt.*;

public abstract class Piece {
    public ImageIcon chessPiece;
    public boolean isWhite;
    public String pieceType;

    public abstract boolean canMove(int startX, int startY, int endX, int endY);

    public void drawPiece(int x, int y, Graphics g) {
        g.drawImage(chessPiece.getImage(), x, y, null);
    }
}