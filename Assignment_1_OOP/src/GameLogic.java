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
    public GameLogic(){
        board = new ConcretePiece[11][11]; // Initializing the board
        pieces = new ConcretePiece[37]; // Initializing the pieces
        player1 = new ConcretePlayer(true); // Initializing the players
        player2 = new ConcretePlayer(false);

        isPlayer2Turn = true; // Initializing the turn to player 2
        player1Pieces();
        player2Pieces();

    }

    public void player1Pieces(){
        // Creating the pieces of player 1 starting with the king
        King king = new King(player1,"♔",7);
        pieces[6] = king;
        for (int i = 0; i < 13; i++) {
            if (i == 6){
                continue;
            }
            pieces[i] = new Pawn(player1,"♙",i + 1);
        }

        // Putting the pieces on the board.
        // The board is going first on 'y' and then on 'x' board[y][x], like in math graph, and not as usual
        // But adding the position is like the Cartesian axis system (x,y)
        // The Pawn are sorted in a cross shape, the king is in the middle and the pawns are around him

        // Row 3
        board[3][5] = pieces[0];
        pieces[0].addMove(new Position(5,3)); // For printing we're including also the first move

        // Row 4
        board[4][4] = pieces[1];
        pieces[1].addMove(new Position(4,4));

        board[4][5] = pieces[2];
        pieces[2].addMove(new Position(5,4));

        board[4][6] = pieces[3];
        pieces[3].addMove(new Position(6,4));

        // Row 5
        board[5][3] = pieces[4];
        pieces[4].addMove(new Position(3,5));

        board[5][4] = pieces[5];
        pieces[5].addMove(new Position(4,5));

        // The king
        board[5][5] = pieces[6];
        pieces[6].addMove(new Position(5,5));

        board[5][6] = pieces[7];
        pieces[7].addMove(new Position(6,5));

        board[5][7] = pieces[8];
        pieces[8].addMove(new Position(7,5));

        // Row 6
        board[6][4] = pieces[9];
        pieces[9].addMove(new Position(4,6));

        board[6][5] = pieces[10];
        pieces[10].addMove(new Position(5,6));

        board[6][6] = pieces[11];
        pieces[11].addMove(new Position(6,6));

        // Row 7
        board[7][5] = pieces[12];
        pieces[12].addMove(new Position(5,7));

    }

    public void player2Pieces(){
        // Creating the pieces of player 2, he has only pawns
        for (int i = 13; i < 37; i++) {
            pieces[i] = new Pawn(player2,"♟",i - 12);
        }

        // Putting the pieces on the board.
        // Player's 2 pawns are sorted on the 4 sides ofr the board

        // Row 0
        board[0][3] = pieces[13];
        pieces[13].addMove(new Position(3,0));

        board[0][4] = pieces[14];
        pieces[14].addMove(new Position(4,0));

        board[0][5] = pieces[15];
        pieces[15].addMove(new Position(5,0));

        board[0][6] = pieces[16];
        pieces[16].addMove(new Position(6,0));

        board[0][7] = pieces[17];
        pieces[17].addMove(new Position(7,0));

        // Row 1
        board[1][5] = pieces[18];
        pieces[18].addMove(new Position(5,1));

        // Row 3
        board[3][0] = pieces[19];
        pieces[19].addMove(new Position(0,3));

        board[3][10] = pieces[20];
        pieces[20].addMove(new Position(10,3));

        // Row 4
        board[4][0] = pieces[21];
        pieces[21].addMove(new Position(0,4));

        board[4][10] = pieces[22];
        pieces[22].addMove(new Position(10,4));

        // Row 5
        board[5][0] = pieces[23];
        pieces[23].addMove(new Position(0,5));

        board[5][1] = pieces[24];
        pieces[24].addMove(new Position(1,5));

        board[5][9] = pieces[25];
        pieces[25].addMove(new Position(9,5));

        board[5][10] = pieces[26];
        pieces[26].addMove(new Position(10,5));

        // Row 6
        board[6][0] = pieces[27];
        pieces[27].addMove(new Position(0,6));

        board[6][10] = pieces[28];
        pieces[28].addMove(new Position(10,6));

        // Row 7
        board[7][0] = pieces[29];
        pieces[29].addMove(new Position(0,7));

        board[7][10] = pieces[30];
        pieces[30].addMove(new Position(10,7));

        // Row 9
        board[9][5] = pieces[31];
        pieces[31].addMove(new Position(5,9));

        // Row 10
        board[10][3] = pieces[32];
        pieces[32].addMove(new Position(3,10));

        board[10][4] = pieces[33];
        pieces[33].addMove(new Position(4,10));

        board[10][5] = pieces[34];
        pieces[34].addMove(new Position(5,10));

        board[10][6] = pieces[35];
        pieces[35].addMove(new Position(6,10));

        board[10][7] = pieces[36];
        pieces[36].addMove(new Position(7,10));

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