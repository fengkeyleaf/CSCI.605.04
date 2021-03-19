package Q2;

import java.io.File;
import java.util.Scanner;

public class Test4 {

    public static void main( String[] args) {
/*        Scanner sc = new Scanner("width  3");
//        sc.useDelimiter(";");
        while (sc.hasNext()) {
            String str = sc.nextLine();
//            if (str != "\n")
                System.out.println(str);
//                System.out.println(sc.next());
        }

        sc.close();*/

//        Scanner scFile = new Scanner("width  3");
        Scanner scFile = new Scanner("height 3");
//        Scanner scFile = new Scanner("row  b1 b2 b1");

        while ( scFile.hasNext() ) {
            Scanner scLine = new Scanner( scFile.nextLine() );

            switch ( scLine.next() ) {
                case "width":
                    System.out.println("width");
                    break;
                case "height":
                    System.out.println("height");
                    break;
                case "row":
                    System.out.println("row");
                    break;
                default:
                    System.out.println("Cannot reach here!");
                    System.exit(1);
                    break;

            }

            scLine.close();
        }

        scFile.close();
    }
}
