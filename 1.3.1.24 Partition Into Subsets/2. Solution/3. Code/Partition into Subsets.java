import java.io.*;
import java.util.*;

class Main {
        
    public static long partitionKSubset(int n, int k) {

        long[][] dp = new long[n+1][k+1];

        for(int peo = 1; peo <= n; peo++) {
            for(int tea = 1; tea <= k; tea++) {
                if(tea == 1) {
                    dp[peo][tea] = 1;                    
                } else if(tea > peo) {
                    dp[peo][tea] = 0;                    
                } else if(tea == peo) {
                    dp[peo][tea] = 1;                    
                } else {
                    dp[peo][tea] = tea*dp[peo-1][tea] + dp[peo-1][tea-1];                    
                }
            }
        }

        return dp[n][k];
    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        long res = partitionKSubset(n, k);
        System.out.println(res);
    }
}