/*
 * PasswordWrite.java
 *
 * Version:
 *     $1.0$
 *
 * Revisions:
 *     $LOG$
 */

package hw_8_3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * This program does what exactly hw 8.3 requires
 *
 * @author       Xiaoyu  Tongyang, or call me sora for short
 */

public class PasswordWrite {

    /**
     *  the main program to write object to a file
     *
     * @param    args      commend line arguments, args[0] means the file name passed in from the user
     */

    public static void main( String args[] ) {

        Password aPassword = new Password("abcdef");
        String fileName    = "1235.ser";

        if ( args.length == 1 )
            fileName = args[0];

        try (
                ObjectOutputStream p = new ObjectOutputStream(new FileOutputStream(fileName) )
        ) {
            p.writeObject(aPassword); // write to the file
        }
        catch ( IOException e)	{
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
