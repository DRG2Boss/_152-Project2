// This creates a big graphical object I can add to the window.
// This object will create a chess board and fill it with the defined chest pieces.

import javax.swing.*;
import java.awt.*;

public class boardComponent extends JComponent {
    public void paintComponent(Graphics g) {
        // Nested for loop to track x and y position.
        for(int y = 0; y <= 7; y++) {
            for (int x = 0; x <= 7; x++) {
                // If both x AND y are even, OR x AND y are odd, paint the lighter rectangle.
                if((x % 2 == 0 && y % 2 == 0) || (x % 2 == 1 && y % 2 == 1)) {
                    g.setColor(new Color(233, 174, 95));
                    g.fillRect(x * Chess.TILE_SIZE, y * Chess.TILE_SIZE, Chess.TILE_SIZE, Chess.TILE_SIZE);
                }
                // Otherwise, paint the darker rectangle.
                else {
                    g.setColor(new Color(177, 113, 24));
                    g.fillRect(x * Chess.TILE_SIZE, y * Chess.TILE_SIZE, Chess.TILE_SIZE, Chess.TILE_SIZE);
                }
                // If the position within the array is NOT null, run method drawPiece within the Piece class.
                if(Chess.position[x][y] != null) {
                    Piece.drawPiece(x * 44, y * 44, g);
                }
            }
        }
    }
}
