/*
 * Palindrome.java
 *
 * Version:
 *     $1.0$
 *
 * Revisions:
 *     $Log$
 */

/**
 * This program finds a number that has the following property:
 * check the number is delayed number or not within MAXIMUM_DELAYED
 *
 * @author      Xiaoyu  Tongyang, or call me sora sor short
 * @author      Chenxuan Li
 */

public class Palindrome {
    static int Start = 0;
    static int MAXIMUM = 100;
    static int MAXIMUM_DELAYED = 3;

    /**
     * add zero at the front of a string to match the number of digits of its Palindromic one
     *
     * @param    str2          string needed to add zero at the front of it
     * @param    difference    how many zeros do need to be added
     */

    public static void addZero(StringBuilder str2, int difference) {
        str2.reverse();
        for ( int i = 0; i < difference; i++ ) {
            str2.append('0');
        }
        str2.reverse();
    }

    /**
     * check whether two numbers have the same number of digits
     *
     * @param    strPrintNum        number needed to check
     * @param    strPrintRevNum     the other number needed to check
     */

    public static void checkHaveSameDigits( StringBuilder strPrintNum, StringBuilder strPrintRevNum ) {
        int difference = strPrintNum.length() - strPrintRevNum.length();

        if (difference > 0) {
            addZero(strPrintRevNum, difference);
            return;
        }

        addZero(strPrintNum, difference);
    }

    /**
     * reverse the input number
     *
     * @param    n        Number needed to reverse
     * @return   rev      Number after reversing
     */

    public static int reverseNum( int n ){
        StringBuilder midString = new StringBuilder();
        midString.append(n);   //converse int n to StringBuilder n
        midString.reverse();
        String revStr = midString.toString();
        int rev = Integer.valueOf(revStr);
        return rev;
    }

    /**
     * print the delayed time and delayed number and so on
     *
     * @param    num        Numbers to check
     */

    public static void printResult( int num ) {
        int origiNum = num;   // get the Number start status for print use
        for ( int delay = 1; delay <= MAXIMUM_DELAYED; delay++ ) {
            int revNum = reverseNum( num );    // get the Number start one step before status for print use
            int printRevNum = revNum;    // get the reverse Number one step before status for print use
            int printNum = num;

            num = num + revNum;
            revNum = reverseNum( num );

            // see if printRevNum and printNum have the same number of digits
			// 这里重复了，前面reverseNum里面已经有原数字和reversed one的字符串副本了
            StringBuilder strPrintNum = new StringBuilder(String.valueOf(printNum));
            StringBuilder strPrintRevNum = new StringBuilder(String.valueOf(printRevNum));
            checkHaveSameDigits(strPrintNum, strPrintRevNum);

            if( revNum == num ){
                System.out.println( origiNum + ":     " + "delayed " + delay + ":  " + strPrintNum + " + " + strPrintRevNum + " = " + num );
                break;
            }

            if( delay == MAXIMUM_DELAYED && revNum != num ){
                System.out.println( origiNum + ":     delayed " + delay + ":  does not become palindromic within "
                        + delay +  " iterations (" + strPrintNum + " + " + strPrintRevNum + " = " + num + ":  " + num + " != "
                        + revNum + ")" );

            }
        }
    }

    /**
     * The main program that prints results
     *
     * @param    args    command line arguments (ignored)
     */

    public static void main( String[] args ){
        for( int num = Start; num <= MAXIMUM ; num++ ){
            printResult(num);
        }
    }
}

