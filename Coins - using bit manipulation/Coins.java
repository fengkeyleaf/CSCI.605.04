/*
 * coins.java
 *
 * Version:
 *     $1.0$
 *
 * Revision
 *     $Log$
 */
 
/**
 * this program is to determines a sequence of coins exist adding up to a given value.
 * and the sequence must be the longest if more than one sequence exist.
 *
 * @author       Chenxuan li
 */
 
class Coins{
	
    /**
     * converse array to an string for print
     *
     * @param    n    is the input array
     */
	 
    public static String getArraysString(int[] n){
        String str="";
        for (int a=0;a<n.length;a++){
            if(a<n.length){
                str=str+n[a]+",";
            }

            if(a==n.length-1){
                str=str+n[a];
            }

        }
        return str;
    }
	
    /**
     * print output:
     * if there is an optimal Solution, print the optimal Solution
     * if the payment can't be paid, print "can not be paid"
     * if the payment is impossible to be paid, print "can not be paid"
     *
     * @param    optimalSolution     optimalSolution is a string represents the optimal Solution
     * @param    toPayElement        is a number represents how much money you need to Pay
     * @param    coinsString         is the optimalSolution of the coins need to be paid
     */
	 
    public static void printFinalSolution(String optimalSolution,int toPayElement,String coinsString){
        if(optimalSolution == ""){
            if(toPayElement <= 0){
                System.out.println("can not be paid");
            }
            if(toPayElement > 0){
                System.out.println("no, can not be paid with the following sequence of coins:["+coinsString+"]");
            }
        }

        else {
            System.out.println("yes, used coins" + optimalSolution);
        }
    }
	
    /**
     * Get the String of the optimalSolution
     *
     * @param    myCoinsLength     the lenghth of myCoins
     * @param    myCoins           is myCoins array
     * @param    toPayElement      the number I need to pay
     * @return   optimalSolution   the best payment plan
     */
	 
    public static String getOptimalSolution(int myCoinsLength,int[] myCoins,int toPayElement) {
        String optimalSolution = "";
        for(int a = 0;a < (1 << myCoinsLength);a++){
            int addUp = 0;// total coins in each possibility
            int coinCurrentNumber = 0; //total coins number for the best solution currently
            int coinsNumber = 0;//total coins used in each possibility
            String currentSolution = "";//coins combination for  each possible solution
            for(int b = 0;b < myCoinsLength;b++){
                if((a&(1 << b)) != 0){
                    addUp=addUp+myCoins[myCoinsLength - b - 1];
                    coinsNumber++;
                    currentSolution = currentSolution+"  "+myCoins[myCoinsLength - b - 1];
                    if(toPayElement == addUp&&coinsNumber>coinCurrentNumber){
                        coinCurrentNumber = coinsNumber;
                        optimalSolution = currentSolution;
                    }
                }
            }
        }
        return optimalSolution;
    }
	
    /**
     * The main program.
     *
     * @param    args  command line arguments(ignored)
     */
	 
    public static void main(String args[]){
        int[] myCoins = { 1, 5, 25, 25, 25 };//myCoins input
        int[] toPay = { 0, 2, 30, 75};//toPay input
        int myCoinsLength = myCoins.length;
        int toPayLength = toPay.length;
        String coinsString = getArraysString(myCoins);
        for(int i = 0;i < toPayLength;i++){
            int toPayElement = toPay[i];
            String optimalSolution = getOptimalSolution(myCoinsLength,myCoins,toPayElement);
            printFinalSolution(optimalSolution,toPayElement,coinsString);
        }

    }
}