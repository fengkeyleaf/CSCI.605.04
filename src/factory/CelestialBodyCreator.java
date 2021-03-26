package factory;
import hw_6_1.CelestialBody;

public class CelestialBodyCreator implements Creator<CelestialBody>{
    @Override
    public CelestialBody create() {
        return new CelestialBody();
    }

    public static void main(String[] args) {
        Factory<CelestialBody> factory = new Factory<>(new CelestialBodyCreator());
        CelestialBody trainer = factory.getT();
        System.out.println(trainer.toString());
    }
}
