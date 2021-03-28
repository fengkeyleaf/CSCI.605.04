/*
 * Visual.java
 *
 * Version:
 *     $1.0$
 *
 * Revisions:
 *     $LOG$
 */

package hw_8_2;

// original from: http://rosettacode.org/wiki/Pi_set#Java from: http://rosettacode.org/wiki/Pi_set#Java
// modified for color

import java.awt.Color;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import java.util.Scanner;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.zip.GZIPInputStream;
import hw_8_1.NumberCounter;

/**
 * This program does what exactly hw 8.2 requires
 *
 * @author       Xiaoyu  Tongyang, or call me sora for short
 */

public class Visual extends JFrame {

    private final int LENGTH_OF_SQUARE = 3;
    private final int LENGTH 	       = 330;
    private final int LENGTH_OF_WINDOW = LENGTH * LENGTH_OF_SQUARE;
    private BufferedImage theImage;
    private String fileName = null;
    Reader input;
    private static final long serialVersionUID = 1234568L;

    public Visual() {
        super("Visual");

        setBounds(100, 100, LENGTH_OF_WINDOW, LENGTH_OF_WINDOW);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public Visual(String fileName) {
        this();
        this.fileName = fileName;
    }

    private char nextDigit(BufferedReader input)	{
        char buf[] = new char[1];

		/* add code here
		   this method returns the next digit, which must be a single digit number
		   Other characters must be discarded.
		*/

        try {
            int numChar = input.read();
            while ( numChar != -1) {
                if ('0' <= numChar && numChar <= '9') {
                    buf[0] = (char) numChar; // 可以直接用input.read(buf)
                    break;
                }
                numChar = input.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return buf[0];
    }

    private void saveImage(BufferedImage theImage)	{
        String suffix = "png";
        String outputFileName = fileName == null ? "output" : fileName + "_output" + "." + suffix ;
        try {
            File outputfile = new File(outputFileName);
            ImageIO.write(theImage, suffix, outputfile);
        } catch (Exception e )	{
            e.printStackTrace();
        }

    }

    public void fillSquare(int xOrig, int yOrig, int color)	{
        for (int x = 0; x < LENGTH_OF_SQUARE; x ++ )
            for (int y = 0; y < LENGTH_OF_SQUARE; y ++ )
                theImage.setRGB(xOrig + x, yOrig + y , color);
    }

    public void createImage()	{
        theImage = new BufferedImage(getWidth(), getHeight(),
                BufferedImage.TYPE_INT_RGB);
        int red = Color.RED.getRGB();		// you might like to change the colors if you like
        int blue = Color.BLUE.getRGB();		// you might like to change the colors if you like
        int colorUsed;

        try (
                BufferedReader input = new BufferedReader(
                        new InputStreamReader( NumberCounter.getInputStream(fileName) ) )
				/* add code here
					fileName is null or ending with gz or not compressed
				*/
        ) {
            for (int y = 0; y < getHeight(); y += LENGTH_OF_SQUARE) {
                for (int x = 0; x < getWidth(); x += LENGTH_OF_SQUARE) {
                    char digit = nextDigit(input);
                    fillSquare(x, y,  digit % 2 == 0 ? red : blue );
                }

            }
        } catch ( Exception e ) {
            e.printStackTrace();
            System.exit(0);
        }

        repaint();
        saveImage(theImage);
//        System.exit(0);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(theImage, 0, 0, this);
    }

    public static void main(String[] args) {
        Visual aVisual = new Visual(args.length == 1 ? args[0] : null );
        aVisual.setVisible(true);
        aVisual.createImage();
    }
}