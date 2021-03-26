package factory;

public class Factory<T> {
    private T t;
    public <C extends Creator<T>> Factory(C creator) {
        t = creator.create();
    }

    public T getT() {
        return this.t;
    }
}