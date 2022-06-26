import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int length = scn.nextInt();

        int[] zeros = new int[length + 1];
        int[] ones = new int[length + 1];

        zeros[1] = 1;
        ones[1] = 1;
        for (int i = 2; i <= length; i++) {
            zeros[i] = ones[i - 1];
            ones[i] = zeros[i - 1] + ones[i - 1];
        }

        System.out.println(zeros[length] + ones[length]);
    }

}