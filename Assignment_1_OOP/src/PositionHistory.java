import java.util.ArrayList;
import java.util.List;

public class PositionHistory {

    /**
     * This class will be kind of a data-structure, that will hold a positoin history.
     * We need to print the number of different pieces that have been in a position, only if it was stepped over
     */

    // Variables
    private ConcretePiece pie;

    // Keeping the positions from where to where, to know the change
    private Position fromWhere;
    private Position toWhere;

    private List<Pawn> eaten; // List of pawn which were eaten in a turn, so we we'll be able to restore them.
                             // If the king is eaten so the game is finished, and this is another case

    public PositionHistory(ConcretePiece pie, Position fromWhere, Position toWhere) {
        this.pie = pie;
        this.fromWhere = fromWhere;
        this.toWhere = toWhere;
        this.eaten = new ArrayList<Pawn>(4); // Maximum, pawn that can be eaten in a turn, is 4
    }

    // Getters & Setters
    public ConcretePiece getPie() {
        return pie;
    }

    public void setPie(ConcretePiece pie) {
        this.pie = pie;
    }

    public Position getFromWhere() {
        return fromWhere;
    }

    public void setFromWhere(Position fromWhere) {
        this.fromWhere = fromWhere;
    }

    public Position getToWhere() {
        return toWhere;
    }

    public void setToWhere(Position toWhere) {
        this.toWhere = toWhere;
    }

    public List<Pawn> getEaten() {
        return eaten;
    }

    public void setEaten(List<Pawn> eaten) {
        this.eaten = eaten;
    }


    // Methods
    public void addEaten(Pawn p) {
        this.eaten.add(p);
    }
}
