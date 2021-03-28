package hw_8_3;
import java.io.*;
import java.util.*;

public class CheckLengthRead {

    public static void main( String args[] ) {

        CheckLength aCheckLength;
        String fileName = "1234.ser";

        if ( args.length == 1 )
            fileName = args[0];
        try (
                ObjectInputStream p = new ObjectInputStream(new FileInputStream(fileName) );
        ) {
            aCheckLength = (CheckLength)p.readObject();
            System.out.println("aCheckLength = " + aCheckLength );
            aCheckLength = (CheckLength)p.readObject();
            System.out.println("aCheckLength = " + aCheckLength );
        }
        catch ( IOException e)	{
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        catch ( ClassNotFoundException e)	{
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}