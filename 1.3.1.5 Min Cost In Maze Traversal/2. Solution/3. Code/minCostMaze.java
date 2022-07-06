import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int row = scn.nextInt();
        int col = scn.nextInt();
        int[][] maze = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                maze[i][j] = scn.nextInt();
            }
        }

        minCostMazeTraversal(maze);

        scn.close();
    }

    public static void minCostMazeTraversal(int[][] maze) {
        int row = maze.length;
        int col = maze[0].length;

        int[][] solutionBank = new int[row][col];

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {

                if (i == row - 1 && j == col - 1) {
                    solutionBank[i][j] = maze[i][j];
                } else if (i == row - 1) {
                    solutionBank[i][j] = solutionBank[i][j + 1] + maze[i][j];
                } else if (j == col - 1) {
                    solutionBank[i][j] = solutionBank[i + 1][j] + maze[i][j];
                } else {
                    solutionBank[i][j] = Math.min(solutionBank[i][j + 1], solutionBank[i + 1][j]) + maze[i][j];
                }

            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // maze[i][j] = scn.nextInt();
                System.out.print(solutionBank[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println(solutionBank[0][0]);
    }
}
