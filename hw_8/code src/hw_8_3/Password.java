/*
 * Password.java
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
 * This program does what exactly hw 8.3 requires. This class implements Serializable
 *
 * @author       Xiaoyu  Tongyang, or call me sora for short
 */

public class Password implements Serializable {
    private String password; // string to store the password
    private static final long serialVersionUID = 1234568L;

    /**
     * a constructor that creates a BST with the node stored element
     *
     * @param    password      password stored in this class
     */

    public Password(String password) {
        this.password = password;
    }

    /**
     * write to ObjectOutputStream
     *
     * @param    s      ObjectOutputStream to read from
     */

    private void writeObject(ObjectOutputStream s) throws IOException {
        System.out.println("Password: writeObject");

        s.defaultWriteObject();
        // write the hashcode of the password to file
		// 还需要检查reversed string的hashcode
        s.writeObject( this.password.hashCode() );
    }

    /**
     * read from ObjectInputStream
     *
     * @param    s      ObjectInputStream to read from
     */

    private void readObject(ObjectInputStream s) throws IOException  {
        System.out.println("Password: readObject");

        try {
            s.defaultReadObject();

            // read the hashcode stored in the file
            int hashCode = (int) s.readObject();
            // if the stored hashcode doesn't equal the one the password string represents
            // don't reveal it to the user
            if ( hashCode != this.password.hashCode() )
                this.password = "";
        }
        catch ( ClassNotFoundException e)	{
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * get a textual representation of this class
     */

    @Override
    public String toString() {
        return this.password;
    }
}
