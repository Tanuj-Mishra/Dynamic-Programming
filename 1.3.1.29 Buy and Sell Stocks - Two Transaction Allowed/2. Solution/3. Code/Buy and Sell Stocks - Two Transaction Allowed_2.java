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

        // finding max profit if selled upto today
        int[] maxProfitIfSelledTillToday = new int[n];
        int minPrice = prices[0];
        for(int i = 1; i < n; i++) {

            // updating minPrice
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            }

            // finding max profit if selled today
            int todayProfit = prices[i] - minPrice;

            // max profit till today
            if(todayProfit > maxProfitIfSelledTillToday[i-1]) {
                maxProfitIfSelledTillToday[i] = todayProfit;
            }
            else {
                maxProfitIfSelledTillToday[i] = maxProfitIfSelledTillToday[i-1];
            }

        }

        // finding max profit if buyed till today
        int[] maxProfitIfBuyedTillToday = new int[n];
        int maxPrice = prices[n-1];
        for(int i = n-2; i >=0; i--) {
            // updating maxPrice
            if(prices[i] > maxPrice) {
                maxPrice = prices[i];
            }

            // max profit if buyed today
            int todayProfit = maxPrice - prices[i];

            // max profit till today
            if(todayProfit > maxProfitIfBuyedTillToday[i+1]) {
                maxProfitIfBuyedTillToday[i] = todayProfit;
            } else {
                maxProfitIfBuyedTillToday[i] = maxProfitIfBuyedTillToday[i+1];
            }

        }

        // finding overall max
        int max = 0;
        for(int i = 0; i < n; i++) {
            if(maxProfitIfSelledTillToday[i] + maxProfitIfBuyedTillToday[i] > max) {
                max = maxProfitIfSelledTillToday[i] + maxProfitIfBuyedTillToday[i];
            }
        }

        System.out.println(max);

        
    }

}

    