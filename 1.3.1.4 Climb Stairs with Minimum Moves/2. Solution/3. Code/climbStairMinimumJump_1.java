import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] jumps = new int[n];
        for (int i = 0; i < n; i++) {
            jumps[i] = scn.nextInt();
        }

        Integer[] solutionBank = new Integer[n + 1];
        solutionBank[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (jumps[i] > 0) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= jumps[i] && i + j < solutionBank.length; j++) {
                    if (solutionBank[i + j] != null) {
                        min = Math.min(min, solutionBank[i + j]);
                    }
                }
                if (min != Integer.MAX_VALUE)
                    solutionBank[i] = min + 1;
            }
        }

        System.out.println(solutionBank[0]);

    }

}