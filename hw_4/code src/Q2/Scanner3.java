package Q2;

import java.util.Scanner;

public class Scanner3 {
    public static void main( String[] args ) {
//        Scanner sc  = new Scanner("  ").useDelimiter(" ");
        Scanner sc  = new Scanner(":1:\n:a:").useDelimiter(":");
//        Scanner sc  = new Scanner("  ");

        while ( sc.hasNext() )	{
            System.out.printf("> ");
            String line = sc.next();
            if (line.equals("\n")) System.out.println("Empty");
            else System.out.printf("-%s-%n", line );
//            System.out.printf("> ");
        }
        sc.close();
    }
}

