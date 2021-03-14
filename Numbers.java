/*
 * Numbers.java
 *
 * Version:
 *     $1.0$
 *
 * Revisions:
 *     $Log$
 */

/**
 * This program finds a number that has the following property:
 * sum of each digit ^n is equal to the number.
 * The number is a sum of ’nth’ power of each digit of a n digit number is equal to n digit of a number
 *
 * @author      Xiaoyu  Tongyang, or call me sora sor short
 */

public class Numbers {

    /**
     * print the output from the number satisfying the property
     *
     * @param    str         string that stands for the number
     * @param    num         the original number in the form of integer type
     * @param    exponent    the exponent satisfying the property
     */

    public static void printAnswer( String str, int num, int exponent ) {
        System.out.print(num);
        System.out.print("  ==       ");
        System.out.print(num);
        System.out.println("  has the desired property");

        String contents = "  ";
        for ( int i = 0; i < str.length(); i++ ) {
            contents += str.charAt(i) + " ^ " + exponent + " + ";
        }

        contents = contents.substring(0, contents.length() - 3);
        contents += "\n";
        System.out.print(contents);
    }

    /**
     * check a string only contains '0' or '1'
     *
     * @param    str    string needed to be checked
     * @return          return true, str only contains character 0 or 1;
     *                  return false, str contains other characters
     */

    public static boolean onlyContainsOneOrZero( String str ) {
        for ( int i = 0; i < str.length(); i++ ) {
            if ( str.charAt(i) != '1' && str.charAt(i) != '0' ) return false;
        }

        return true;
    }

    /**
     * check a number has the property
     *
     * @param    i    number needed to be checked
     */

    public static void checkIfHasProperties( int i ) {
        // convert Integer to String
        Integer num = i;
        String str = num.toString();

        int exponent = 1;
        int sum = 0;
        boolean flag = onlyContainsOneOrZero(str);
        // continue checking whether a sum of 'exponent-th' power of each digit of i is equal to itself
        // until the sum is greater or equal to i
        // Note: if str only contains '0' or '1', the sum is always 1 and the while loop will never stop.
        // So if we encounter this situation, we need to stop looping
        while ( sum < i ) {
            sum = 0;

            for ( int idx = 0; idx < str.length(); idx++ ) {
                sum += Math.pow(str.charAt(idx) - '0', exponent); // str.charAt(idx) - '0', convert a char to integer
            }

            if ( Integer.compare(sum, i) == 0 ) {
                printAnswer(str, i, exponent);
            }

            if ( flag ) return;
            exponent++;
        }
    }

    /**
     * The main program that prints all numbers satisfying the property
     *
     * @param    args    command line arguments (ignored)
     */

    public static void main( String[] args ) {
        for ( int i = 1; i < 10000; i++ ) {
            checkIfHasProperties(i);
        }
    }
}
