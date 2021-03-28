/*
 * NumberCounter.java
 *
 * Version:
 *     $1.0$
 *
 * Revisions:
 *     $LOG$
 */

package hw_8_1;

import java.io.*;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipException;

/**
 * This program does what exactly hw 8.1 requires
 *
 * @author       Xiaoyu  Tongyang, or call me sora for short
 */

public class NumberCounter {
    private static final int[] distribution = new int[80]; // array to store numbers

    /**
     * read from stdin, gzipped or file
     *
     * @param    filename      name of a file to read from
     * @return                 InputStream to read from
     */

    public static InputStream getInputStream(String filename) {

        // try to read from gzipped
        try {
            return new GZIPInputStream( new FileInputStream(filename) );
        }
        catch ( ZipException e)	{

            // the input file is not in the form of gzipped, try to read from a file
            try {
                return new FileInputStream(filename);
            }
            catch ( FileNotFoundException eInner)	{
                System.out.println("FileNotFoundException e");
                System.out.println(eInner.getMessage());
            }

            System.out.println("FileNotFoundException e");
            System.out.println(e.getMessage());
        } catch ( IOException e)	{
            System.out.println("IOException e");
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            // no file passed in, read from the standard input
            return System.in;
        }

        System.err.println("Canoot reach here");
        System.exit(1);
        return null;
    }

    /**
     *  a program which can determine the distribution of the numbers between 1 and 80 from the input stream
     *
     * @param    args      commend line arguments, args[0] means the file name passed in from the user
     */

    public static void main(String[] args) {
        String fileName = null;
        if ( args.length == 1 ) {
            fileName = args[0];
        }

		// 这个可以用三元表达式来做，先判断filename == null嘛？如果是，判断文件后缀名是不是gz；如果不是直接则getInputStream(filename)
		// 判断后缀名: fileName.endsWith(suffix);
		// https://docs.oracle.com/en/java/javase/14/docs/api/java.naming/javax/naming/Name.html#endsWith(javax.naming.Name)
        try ( InputStream in = new DataInputStream( getInputStream( fileName ) ) ) {
            Scanner sc = new Scanner(in);

            // store every number into the array
            sc.nextLine();
            while( sc.hasNextLine() ){
                String[] data = sc.nextLine().split(",");

                String[] numbers = data[data.length - 1].split(" ");

                for (String number : numbers) {
                    distribution[Integer.parseInt(number) - 1]++;
                }
            }

            // get the output string
            StringBuilder text = new StringBuilder();
            for (int i = 0; i < distribution.length; i++) {
                if (i != 0 && i % 4 == 0) {
                    text.append("\n");
                }

                text.append(i + 1).append(": ").append(distribution[i]).append("    ");
            }

            sc.close();
            System.out.println(text);
        } catch ( FileNotFoundException e)	{
            System.out.println("FileNotFoundException e");
             System.out.println(e.getMessage());
        } catch ( IOException e)	{
            System.out.println("IOException e");
            System.out.println(e.getMessage());
        } catch ( Exception e)	{
            System.out.println("ExceptionType occurred: " +
                    e.getMessage() );
        }
    }
}

