/*
 * Planet.java
 *
 * Version:
 *     $1.1$
 *
 * Revisions:
 *     $adapted to hw 6.1 on 10/02/2020$
 */

/**
 * This program does what exactly hw 6.1 requires
 *
 * @author      Xiaoyu  Tongyang, or call me sora sor short
 */

package hw_6_1;

public class Planet extends CelestialBody {
    private double orbitalPeriod; // orbital period of the planet
    private int numberOfMoons; // number of moons, must be non-negative integer

    /**
     * the default constructor to create a planet without any associated information
     */

    public Planet() {}

    /**
     * the constructor that create a planet with its name, density, orbital period, number of moons
     *
     * @param    name     name of a given planet
     * @param    density  density of a give planet
     * @param    orbitalPeriod  orbital period of a give planet
     * @param    numberOfMoons  number of moons of a give planet
     */

    public Planet( String name, double density, double orbitalPeriod, int numberOfMoons ) {
        super(name, density);

        if (orbitalPeriod <= 0) {
            System.out.println( "Orbital Period must be positive! failed to create a Planet" );
            System.exit(1);
        }

        if (numberOfMoons < 0) {
            System.out.println( "Number Of Moons must be non-negative! failed to create a Planet" );
            System.exit(1);
        }
        
        this.orbitalPeriod = orbitalPeriod;
        this.numberOfMoons = numberOfMoons;
    }

    /**
     * set the density of a give planet
     *
     * @param    orbitalPeriod     orbital period of a give planet
     */

    public void setOrbitalPeriod( double orbitalPeriod ) {
        if ( orbitalPeriod <= 0 ) {
            System.out.println( "Orbital Period must be positive!" );
            return;
        }

        this.orbitalPeriod = orbitalPeriod;
    }

    /**
     * set the number of moons of a give planet
     *
     * @param    numberOfMoons     number of moons of a give planet
     */

    public void setNumberOfMoons( int numberOfMoons ) {
        if (numberOfMoons < 0) {
            System.out.println( "Number Of Moons must be non-negative!" );
            return;
        }

        this.numberOfMoons = numberOfMoons;
    }

    /**
     * get the orbital period of a give planet
     */

    public double getOrbitalPeriod() {
        return this.orbitalPeriod;
    }

    /**
     * get the number Of moons of a give planet
     */

    public int getNumberOfMoons() {
        return this.numberOfMoons;
    }

    /**
     * get a textual representation of the planet
     */

    public String toString() {
        return "Planet: " + this.name + "/" + this.density + "/" + this.orbitalPeriod + "/" + this.numberOfMoons;
    }

    /**
     * The main program to test class Planet.
     *
     * @param    args  command line arguments, ignored
     */

    public static void main( String args[] )  {
        Planet aPlanet = new Planet("Mercury", 5.427, 87.97, 0);
        System.out.println(aPlanet);
        aPlanet.setName("Saturn");
        aPlanet.setDensity(0.687);
        aPlanet.setOrbitalPeriod(10759.22);
        aPlanet.setNumberOfMoons(82);
        System.out.println(aPlanet);

        System.out.println("1: " + aPlanet.getName() );
        System.out.println("2: " + aPlanet.getDensity() );
        System.out.println("3: " + aPlanet.getOrbitalPeriod() );
        System.out.println("4: " + aPlanet.getNumberOfMoons() );

        System.out.println("---------------------------------");
        Planet bPlant = new Planet();
        System.out.println(bPlant);
        bPlant.setName("Earth");
        bPlant.setDensity(1.01);
        bPlant.setOrbitalPeriod(908);
        bPlant.setNumberOfMoons(1);
        System.out.println(bPlant);

        System.out.println("1: " + bPlant.getName() );
        System.out.println("2: " + bPlant.getDensity() );
        System.out.println("3: " + bPlant.getOrbitalPeriod() );
        System.out.println("4: " + bPlant.getNumberOfMoons() );
    }
}
