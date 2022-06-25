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

    public static int knapsack(int[] item, int[] weight, int capacity) {

        // matrix to which elements must be used
        int n = item.length;
        int[][] mtrx = new int[n + 1][capacity + 1];

        // filling this matrix
        // basically, row signifies the elements considered, i.e for row = 4 ->
        // {0,1,2,3,4} are now taken under consideration
        for (int row = 1; row <= n; row++) {
            for (int presentCapacity = 1; presentCapacity <= capacity; presentCapacity++) {

                int wt = weight[row - 1]; // weight of present element
                int val = item[row - 1]; // number of elements
                int prvs = mtrx[row - 1][presentCapacity]; // preivous item

                if (wt > presentCapacity) {
                    // in this case element can't be included
                    mtrx[row][presentCapacity] = prvs;
                } else {
                    int excluding = prvs;
                    int including = val + mtrx[row - 1][presentCapacity - wt];

                    mtrx[row][presentCapacity] = Math.max(excluding, including);
                }
            }
        }

        return mtrx[n][capacity];

    }

    public static void main(String[] Args) {

        int n = scn.nextInt();
        int[] item = arrayInput(n); // item is # of elements
        int[] weight = arrayInput(n);
        int capacity = scn.nextInt();

        // finding 01 Knapsack
        int knap = knapsack(item, weight, capacity);
        System.out.println(knap);
    }

}

// item-weight = x-y
// y weight wale, x elements h