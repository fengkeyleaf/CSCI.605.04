/*
 * TestInterfaceImplementation .java
 *
 * Version:
 *     $1.0$
 *
 * Revisions:
 *     $LOG$
 */

package hw_7_2;

import hw_7_1.Address;
import hw_7_1.LP;

/**
 * This program does what exactly hw 7.2 requires
 *
 * @author      Xiaoyu  Tongyang, or call me sora sor short
 */

public class TestInterfaceImplementation {
    public static void testStringSet(StorageInterface<String> aStorageInterfaceString)	{

        String three = new String("3");

        System.out.println("add(null) " + aStorageInterfaceString.add(null));
        System.out.println("add(null) " + aStorageInterfaceString.add(null));
        System.out.println("add(3) " + aStorageInterfaceString.add("3"));
        System.out.println("add(three) " + aStorageInterfaceString.add(three));
        System.out.println("add(1) " + aStorageInterfaceString.add("1"));
        System.out.println("add(2) " + aStorageInterfaceString.add("2"));
        System.out.println("add(2) " + aStorageInterfaceString.add("2"));
        System.out.println("1." + aStorageInterfaceString);
    }

    public static void testStringBuild(StorageInterface<String> aStorageInterfaceString)	{

        String three = new String("3");

        aStorageInterfaceString.add(null);
        aStorageInterfaceString.add(null);
        aStorageInterfaceString.add("3");
        aStorageInterfaceString.add(three);
        aStorageInterfaceString.add("1");
        aStorageInterfaceString.add("2");
        System.out.println("1." + aStorageInterfaceString);
    }

    public static void testStringManipulate(StorageInterface<String> aStorageInterfaceString)	{
        System.out.println("aStorageInterfaceString.find(null) " + aStorageInterfaceString.find(null) );
        System.out.println("aStorageInterfaceString.delete(null) " + aStorageInterfaceString.delete(null) );
        System.out.println("aStorageInterfaceString.delete(1) " + aStorageInterfaceString.delete("1") );
        System.out.println("aStorageInterfaceString.delete(0) " + aStorageInterfaceString.delete("0") );
        System.out.println("2." + aStorageInterfaceString);
    }

    public static void testInteger(StorageInterface<Integer> aStorageInterfaceInteger)	{

//        aStorageInterfaceInteger.add(null);
        aStorageInterfaceInteger.add(null);
//        aStorageInterfaceInteger.add(Integer.valueOf("55"));
//        aStorageInterfaceInteger.add(Integer.valueOf("33"));
//        aStorageInterfaceInteger.add(Integer.valueOf("66"));
        System.out.println("aStorageInterfaceInteger: " + aStorageInterfaceInteger);
//        System.out.println(aStorageInterfaceInteger.delete(55));
//        System.out.println(aStorageInterfaceInteger.delete(66));
//        System.out.println(aStorageInterfaceInteger.delete(33));
        System.out.println(aStorageInterfaceInteger.delete(null));
        System.out.println("aStorageInterfaceInteger: " + aStorageInterfaceInteger);
    }

    public static void testAddress(StorageInterface<Address> aStorageInterfaceAddress)	{
        aStorageInterfaceAddress.add(  new Address(1600, "Pennsylvania Avenue NW", "Washington", "DC", 20500) );
        aStorageInterfaceAddress.add(  new Address(11, "Wall Street", "New York", "NY", 10118) );
        aStorageInterfaceAddress.add(  new Address(102, "Lomb Memorial Drive", "Rochester", "NY", 14623) );
        aStorageInterfaceAddress.add(  new Address(1, "A", "B", "C", 1) );
        System.out.println("aStorageInterfaceAddress: " + aStorageInterfaceAddress);
    }

    public static void testLP(StorageInterface<LP> aStorageInterfaceLP)	{
        LP aLP = new LP( 1960, "Deep Purple in Rock", "Deep Purple", (float)43.30, 7);
        LP bLP = new LP( 1973, "Dark Side of the Moon", "Pink Floyd ", (float)43.09, 10);
        LP cLP = new LP( 1, "A", "B ", (float)3, 4);
        LP dLP = new LP( 2, "A", "B ", (float)3, 4);
        LP eLP = new LP( 3, "A", "B ", (float)3, 4);
        LP fLP = new LP( 0, "A", "B ", (float)3, 4);
        aStorageInterfaceLP.add( aLP );
        aStorageInterfaceLP.add( dLP );
        aStorageInterfaceLP.add( bLP );
        aStorageInterfaceLP.add( cLP );
        aStorageInterfaceLP.add( eLP );
        aStorageInterfaceLP.add( fLP );
        System.out.println("aStorageInterfaceAddress: " + aStorageInterfaceLP);
    }

    public static void main(String args[] )	{
        StorageInterface<String> aStorageInterfaceString = new SortedStorage<String>();
        StorageInterface<Integer> aStorageInterfaceInteger = new SortedStorage<Integer>();
        StorageInterface<Address> aStorageInterfaceAddress = new SortedStorage<Address>();
        StorageInterface<LP> aStorageInterfaceLP = new SortedStorage<LP>();
        testStringBuild(aStorageInterfaceString);
        testStringSet(aStorageInterfaceString);
        testStringManipulate(aStorageInterfaceString);
        testInteger(aStorageInterfaceInteger);
        testAddress(aStorageInterfaceAddress);
        testLP(aStorageInterfaceLP);
    }
}
