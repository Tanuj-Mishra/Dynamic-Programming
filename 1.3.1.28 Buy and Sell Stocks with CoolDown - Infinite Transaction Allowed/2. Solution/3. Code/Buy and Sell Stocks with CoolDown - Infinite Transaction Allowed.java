// O(N) && O(1)

import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // taking prices[]
        int n = scn.nextInt();
        int[] prices = new int[n];
        for(int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }


        // compute 
        int endAtBuy = -prices[0];
        int endAtSell = 0;
        int coolDown = 0;

        for(int i = 1, option1 = 0, option2 = 0; i < n; i++) {

            int oldBuy = endAtBuy;
            int oldSell = endAtSell;

            // buy
            option1 = endAtBuy;
            option2 = coolDown - prices[i];
            endAtBuy = Math.max(option1, option2);

            // sell
            option1 = endAtSell;
            option2 = oldBuy + prices[i];
            endAtSell = Math.max(option1, option2);

            // cooldown
            option1 = coolDown;
            option2 = oldSell;
            coolDown = Math.max(option1, option2);

        }

        System.out.println(endAtSell);

    }

}
