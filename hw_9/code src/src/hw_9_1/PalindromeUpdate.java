/*
 * PalindromeUpdate.java
 *
 * Version:
 *     $1.0$
 *
 * Revisions:
 *     $Log$
 */

package hw_9_1;

/**
 * This program does what hw 9.1 requires
 *
 * @author      Xiaoyu  Tongyang, or call me sora for short
 * @author      Chenxuan Li
 */

public class PalindromeUpdate extends Thread {
    private static final int Start = 78;                // minimum number to check
    private static final int MAXIMUM = 88;              // maximum number to check
    private static final int MAXIMUM_DELAYED = 10;      // number of delays
    private static PalindromeUpdate[] threads;          // array to store every threads
    private int number;                                 // number needed to check in this thread
    private final int originalNumber;                   // copy of the number

    /**
     * constructor with the number needed to test in this thread
     * Note that no default constructor provided
     *
     * @param    number          number needed to test
     */

    public PalindromeUpdate(int number) {
        this.originalNumber = this.number = number;
    }

    /**
     * add zero at the front of a string to match the number of digits of its Palindromic one
     *
     * @param    str2          string needed to add zero at the front of it
     * @param    difference    how many zeros do need to be added
     */

    private void addZero(StringBuilder str2, int difference) {
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
     * print the delayed time and delayed number and so on
     */

    public void run() {
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
				// 老师的方法是：再用一个数组存储output，然后每个thread存储有存放的index，但最后还是要用join等待所有的threads结束运行
                // -------Major Modification-------
                // the major part of code to get what the hw 9.1 requires done
                try {
                    if ( this.originalNumber - Start > 0 )
                        threads[this.originalNumber - Start - 1].join();
                } catch (InterruptedException e) {
                    System.out.println("Interrupted!");
                }
                // -------Major Modification-------

                System.out.println( origiNum + ":     " + "delayed " + delay + ":  " + strPrintNum + " + " +
                        strPrintRevNum + " = " + this.number );
                break;
            }

            if( delay == MAXIMUM_DELAYED && revNum != this.number ){
                // -------Major Modification-------
                // the major part of code to get what the hw 9.1 requires done
                try {
                    if ( this.originalNumber - Start > 0 )
                        threads[this.originalNumber - Start - 1].join();
                } catch (InterruptedException e) {
                    System.out.println("Interrupted!");
                }
                // -------Major Modification-------

                System.out.println( origiNum + ":     delayed " + delay + ":  does not become palindromic within "
                        + delay +  " iterations (" + strPrintNum + " + " + strPrintRevNum + " = " + this.number + ":  "
                        + this.number + " != " + revNum + ")" );
            }
        }
    }

    /**
     * initialize the array to store each thread and call their start() method
     */

    public static void initializeArray() {
        threads = new PalindromeUpdate[MAXIMUM - Start + 1];

        for( int num = Start; num <= MAXIMUM ; num++ ){
            threads[num - Start] = new PalindromeUpdate(num);
            threads[num - Start].start();
        }
    }

    /**
     * The main program that prints results
     *
     * @param    args    command line arguments (ignored)
     */

    public static void main( String[] args ){
        initializeArray();
    }
}

