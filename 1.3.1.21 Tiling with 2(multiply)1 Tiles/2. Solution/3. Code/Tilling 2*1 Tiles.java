// O(n), O(n)

import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int length = scn.nextInt();

        int[] dp = new int[length+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[length]);
    }
}