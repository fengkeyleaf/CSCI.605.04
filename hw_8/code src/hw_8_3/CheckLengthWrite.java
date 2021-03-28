package hw_8_3;
import java.io.*;
import java.util.*;

public class CheckLengthWrite {

    public static void main( String args[] ) {

        CheckLength aCheckLength = new CheckLength("abcdef");
        CheckLength bCheckLength = new CheckLength("abcdefghijklmnopqrst");
        String fileName    = "1234.ser";

        if ( args.length == 1 )
            fileName = args[0];

        try (
                ObjectOutputStream p = new ObjectOutputStream(new FileOutputStream(fileName) );
        ) {
            p.writeObject(aCheckLength);
            p.writeObject(bCheckLength);
        }
        catch ( IOException e)	{
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}