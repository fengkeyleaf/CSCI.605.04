/*
 * PasswordRead.java
 *
 * Version:
 *     $1.0$
 *
 * Revisions:
 *     $LOG$
 */

package hw_8_3;

import java.io.*;

/**
 * This program does what exactly hw 8.3 requires
 *
 * @author       Xiaoyu  Tongyang, or call me sora for short
 */

public class PasswordRead {

    /**
     * read from a file
     *
     * @param    fileName      file name to read from
     * @return                 the Password object stored in the file
     */

    public static Password readPassword(String fileName) {

        try (
                ObjectInputStream p = new ObjectInputStream( new FileInputStream(fileName) );
        ) {
            return (Password) p.readObject(); // read from the file
        }
        catch ( IOException e)	{
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        catch ( ClassNotFoundException e)	{
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.err.println("Cannot reach here");
        System.exit(1);
        return null;
    }

    /**
     *  the main program to read object from a file
     *
     * @param    args      commend line arguments, args[0] means the file name passed in from the user
     */

    public static void main( String args[] ) {
        Password aPassword;

        if ( args.length == 1 ) {
            aPassword = readPassword(args[0]);
        }
        else {
            aPassword = readPassword("1235.ser");
        }

        System.out.println("The password is: " + aPassword);
    }
}
