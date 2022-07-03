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
        int buy = prices[0];
        int sell = prices[0];
        int overallProfit = 0;

        for(int i = 1; i < n; i++) {
            if(prices[i] >= prices[i-1]) {
                sell = prices[i];
            } else {
                overallProfit += sell - buy;               
                buy = sell = prices[i];
            }
        }
        overallProfit += sell - buy;            // to update last transaction        

        System.out.println(overallProfit);
        
    }

}


