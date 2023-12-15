package Q4;

/**
 * This class represent a collection of symbols
 */
public class SymbolTable {
    // Arguments
    private Symbol[] symbolArr;
    // We can to it also with ArrayList
    private int capacity;
    static int size = 0; // Like in a stack, that we can track the size and the capacity

    // Constructor
    public SymbolTable(int length) { // The regular constructor getting a size, and allocating a place in the memory for it
        this.capacity = length;
        symbolArr = new Symbol[capacity];
    }

    // Copy constructor
    public SymbolTable(Symbol[] symbol) {
        symbolArr = new Symbol[symbol.length];
        for (int i = 0; i < symbol.length; i++) {
            symbolArr[i] = new Symbol(symbol[i].getName(), symbol[i].getTag());
            ; // this will point to the same place in the memory
        }
    }

    // Methods
    public void add(Symbol sym) throws Exception {
        if (capacity == size){
            throw new Exception("Try to add to full array");
        }
        else {
            symbolArr[size] = sym;
            size++;
        }
    }

    public void remove() throws Exception {
        if (symbolArr.length == 0) { // the array is empty
            throw new Exception("Try to remove from empty array");
        } else {
            symbolArr[symbolArr.length] = null;
            size--;
        }
    }

    public void set (int newTag){

    }

}
