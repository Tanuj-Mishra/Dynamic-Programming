import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        // get prices[]
        int n = scn.nextInt();
        int[] prices = new int[n];
        for(int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }

        // get fee
        int fee = scn.nextInt();

        // 
        int[] endAtBuy = new int[n];
        int[] endAtSell = new int[n];

        endAtBuy[0] = -1 * prices[0];

        for(int i = 1, option1, option2, option3; i < n; i++) {
            // buy
            option1 = endAtBuy[i-1];
            option2 = endAtSell[i-1] - prices[i];
            // option3 = endAtSell[i] - prices[i];
            // option3 must not be included as selling and buying on same day can't make any profit
            // endAtBuy[i] = Math.max(option1,  Math.max(option2, option3) );
            endAtBuy[i] = Math.max(option1,option2);

            // sell
            option1 = endAtSell[i-1];
            option2 = prices[i] + endAtBuy[i-1] - fee ;
            endAtSell[i] = Math.max(option1, option2);
        }

        System.out.println(endAtSell[n-1]);

    }

}

