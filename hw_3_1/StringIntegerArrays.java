package hw_3_1;

/*
 * StringIntegerArrays.java
 *
 * Version:
 *     $1.0$
 *
 * Revisions:
 *     $Log$
 */

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * This program does exactly what hw 3.1 requires
 *
 * @author      Xiaoyu  Tongyang, or call me sora sor short
 */
 
public class StringIntegerArrays {

    /**
     * I. Determine if aString and bString are identical.
     *
     * @param aString    string needed to compare to be identical
     * @param bString    string needed to compare to be identical
     * */

    public static void aStringbStringIdentical(String aString, String bString) {
        System.out.printf("%-6s%b\n", "I.", aString.equals(bString));
    }

    /**
     * II. Determine if cString and dString are identical ignoring case differences.
     *
     * @param cString    string needed to compare to be identical
     * @param dString    string needed to compare to be identical
     * */

    public static void cStringdStringIdenticalIgnoringCase(String cString, String dString) {
		// negative - greater than, 0 - equals, positive - less than
        System.out.printf("%-6s%b\n", "II.", cString.compareToIgnoreCase(dString) == 0);
    }

    /**
     * III. Cutting out the the first character of aString and print it.
     *
     * @param str    string needed to operate on
     * */

    public static void cutOutFirst(String str) {
        System.out.printf("%-6s%c\n", "III.", str.charAt(0));
    }

    /**
     * IV. Cut out the the last two characters of aString and print it.
     *
     * @param str    string needed to operate on
     * */

    public static void cutOutLastTwo(String str) {
        System.out.printf("%-6s%c%c\n", "IV.", str.charAt(str.length() - 2), str.charAt(str.length() - 1));
    }

    /**
     * V. Cut out the string of cString from the beginning of the string to
     * the first occurrence of ’C’ including ’C’ and print it.
     *
     * @param str    string needed to operate on
     * @param ch     the character indicating the last index needed to cut out
     * */

    public static void cutOutFirstToChar(String str, char ch) {
        System.out.printf("%-6s%s\n", "V.", str.substring(0, str.indexOf(ch) + 1));
    }

    /**
     * VI. Cut out of dString from the first digit in aString and the last digit in aString and print it.
     *
     * @param aString    string needed to operate on
     * @param dString    string needed to operate on
     * */

    public static void cutOutFirstToLast(String aString, String dString) {
        System.out.printf("%-6s%s\n", "VI.", dString.substring(aString.charAt(0) - '0',
                                             aString.charAt(aString.length() - 1) - '0'));
    }

    /**
     * VII. Sort the characters in aString and cut out
     * from dString beginning with the lowest number to the second lowest number.
     *
     * @param aString    string needed to operate on
     * @param dString    string needed to operate on
     * */

    public static void curOutFromFirstLowestToSecondLowest(String aString, String dString) {
        char tempArray[] = aString.toCharArray();
        Arrays.sort(tempArray);
        char lowestCharacter = tempArray[0];

        String aStringSorted = Arrays.toString(tempArray);
        int index = aStringSorted.lastIndexOf(lowestCharacter);

        System.out.printf("%-6s%s\n", "VII.", dString.substring(lowestCharacter - '0', index + 1));
    }

    /**
     * VIII. Print eString in such a ways that the output is sorted.
     *
     * @param eString    string needed to operate on
     * */

    public static void eStringPrint(String eString) {
        char tempArray[] = eString.toCharArray();
        Arrays.sort(tempArray);

        System.out.printf("%-6s%s\n", "VIII.", new String(tempArray));
    }

    /**
     * IX. Determine if aString is part of eString.
     *
     * @param aString    string needed to operate on
     * @param eString    string needed to operate on
     * */

    public static void isSubString(String aString, String eString) {
        String subStringPattern = ".*" + aString + ".*";
        System.out.printf("%-6s%b\n", "IX.", Pattern.matches(subStringPattern, eString));
    }

    /**
     * X. Determine if dString is part of cString ignoring case differences.
     *
     * @param dString    string needed to operate on
     * @param cString    string needed to operate on
     * */

    public static void isSubStringIgnoringCase(String dString, String cString) {
        String dStringLower = ".*" + dString.toLowerCase() + ".*";
        String cStringLower = dString.toLowerCase();

        System.out.printf("%-6s%b\n", "X.", Pattern.matches(dStringLower, cStringLower));
    }

    public static void main( String args[] ) {
        String aString;
        String bString;
        String cString;
        String dString;
        String eString;

        System.out.println("% javac StringIntegerArrays.java");
        if ( args.length == 0 ) {
            aString = "2513";
            bString = "2513";
            cString = "ABCDECFG";
            dString = "abcDECFG";
            eString = aString + ( bString + cString ) + dString;

            System.out.println("% java StringIntegerArrays");
        }
        else {
            aString = "213";
            bString = "2513";
            cString = "ABCDECFGT";
            dString = "abcDECFG";
            eString = bString + ( bString + cString ) + dString;

            System.out.println("% java StringIntegerArrays useSecondSet");
        }

        aStringbStringIdentical(aString,bString); // I.
        cStringdStringIdenticalIgnoringCase(cString, dString); // II,
        cutOutFirst(aString); // III.
        cutOutLastTwo(aString); // IV.
        cutOutFirstToChar(cString, 'C'); // V
        cutOutFirstToLast(aString, dString); // VI
        curOutFromFirstLowestToSecondLowest(aString, dString); // VII
        eStringPrint(eString); // VIII
        isSubString(aString, eString); // IX
        isSubStringIgnoringCase(dString,cString); // X

    }
}
