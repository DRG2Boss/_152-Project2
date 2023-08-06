// This object will listen for mouse presses and releases within "board" and respond to them.

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// Must implement MouseListener

public class boardMouseListener implements MouseListener {
    int startX;
    int startY;
    int endX;
    int endY;

    public void mousePressed(MouseEvent e) {
        // Track the coordinates anywhere the user mouse presses within the board.
        // These coordinates need to be divided by 44 to fit within the position array index correctly.
        int possibleStartX = e.getX()/44;
        int possibleStartY = e.getY()/44;

        // If the tile selected contains a piece, track that tile using variables startX and startY.
        if(Chess.position[possibleStartX][possibleStartY] != null) {
            startX = possibleStartX;
            startY = possibleStartY;
        }
    }
    public void mouseReleased(MouseEvent e) {
        // Do the same for releasing the mouse click.
        int possibleEndX = e.getX()/44;
        int possibleEndY = e.getY()/44;

        // If the tile selected does NOT contain a piece
        if(Chess.position[possibleEndX][possibleEndY] == null) {
            // Track this tile using endX and endY.
            endX = possibleEndX;
            endY = possibleEndY;

            // Reassign that pieces starting tile to the one we released the mouse over.
            Chess.position[endX][endY] = Chess.position[startX][startY];
            // Make the starting position empty.
            Chess.position[startX][startY] = null;
        }
        // Now redraw the board to see the new position updated graphically.
        Chess.board.repaint();
    }
    // Don't need these, just need to define them as an implementation action requirement.
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
}