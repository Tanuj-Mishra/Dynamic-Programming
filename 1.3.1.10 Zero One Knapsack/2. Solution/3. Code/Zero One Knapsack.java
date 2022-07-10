import java.io.*;
import java.util.*;

class Main {

    static Scanner scn = new Scanner(System.in);

    public static int[] arrayInput(int n) {
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        return arr;
    }

    public static int knapsack(int[] balls, int[] runs, int target) {

        int[][] dp = new int[runs.length + 1][target + 1]; // dp-row = player, dp-col = balls

        for (int player = 0; player < dp.length; player++) {
            for (int ballsAvailable = 0; ballsAvailable < dp[0].length; ballsAvailable++) {

                if (player == 0 || ballsAvailable == 0) {
                    dp[player][ballsAvailable] = 0;
                } else {
                    int minBallRequired = balls[player - 1];
                    if (ballsAvailable < minBallRequired) { // he can't play
                        dp[player][ballsAvailable] = dp[player - 1][ballsAvailable];
                    } else { // he "can" play
                        int runsIfNotPlayed = dp[player - 1][ballsAvailable];
                        int runsIfPlayed = runs[player-1] + dp[player - 1][ballsAvailable - minBallRequired];
                        dp[player][ballsAvailable] = Math.max(runsIfNotPlayed, runsIfPlayed);
                    }
                }

            }
        }


        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] Args) {

        int n = scn.nextInt();
        int[] runs = arrayInput(n);
        int[] balls = arrayInput(n); // balls is # of elements
        int target = scn.nextInt();

        // finding 01 Knapsack
        int knap = knapsack(balls, runs, target);
        System.out.println(knap);
    }

}

// balls-runs = x-y
// y runs wale, x elements h