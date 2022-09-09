/**
 * class List is a collection of unsorted Face objects.
 * The records in the list should all have unique IDs.
 */
public class List {

    /** Array to store songs in queue */
    protected Face[] faces;

    /** Default for maximum number of faces that can be stored */
    protected static final int DEFAULT_CAPACITY = 500;

    /** Maximum number of faces that can be stored */
    private int capacity;

    /** The number of faces stored in the array. */
    private int count = 0;

    // ============== 2 Overloaded Constructors ============== //

    /**
     * Constructor with capacity as parameter
     * 
     * @param size The capacity of the list (i.e. max number of elements)
     */
    public List(int size) {
        capacity = size;
        faces = new Face[capacity];
    }

    /**
     * Default Constructor
     */
    public List() {
        this(DEFAULT_CAPACITY);
    }

    // ************ SETTERS, GETTERS, print, helper ******************* //

    public int length() {
        return count;
    }

    public int capacity() {
        return capacity;
    }

    public boolean isFull() {
        /** TODO: fix this (1 line of code) */
        return true;
    }

    public boolean isEmpty() {
        /** TODO: fix this (1 line of code) */
        return true;
    }

    private Boolean isValid(int index) {
        /** TODO: fix this (a few lines of code) */
        return true;
    }

    /** Prints numbered list of faces. */
    @Override
    public String toString() {
        String printedList = "";
        for (int i = 0; i < count; i++) {
            printedList += (i + 1) + ". " + faces[i].toString() + "\n";
        }
        return printedList;
    } // end toString()

    // ******************* ADD ******************* //

    /**
    */
    public void add(Face face) {
        // Default location for adding a face is at the end of the array
        // Add only if it is not full
        /** TODO: Write this (~3 lines of code) */

    } // end add(Face)

    /**
    */
    public void add(Face face, int index) {
        /** TODO: write this */
        // Add at index only if it is a valid index AND the array isn't full.
        // All elements must be shifted to make room for the new item.
        // HINT: start shifting at the end until you get to where you want to add

    } // end add(Face, int)

    /**
    */
    public void set(Face face, int index) {
        // Overwrite the element IF the index is valid
        /** TODO: write this (~2 lines of code) */
    } // end set(Face, int)

    // ******************* SEARCH ******************* //

    /**
    */
    public Face peek(int index) {
        /** TODO: write this (1 line of code) */
        return null;
    } // end peek(int)

    /**
    */
    public int recordNo(Face face) {
        /** TODO: write this */
        // Return the index within the array or -1 if not in the array
        // Use the isEqual method in the Face class
        return -1;
    } // end recordNo(Face)

    // ******************* CONVERT ******************* //
    /**
    */
    public Face[] toArray() {
        // TODO: write this
        // make a COPY of the faces array and return it.
        // it should be the size of "count"
        return null;
    } // end toArray()

} // end class List
