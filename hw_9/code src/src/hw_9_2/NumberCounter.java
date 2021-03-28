/*
 * NumberCounter.java
 *
 * Version:
 *     $1.1$
 *
 * Revisions:
 *     $adapted to hw 9.2 on 10/23/2020$
 */

package hw_9_2;

import java.io.*;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipException;

/**
 * This program does what exactly hw 9.2 requires
 *
 * @author      Xiaoyu  Tongyang, or call me sora for short
 */

public class NumberCounter extends Thread {
    private static final int[] distribution = new int[80];        // array to store all numbers from the file
    private final int[] distributionOfEachThread = new int[80];   // array to store numbers from a thread
    private static NumberCounter[] threads;                       // array to store threads
    private static String fileName;                               // filename to read from
    private static int numberOfThreads;                           // how many threads we will use to read file
    private static final int lines = 12278 + 1;                   // total lines in the file, including the first line
    private static int linesPerThread;                            // lines read by per thread
    private final int start;                                      // first line read by a certain thread
    private final int end;                                        // last line read by a certain thread
    private final int index;                                      // index of threads(array)

    /**
     * constructor to create a NumberCounter with its starting line, ending line and index
     *
     * @param    start      first line read by this thread
     * @param    end        last line read by this thread
     * @param    index      index of threads(array)
     */

    public NumberCounter(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    /**
     * read from stdin, gzipped or file
     *
     * @param    filename      name of a file to read from
     * @return                 InputStream to read from
     */

    public static InputStream getInputStream(String filename) {

        // try to read from gzipped
        try {
            return new GZIPInputStream(new FileInputStream(filename));
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
     * print the output
     * */

    public static void printOutput() {
        // get the output string
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < distribution.length; i++) {
            if (i != 0 && i % 4 == 0) {
                text.append("\n");
            }

            text.append(i + 1).append(": ").append(distribution[i]).append("    ");
        }

        System.out.println(text);
    }

    /**
     * collect data from each thread and add them together
     * */

    private void collectDataFromEachThread() {
        for (int i = 0; i < this.distributionOfEachThread.length; i++) {
            distribution[i] += this.distributionOfEachThread[i];
        }
    }

    /**
     * read data from file and store them into the array
     * */

    public void run() {
        try ( InputStream in = new DataInputStream( getInputStream( fileName ) ) ) {
            Scanner sc = new Scanner(in);

            // skip lines that have been read from other threads
            for ( int i = 1; sc.hasNextLine() && i < this.start; i++ ) {
                sc.nextLine();
            }

            // store every number into the array
            for ( int i = this.start; sc.hasNextLine() && i <= this.end; i++ ) {
                String[] data = sc.nextLine().split(",");

                String[] numbers = data[data.length - 1].split(" ");

                for (String number : numbers) {
                    this.distributionOfEachThread[Integer.parseInt(number) - 1]++;
                }
            }

            sc.close();
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

        try {
            if ( this.index > 0 )
                threads[this.index - 1].join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted!");
        }

        // collect data from this thread
        collectDataFromEachThread();
    }

    /**
     * initialize the array to store threads and call their start() method
	 * 可以使用BufferRead里面的skip方法：
	 * BufferedReader input = new BufferedReader ( new InpuStreamReader( new FileInputStream( fileName) ) );
	 * input.skip(需要跳过的字符数)
	 * BufferedReader: public long skip​(long n) throws IOException
	 * https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/io/BufferedReader.html#skip(long)
     * */

    public static void initializeArray() {
        int s = 2, e = Math.min(s + linesPerThread - 1, lines);

        for( int num = 0; num < numberOfThreads ; num++ ){
            // the last thread need to process all remaining lines
            if (num == numberOfThreads - 1)
                e = lines;

            threads[num] = new NumberCounter(s, e, num);
            threads[num].start();
            s += linesPerThread;
            e = Math.min(s + linesPerThread - 1, lines);
        }
    }

    /**
     *  a program which can determine the distribution of the numbers between 1 and 80 from the input stream
     *
     * @param    args      commend line arguments, args[0] means how many threads will be used to read file
     *                                             args[1] means the file name passed in from the user
     */

    public static void main(String[] args) {
        if ( args.length < 1 ) {
            System.out.println("Not enough command line arguments");
            return;
        }
        else if ( args.length == 1 ) {
            fileName = "Lottery_Pick_10_Winning_Numbers__Beginning_1987.csv";
        }
        else {
            fileName = args[1];
        }

        numberOfThreads = Integer.parseInt(args[0]);
        // the number of threads must be valid or meaningful
        if (numberOfThreads < 1) {
            System.out.println("The number of threads must be positive!");
            return;
        } else if (numberOfThreads >= lines) {
            numberOfThreads = lines;
        }

        threads = new NumberCounter[numberOfThreads];
        linesPerThread = lines / numberOfThreads;

        initializeArray();

        // print the output after getting all data from the threads
        try {
            threads[threads.length - 1].join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted!");
        }

        printOutput();
    }
}

