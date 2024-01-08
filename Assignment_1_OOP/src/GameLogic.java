public class GameLogic implements PlayableLogic {
    /**
     * This class represents the game logic of the game. and implements the PlayableLogic interface.
     * here we'll have the running game methods.
     */

    private final ConcretePiece[][] board; // The board of the game 2D array of ConcretePiece
    private final ConcretePiece[] pieces; // The pieces of the game from 0-12 players 1 and 13-36 players 2


    private final ConcretePlayer player1;
    private final ConcretePlayer player2;

    private boolean isPlayer2Turn; // To know which player turn is it

    private Position king1Position; // The position of the king of player 1


    // Constructor
    public GameLogic() {
        board = new ConcretePiece[11][11]; // Initializing the board
        pieces = new ConcretePiece[37]; // Initializing the pieces
        player1 = new ConcretePlayer(true); // Initializing the players
        player2 = new ConcretePlayer(false);

        isPlayer2Turn = true; // Initializing the turn to player 2
        player1Pieces();
        player2Pieces();

    }

    public void player1Pieces() {
        // Creating the pieces of player 1 starting with the king
        King king = new King(player1, "♔", 7);
        pieces[6] = king;
        for (int i = 0; i < 13; i++) {
            if (i == 6) {
                continue;
            }
            pieces[i] = new Pawn(player1, "♙", i + 1);
        }

        // Putting the pieces on the board.
        // The board is going first on 'y' and then on 'x' board[y][x], like in math graph, and not as usual
        // But adding the position is like the Cartesian axis system (x,y)
        // The Pawn are sorted in a cross shape, the king is in the middle and the pawns are around him

        // Row 3
        board[3][5] = pieces[0];
        pieces[0].addMove(new Position(5, 3)); // For printing we're including also the first move

        // Row 4
        board[4][4] = pieces[1];
        pieces[1].addMove(new Position(4, 4));

        board[4][5] = pieces[2];
        pieces[2].addMove(new Position(5, 4));

        board[4][6] = pieces[3];
        pieces[3].addMove(new Position(6, 4));

        // Row 5
        board[5][3] = pieces[4];
        pieces[4].addMove(new Position(3, 5));

        board[5][4] = pieces[5];
        pieces[5].addMove(new Position(4, 5));

        // The king
        board[5][5] = pieces[6];
        pieces[6].addMove(new Position(5, 5));

        board[5][6] = pieces[7];
        pieces[7].addMove(new Position(6, 5));

        board[5][7] = pieces[8];
        pieces[8].addMove(new Position(7, 5));

        // Row 6
        board[6][4] = pieces[9];
        pieces[9].addMove(new Position(4, 6));

        board[6][5] = pieces[10];
        pieces[10].addMove(new Position(5, 6));

        board[6][6] = pieces[11];
        pieces[11].addMove(new Position(6, 6));

        // Row 7
        board[7][5] = pieces[12];
        pieces[12].addMove(new Position(5, 7));

    }

    public void player2Pieces() {
        // Creating the pieces of player 2, he has only pawns
        for (int i = 13; i < 37; i++) {
            pieces[i] = new Pawn(player2, "♟", i - 12);
        }

        // Putting the pieces on the board.
        // Player's 2 pawns are sorted on the 4 sides ofr the board

        // Row 0
        board[0][3] = pieces[13];
        pieces[13].addMove(new Position(3, 0));

        board[0][4] = pieces[14];
        pieces[14].addMove(new Position(4, 0));

        board[0][5] = pieces[15];
        pieces[15].addMove(new Position(5, 0));

        board[0][6] = pieces[16];
        pieces[16].addMove(new Position(6, 0));

        board[0][7] = pieces[17];
        pieces[17].addMove(new Position(7, 0));

        // Row 1
        board[1][5] = pieces[18];
        pieces[18].addMove(new Position(5, 1));

        // Row 3
        board[3][0] = pieces[19];
        pieces[19].addMove(new Position(0, 3));

        board[3][10] = pieces[20];
        pieces[20].addMove(new Position(10, 3));

        // Row 4
        board[4][0] = pieces[21];
        pieces[21].addMove(new Position(0, 4));

        board[4][10] = pieces[22];
        pieces[22].addMove(new Position(10, 4));

        // Row 5
        board[5][0] = pieces[23];
        pieces[23].addMove(new Position(0, 5));

        board[5][1] = pieces[24];
        pieces[24].addMove(new Position(1, 5));

        board[5][9] = pieces[25];
        pieces[25].addMove(new Position(9, 5));

        board[5][10] = pieces[26];
        pieces[26].addMove(new Position(10, 5));

        // Row 6
        board[6][0] = pieces[27];
        pieces[27].addMove(new Position(0, 6));

        board[6][10] = pieces[28];
        pieces[28].addMove(new Position(10, 6));

        // Row 7
        board[7][0] = pieces[29];
        pieces[29].addMove(new Position(0, 7));

        board[7][10] = pieces[30];
        pieces[30].addMove(new Position(10, 7));

        // Row 9
        board[9][5] = pieces[31];
        pieces[31].addMove(new Position(5, 9));

        // Row 10
        board[10][3] = pieces[32];
        pieces[32].addMove(new Position(3, 10));

        board[10][4] = pieces[33];
        pieces[33].addMove(new Position(4, 10));

        board[10][5] = pieces[34];
        pieces[34].addMove(new Position(5, 10));

        board[10][6] = pieces[35];
        pieces[35].addMove(new Position(6, 10));

        board[10][7] = pieces[36];
        pieces[36].addMove(new Position(7, 10));

    }


    @Override
    public boolean move(Position a, Position b) {

        // First we will check which in this position
        ConcretePiece currPiece = board[a.getY()][a.getX()]; // Getting the current piece in that position

        Player currPlayer = currPiece.getOwner();
//        Player currPlayer = isPlayer2Turn ? player2 : player1; // Getting the current player

        // checking first the position correction
        if (currPiece == null) { // if it is an empty position
            return false;
        }

//        if (currPiece.getOwner() != currPlayer) { // If the piece isn't belong to the player
//            return false;
//        }

        if (a.equals(b)) {
            return false; // This is the same place
        }

        if (!(a.getX() == b.getX() || a.getY() == b.getY())) { // Checking if he tries to move diagonal
//        if (!(a.getX() != b.getX() || a.getY() != b.getY())) {
            return false;
        }

        // Checking if the position is a corner and the piece isn't a king
        if ((b.getX() == 0 && b.getY() == 0) || (b.getX() == 0 && b.getY() == 10) || (b.getX() == 10 && b.getY() == 0) || (b.getX() == 10 && b.getY() == 10) && !(currPiece instanceof King)) {
            return false;
        }

        // Now checking if there is a piece on the way to position b, if there is we cant move there
        if (a.getX() == b.getX()) { // We are moving on 'Y' axis
            for (int i = a.getY() + 1; i <= b.getY(); i++) { // Checking right to left
                if (board[i][a.getX()] != null) {
                    return false;
                }
            }

            for (int i = a.getY() - 1; i >= b.getY(); i--) { // Checking left to right
                if (board[i][a.getX()] != null) {
                    return false;
                }
            }
        } else if (a.getY() == b.getY()) { // We are moving on 'X' axis
            for (int i = a.getX() + 1; i <= b.getX(); i++) { // Checking up to down
                if (board[a.getY()][i] != null) {
                    return false;
                }
            }
            for (int i = a.getX() - 1; i >= b.getX(); i--) { // Checking down to up
                if (board[a.getY()][i] != null) {
                    return false;
                }
            }
        }

        // Updating the board because if we've got here means we succeeded to move
        board[a.getY()][a.getX()] = null;
        board[b.getY()][b.getX()] = currPiece;

        // Adding here a List or HashMap for collecting data for printing

        // Now we need to check if it is a pawn or a king
        // if(p instanceof King){ // If it is a king
        if (King.class.isInstance(currPiece)) {
            king1Position = b; // Updating the position of the king
        }

        //eatCheck(b);

        isPlayer2Turn = !isPlayer2Turn; // Changing the turn
        return true;
    }


    private void eatCheck(Position position) { // Check if can it

    }

    /**
     * To check if the game is finished we have few options:
     * 1. the king got to one of the corners, and then player 1 wins
     * 2. the king is surrounded by player's 2 pawns, and then player 2 wins:
     *   2.1. The king is surrounded by player's 2 pawns from 3 directions, and one of the edges of the board
     *   2.2. The king is surrounded by player's 2 pawns from 4 directions
     * NOTE!!! is the king is next to the one of the corners and surrounded by 2 pawns, it's not count as a win!!!!
     * the edges and the corners are helping only for eating, and here the king can run to the corner.
     * @return
     */
    public boolean isFinished() {
        // Checking if the king got to one of the corners
        //  if (board[0][0] instanceof King || board[0][10] instanceof King || board[10][0] instanceof King || board[10][10] instanceof King) {
        if (king1Position == new Position(0, 0) || king1Position == new Position(0, 10) || king1Position == new Position(10, 0) || king1Position == new Position(10, 10)) {
            player1.addWin();
            // Printing the data
            return true;
        }

        // Checking 3 directions
        // If the king on the first column
        else if ((king1Position.getX() == 0) && checkEenemy(king1Position, 0, -1) && checkEenemy(king1Position, 1, 0) && checkEenemy(king1Position, 0, 1)) {
            player2.addWin();
            // Printing the data
            return true;
        }

        // If the king on the first row
        else if ((king1Position.getY() == 0) && checkEenemy(king1Position, 1, 0) && checkEenemy(king1Position, 0, 1) && checkEenemy(king1Position, -1, 0)) {
            player2.addWin();
            // Printing the data
            return true;
        }

        // If the king on the last column
        else if (king1Position.getX() == 10 && checkEenemy(king1Position, 0, -1) && checkEenemy(king1Position, -1, 0) && checkEenemy(king1Position, 0, 1)) {
            player2.addWin();
            // Printing the data
            return true;
        }

        // If the king on the last row
        else if (king1Position.getY() == 10 && checkEenemy(king1Position, 1, 0) && checkEenemy(king1Position, 0, -1) && checkEenemy(king1Position, -1, 0)) {
            player2.addWin();
            // Printing the data
            return true;
        }

        // Checking if the king is surrounded by player's 2 pawns
        // 4 directions and need to check if not null
        // else if (board[king1Position.getY() + 1][king1Position.getX()].getOwner() == player2 && board[king1Position.getY() - 1][king1Position.getX()].getOwner() == player2 && board[king1Position.getY()][king1Position.getX() + 1].getOwner() == player2 && board[king1Position.getY()][king1Position.getX() - 1].getOwner() == player2) {
        else if (checkEenemy(king1Position, 1, 0) && checkEenemy(king1Position, -1, 0) && checkEenemy(king1Position, 0, 1) && checkEenemy(king1Position, 0, -1)) {
            player2.addWin();
            // Printing the data
            return true;
        }

        // The ame hasn't finished yet
        return false;
    }

    /**
     * This method checks if there is an enemy piece around the given position from 4 directions
     * King cant eat, so we are checking only pawns, and in 'eatCheck' function
     */
    private boolean checkEenemy(Position a, int x, int y) {
        // Checking boundaries
        if (a.getX() + x < 0 || a.getX() + x > 10 || a.getY() + y < 0 || a.getY() + y > 10) {
            return false;
        }
        boolean isEnemy = false;
        // Checking if the owner are different and if the piece is a pawn
        // Checking if it's a pawn also helping us overcome a NullPointerException, that why we're checking it first
        isEnemy = (board[a.getY() + y][a.getX() + x] instanceof Pawn) && (board[a.getY() + y][a.getX() + x].getOwner() != board[a.getY()][a.getX()].getOwner());
        return isEnemy;
    }

    @Override
    public Piece getPieceAtPosition(Position position) {
        return board[position.getY()][position.getX()];
    }

    @Override
    public Player getFirstPlayer() {
        return this.player1;
    }

    @Override
    public Player getSecondPlayer() {
        return this.player2;
    }

    @Override
    public boolean isGameFinished() {
        return false;
    }

    @Override
    public boolean isSecondPlayerTurn() {
        return isPlayer2Turn;
    }

    @Override
    public void reset() {

    }

    @Override
    public void undoLastMove() {

    }

    @Override
    public int getBoardSize() {
        return 11;
    }
}
