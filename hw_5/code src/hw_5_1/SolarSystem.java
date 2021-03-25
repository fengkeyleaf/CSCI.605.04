/*
 * SolarSystem.java
 *
 * Version:
 *     $1.1$
 *
 * Revisions:
 *     $adapted to hw 6.1 on 10/02/2020$
 */

/**
 * This program does what exactly what hw 6.1 requires
 *
 * @author      Xiaoyu  Tongyang, or call me sora sor short
 */

package hw_5_1;

public class SolarSystem {
    private final Planet[] planets; // array to store planets
    private int numberOfPlanets = 0; // number of planets in the solar system
    private double totalDensity = 0; // total density of all planets

    // 应该有默认构造函数
    /**
     * the constructor that create a planet with its name, density, orbital period, number of moons
     *
     * @param    soManyPlanets     how many planets will be stored in the solar system
     */

    public SolarSystem( int soManyPlanets ) {
        if ( soManyPlanets < 1 ) {
            System.out.println( "The number of planets must be positive!" );
            System.exit(1);
        }

        this.planets = new Planet[soManyPlanets];
    }

    /**
     * to calculate total density of all planets
     */

    private void calculateTotalDensity() {
        // calculate from the scratch because there are some planets being updated
        this.totalDensity = 0;

        for ( int i = 0; i < this.planets.length; i++ ) {
            if ( this.planets[i] != null ) {
                this.totalDensity += this.planets[i].getDensity();
            }
        }
    }

    /**
     * add a planet to the solar system
     *
     * @param    position     which position a planet is added to
     * @param    p            the planet needed to add to the solar system
     */

    public void setPlanet( int position, Planet p ) {
        if ( p == null ) {
            System.out.println("Should not add null to the solar system!");
            return;
        }

        try {
            this.planets[position - 1] = p;
            this.numberOfPlanets++;
            calculateTotalDensity();
        }catch ( ArrayIndexOutOfBoundsException e ) {
            System.err.println("The position is invalid!");
            System.exit(1);
        }
    }


    /**
     * get a textual representation of the solar system
     */

    public String toString() {
        String output = "";
        for ( int i = 0; i < this.planets.length; i++ ) {
            if ( this.planets[i] != null ) {
                output += (i + 1) + ": " + this.planets[i] + "\n";
            }
        }

        output += "\n\taverage density: " + this.totalDensity / this.numberOfPlanets;
        return output;
    }

    /**
     * The main program to test class SolarSystem.
     *
     * @param    args  command line arguments, ignored
     */

    public static void main( String args[] )  {
        SolarSystem aSolarSystem = new SolarSystem(8);  // sadly Pluto was demoted

        Planet aPlanet = new Planet("Mercury", 5.427, 87.97, 0);
        aSolarSystem.setPlanet(1, new Planet("Mercury", 5.427, 87.97, 0));

        aPlanet.setName("Saturn");
        aPlanet.setDensity(0.687);
        aPlanet.setOrbitalPeriod(10759.22);
        aPlanet.setNumberOfMoons(82);
        aSolarSystem.setPlanet(6, aPlanet);

 /*       aPlanet.setName("Earth");
        aPlanet.setDensity(5.514);
        aPlanet.setOrbitalPeriod(365.256363004);
        aPlanet.setNumberOfMoons(1);
        aSolarSystem.setPlanet(3, aPlanet);*/

        System.out.println(aSolarSystem);
    }
}
