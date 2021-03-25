/*
 * Flexible.java
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
 * @author      Xiaoyu  Tongyang, or call me sora sor short
 */

package hw_5_2;

import java.util.Arrays;

public class Flexible extends Array {
    private static final String name = "Flexible"; // name of class Flexible, immutable, cannot be inherited

    // indicate whether the class can store as many objects as possible, immutable, cannot be inherited
    private static final boolean unlimited = true;

    /**
     * the default constructor for class Flexible
     */

    public Flexible() {}

    /**
     * mimic the same behavior as value construct in Array
     *
     * @param    arraySize     how many objects will be stored
     */

    public Flexible(int arraySize) {
        super(arraySize);
    }

    /**
     * add new element to empty space in array
     *
     * @param    element     element append to the array, automatally give 10 extra size, when the size meet limitation
     * @return               return true if element add successful
     */

    public boolean add( Object element ) {
        // if the space is not enough, extends it
        if ( this.soMany >= this.arraySize ) {
            this.arraySize += 10;
            this.storeElements = Arrays.copyOf( storeElements, this.arraySize );
            this.markPosition = Arrays.copyOf( markPosition, this.arraySize );
        }

        findPositionToAdd(element);
        updateModificationTime();
        return true;
    }

    /**
     * get a textual representation of Array
     */

    public String toString() {
        String str = "name: " + name + "\nunlimited: " + unlimited;;
        return generateTextualRepresentation(str) + "\n";
    }

    /**
     * The main program to test class Flexible
     *
     * @param    args  command line arguments, ignored
     */

    public static void main( String[] args ) {
        Flexible aFlexible = new Flexible();

        Integer num1 = Integer.valueOf(5);
        Integer num2 = Integer.valueOf(6);
        Integer num3 = Integer.valueOf(7);
        Integer num4 = Integer.valueOf(8);
        Double doubleNum1 = Double.valueOf(5.1);

        aFlexible.add(num2);
        aFlexible.add(num3);
        aFlexible.add(num4);
        aFlexible.add(null);

        String str1 = new String("YUI");
        String str2 = new String("OPL");

        aFlexible.add(str1);
        aFlexible.add(str2);
        aFlexible.add(null);
        aFlexible.add(num1);
        aFlexible.add("QWE");
        aFlexible.add("MGF");
        aFlexible.add(doubleNum1);

        System.out.println(aFlexible);

        aFlexible.delete(num2);
        aFlexible.delete(null);
        aFlexible.delete(str2);
        aFlexible.delete(null);

        System.out.println(aFlexible);
    }
}
