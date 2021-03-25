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

package hw_5_1;

public class Planet {
    // those variables only belonging to the planet itself, so cannot be inherited or available to other classes
    // and those are mutable so not use final
    private String name; // name of the planet
    private double density; // density of the planet
    private double orbitalPeriod; // orbital period of the planet
    private int numberOfMoons; // number of moons, must be non-negative integer

    // 应该有默认构造函数
    /**
     * the constructor that create a planet with its name, density, orbital period, number of moons
     *
     * @param    name     name of a given planet
     * @param    density  density of a give planet
     * @param    orbitalPeriod  orbital period of a give planet
     * @param    numberOfMoons  number of moons of a give planet
     */

    public Planet( String name, double density, double orbitalPeriod, int numberOfMoons ) {
        this.name = name;

        if ( density <= 0 ) {
            System.out.println( "Density must be positive!" );
            System.exit(1);
        }

        if (orbitalPeriod <= 0) {
            System.out.println( "Orbital Period must be positive!" );
            System.exit(1);
        }

        if (numberOfMoons < 0) {
            System.out.println( "Number Of Moons must be non-negative!" );
            System.exit(1);
        }

        this.density = density;
        this.orbitalPeriod = orbitalPeriod;
        this.numberOfMoons = numberOfMoons;
    }

    /**
     * set the name of a give planet
     *
     * @param    name     name of the planet
     */

    public void setName( String name ) {
        this.name = name;
    }

    /**
     * set the density of a give planet
     *
     * @param    density     density of a given planet
     */

    public void setDensity( double density ) {
        if ( density <= 0 ) {
            System.out.println( "Density must be positive!" );
            System.exit(1);
        }

        this.density = density;
    }

    /**
     * set the density of a give planet
     *
     * @param    orbitalPeriod     orbital period of a give planet
     */

    public void setOrbitalPeriod( double orbitalPeriod ) {
        if ( orbitalPeriod <= 0 ) {
            System.out.println( "Orbital Period must be positive!" );
            System.exit(1);
        }

        this.orbitalPeriod = orbitalPeriod;
    }

    /**
     * set the number of moons of a give planet
     *
     * @param    numberOfMoons     number of moons of a give planet
     */

    public void setNumberOfMoons( double numberOfMoons ) {
        if (numberOfMoons < 0) {
            System.out.println( "Number Of Moons must be non-negative!" );
            System.exit(1);
        }

        this.numberOfMoons = (int) numberOfMoons;
    }

    /**
     * get the name of a give planet
     */

    public String getName() {
        return this.name;
    }

    /**
     * get the density of a give planet
     */

    public double getDensity() {
        return this.density;
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
        return this.name + "/" + this.density + "/" + this.orbitalPeriod + "/" + this.numberOfMoons;
    }

    /**
     * The main program to test class Planet.
     *
     * @param    args  command line arguments, ignored
     */

    public static void main( String args[] )  {
//        Planet bPlant = new Planet();
        Planet aPlanet = new Planet("Mercury", 5.427, 87.97, 0);
        System.out.println(aPlanet);
        aPlanet.setName("Saturn");
        aPlanet.setDensity(0.687);
        aPlanet.setOrbitalPeriod(10759.22);
        aPlanet.setNumberOfMoons(82.1);
        System.out.println(aPlanet);

        System.out.println("1: " + aPlanet.getName() );
        System.out.println("2: " + aPlanet.getDensity() );
        System.out.println("3: " + aPlanet.getOrbitalPeriod() );
        System.out.println("4: " + aPlanet.getNumberOfMoons() );

    }
}
