/*
 * Coins.java
 *
 * Version:
 *     $1.1$
 *
 * Revisions:
 *     $adapt to homework 2.1 on 8/29/2020$
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

// The method to deal with cashier's coins to negate all their coins and combine them with my coins in the same array,
// and remained work is just to generate all subsets of the new array to see if a bill can be paid off.
// We update the minimum subset and its length everytime we see another smaller one

// test cases: {coins}, {cashiersCoins}, {toPay}
// {}, {}, {}, one of them is empty
// {1, 5}, {1, 2}, {6}
// {1, 1, 1, 1, 1, 5}, {1, 1, 1, 3}, {7}
// {1, 1, 1, 1, 1, 5}, {3, 1, 1, 2}, {6, 7, 100}

/**
 * This program uses coins to pay off a bill,
 * if the sum of several coins exactly equals a bill, the bill can be paid off and print the output;
 * if not, the bill can't be paid off and print the corresponding output.
 *
 * @author      Xiaoyu  Tongyang, or call me sora sor short
 */

public class Coins {
    static int[] coins = {  1, 1, 5, 1, 1, 1 };       // coins used to pay off bills
    static int coinsLength = coins.length;            // length of coins
    static int[] cashiersCoins = { 3, 2, 1, 1 };      // cashier's coins
    static int cashierCoinsLength = cashiersCoins.length; // number of coins the cashier has
    static int combinedCoinsLength = coinsLength + cashierCoinsLength;   // number of coins in combinedCoins
    static int[] combinedCoins = new int[combinedCoinsLength];           // the coins from mine and cashier's
    static int[] toPay = { 7, 6, 100 };                         // bills needed to be paid off
    static int toPayLength = toPay.length;                 // length of toPay
    static int[] ans = new int[combinedCoinsLength];       // array used to store a subset of coins
    static int idxWritten = 0;                             // index of ans
    static int[] minAns = new int[combinedCoinsLength];    // array used to store the maximum subset that can pay off a certain bill
    static int minLen = 0;                                 // length of maxAns
    static int numberOfMyCoins = 0;                        // number of my coins used to pay off a bill
    static int numberOfCashierCoins = 0;                   // number of cashier's coins used to give back to me
    static int minCoins = combinedCoinsLength;             // minimum number of coins in my wallet after paying off a bill

    /**
     * initialize an array to store all coins from my wallet and cashier's
     */

    public static void initializeCombinedCoins() {
        int index = 0;

        // combine my coins
        for ( int i = 0; i < coinsLength; i++ ) {
            combinedCoins[index++] = coins[i];
        }

        // combine cashier's coins
        for ( int i = 0; i < cashierCoinsLength; i++ ) {
            combinedCoins[index++] = -cashiersCoins[i];
        }
    }

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
     * in order to pay off a bill, how many my coins and cashier's coins were used, separately
     */

    public static void calculateNumberOfMyCoinsAndCashierCoins() {
        numberOfCashierCoins = numberOfMyCoins = 0;

        for ( int i = 0; i < idxWritten; i++ ) {
            if ( ans[i] > 0 ) {
                numberOfMyCoins++;
            }
            else {
                numberOfCashierCoins++;
            }
        }
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
        // when a subset can pay off a bill,
        // we need to check there is minimum number of coins in wallet
        if ( idxWritten == k && checkIfPayOff( k, idxOfToPay ) ) {
            calculateNumberOfMyCoinsAndCashierCoins();
            // number of coins in my wallet now
            int minCoinsNow = coinsLength - numberOfMyCoins + numberOfCashierCoins;

            // update minLen and minCoins when we have less coins in my wallet at this point
            if ( minCoinsNow < minCoins ) {
                System.arraycopy(ans, 0, minAns, 0, k);
                minLen = k;
                minCoins = minCoinsNow;
            }

            return;
        }

        for ( int i = idx; i < combinedCoinsLength; i++ ) {
            ans[idxWritten++] = combinedCoins[i]; // write the element at idx to the position of ans at idxWritten
            generateAllSubset(i + 1, k, idxOfToPay );
            idxWritten--; // discard the last element in the ans
        }
    }

    /**
     * print all elements in a subset satisfying the prerequisite mentioned in method checkIfPayOff
     */

    public static void printAnsWithCents() {
        // get the number of my coins
        numberOfMyCoins = 0;
        for (int i = 0; i < minLen && minAns[i] > 0; i++) {
            numberOfMyCoins++;
        }

        int idx = 0;
        // print my coins
        System.out.print("I gave the cashier the following coins ");
        for ( ; idx < numberOfMyCoins; idx++ ) {
            System.out.print(minAns[idx]);
            System.out.print(" cents ");
        }
        System.out.println();

        if (idx >= minLen) return; // Not use any cashier's coins
        // print cashier's coins
        System.out.print("\t\t and the cashier gave me ");
        for ( ; idx < minLen; idx++ ) {
            System.out.print(-minAns[idx]);
            System.out.print(" cents ");
        }
        System.out.println();
    }

    /**
     * print an output, if a bill can be paid off or not
     */

    public static void printAnswer( int idx ) {
        System.out.print(toPay[idx]);
        System.out.print(" cents: ");

        // a bill is 0, can't be paid with any coins
        if ( toPay[idx] == 0 ) {
            System.out.println("There is need to pay off this bill");
            return;
        }

        // there is no answer for a bill when the minLen is 0, no match at all
        if ( minLen == 0 ) {
            System.out.println("no; can not be paid with my coins and cashier's coins");
            return;
        }

        printAnsWithCents();
    }

    /**
     * The main program that checks all subsets of coins and prints outputs
     *
     * @param    args    command line arguments (ignored)
     */

    public static void main( String[] args ) {
        initializeCombinedCoins();
        System.out.println("% java Coins");

        // go through all the bills in toPay
        for ( int idx = 0; idx < toPayLength; idx++ ) {
            // go through all subsets of coins in combinedCoins
            for ( int k = 1; k <= combinedCoinsLength; k++ ) {
                generateAllSubset(0, k, idx);
            }
            printAnswer(idx);

            // need to check next bill, so let idxWritten, maxLen and minCoins be their default value
            idxWritten = 0;
            minLen = 0;
            minCoins = combinedCoinsLength;
        }
    }
}
