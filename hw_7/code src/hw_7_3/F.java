package hw_7_3;

/**
 * • This program does not compile as is. Why?
 * • Explain the execution of each method in writing. You have to name the file 27_3.txt
 *
 * */

public class F {

    private int noSystemExit()	 {
        try {
            throw new Exception("1");
        } catch (Exception e)	{
            System.out.println("2");
            return 0;
        } finally	{
            System.out.println("3 finally");
            return 1;
        }
    //        return 3; // unreachable statement
    }

    private int noExeption()	 {
        try {
            int x = 1 - 1;
            System.out.println("inside try: 1");
            return x;
        } catch (Exception e)	{
            System.out.println("inside catch: 2");
            return 1;
        } finally	{
            System.out.println("inside finally: 3 ");
            return 2;
        }
    }

    private int anExeption1()	 {
        int[] anArray  = new int[1];
        try {
            anArray[2] = 1 / 0;
            System.out.println("inside try: 1");
            return 0;
        } catch (ArithmeticException e)	{
            anArray[2] = 0;
            System.out.println("inside catch: 2");
            return 1;
        }
        finally	{
            System.out.println("inside finally: 3 ");
            return 2;
        }
        // return 3;
    }

    private int anExeption2()	 {
        int[] anArray  = new int[1];
        try {
            anArray[2] = 0;
            anArray[2] = 1 / 0;
            System.out.println("inside try: 1");
            return 0;
        } catch (ArithmeticException e)	{
            System.out.println("inside catch: 2");
            return 1;
        } finally	{
            System.out.println("inside finally: 3 ");
            return 2;
        }
        // return 3;
    }

    private void withSystemExit()	 {
        try {
            throw new Exception("4");
        } catch (Exception e)	{
            System.out.println("5");
            System.exit(0);
        } finally	{
            System.out.println("6 finally");
        }
        System.out.println("exit(): you will not see this line");	// not exectuted
    }

    public static void main(String[] args) {
        int r = new F().noSystemExit();
        System.out.println(new F().noSystemExit()); // 1
        System.out.println(new F().noExeption()); // 2
        System.out.println(new F().anExeption1()); // 2
        System.out.println(new F().anExeption2()); // 2
        new F().withSystemExit();
    }
}