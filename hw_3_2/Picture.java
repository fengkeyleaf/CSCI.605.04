package hw_3_2;

/*
 * Picture.java
 *
 * Version:
 *     $1.0$
 *
 * Revisions:
 *     $Log$
 */

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import java.io.File;

/**
 * this program is to give word from the words.txt, and then giving a picture regarding the word
 * player can type an alphabet each time, and if player tries more than 9 times or guess word correctly
 * they will be able to guess next word. And after all words have been selected, exit the program.
 *
 * @author      Xiaoyu  Tongyang, or call me sora sor short
 */

public class Picture {
     StringBuilder image = new StringBuilder();     // store the image in liner order
     int imageColumns;                              // how many columns original image have
     Vector<String> words = new Vector<String>();   // store words from a words file
     StringBuilder word;                            // the word that a player needs to guess
     StringBuilder originalWord;                    // the original word without modifying
     int countRightGuesses;                         // count how many times a player guesses correctly
     int numberOfGuesses;                           // count how many times a player guesses

    // store the pattern of the word,
    // e.g. decide which index of the world should be print as itself or '.'
     boolean[] printPatternWord;

    /**
     * read image and words and store
     *
     * @param    argv     relative path of a file
     * @param    flag     the status indicating the program is processing a image file or a words file
     */

    public void readFromFile( String argv, boolean flag ) throws FileNotFoundException{
        // open the file and read it
        File f = new File( argv );
        Scanner s = new Scanner( f );

        // store the content of the file
        while ( s.hasNext() ) {
            String str = s.next(); // 这里应该用s.nextline()，防止中间有空格而导致读取不完整

            if ( flag ) { // store the content into image container
                this.image.append( str );
                imageColumns = str.length();
            }
            else { // store the content into words container
                this.words.add( str );
            }

        }

        s.close();
    }

    /**
     * print the pattern word
     */

    public String printWord() {
        String str = "";
        for ( int i = 0; i < originalWord.length(); i++ ) {
                str += printPatternWord[i] ? originalWord.charAt(i) : '.';
        }

        return str;
    }

    /**
     * print the image, the guessing word
     */

    public void printMessage() {
        // print image pattern
        int start = originalWord.length() - countRightGuesses; // the starting index printing a character, not '.'
        int imageNewLine = imageColumns - 1; // the starting index print a new line
        int printTab = 0; // the starting index print a tab
        for (int i = 0; i < image.length(); i++) {
            // reach the beginning of next row of the image, print a tab
            if (i == printTab) {
                System.out.print("\t");
                printTab += imageColumns;
            }

            // print every (originalWord.length() - countRightGuesses)th character
            System.out.print( start == i ? image.charAt(i) : '.' );
            if (start == i) {
                start += originalWord.length() + 1 - countRightGuesses;
            }

            // reach the end of next row of the image, print a tab
            if (i == imageNewLine ) {
                System.out.println();
                imageNewLine += imageColumns;
            }
        }

        // print word pattern
        System.out.println( ( word.length() == 0 ? "The word was" : numberOfGuesses ) + ": " + printWord() );
    }

    /**
     * record which character of the word has been guessed correctly
     *
     * @param    guess  the character that the player typed in
     */

	// 关于打印word的方法都可以不用使用额外的boolean array，可以用...来表示某个字符没有还有被猜出来
	// 然后用indexOf()，搜索"."，如果结果==-1，表示所有的字符都猜出来的，打印完整的字符
    public void revealWord( String guess ) {
        for ( int j = 0; j < printPatternWord.length; j++ ) {
            if ( !printPatternWord[j] && originalWord.charAt(j) == guess.charAt(0) ) {
                printPatternWord[j] = true;
                break;
            }
        }
    }

    /**
     * determine whether the player's guess is correct or not
     *
     * @param    guess  the character that the player typed in
     */

    public void howManyCorrectGuesses( String guess ) {
            int index = word.indexOf( guess );

            // correctly guessed a character
            if ( index != -1 ) {
                word.deleteCharAt( index );
                countRightGuesses++;

                revealWord( guess );
            }

            numberOfGuesses++;
    }

    /**
     * the main code body of the game, including selecting random words and
     * checking if a player has remained words to guess
     */

    public void startPlayingGame() {
        Scanner sc = new Scanner( System.in );

        // have words needed to guess, go on the game
        while ( !words.isEmpty() ) {
            String newWord = words.remove( new Random().nextInt( words.size() ) );
            word = new StringBuilder( newWord );
            originalWord = new StringBuilder( newWord );
            countRightGuesses = 0;
            printPatternWord = new boolean[ originalWord.length() ];

            // start guess the word within 9 times
            // 这个地方可以用do...while，就可以省略下面的一行代码
            printMessage();
            while ( word.length() != 0 ) {
                String guess = sc.next();
                // the input should be one character, not two or more characters
                if ( guess.length() > 1 ) {
                    System.out.println( "Should type only one character!" );
                    continue;
                }

                howManyCorrectGuesses( guess );
                printMessage();
                System.out.println();

                // have guessed 9 times, current round ends
                if ( word.length() != 0 && numberOfGuesses == 9 ) {
                    System.out.println( "You ran out of chances. Round Over! The world is: " + originalWord );
                    break;
                }
            }

            numberOfGuesses = 0;
        }

        sc.close();
        System.out.println( "No more words left to guess\nI hope you enjoyed the game, bye!" );
    }

    /**
     * The main program.
     *
     * @param    args  command line arguments
     *                 args[0] stands for words file; args[1] stands for image file
     */

    public static void main( String args[] ) throws FileNotFoundException	{
        Picture p = new Picture();
        // use command line to run the program
        // 这里应该检查一下commend line的合法性
         p.readFromFile(args[0], false); // read words file
         p.readFromFile(args[1], true);  // read image file

        // not use command line to run the program
        // p.readFromFile( "src/batman.txt", true ); // read image file
        // p.readFromFile( "src/words.txt", false ); // read words file

        p.startPlayingGame();
    }
}
