package TicTacToe;

enum Mark {BLANK, X, O} // for every option in the board, x o, or blank

public class Board {
    // Constants
    public static final int SIZE = 3; // Board of 3x3
    //    public static final int SIZE = … ;
    public static final int WIN_STREAK = 3;

    static int blank_spots = SIZE * SIZE; // in each time the of putMark, the counter will be reduced. It will indicate us if the game is over and to check who won


    private Mark[][] board = new Mark[SIZE][SIZE];

    // Constructor
    public Board() {
        initBoard(); // making evey cell on the board as a blank mark
    }

    public void initBoard() { // initializing the board with blank, because in the beginning is like an object, null
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.board[i][j] = Mark.BLANK;
            }
        }
    }

    /**
     * This method is putting a Mark in a place that the player decided.
     * It's a boolean method, so we can know if the marking had succeeded (out of bound or the cell is already marked)
     */
    public boolean putMark(Mark mark, int row, int col) {
        if (row < 0 || row > SIZE || col < 0 || col > SIZE) { // index out of bound
            return false;
        }
        if (this.board[row - 1][col - 1] != Mark.BLANK) {
            return false;
        }
        if (isGameEnded()) {
            System.out.println("Check game Status");
        }
        this.board[row - 1][col - 1] = mark; // The input is legal. The -1, is for the suit the coordinates to the player
        blank_spots--;
        if (rowCheck(mark, row) || colCheck(mark, col) || mainDiagonalCheck(mark) || secondaryDiagonalCheck(mark)) {
            System.out.println(mark + ", Won the game!");
            return isGameEnded();
        }
        return true;
    }

    // For ending the game
//    private int countMarkInDirection(int row, int col, int rowDelta, int colDelta, Mark mark) {
//        int count = 0;
//        while(row < SIZE && row >= 0 && col < SIZE && col >= 0 && board[row][col] == mark) {
//            count++;
//            row += rowDelta;
//            col += colDelta;
//        }
//        return count;
//    }

    // returning if the game ended
    public boolean isGameEnded() {
        if (blank_spots == 0) {
            System.out.println("Draw!");
            return true;
        }
        return false;
    }

    // Returning what is the game status, and how won
    // DRAW, X_WIN, O_WIN or IN_PROGRESS.
    public Mark GameStatus() {
//        if(!isGameEnded()){
//            return IN_PROGRESS;
//        }
        Mark m = null;
        return m;
    }

    public Mark getMark(int row, int col) {
        if (row < 0 || row > SIZE || col < 0 || col > SIZE) { // index out of bound
            return Mark.BLANK;
        }
        return this.board[row][col];
//        return Mark.X;
    }

    // another method for the future
    public int getSize() {
        return SIZE;
    }

    // The same idea for both checkups
    // Checking the row and column of the input. Because we've put the mark so One of them is not BLANK
    private boolean rowCheck(Mark mark, int row) {
        boolean ans = false;
        int counter = 0;
        for (int i = 0; i < SIZE; i++) {
//            if (board[row - 1][i] == board[row - 1][i - 1]) {
            if (board[row - 1][i] == mark) {
                counter++;
            }
        }
        if (counter == WIN_STREAK) {
            ans = true;
        }
        return ans;
    }

    private boolean colCheck(Mark mark, int col) {
        boolean ans = false;
        int counter = 0;
        for (int i = 0; i < SIZE; i++) {
//            if (board[i][col - 1] == board[i - 1][col - 1]) {
            if (board[i][col - 1] == mark) {
                counter++;
            }
        }
        if (counter == WIN_STREAK) {
            ans = true;
        }
        return ans;
    }

    // Getting the mark to check if for all the main diagonal
    private boolean mainDiagonalCheck(Mark mark) {
        boolean ans = false;
        int counter = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == j) { // Condition for main diagonal
                    if (board[i][j] == mark) {
//                    if ((board[i][j] == board[i - 1][j - 1]) && (board[i - 1][j - 1] != Mark.BLANK) && (board[i][j] != Mark.BLANK)){
                        counter++;
                    }
                }
            }
        }
        if (counter == WIN_STREAK) {
            ans = true;
        }
        return ans;
    }

    // Checking only if the
    private boolean secondaryDiagonalCheck(Mark mark) {
        boolean ans = false;
        int counter = 0;

        for (int i = 1; i < SIZE; i++) {
            if (board[i][SIZE - 1 - i] == mark) {
                counter++;
            }
        }
        if (counter == WIN_STREAK) {
            ans = true;
        }
        return ans;
    }


//    private boolean secondaryDiagonalCheck() {
//        boolean ans = false;
//        int counter = 0;
//        for (int i = 1; i < SIZE; i++) {
//            for (int j = 1; j < SIZE; j++) {
//
//                // Condition for secondary diagonal
//                if ((i + j) == (SIZE - 1)) {
//                    if (board[i][j] == board[i - 1][j - 1]) {
//                        counter++;
//                    }
//
//                    if (counter == SIZE) {
//                        ans = true;
//                    }
//                }
//            }
//        }
//        return ans;
//    }
}