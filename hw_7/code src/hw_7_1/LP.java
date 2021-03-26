/*
 * LP.java
 *
 * Version:
 *     $1.0$
 *
 * Revisions:
 *     $0.0$
 */

package hw_7_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This program does what exactly hw 7.1 requires
 *
 * @author      Xiaoyu  Tongyang, or call me sora sor short
 */

public class LP implements Comparable<LP> {
    private int releasedYear;   // released Year of a LP
    private String bandName;    // band Name of a LP
    private String albumName;   // album Name of a LP
    private float time;         // time of a LP
    private int tracks;         // tracks of a LP

    /**
     * the constructor that create a given LP with its released Year, band Name, album Name, time and tracks;
     * no default constructor provided, so cannot create an empty LP.
     *
     * @param    releasedYear     releasedYear of a given LP
     * @param    bandName         bandName of a given LP
     * @param    albumName        albumName of a given LP
     * @param    time             time of a given LP
     * @param    tracks           number of tracks of a given LP
     */

    public LP(int releasedYear, String bandName, String albumName, float time, int tracks) {
        if ( releasedYear < 0 ) {
            System.err.println("released Year must be non-negative! Failed to create a LP");
            System.exit(1);
        }

        if ( time < 0 ) {
            System.err.println("time must be non-negative! Failed to create a LP");
            System.exit(1);
        }

        if ( tracks < 0 ) {
            System.err.println("tracks must be non-negative! Failed to create a LP");
            System.exit(1);
        }

        this.releasedYear = releasedYear;
        this.bandName = bandName;
        this.albumName = albumName;
        this.time = time;
        this.tracks = tracks;
    }

    /**
     * overridden method to compare two LPs
     *
     * @param    aLP     passed-in LP needed to compare
     * @return           Returns a negative integer, zero, or a positive integer as this LP is
     *                   less than, equal to, or greater than the passed-in LP.
     */

	// 可以直接用 toString().compareTo(aLP.toString()) 来实现
    @Override
    public int compareTo( LP aLP ) {
        // compare released Year, if get 0, which means the two LPs are the same in terms of released Year,
        // and continue comparing other variables
        int result = Integer.compare(this.releasedYear, aLP.getReleasedYear());
        if ( result != 0 ) {
            return result;
        }

        // compare band Name, if get 0, which means the two LPs are the same in terms of band Name
        result = this.bandName.compareTo(aLP.getBandName());
        if ( result != 0 ) {
            return result;
        }

        // compare album Name
        result = this.albumName.compareTo(aLP.getAlbumName());
        if ( result != 0 ) {
            return result;
        }

        // compare time
        result = Float.compare(this.time, aLP.getTime());
        if ( result != 0 ) {
            return result;
        }

        // compare tracks
        return Integer.compare(this.tracks, aLP.getTracks());
    }

    /**
     * get the Released Year of a given LP
     */

    public int getReleasedYear() {
        return this.releasedYear;
    }

    /**
     * get the Band Name of a given LP
     */

    public String getBandName() {
        return this.bandName;
    }

    /**
     * get the Album Name of a given LP
     */

    public String getAlbumName() {
        return this.albumName;
    }

    /**
     * get the time of a given LP
     */

    public float getTime() {
        return time;
    }

    /**
     * get the Tracks of a given LP
     */

    public int getTracks() {
        return this.tracks;
    }

    /**
     * get a textual representation of the LP
     */

    public String toString() {
        return "LP: " + this.releasedYear + "/" + this.bandName +
                "/" + this.albumName + "/" + this.time + "/" + this.tracks;
    }

    /**
     * The main program to test class LP.
     *
     * @param    args  command line arguments, ignored
     */

    public static void main( String args[] ) {
        LP aLP = new LP( 1960, "Deep Purple in Rock", "Deep Purple", (float)43.30, 7);
        LP bLP = new LP( 1973, "Dark Side of the Moon", "Pink Floyd ", (float)43.09, 10);
        LP cLP = new LP( 1, "A", "B ", (float)3, 4);
        LP dLP = new LP( 2, "A", "B ", (float)3, 4);
        LP eLP = new LP( 3, "A", "B ", (float)3, 4);
        LP fLP = new LP( 0, "A", "B ", (float)3, 4);

        LP gLP = new LP( 1, "A", "B ", (float)3, 4);
        LP hLP = new LP( 1, "B", "B ", (float)3, 4);
        LP iLP = new LP( 1, "B", "C ", (float)3, 4);
        LP jLP = new LP( 1, "B", "C ", (float)4, 4);
        LP kLP = new LP( 1, "B", "C ", (float)4, 5);
        LP mLP = new LP( 1, "B", "C ", (float)4, 5);

        System.out.println( aLP.compareTo(bLP) );
        System.out.println( cLP.compareTo(fLP) );

        System.out.println( gLP.compareTo(hLP) );
        System.out.println( hLP.compareTo(gLP) );
        System.out.println( hLP.compareTo(iLP) );
        System.out.println( jLP.compareTo(kLP) );
        System.out.println( gLP.compareTo(kLP) );
        System.out.println( kLP.compareTo(mLP) );

        List<LP> aListOfLPs = new ArrayList<LP>();
/*        aListOfLPs.add( aLP );
        aListOfLPs.add( bLP );
        aListOfLPs.add( cLP );
        aListOfLPs.add( dLP );
        aListOfLPs.add( eLP );
        aListOfLPs.add( fLP );*/

        aListOfLPs.add( gLP );
        aListOfLPs.add( hLP );
        aListOfLPs.add( iLP );
        aListOfLPs.add( jLP );
        aListOfLPs.add( kLP );
        aListOfLPs.add( mLP );

        Collections.sort(aListOfLPs);
        System.out.println(aListOfLPs);
    }
}
