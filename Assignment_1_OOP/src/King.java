public class King extends ConcretePiece {
    /**
     * This class represents the King piece in the game.
     * We have his String type as a constant.
     * We have his eatNumber as 0 because he can't eat.
     * We have his name as "K7" to help us for the printing after it.
     */
    private static final String type = "♔"; // We define the type of the piece as a constant String

    public King(Player player, String type, int numberKing) {
        super(player, type, numberKing); // Each piece has a Player/Owner,type and tag number
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public int getNumberOfEats() {
        return 0;
    }
    @Override
    public String getName() { // It will help us for the printing after it
        return "K7";
    }
}
