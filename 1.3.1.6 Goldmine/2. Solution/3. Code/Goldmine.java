import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int row = scn.nextInt();
        int col = scn.nextInt();
        int[][] goldmine = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                goldmine[i][j] = scn.nextInt();
            }
        }

        minCostgoldmineTraversal(goldmine);

        scn.close();
    }

    public static void minCostgoldmineTraversal(int[][] goldmine) {
        int row = goldmine.length;
        int col = goldmine[0].length;

        int[][] solutionBank = new int[row][col];

        for (int j = col - 1; j >= 0; j--) {
            for (int i = row - 1; i >= 0; i--) {        // we can also traverse from i = 0 to i < row;

                if (j == col - 1) {
                    solutionBank[i][j] = goldmine[i][j];
                } else if (i == 0) {
                    solutionBank[i][j] = Math.max(solutionBank[i][j + 1], solutionBank[i + 1][j + 1]) + goldmine[i][j];
                } else if (i == row - 1) {
                    solutionBank[i][j] = Math.max(solutionBank[i][j + 1], solutionBank[i - 1][j + 1]) + goldmine[i][j];
                } else {
                    solutionBank[i][j] = Math.max(solutionBank[i - 1][j + 1],
                            Math.max(solutionBank[i][j + 1], solutionBank[i + 1][j + 1])) + goldmine[i][j];
                }

            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            if (solutionBank[i][0] > max) {
                max = solutionBank[i][0];
            }
        }

        System.out.println(max);
    }
}
