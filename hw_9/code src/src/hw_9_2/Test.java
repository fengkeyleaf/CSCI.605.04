package hw_9_2;

public class Test {
    public static void main(String[] args) {
        int lines = 12278;
        int numberOfThreads = 3;
//        int linesPerThread = lines / ( numberOfThreads - 1);
        int linesPerThread = lines / numberOfThreads;

        System.out.println(lines % numberOfThreads);
        System.out.println(linesPerThread);
        int s = 2, e = Math.min(s + linesPerThread - 1, lines);

        for( int num = 0; num < numberOfThreads ; num++ ){
            if (num == numberOfThreads - 1)
                e = lines;
            System.out.println((num + 1) + " - Start: " + s + "\tEnd: " + e);
            s += linesPerThread;
            e = Math.min(s + linesPerThread - 1, lines);
        }
    }
}
