import java.util.ArrayList;
import java.util.List;

public abstract class ConcretePiece implements Piece {

    // Variables
    private Player player; // The owner of the piece
    private String type;

    // For each piece we will have a list of moves, that will helps us in the end to print and sort the data for part 2 of the assignment
    private final List<Position> moves; // The type is a list that we can decide if it will be an ArrayList or LinkedList
    private int pieceNum; // This is like a tag for each piece, to help us print the data
    int distance = 0; // The distance that the piece moved, also for printing the data


    // Constructor
    public ConcretePiece(Player player, String type, int tag) {
        this.player = player;
        this.type = type;
        this.moves = new ArrayList<>(); // For now implementing it as an ArrayList
        this.pieceNum = tag; // giving each piece a tag
        this.distance = 0; // The distance that the piece moved

    }

    // Methods
    // Getters
    @Override
    public Player getOwner() {
        return this.player;
    }

    @Override
    public String getType() {
        return this.type;
    }


    public int getPieceNum() {
        return this.pieceNum;
    }

    public int getDistance() {
        return this.distance;
    }

    // return the moves List
    public List<Position> getMoves() {
        return this.moves;
    }

    public void addMove(Position position) {
        if (moves.size() > 0) {
            this.distance += moves.get(moves.size() - 1).distance(position); // Updating thew distance, by adding last place distance
        }
        this.moves.add(position);
    }


    // Abstract methods
    public abstract int getNumberOfEats(); // Will be implemented in Pawn class

    public abstract String getName(); // The same as above


}