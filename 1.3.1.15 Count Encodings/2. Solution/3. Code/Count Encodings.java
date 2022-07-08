import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        int len = str.length();

        int[] dp = new int[len+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= len; i++) {
            int c1 = str.charAt(i-2) - '0';
            int c2 = str.charAt(i-1) - '0';

            if(c1 == 0 && c2 == 0) {
                dp[i] = 0;
            } else if (c1 == 0) {
                dp[i] = dp[i-1];
            } else if (c2 == 0) {
                if(c1 > 2) {
                    dp[i] = 0;
                } else {
                    dp[i] = dp[i-1];
                }
            } else {
                if(c1 > 2) {
                    dp[i] = dp[i-1];
                } else {
                    dp[i] = dp[i-1] + dp[i-2];
                }
            }

        }

        System.out.println(dp[len]);
    }
}



