import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        int ans1 = climbStairsMemorization(num, new int[num + 1]);
        int ans2 = climbStairsTabulation(num);
        System.out.println(ans2);

    }

    public static int climbStairsMemorization(int num, int[] solutionBank) {
        // Base Case
        if (num == 0) {
            return 1;
        } else if (num < 0) {
            return 0;
        }

        // Checking if answer is already calculated or not
        if (solutionBank[num] != 0) {
            return solutionBank[num];
        }

        // Recursive Work
        int smallAns1 = climbStairsMemorization(num - 1, solutionBank);
        int smallAns2 = climbStairsMemorization(num - 2, solutionBank);
        int smallAns3 = climbStairsMemorization(num - 3, solutionBank);

        int ans = smallAns1 + smallAns2 + smallAns3;
        solutionBank[num] = ans;

        return ans;
    }

    public static int climbStairsTabulation(int num) {

        int[] solutionBank = new int[num + 1];
        solutionBank[0] = 1;
        for (int i = 1; i <= num; i++) {
            if (i == 1) {
                solutionBank[i] = solutionBank[i - 1];
            } else if (i == 2) {
                solutionBank[i] = solutionBank[i - 1] + solutionBank[i - 2];
            } else {
                solutionBank[i] = solutionBank[i - 1] + solutionBank[i - 2] + solutionBank[i - 3];
            }
        }

        return solutionBank[num];
    }
}