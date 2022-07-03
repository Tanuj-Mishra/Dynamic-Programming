import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] prices = new int[n];
        for(int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }

        int[] dp = new int[n];
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i < n; i++) {
            // updating minPrice
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            }

            // compute localMax
            int presentProfit = prices[i] - minPrice;

            // update maxProfit
            if(maxProfit < presentProfit) {
                maxProfit = presentProfit;
            }
        }

        System.out.println(maxProfit);
        
    }

}