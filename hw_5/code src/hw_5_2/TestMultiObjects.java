package hw_5_2;

// our own test Class to test if the classes Array and Flexible can store elements from different classes,
// including our self-defined classes: A  B, C, and C extends B, B extends A;

public class TestMultiObjects {
    Array array	 	    = new Array();
    Flexible aFlexible 	= new Flexible();
    Integer one 		= Integer.valueOf(1);
    double number       = 3.2;
    A aTest             = new A();
    B bTest             = new B();
    C cTest             = new C();
    String  testStr     = "abc";

    private void testMultipulArray(){
        array.add(one);
        array.add(number);
        array.add(aTest);
        array.add(bTest);
        array.add(cTest);
        array.add(testStr);

        System.out.println(array);

        array.delete(one);
        array.delete(cTest);

        array.add(testStr);
        array.add(null);

        System.out.println(array);
    }

    private void testMultipulFlexible(){
        aFlexible.add(one);
        aFlexible.add(number);
        aFlexible.add(aTest);
        aFlexible.add(bTest);
        aFlexible.add(cTest);
        aFlexible.add(testStr);

        System.out.println(aFlexible);

        aFlexible.delete(one);
        aFlexible.delete(cTest);

        aFlexible.add(new StringBuilder(""));
        aFlexible.add(null);

        System.out.println(aFlexible);
    }

    private void test(){
        testMultipulArray();
        testMultipulFlexible();
    }

    public static void main(String args[])	{
        new TestMultiObjects().test();
    }
}



