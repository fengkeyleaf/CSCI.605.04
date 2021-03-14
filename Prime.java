/*
* prime.java
*
* Version:
*     $1.0$
*
* Revision
*     $Log$
*/

import java.util.Arrays;

/**
 * This program print all number have following property:
 * the number itself is a prime number
 * if the number is more than one digit, remove its right digit and the new number is also a prime number,
 * repeating this process until there is one digit left.
 * input value is between 3 and 73939233
 *
 * @author      Xiaoyu  Tongyang, or call me sora sor short
 */
 
class Prime {
    /**
     * judge an integer is prime or not
     *
     * @param    n               number n for judgement
     * @param    memorization    array to store whether a number is prime or not
     * @return                   return true, if n is a prime;
     *                           return false, if n is not a prime
     */
	 
    public static boolean isPrime(int n, int[] memorization) {
        // check that n has been checked before
        if ( memorization[n] == 0 ) return false;
        else if ( memorization[n] == 1 ) return true;

        if( n < 2 ){
            memorization[n] = 0;
			return false;
		}
        else {
			// We only need to check from 2 to n square root
			// Suppose n % i == 0, which means n / i equals a certain integer m,
			// and i <= sqrt(n) and m >= sqrt(n)
			for ( int index = 2; index <= Math.sqrt(n); index++ ) {
				if (n % index == 0){
                    memorization[n] = 0;
					return false;
				}
			}

            memorization[n] = 1;
            return true;
		}	
    }
	
    /**
     * The main program.
     *
     * @param    args  command line arguments(ignored)
     */
	 
	public static void main (String args[]){
		int maxNum =  73939233; // the ending number to be checked
		int minNum = 3; // the starting number to be checked
        // array to store whether a number is prime or not;
        // -1 represents not checked yet; 0 represents not a prime; 1 represents a prime
        int[] memorization = new int[maxNum + 1];
        Arrays.fill(memorization, -1);

        for ( int x = minNum;x <= maxNum;x++ ) {
			for( int a = x; isPrime(a, memorization); a = a / 10 ){
				if( a / 10 == 0 ){
					System.out.println( x + " has the property" );
				}
			}

		}
	}
}