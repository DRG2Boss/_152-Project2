// Main class for Chess game
// Hold the storage for the program
// Set up storage and graphics

import javax.swing.*;

public class Chess {
    // Dimensions of full board and each tile.
    public static final int BOARD_SIZE = 352, TILE_SIZE = BOARD_SIZE / 8;
    // Define board variable here.
    public static boardComponent board;
    // Create array for every position on board, and define container size.
    public static Piece[][] position = new Piece[8][8];
    public static void main(String[] args) {
        // Draw pieces in appropriate starting positions.
        // Black Rooks
        position[0][0] = new Rook(false);
        position[7][0] = new Rook(false);
        // White Rooks
        position[0][7] = new Rook(true);
        position[7][7] = new Rook(true);
        // Black Knights
        position[1][0] = new Knight(false);
        position[6][0] = new Knight(false);
        // White Knights
        position[1][7] = new Knight(true);
        position[6][7] = new Knight(true);
        // Black Bishops
        position[2][0] = new Bishop(false);
        position[5][0] = new Bishop(false);
        // White Bishops
        position[2][7] = new Bishop(true);
        position[5][7] = new Bishop(true);
        // Black Queen
        position[3][0] = new Queen(false);
        // White Queen
        position[3][7] = new Queen(true);
        // Black King
        position[4][0] = new King(false);
        // White King
        position[4][7] = new King(true);
        // Pawns
        for(int x = 0; x <= 7; x++) {
            position[x][1] = new Pawn(false);
            position[x][6] = new Pawn(true);
        }

        // Basic window setup.
        JFrame myWindow = new JFrame("Chess");
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow.setSize(BOARD_SIZE+16, BOARD_SIZE+39);

        // Create a graphical object that will represent the board using earlier defined variable.
        board = new boardComponent();

        // Now add board object to the window.
        // This will take up the entire window, no Panels needed.
        myWindow.add(board);

        // Make an object that operates on mouse presses and releases.
        boardMouseListener boardMouse = new boardMouseListener();
        board.addMouseListener(boardMouse);

        // Last thing to run, make myWindow visible.
        myWindow.setVisible(true);
    }
}
