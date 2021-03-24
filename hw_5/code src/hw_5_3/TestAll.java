package hw_5_3;

public class TestAll	{
    // 1. draw the class diagram, including interface
    // 2. why are these declararions legal?
    static I1	anI1	=	new C1();
    static I2	anI2	=	new C3();
    static I1	anI1a	=	new C2();
    static I1	anI1b	=	new C4();
    static I2	anI2a	=	new C4();

    // 3. which methods will be called and why?
    public static void test1()	{
        anI1.i1method(); // C1: i1method()/i1variable = 0 in C1
        anI1b.i1method(); // C4: i1method()/i1variable = 0 in C4
        anI1b.i1and2method(); // C4: i1and2method()/i2variable = 3333, I2.i1and2variable = 4444, in C4
        anI1b.i1method(); // C4: i1method()/i1variable = 0 in C4
        anI2.i2method(); // C3: i2method() in C3
        anI2.i1and2method(); // C3: i1and2method()/i2variable = 3333, I1.i1and2variable = 1 in C3
    }

    // 4. which methods will be called and why?
    public static void test2()	{
        C3 aC3 = new C3();
        C5 aC5 = new C5();
        C3 aaC3 = (C3)aC5;
        aC3.c3andC5m(); // C3: c3andC5m()/c3andC5m: 42
        aC5.c3andC5m(); // C5: c3andC5m()/c3andC5m: 424242
        aaC3.c3andC5m(); // C5: c3andC5m()/c3andC5m: 424242
        System.out.println("aaC3.c3andC5 = " + aaC3.c3andC5 ); // aaC3.c3andC5 = 42
        aaC3.c3andC5 = 99999;
        aaC3.c3andC5m(); // C5: c3andC5m()/c3andC5m: 424242
        System.out.println("aaC3.c3andC5 = " + aaC3.c3andC5 ); // aaC3.c3andC5 = 99999
    }

    public static void main(String[] args)	{
        test1();
        test2();
    }
    // 5. give an example when you would use an abstract class but not an interface
    // 6. give an example when you would use an interface but not an abstract class
    // 7. give an example when you have to use an interface
}