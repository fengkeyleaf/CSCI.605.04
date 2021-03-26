/*
 * MyTest.java
 *
 * Version:
 *     $1.0$
 *
 * Revisions:
 *     $0.0$
 */

package hw_7_2;

/**
 * Our self-designed test class to
 *
 * @author      Xiaoyu  Tongyang, or call me sora sor short
 */

public class MyTest {

    /**
     * test with String
     *
     * @param    aStorageInterfaceString      the binary search tree to store Strings
     */

    public static void testStringBuild(StorageInterface<String> aStorageInterfaceString)	{

        String three = new String("3");

        aStorageInterfaceString.add(null);
        aStorageInterfaceString.add("");
        aStorageInterfaceString.add(null);
        aStorageInterfaceString.add("3");
        aStorageInterfaceString.add(three);
        aStorageInterfaceString.add("1");
        aStorageInterfaceString.add("2");
        System.out.println("1." + aStorageInterfaceString);

        System.out.println(aStorageInterfaceString.find(new String("3")));
        System.out.println(aStorageInterfaceString.find("3"));
        System.out.println(aStorageInterfaceString.find(""));
        System.out.println(aStorageInterfaceString.find("4"));
        System.out.println(aStorageInterfaceString.find(null));
        System.out.println(aStorageInterfaceString.find("0"));
        System.out.println(aStorageInterfaceString.find("Himea"));

        System.out.println("-------------------------->");
        System.out.println(aStorageInterfaceString.includesNull());
        System.out.println(aStorageInterfaceString.delete("3"));
        System.out.println(aStorageInterfaceString.delete(three));
        System.out.println(aStorageInterfaceString.delete(null));
        System.out.println(aStorageInterfaceString.delete(null));
        System.out.println(aStorageInterfaceString.delete("1"));
        System.out.println(aStorageInterfaceString.delete("2"));
        System.out.println(aStorageInterfaceString.delete(""));
        System.out.println("1." + aStorageInterfaceString);

    }

    /**
     * test with the following elements: 5
     *
     * @param    aStorageInterfaceInteger      the binary search tree to store Integers
     */

    public static void testIntegerWithTheStructureOfTheTree1(StorageInterface<Integer> aStorageInterfaceInteger)	{
        aStorageInterfaceInteger.add(5);
        System.out.println("aStorageInterfaceInteger: " + aStorageInterfaceInteger);
        aStorageInterfaceInteger.delete(5);
        System.out.println("aStorageInterfaceInteger: " + aStorageInterfaceInteger);
    }

    /**
     * test with the following elements: 1, 4, 5
     *
     * @param    aStorageInterfaceInteger      the binary search tree to store Integers
     */

    public static void testIntegerWithTheStructureOfTheTree2(StorageInterface<Integer> aStorageInterfaceInteger)	{
        aStorageInterfaceInteger.add(4);
        aStorageInterfaceInteger.add(1);
        aStorageInterfaceInteger.add(Integer.valueOf(5));
        System.out.println("aStorageInterfaceInteger: " + aStorageInterfaceInteger);
        System.out.println(aStorageInterfaceInteger.find(2));
        aStorageInterfaceInteger.delete(5);
        System.out.println("aStorageInterfaceInteger: " + aStorageInterfaceInteger);
        aStorageInterfaceInteger.delete(Integer.valueOf(0));
        aStorageInterfaceInteger.delete(1);
        aStorageInterfaceInteger.delete(4);
        System.out.println("aStorageInterfaceInteger: " + aStorageInterfaceInteger);
    }

    /**
     * test with the following elements: 3, 5, 6, 8, 9
     *
     * @param    aStorageInterfaceInteger      the binary search tree to store Integers
     */

    public static void testIntegerWithTheStructureOfTheTree3(StorageInterface<Integer> aStorageInterfaceInteger)	{
        aStorageInterfaceInteger.add(3);
        aStorageInterfaceInteger.add(6);
        aStorageInterfaceInteger.add(9);
        aStorageInterfaceInteger.add(5);
        aStorageInterfaceInteger.add(8);
        aStorageInterfaceInteger.add(Integer.valueOf(10));
        System.out.println("aStorageInterfaceInteger: " + aStorageInterfaceInteger);
        System.out.println(aStorageInterfaceInteger.find(5));
        System.out.println(aStorageInterfaceInteger.find(-1));
        aStorageInterfaceInteger.delete(5);
        System.out.println("aStorageInterfaceInteger: " + aStorageInterfaceInteger);
        aStorageInterfaceInteger.delete(Integer.valueOf(0));
        aStorageInterfaceInteger.delete(1);
        aStorageInterfaceInteger.delete(10);
        System.out.println("aStorageInterfaceInteger: " + aStorageInterfaceInteger);
    }

    /**
     * test with the following elements: 3, 4, 5, 10
     *
     * @param    aStorageInterfaceInteger      the binary search tree to store Integers
     */

    public static void testIntegerWithTheStructureOfTheTree4(StorageInterface<Integer> aStorageInterfaceInteger)	{
        aStorageInterfaceInteger.add(10);
        aStorageInterfaceInteger.add(5);
        aStorageInterfaceInteger.add(4);
        aStorageInterfaceInteger.add(3);
        System.out.println("aStorageInterfaceInteger: " + aStorageInterfaceInteger);
        aStorageInterfaceInteger.delete(5);
        System.out.println("aStorageInterfaceInteger: " + aStorageInterfaceInteger);
        aStorageInterfaceInteger.add(Integer.valueOf(5));
        System.out.println("aStorageInterfaceInteger: " + aStorageInterfaceInteger);
    }

    /**
     * test with the following elements: 11, 12, 13, 14
     *
     * @param    aStorageInterfaceInteger      the binary search tree to store Integers
     */

    public static void testIntegerWithTheStructureOfTheTree5(StorageInterface<Integer> aStorageInterfaceInteger)	{
        aStorageInterfaceInteger.add(14);
        aStorageInterfaceInteger.add(13);
        aStorageInterfaceInteger.add(12);
        aStorageInterfaceInteger.add(11);
        aStorageInterfaceInteger.add(Integer.valueOf(100));
        System.out.println("aStorageInterfaceInteger: " + aStorageInterfaceInteger);
        aStorageInterfaceInteger.delete(5);
        System.out.println("aStorageInterfaceInteger: " + aStorageInterfaceInteger);
        aStorageInterfaceInteger.add(Integer.valueOf(1000));
        System.out.println("aStorageInterfaceInteger: " + aStorageInterfaceInteger);
    }

    /**
     * test with the following elements: 3, 5, 6, 7, 8, 9, 10
     *
     * @param    aStorageInterfaceInteger      the binary search tree to store Integers
     */

    public static void testIntegerWithTheStructureOfTheTree6(StorageInterface<Integer> aStorageInterfaceInteger)	{
        aStorageInterfaceInteger.add(10);
        aStorageInterfaceInteger.add(5);
        aStorageInterfaceInteger.add(7);
        aStorageInterfaceInteger.add(6);
        aStorageInterfaceInteger.add(8);
        System.out.println("aStorageInterfaceInteger: " + aStorageInterfaceInteger);
        aStorageInterfaceInteger.delete(5);
        System.out.println("aStorageInterfaceInteger: " + aStorageInterfaceInteger);
        aStorageInterfaceInteger.delete(Integer.valueOf(10));
        System.out.println("aStorageInterfaceInteger: " + aStorageInterfaceInteger);
    }

    /**
     * test with the following elements: null
     *
     * @param    aStorageInterfaceInteger      the binary search tree to store Integers
     */

    public static void testIntegerWithTheStructureOfTheTreeWithNll1(StorageInterface<Integer> aStorageInterfaceInteger)	{
        aStorageInterfaceInteger.add(null);
        System.out.println("aStorageInterfaceInteger: " + aStorageInterfaceInteger);
        aStorageInterfaceInteger.delete(null);
        aStorageInterfaceInteger.delete(null);
        System.out.println("aStorageInterfaceInteger: " + aStorageInterfaceInteger);
    }

    /**
     * test with the following elements: null, null, null, null, null, null
     *
     * @param    aStorageInterfaceInteger      the binary search tree to store Integers
     */

    public static void testIntegerWithTheStructureOfTheTreeWithNll2(StorageInterface<Integer> aStorageInterfaceInteger)	{
        aStorageInterfaceInteger.add(null);
        aStorageInterfaceInteger.add(null);
        aStorageInterfaceInteger.add(null);
        aStorageInterfaceInteger.add(null);
        aStorageInterfaceInteger.add(null);
        aStorageInterfaceInteger.add(null);
        System.out.println("aStorageInterfaceInteger: " + aStorageInterfaceInteger);
        System.out.println(aStorageInterfaceInteger.delete(5));
        System.out.println("aStorageInterfaceInteger: " + aStorageInterfaceInteger);
        aStorageInterfaceInteger.delete(Integer.valueOf(10));
        System.out.println("aStorageInterfaceInteger: " + aStorageInterfaceInteger);
        aStorageInterfaceInteger.delete(null);
        aStorageInterfaceInteger.delete(null);
        aStorageInterfaceInteger.delete(null);
        aStorageInterfaceInteger.delete(null);
        System.out.println("aStorageInterfaceInteger: " + aStorageInterfaceInteger);
        aStorageInterfaceInteger.delete(null);
        System.out.println(aStorageInterfaceInteger.delete(null));
        System.out.println("aStorageInterfaceInteger: " + aStorageInterfaceInteger);
        System.out.println(aStorageInterfaceInteger.delete(null));
        System.out.println(aStorageInterfaceInteger.delete(null));
        System.out.println("aStorageInterfaceInteger: " + aStorageInterfaceInteger);
    }

    /**
     * test with the following elements: null, null, null, null, null, 5, 10, 11, 12
     *
     * @param    aStorageInterfaceInteger      the binary search tree to store Integers
     */

    public static void testIntegerWithTheStructureOfTheTreeWithNll3(StorageInterface<Integer> aStorageInterfaceInteger)	{
        aStorageInterfaceInteger.add(null);
        aStorageInterfaceInteger.add(null);
        aStorageInterfaceInteger.add(null);
        aStorageInterfaceInteger.add(10);
        aStorageInterfaceInteger.add(null);
        aStorageInterfaceInteger.add(11);
        aStorageInterfaceInteger.add(null);
        aStorageInterfaceInteger.add(12);
        aStorageInterfaceInteger.add(null);
        System.out.println("aStorageInterfaceInteger: " + aStorageInterfaceInteger);
        aStorageInterfaceInteger.delete(Integer.valueOf(10));
        System.out.println(aStorageInterfaceInteger.delete(null));
        System.out.println("aStorageInterfaceInteger: " + aStorageInterfaceInteger);
        System.out.println(aStorageInterfaceInteger.delete(11));
        System.out.println(aStorageInterfaceInteger.delete(1000));
        System.out.println("aStorageInterfaceInteger: " + aStorageInterfaceInteger);
        System.out.println(aStorageInterfaceInteger.includesNull());
    }

    public static void testIntegerWithTheStructureOfTheTreeWithNll4(StorageInterface<Integer> aStorageInterfaceInteger)	{
//        aStorageInterfaceInteger.add(null);
        System.out.println("aStorageInterfaceInteger: " + aStorageInterfaceInteger);
        System.out.println(aStorageInterfaceInteger.find(null));
        aStorageInterfaceInteger.delete(null);
        System.out.println("aStorageInterfaceInteger: " + aStorageInterfaceInteger);
    }

    /**
     * the main program to test
     *
     * @param    args      commend line arguments, ignored
     */

    public static void main(String args[] )	{
        StorageInterface<String> aStorageInterfaceString = new SortedStorage<String>();
        StorageInterface<Integer> aStorageInterfaceInteger = new SortedStorage<Integer>();
//        testStringBuild(aStorageInterfaceString);
//        testIntegerWithTheStructureOfTheTree1(aStorageInterfaceInteger);
//        testIntegerWithTheStructureOfTheTree2(aStorageInterfaceInteger);
//        testIntegerWithTheStructureOfTheTree3(aStorageInterfaceInteger);
//        testIntegerWithTheStructureOfTheTree4(aStorageInterfaceInteger);
//        testIntegerWithTheStructureOfTheTree5(aStorageInterfaceInteger);
//        testIntegerWithTheStructureOfTheTree6(aStorageInterfaceInteger);
//        testIntegerWithTheStructureOfTheTreeWithNll1(aStorageInterfaceInteger);
//        testIntegerWithTheStructureOfTheTreeWithNll2(aStorageInterfaceInteger);
        testIntegerWithTheStructureOfTheTreeWithNll3(aStorageInterfaceInteger);
//        testIntegerWithTheStructureOfTheTreeWithNll4(aStorageInterfaceInteger);
    }
}
