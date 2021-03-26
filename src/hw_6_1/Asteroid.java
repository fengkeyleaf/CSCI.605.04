/*
 * Asteroid.java
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

public class Asteroid extends CelestialBody{
    protected String discoverer; // discoverer of a given asteroid

    /**
     * the default constructor to create a Asteroid without any associated information
     */

    public Asteroid() {}

    /**
     * the constructor that create a given Asteroid with its name, density, discoverer
     *
     * @param    name     name of a given Asteroid
     * @param    density  density of a given Asteroid
     * @param    discoverer  discoverer of a given Asteroid
     */

    public Asteroid(String name, double density, String discoverer) {
        super(name, density);
        this.discoverer = discoverer;
    }

    /**
     * get the discoverer of a given asteroid
     */

    public String getDiscoverer() {
        return this.discoverer;
    }

    /**
     * set the discoverer of a given asteroid
     *
     * @param    discoverer  discoverer of a given Asteroid
     */

    public void setDiscoverer(String discoverer) {
        this.discoverer = discoverer;
    }

    /**
     * get a textual representation of the asteroid
     */

    public String toString() {
        return "Asteroid: " + this.name + "/" + this.density + "/" + this.discoverer + "/";
    }

    /**
     * The main program to test class Asteroid.
     *
     * @param    args  command line arguments, ignored
     */

    public static void main( String args[] )  {
        Asteroid aAsteroid = new Asteroid();
        Asteroid bAsteroid = new Asteroid("Himea", 100.1, "MJ");

        aAsteroid.setDiscoverer("Luckin");
        aAsteroid.setName("Schaerer");

        System.out.println(bAsteroid.getDensity());
        System.out.println(bAsteroid.getName());
        System.out.println(bAsteroid.getDiscoverer());

        System.out.println(aAsteroid);
        System.out.println(bAsteroid);

        bAsteroid.setDiscoverer("Coffee");
        bAsteroid.setName("Franke");
        bAsteroid.setDensity(101);

        System.out.println(aAsteroid);
        System.out.println(bAsteroid);
    }
}
