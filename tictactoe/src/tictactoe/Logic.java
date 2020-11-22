package tictactoe;

public class Logic {
    private static final int MINIMUM_SIZE = 3;
    private static final int MAXIMUM_SIZE = 5;
    private static final char EMPTY_SQUARE = ' ';
    private static final char PLAYER_ONE = 'X';
    private static final char PLAYER_TWO = 'O';
    private int size, turn;
    private char[][] board;
    private char currentPlayer;
    
    public Logic() {
        this(MINIMUM_SIZE);
    }
    
    public Logic(int size) {
        if (!resetBoard(size)) {
            resetBoard(MINIMUM_SIZE);
        }
    }
    
    public boolean resetBoard(int size) {
        boolean value = false;
        
        if (MINIMUM_SIZE <= size && size <= MAXIMUM_SIZE) {
            value = true;
            this.size = size;
            board = new char[size][size];
            
            clearBoard();
        }
        
        return value;
    }
    
    private void clearBoard() {
        int i, j;
        
        for (i = 0; i < size; i++) {
            for (j = 0; j < size; j++) {
                board[i][j] = ' ';
            }
        }
        
        currentPlayer = PLAYER_ONE;
        turn = 0;
    }
    
    public void displayBoard() {
        int i, j;
        
        for (i = 0; i < size * 2 - 1; i++) {
            System.out.print(" ");
        }
        
        System.out.println("Board");
        
        for (i = 0; i < size * 2 + 1; i++) {
            if (i % 2 == 0) {
                System.out.print(" ");
                
                for (j = 0; j < size; j++) {
                    System.out.print(" ───");
                }
                
                System.out.println();
            } else {
                for (j = 0; j < size * 2 + 1; j++) {
                    if (j % 2 == 0) {
                        System.out.print(" │ ");
                    } else {
                        System.out.print(board[i / 2][j / 2]);
                    }
                }
                
                System.out.println();
            }
        }
    }
    
    public boolean markSquare(int row, int col) {
        boolean value = false;
        
        if (isSquareValid(row, col) && isSquareEmpty(row, col)) {
            value = true;
            board[row][col] = currentPlayer;
        }
        
        return value;
    }
    
    private boolean isSquareValid(int row, int col) {
        boolean value = false;
        
        if (0 <= row && row < size && 0 <= col && col < size) {
            value = true;
        }
        
        return value;
    }
    
    private boolean isSquareEmpty(int row, int col) {
        boolean value = false;
        
        if (board[row][col] == EMPTY_SQUARE) {
            value = true;
        }
        
        return value;
    }
    
    public boolean existsWinner() {
        boolean value = false;
        
        // row
        // column
        // diagonal
        
        return value;
    }
    
    public boolean isBoardFull() {
        boolean value = false;
        
        if (size * size <= turn) {
            value = true;
        }
        
        return value;
    }
    
    public void switchPlayer() {
        if (currentPlayer == PLAYER_ONE) {
            currentPlayer = PLAYER_TWO;
        } else {
            currentPlayer = PLAYER_ONE;
        }
        
        turn++;
    }
}
