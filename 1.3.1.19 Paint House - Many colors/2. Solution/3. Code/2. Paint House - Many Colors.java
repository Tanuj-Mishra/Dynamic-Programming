// O(n*n), O(n*n)

import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int numHouses = scn.nextInt();
        int numColors = scn.nextInt();

        int[][] colors = new int[numColors][numHouses];
        for(int col = 0; col < colors[0].length; col++) {
            for(int row = 0; row < colors.length; row++) {
                colors[row][col] = scn.nextInt();
            }
        }


        paintingCost(colors);
        

    }

    public static void paintingCost(int[][] colors) {

        // creating cost[][]
        int[][] cost = new int[colors.length][colors[0].length];
        
        // fill first col
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        // filling first column 
        for(int i = 0; i < colors.length; i++) {
            cost[i][0] = colors[i][0];

            // finding min1 and min2
            if(cost[i][0] <= min1) {
                min2 = min1;
                min1 = cost[i][0];
            } else if(cost[i][0] <= min2) {
                min2 = cost[i][0];
            }
        }
         

        // fill cost[][] -> col wise, from col-1
        for(int col = 1; col < colors[0].length; col++) {
            
            int tempMin1 = Integer.MAX_VALUE;
            int tempMin2 = Integer.MAX_VALUE;
            
            for(int row = 0; row < colors.length; row++) {
            
                if(cost[row][col-1] != min1) {
                    cost[row][col] = min1 + colors[row][col];
                } else {
                    cost[row][col] = min2 + colors[row][col];
                }

                // finding min1 and min2    
                if(cost[row][col] <= tempMin1) {
                    tempMin2 = tempMin1;
                    tempMin1 = cost[row][col];
                } else if(cost[row][col] <= tempMin2) {
                    tempMin2 = cost[row][col];
                }

            }

            // updating min1 and min2
            min1 = tempMin1;
            min2 = tempMin2;
        }

        // ans
        System.out.println(min1);        

    
    }



}
