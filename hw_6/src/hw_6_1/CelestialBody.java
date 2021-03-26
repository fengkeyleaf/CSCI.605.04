/*
 * CelestialBody.java
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

public class CelestialBody {
    protected String name; // name of a given CelestialBody
    protected double density; // name of a given CelestialBody

    /**
     * the default constructor to create a celestial body without any associated information
     */

    public CelestialBody() {}

    /**
     * the constructor that create a given CelestialBody with its name, density
     *
     * @param    name     name of a given CelestialBody
     * @param    density  density of a given CelestialBody
     */

    public CelestialBody(String name, double density) {
        if ( density <= 0 ) {
            System.out.println( "Density must be positive! failed to create a celestial body" );
            System.exit(1);
        }

        this.name = name;
        this.density = density;
    }

    /**
     * get the name of a given celestial body
     */

    public String getName() {
        return this.name;
    }

    /**
     * get the density of a given celestial body
     */

    public double getDensity() {
        return this.density;
    }

    /**
     * set the name of a given celestial body
     *
     * @param    name     name of the given celestial body
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * set the density of a given celestial body
     *
     * @param    density     density of the given celestial body
     */

    public void setDensity(double density) {
        if ( density <= 0 ) {
            System.out.println( "Density must be positive!" );
            return;
        }

        this.density = density;
    }

    /**
     * get a textual representation of the CelestialBody
     */

    public String toString() {
        return "CelestialBody: " + this.name + "/" + this.density;
    }

    /**
     * The main program to test class CelestialBody.
     *
     * @param    args  command line arguments, ignored
     */

    public static void main( String args[] )  {
        CelestialBody aCelestialBody = new CelestialBody();
        CelestialBody bCelestialBody = new CelestialBody("Himea", 100.1);

        aCelestialBody.setDensity(21.1);
        aCelestialBody.setName("Saito");

        System.out.println(aCelestialBody.getDensity());
        System.out.println(aCelestialBody.getName());
        System.out.println(bCelestialBody.getDensity());
        System.out.println(bCelestialBody.getName());

        System.out.println(aCelestialBody);
        System.out.println(bCelestialBody);
    }
}
