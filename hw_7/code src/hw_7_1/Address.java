/*
 * Address.java
 *
 * Version:
 *     $1.0$
 *
 * Revisions:
 *     $0.0$
 */

package hw_7_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This program does what exactly hw 7.1 requires
 *
 * @author      Xiaoyu  Tongyang, or call me sora sor short
 */

public class Address implements Comparable<Address> {
    private int number;         // number of the Address
    private String street;      // street of the Address
    private String city;        // city of the Address
    private String district;    // district of the Address
    private int postalCode;     // postalCode of the Address

    /**
     * the constructor that create a given Address with its number, street, city, district and postal Code;
     * no default constructor provided, so cannot create an empty Address.
     *
     * @param    number      number of a given Address
     * @param    street      street of a given Address
     * @param    city        city of a given Address
     * @param    district    district of a given Address
     * @param    postalCode  postal Code of tracks of a given Address
     */

    public Address(int number, String street, String city, String district, int postalCode) {
        if ( number < 0 ) {
            System.err.println("number must be non-negative! Failed to create an Address");
            System.exit(1);
        }

        if ( postalCode < 0 ) {
            System.err.println("postalCode must be non-negative! Failed to create an Address");
            System.exit(1);
        }

        this.number = number;
        this.street = street;
        this.city = city;
        this.district = district;
        this.postalCode = postalCode;
    }

    /**
     * overridden method to compare two Addresses
     *
     * @param    aAddress     passed-in Address needed to compare
     * @return                Returns a negative integer, zero, or a positive integer as this Address is
     *                        less than, equal to, or greater than the passed-in Address.
     */

	// 可以直接用 toString().compareTo(aAddress.toString()) 来实现
    @Override
    public int compareTo( Address aAddress ) {
        // compare number, if get 0, which means the two Addresses are the same in terms of number,
        // and continue comparing other variables
        int result = Integer.compare(this.number, aAddress.getNumber());
        if ( result != 0 ) {
            return result;
        }

        // compare street
        result = this.street.compareTo(aAddress.getStreet());
        if ( result != 0 ) {
            return result;
        }

        // compare city
        result = this.city.compareTo(aAddress.getCity());
        if ( result != 0 ) {
            return result;
        }

        // compare district
        result = this.district.compareTo(aAddress.getDistrict());
        if ( result != 0 ) {
            return result;
        }

        // compare postal Code
        return Integer.compare(this.postalCode, aAddress.getPostalCode());
    }

    /**
     * get the Number Year of a given Address
     */

    public int getNumber() {
        return this.number;
    }

    /**
     * get the Postal Code of a given Address
     */

    public int getPostalCode() {
        return this.postalCode;
    }

    /**
     * get the City of a given Address
     */

    public String getCity() {
        return this.city;
    }

    /**
     * get the District of a given Address
     */

    public String getDistrict() {
        return this.district;
    }

    /**
     * get the Street of a given Address
     */

    public String getStreet() {
        return this.street;
    }


    /**
     * get a textual representation of the Address
     */

    public String toString() {
        return "Address: " + this.number + "/" + this.street +
                "/" + this.city + "/" + this.district + "/" + this.postalCode;
    }

    /**
     * The main program to test class Address.
     *
     * @param    args  command line arguments, ignored
     */

    public static void main( String[] args ) {
        Address aAddress = new Address(1600, "zennsylvania Avenue NW", "Washington", "DC", 20500);
        Address bAddress = new Address(1600, "wall Street", "New York", "NY", 10118);
        // Address bAddress = new Address(11, "Wall Street", "New York", "NY", 10118);
        Address cAddress = new Address(102, "Lomb Memorial Drive", "Rochester", "NY", 14623);
        Address dAddress = new Address(1, "A", "B", "C", 1);
        Address eAddress = new Address(2, "A", "B", "C", 1);
        Address fAddress = new Address(3, "A", "B", "C", 1);
        Address gAddress = new Address(4, "A", "B", "C", 1);

        Address hAddress = new Address(1, "A", "B", "C", 1);
        Address iAddress = new Address(1, "B", "C", "C", 1);
        Address jAddress = new Address(1, "B", "C", "D", 1);
        Address kAddress = new Address(1, "B", "C", "D", 2);
        Address mAddress = new Address(1, "B", "C", "D", 2);

        System.out.println( aAddress.compareTo(bAddress) );
        System.out.println( dAddress.compareTo(eAddress) );
        System.out.println( eAddress.compareTo(dAddress) );
        System.out.println( dAddress.compareTo(gAddress) );

        System.out.println( hAddress.compareTo(iAddress) );
        System.out.println( iAddress.compareTo(jAddress) );
        System.out.println( jAddress.compareTo(kAddress) );
        System.out.println( kAddress.compareTo(mAddress) );

        List<Address> aListOfAddresses 	= new ArrayList<Address>();
/*        aListOfAddresses.add( aAddress );
        aListOfAddresses.add( bAddress );
        aListOfAddresses.add( cAddress );
        aListOfAddresses.add( dAddress );
        aListOfAddresses.add( eAddress );
        aListOfAddresses.add( fAddress );
        aListOfAddresses.add( gAddress );*/

        aListOfAddresses.add( hAddress );
        aListOfAddresses.add( iAddress );
        aListOfAddresses.add( jAddress );
        aListOfAddresses.add( kAddress );
        aListOfAddresses.add( mAddress );

        Collections.sort(aListOfAddresses);
        System.out.println(aListOfAddresses);
    }
}
