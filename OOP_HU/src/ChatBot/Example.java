package ChatBot;

public class Example {
    /**
     * CONSTANTS
     **/
    private static final String MESSAGE1 = "CONSTANT1";
    private static final String MESSAGE2 = "CONSTANT2";


    /**
     * FIELD MEMBERS
     **/
    // field member is initialized by default therefore field1 => 0
    private int field1;

    /**
     * Here we write constructor documentation
     */
    public Example() {
        //we can also initialize field1 in the constructor
        this.field1 = 10;
    }

    /**
     * Here we write method documentation
     */
    public void whileExample(int counter) {
        //a local variable must explicitly initialize!
        int localVar = 0;
        while (localVar < counter) {
            localVar++; // equals to localVar = localVar + 1
        }
    }

    /**
     * Here we write method documentation
     */
    private void implementForLoop() {
        int[] increasedValues = new int[this.field1];
        //each index in the array store the index value
        for (int i = 0; i < increasedValues.length; i++) {
            increasedValues[i] = i;
        }
    }

    /**
     * Here we write method documentation
     */
    public void forExample() {
        //call private helper method
        this.implementForLoop();
    }

    /**
     * Here we write method documentation
     */
    public String ifExample(boolean bool) {
        if (bool) {
            return MESSAGE1;
        } else {
            return MESSAGE2;
        }
    }
}
