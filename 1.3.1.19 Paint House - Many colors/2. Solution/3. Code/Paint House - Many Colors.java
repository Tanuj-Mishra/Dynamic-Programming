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
        // fill cost[][] -> col wise
            // fill first col, from colors
            // for rest 
                // find input from previous
                // fill using min and colors[][]
        // find ans - min of last col 
        
        // creating cost[][]
        int[][] cost = new int[colors.length][colors[0].length];


        
        // fill first col
        for(int i = 0; i < colors.length; i++) {
            cost[i][0] = colors[i][0];
        }

        // fill cost[][] -> col wise, from col-1
        for(int col = 1; col < colors[0].length; col++) {
            for(int row = 0; row < colors.length; row++) {
            
                // find input from previous
                int min = Integer.MAX_VALUE;
                for(int i = 0; i < colors.length; i++) {
                    if(i != row) {
                        if(cost[i][col-1] < min) {
                            min = cost[i][col-1];
                        }
                    }
                }

                // filling cost[][]
                cost[row][col] = colors[row][col] + min;
                // System.out.println(row + "\t" + col + "\t" + cost[row][col]);
            }
        }

        // finding ans - min of last col 
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < colors.length; i++) {
            if(cost[i][colors[0].length-1] < ans) {
                ans = cost[i][colors[0].length-1];
            }
        }

        System.out.println(ans);        

    
    }



}


