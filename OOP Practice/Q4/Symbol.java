package Q4;

/**
 * This is from OOP self-practice in the drive:
 * https://drive.google.com/drive/folders/1YF5oYpIFE8VgzcfMUAV25LaCoNHZlUdI
 */
public class Symbol {
    // Variables
    private String name;
    private int tag;

    // Constructor
    public Symbol (String name, int tag){
        this.name = name;
        this.tag = tag;
    }

    public boolean equals(Symbol sym){
        return (this.name == sym.name) && (this.tag == sym.tag);
    }

    // For the copy constructor int the SymbolTable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }
}
