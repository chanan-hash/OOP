public class Pawn extends ConcretePiece {
    /**
     * This class represents the Pawn piece in the game.
     * We have his String type as a constant, to tell us which player is it.
     * We have his eatNumber as 0 at the beginning.
     */
    // To define the type of the piece as a constant String for each player
    private static final String PLAYER1 = "♙";
    private static final String PLAYER2 = "♟";
    private String type;

    private int eatNumber = 0; // The number of the pieces that the pawn ate

    //The owner and the type are inherited from the ConcretePiece class
    public Pawn(Player player, String type, int numberPwan) {
        super(player, type, numberPwan);
        this.type = player.isPlayerOne() ? PLAYER1 : PLAYER2; // By checking which player is it, we will know which type is it
        this.eatNumber = 0; // The number of the pieces that the pawn ate, initialized by 0
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public int getNumberOfEats() {
        return this.eatNumber;
    }

    // Updating the eatNumber
    public void eat() {
        eatNumber++;
    }

    @Override
    public String getName() { // It will help us for the printing after it
        String pawnName = super.getOwner().isPlayerOne() ? "D" : "A"; // D - Defender, A - Attacker
        return pawnName + super.getPieceNum();
    }
}
