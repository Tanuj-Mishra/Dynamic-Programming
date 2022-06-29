import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int row = scn.nextInt();
        int col = 3;

        int[][] colors = new int[row][col];


        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                colors[i][j] = scn.nextInt();
            }
        }

        paintHouse(colors);


    }

    public static void paintHouse(int[][] colors) {

        int row = colors[0].length;
        int col = colors.length;
        int[][] paintingCost = new int[row][col];

        for(int i = 0; i < row; i++) {
            paintingCost[i][0] = colors[0][i];
        }


        for(int i = 1; i < col; i++) {
            for(int j = 0; j < row; j++) {
                int option1 = paintingCost[(j+1)%3][i-1];    
                int option2 = paintingCost[(j+2)%3][i-1];    
                paintingCost[j][i] = colors[i][j] + Math.min(option1, option2);
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < row; i++) {
            if(paintingCost[i][col-1] < min)
                min = paintingCost[i][col-1];
        }

        System.out.println(min);

    }
}