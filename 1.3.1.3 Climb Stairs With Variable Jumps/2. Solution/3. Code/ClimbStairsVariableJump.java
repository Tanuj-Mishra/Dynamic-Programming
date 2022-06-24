import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] jumps = new int[n];
        for (int i = 0; i < n; i++) {
            jumps[i] = scn.nextInt();
        }

        System.out.println(climbStairVJ(n, jumps));

    }

    // returns total number of path from 0 to nth floor with varisolutionBankle
    // jumps
    public static int climbStairVJ(int n, int[] jumps) {

        int[] solutionBank = new int[n + 1];
        solutionBank[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= jumps[i] && i + j < solutionBank.length; j++) {
                solutionBank[i] += solutionBank[i + j];
            }
        }

        return solutionBank[0];
    }
}