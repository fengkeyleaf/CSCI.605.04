/*
 * PalindromeUpdate.java
 *
 * Version:
 *     $1.1$
 *
 * Revisions:
 *     $adapted to hw 9.3 on 10/23/2020$
 */

package hw_9_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * This program does what hw 9.3 requires
 *
 * @author      Xiaoyu  Tongyang, or call me sora for short
 * @author      Chenxuan li
 */

public class PalindromeUpdate extends Thread {
    private static final int Start = 78;                // minimum number to check
    private static final int MAXIMUM = 200;             // maximum number to check
    private static final int MAXIMUM_DELAYED = 10;      // number of delays
    private static PalindromeUpdate[] threads;          // array to store every threads
    private int number;                                 // number needed to check in this thread
    private static int numberOfThreads;                 // how many threads we will use to read file
    private static int numberPerThread;                 // numbers processed by per thread
    private final int start;                            // first number processed by a certain thread
    private final int end;                              // last number processed by a certain thread
    private static final List<Result> theResults        // synchronized list to store results from each thread
            = Collections.synchronizedList( new ArrayList<Result>() );

    /**
     * constructor with a range of numbers needed to test in this thread
     * Note that no default constructor provided
     *
     * @param    start      first line read by this thread
     * @param    end        last line read by this thread
     */

    public PalindromeUpdate(int start, int end) {
        this.start = start;
        this.end = end;
    }

    /**
     * inner class to store the output of a given number
     */

    class Result implements Comparable<Result> {
        private final String output; // output in the form of string
        private int number;          // the original number of the output

        /**
         * constructor to create an instance of Result with its output and number
         * Note that no default constructor provided
         *
         * @param    output        output in the form of string
         * @param    number        the original number of the output
         */

        public Result(String output, int number) {
            this.output = output;
            this.number = number;
        }

        /**
         * get the original number
         */

        public int getNumber() {
            return this.number;
        }

        /**
         * method to make this class comparable
         */

        @Override
        public int compareTo(Result aResult) {
            return Integer.compare(number, aResult.getNumber());
        }

        /**
         * get a textual representation of this class
         */

        @Override
        public String toString() {
            return this.output;
        }
    }

    /**
     * add zero at the front of a string to match the number of digits of its Palindromic one
     *
     * @param    str2          string needed to add zero at the front of it
     * @param    difference    how many zeros do need to be added
     */

    private void addZero(StringBuilder str2, int difference) {
        str2.reverse();
        str2.append("0".repeat(Math.max(0, difference)));
        str2.reverse();
    }

    /**
     * check whether two numbers have the same number of digits
     *
     * @param    strPrintNum        number needed to check
     * @param    strPrintRevNum     the other number needed to check
     */

    private void checkHaveSameDigits( StringBuilder strPrintNum, StringBuilder strPrintRevNum ) {
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

    private int reverseNum( int n ){
        StringBuilder midString = new StringBuilder();
        midString.append(n);   //converse int n to StringBuilder n
        midString.reverse();
        String revStr = midString.toString();
        int rev = Integer.valueOf(revStr);
        return rev;
    }

    /**
     * method to check if a number is palindromic or not
     */

    private void checkPalindrome() {
        int origiNum = this.number;   // get the Number start status for print use
        for ( int delay = 1; delay <= MAXIMUM_DELAYED; delay++ ) {
            // get the Number start one step before status for print use
            int revNum = reverseNum( this.number );
            // get the reverse Number one step before status for print use
            int printRevNum = revNum;
            int printNum = this.number;

            this.number = this.number + revNum;
            revNum = reverseNum( this.number );

            // see if printRevNum and printNum have the same number of digits
            StringBuilder strPrintNum = new StringBuilder(String.valueOf(printNum));
            StringBuilder strPrintRevNum = new StringBuilder(String.valueOf(printRevNum));
            checkHaveSameDigits(strPrintNum, strPrintRevNum);

            if( revNum == this.number ){
                String output = origiNum + ":     " + "delayed " + delay + ":  " + strPrintNum + " + " +
                        strPrintRevNum + " = " + this.number;
                // finish processing and store the result into the synchronized list
                theResults.add( new Result( output, origiNum ) );
                break;
            }

            if( delay == MAXIMUM_DELAYED && revNum != this.number ){
                String output = origiNum + ":     delayed " + delay + ":  does not become palindromic within "
                        + delay +  " iterations (" + strPrintNum + " + " + strPrintRevNum + " = " + this.number +
                        ":  " + this.number + " != " + revNum + ")" ;

                // finish processing and store the result into the synchronized list
                theResults.add( new Result( output, origiNum ) );
            }
        }
    }

    /**
     * method to start processing numbers from this.start to this.end,
     * in other words, the numbers stored in this thread
     */

    public void run() {
        // start processing numbers
        for (int i = this.start; i <= this.end; i++) {
            this.number = i;
            checkPalindrome();
        }
    }

    /**
     * print all results of all numbers from MAXIMUM to Start
     */

    public static void printOutput() {
        // guarantee to be thread safe when using iterator to iterate the synchronized list
        synchronized (theResults) {
            Iterator<Result> i = theResults.iterator();

            while ( i.hasNext() ) {
                System.out.println( i.next() );
            }
        }
    }

    /**
     * initialize the array to store each thread and call their start() method
     */

    public static void initializeArray() {
        threads = new PalindromeUpdate[numberOfThreads];

        int s = Start, e = Math.min(s + numberPerThread - 1, MAXIMUM);
        for( int num = 0; num < numberOfThreads ; num++ ){
            // the last thread need to process all remaining numbers
            if (num == numberOfThreads - 1)
                e = MAXIMUM;

            threads[num] = new PalindromeUpdate( s, e );
            threads[num].start();
            s += numberPerThread;
            e = Math.min(s + numberPerThread - 1, MAXIMUM);
        }
    }

    /**
     * The main program that prints results
     *
     * @param    args    command line arguments??? args[0] means how many threads will be used to process
     */

    public static void main( String[] args ) {
        if ( args.length != 1 ) {
            System.out.println("Invalid command line arguments!");
            return;
        }

        int numberOfNumber = MAXIMUM - Start + 1;
        numberOfThreads = Integer.parseInt(args[0]);
        // the number of threads must be valid or meaningful
        if (numberOfThreads < 1) {
            System.out.println("The number of threads must be positive!");
            return;
        } else if (numberOfThreads >= numberOfNumber) {
            numberOfThreads = numberOfNumber;
        }

        numberPerThread = numberOfNumber / numberOfThreads;

        initializeArray();

        // guarantee to be thread safe
        try {
            for (PalindromeUpdate p : threads)
                p.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted!");
        }

        // guarantee that the result is sorted
        // because even though the theResults is synchronized list,
        // the order of storing each output into the list
        // is not guaranteed to be sorted, it could be in disorder
        Collections.sort( theResults );

        printOutput();
    }
}

