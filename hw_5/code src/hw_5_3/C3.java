package hw_5_3;

// AbstractClass implements I1
public class C3 extends AbstractClass implements I2 {
    int c3andC5 = 42;

    public void c3andC5m()  {
        System.out.println("C3: c3andC5m()/c3andC5m: " + c3andC5);
    }

    public int abstractClass2()	{
        System.out.println("C3: abstractClass2()");
        return 123456;
    }

    public void i1method()	{
        System.out.println("C3: i1method()/i2variable = " + i2variable);
    }

    public void i2method()	{
        System.out.println("C3: i2method()");
    }

    public void i1and2method()	{
        System.out.println("C3: i1and2method()/i2variable = " + i2variable + " I1.i1and2variable = " + I1.i1and2variable);
    }
}