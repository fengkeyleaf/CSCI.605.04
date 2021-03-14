/*
 * Coins.java
 *
 * Version:
 *     $1.0$
 *
 * Revisions:
 *     $Log$
 */

// There are tow main ideas for this algorithm:
// First, we take advantage of naive array to store a subset of k elements,
// but we have a problem, that is, how we use a fixed-length of array to present a subset with different elements?
// In order to settle it down, we initialize a pointer, e.g. an index. It has two meanings:
// 1. write an element to the position that the pointer is pointing to; 2. it means the length of the subset;
// For example, when the pointer is 0, we need to write an element at the position 0, and the length is 0.
// We have no elements in the subset at this point.

// Second, we utilize recursion to generate all subsets of k elements.
// In other words, we continue adding elements, for instance, at index i.
// The next thing we should do is to add the i + 1 element to a subset,
// and we have k elements in the subset when the pointer == k.

/**
 * This program uses coins to pay off a bill,
 * if the sum of several coins exactly equals a bill, the bill can be paid off and print the output;
 * if not, the bill can't be paid off and print the corresponding output.
 *
 * @author      Xiaoyu  Tongyang, or call me sora sor short
 */

public class Coins {
    static int[] coins = { 1, 1, 2, 5, 25, 25, 25 };       // coins used to pay off bills
    static int coinsLength = coins.length;                 // length of coins
    static int[] toPay = { 0, 1, 4, 5, 7, 8 };             // bills needed to be paid off
    static int toPayLength = toPay.length;                 // length of toPay
    static int[] ans = new int[coinsLength];    // array used to store a subset of coins
    static int idxWritten = 0;                  // index of ans
    static int[] maxAns = new int[coinsLength]; // array used to store the maximum subset that can pay off a certain bill
    static int maxLen = 0;                      // length of maxAns

    /**
     * add all coins in a subset together and check whether the sum equals a bill
     *
     * @param    len            length of a subset
     * @param    idxOfToPay     index of toPay
     * @return                  return true, meaning the bill at index idxOfToPay can be paid off;
     *                          return false, meaning the bill can't
     */

    public static boolean checkIfPayOff( int len, int idxOfToPay ) {
        int sum = 0;
        for ( int i = 0; i < len; i++ ) {
            sum += ans[i];
        }

        return sum == toPay[idxOfToPay];
    }

    /**
     * generate all possible subsets of k elements in it,
     * and then check if the sum of a subset can pay off a bill
     *
     * @param    idx            index of coins
     * @param    k              number of elements in a subset needed to reach
     * @param    idxOfToPay     index of toPay
     */
    public static void generateAllSubset( int idx, int k, int idxOfToPay ) {
        if ( idxWritten == k ) {
            // update maxAns when k is greater than the present maxLen and
            // the bill at idxOfToPay can be paid off
            if ( k > maxLen && checkIfPayOff( k, idxOfToPay )) {
                System.arraycopy(ans, 0, maxAns, 0, k);
                maxLen = k;
            }

            return;
        }

        for ( int i = idx; i < coinsLength; i++ ) {
            ans[idxWritten++] = coins[i]; // write the element at idx to the position of ans at idxWritten
            generateAllSubset(i + 1, k, idxOfToPay );
            idxWritten--; // discard the last element in the ans
        }
    }

    /**
     * print all the elements in coins
     */

    public static void printCoins() {
        System.out.print("[ ");

        for ( int i = 0; i < coinsLength; i++ ) {
            System.out.print(coins[i]);
            System.out.print(" ");
        }

        System.out.println("]");
    }

    /**
     * print all elements in a subset satisfying the prerequisite mentioned in method checkIfPayOff
     */

    public static void printAnsWithCents() {
        for ( int i = 0; i < maxLen; i++ ) {
            System.out.print(maxAns[i]);
            System.out.print(" cents ");
        }

        System.out.println();
    }

    /**
     * print an output, if a bill can be paid off or not
     */

    public static void printAnswer( int idx ) {
        System.out.print(toPay[idx]);
        System.out.print(" cents -- ");

        // a bill is 0, can't be paid with any coins
        if ( toPay[idx] == 0 ) {
            System.out.println("can not be paid");
            return;
        }

        // there is no answer for a bill when the maxLen is 0, no match at all
        if ( maxLen == 0 ) {
            System.out.print("no; can not be paid with the following sequence of coins: ");
            printCoins();
            return;
        }

        System.out.print("yes; used coins = ");
        printAnsWithCents();
    }

    /**
     * The main program that checks all subsets of coins and print outputs
     *
     * @param    args    command line arguments (ignored)
     */

    public static void main( String[] args ) {
        System.out.println("% java Coins");

        // go through all the bills in toPay
        for ( int idx = 0; idx < toPayLength; idx++ ) {
            // go through all subsets of coins
            for ( int k = 1; k <= coinsLength; k++ ) {
                generateAllSubset(0, k, idx);
            }
            printAnswer(idx);

            // need to check next bill, so let idxWritten and maxLen be 0
            idxWritten = 0;
            maxLen = 0;
        }
    }
}
