// WRONG APPROACH

import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] prices = new int[n];
        for(int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }

        int[] dp = new int[n];
        int minPrice = Integer.MAX_VALUE;
        int maxProfit1 = 0;
        int maxProfit2 = 0;


        for(int i = 0; i < n; i++) {
            // updating minPrice
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            }

            // compute localMax
            int presentProfit = prices[i] - minPrice;

            // update maxProfit
            if(presentProfit > maxProfit1) {
                maxProfit2 = maxProfit1;
                maxProfit1 = presentProfit;
            } else if(presentProfit > maxProfit2) {
                maxProfit2 = presentProfit;
            }
        }

        System.out.println(maxProfit1 + maxProfit2);
        
    }

}

// 9		4		1		1		0		4		7		4		2		6

// here 0 will become min, and it will select 7 and 6 
// so it will result 13 which is wrong as
// result must be 11 -> buy(0)->sell(7)->buy(2)->sell(6)
    