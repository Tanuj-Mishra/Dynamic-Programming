// O(N) && O(1)

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

        int endAtBuy = -prices[0];
        int endAtSell = 0;

        for(int i = 1, option1 = 0, option2 = 0; i < n; i++) {

            // buy
            option1 = endAtBuy;
            option2 = endAtSell - prices[i];
            endAtBuy = Math.max(option1,option2);

            // sell
            option1 = endAtSell;
            option2 = prices[i] + endAtBuy - fee ;
            endAtSell = Math.max(option1, option2);
        }

        System.out.println(endAtSell);

    }

}

