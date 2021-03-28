package hw_8_1;

import java.io.BufferedReader;
import java.io.FileReader;

public class TestRead {

    public static void main(String[] args) {
        String filename = null;
        if ( args.length == 1 ) {
            filename = args[0];
        }


        try ( BufferedReader reader = new BufferedReader( new FileReader (filename) ) ){

            reader.readLine();
            String line = null;
            while((line=reader.readLine())!=null){
                String item[] = line.split(",");

                String last = item[item.length-1];
                //int value = Integer.parseInt(last);
                System.out.println(last);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}