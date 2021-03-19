package Q2;

/*
 * RegularExample.java
 *
 * Version:
 *     $1.0$
 *
 * Revisions:
 *     $Log$
 */

// The names of testing files match the following format: test_numbers.txt

import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * This program does what exactly hw 4.2 requires
 *
 * @author      Xiaoyu  Tongyang, or call me sora sor short
 */

public class RegularExample {
    // the delimiter via command line argument
    static String delimiter;
    // the input filename
    static String filename;
    // maximum number of words can be tested and it's also the length of allTestWordsFromFile
    static int maximum = 100;
    // string array to store test cases
    static private String[] allTestWordsFromFile = new String[maximum];
    // how many words needed to test
    static int numberOfWords;

    // array to store all patterns descriptions
    static final private String[] allPatternsDescriptions = {
            "starts with ’a’ followed by one digit or more digits", // 1
            "a word with the vowels ’aeiou’ in order and each vowel can appear only once", // 2
            "starts with ’a’ followed by 3 digits in the range between 1 and 3 only", // 3
            "starts with ’a’ followed by least 3 digits in the range between 1 and 3 only", // 4
            "starts with ’a’ followed by between 1 and 2 digits in the range between 8 and 9 only", // 5
            "includes only lower case characters, but not the character ’h’, ’p’, and ’b’" // 6
    };

    // array to store all patterns
    static final private String[] allPatterns = {
            "^a\\d+$", // 1
            "[^aeiou]*aeiou[^aeiou]*", // 2
            "^a[1-3]{3}$", // 3
            "^a[1-3]{3,}$", // 4
            "^a[8-9]{1,2}$", // 5
            "[a-z&&[^hpb]]*" // 6
    };

    /**
     * read words from input file
     */

    public static void readFromFile() {
        try {

            File f = new File(filename);
            Scanner sc = new Scanner(f).useDelimiter(delimiter);

            int index = 0;
            while (index < allTestWordsFromFile.length && sc.hasNext()) {
                String word = sc.next();

                // remove whitespace characters
                if ( Pattern.matches("\\S*", word) ) {
                    allTestWordsFromFile[index++] = word;
                }
            }

            numberOfWords = index;
            sc.close();

        } catch ( Exception e ) {
            System.err.println("Could not find the filename!");
            System.exit(1);
        }
    }

    /**
     * the main code body to execute the matching process
     */

    public static void processStatic() {
        for (int i = 0; i < numberOfWords; i++) {
            for (int j = 0; j < allPatterns.length; j++) {
                if (Pattern.matches(allPatterns[j], allTestWordsFromFile[i])) {
                    System.out.printf("Input: -%s=\n", allTestWordsFromFile[i]);
                    System.out.printf("This regular expression \"%s\" matches the following input: -%s=\n",
                            allPatterns[j], allTestWordsFromFile[i]);
                    System.out.printf("verbal explanation: %s\n\n", allPatternsDescriptions[j]);
                }
            }
        }
    }

    /**
     * The main program.
     *
     * @param    args  command line arguments, args[0] stands for the delimiter;
     *                 args[1] stands for the testing file
     */

    public static void main(String[] args) {
        // if no command line arguments are provided, use the default ones
        delimiter = args.length > 1 ? args[1] : ":";
        filename = "" + (args.length > 3 ? args[3] : "Q2/test_1.txt");
        delimiter = args.length > 3 ? delimiter : ":";

        readFromFile();
        processStatic();
    }
}