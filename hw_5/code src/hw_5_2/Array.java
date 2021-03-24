/*
 * Array.java
 *
 * Version:
 *     $1.0$
 *
 * Revisions:
 *     $Log$
 */

/**
 * This program does what exactly what hw 5.2 requires
 *
 * @author       Xiaoyu  Tongyang
 * @author       Chenxuan li
 */

package hw_5_2;

import java.util.Date;

public class Array {
    private static final String name = "Array"; // name of class Array, immutable, cannot be inherited
    protected final String creationTime; // creation time of the class
    protected String modificationTime;  // modification time of the class

	// 可以放在父类，然后用构造函数根据对象初始化就行了
    // indicate whether the class can store as many objects as possible, immutable, cannot be inherited
    private static final boolean unlimited = false;

    protected int soMany = 0; // number of elements the class stores at this point
    protected int soManyNull = 0; // number of null the class stores at this point
    protected int arraySize = 5; // number of elements the class can stores

    protected int index = 0; // use to store an element at this position
    protected Object[] storeElements; // array to store objects or elements
    protected boolean[] markPosition; // array to indicate a position at which if an element is located in the storeElement

    protected final Date myTime = new Date(); // the Date class to generate time
    protected boolean nullObjectAdded; // true - nulls added; false - none of nulls added

    /**
     * the constructor that create a Array object, initialize the creation time and modificationTime, and assign the
     * default size to array store Elements and markPosition.
     */

    public Array() {
        this.modificationTime = creationTime = myTime.toString();
        this.storeElements = new Object[this.arraySize];
        this.markPosition = new boolean[this.arraySize];
    }

    /**
     * the constructor that create a Array with demand size, initialize the creation time and modificationTime,
     * and assign the pass size to array store Elements and markPosition.
     *
     * @param    arraySize     how many objects will be stored
     */

    public Array( int arraySize ) {
        this.arraySize = arraySize;
        this.modificationTime = this.creationTime = myTime.toString();
        this.storeElements = new Object[this.arraySize];
        this.markPosition = new boolean[this.arraySize];
    }

    /**
     * update the modificationTime from current time
     */

    protected void updateModificationTime() {
        this.modificationTime = myTime.toString();
    }

    /**
     * add new element to empty space in array
     *
     * @param    element     element append to the array
     */

    protected void findPositionToAdd(Object element) {
        for ( int i = 0; i < this.arraySize; i++ ) {
            if ( !this.markPosition[i] ) {
                if (element == null) {
                    this.nullObjectAdded = true;
                    this.soManyNull++;
                }

                this.storeElements[i] = element;
                this.markPosition[i] = true;
                break;
            }
        }

        this.soMany++;
    }

    /**
     * add new element to empty space in array
     *
     * @param    element     element appended to the array
     * @return               return true if element add successful
     *                       return false if array meet limitation
     */

	// 老师的方法把null看成一种状态，即当前class没有null，但是多少个null都看成同一种状态，只有计数，没有实际占位
    public boolean add(Object element) {
        if ( this.soMany >= this.arraySize ) {
            System.out.println( "Cannot add more elements!" );
            return false;
        }

        findPositionToAdd( element );
        updateModificationTime();
        return true;
    }

    private void sleep(int i) {
    }

    /**
     * add new element to empty space in array
     *
     * @param    element     element append to the array
     * @return               return true if element add successful
     *                       return false if array meet limitation
     */

    public boolean delete(Object element) {
        if (this.soMany <= 0) {
            System.out.println("No more elements to delete!");
            return false;
        }

        // have an element at a certain position if:
        // 1) this.markPosition[i] == true;
        // 2) markPosition[i] == null or markPosition[i] != null; the former shows we have a null; the later an element
		// 最好先检查地址相等，没有地址相等的情况，再检查内容相等，特别是对于planet来说
        for ( int i = 0; i < this.arraySize; i++ ) {
            if ( this.markPosition[i] && element == this.storeElements[i] ) {
                if ( element == null && --this.soManyNull <= 0 ) {
                    this.nullObjectAdded = false;
                }

                this.storeElements[i] = null;
                this.markPosition[i] = false;
                break;
            }
        }

        this.soMany--;
        updateModificationTime();
        return true;
    }

    /**
     * Returns the maximum number of elements can be stored
     */

    public int getMax() {
        return this.arraySize;
    }

    /**
     * Returns the current number of elements stored
     */

    public int size() {
        return this.soMany;
    }

    /**
     * Returns true if a particular element is stored
     *
     * @param    target     element needed to check in the object
     */

    public boolean contains( Object target ) {
        for ( Object element : this.storeElements ) {
            if ( element == target ) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns true if no more elements can be stored unless an element is deleted
     */

    public boolean isFull() {
        return this.soMany >= this.arraySize;
    }

    /**
     * Returns true if 0 ore elements are stored
     */

    public boolean isEmpty() {
        return this.soMany == 0;
    }

    /**
     * add new element to empty space in array
     *
     * @param    str         part of print
     * @return               return str which include many object property for print
     */

    protected String generateTextualRepresentation(String str) {
        str += "\ncreationTime: " + this.creationTime + "\nsoMany: " + this.soMany
                + "\nnullObjectAdded: " + this.nullObjectAdded
                + "\nmodificationTime: " + this.modificationTime + "\n";

        for (int i = 0; i < storeElements.length; i++) {
            if (storeElements[i] == null && markPosition[i]) {
                str += " , ";
            }
            else if (storeElements[i] != null) {
                str += storeElements[i] + ", ";
            }
        }
        
        return str;
    }

    /**
     * get a textual representation of Array
     */

    public String toString() {
        String str = "name: " + name + "\nunlimited: " + unlimited;
        return generateTextualRepresentation(str) + "\n";
    }

    /**
     * The main program to test class Array
     *
     * @param    args  command line arguments, ignored
     */

    public static void main(String[] args) {
        Array myArray = new Array();
        
        Integer num1 = Integer.valueOf(1);
        Integer num2 = Integer.valueOf(2);
        Integer num3 = Integer.valueOf(3);
        Integer num4 = Integer.valueOf(4);

        myArray.add(num2);
        myArray.add(num3);
        myArray.add(num4);
        myArray.add(null);

        String str1 = new String("ABC");
        String str2 = new String("DEF");

        myArray.add(str1);
        myArray.add(str2);
        myArray.add(null);
        myArray.add(num1);
        myArray.add("GHI");
        myArray.add("MNK");

        System.out.println(myArray);

        myArray.delete(num2);
        myArray.delete(null);
        myArray.delete(str2);
        myArray.delete(null);

        System.out.println(myArray);
    }
}
