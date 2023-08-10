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

        // Two if statements to let user know they cannot select outside the board / an empty tile.
        if (possibleStartX < 0 || possibleStartX > 7 || possibleStartY < 0 || possibleStartY > 7) {
            System.out.println("Invalid move - cannot select something outside of the board.");
            return;
        }
        if (Chess.position[possibleStartX][possibleStartY] == null) {
            System.out.println("Invalid move - cannot select an empty tile.");
        }

        // If the tile selected contains a piece, track that tile using variables startX and startY.
        else {
            startX = possibleStartX;
            startY = possibleStartY;
            System.out.println("Start: "+startX+","+startY);
        }
    }
    public void mouseReleased(MouseEvent e) {
        // Do the same for releasing the mouse click.
        int possibleEndX = e.getX()/44;
        int possibleEndY = e.getY()/44;

        // If area selected is out of bounds OR the same tile as the starting piece.
        if (possibleEndX > 7 || possibleEndY > 7 || possibleEndX < 0 || possibleEndY < 0) {
            System.out.println("Invalid move - cannot move piece outside of the board.");
            return;
        }
        // If area selected is the same tile as the starting piece.
        if (startX == possibleEndX && startY == possibleEndY) {
            System.out.println("Invalid move - must move piece.");
            return;
        }
        // If you attempt to move a black piece as the first move.
        if (!Chess.position[startX][startY].isWhite) {
            System.out.println("Invalid move - you only control the white pieces.");
            return;
        }

        // If the tile selected is a valid move for that pieceType.
        if (Chess.position[startX][startY].canMove(startX, startY, possibleEndX, possibleEndY)) {
            // Track this tile using endX and endY, and print coordinates the piece moved to.
            endX = possibleEndX;
            endY = possibleEndY;
            System.out.println("End: "+endX+ ","+endY);

            // Reassign that piece's starting tile to the one we released the mouse over.
            Chess.position[endX][endY] = Chess.position[startX][startY];
            // Make the starting position empty.
            Chess.position[startX][startY] = null;
        }
        else {
            System.out.println("Invalid move - the selected piece cannot move there.");
            return;
        }
        // Now redraw the board to see the new position updated graphically.
        Chess.board.repaint();

        // Computer player setup.
        while(true) {
            // Assign startX, startY, endX, and endY values using Math.random().
            Chess.player.possibleStartX = (int) (Math.random() * 8);
            Chess.player.possibleStartY = (int) (Math.random() * 8);
            Chess.player.possibleEndX = (int) (Math.random() * 8);
            Chess.player.possibleEndY = (int) (Math.random() * 8);

            // If the computer selects a null space, call continue to try again.
            if (Chess.position[Chess.player.possibleStartX][Chess.player.possibleStartY] == null) {
                continue;
            }
            // If the piece selected is white, call continue to try again
            if (Chess.position[Chess.player.possibleStartX][Chess.player.possibleStartY].isWhite) {
                continue;
            }
            // If the movement desired is to the same tile, call continue to try again.
            if (Chess.player.possibleStartX == Chess.player.possibleEndX && Chess.player.possibleStartY == Chess.player.possibleEndY) {
                continue;
            }
            // If the movement desired is not allowed for that specific pieceType, call continue to try again.
            if (!Chess.position[Chess.player.possibleStartX][Chess.player.possibleStartY].canMove(Chess.player.possibleStartX, Chess.player.possibleStartY, Chess.player.possibleEndX, Chess.player.possibleEndY)) {
                continue;
            }
            // Otherwise if the space piece is moving to is available: do the movement, call repaint, and break from the while loop.
            if (Chess.position[Chess.player.possibleEndX][Chess.player.possibleEndY] == null) {
                // Store all coordinates and add one to numberOfMoves++
                Chess.player.playerNumberOfMoves++;
                startX = Chess.player.possibleStartX;
                startY = Chess.player.possibleStartY;
                endX = Chess.player.possibleEndX;
                endY = Chess.player.possibleEndY;

                // Reassign that pieces starting tile to the one we released the mouse over.
                Chess.position[endX][endY] = Chess.position[startX][startY];
                // Make the starting position empty.
                Chess.position[startX][startY] = null;
                Chess.board.repaint();
                break;
            }
        }
    }
    // Don't need these, just need to define them as an implementation action requirement.
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
}