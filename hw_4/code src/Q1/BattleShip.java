package Q1;

/*
 * BattleShip.java
 *
 * Version:
 *     $1.0$
 *
 * Revisions:
 *     $Log$
 */

// The main idea here is use a 2-D integer array to represent the battlefield.
// In particular, 1 <= id <= 128(stand for ships) and
// 0(stands for ocean) are unrevealed areas to the player,
// so print a single dot '.' when encountering them.
// On the other hand, -1 when hit ships and print a 'x' correspondingly.
// Similarly, -2 when hit ocean and print a 'w'.
// 表示击中ship和击中海洋的整型可以用枚举变量来表示，这个可读性更高

// The names of test files match the following format: b_numbers.txt

import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * This program simulates a battleship game
 *
 * @author      Xiaoyu  Tongyang, or call me sora sor short
 */

public class BattleShip {
    private int[][] ocean;           // 2-D integer array to stimulate the battlefield or the ocean
    private int leftAreas;           // remained coordinates that haven't been hit yet
    private int leftShips;           // remained coordinates of ships that haven't been hit yet
    private int columnsOcean = -1;   // how many columns the battlefield has
    private int rowsOcean = -1;      // how many rows the battlefield has

    /**
     * print the ocean or the battlefield
     */

    private void printOcean() {
        // print column indicator
        System.out.printf("%-5s", "");
        for (int i = 0; i < columnsOcean; i++) {
            System.out.print(i + " ");
        }
        System.out.println(" ---> columns");

        // print the ocean and row indicator
        for (int i = 0; i < ocean.length; i++) {
            System.out.printf("%d%-3s", i, ":");

            for (int j = 0; j < ocean[0].length; j++) {
                if (ocean[i][j] >= 0) { // print '.' when 1 <= id <= 128 and 0
                    System.out.print(" " + '.');
                }
                else if (ocean[i][j] == -1) { // print 'x' when hit a ship
                    System.out.print(" " + 'x');
                }
                else { // print 'w' when hit ocean
                    System.out.print(" " + 'w');
                }
            }

            System.out.println();
        }
    }

    /**
     * initialize a board or a battlefield
     */

    private void initializeBoard() {
        this.ocean = new int[this.rowsOcean][this.columnsOcean];
        this.leftAreas = this.rowsOcean * this.columnsOcean;
    }

    /**
     * read a ship's ID and convert it into an integer, and store into the 2-D array
     *
     * @param    row     the row we are at now
     * @param    scLine  the scanner used to read the file
     */

    private void setShipsOnOcean(int row, Scanner scLine) {
        int column = 0;
        String thing;

        while (scLine.hasNext()) {
            thing = scLine.next();

            if (thing.charAt(0) == 'b') {
                ocean[row][column] = Integer.parseInt(thing.substring(1));
                this.leftShips++;
            }

            column++;
        }
    }

    /**
     * check whether the row and column the player typed in contains only numbers and at least one number
     *
     * @param    row  string standing for rows
     * @param    col  string standing for columns
     * @return        true, valid row and column; false, invalid
     */

    private boolean checkGuessValid(String row, String col) {
        return Pattern.matches("\\d+", row) && Pattern.matches("\\d+", col);
    }

    /**
     * check whether the row and column the player typed in are valid or not, in terms of the battlefield
     *
     * @param    row  rows in the form of integer
     * @param    col  columns in the form of integer
     * @return        true, valid row and column; false, invalid
     */

    private boolean checkHitOnOcean(int row, int col) {
        return row >= 0 && row < this.rowsOcean && col >= 0 && col < this.columnsOcean;
    }

    /**
     * iterate the 2-D array to check the player is hitting either ocean or a ship or nothing
     *
     * @param    row  rows in the form of integer
     * @param    col  columns in the form of integer
     */

    private void hitShips(int row, int col) {
        if (! checkHitOnOcean(row, col) ) {
            System.out.println("The hit is out of the ocean range!");
            return;
        }

        // hit the places that have been hit before
        if (ocean[row][col] < 0) {
            return;
        }
        else if (ocean[row][col] == 0) { // hit the ocean
            ocean[row][col] = -2;
            this.leftAreas--;
            return;
        }

        // hit a ship and find all its coordinates and set them to -1
        System.out.println("HIT!\n");
        int shipID = ocean[row][col];

		// 这里只需检查整行和整列就行，无需check整个键盘
        for (int i = 0; i < ocean.length; i++) {
            for (int j = 0; j < ocean[0].length; j++) {
                if (ocean[i][j] == shipID) {
                    ocean[i][j] = -1;
                    this.leftAreas--;
                    this.leftShips--;
                }
            }
        }
    }

    /**
     * read the battlefield file and get the information about width, height or ships' ID, ect.
     *
     * @param    scFile  the scanner used to read the file
     */

    private void readFromFile( Scanner scFile ) {
        int rowCount = 0;

        // after initializing the battlefield, set flag to false to avoid repeating to initialize the battlefield
        boolean flag = true;

        while (scFile.hasNext()) {
            // scanner to process a line read from the file
            Scanner scLine = new Scanner( scFile.nextLine() );

            switch ( scLine.next() ) {
                case "width":
                    this.columnsOcean = Integer.parseInt(scLine.next());
                    break;
                case "height":
                    this.rowsOcean = Integer.parseInt(scLine.next());
                    break;
                case "row":
                    setShipsOnOcean(rowCount++, scLine);
                    break;
                default:
                    System.out.println("Cannot reach here!");
                    System.exit(1);
                    break;
            }

            // have gotten the rows and columns and need to initialize the battlefield
            if (flag && this.columnsOcean != -1 && this.rowsOcean != -1) {
                initializeBoard();
                flag = false;
            }

            scLine.close();
        }

        scFile.close();
    }

    /**
     * get the battlefield filename
     *
     * @param    args    command line arguments
     * @param    scUser  the scanner used to receive the player's input
     * @return           the scanner to read the file
     */

    private Scanner openBattleFieldFile( String[] args, Scanner scUser ) {
        try {

            String str = "";

            // if the command line is empty, let the player type the filename in
            if (args.length > 0) {
                str += args[0];
            }
            else {
                System.out.print("BattleField file name: ");
                str += scUser.next();
            }

            File f = new File( str );
            return new Scanner(f);

        } catch ( Exception e ) {
            System.err.println("Could not find the filename!");
            System.exit(1);
        }

        System.err.println("Cannot reach here!");
        System.exit(1);
        return null;
    }

    /**
     * the main code body to execute the game
     *
     * @param    args    command line arguments
     */

    public void startPlayingGame( String[] args ) {
        // open the battlefield file
        Scanner scUser = new Scanner(System.in);
        readFromFile( openBattleFieldFile( args, scUser ) );

        String row; // store the row that the player types in
        String col; // store the column that the player types in

        // start playing the game
        do {
            System.out.printf("\n%s\n%s\n\n", "x indicates a hit.",
                    "w indicates a miss, but you know now there is water.");
            printOcean();

            do {
                // get row and column from the player
                System.out.printf("%s%d%s", "row  coordinate 0 <= row  < ", this.rowsOcean, "): ");
                row = scUser.next();
                System.out.printf("%s%d%s", "column coordinate 0 <= column < ", this.columnsOcean, "): ");
                col = scUser.next();
            }  while ( ! checkGuessValid(row, col) ); // check if the row and column from user are valid or not

            hitShips(Integer.parseInt(row), Integer.parseInt(col));

        } while (this.leftShips > 0 && this.leftAreas > 0);

        // Game over, print the ending message
        System.out.println("Game ends, all boats have been hit!\n");
        printOcean();

        scUser.close();
    }

    /**
     * The main program.
     *
     * @param    args  command line arguments, args[0] stands for battleField filename if it has
     */

    public static void main( String[] args ) {
        new BattleShip().startPlayingGame( args );
    }
}
