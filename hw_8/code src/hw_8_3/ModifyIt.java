/*
 * ModifyIt.java
 *
 * Version:
 *     $1.0$
 *
 * Revisions:
 *     $LOG$
 */

/**
 * This program does what exactly hw 8.3 requires
 *
 * @author       Xiaoyu  Tongyang
 * @author       Chenxuan li
 */

package hw_8_3;

public class ModifyIt {

    public static void main( String[] args ) {
        Password aPassword = null;
        String fileName = null;

        // read the object from file
        if ( args.length == 1 ) {
            fileName = args[0];
        }
        else {
            fileName = "1235.ser";
        }

        try {
            aPassword = PasswordRead.readPassword(fileName);
//            aPassword.setPassword("abcdea"); // change the password here
//            Password.writePassword(aPassword, fileName); // write the object to file
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

}
