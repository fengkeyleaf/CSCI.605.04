/*
 * Binaries.java
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

public class Binaries extends Asteroid{
    private int satellites; // satellites of a given Binaries

    /**
     * the default constructor to create a Binaries without any associated information
     */

    public Binaries() {}

    /**
     * the constructor that create a given Binaries with its name, density, discoverer and satellites
     *
     * @param    name     name of a given Binaries
     * @param    density  density of a given Binaries
     * @param    discoverer  discoverer of a given Binaries
     * @param    satellites  satellites of a given Binaries
     */

    public Binaries(String name, double density, String discoverer, int satellites) {
        super(name, density, discoverer);

        if (satellites < 0) {
            System.out.println( "Number Of Moons must be non-negative! failed to create a Binaries" );
            System.exit(1);
        }

        this.satellites = satellites;
    }

    /**
     * get the satellites of a given asteroid
     */

    public int getSatellites() {
        return this.satellites;
    }

    /**
     * set the satellites of a given asteroid
     *
     * @param    satellites  satellites of a given Asteroid
     */

    public void setSatellites(int satellites) {
        if (satellites < 0) {
            System.out.println( "Number Of satellites must be non-negative!" );
            return;
        }

        this.satellites = satellites;
    }

    /**
     * get a textual representation of the Binaries
     */

    public String toString() {
        return "Binaries: " + this.name + "/" + this.density + "/" + this.discoverer + "/" + this.satellites;
    }


    /**
     * The main program to test class Binaries.
     *
     * @param    args  command line arguments, ignored
     */

    public static void main( String args[] ) {
        Binaries aBinaries = new Binaries();
        Binaries bBinaries = new Binaries("Himea", 100.1, "MJ", 2);

        aBinaries.setName("Luckin");
        aBinaries.setDiscoverer("Coffee");
        aBinaries.setSatellites(5);
        aBinaries.setDensity(102);

        System.out.println(bBinaries.getDensity());
        System.out.println(bBinaries.getName());
        System.out.println(bBinaries.getDiscoverer());
        System.out.println(bBinaries.getSatellites());

        System.out.println(aBinaries);
        System.out.println(bBinaries);

        bBinaries.setDiscoverer("Coffee");
        bBinaries.setName("Franke");
        bBinaries.setDensity(101);

        System.out.println(aBinaries);
        System.out.println(bBinaries);
    }
}
