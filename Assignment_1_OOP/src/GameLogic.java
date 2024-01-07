public class GameLogic implements PlayableLogic {
    /**
     * This class represents the game logic of the game. and implements the PlayableLogic interface.
     * here we'll have the running game methods.
     */

    private final ConcretePiece[][] board; // The board of the game 2D array of ConcretePiece
    private final ConcretePiece[] peices; // The pieces of the game from 0-12 players 1 and 13-36 players 2


    private final ConcretePlayer player1;
    private final ConcretePlayer player2;

    private boolean isPlayer2Turn; // To know which player turn is it

    private Position king1Position; // The position of the king of player 1


    // Constructor
    public GameLogic(){
        board = new ConcretePiece[11][11]; // Initializing the board
        peices = new ConcretePiece[37]; // Initializing the pieces
        player1 = new ConcretePlayer(true); // Initializing the players
        player2 = new ConcretePlayer(false);

        isPlayer2Turn = true; // Initializing the turn to player 2
//        player1Pieces();
//        player2Pieces();

    }

    @Override
    public boolean move(Position a, Position b) {
        return false;
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
