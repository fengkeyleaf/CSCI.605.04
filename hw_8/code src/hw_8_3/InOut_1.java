package hw_8_3;

import hw_8_1.NumberCounter;

import java.io.*;

public class InOut_1 {
    public static void main( String args[] ) {
        /*byte[]  buffer = new byte[1024];
        int     n;

        if ( args.length < 2 )	{
            System.err.println(
                    "Usage: java InOut_1 from to");
            System.exit(1);
        }

        try (
                DataInputStream in = new DataInputStream(
                        new FileInputStream(args[0]) );
                DataOutputStream out = new DataOutputStream(
                        new FileOutputStream(args[1]) );
        ) {

            while ( (n = in.read(buffer) ) != -1 ) {
                out.write(buffer, 0, n);
            }

        }
        catch ( FileNotFoundException ef)	{
            System.out.println("File not found: " + args[1]);
        }
        catch ( IOException ef)	{
            System.out.println("File not found: " + args[1]);
        }
        catch ( Exception e)	{
            System.out.println("ExceptionType occurred: " +
                    e.getMessage() );
        }*/

        try (
                BufferedReader input = new BufferedReader( new InputStreamReader( NumberCounter.getInputStream( args[0] ) ) );
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("1234.ser")));
//                BufferedReader input = new BufferedReader( new FileReader(fileName) )
				/* add code here
					fileName is null or ending with gz or not compressed
				*/
        ) {
            char buf[] = new char[1024];

		/* add code here
		   this method returns the next digit, which must be a single digit number
		   Other characters must be discarded.
		*/
            int count = 0;
            try {
//            System.out.println(input.ready());
                int numChar = input.read();

                while ( numChar != -1) {
                    buf[count++] = (char) numChar;
                    numChar = input.read();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                for (int i = 0; i < count; i++) {
                    out.write(buf[i]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

//            System.out.println(buf);
        } catch ( Exception e ) {
            e.printStackTrace();
            System.exit(0);
        }

    }
}