import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int size = scn.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = scn.nextInt();
        }

        int target = scn.nextInt();

        targetSumSubset(arr, target);
    }

    public static void targetSumSubset(int[] arr, int target) {
        int row = arr.length + 1;
        int col = target + 1;

        boolean[][] dp = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    dp[i][j] = true;
                } else {
                    int val = arr[i - 1];
                    if (j < val) {
                        dp[i][j] = dp[i - 1][j];
                    } else if (j == val) {
                        dp[i][j] = true;
                    } else {
                        if (dp[i - 1][j] || dp[i - 1][j - val]) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = false;
                        }
                    }
                }
            }
        }

        System.out.println(dp[row - 1][col - 1]);
    }

}