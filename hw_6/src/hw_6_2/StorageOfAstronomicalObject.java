/*
 * StorageOfAstronomicalObject.java
 *
 * Version:
 *     $1.1$
 *
 * Revisions:
 *     $adapted to hw 6.2 on 10.3.2020$
 */

/**
 * This program does what exactly hw 6.2 requires
 *
 * @author      Xiaoyu  Tongyang, or call me sora sor short
 */

package hw_6_2;

import hw_6_1.Asteroid;
import hw_6_1.Binaries;
import hw_6_1.CelestialBody;
import hw_6_1.Planet;
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

        for (T element : this.container) {
            this.totalDensity += element.getDensity();
        }
    }

    /**
     * add an object to the solar system
     *
     * @param    element            the object needed to add to the storage class
     */

    public void add(T element) {
        if (element == null) {
            System.out.println("Cannot add null to the storage class");
            return;
        }

		// 老师给的方法是每个存储类重写clone方法，add的时候调用这个方法就行了；
		// 也就是不是只能修改这个storage class，可以修改其他类
        // The approach to deal with the problem in hw 6.1
        // check which class is stored in the run time and create a new copy of the object passed in as the argument,
        // and store it into the vector. But the following code may not be that elegant
        T anotherElement = null;
        try {
            switch (element.getClass().getName()) {
                case "hw_6_1.CelestialBody":
                    anotherElement = (T) new CelestialBody(element.getName(), element.getDensity());
                    break;
                case "hw_6_1.Planet":
                    Planet aPlanet = (Planet) element; // down-casting to Planet
                    anotherElement = (T) new Planet(aPlanet.getName(), aPlanet.getDensity(), aPlanet.getOrbitalPeriod(), aPlanet.getNumberOfMoons());
                    break;
                case "hw_6_1.Asteroid":
                    Asteroid aAsteroid = (Asteroid) element; // down-casting to Asteroid
                    anotherElement = (T) new Asteroid(aAsteroid.getName(), aAsteroid.getDensity(), aAsteroid.getDiscoverer());
                    break;
                case "hw_6_1.Binaries":
                    Binaries aBinaries = (Binaries) element; // down-casting to Binaries
                    anotherElement = (T) new Binaries(aBinaries.getName(), aBinaries.getDensity(), aBinaries.getDiscoverer(), aBinaries.getSatellites());
                    break;
                default:
                    System.err.println("Cannot reach here!");
                    System.exit(1);
            }
        } catch ( ClassCastException e ) {
            System.err.printf("%s%s\n", "Failed to add the element named ", element.getClass().getName());
            e.printStackTrace();
            return;
        }

        this.container.add( anotherElement );
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

        for (T element : this.container) {
            allNames.append( element.getName() ).append(", ");
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
