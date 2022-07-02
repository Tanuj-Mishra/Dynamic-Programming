import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        int fences = scn.nextInt();
        int colors = scn.nextInt();

        if(fences == 1) {
            System.out.println(colors);
            return;
        }

        int lastTwoSame = colors;
        int lastTwoDifferent = colors*(colors-1);
        int totalOptions = lastTwoDifferent + lastTwoSame;
        for(int i = 3; i <= fences; i++) {
            lastTwoSame = lastTwoDifferent;
            lastTwoDifferent = totalOptions * (colors-1);
            totalOptions = lastTwoDifferent + lastTwoSame;
        }

        System.out.println(totalOptions);

    }
}