public class ConcretePlayer implements Player{
    /**
     * A Simple class that represents a player in a chess-like game.
     * We have two players in the game, and each player has a number of wins.
     * And each player has a boolean value that indicates whether the player is player one or not.
     */
    private final boolean isPlayerOne;
    private int wins = 0;

    public ConcretePlayer(boolean isPlayerOne) {
        this.isPlayerOne = isPlayerOne;
        this.wins = 0; // The number of wins is 0 at the beginning
    }

    @Override
    public boolean isPlayerOne() {
        return isPlayerOne;
    }

    @Override
    public int getWins() {
        return this.wins;
    }

    // Updating the wins
    public void addWin() {
        this.wins++;
    }
}
