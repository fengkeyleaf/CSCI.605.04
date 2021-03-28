package hw_8_2;

import hw_8_1.NumberCounter;

import java.io.*;
import java.util.zip.GZIPInputStream;

public class Test {
    public static void main(String[] args) {
        String fileName = args.length == 1 ? args[0] : null;

        try (
//                BufferedReader input = new BufferedReader( new InputStreamReader(new GZIPInputStream( new FileInputStream (fileName) ) ) )
//                BufferedReader input = new BufferedReader( new InputStreamReader( new FileInputStream (fileName)  ) )
                BufferedReader input = new BufferedReader( new InputStreamReader( NumberCounter.getInputStream( fileName ) ) )
				/* add code here

					fileName is null or ending with gz or not compressed
				*/
        ) {
//            input.readLine();
            char buf[] = new char[1];

            int numChar = input.read();
            while ( numChar != -1) {
                if ('0' <= numChar && numChar <= '9') {
//                    buf[0] = (char) numChar;
//                    break;
                    System.out.println( (char) numChar);
//                    System.out.println( numChar);
                }
                numChar = input.read();
            }
//
//            String line = null;
//            while((line=input.readLine())!=null){
//                System.out.println(line);
//            }
        } catch ( Exception e ) {
            e.printStackTrace();
            System.out.println("Exception e");
            System.exit(0);
        }

    }

}
