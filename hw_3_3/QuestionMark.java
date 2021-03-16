package hw_3_3;

/*
 * QuestionMark.java
 *
 * Version:
 *     $1.0$
 *
 * Revisions:
 *     $Log$
 */

/**
 * This program does exactly what hw 3.3 requires
 *
 * @author      Xiaoyu  Tongyang, or call me sora sor short
 */

public class QuestionMark {

    /**
     * find which number is greater
     *
     * @param a    number needed to operate on
     * @param b    number needed to operate on
     * */

    public static boolean aGreaterB(int a, int b)	{
        return a > b;
    }

    /**
     * find the maximum number in 2 numbers
     *
     * @param a    number needed to operate on
     * @param b    number needed to operate on
     * */

    public static int findMaximum(int a, int b)	{
        return a > b ? a : b;
    }

    /**
     * find the maximum number in 4 numbers
     *
     * @param a    number needed to operate on
     * @param b    number needed to operate on
     * */

    // 这里可以用函数重载findMaximum
    public static int findMaximum(int a, int b, int c, int d)	{
        int maxAandB = a > b ? a : b;
        int maxCandD = c > d ? c : d;
        return maxAandB > maxCandD ? maxAandB : maxCandD;
    }

    /**
     * if a equals 0, return 0; otherwise, return a / b when b doesn't equal 0 or return -1 when b equals 0
     *
     * @param a    number needed to operate on
     * @param b    number needed to operate on
     * */

    public static int leftToRight(int a, int b)	{
        return a == 0 ? 0 : ( b == 0 ? -1 : a / b);
    }

    public static void main( String[] args ) {
        int a = 5;
        int b = 1;
        int c = 2;
        int d = 1;
        System.out.println("aGreaterB(" + a + "," + b + ") = " + aGreaterB(a, b ) );
        System.out.println("findMaximum(" + a + "," + b + ") = " + findMaximum(a, b ) );
        System.out.println("findMaximum(" + a + ", " + b + ", " + c + ", " + d + " ) = " +
                findMaximum(a, b, c, d ) );
        a = 0;
        b = 0;
        System.out.println("leftToRight(" + a++ + "," + b++ + ") = " + leftToRight(a, b ) );
        System.out.println("leftToRight(" + --a + "," + b + ") = " + leftToRight(a, b ) );
    }
}