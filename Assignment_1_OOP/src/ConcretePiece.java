public abstract class ConcretePiece implements Piece{
    private Player player;
    private String type;

    public ConcretePiece(Player player, String type) {
        this.player = player;
        this.type = type;
    }

    @Override
    public Player getOwner() {
        return this.player;
    }

    @Override
    public String getType() {
        return this.type;
    }
}
