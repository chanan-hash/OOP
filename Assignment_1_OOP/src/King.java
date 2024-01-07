public class King extends ConcretePiece {
    /**
     * This class represents the King piece in the game.
     * We have his String type as a constant.
     * We have his eatNumber as 0 because he can't eat.
     * We have his name as "K7" to help us for the printing after it.
     */
    private static final String type = "♔"; // We define the type of the piece as a constant String

    public King(Player player, String type) {
        super(player, type);
    }

    @Override
    public String getType() {
        return this.type;
    }


    public int getEatNumber() { // The King can't eat
        return 0;
    }


    public String getName() { // It will help us for the printing after it
        return "K7";
    }
}
