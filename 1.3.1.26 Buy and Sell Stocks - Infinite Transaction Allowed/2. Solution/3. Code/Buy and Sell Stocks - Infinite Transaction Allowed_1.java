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
        int overallProfit = 0;

        for(int i = 0; i < n; i++) {
            // updating minPrice
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            }

            // updating overallProfit if possible and other attributes thereby
            int presentProfit = prices[i] - minPrice;
            if(presentProfit > 0) {
                overallProfit += presentProfit;
                minPrice = prices[i];
            }

        }

        System.out.println(overallProfit);
        
    }

}
