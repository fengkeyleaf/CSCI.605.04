// This program is to test if Class StorageOfAstronomicalObject works correctly

package hw_6_1;

public class Test {
    public static <T extends CelestialBody> void print(StorageOfAstronomicalObject<T> aStorageOfAstronomicalObject) {
        System.out.println(aStorageOfAstronomicalObject.getAllNames());
        System.out.println(aStorageOfAstronomicalObject);
    }

    public static void testPlanets() {
        StorageOfAstronomicalObject<Planet> aStorageOfAstronomicalObject = new StorageOfAstronomicalObject<>("Milky Way");

        aStorageOfAstronomicalObject.add(new Planet("Mercury", 5.427, 87.97, 0));

        Planet aPlanet = new Planet("Saturn", 0.687, 10792, 82);
        aStorageOfAstronomicalObject.add(aPlanet);

        aPlanet.setName("Earth");
        aPlanet.setDensity(5.514);
        aPlanet.setOrbitalPeriod(365.256363004);
        aPlanet.setNumberOfMoons(1);
        aStorageOfAstronomicalObject.add(aPlanet);

        print(aStorageOfAstronomicalObject);
    }

    public static void testAsteroid()        {
        StorageOfAstronomicalObject<Asteroid> aStorageOfAstronomicalObject = new StorageOfAstronomicalObject<>("Milky Way");

        aStorageOfAstronomicalObject.add(new Asteroid("Ceres", 9.427, "Pallas Athena"));

        Asteroid aAsteroid = new Asteroid("Juno", 0.687, "Vesta");
        aStorageOfAstronomicalObject.add(aAsteroid);

        aAsteroid.setName("Astraea");
        aAsteroid.setDensity(5.514);
        aAsteroid.setDiscoverer("Juno");
        aStorageOfAstronomicalObject.add(aAsteroid);

        print(aStorageOfAstronomicalObject);
    }

    public static void testBinaries()        {
        StorageOfAstronomicalObject<Binaries> aStorageOfAstronomicalObject = new StorageOfAstronomicalObject<>("Milky Way");

        aStorageOfAstronomicalObject.add(new Binaries("Iris", 5.427, "Ceres", 0));

        Binaries aBinaries = new Binaries("Flora", 0.687, "Hebe", 82);
        aStorageOfAstronomicalObject.add(aBinaries);

        aBinaries.setName("Metis");
        aBinaries.setDensity(11.1);
        aBinaries.setSatellites(10);
        aBinaries.setDiscoverer("Hygiea");
        aStorageOfAstronomicalObject.add(aBinaries);

        print(aStorageOfAstronomicalObject);
    }

    public static void testCelestialBody()        {
        StorageOfAstronomicalObject<CelestialBody> aStorageOfAstronomicalObject = new StorageOfAstronomicalObject<>();
        aStorageOfAstronomicalObject.setName("Saito Himea");

        aStorageOfAstronomicalObject.add(new CelestialBody("Mercury", 5.427));

        CelestialBody aCelestialBody = new CelestialBody("Saturn", 0.687);
        aStorageOfAstronomicalObject.add(aCelestialBody);

        aCelestialBody.setName("Earth");
        aCelestialBody.setDensity(5.514);
        aStorageOfAstronomicalObject.add(aCelestialBody);

        print(aStorageOfAstronomicalObject);
    }

    public static void main( String args[] )  {
        Test.testPlanets();
//        Test.testAsteroid();
//        Test.testBinaries();
//        Test.testCelestialBody();
    }
}