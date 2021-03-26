package factory;

import hw_6_1.CelestialBody;

public class TrainerCreator implements Creator<Trainer> {
    @Override
    public Trainer create() { return new Trainer(); }

    public static void main(String[] args) {
        Factory<Trainer> factory = new Factory<>(new TrainerCreator());
        Trainer trainer = factory.getT();
        System.out.println(trainer.toString());

        Factory<CelestialBody> factory1 = new Factory<>(new CelestialBodyCreator());
        CelestialBody trainer1 = factory1.getT();
        System.out.println(trainer1.toString());
    }
}
//输出结果：Trainer