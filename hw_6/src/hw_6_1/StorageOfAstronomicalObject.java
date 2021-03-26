/*
 * StorageOfAstronomicalObject.java
 *
 * Version:
 *     $1.0$
 *
 * Revisions:
 *     $0.0$
 */

/**
 * This program does what exactly hw 6.1 requires
 *
 * @author      Xiaoyu  Tongyang, or call me sora sor short
 */

package hw_6_1;

import java.util.Vector;

public class StorageOfAstronomicalObject<T extends CelestialBody> {
    private String name; // name of the storage class
    private final Vector<T> container = new Vector<T>(); // generics vector to store objects
    private double totalDensity = 0; // total density of all elements

    /**
     * the default constructor to create a hw_6_2.StorageOfAstronomicalObject without any associated information
     */

    public StorageOfAstronomicalObject() {}

    /**
     * the constructor that create a given storage class with its name
     *
     * @param    name     name of a given storage class
     */

    public StorageOfAstronomicalObject(String name) {
        this.name = name;
    }

    /**
     * get the name
     */

    public String getName() {
        return this.name;
    }

    /**
     * set the name
     *
     * @param    name     name of a given storage class
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * to calculate total density of all elements
     */

    private void calculateTotalDensity() {
        // calculate from the scratch because there might be some planets being updated
        this.totalDensity = 0;

        for ( T element : this.container ) {
            this.totalDensity += element.getDensity();
        }
    }

    /**
     * add an object to the solar system
     *
     * @param    element            the object needed to add to the storage class
     */

    public void add(T element) {
        if ( element == null ) {
            System.out.println("Cannot add null to the storage class");
            return;
        }

        this.container.add( element );
        calculateTotalDensity();
    }

    /**
     * get the size of the storage class
     */

    public int getSize() {
        return this.container.size();
    }

    /**
     * get all of the names of each element
     */

    public String getAllNames() {
        StringBuilder allNames = new StringBuilder();

        for ( T element : this.container ) {
            allNames.append(element.getName()).append(", ");
        }

        return allNames.toString();
    }

    /**
     * get a textual representation of this class
     */

    public String toString() {
        StringBuilder textualRepresentation = new StringBuilder();

        for ( int i = 0; i < this.container.size(); i++ ) {
            textualRepresentation.append(i).append(": "). // append "Index: "
                    append(this.container.elementAt(i).toString()). // append textual representation of the object
                    append("\n");
        }

        textualRepresentation.append( "\taverage density: " ).append( this.totalDensity / this.getSize() );
        return textualRepresentation.toString();
    }

    // test for this storage class is located in Class Test
}
