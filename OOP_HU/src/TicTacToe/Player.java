package TicTacToe;

import java.util.Scanner;

public class Player {


    //Constructor
    public Player() {
    } // Empty constructor

    private Scanner scanner = new Scanner(System.in);

    public void playTurn(Board board, Mark mark) {
//        try {
//        int num = scanner.nextInt();
//        int i = num/10; // Tens digit
//        int j = (num % 10) - 1; // Ones digit
//        int n = Integer.parseInt(System.console().readLine());
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            while (!board.putMark(mark, row, col) && !board.isGameEnded()) { // while the input isn't correct
                System.out.println("Please enter Correct input (row and then column), int the bounds of the game, and correct mark: ");
                row = scanner.nextInt();
                col = scanner.nextInt();
            }
            board.putMark(mark, row, col);
//        } catch (Exception e) {
//            System.out.println("Please enter Correct input(row and then column), int the bounds of the game, and correct mark: ");
//            int row2 = scanner.nextInt();
//            int col2 = scanner.nextInt();
//            board.putMark(mark, row2, col2);
//        }
    }
}
