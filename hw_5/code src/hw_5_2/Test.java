package hw_5_2;

public class Test {
    Array aArray	 	= new Array();
    Flexible aFlexible 	= new Flexible();
    Integer one 		= Integer.valueOf(1);
    Integer two 		= Integer.valueOf(2);
    Integer three 		= Integer.valueOf(3);

    private void testAddArray()	{
        aArray.add(one);
        aArray.add(two);
        aArray.add(three);
        aArray.add(null);
        System.out.println(aArray);
    }

    private void testAddFlexible()	{
        aFlexible.add(one);
        aFlexible.add(one);
        aFlexible.add(two);
        aFlexible.add(two);
        aFlexible.add(three);
        aFlexible.add(null);
        aFlexible.delete(two);
        System.out.println(aFlexible);

    }

    private void test()	{
        testAddArray();
        testAddFlexible();
    }

    public static void main(String args[])	{
        new Test().test();
    }
}