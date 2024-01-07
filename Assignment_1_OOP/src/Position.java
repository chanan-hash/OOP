import java.util.Objects;

public class Position {
    /**
     * This class represents a position in the board.
     * The position is represented by a Point object, that includes X and Y numbers.
     * <p>
     * The board is build like a math graph, Y - row, X - column. opposite to the usual board.
     * X = i = row, and Y = j = column. board[i][j] here it will be board[y][x].
     */

    // Variables
    private int _x;
    private int _y;

    // Constructor
    public Position(int x, int y) {
        this._x = x;
        this._y = y;
    }

    // Methods
    // Getters
    public int getX() {
        return this._x;
    }

    public int getY() {
        return this._y;
    }

    // Setters
    public void set_x(int _x) {
        this._x = _x;
    }

    public void set_y(int _y) {
        this._y = _y;
    }

    @Override
    public String toString() {
        return "Position{" +
                "_x=" + _x +
                ", _y=" + _y +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Position) {
            Position other = (Position) obj;
            return this._x == other._x && this._y == other._y;
        }
        return false;
    }

    /*
    public boolean equals(Object obj{
    if (this == obj) {
        return true; // The same object itself
    }
    if (obj == null || getClass() != obj.getClass(){
        return false; // The other object is null, or not from the same class
        }
        Position other = (Position) obj; // Casting the other object to Position
        return (this._x == other._x) && (this._y == other._y);
     */

    @Override
    public int hashCode() {
        return Objects.hash(_x, _y);
    }
    /*
    @Override
    public int compareTo(Position other) {
        if (this._x == other._x) {
            return this._y - other._y;
        }
        return this._x - other._x;
     */

    // Calculating the distance between two positions
    public int distance(Position other) {
        return Math.abs(this._x - other._x) + Math.abs(this._y - other._y);
    }

}
