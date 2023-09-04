package TicTacToe;

public class Piece {
    private PieceColor color;

    public Piece(PieceColor color) {
        this.color = color;
    }

    public static void main(String[] args) {
        Piece whitePiece = new Piece(PieceColor.WHITE);
    }
}
