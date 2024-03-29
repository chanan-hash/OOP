import java.util.*;

public class GameLogic implements PlayableLogic {
    /**
     * This class represents the game logic of the game. and implements the PlayableLogic interface.
     * here we'll have the running game methods.
     */
    // Counters if all the pawn of other player are eaten, the other wins
    private static int count1Pieces = 0;
    private static int count2Pieces = 0;

    private static final int BOARD_SIZE = 11; // The size of the board, can be updated if we want. Makes the board modular
    private final Stack<PositionHistory> undoStack; // The stack for undoing the last move
    private final ConcretePiece[][] board; // The board of the game 2D array of ConcretePiece
    private final ConcretePiece[] pieces; // The pieces of the game from 0-12 players 1 and 13-36 players 2

    private final Map<Position, Set<ConcretePiece>> cellHistory;

    private final ConcretePlayer player1;
    private final ConcretePlayer player2;

    private boolean isPlayer2Turn; // To know which player turn is it

    private Position king1Position; // The position of the king of player 1


    // Constructor
    public GameLogic() {
        board = new ConcretePiece[BOARD_SIZE][BOARD_SIZE]; // Initializing the board

        cellHistory = new HashMap<>();

        undoStack = new Stack<>(); // Initializing the undo stack
        pieces = new ConcretePiece[37]; // Initializing the pieces
        player1 = new ConcretePlayer(true); // Initializing the players
        player2 = new ConcretePlayer(false);
        isPlayer2Turn = true; // Initializing the turn to player 2
        king1Position = new Position(5, 5); // Initializing the king's position
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

        Player currPlayer = isPlayer2Turn ? player2 : player1; // Getting the current player

        // checking first the position correction
        if (currPiece == null) { // if it is an empty position
            return false;
        }

        if (currPiece.getOwner() != currPlayer) { // If the piece isn't belong to the player
            return false;
        }

        if (a.equals(b)) {
            return false; // This is the same place
        }

        if (!(a.getX() == b.getX() || a.getY() == b.getY())) { // Checking if he tries to move diagonal
//        if (!(a.getX() != b.getX() || a.getY() != b.getY())) {
            return false;
        }

        // Checking if the position is a corner and the piece isn't a king
        if (((b.getX() == 0 && b.getY() == 0) || (b.getX() == 0 && b.getY() == 10) || (b.getX() == 10 && b.getY() == 0) || (b.getX() == 10 && b.getY() == 10)) && !(currPiece instanceof King)) {
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
        currPiece.addMove(b);

        // Now we need to check if it is a pawn or a king
        if (currPiece instanceof King) { // If it is a king
//        if (King.class.isInstance(currPiece)) {
            king1Position = b; // Updating the position of the king
        }

        eatCheck(b);

        isPlayer2Turn = !isPlayer2Turn; // Changing the turn


        if (isGameFinished()) {
            if (isPlayer2Turn) {
                printGameData(false);
            } else {
                printGameData(true);
            }
        }

        // Update cell history for the "to" position
        updateCellHistory(b, currPiece);


        undoStack.push(new PositionHistory(currPiece, a, b)); // Putting the new move in the stack with the current piece and the positions

        return true;
    }

    private void eatCheck(Position position) { // Check if can it
        // Only pawn can eat
        if (board[position.getY()][position.getX()] instanceof King) {
            return;
        }

        //making the edges of the board as a pawn for eating
        Pawn current = (Pawn) board[position.getY()][position.getX()]; // Getting the current pawn
        Player whichPlayer = board[position.getY()][position.getX()].getOwner(); // Tp update the counters

        board[0][0] = new Pawn(current.getOwner(), current.getType(), 0);
        board[0][10] = new Pawn(current.getOwner(), current.getType(), 0);
        board[10][0] = new Pawn(current.getOwner(), current.getType(), 0);
        board[10][10] = new Pawn(current.getOwner(), current.getType(), 0);


        // Checking if there is an enemy piece from 2 sides, starting from down
        // Reminder - king can't eat
        if (checkEenemy(position, 0, 1) && !king1Position.equals(new Position(position.getY() + 1, position.getY()))) {
            if (position.getY() + 1 == 10) { // On the last row
                current.eat(); // Updating the number of eats for specific pawn

                if (whichPlayer == player1) {
                    count2Pieces++;
                } else {
                    count1Pieces++;
                }
                // Adding to current piece the number of eats in undo stack, so we can restore the eaten pawn
                undoStack.peek().addEaten((Pawn) board[position.getY() + 1][position.getX()]);
                board[position.getY() + 1][position.getX()] = null; // Removing the enemy piece
            } else {
                if (board[position.getY() + 2][position.getX()] instanceof Pawn && board[position.getY() + 2][position.getX()].getOwner() == current.getOwner()) {
                    current.eat(); // Updating the number of eats for specific pawn

                    if (whichPlayer == player1) {
                        count2Pieces++;
                    } else {
                        count1Pieces++;
                    }
                    undoStack.peek().addEaten((Pawn) board[position.getY() + 1][position.getX()]);
                    board[position.getY() + 1][position.getX()] = null; // Removing the enemy piece
                }
            }
        }

        // Checking right place
        if (checkEenemy(position, 1, 0) && !king1Position.equals(new Position(position.getY(), position.getX() + 1))) {
            if (position.getX() + 1 == 10) { // On the last column
                current.eat(); // Updating the number of eats for specific pawn

                if (whichPlayer == player1) {
                    count2Pieces++;
                } else {
                    count1Pieces++;
                }
                undoStack.peek().addEaten((Pawn) board[position.getY()][position.getX() + 1]);
                board[position.getY()][position.getX() + 1] = null; // Removing the enemy piece
            } else {
                if (board[position.getY()][position.getX() + 2] instanceof Pawn && board[position.getY()][position.getX() + 2].getOwner() == current.getOwner()) {
                    current.eat(); // Updating the number of eats for specific pawn

                    if (whichPlayer == player1) {
                        count2Pieces++;
                    } else {
                        count1Pieces++;
                    }
                    undoStack.peek().addEaten((Pawn) board[position.getY()][position.getX() + 1]);
                    board[position.getY()][position.getX() + 1] = null; // Removing the enemy piece
                }
            }
        }

        // Checking left place
        if (checkEenemy(position, 0, -1) && !king1Position.equals(new Position(position.getY() - 1, position.getX()))) {
            if (position.getY() - 1 == 0) { // On the first row
                current.eat(); // Updating the number of eats for specific pawn

                if (whichPlayer == player1) {
                    count2Pieces++;
                } else {
                    count1Pieces++;
                }
                undoStack.peek().addEaten((Pawn) board[position.getY() - 1][position.getX()]);
                board[position.getY() - 1][position.getX()] = null; // Removing the enemy piece
            } else {
                if (board[position.getY() - 2][position.getX()] instanceof Pawn && board[position.getY() - 2][position.getX()].getOwner() == current.getOwner()) {
                    current.eat(); // Updating the number of eats for specific pawn

                    if (whichPlayer == player1) {
                        count2Pieces++;
                    } else {
                        count1Pieces++;
                    }
                    undoStack.peek().addEaten((Pawn) board[position.getY() - 1][position.getX()]);
                    board[position.getY() - 1][position.getX()] = null; // Removing the enemy piece
                }
            }
        }

        // Checking down
        if (checkEenemy(position, -1, 0) && !king1Position.equals(new Position(position.getY(), position.getX() - 1))) {
            if (position.getX() - 1 == 0) { // On the first column
                current.eat(); // Updating the number of eats for specific pawn

                if (whichPlayer == player1) {
                    count2Pieces++;
                } else {
                    count1Pieces++;
                }
                undoStack.peek().addEaten((Pawn) board[position.getY()][position.getX() - 1]);
                board[position.getY()][position.getX() - 1] = null; // Removing the enemy piece
            } else {
                if (board[position.getY()][position.getX() - 2] instanceof Pawn && board[position.getY()][position.getX() - 2].getOwner() == current.getOwner()) {
                    current.eat(); // Updating the number of eats for specific pawn

                    if (whichPlayer == player1) {
                        count2Pieces++;
                    } else {
                        count1Pieces++;
                    }
                    undoStack.peek().addEaten((Pawn) board[position.getY() - 1][position.getX()]);
                    board[position.getY()][position.getX() - 1] = null; // Removing the enemy piece
                }
            }
        }

        // Ending the eating checkup, and returning the edges to null
        board[0][0] = null;
        board[0][10] = null;
        board[10][0] = null;
        board[10][10] = null;
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

    /**
     * To check if the game is finished we have few options:
     * 1. the king got to one of the corners, and then player 1 wins
     * 2. the king is surrounded by player's 2 pawns, and then player 2 wins:
     * 2.1. The king is surrounded by player's 2 pawns from 3 directions, and one of the edges of the board
     * 2.2. The king is surrounded by player's 2 pawns from 4 directions
     * NOTE!!! is the king is next to the one of the corners and surrounded by 2 pawns, it's not count as a win!!!!
     * the edges and the corners are helping only for eating, and here the king can run to the corner.
     *
     * @return
     */

    @Override
    public boolean isGameFinished() {
        // Checking if the king got to one of the corners
        if (board[0][0] instanceof King || board[0][10] instanceof King || board[10][0] instanceof King || board[10][10] instanceof King) {
            player1.addWin();

            // Printing the data, according to that player 1 won
//            printGameData(true);

            return true;
        }

        // Checking 3 directions
        // If the king on the first column
        else if ((king1Position.getX() == 0) && checkEenemy(king1Position, 0, -1) && checkEenemy(king1Position, 1, 0) && checkEenemy(king1Position, 0, 1)) {
            player2.addWin();

            // Printing the data, according to that player 2 won
//            printGameData(false);

            return true;
        }

        // If the king on the first row
        else if ((king1Position.getY() == 0) && checkEenemy(king1Position, 1, 0) && checkEenemy(king1Position, 0, 1) && checkEenemy(king1Position, -1, 0)) {
            player2.addWin();

            // Printing the data, according to that player 2 won
//            printGameData(false);

            return true;
        }

        // If the king on the last column
        else if (king1Position.getX() == 10 && checkEenemy(king1Position, 0, -1) && checkEenemy(king1Position, -1, 0) && checkEenemy(king1Position, 0, 1)) {
            player2.addWin();

            // Printing the data, according to that player 2 won
//            printGameData(false);

            return true;
        }

        // If the king on the last row
        else if (king1Position.getY() == 10 && checkEenemy(king1Position, 1, 0) && checkEenemy(king1Position, 0, -1) && checkEenemy(king1Position, -1, 0)) {
            player2.addWin();

            // Printing the data, according to that player 2 won
//            printGameData(false);

            return true;
        }

        // Checking if the king is surrounded by player's 2 pawns
        // 4 directions and need to check if not null
        // else if (board[king1Position.getY() + 1][king1Position.getX()].getOwner() == player2 && board[king1Position.getY() - 1][king1Position.getX()].getOwner() == player2 && board[king1Position.getY()][king1Position.getX() + 1].getOwner() == player2 && board[king1Position.getY()][king1Position.getX() - 1].getOwner() == player2) {
        else if (checkEenemy(king1Position, 1, 0) && checkEenemy(king1Position, -1, 0) && checkEenemy(king1Position, 0, 1) && checkEenemy(king1Position, 0, -1)) {
            player2.addWin();

            // Printing the data, according to that player 2 won
//            printGameData(false);

            return true;
        }

        // Player 1 ate all player'2 2 pieces
        else if (count2Pieces == 24) {
            player1.addWin();
//            printGameData(true);
            return true;

        }

        // TODO check that rule
        // Player 2 ate all player'1 2 pieces instead of the king only the king is left
        else if (count1Pieces == 12) {
            player2.addWin();
//            printGameData(false);
            return true;
        }

        // The ame hasn't finished yet
        return false;
    }

    @Override
    public boolean isSecondPlayerTurn() {
        return isPlayer2Turn;
    }

    @Override
    public void reset() {
        isPlayer2Turn = true; // player 2 is always starting
        king1Position.set_x(5); // setting king's position to start
        king1Position.set_y(5);

        // resting the board to null as in beginning
        // going on every row and turning it to null
        for (Piece[] r : board) {
            Arrays.fill(r, null);
        }

        // putting the pieces on the board from beginning
        player1Pieces();
        player2Pieces();

        cellHistory.clear(); // Clear the cell history on reset
        undoStack.clear(); // Clear the undo stack on reset
    }

    @Override
    public void undoLastMove() {
        if (undoStack.isEmpty()) {
            return;
        }

        // The stack is not empty, so we can undo the last move
        PositionHistory lastMove = undoStack.pop(); // Getting the last move
        ConcretePiece piece = lastMove.getPie(); // Getting the piece

        // We've kept the position to know where to take the piece back
        board[lastMove.getFromWhere().getY()][lastMove.getFromWhere().getX()] = piece; // Taking him back
        board[lastMove.getToWhere().getY()][lastMove.getToWhere().getX()] = null;   // Removing him from the last position

        // We need to update the distance of the piece
        piece.removeMove(piece.getMoves().get(piece.getMoves().size() - 1)); // Removing the last move from the list and decreasing the distance

        // Update the num of eats for that pawn if he ate, we need to decrease
        piece.setNumberOfEats(piece.getNumberOfEats() - lastMove.getEaten().size());

        //Now we need to return the eaten pawns
        for (Pawn eaten : lastMove.getEaten()) {
            if (eaten.getOwner() == player2) {
                count2Pieces--; // The counter for how many pieces remain
            }
            Position eatenLastPosition = eaten.getMoves().get(eaten.getMoves().size() - 1); // Getting the last position for
            board[eatenLastPosition.getY()][eatenLastPosition.getX()] = eaten;
        }

        // TODO may need to be changed
        // Need to update the cell history
        Set<ConcretePiece> stepTracker = cellHistory.get(lastMove.getToWhere());
        if (stepTracker.size() == 1) {
            stepTracker.remove(piece);
            if (stepTracker.isEmpty()) { // Nothing there
                cellHistory.remove(lastMove.getToWhere());
            }
        } else {
            stepTracker.add(piece);
            cellHistory.put(lastMove.getToWhere(), stepTracker);
        }


        if (piece instanceof King) {
            king1Position = lastMove.getFromWhere();
        }

        // Switch the turn back
        isPlayer2Turn = !isPlayer2Turn;
    }


    @Override
    public int getBoardSize() {
        return BOARD_SIZE;
    }

    private void updateCellHistory(Position position, ConcretePiece piece) {
        if (!cellHistory.containsKey(position)) {
            cellHistory.put(position, new HashSet<>());
        }

        Set<ConcretePiece> piecesOnCell = cellHistory.get(position);
        piecesOnCell.add(piece);
    }

    //************** Data Printing ******************\\

    /**
     * In isGameFinished function, we are calling after each kind of win to print the data, and passing who won.
     * We need to know it because we have all kind of comparisons and sorting between the players.
     *
     * @param isPlayer1Won
     */
    private void printGameData(boolean isPlayer1Won) {
        printPiecesData(isPlayer1Won);
        printDivider();

        printEatsData(isPlayer1Won);
        printDivider();

        printDistanceData(isPlayer1Won);
        printDivider();

        printPositionHistoryData(isPlayer1Won);
        printDivider();
    }


    private void printPiecesData(boolean isPlayer1Won) {
        // copying the pieces array to a new array, so we can work on each player separately
        ConcretePiece[] p1Pieces = Arrays.copyOfRange(pieces, 0, 13);
        ConcretePiece[] p2Pieces = Arrays.copyOfRange(pieces, 13, 37);

        //Creating the comparator here locally. Define what he gets and what he return for each case
        // This is a lambda concept
        Comparator<ConcretePiece> comparatorPieces = (o1, o2) -> {
            if (o1.getMoves().size() > o2.getMoves().size()) {
                return 1;
            } else if (o1.getMoves().size() < o2.getMoves().size()) {
                return -1;
            } else if (o1.getMoves().size() == o2.getMoves().size()) {
                return 0;
            }
            return o1.getPieceNum() - o2.getPieceNum();
//            if (o1.getMoves().size() != o2.getMoves().size()) {
//                return o1.getMoves().size() - o2.getMoves().size();
//            }
//            // the number of moves is the same, so sort by the number of the pieces
//            return o1.getPieceNum() - o2.getPieceNum();
        };

        // Sorting each player's pieces by according to the comparator
        Arrays.sort(p1Pieces, comparatorPieces);
        Arrays.sort(p2Pieces, comparatorPieces);

        // Now printing them
        ConcretePiece[] winner, loser;
        if (isPlayer1Won) {
            // We don't need to copy the array, just to point them
            winner = p1Pieces;
            loser = p2Pieces;
        } else {
            winner = p2Pieces;
            loser = p1Pieces;
        }

        // The printing itself, starting with the winner
        for (ConcretePiece win : winner) {
            // Printing only if the piece has moved
            if (win.getMoves() != null && win.getMoves().size() > 1) { // each piece has his first move, but it's not enough
                System.out.println(win.getName() + ": " + win.getMoves());
            }
        }

        // Printing the loser pieces
        for (ConcretePiece lose : loser) {
            // Printing only if the piece has moved
            if (lose.getMoves() != null && lose.getMoves().size() > 1) { // each piece has his first move, but it's not enough
                System.out.println(lose.getName() + ": " + lose.getMoves());
            }
        }
    }

    private void printEatsData(boolean isPlayer1Won) {
        // We want only the pieces that ate, so we need to check if the size of the moves is bigger than 2
        //         ConcretePiece[] filtered = Arrays.stream(gamePieces).filter(piece -> piece.getNumberOfEats() > 0).toArray(ConcretePiece[]::new);
        List<ConcretePiece> didEat = new ArrayList<>();

        for (ConcretePiece piece : pieces) {
            if (piece.getNumberOfEats() > 0) {
                didEat.add(piece);
            }
        }
        //ConcretePiece[] onlyEat = didEat.toArray(new ConcretePiece[0]);

        // Now sorting according to the format, writing the comparator
        Comparator<ConcretePiece> eatCompare = (o1, o2) -> {
            // The kill order is descending
            if (o1.getNumberOfEats() > o2.getNumberOfEats()) {
                return -1;
            } else if (o1.getNumberOfEats() < o2.getNumberOfEats()) {
                return 1;
            } else if (o1.getNumberOfEats() == o2.getNumberOfEats()) {
                return 0;
            }
            // The number of pieces is ascending
            else if (o1.getPieceNum() != o2.getPieceNum()) {
                return o1.getPieceNum() - o2.getPieceNum();
                // And this if functioning in the comparator: positive o1 > 02, Zero o1 = o2, negative o1 < o2
            }

            // How won for the to know which print first
            if (isPlayer1Won) {
                return o1.getOwner().isPlayerOne() ? -1 : 1;
            } else {// the second player won
                return o1.getOwner().isPlayerOne() ? 1 : -1;
            }
        };

        // Arrays.sort(onlyEat, eatCompare);
        // print the sorted pieces
        didEat.sort(eatCompare);
        for (ConcretePiece eat : didEat) {
            System.out.println(eat.getName() + ": " + eat.getNumberOfEats() + " kills");
        }
    }

    private void printDistanceData(boolean isPlayer1Won) {
        // Filtering the pieces that haven't moved
        // The same way as before
        List<ConcretePiece> didMove = new ArrayList<>();

        for (ConcretePiece piece : pieces) {
            if (piece.getMoves().size() > 1) {  // We aren't counting the first move
                didMove.add(piece);
            }
        }

        ConcretePiece[] onlyMove = didMove.toArray(new ConcretePiece[0]);
        // Define the comparator here
        Comparator<ConcretePiece> moveCompare = (o1, o2) -> {
            // We need the squares in descending order
            if (o1.getDistance() != o2.getDistance()) {
                return o2.getDistance() - o1.getDistance(); // And this if functioning in the comparator: positive o2 > 01, Zero o2 = o1, negative o2 < o1
            } else if (o1.getPieceNum() != o2.getPieceNum()) {
                return o1.getPieceNum() - o2.getPieceNum();
            }

            if (isPlayer1Won) {
                return o1.getOwner().isPlayerOne() ? -1 : 1;
            } else {
                return o1.getOwner().isPlayerOne() ? 1 : -1;
            }
        };

        Arrays.sort(onlyMove, moveCompare);
        for (ConcretePiece hasMoved : onlyMove) {
            System.out.println(hasMoved.getName() + ": " + hasMoved.getDistance() + " squares");
        }
    }

    private void printPositionHistoryData(boolean isPlayer1Won) {
        List<Position> positionsInfo = new ArrayList<>();
        for (Map.Entry<Position, Set<ConcretePiece>> entry : cellHistory.entrySet()) {
            if (entry.getValue().size() > 1) {
                positionsInfo.add(entry.getKey());
            }
        }

        Comparator<Position> positionCompare = (pos1, pos2) -> {
            // Sorting according to number of pieces that stepped over
            if ((cellHistory.get(pos1).size() != cellHistory.get(pos2).size())) {
                return cellHistory.get(pos2).size() - cellHistory.get(pos1).size();
            }
            // Sorting according to X axis
            if (pos1.getX() != pos2.getX()) {
                return pos1.getX() - pos2.getX();
            }
            // Sorting according Y axis
            else {
                return pos1.getY() - pos2.getY();
            }
        };

        positionsInfo.sort(positionCompare);
        for (Position position : positionsInfo) {
            System.out.println(position.toString() + cellHistory.get(position).size() + " pieces");
        }
    }

    private void printDivider() {
        System.out.println("***************************************************************************");
    }
}
