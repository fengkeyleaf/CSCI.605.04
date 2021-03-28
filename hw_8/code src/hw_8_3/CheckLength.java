package hw_8_3;

import java.io.*;
import java.util.*;
import java.io.*;
import java.util.*;

public class CheckLength implements Serializable {
    private int    MINIMUMlength = 10;
    private int    length;
    private String aString;
//    private String aString1;
//     private int length = 4;

//     private static final long serialVersionUID = 1234567L;
    private static final long serialVersionUID = 1234568L;

    public CheckLength(String aString)	{
        this.aString = aString;
        this.length  = aString.length();
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        System.out.println("CheckLength: writeObject");
        s.defaultWriteObject();

        if ( length < MINIMUMlength )
//            s.writeObject(-1);
            s.writeObject(Integer.valueOf(-1));
        else
            s.writeObject(Integer.valueOf(length));
//            s.writeObject(length);
    }

    private void readObject(ObjectInputStream s) throws IOException  {
        System.out.println("CheckLength: readObject");
        try {
            s.defaultReadObject();
            int length = (int)s.readObject();
            if ( this.aString.length() != length )
                this.aString = "";
        }
        catch ( ClassNotFoundException e)	{
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public String toString()	{
        return aString + "/" + length;
    }

}
