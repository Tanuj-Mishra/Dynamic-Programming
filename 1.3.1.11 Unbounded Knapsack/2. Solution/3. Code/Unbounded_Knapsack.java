import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        int[] values = new int[num];
        int[] weights = new int[num];

        for (int i = 0; i < num; i++) {
            values[i] = scn.nextInt();
        }

        for (int i = 0; i < num; i++) {
            weights[i] = scn.nextInt();
        }

        int capacity = scn.nextInt();

        unboundedKnapsack(values, weights, capacity);
    }

    public static void unboundedKnapsack(int[] values, int[] weights, int capacity) {
        int[] dp = new int[capacity + 1];

        dp[0] = 0;
        for (int presentCapacity = 0; presentCapacity < dp.length; presentCapacity++) {
            int max = 0;
            for (int item = 0; item < weights.length; item++) {
                int itemWeight = weights[item];

                if (presentCapacity >= itemWeight) {
                    int restBagValue = dp[presentCapacity - itemWeight];
                    int presentBagValue = values[item] + restBagValue;

                    if (presentBagValue > max) {
                        max = presentBagValue;
                    }
                }
            }

            dp[presentCapacity] = max;
        }

        System.out.println(dp[capacity]);
    }

}