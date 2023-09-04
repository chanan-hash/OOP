package TicTacToe;

public class Game {
    // Variables
    private Player playerX;
    private Player playerO;
    private Renderer renderer;

    // Constructor for Game
    public Game(Player playerX, Player playerO, Renderer renderer) {
        // Creating the new objects will be before the game itself, and we'll pass only the pointers
        this.playerX = playerX;
        this.playerO = playerO;
        this.renderer = renderer;
    }

    public Mark run() {
        Board board = new Board();
        Player[] players = {playerX, playerO};
        Mark[] marks = {Mark.X, Mark.O};
        int counter = 0;
        System.out.println("First player enter your Move, row and then column: ");
        renderer.renderBoard(board);
        while (!board.isGameEnded()) {
            if (counter % 2 == 0) {
                System.out.println("Player " + Mark.X + ", enter your Move, row and then column: ");
                playerX.playTurn(board, Mark.X); // Asking an input from the user for One of the player, we can take a String format and Spilt it

                renderer.renderBoard(board);
            } else {
                System.out.println("Player, " + Mark.O + " enter your Move, row and then column: ");
                playerO.playTurn(board, Mark.O);
                renderer.renderBoard(board); // printing the board
            }
            counter++;

        }

        renderer.renderBoard(board);
        return board.GameStatus();
    }

    public static void main(String[] args) {
        Board board = new Board(); // creating new Board
        Renderer renderer = new Renderer(); // Creating the option to print it
        Player playerX = new Player();
        Player playerO = new Player();
        Game game = new Game(playerX, playerO, renderer);
        game.run();
//        Player play1 = new Player();
//        board.putMark(Mark.O, 2,1);
//        board.putMark(Mark.X, 3,3);
//        board.putMark(Mark.X, 2,1); // not supposed to be able to put the mark
//        board.putMark(Mark.O,1,1);
//        board.putMark(Mark.X,3,1);
//        board.putMark(Mark.O,3,2);
//        board.putMark(Mark.X,2,2);
//        board.putMark(Mark.O,1,2);
//        board.putMark(Mark.X,1,3);
//        board.putMark(Mark.O,2,3);
//        System.out.println(Board.blank_spots);

//        renderer.renderBoard(board); // printing the board
//        System.out.println(board.getMark(2,1));


//        while (!board.isGameEnded()){
//            System.out.println("Please enter your Move, row and then column: ");
//            // Asking an input from the user for One of the player, we can take a String format and Spilt it
//            play1.playTurn(board,Mark.X);
//            renderer.renderBoard(board); // printing the board
//
//        }
//        board.GameStatus(); // returning/ printing the what is the Status of the game
    }
}
